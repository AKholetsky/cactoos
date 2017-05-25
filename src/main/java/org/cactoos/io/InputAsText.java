/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.io;

import java.io.IOException;
import java.nio.charset.Charset;
import org.cactoos.Input;
import org.cactoos.Text;

/**
 * Input as Text.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class InputAsText implements Text {

    /**
     * The input.
     */
    private final Input source;

    /**
     * Text encoding.
     */
    private final Charset charset;

    /**
     * New {@link InputAsText} with default charset.
     *
     * @param input The input
     */
    public InputAsText(final Input input) {
        this(input, Charset.defaultCharset());
    }

    /**
     * New {@link InputAsText} with specified charset.
     *
     * @param input The input
     * @param encoding Text charset
     */
    public InputAsText(final Input input, final Charset encoding) {
        this.source = input;
        this.charset = encoding;
    }

    @Override
    public String asString() throws IOException {
        return new String(
            new InputAsBytes(this.source).asBytes(),
            this.charset
        );
    }
}
