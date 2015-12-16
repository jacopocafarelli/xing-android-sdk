/*
 * Copyright (c) 2015 XING AG (http://xing.com/)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.xing.android.sdk.internal.json;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.xing.android.sdk.model.user.WebProfile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import okio.Buffer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author daniel.hartwich
 */
public class WebProfileJsonAdapterTest {
    private Moshi moshi;

    @Before
    public void setUp() throws Exception {
        moshi = new Moshi.Builder()
              .add(WebProfileJsonAdapter.FACTORY)
              .build();
    }

    @After
    public void tearDown() throws Exception {
        moshi = null;
    }

    @Test
    public void testFromJson() throws Exception {
        JsonAdapter<WebProfileHelper> adapter = moshi.adapter(WebProfileHelper.class);
        assertThat(adapter.fromJson("{\"web_profile\" : \"amazon\"}").webProfile).isEqualTo(WebProfile.AMAZON);
        assertThat(adapter.fromJson("{\"web_profile\" : \"delicious\"}").webProfile).isEqualTo(WebProfile.DELICIOUS);
        assertThat(adapter.fromJson("{\"web_profile\" : \"digg\"}").webProfile).isEqualTo(WebProfile.DIGG);
        assertThat(adapter.fromJson("{\"web_profile\" : \"doodle\"}").webProfile).isEqualTo(WebProfile.DOODLE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"dopplr\"}").webProfile).isEqualTo(WebProfile.DOPPLR);
        assertThat(adapter.fromJson("{\"web_profile\" : \"ebay\"}").webProfile).isEqualTo(WebProfile.EBAY);
        assertThat(adapter.fromJson("{\"web_profile\" : \"facebook\"}").webProfile).isEqualTo(WebProfile.FACEBOOK);
        assertThat(adapter.fromJson("{\"web_profile\" : \"flickr\"}").webProfile).isEqualTo(WebProfile.FLICKR);
        assertThat(adapter.fromJson("{\"web_profile\" : \"foursquare\"}").webProfile).isEqualTo(WebProfile.FOURSQUARE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"github\"}").webProfile).isEqualTo(WebProfile.GITHUB);
        assertThat(adapter.fromJson("{\"web_profile\" : \"google+\"}").webProfile).isEqualTo(WebProfile.GOOGLE_PLUS);
        assertThat(adapter.fromJson("{\"web_profile\" : \"homepage\"}").webProfile).isEqualTo(WebProfile.HOMEPAGE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"last.fm\"}").webProfile).isEqualTo(WebProfile.LAST_FM);
        assertThat(adapter.fromJson("{\"web_profile\" : \"lifestream.fm\"}").webProfile)
              .isEqualTo(WebProfile.LIFESTREAM_FM);
        assertThat(adapter.fromJson("{\"web_profile\" : \"mindmeister\"}").webProfile)
              .isEqualTo(WebProfile.MINDMEISTER);
        assertThat(adapter.fromJson("{\"web_profile\" : \"mister wong\"}").webProfile).isEqualTo(WebProfile.MR_WONG);
        assertThat(adapter.fromJson("{\"web_profile\" : \"other\"}").webProfile).isEqualTo(WebProfile.OTHER);
        assertThat(adapter.fromJson("{\"web_profile\" : \"photobucket\"}").webProfile)
              .isEqualTo(WebProfile.PHOTOBUCKET);
        assertThat(adapter.fromJson("{\"web_profile\" : \"plazes\"}").webProfile).isEqualTo(WebProfile.PLAZES);
        assertThat(adapter.fromJson("{\"web_profile\" : \"qype\"}").webProfile).isEqualTo(WebProfile.QYPE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"reddit\"}").webProfile).isEqualTo(WebProfile.REDDIT);
        assertThat(adapter.fromJson("{\"web_profile\" : \"second life\"}").webProfile)
              .isEqualTo(WebProfile.SECOND_LIFE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"sevenload\"}").webProfile).isEqualTo(WebProfile.SEVENLOAD);
        assertThat(adapter.fromJson("{\"web_profile\" : \"slideshare\"}").webProfile).isEqualTo(WebProfile.SLIDESHARE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"sourceforge\"}").webProfile)
              .isEqualTo(WebProfile.SOURCEFORGE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"spreed\"}").webProfile).isEqualTo(WebProfile.SPREED);
        assertThat(adapter.fromJson("{\"web_profile\" : \"stumble upon\"}").webProfile)
              .isEqualTo(WebProfile.STUMPLE_UPON);
        assertThat(adapter.fromJson("{\"web_profile\" : \"twitter\"}").webProfile).isEqualTo(WebProfile.TWITTER);
        assertThat(adapter.fromJson("{\"web_profile\" : \"vimeo\"}").webProfile).isEqualTo(WebProfile.VIMEO);
        assertThat(adapter.fromJson("{\"web_profile\" : \"wikipedia\"}").webProfile).isEqualTo(WebProfile.WIKIPEDIA);
        assertThat(adapter.fromJson("{\"web_profile\" : \"yelp\"}").webProfile).isEqualTo(WebProfile.YELP);
        assertThat(adapter.fromJson("{\"web_profile\" : \"youtube\"}").webProfile).isEqualTo(WebProfile.YOUTUBE);
        assertThat(adapter.fromJson("{\"web_profile\" : \"zoominfo\"}").webProfile).isEqualTo(WebProfile.ZOOMINFO);
        assertThat(adapter.fromJson("{\"web_profile\" : \"xing\"}").webProfile).isNull();
    }

    @Test
    public void testToJson() throws Exception {
        Buffer buffer = new Buffer();
        JsonWriter writer = JsonWriter.of(buffer);
        writer.setLenient(true);
        moshi.adapter(WebProfile.class).toJson(writer, WebProfile.GITHUB);
        writer.flush();
        String bufferedString = buffer.readUtf8();
        assertThat(bufferedString).isEqualTo('"' + WebProfile.GITHUB.getJsonValue() + '"');
    }

    static class WebProfileHelper {
        @Json(name = "web_profile")
        public WebProfile webProfile;
    }
}
