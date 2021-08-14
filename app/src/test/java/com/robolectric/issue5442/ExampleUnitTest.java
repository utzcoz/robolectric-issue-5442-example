package com.robolectric.issue5442;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@RunWith(AndroidJUnit4.class)
public class ExampleUnitTest {
    @Test
    public void openFd_shouldProvideFileDescriptorForAsset() throws IOException {
        Context context = ApplicationProvider.getApplicationContext();
        AssetManager assetManager = context.getAssets();
        AssetFileDescriptor assetFileDescriptor = assetManager.openFd("assetsHome.txt");
        assertThat(CharStreams.toString(new InputStreamReader(
                assetFileDescriptor.createInputStream(), Charset.forName("UTF-8"))))
                .isEqualTo("assetsHome!");
        assertThat(assetFileDescriptor.getLength()).isEqualTo(11);
    }
}