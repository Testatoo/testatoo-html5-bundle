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
package org.testatoo.bundle.html5

import org.testatoo.core.By
import org.testatoo.core.ComponentException
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Component

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@CssIdentifier('form')
class Form extends org.testatoo.core.component.Form {
    @Override
    void reset() {
        Button reset_button = find(By.css('[type=reset]:first'))[0] as Button
        if (reset_button && reset_button.available())
            reset_button.click()
        else
            throw new ComponentException('Cannot reset form without reset button')
    }

    @Override
    void submit() {
        Button submit_button = this.find(By.css('[type=submit]:first'))[0] as Button
        if (submit_button && submit_button.available())
            submit_button.click()
        else
            throw new ComponentException('Cannot submit form without submit button')
    }

    @Override
    boolean valid() {
        find(By.css('input'), Component).findAll { input ->
            config.evaluator.check(input.id(), "it.is(':invalid')")
        }.empty
    }
}
