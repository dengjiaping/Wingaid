package com.yd.org.sellpopularizesystem.activity;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.fragment.ExamineFragment;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.javaBean.OptionBean;
import com.yd.org.sellpopularizesystem.javaBean.PagerDetailsBean;
import com.yd.org.sellpopularizesystem.javaBean.QuestionBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExaminationActivity extends BaseActivity {
    private List<QuestionBean> questions = new ArrayList<>();

    private LinearLayout test_layout;
    private PagerDetailsBean pagerDetail;
    // 选项列表
    private List<OptionBean> the_answer_list;
    // 问题所在的View
    private View que_view;
    private LayoutInflater mInflater;
    private JSONArray jsonArray;
    private String paper_id;
    private Button btnSkip, button;


    @Override
    protected int setContentView() {
        return R.layout.activity_examination;
    }

    @Override
    public void initView() {

        setTitle(R.string.check);
        hideRightImagview();
        paper_id = getIntent().getExtras().getString("paper_id");
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 提交按钮
        button = getViewById(R.id.btnSubmit);
        initData(paper_id);
        button.setOnClickListener(new ExaminationActivity.submitOnClickListener());


        btnSkip = getViewById(R.id.btnSkip);

    }

    @Override
    public void setListener() {
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData(String paperId) {
        EasyHttp.get(Contants.PAPER_DETAILS)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("paper_id", paperId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {

                        closeDialog();
                        if (json != null) {
                            jsonParse(json);
                        }

                    }
                });


    }

    private void jsonParse(String json) {

        try {
            Gson gson = new Gson();
            pagerDetail = gson.fromJson(json, PagerDetailsBean.class);
            if (pagerDetail.getCode().equals("1")) {
                questions = pagerDetail.getResult();
                addViews(questions);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void addViews(List<QuestionBean> questions) {

        try {

            test_layout = (LinearLayout) findViewById(R.id.examinaltionLinearLayout);

            for (int i = 0; i < questions.size(); i++) {
                que_view = mInflater.inflate(R.layout.radiobuttonittem, null);
                TextView questionTitle = (TextView) que_view.findViewById(R.id.examinaltionTextView);
                LinearLayout option_layout = (LinearLayout) que_view.findViewById(R.id.childLinearLayout);
                //多选和单选
                if (questions.get(i).getType() == 3) {
                    questionTitle.setText((i + 1) + "." + questions.get(i).getCheck_title() + getString(R.string.mutilatequestion));
                } else if (questions.get(i).getType() == 1) {
                    questionTitle.setText((i + 1) + "." + questions.get(i).getCheck_title() + getString(R.string.yesornoquestion));
                } else if (questions.get(i).getType() == 2) {
                    questionTitle.setText((i + 1) + "." + questions.get(i).getCheck_title() + getString(R.string.singlequestion));
                }
                the_answer_list = questions.get(i).getOptions();
                for (int j = 0; j < the_answer_list.size(); j++) {
                    the_answer_list.get(j).setStatus(0);
                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setTag(i * 10 + j + "");
                    radioButton.setPadding(5, 10, 0, 10);
                    radioButton.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.examination_checkradio));
                    radioButton.setText(the_answer_list.get(j).getOption_name());
                    option_layout.addView(radioButton);
                    radioButton.setOnClickListener(new answerItemOnClickListener(i, j, the_answer_list, option_layout, radioButton));
                }
                test_layout.addView(que_view);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    class answerItemOnClickListener implements View.OnClickListener {
        private int i;
        private int j;
        private LinearLayout linearLayout;
        private RadioButton radioButton;
        private List<OptionBean> options;

        public answerItemOnClickListener(int i, int j, List<OptionBean> options, LinearLayout linearLayout, RadioButton radioButton) {
            this.i = i;
            this.j = j;
            this.options = options;
            this.linearLayout = linearLayout;
            this.radioButton = radioButton;

        }

        // 实现点击选项后改变选中状态以及对应图片
        @Override
        public void onClick(View arg0) {
            // 判断当前问题是单选还是多选
            if (questions.get(i).getType() == 3) {
                // 多选未选中
                if (options.get(j).getStatus() == 0) {
                    radioButton.setButtonDrawable(ContextCompat.getDrawable(ExaminationActivity.this, R.mipmap.selectedx));
                    // 如果未被选中
                    radioButton.setChecked(true);
                    options.get(j).setStatus(1);
                    //多选选中状态
                } else if (options.get(j).getStatus() == 1) {
                    radioButton.setButtonDrawable(ContextCompat.getDrawable(ExaminationActivity.this, R.mipmap.unselected));
                    radioButton.setChecked(false);
                    options.get(j).setStatus(0);
                }

                int falseCount = 0;
                for (int k = 0; k < questions.get(i).getOptions().size(); k++) {
                    if (options.get(k).getStatus() == 1) {
                        setStatuToTrue(i, questions);
                    } else {
                        falseCount++;
                    }
                }
                if (falseCount == questions.get(i).getOptions().size()) {
                    setStatuToFalse(i, questions);
                }
            } else {
                // 单选未选中
                if (options.get(j).getStatus() == 0) {
                    radioButton.setChecked(true);
                    radioButton.setButtonDrawable(ContextCompat.getDrawable(ExaminationActivity.this, R.mipmap.selectedx));
                    options.get(j).setStatus(1);
                    questions.get(i).setStatus(1);
                    for (int k = 0; k < linearLayout.getChildCount(); k++) {
                        View view = linearLayout.getChildAt(k);
                        if (k != j) {
                            if (view instanceof RadioButton) {
                                ((RadioButton) view).setChecked(false);
                                ((RadioButton) view).setButtonDrawable(ContextCompat.getDrawable(ExaminationActivity.this, R.mipmap.unselected));
                                options.get(k).setStatus(0);
                            }
                        }
                    }
                }
            }
        }
    }

    private void setStatuToTrue(int i, List<QuestionBean> questions) {
        questions.get(i).setStatus(1);
    }

    private void setStatuToFalse(int i, List<QuestionBean> questions) {
        questions.get(i).setStatus(0);
    }

    class submitOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // 判断是否答完题
            boolean isState = true;
            // 最终要的json数组
            jsonArray = new JSONArray();
            // 点击提交的时候，先判断状态，如果有未答完的就提示，如果没有再把每条答案提交（包含问卷ID 问题ID 及答案ID）
            // 注：不用管是否是一个问题的答案，就以答案的个数为准来提交上述格式的数据
            for (int i = 0; i < questions.size(); i++) {
                // 判断是否有题没答完
                if (questions.get(i).getStatus() == 0) {
                    Toast.makeText(getApplicationContext(), getString(R.string.nin) + (i + 1) + getString(R.string.examination), Toast.LENGTH_LONG).show();
                    jsonArray = null;
                    isState = false;
                    break;
                }

            }
            if (isState) {

                String str = null;
                String s = null;
                for (int i = 0; i < questions.size(); i++) {
                    JSONObject json = new JSONObject();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < questions.get(i).getOptions().size(); j++) {
                        if (questions.get(i).getOptions().get(j).getStatus() == 1) {
                            if (questions.get(i).getType() == 3) {
                                sb.append(questions.get(i).getOptions().get(j).getOption_id() + ",");
                                str = sb.toString().substring(0, sb.length() - 1);
                            } else if (questions.get(i).getType() == 1 || questions.get(i).getType() == 2) {
                                s = questions.get(i).getOptions().get(j).getOption_id() + "";
                            }
                        }
                    }
                    try {
                        json.put("check_id", questions.get(i).getCheck_id());
                        if (questions.get(i).getType() == 3) {
                            json.put("user_answer", str);
                        } else {
                            json.put("user_answer", s);
                        }
                        jsonArray.put(json);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                Log.e("提交数据**", "jsonArray:" + jsonArray.toString());
                commit();
            }
        }
    }

    private void commit() {
        EasyHttp.post(Contants.SUBMIT_PAPER)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("paper_id", paper_id)
                .params("answer", jsonArray.toString())
                .params("add_ip", "")
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        ToasShow.showToastCenter(ExaminationActivity.this, e.getMessage());
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);

                        closeDialog();

                        try {

                            Gson gson = new Gson();
                            ErrorBean errorBean = gson.fromJson(json, ErrorBean.class);
                            if (errorBean.getCode().equals("1")) {
                                ExamineFragment.examineFragment.handler.sendEmptyMessage(1);
                                ToasShow.showToastBottom(ExaminationActivity.this, errorBean.getMsg());
                                finish();
                            } else {
                                ToasShow.showToastBottom(ExaminationActivity.this, errorBean.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

}
