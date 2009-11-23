/*
 * Created on Oct 6, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2009 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.CommonFailures.expectErrorIfConditionIsNull;
import static org.fest.assertions.EmptyArrays.emptyFloatArray;
import static org.fest.assertions.NotNull.notNullFloatArray;
import static org.fest.test.ExpectedFailure.expectAssertionError;

import org.fest.test.CodeToTest;
import org.junit.Test;

/**
 * Tests for <code>{@link FloatArrayAssert#is(Condition)}</code>.
 *
 * @author Alex Ruiz
 */
public class FloatArrayAssert_is_Test implements GenericAssert_satisfies_TestCase {

  @Test
  public void should_pass_if_condition_is_satisfied() {
    new FloatArrayAssert(emptyFloatArray()).is(notNullFloatArray());
  }

  @Test
  public void should_throw_error_if_condition_is_null() {
    expectErrorIfConditionIsNull().on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(emptyFloatArray()).is(null);
      }
    });
  }

  @Test
  public void should_fail_if_condition_is_not_satisfied() {
    expectAssertionError("actual value:<null> should be:<NotNull>").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).is(notNullFloatArray());
      }
    });
  }

  @Test
  public void should_fail_and_display_description_of_assertion_if_condition_is_not_satisfied() {
    expectAssertionError("[A Test] actual value:<null> should be:<NotNull>").on(
      new CodeToTest() {
        public void run() {
          new FloatArrayAssert(null).as("A Test")
                                    .is(notNullFloatArray());
        }
      });
  }

  @Test
  public void should_fail_and_display_description_of_condition_if_condition_is_not_satisfied() {
    expectAssertionError("actual value:<null> should be:<Not Null>").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).is(notNullFloatArray().as("Not Null"));
      }
    });
  }

  @Test
  public void should_fail_and_display_descriptions_of_assertion_and_condition_if_condition_is_not_satisfied() {
    expectAssertionError("[A Test] actual value:<null> should be:<Not Null>").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).as("A Test")
                                  .is(notNullFloatArray().as("Not Null"));
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_if_condition_is_not_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).overridingErrorMessage("My custom message")
                                  .is(notNullFloatArray());
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_ignoring_description_of_assertion_if_condition_is_not_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).as("A Test")
                                  .overridingErrorMessage("My custom message")
                                  .is(notNullFloatArray());
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_ignoring_description_of_condition_if_condition_is_not_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FloatArrayAssert(null).overridingErrorMessage("My custom message")
                                  .is(notNullFloatArray().as("Not Null"));
      }
    });
  }
}