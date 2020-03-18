/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.media.tv.tuner.frontend;

import android.annotation.IntDef;
import android.annotation.IntRange;
import android.annotation.NonNull;
import android.annotation.RequiresPermission;
import android.annotation.SystemApi;
import android.content.Context;
import android.hardware.tv.tuner.V1_0.Constants;
import android.media.tv.tuner.TunerUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Frontend settings for ATSC.
 *
 * @hide
 */
@SystemApi
public class AtscFrontendSettings extends FrontendSettings {

    /** @hide */
    @IntDef(flag = true,
            prefix = "MODULATION_",
            value = {MODULATION_UNDEFINED, MODULATION_AUTO, MODULATION_MOD_8VSB,
                    MODULATION_MOD_16VSB})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Modulation {}

    /**
     * Modulation undefined.
     */
    public static final int MODULATION_UNDEFINED = Constants.FrontendAtscModulation.UNDEFINED;
    /**
     * Hardware is able to detect and set modulation automatically
     */
    public static final int MODULATION_AUTO = Constants.FrontendAtscModulation.AUTO;
    /**
     * 8VSB Modulation.
     */
    public static final int MODULATION_MOD_8VSB = Constants.FrontendAtscModulation.MOD_8VSB;
    /**
     * 16VSB Modulation.
     */
    public static final int MODULATION_MOD_16VSB = Constants.FrontendAtscModulation.MOD_16VSB;


    private final int mModulation;

    private AtscFrontendSettings(int frequency, int modulation) {
        super(frequency);
        mModulation = modulation;
    }

    /**
     * Gets Modulation.
     */
    @Modulation
    public int getModulation() {
        return mModulation;
    }

    /**
     * Creates a builder for {@link AtscFrontendSettings}.
     *
     * @param context the context of the caller.
     */
    @RequiresPermission(android.Manifest.permission.ACCESS_TV_TUNER)
    @NonNull
    public static Builder builder(@NonNull Context context) {
        TunerUtils.checkTunerPermission(context);
        return new Builder();
    }

    /**
     * Builder for {@link AtscFrontendSettings}.
     */
    public static class Builder {
        private int mFrequency = 0;
        private int mModulation = MODULATION_UNDEFINED;

        private Builder() {
        }

        /**
         * Sets frequency in Hz.
         *
         * <p>Default value is 0.
         */
        @NonNull
        @IntRange(from = 1)
        public Builder setFrequency(int frequency) {
            mFrequency = frequency;
            return this;
        }

        /**
         * Sets Modulation.
         *
         * <p>Default value is {@link #MODULATION_UNDEFINED}.
         */
        @NonNull
        public Builder setModulation(@Modulation int modulation) {
            mModulation = modulation;
            return this;
        }

        /**
         * Builds a {@link AtscFrontendSettings} object.
         */
        @NonNull
        public AtscFrontendSettings build() {
            return new AtscFrontendSettings(mFrequency, mModulation);
        }
    }

    @Override
    public int getType() {
        return FrontendSettings.TYPE_ATSC;
    }
}
