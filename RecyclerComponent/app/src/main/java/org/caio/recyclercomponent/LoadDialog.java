package org.caio.recyclercomponent;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoadDialog {

    private AlertDialog dialog;
    private LinearLayout.LayoutParams llParam;
    private int ySize = 100;
    private  int xSize = 80;
    private int textSize = 28;

    private int color = Color.CYAN;
    private boolean cancelable = true;
    private int textColor = Color.BLACK;
    private LinearLayout.LayoutParams WRAP_CONTENT = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    private boolean FORMAT_LAYOUT_VERTICAL = true;

    private Context context;

    public LoadDialog(Context context) { this.context = context; }

    public LoadDialog setColor(int color) {
        this.color = color;
        return this;
    }

    public LoadDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public LoadDialog setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public LoadDialog setTextSize(int size) {
        this.textSize = size;
        return this;
    }

    public LoadDialog setSize(int x, int y) {
        xSize = x;
        ySize = y;
        return this;
    }

    public LoadDialog setHorizontalLayout() {
        FORMAT_LAYOUT_VERTICAL = false;
        return this;
    }

    public void justLoad() {
        RelativeLayout layoutBackground = new RelativeLayout(context);
        layoutBackground.setGravity(Gravity.CENTER);

        layoutBackground.setLayoutParams(WRAP_CONTENT);

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        progressBar.setPadding(0, 0, 0, 0);
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        llParam = new LinearLayout.LayoutParams(xSize, ySize);
        progressBar.setLayoutParams(llParam);
        layoutBackground.addView(progressBar);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setView(layoutBackground);

        dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);
        }
    }

    public void startWithMessage(String textToShow) {
        LinearLayout ll = new LinearLayout(context);
        ProgressBar progressBar = new ProgressBar(context);

        if (FORMAT_LAYOUT_VERTICAL) {
            ll.setOrientation(LinearLayout.VERTICAL);
            progressBar.setPadding(0, 0, 0, 30);
        } else {
            ll.setOrientation(LinearLayout.HORIZONTAL);
            progressBar.setPadding(0, 0, 30, 0);
        }

        ll.setPadding(10, 30, 0, 30);
        ll.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams llParam = WRAP_CONTENT;
        llParam.gravity = Gravity.CENTER;
        ll.setLayoutParams(llParam);

        llParam = new LinearLayout.LayoutParams(xSize, ySize);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(llParam);
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        llParam = WRAP_CONTENT;
        llParam.gravity = Gravity.CENTER;
        TextView tvText = new TextView(context);
        tvText.setText(textToShow);
        tvText.setTextColor(textColor);
        tvText.setTextSize(textSize);
        tvText.setLayoutParams(llParam);

        ll.addView(progressBar);
        ll.addView(tvText);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setView(ll);

        dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();

        if (FORMAT_LAYOUT_VERTICAL)
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissIt();
            }
        }, 30000);

    }

    public void dismissIt() {
        if (dialog.isShowing())
            dialog.dismiss();
    }
}
