/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.lib.util.svn;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSVNUtils  {

    @Test
    public void testNull() {
        assertEquals(-1, SVNUtils.svnInfoToInteger(null));
    }

    @Test
    public void testBasic() {
        int i = 12345678;
        assertEquals(i, SVNUtils.svnInfoToInteger(i + ""));
    }

    @Test
    public void testGoodTrailingString() {
        int i = 12345678;
        assertEquals(i, SVNUtils.svnInfoToInteger(i + "m"));
    }

    @Test
    public void testMixedRevision() {
        int i = 12345678;
        assertEquals(i, SVNUtils.svnInfoToInteger("55555:" + i));
    }

    @Test
    public void testMixedRevisionTrailingString() {
        int i = 12345678;
        assertEquals(i, SVNUtils.svnInfoToInteger("55555:" + i + "MS"));
    }

    @Test
    public void testBad() {
        int i = 12345678;
        assertEquals(-1, SVNUtils.svnInfoToInteger("55555:aa" + i + "ms"));
    }

}
