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

import android.annotation.BytesLong;
import android.annotation.Nullable;

/**
 * Filter event sent from {@link Filter} objects with media type.
 *
 * @hide
 */
public class MediaEvent extends FilterEvent{
    private final int mStreamId;
    private final boolean mIsPtsPresent;
    private final long mPts;
    private final long mDataLength;
    private final long mOffset;
    private final Object mLinearBuffer;
    private final boolean mIsSecureMemory;
    private final long mDataId;
    private final int mMpuSequenceNumber;
    private final boolean mIsPrivateData;
    private final AudioDescriptor mExtraMetaData;

    // This constructor is used by JNI code only
    private MediaEvent(int streamId, boolean isPtsPresent, long pts, long dataLength, long offset,
            Object buffer, boolean isSecureMemory, long dataId, int mpuSequenceNumber,
            boolean isPrivateData, AudioDescriptor extraMetaData) {
        mStreamId = streamId;
        mIsPtsPresent = isPtsPresent;
        mPts = pts;
        mDataLength = dataLength;
        mOffset = offset;
        mLinearBuffer = buffer;
        mIsSecureMemory = isSecureMemory;
        mDataId = dataId;
        mMpuSequenceNumber = mpuSequenceNumber;
        mIsPrivateData = isPrivateData;
        mExtraMetaData = extraMetaData;
    }

    /**
     * Gets stream ID.
     */
    public int getStreamId() {
        return mStreamId;
    }

    /**
     * Returns whether PTS is present.
     *
     * @return {@code true} if PTS is present in PES header; {@code false} otherwise.
     */
    public boolean getIsPtsPresent() {
        return mIsPtsPresent;
    }

    /**
     * Gets PTS (Presentation Time Stamp) for audio or video frame.
     */
    public long getPts() {
        return mPts;
    }

    /**
     * Gets data size in bytes of audio or video frame.
     */
    @BytesLong
    public long getDataLength() {
        return mDataLength;
    }

    /**
     * The offset in the memory block which is shared among multiple Media Events.
     */
    @BytesLong
    public long getOffset() {
        return mOffset;
    }

    /**
     * Gets a linear buffer associated to the memory where audio or video data stays.
     * TODO: use LinearBuffer when it's ready.
     *
     * @hide
     */
    public Object getLinearBuffer() {
        return mLinearBuffer;
    }

    /**
     * Returns whether the data is secure.
     *
     * @return {@code true} if the data is in secure area, and isn't mappable;
     *         {@code false} otherwise.
     */
    public boolean getIsSecureMemory() {
        return mIsSecureMemory;
    }

    /**
     * Gets the ID which is used by HAL to provide additional information for AV data.
     *
     * <p>For secure audio, it's the audio handle used by Audio Track.
     */
    public long getAvDataId() {
        return mDataId;
    }

    /**
     * Gets MPU sequence number of filtered data.
     */
    public int getMpuSequenceNumber() {
        return mMpuSequenceNumber;
    }

    /**
     * Returns whether the data is private.
     *
     * @return {@code true} if the data is in private; {@code false} otherwise.
     */
    public boolean getIsPrivateData() {
        return mIsPrivateData;
    }

    /**
     * Gets audio extra metadata.
     */
    @Nullable
    public AudioDescriptor getExtraMetaData() {
        return mExtraMetaData;
    }
}
