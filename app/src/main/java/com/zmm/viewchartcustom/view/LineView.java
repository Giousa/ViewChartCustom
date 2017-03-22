package com.zmm.viewchartcustom.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Jesse write this view for draw line,use it easy.
 */
public class LineView extends View {
	private final static String X_KEY = "Xpos";
	private final static String Y_KEY = "Ypos";

	private List<Map<String, Integer>> mListPoint = new ArrayList<>();
	private List<Map<String, Integer>> mListPoint2 = new ArrayList<>();

	Paint mPaint = new Paint();
	Paint mPaint2 = new Paint();

	public LineView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public LineView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LineView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(3);
		mPaint.setAntiAlias(true);

		mPaint2.setColor(Color.GREEN);
		mPaint2.setStrokeWidth(3);
		mPaint2.setAntiAlias(true);

		for (int index = 0; index < mListPoint.size(); index++) {
			if (index > 0) {
				canvas.drawLine(mListPoint.get(index - 1).get(X_KEY),
						mListPoint.get(index - 1).get(Y_KEY),
						mListPoint.get(index).get(X_KEY), mListPoint.get(index)
								.get(Y_KEY), mPaint);
				canvas.setDrawFilter(new PaintFlagsDrawFilter(0,
						Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
			}
		}

		for (int index = 0; index < mListPoint2.size(); index++) {
			if (index > 0) {
				canvas.drawLine(mListPoint2.get(index - 1).get(X_KEY),
						mListPoint2.get(index - 1).get(Y_KEY),
						mListPoint2.get(index).get(X_KEY), mListPoint2.get(index)
								.get(Y_KEY), mPaint2);
				canvas.setDrawFilter(new PaintFlagsDrawFilter(0,
						Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
			}
		}

	}

	public void setLinePoint(int curX, int curY) {
		Map<String, Integer> temp = new HashMap<>();
		temp.put(X_KEY, curX+110);
		temp.put(Y_KEY, curY+70);
		mListPoint.add(temp);
		invalidate();
	}

	public void setLinePoint2(int curX, int curY) {
		Map<String, Integer> temp = new HashMap<>();
		temp.put(X_KEY, curX+110);
		temp.put(Y_KEY, curY+70);
		mListPoint2.add(temp);
		invalidate();
	}
}
