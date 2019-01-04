/*
 * Copyright (C) 2019 The Android Open Source Project
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
package android.telephony.ims;

import android.os.Parcel;

/**
 * Rcs1To1Thread represents a single RCS conversation thread with a total of two
 * {@link RcsParticipant}s.
 * @hide - TODO(sahinc) make this public
 */
public class Rcs1To1Thread extends RcsThread {
    public static final Creator<Rcs1To1Thread> CREATOR = new Creator<Rcs1To1Thread>() {
        @Override
        public Rcs1To1Thread createFromParcel(Parcel in) {
            return new Rcs1To1Thread(in);
        }

        @Override
        public Rcs1To1Thread[] newArray(int size) {
            return new Rcs1To1Thread[size];
        }
    };

    protected Rcs1To1Thread(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
