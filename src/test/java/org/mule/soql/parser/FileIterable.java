/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class FileIterable implements Iterable {
    File file;

    public FileIterable(String fileName) {
        file = new File(fileName);
    }

    public Iterator iterator() {
        try {
            return FileUtils.lineIterator(file);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
