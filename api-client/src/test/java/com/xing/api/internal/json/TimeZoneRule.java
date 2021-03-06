/*
 * Copyright (C) 2016 XING AG (http://xing.com/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xing.api.internal.json;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.TimeZone;

final class TimeZoneRule extends TestWatcher {
    private final TimeZone originalTimeZone = TimeZone.getDefault();
    private final TimeZone timeZone;

    public TimeZoneRule(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    protected void starting(Description description) {
        TimeZone.setDefault(timeZone);
    }

    @Override
    protected void finished(Description description) {
        TimeZone.setDefault(originalTimeZone);
    }
}
