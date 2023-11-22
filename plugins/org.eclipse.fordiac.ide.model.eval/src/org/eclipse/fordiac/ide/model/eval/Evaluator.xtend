/*******************************************************************************
 * Copyright (c) 2022-2023 Martin Erich Jobst
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Martin Jobst - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.eval

import java.util.Map
import org.eclipse.fordiac.ide.model.eval.value.Value
import org.eclipse.fordiac.ide.model.eval.variable.Variable
import org.eclipse.fordiac.ide.model.libraryElement.ICallable
import java.util.Set

interface Evaluator {
	/**
	 * The default name of the context variable
	 */
	String CONTEXT_NAME = "THIS"

	/**
	 * Prepare the evaluator for execution. This executes preparatory steps that may run ahead of time, such as parsing the code.
	 */
	def void prepare()

	/**
	 * Evaluate a result
	 * 
	 * @return The resulting value or {@code null} if not applicable
	 * @throws EvaluatorException if an exception occurred during evaluation
	 * @throws InterruptedException if the evaluation was interrupted
	 */
	def Value evaluate() throws EvaluatorException, InterruptedException

	/**
	 * Get the name of the evaluator
	 */
	def String getName()

	/**
	 * Get the context of the evaluation, that is, the object or instance the evaluator operates on.
	 * 
	 * @return The context of the evaluation or {@code null} if not applicable (e.g., static functions)
	 */
	def Variable<?> getContext()

	/**
	 * Get the parent evaluator
	 * 
	 * @return The parent evaluator or {@code null} if this is the <b>root evaluator</b>
	 */
	def Evaluator getParent()

	/**
	 * Get the children of this evaluator.
	 * 
	 * <p>Note: This may not include temporary evaluators created on demand.
	 */
	def Map<? extends ICallable, ? extends Evaluator> getChildren()

	/**
	 * Get the source element this evaluator is executing.
	 */
	def Object getSourceElement()

	/**
	 * Get the dependencies of the source element
	 */
	def Set<String> getDependencies()

	/**
	 * Get the variables this evaluator has in its scope.
	 */
	def Map<String, Variable<?>> getVariables()

	/**
	 * Reset this evaluator to the given variables.
	 * 
	 * @apiNote This should set the evaluator to the state as if it was just created by passing the variables to the constructor.
	 * @param variables The variables to initialize the evaluator with
	 */
	def void reset(Iterable<Variable<?>> variables)
}
