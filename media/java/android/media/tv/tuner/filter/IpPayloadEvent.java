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

package android.media.tv.tuner.filter;

/**
 * Filter event sent from {@link Filter} objects with IP payload type.
 *
 * @hide
 */
public class IpPayloadEvent extends FilterEvent {
    private final int mDataLength;

    // This constructor is used by JNI code only
    private IpPayloadEvent(int dataLength) {
        mDataLength = dataLength;
    }

    /**
     * Gets data size in bytes of filtered data.
     */
    public int getDataLength() {
        return mDataLength;
    }
}
