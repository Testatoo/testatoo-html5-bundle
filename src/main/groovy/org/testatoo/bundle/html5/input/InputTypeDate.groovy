/**
 * Copyright © 2018 Ovea (d.avenante@gmail.com)
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
package org.testatoo.bundle.html5.input

import org.testatoo.bundle.html5.helper.RangeHelper
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.field.DateField

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@CssIdentifier('input[type=date]')
class InputTypeDate extends DateField implements Input {
    @Override
    void value(Object value) {
        config.evaluator.runScript("\$('[id=\"${id()}\"]').val('" + value + "')")
    }

    @Override
    Object minimum() {
        RangeHelper.minimun(this)
    }

    @Override
    Object maximum() {
        RangeHelper.maximum(this)
    }

    @Override
    Object step() {
        RangeHelper.step(this)
    }

    @Override
    boolean inRange() {
        RangeHelper.inRange(this)
    }
}
