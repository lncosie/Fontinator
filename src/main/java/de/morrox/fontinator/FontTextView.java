package de.morrox.fontinator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import de.morrox.fontinator.utilities.TypefaceLoader;
import de.morrox.fontinator.utilities.Typefaceable;

public class FontTextView extends TextView implements Typefaceable {

    private TypefaceLoader typefaceLoader;
    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        typefaceLoader = new TypefaceLoader(this, context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if(type != BufferType.SPANNABLE && typefaceLoader != null){
            typefaceLoader.createLetterSpacing(text);
        }
    }
}