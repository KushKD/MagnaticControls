package com.kailash.magnet.uicontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.DashPathEffect;
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
     * Actual Drawing begins here
     * Initializes the {@code Paint} objects with the appropriate styles.
     * Drawing of the circles , Rectangles and Paths goes here
     */
    private void initPaints(){

        //Optional Dash PAth Effect
        DashPathEffect dashPath = new DashPathEffect(new float[]{80,10}, (float)0.0 );

    }


}
