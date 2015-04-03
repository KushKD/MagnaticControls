package com.kailash.magnet.uicontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kush Kumar Dhawan on 03/04/15.
 * A Lot of help taken from the following Resources:
 * ->
 * ->
 * ->
 * Just editing it with some more features :
 * -> Dash Path
 * ->
 */
public class CircularJava_MC extends View {

    /**
     *
     * Variables and Constants
     * {@code Paint} instance used to draw the inactive circle.
     * {@Path} instance used to draw the circle path
     * {@code RectF} that represents the circle (or ellipse) of the seekbar.
     */

    private Paint OuterCirclePaint;
    private Paint OuterCircleFillPaint;
    private Path OuterCirclePath;
    private RectF mCircleRectF = new RectF();

    /**
     * Default Color and Properties
     * Holds the color value for {@code mCircleFillPaint} before the {@code Paint} instance is created.
     */
    private int mCircleFillColor = Color.BLUE;


    /** Change the angle to create different shapes of the circle default is 270 270
     *  Geometric (clockwise, relative to 3 o'clock)  default is 270
     *  Geometric (clockwise, relative to 3 o'clock)
     */
    private static final float DEFAULT_START_ANGLE = 120f;
    private static final float DEFAULT_END_ANGLE = 60f;


    /**
     * Start Angle and End Angle
     * Start angle of the CircularSeekBar.
     * Note: If mStartAngle and mEndAngle are set to the same angle, 0.1 is subtracted
     * from the mEndAngle to make the circle function properly .
     */
    private float mStartAngle;
    private float mEndAngle;

    /**
     * Width and the Height of the Circle
     */
    private float mCircleWidth;
    private float mCircleHeight;

    /**
     * Total Degrees
     *
     */
    private float mTotalCircleDegrees;





    public CircularJava_MC(Context context) {
        super(context);
        init(null,0);
    }

    public CircularJava_MC(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CircularJava_MC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

   /* public CircularJava_MC(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    } */

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircularJava_MC, defStyle, 0);
        /**
         * Initialize all the Properties that we want in the xml file i.e Go to the attributes.xml in the values.
         * Initialize the CircularSeekBar with the attributes from the XML style.
         * Uses the defaults defined at the top of this file when an attribute is not specified by the user.
         * @param attrArray TypedArray containing the attributes.
         */
         initAttributes(attrArray);
        attrArray.recycle();


        initPaints();
    }

    /**
     * Initialize all the Properties that we want in the xml file i.e Go to the attributes.xml in the values.
     * Initialize the CircularSeekBar with the attributes from the XML style.
     * Uses the defaults defined at the top of this file when an attribute is not specified by the user.
     * @param attrArray TypedArray containing the attributes.
     */
    private void initAttributes(TypedArray attrArray) {
     //TODO
    }


    /**
     * Calculates the total degrees between mStartAngle and mEndAngle, and sets mTotalCircleDegrees
     * to this value.
     */
    private void calculateTotalDegrees() {
        mTotalCircleDegrees = (360f - (mStartAngle - mEndAngle)) % 360f; // Length of the entire circle/arc
        if (mTotalCircleDegrees <= 0f) {
            mTotalCircleDegrees = 360f;
        }
    }


    /**
     * Actual Drawing begins here
     * Initializes the {@code Paint} objects with the appropriate styles.
     * Drawing of the circles , Rectangles and Paths goes here
     */
    private void initPaints(){

        //Optional Dash PAth Effect
        DashPathEffect dashPath = new DashPathEffect(new float[]{80,10}, (float)0.0 );
        OuterCirclePaint = new Paint();
        OuterCirclePaint.setAntiAlias(true);
        OuterCirclePaint.setDither(true);
        OuterCirclePaint.setColor(Color.GREEN);
        OuterCirclePaint.setStrokeWidth(12);
        OuterCirclePaint.setStyle(Paint.Style.STROKE);
        OuterCirclePaint.setStrokeJoin(Paint.Join.ROUND);
        OuterCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        OuterCirclePaint.setPathEffect(dashPath);

        OuterCircleFillPaint = new Paint();
        OuterCircleFillPaint.setAntiAlias(true);
        OuterCircleFillPaint.setDither(true);
        OuterCircleFillPaint.setColor(mCircleFillColor);
        OuterCircleFillPaint.setStyle(Paint.Style.FILL);
        OuterCircleFillPaint.setPathEffect(dashPath);

    }


    /**
     * Initialize the {@code Path} objects with the appropriate values.
     */
    private void initPaths(){
        OuterCirclePath = new Path();
        OuterCirclePath.addArc(mCircleRectF, mStartAngle, mTotalCircleDegrees);
    }

    /**
     *
     */
    private void initRects() {
        mCircleRectF.set(-mCircleWidth, -mCircleHeight, mCircleWidth, mCircleHeight);
    }

    /**
     * This is the main function of drawing stuff to the canvas.
     * Takes canvas as the main parameter
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(this.getWidth() / 2, this.getHeight() / 2);
        initRects();
        calculateTotalDegrees();
        initPaths();
        canvas.drawPath(OuterCirclePath, OuterCirclePaint);
    }


}
