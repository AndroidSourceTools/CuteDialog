package io.github.cutelibs.cutedialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import io.github.cutelibs.cutedialog.databinding.CuteDialogMainLayoutBinding;

public class CuteDialog {

    // Default Value
    private static final int WHOLE_BACKGROUND_COLOR_DEFAULT = Color.parseColor("#FFFFFF");
    private static final int CLOSE_ICON_COLOR_DEFAULT = Color.parseColor("#A0A0A0");
    private static final int TITLE_TEXT_COLOR_DEFAULT = Color.parseColor("#398AB9");
    private static final int DESC_TEXT_COLOR_DEFAULT = Color.parseColor("#222222");
    private static final int BUTTON_BACKGROUND_COLOR_DEFAULT = Color.parseColor("#398AB9");
    private static final int POSITIVE_BUTTON_TEXT_COLOR_DEFAULT = Color.parseColor("#FFFFFF");
    private static final int NEGATIVE_BUTTON_TEXT_COLOR_DEFAULT = Color.parseColor("#222222");
    private static final int CLOSE_ICON_SIZE_DEFAULT = 30;
    private static final int WHOLE_CORNER_RADIUS_DEFAULT = 10;
    private static final int WHOLE_PADDING_DEFAULT = 10;
    private static final int TITLE_TEXT_SIZE_DEFAULT = 20;
    private static final int DESC_TEXT_SIZE_DEFAULT = 14;
    private static final int BUTTON_CORNER_RADIUS_DEFAULT = 10;
    private static final int BUTTON_TEXT_SIZE_DEFAULT = 16;
    private static final String POSITIVE_BUTTON_TEXT_DEFAULT = "Yes";
    private static final String NEGATIVE_BUTTON_TEXT_DEFAULT = "No";
    private static final String TITLE_TEXT_DEFAULT = "";
    private static final String DESC_TEXT_DEFAULT = "";

    /**
     *
     */
    public static class withIcon extends Dialog {
        Context context;
        CuteDialogMainLayoutBinding binding;

        public withIcon(Context context) {
            super(context);
            this.context = context;
            binding = CuteDialogMainLayoutBinding.inflate(LayoutInflater.from(context));
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            setContentView(binding.getRoot());
            inits();

        }

