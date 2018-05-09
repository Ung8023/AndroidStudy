package com.ung8023.androidbase.view;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.ung8023.androidbase.R;
import com.ung8023.androidbase.utils.TransferUtils;

public class TextViewActivity extends AppCompatActivity {


    String url = "aAAAAAAAAAAAAAAA 343-1232342-2424 <a href=\"http://www.baidu.com asdasdasdasd\">这是一个字符串</a>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        initView();
    }

    private void initView() {
        initMovementTextView();
        initAutoLinkTextView();
    }

    private Spanned getHtmlStr(String htmlStr) {
        return Html.fromHtml(htmlStr);
    }

    private void initMovementTextView() {
        TextView movementTv = findViewById(R.id.tv_movement_link);

        CharSequence text = getResources().getText(R.string.sapmle_url);
        movementTv.setText(text);
        movementTv.setAutoLinkMask(Linkify.ALL);
        // 通过设置MovementMethod
        movementTv.setMovementMethod(LinkMovementMethod.getInstance());
    }


    private void initAutoLinkTextView() {
        TextView textView = findViewById(R.id.tv_auto_link);
        textView.setText(url);

        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable spannable = (Spannable) text;

            URLSpan[] urls = spannable.getSpans(0, end, URLSpan.class);
            SpannableStringBuilder style = new SpannableStringBuilder(text);
            style.clearSpans();

            for (URLSpan urlSpan: urls) {
                MyUrlSpan myUrlSpan = new MyUrlSpan(urlSpan.getURL());
                style.setSpan(myUrlSpan, spannable.getSpanStart(urlSpan),
                        spannable.getSpanEnd(urlSpan),
                        Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            }
            textView.setText(style);
        }
    }

    private class MyUrlSpan extends ClickableSpan {
        private String url;

        public MyUrlSpan(String url) {
            this.url = url;
        }

        @Override
        public void onClick(View widget) {
            TransferUtils.toBrowser(widget.getContext(), url);
        }
    }


}
