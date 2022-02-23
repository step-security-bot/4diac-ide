/*
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextfunctioneditor.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.fordiac.ide.structuredtextcore.serializer.STCoreSemanticSequencer;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STArrayAccessExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STArrayInitElement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STArrayInitializerExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STAssignmentStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STBinaryExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCallNamedInputArgument;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCallNamedOutputArgument;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCallStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCallUnnamedArgument;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCaseCases;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCaseStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STContinue;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCorePackage;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STCoreSource;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STDateAndTimeLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STDateLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STElementaryInitializerExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STElseIfPart;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STElsePart;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STExit;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STFeatureExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STForStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STIfStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STMemberAccessExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STMultibitPartialExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STNop;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STNumericLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STRepeatStatement;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STReturn;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STStringLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STTimeLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STTimeOfDayLiteral;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STUnaryExpression;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STVarDeclaration;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STVarDeclarationBlock;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.STWhileStatement;
import org.eclipse.fordiac.ide.structuredtextfunctioneditor.services.STFunctionGrammarAccess;
import org.eclipse.fordiac.ide.structuredtextfunctioneditor.stfunction.STFunction;
import org.eclipse.fordiac.ide.structuredtextfunctioneditor.stfunction.STFunctionPackage;
import org.eclipse.fordiac.ide.structuredtextfunctioneditor.stfunction.STFunctionSource;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;

@SuppressWarnings("all")
public class STFunctionSemanticSequencer extends STCoreSemanticSequencer {

	@Inject
	private STFunctionGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == STCorePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case STCorePackage.ST_ARRAY_ACCESS_EXPRESSION:
				sequence_STAccessExpression(context, (STArrayAccessExpression) semanticObject); 
				return; 
			case STCorePackage.ST_ARRAY_INIT_ELEMENT:
				sequence_STArrayInitElement(context, (STArrayInitElement) semanticObject); 
				return; 
			case STCorePackage.ST_ARRAY_INITIALIZER_EXPRESSION:
				sequence_STArrayInitializerExpression(context, (STArrayInitializerExpression) semanticObject); 
				return; 
			case STCorePackage.ST_ASSIGNMENT_STATEMENT:
				sequence_STAssignmentStatement(context, (STAssignmentStatement) semanticObject); 
				return; 
			case STCorePackage.ST_BINARY_EXPRESSION:
				sequence_STAddSubExpression_STAndExpression_STComparisonExpression_STEqualityExpression_STMulDivModExpression_STOrExpression_STPowerExpression_STSubrangeExpression_STXorExpression(context, (STBinaryExpression) semanticObject); 
				return; 
			case STCorePackage.ST_CALL_NAMED_INPUT_ARGUMENT:
				sequence_STCallNamedInputArgument(context, (STCallNamedInputArgument) semanticObject); 
				return; 
			case STCorePackage.ST_CALL_NAMED_OUTPUT_ARGUMENT:
				sequence_STCallNamedOutputArgument(context, (STCallNamedOutputArgument) semanticObject); 
				return; 
			case STCorePackage.ST_CALL_STATEMENT:
				sequence_STCallStatement(context, (STCallStatement) semanticObject); 
				return; 
			case STCorePackage.ST_CALL_UNNAMED_ARGUMENT:
				sequence_STCallUnnamedArgument(context, (STCallUnnamedArgument) semanticObject); 
				return; 
			case STCorePackage.ST_CASE_CASES:
				sequence_STCaseCases(context, (STCaseCases) semanticObject); 
				return; 
			case STCorePackage.ST_CASE_STATEMENT:
				sequence_STCaseStatement(context, (STCaseStatement) semanticObject); 
				return; 
			case STCorePackage.ST_CONTINUE:
				sequence_STStatement(context, (STContinue) semanticObject); 
				return; 
			case STCorePackage.ST_CORE_SOURCE:
				sequence_STCoreSource(context, (STCoreSource) semanticObject); 
				return; 
			case STCorePackage.ST_DATE_AND_TIME_LITERAL:
				sequence_STDateAndTimeLiteral(context, (STDateAndTimeLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_DATE_LITERAL:
				sequence_STDateLiteral(context, (STDateLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_ELEMENTARY_INITIALIZER_EXPRESSION:
				sequence_STElementaryInitializerExpression(context, (STElementaryInitializerExpression) semanticObject); 
				return; 
			case STCorePackage.ST_ELSE_IF_PART:
				sequence_STElseIfPart(context, (STElseIfPart) semanticObject); 
				return; 
			case STCorePackage.ST_ELSE_PART:
				sequence_STElsePart(context, (STElsePart) semanticObject); 
				return; 
			case STCorePackage.ST_EXIT:
				sequence_STStatement(context, (STExit) semanticObject); 
				return; 
			case STCorePackage.ST_FEATURE_EXPRESSION:
				sequence_STFeatureExpression(context, (STFeatureExpression) semanticObject); 
				return; 
			case STCorePackage.ST_FOR_STATEMENT:
				sequence_STForStatement(context, (STForStatement) semanticObject); 
				return; 
			case STCorePackage.ST_IF_STATEMENT:
				sequence_STIfStatement(context, (STIfStatement) semanticObject); 
				return; 
			case STCorePackage.ST_MEMBER_ACCESS_EXPRESSION:
				sequence_STAccessExpression(context, (STMemberAccessExpression) semanticObject); 
				return; 
			case STCorePackage.ST_MULTIBIT_PARTIAL_EXPRESSION:
				sequence_STMultibitPartialExpression(context, (STMultibitPartialExpression) semanticObject); 
				return; 
			case STCorePackage.ST_NOP:
				sequence_STStatement(context, (STNop) semanticObject); 
				return; 
			case STCorePackage.ST_NUMERIC_LITERAL:
				sequence_STNumericLiteral(context, (STNumericLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_REPEAT_STATEMENT:
				sequence_STRepeatStatement(context, (STRepeatStatement) semanticObject); 
				return; 
			case STCorePackage.ST_RETURN:
				sequence_STStatement(context, (STReturn) semanticObject); 
				return; 
			case STCorePackage.ST_STRING_LITERAL:
				sequence_STStringLiteral(context, (STStringLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_TIME_LITERAL:
				sequence_STTimeLiteral(context, (STTimeLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_TIME_OF_DAY_LITERAL:
				sequence_STTimeOfDayLiteral(context, (STTimeOfDayLiteral) semanticObject); 
				return; 
			case STCorePackage.ST_UNARY_EXPRESSION:
				sequence_STUnaryExpression(context, (STUnaryExpression) semanticObject); 
				return; 
			case STCorePackage.ST_VAR_DECLARATION:
				sequence_STVarDeclaration(context, (STVarDeclaration) semanticObject); 
				return; 
			case STCorePackage.ST_VAR_DECLARATION_BLOCK:
				if (rule == grammarAccess.getSTVarDeclarationBlockRule()) {
					sequence_STVarDeclarationBlock(context, (STVarDeclarationBlock) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSTVarInputDeclarationBlockRule()) {
					sequence_STVarInputDeclarationBlock(context, (STVarDeclarationBlock) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSTVarOutputDeclarationBlockRule()) {
					sequence_STVarOutputDeclarationBlock(context, (STVarDeclarationBlock) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSTVarTempDeclarationBlockRule()) {
					sequence_STVarTempDeclarationBlock(context, (STVarDeclarationBlock) semanticObject); 
					return; 
				}
				else break;
			case STCorePackage.ST_WHILE_STATEMENT:
				sequence_STWhileStatement(context, (STWhileStatement) semanticObject); 
				return; 
			}
		else if (epackage == STFunctionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case STFunctionPackage.ST_FUNCTION:
				sequence_STFunction(context, (STFunction) semanticObject); 
				return; 
			case STFunctionPackage.ST_FUNCTION_SOURCE:
				sequence_STFunctionSource(context, (STFunctionSource) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     STFunctionSource returns STFunctionSource
	 *
	 * Constraint:
	 *     functions+=STFunction*
	 */
	protected void sequence_STFunctionSource(ISerializationContext context, STFunctionSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     STFunction returns STFunction
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         returnType=[DataType|STAnyType]? 
	 *         (
	 *             varDeclarations+=STVarDeclarationBlock | 
	 *             varTempDeclarations+=STVarTempDeclarationBlock | 
	 *             varInputDeclarations+=STVarInputDeclarationBlock | 
	 *             varOutputDeclarations+=STVarOutputDeclarationBlock
	 *         )* 
	 *         code+=STStatement*
	 *     )
	 */
	protected void sequence_STFunction(ISerializationContext context, STFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