        private void inits() {
            // whole card design
            getWindow().setGravity(Gravity.CENTER);
            setCancelable(true);
            binding.wholeCard.setCardBackgroundColor(WHOLE_BACKGROUND_COLOR_DEFAULT);
            binding.wholeCard.setRadius(WHOLE_CORNER_RADIUS_DEFAULT * 4);

            // padding
            binding.padding1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WHOLE_PADDING_DEFAULT * 4));
            binding.padding2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WHOLE_PADDING_DEFAULT * 2));
            binding.padding3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WHOLE_PADDING_DEFAULT * 4));
            binding.padding4.setLayoutParams(new LinearLayout.LayoutParams(WHOLE_PADDING_DEFAULT * 4, ViewGroup.LayoutParams.WRAP_CONTENT));
            binding.padding5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WHOLE_PADDING_DEFAULT * 4));
            binding.padding6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WHOLE_PADDING_DEFAULT * 4));


            // close icon
            binding.closeIcon.setImageResource(R.drawable.cute_dialog_close_icon);
            binding.closeIcon.setColorFilter(CLOSE_ICON_COLOR_DEFAULT);
            binding.closeIcon.getLayoutParams().height = CLOSE_ICON_SIZE_DEFAULT * 2;
            binding.closeIcon.getLayoutParams().width = CLOSE_ICON_SIZE_DEFAULT * 2;

            // header visibility
            binding.mainIcon.setVisibility(View.VISIBLE);
            binding.mainImage.setVisibility(View.GONE);
            binding.mainAnimation.setVisibility(View.GONE);

            // title Text
            binding.titleText.setText(TITLE_TEXT_DEFAULT);
            binding.titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, TITLE_TEXT_SIZE_DEFAULT);
            binding.titleText.setTextColor(TITLE_TEXT_COLOR_DEFAULT);
            binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.BOLD);

            // description Text
            binding.descText.setText(DESC_TEXT_DEFAULT);
            binding.descText.setTextSize(TypedValue.COMPLEX_UNIT_SP, DESC_TEXT_SIZE_DEFAULT);
            binding.descText.setTextColor(DESC_TEXT_COLOR_DEFAULT);
            binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.NORMAL);

            // positive button style
            binding.positiveButton.setRadius(BUTTON_CORNER_RADIUS_DEFAULT * 4);
            binding.positiveButton.setCardBackgroundColor(BUTTON_BACKGROUND_COLOR_DEFAULT);
            binding.positiveButton.setStrokeColor(BUTTON_BACKGROUND_COLOR_DEFAULT);
            binding.positiveButton.setStrokeWidth(1);

            // negative button style
            binding.negativeButton.setRadius(BUTTON_CORNER_RADIUS_DEFAULT * 4);
            binding.negativeButton.setCardBackgroundColor(WHOLE_BACKGROUND_COLOR_DEFAULT);
            binding.negativeButton.setStrokeColor(BUTTON_BACKGROUND_COLOR_DEFAULT);
            binding.negativeButton.setStrokeWidth(1);

            // button text
            binding.positiveText.setTextSize(TypedValue.COMPLEX_UNIT_SP, BUTTON_TEXT_SIZE_DEFAULT);
            binding.negativeText.setTextSize(TypedValue.COMPLEX_UNIT_SP, BUTTON_TEXT_SIZE_DEFAULT);
            binding.positiveText.setText(POSITIVE_BUTTON_TEXT_DEFAULT);
            binding.positiveText.setTextColor(POSITIVE_BUTTON_TEXT_COLOR_DEFAULT);
            binding.negativeText.setText(NEGATIVE_BUTTON_TEXT_DEFAULT);
            binding.negativeText.setTextColor(NEGATIVE_BUTTON_TEXT_COLOR_DEFAULT);

            // button click
            binding.positiveButton.setOnClickListener(v -> dismiss());
            binding.negativeButton.setOnClickListener(v -> dismiss());
            binding.closeIcon.setOnClickListener(v -> dismiss());

        }

        public withIcon isCancelable(boolean cancelable) {
            setCancelable(cancelable);
            return this;
        }


        /**
         * Sets heading.
         *
         * @param titleText    the title text
         * @param textSizeInSP the text size in sp
         * @param textColor    the text color
         * @param textStyle    the text style
         * @return the heading
         */
        public withIcon setHeading(String titleText, int textSizeInSP, int textColor, int textStyle) {
            binding.titleText.setText(titleText);

            if (textSizeInSP != 0) {
                binding.titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeInSP);
            }

            // title Text color
            if (textColor != 0) {
                try {
                    binding.titleText.setTextColor(ContextCompat.getColor(context, textColor));
                } catch (Resources.NotFoundException e) {
                    binding.titleText.setTextColor(textColor);
                }
            }

            // title text style
            if (textStyle == 1) {
                binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.NORMAL);
            } else if (textStyle == 2) {
                binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.BOLD);
            } else if (textStyle == 3) {
                binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.ITALIC);
            } else if (textStyle == 4) {
                binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.BOLD_ITALIC);
            } else {
                binding.titleText.setTypeface(binding.titleText.getTypeface(), Typeface.NORMAL);
            }

            return this;
        }

        public withIcon setDescription(String descText, int textSizeInSP, int textColor, int textStyle) {

            binding.descText.setText(descText);

            if (textSizeInSP != 0) {
                binding.descText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeInSP);
            }

            // desc Text color
            if (textColor != 0) {
                try {
                    binding.descText.setTextColor(ContextCompat.getColor(context, textColor));
                } catch (Resources.NotFoundException e) {
                    binding.descText.setTextColor(textColor);
                }
            }

            // desc text style
            if (textStyle == 1) {
                binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.NORMAL);
            } else if (textStyle == 2) {
                binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.BOLD);
            } else if (textStyle == 3) {
                binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.ITALIC);
            } else if (textStyle == 4) {
                binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.BOLD_ITALIC);
            } else {
                binding.descText.setTypeface(binding.descText.getTypeface(), Typeface.NORMAL);
            }

            return this;
        }


    }


}
