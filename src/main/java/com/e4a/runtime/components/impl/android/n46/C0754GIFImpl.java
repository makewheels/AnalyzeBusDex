package com.e4a.runtime.components.impl.android.n46;

import android.view.View;
import android.view.View.OnClickListener;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.components.impl.android.n46.gifview.GifView;
import com.e4a.runtime.components.impl.android.n46.gifview.GifView.GifImageType;
import com.e4a.runtime.errors.NoSuchFileError;
import com.e4a.runtime.events.EventDispatcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.e4a.runtime.components.impl.android.n46.GIF图片框Impl */
public class C0754GIFImpl extends ViewComponent implements C0753GIF, OnClickListener {
    private String backgroundImage;

    public C0754GIFImpl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        GifView view = new GifView(mainActivity.getContext());
        view.setFocusable(true);
        view.setOnClickListener(this);
        return view;
    }

    /* renamed from: 图像 */
    public String mo1176() {
        return this.backgroundImage;
    }

    /* renamed from: 图像 */
    public void mo1177(String imagePath) {
        if (imagePath.length() > 0) {
            this.backgroundImage = imagePath;
            GifView view;
            if (imagePath.startsWith("/")) {
                File f = new File(imagePath);
                if (f.exists()) {
                    try {
                        view = (GifView) getView();
                        view.setShowDimension(mo779(), mo805());
                        view.setGifImageType(GifImageType.COVER);
                        view.setGifImage(new FileInputStream(f));
                        return;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                InputStream inputstream = mainActivity.getContext().getAssets().open(imagePath);
                view = (GifView) getView();
                view.setShowDimension(mo779(), mo805());
                view.setGifImageType(GifImageType.COVER);
                view.setGifImage(inputstream);
            } catch (IOException e2) {
                throw new NoSuchFileError(imagePath);
            }
        }
    }

    /* renamed from: 载入字节图片 */
    public void mo1179(byte[] image) {
        if (image.length > 0) {
            GifView view = (GifView) getView();
            view.setShowDimension(mo779(), mo805());
            view.setGifImageType(GifImageType.COVER);
            view.setGifImage(image);
        }
    }

    /* renamed from: 被单击 */
    public void mo1178() {
        EventDispatcher.dispatchEvent(this, "被单击", new Object[0]);
    }

    public void onClick(View view) {
        mo1178();
    }
}
