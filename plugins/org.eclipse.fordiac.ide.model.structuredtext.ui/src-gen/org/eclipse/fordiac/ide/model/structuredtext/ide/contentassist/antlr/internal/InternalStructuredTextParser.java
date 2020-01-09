package org.eclipse.fordiac.ide.model.structuredtext.ide.contentassist.antlr.internal;

import java.util.Map;
import java.util.HashMap;

import org.eclipse.xtext.*;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.fordiac.ide.model.structuredtext.services.StructuredTextGrammarAccess;

import org.antlr.runtime.*;

@SuppressWarnings("all")
public class InternalStructuredTextParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LDATE_AND_TIME",
			"DATE_AND_TIME", "LTIME_OF_DAY", "TIME_OF_DAY", "END_REPEAT", "END_WHILE", "CONSTANT", "CONTINUE",
			"END_CASE", "END_FOR", "END_VAR", "WSTRING", "END_IF", "REPEAT", "RETURN", "STRING", "DWORD", "ELSIF",
			"FALSE", "LDATE", "LREAL", "LTIME", "LWORD", "SUPER", "UDINT", "ULINT", "UNTIL", "USINT", "WCHAR", "WHILE",
			"BOOL", "BYTE", "CASE", "CHAR", "DATE", "DINT", "ELSE", "EXIT", "LINT", "LTOD", "REAL", "SINT", "THEN",
			"TIME", "TRUE", "UINT", "WORD", "AND", "FOR", "INT", "LDT", "MOD", "NOT", "TOD", "VAR", "XOR",
			"AsteriskAsterisk", "ColonEqualsSign", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign",
			"EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "BY", "DO", "DT", "IF", "LD", "LT", "OF", "OR",
			"TO", "Ms", "Ns", "Us", "NumberSign", "Ampersand", "LeftParenthesis", "RightParenthesis", "Asterisk",
			"PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign",
			"EqualsSign", "GreaterThanSign", "E", "T", "LeftSquareBracket", "RightSquareBracket", "KW__", "D_1", "H",
			"M", "S", "RULE_LETTER", "RULE_DIGIT", "RULE_BIT", "RULE_OCTAL_DIGIT", "RULE_HEX_DIGIT", "RULE_ID",
			"RULE_BINARY_INT", "RULE_OCTAL_INT", "RULE_HEX_INT", "RULE_UNSIGNED_INT", "RULE_S_BYTE_CHAR_VALUE",
			"RULE_S_BYTE_CHAR_STR", "RULE_D_BYTE_CHAR_VALUE", "RULE_D_BYTE_CHAR_STR", "RULE_COMMON_CHAR_VALUE",
			"RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER" };
	public static final int LWORD = 26;
	public static final int LessThanSignGreaterThanSign = 63;
	public static final int EqualsSignGreaterThanSign = 64;
	public static final int VAR = 58;
	public static final int END_IF = 16;
	public static final int ULINT = 29;
	public static final int END_CASE = 12;
	public static final int LessThanSign = 90;
	public static final int RULE_BIT = 104;
	public static final int LeftParenthesis = 80;
	public static final int BYTE = 35;
	public static final int ELSE = 40;
	public static final int IF = 69;
	public static final int LINT = 42;
	public static final int GreaterThanSign = 92;
	public static final int WORD = 50;
	public static final int DATE_AND_TIME = 5;
	public static final int RULE_ID = 107;
	public static final int TOD = 57;
	public static final int RULE_DIGIT = 103;
	public static final int DINT = 39;
	public static final int UDINT = 28;
	public static final int CASE = 36;
	public static final int GreaterThanSignEqualsSign = 65;
	public static final int RULE_OCTAL_INT = 109;
	public static final int PlusSign = 83;
	public static final int END_FOR = 13;
	public static final int RULE_ML_COMMENT = 117;
	public static final int THEN = 46;
	public static final int XOR = 59;
	public static final int LeftSquareBracket = 95;
	public static final int EXIT = 41;
	public static final int TIME_OF_DAY = 7;
	public static final int LDATE_AND_TIME = 4;
	public static final int REPEAT = 17;
	public static final int E = 93;
	public static final int H = 99;
	public static final int CHAR = 37;
	public static final int RULE_D_BYTE_CHAR_STR = 115;
	public static final int RULE_UNSIGNED_INT = 111;
	public static final int M = 100;
	public static final int LTIME = 25;
	public static final int Comma = 84;
	public static final int HyphenMinus = 85;
	public static final int S = 101;
	public static final int T = 94;
	public static final int BY = 66;
	public static final int ELSIF = 21;
	public static final int END_REPEAT = 8;
	public static final int LessThanSignEqualsSign = 62;
	public static final int Solidus = 87;
	public static final int RULE_OCTAL_DIGIT = 105;
	public static final int RULE_HEX_INT = 110;
	public static final int FullStop = 86;
	public static final int CONSTANT = 10;
	public static final int KW__ = 97;
	public static final int CONTINUE = 11;
	public static final int Semicolon = 89;
	public static final int RULE_LETTER = 102;
	public static final int LD = 70;
	public static final int STRING = 19;
	public static final int RULE_HEX_DIGIT = 106;
	public static final int TO = 74;
	public static final int UINT = 49;
	public static final int LTOD = 43;
	public static final int LT = 71;
	public static final int DO = 67;
	public static final int WSTRING = 15;
	public static final int DT = 68;
	public static final int END_VAR = 14;
	public static final int Ampersand = 79;
	public static final int RightSquareBracket = 96;
	public static final int RULE_BINARY_INT = 108;
	public static final int USINT = 31;
	public static final int DWORD = 20;
	public static final int FOR = 52;
	public static final int RightParenthesis = 81;
	public static final int TRUE = 48;
	public static final int ColonEqualsSign = 61;
	public static final int END_WHILE = 9;
	public static final int DATE = 38;
	public static final int NOT = 56;
	public static final int LDATE = 23;
	public static final int AND = 51;
	public static final int NumberSign = 78;
	public static final int REAL = 44;
	public static final int AsteriskAsterisk = 60;
	public static final int SINT = 45;
	public static final int LTIME_OF_DAY = 6;
	public static final int Us = 77;
	public static final int LREAL = 24;
	public static final int WCHAR = 32;
	public static final int Ms = 75;
	public static final int INT = 53;
	public static final int RULE_SL_COMMENT = 118;
	public static final int RETURN = 18;
	public static final int EqualsSign = 91;
	public static final int RULE_COMMON_CHAR_VALUE = 116;
	public static final int OF = 72;
	public static final int Colon = 88;
	public static final int EOF = -1;
	public static final int LDT = 54;
	public static final int Asterisk = 82;
	public static final int SUPER = 27;
	public static final int MOD = 55;
	public static final int OR = 73;
	public static final int RULE_S_BYTE_CHAR_VALUE = 112;
	public static final int Ns = 76;
	public static final int RULE_WS = 119;
	public static final int TIME = 47;
	public static final int RULE_ANY_OTHER = 120;
	public static final int UNTIL = 30;
	public static final int RULE_S_BYTE_CHAR_STR = 113;
	public static final int BOOL = 34;
	public static final int D_1 = 98;
	public static final int FALSE = 22;
	public static final int WHILE = 33;
	public static final int RULE_D_BYTE_CHAR_VALUE = 114;

	// delegates
	// delegators

	public InternalStructuredTextParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalStructuredTextParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}

	@Override
	public String[] getTokenNames() {
		return InternalStructuredTextParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "InternalStructuredTextParser.g";
	}

	private StructuredTextGrammarAccess grammarAccess;
	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();

	{
		tokenNameToValue.put("NumberSign", "'#'");
		tokenNameToValue.put("Ampersand", "'&'");
		tokenNameToValue.put("LeftParenthesis", "'('");
		tokenNameToValue.put("RightParenthesis", "')'");
		tokenNameToValue.put("Asterisk", "'*'");
		tokenNameToValue.put("PlusSign", "'+'");
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("HyphenMinus", "'-'");
		tokenNameToValue.put("FullStop", "'.'");
		tokenNameToValue.put("Solidus", "'/'");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("Semicolon", "';'");
		tokenNameToValue.put("LessThanSign", "'<'");
		tokenNameToValue.put("EqualsSign", "'='");
		tokenNameToValue.put("GreaterThanSign", "'>'");
		tokenNameToValue.put("D_1", "'D'");
		tokenNameToValue.put("E", "'E'");
		tokenNameToValue.put("T", "'T'");
		tokenNameToValue.put("LeftSquareBracket", "'['");
		tokenNameToValue.put("RightSquareBracket", "']'");
		tokenNameToValue.put("KW__", "'_'");
		tokenNameToValue.put("D_1", "'d'");
		tokenNameToValue.put("H", "'h'");
		tokenNameToValue.put("M", "'m'");
		tokenNameToValue.put("S", "'s'");
		tokenNameToValue.put("AsteriskAsterisk", "'**'");
		tokenNameToValue.put("ColonEqualsSign", "':='");
		tokenNameToValue.put("LessThanSignEqualsSign", "'<='");
		tokenNameToValue.put("LessThanSignGreaterThanSign", "'<>'");
		tokenNameToValue.put("EqualsSignGreaterThanSign", "'=>'");
		tokenNameToValue.put("GreaterThanSignEqualsSign", "'>='");
		tokenNameToValue.put("BY", "'BY'");
		tokenNameToValue.put("DO", "'DO'");
		tokenNameToValue.put("DT", "'DT'");
		tokenNameToValue.put("IF", "'IF'");
		tokenNameToValue.put("LD", "'LD'");
		tokenNameToValue.put("LT", "'LT'");
		tokenNameToValue.put("OF", "'OF'");
		tokenNameToValue.put("OR", "'OR'");
		tokenNameToValue.put("TO", "'TO'");
		tokenNameToValue.put("Ms", "'ms'");
		tokenNameToValue.put("Ns", "'ns'");
		tokenNameToValue.put("Us", "'us'");
		tokenNameToValue.put("AND", "'AND'");
		tokenNameToValue.put("FOR", "'FOR'");
		tokenNameToValue.put("INT", "'INT'");
		tokenNameToValue.put("LDT", "'LDT'");
		tokenNameToValue.put("MOD", "'MOD'");
		tokenNameToValue.put("NOT", "'NOT'");
		tokenNameToValue.put("TOD", "'TOD'");
		tokenNameToValue.put("VAR", "'VAR'");
		tokenNameToValue.put("XOR", "'XOR'");
		tokenNameToValue.put("BOOL", "'BOOL'");
		tokenNameToValue.put("BYTE", "'BYTE'");
		tokenNameToValue.put("CASE", "'CASE'");
		tokenNameToValue.put("CHAR", "'CHAR'");
		tokenNameToValue.put("DATE", "'DATE'");
		tokenNameToValue.put("DINT", "'DINT'");
		tokenNameToValue.put("ELSE", "'ELSE'");
		tokenNameToValue.put("EXIT", "'EXIT'");
		tokenNameToValue.put("LINT", "'LINT'");
		tokenNameToValue.put("LTOD", "'LTOD'");
		tokenNameToValue.put("REAL", "'REAL'");
		tokenNameToValue.put("SINT", "'SINT'");
		tokenNameToValue.put("THEN", "'THEN'");
		tokenNameToValue.put("TIME", "'TIME'");
		tokenNameToValue.put("TRUE", "'TRUE'");
		tokenNameToValue.put("UINT", "'UINT'");
		tokenNameToValue.put("WORD", "'WORD'");
		tokenNameToValue.put("DWORD", "'DWORD'");
		tokenNameToValue.put("ELSIF", "'ELSIF'");
		tokenNameToValue.put("FALSE", "'FALSE'");
		tokenNameToValue.put("LDATE", "'LDATE'");
		tokenNameToValue.put("LREAL", "'LREAL'");
		tokenNameToValue.put("LTIME", "'LTIME'");
		tokenNameToValue.put("LWORD", "'LWORD'");
		tokenNameToValue.put("SUPER", "'SUPER'");
		tokenNameToValue.put("UDINT", "'UDINT'");
		tokenNameToValue.put("ULINT", "'ULINT'");
		tokenNameToValue.put("UNTIL", "'UNTIL'");
		tokenNameToValue.put("USINT", "'USINT'");
		tokenNameToValue.put("WCHAR", "'WCHAR'");
		tokenNameToValue.put("WHILE", "'WHILE'");
		tokenNameToValue.put("END_IF", "'END_IF'");
		tokenNameToValue.put("REPEAT", "'REPEAT'");
		tokenNameToValue.put("RETURN", "'RETURN'");
		tokenNameToValue.put("STRING", "'STRING'");
		tokenNameToValue.put("END_FOR", "'END_FOR'");
		tokenNameToValue.put("END_VAR", "'END_VAR'");
		tokenNameToValue.put("WSTRING", "'WSTRING'");
		tokenNameToValue.put("CONSTANT", "'CONSTANT'");
		tokenNameToValue.put("CONTINUE", "'CONTINUE'");
		tokenNameToValue.put("END_CASE", "'END_CASE'");
		tokenNameToValue.put("END_WHILE", "'END_WHILE'");
		tokenNameToValue.put("END_REPEAT", "'END_REPEAT'");
		tokenNameToValue.put("TIME_OF_DAY", "'TIME_OF_DAY'");
		tokenNameToValue.put("LTIME_OF_DAY", "'LTIME_OF_DAY'");
		tokenNameToValue.put("DATE_AND_TIME", "'DATE_AND_TIME'");
		tokenNameToValue.put("LDATE_AND_TIME", "'LDATE_AND_TIME'");
	}

	public void setGrammarAccess(StructuredTextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		String result = tokenNameToValue.get(tokenName);
		if (result == null)
			result = tokenName;
		return result;
	}

	// $ANTLR start "entryRuleStructuredTextAlgorithm"
	// InternalStructuredTextParser.g:154:1: entryRuleStructuredTextAlgorithm :
	// ruleStructuredTextAlgorithm EOF ;
	public final void entryRuleStructuredTextAlgorithm() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:155:1: ( ruleStructuredTextAlgorithm EOF )
			// InternalStructuredTextParser.g:156:1: ruleStructuredTextAlgorithm EOF
			{
				before(grammarAccess.getStructuredTextAlgorithmRule());
				pushFollow(FOLLOW_1);
				ruleStructuredTextAlgorithm();

				state._fsp--;

				after(grammarAccess.getStructuredTextAlgorithmRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStructuredTextAlgorithm"

	// $ANTLR start "ruleStructuredTextAlgorithm"
	// InternalStructuredTextParser.g:163:1: ruleStructuredTextAlgorithm : ( (
	// rule__StructuredTextAlgorithm__Group__0 ) ) ;
	public final void ruleStructuredTextAlgorithm() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:167:2: ( ( (
			// rule__StructuredTextAlgorithm__Group__0 ) ) )
			// InternalStructuredTextParser.g:168:2: ( (
			// rule__StructuredTextAlgorithm__Group__0 ) )
			{
				// InternalStructuredTextParser.g:168:2: ( (
				// rule__StructuredTextAlgorithm__Group__0 ) )
				// InternalStructuredTextParser.g:169:3: (
				// rule__StructuredTextAlgorithm__Group__0 )
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getGroup());
					// InternalStructuredTextParser.g:170:3: (
					// rule__StructuredTextAlgorithm__Group__0 )
					// InternalStructuredTextParser.g:170:4: rule__StructuredTextAlgorithm__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__StructuredTextAlgorithm__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getStructuredTextAlgorithmAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleStructuredTextAlgorithm"

	// $ANTLR start "entryRuleVar_Decl_Init"
	// InternalStructuredTextParser.g:179:1: entryRuleVar_Decl_Init :
	// ruleVar_Decl_Init EOF ;
	public final void entryRuleVar_Decl_Init() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:180:1: ( ruleVar_Decl_Init EOF )
			// InternalStructuredTextParser.g:181:1: ruleVar_Decl_Init EOF
			{
				before(grammarAccess.getVar_Decl_InitRule());
				pushFollow(FOLLOW_1);
				ruleVar_Decl_Init();

				state._fsp--;

				after(grammarAccess.getVar_Decl_InitRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVar_Decl_Init"

	// $ANTLR start "ruleVar_Decl_Init"
	// InternalStructuredTextParser.g:188:1: ruleVar_Decl_Init : ( (
	// rule__Var_Decl_Init__Group__0 ) ) ;
	public final void ruleVar_Decl_Init() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:192:2: ( ( ( rule__Var_Decl_Init__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:193:2: ( ( rule__Var_Decl_Init__Group__0 ) )
			{
				// InternalStructuredTextParser.g:193:2: ( ( rule__Var_Decl_Init__Group__0 ) )
				// InternalStructuredTextParser.g:194:3: ( rule__Var_Decl_Init__Group__0 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getGroup());
					// InternalStructuredTextParser.g:195:3: ( rule__Var_Decl_Init__Group__0 )
					// InternalStructuredTextParser.g:195:4: rule__Var_Decl_Init__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVar_Decl_Init"

	// $ANTLR start "entryRuleStmt_List"
	// InternalStructuredTextParser.g:204:1: entryRuleStmt_List : ruleStmt_List EOF
	// ;
	public final void entryRuleStmt_List() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:205:1: ( ruleStmt_List EOF )
			// InternalStructuredTextParser.g:206:1: ruleStmt_List EOF
			{
				before(grammarAccess.getStmt_ListRule());
				pushFollow(FOLLOW_1);
				ruleStmt_List();

				state._fsp--;

				after(grammarAccess.getStmt_ListRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStmt_List"

	// $ANTLR start "ruleStmt_List"
	// InternalStructuredTextParser.g:213:1: ruleStmt_List : ( (
	// rule__Stmt_List__Group__0 ) ) ;
	public final void ruleStmt_List() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:217:2: ( ( ( rule__Stmt_List__Group__0 ) ) )
			// InternalStructuredTextParser.g:218:2: ( ( rule__Stmt_List__Group__0 ) )
			{
				// InternalStructuredTextParser.g:218:2: ( ( rule__Stmt_List__Group__0 ) )
				// InternalStructuredTextParser.g:219:3: ( rule__Stmt_List__Group__0 )
				{
					before(grammarAccess.getStmt_ListAccess().getGroup());
					// InternalStructuredTextParser.g:220:3: ( rule__Stmt_List__Group__0 )
					// InternalStructuredTextParser.g:220:4: rule__Stmt_List__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Stmt_List__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getStmt_ListAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleStmt_List"

	// $ANTLR start "entryRuleStmt"
	// InternalStructuredTextParser.g:229:1: entryRuleStmt : ruleStmt EOF ;
	public final void entryRuleStmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:230:1: ( ruleStmt EOF )
			// InternalStructuredTextParser.g:231:1: ruleStmt EOF
			{
				before(grammarAccess.getStmtRule());
				pushFollow(FOLLOW_1);
				ruleStmt();

				state._fsp--;

				after(grammarAccess.getStmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleStmt"

	// $ANTLR start "ruleStmt"
	// InternalStructuredTextParser.g:238:1: ruleStmt : ( ( rule__Stmt__Alternatives
	// ) ) ;
	public final void ruleStmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:242:2: ( ( ( rule__Stmt__Alternatives ) ) )
			// InternalStructuredTextParser.g:243:2: ( ( rule__Stmt__Alternatives ) )
			{
				// InternalStructuredTextParser.g:243:2: ( ( rule__Stmt__Alternatives ) )
				// InternalStructuredTextParser.g:244:3: ( rule__Stmt__Alternatives )
				{
					before(grammarAccess.getStmtAccess().getAlternatives());
					// InternalStructuredTextParser.g:245:3: ( rule__Stmt__Alternatives )
					// InternalStructuredTextParser.g:245:4: rule__Stmt__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Stmt__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getStmtAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleStmt"

	// $ANTLR start "entryRuleAssign_Stmt"
	// InternalStructuredTextParser.g:254:1: entryRuleAssign_Stmt : ruleAssign_Stmt
	// EOF ;
	public final void entryRuleAssign_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:255:1: ( ruleAssign_Stmt EOF )
			// InternalStructuredTextParser.g:256:1: ruleAssign_Stmt EOF
			{
				before(grammarAccess.getAssign_StmtRule());
				pushFollow(FOLLOW_1);
				ruleAssign_Stmt();

				state._fsp--;

				after(grammarAccess.getAssign_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAssign_Stmt"

	// $ANTLR start "ruleAssign_Stmt"
	// InternalStructuredTextParser.g:263:1: ruleAssign_Stmt : ( (
	// rule__Assign_Stmt__Group__0 ) ) ;
	public final void ruleAssign_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:267:2: ( ( ( rule__Assign_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:268:2: ( ( rule__Assign_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:268:2: ( ( rule__Assign_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:269:3: ( rule__Assign_Stmt__Group__0 )
				{
					before(grammarAccess.getAssign_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:270:3: ( rule__Assign_Stmt__Group__0 )
					// InternalStructuredTextParser.g:270:4: rule__Assign_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Assign_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getAssign_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAssign_Stmt"

	// $ANTLR start "entryRuleSubprog_Ctrl_Stmt"
	// InternalStructuredTextParser.g:279:1: entryRuleSubprog_Ctrl_Stmt :
	// ruleSubprog_Ctrl_Stmt EOF ;
	public final void entryRuleSubprog_Ctrl_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:280:1: ( ruleSubprog_Ctrl_Stmt EOF )
			// InternalStructuredTextParser.g:281:1: ruleSubprog_Ctrl_Stmt EOF
			{
				before(grammarAccess.getSubprog_Ctrl_StmtRule());
				pushFollow(FOLLOW_1);
				ruleSubprog_Ctrl_Stmt();

				state._fsp--;

				after(grammarAccess.getSubprog_Ctrl_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSubprog_Ctrl_Stmt"

	// $ANTLR start "ruleSubprog_Ctrl_Stmt"
	// InternalStructuredTextParser.g:288:1: ruleSubprog_Ctrl_Stmt : ( (
	// rule__Subprog_Ctrl_Stmt__Alternatives ) ) ;
	public final void ruleSubprog_Ctrl_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:292:2: ( ( (
			// rule__Subprog_Ctrl_Stmt__Alternatives ) ) )
			// InternalStructuredTextParser.g:293:2: ( (
			// rule__Subprog_Ctrl_Stmt__Alternatives ) )
			{
				// InternalStructuredTextParser.g:293:2: ( (
				// rule__Subprog_Ctrl_Stmt__Alternatives ) )
				// InternalStructuredTextParser.g:294:3: ( rule__Subprog_Ctrl_Stmt__Alternatives
				// )
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getAlternatives());
					// InternalStructuredTextParser.g:295:3: ( rule__Subprog_Ctrl_Stmt__Alternatives
					// )
					// InternalStructuredTextParser.g:295:4: rule__Subprog_Ctrl_Stmt__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Subprog_Ctrl_Stmt__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleSubprog_Ctrl_Stmt"

	// $ANTLR start "entryRuleSelection_Stmt"
	// InternalStructuredTextParser.g:304:1: entryRuleSelection_Stmt :
	// ruleSelection_Stmt EOF ;
	public final void entryRuleSelection_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:305:1: ( ruleSelection_Stmt EOF )
			// InternalStructuredTextParser.g:306:1: ruleSelection_Stmt EOF
			{
				before(grammarAccess.getSelection_StmtRule());
				pushFollow(FOLLOW_1);
				ruleSelection_Stmt();

				state._fsp--;

				after(grammarAccess.getSelection_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSelection_Stmt"

	// $ANTLR start "ruleSelection_Stmt"
	// InternalStructuredTextParser.g:313:1: ruleSelection_Stmt : ( (
	// rule__Selection_Stmt__Alternatives ) ) ;
	public final void ruleSelection_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:317:2: ( ( (
			// rule__Selection_Stmt__Alternatives ) ) )
			// InternalStructuredTextParser.g:318:2: ( ( rule__Selection_Stmt__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:318:2: ( ( rule__Selection_Stmt__Alternatives
				// ) )
				// InternalStructuredTextParser.g:319:3: ( rule__Selection_Stmt__Alternatives )
				{
					before(grammarAccess.getSelection_StmtAccess().getAlternatives());
					// InternalStructuredTextParser.g:320:3: ( rule__Selection_Stmt__Alternatives )
					// InternalStructuredTextParser.g:320:4: rule__Selection_Stmt__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Selection_Stmt__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getSelection_StmtAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleSelection_Stmt"

	// $ANTLR start "entryRuleIF_Stmt"
	// InternalStructuredTextParser.g:329:1: entryRuleIF_Stmt : ruleIF_Stmt EOF ;
	public final void entryRuleIF_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:330:1: ( ruleIF_Stmt EOF )
			// InternalStructuredTextParser.g:331:1: ruleIF_Stmt EOF
			{
				before(grammarAccess.getIF_StmtRule());
				pushFollow(FOLLOW_1);
				ruleIF_Stmt();

				state._fsp--;

				after(grammarAccess.getIF_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleIF_Stmt"

	// $ANTLR start "ruleIF_Stmt"
	// InternalStructuredTextParser.g:338:1: ruleIF_Stmt : ( (
	// rule__IF_Stmt__Group__0 ) ) ;
	public final void ruleIF_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:342:2: ( ( ( rule__IF_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:343:2: ( ( rule__IF_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:343:2: ( ( rule__IF_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:344:3: ( rule__IF_Stmt__Group__0 )
				{
					before(grammarAccess.getIF_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:345:3: ( rule__IF_Stmt__Group__0 )
					// InternalStructuredTextParser.g:345:4: rule__IF_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__IF_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getIF_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleIF_Stmt"

	// $ANTLR start "entryRuleELSIF_Clause"
	// InternalStructuredTextParser.g:354:1: entryRuleELSIF_Clause :
	// ruleELSIF_Clause EOF ;
	public final void entryRuleELSIF_Clause() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:355:1: ( ruleELSIF_Clause EOF )
			// InternalStructuredTextParser.g:356:1: ruleELSIF_Clause EOF
			{
				before(grammarAccess.getELSIF_ClauseRule());
				pushFollow(FOLLOW_1);
				ruleELSIF_Clause();

				state._fsp--;

				after(grammarAccess.getELSIF_ClauseRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleELSIF_Clause"

	// $ANTLR start "ruleELSIF_Clause"
	// InternalStructuredTextParser.g:363:1: ruleELSIF_Clause : ( (
	// rule__ELSIF_Clause__Group__0 ) ) ;
	public final void ruleELSIF_Clause() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:367:2: ( ( ( rule__ELSIF_Clause__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:368:2: ( ( rule__ELSIF_Clause__Group__0 ) )
			{
				// InternalStructuredTextParser.g:368:2: ( ( rule__ELSIF_Clause__Group__0 ) )
				// InternalStructuredTextParser.g:369:3: ( rule__ELSIF_Clause__Group__0 )
				{
					before(grammarAccess.getELSIF_ClauseAccess().getGroup());
					// InternalStructuredTextParser.g:370:3: ( rule__ELSIF_Clause__Group__0 )
					// InternalStructuredTextParser.g:370:4: rule__ELSIF_Clause__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__ELSIF_Clause__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getELSIF_ClauseAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleELSIF_Clause"

	// $ANTLR start "entryRuleELSE_Clause"
	// InternalStructuredTextParser.g:379:1: entryRuleELSE_Clause : ruleELSE_Clause
	// EOF ;
	public final void entryRuleELSE_Clause() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:380:1: ( ruleELSE_Clause EOF )
			// InternalStructuredTextParser.g:381:1: ruleELSE_Clause EOF
			{
				before(grammarAccess.getELSE_ClauseRule());
				pushFollow(FOLLOW_1);
				ruleELSE_Clause();

				state._fsp--;

				after(grammarAccess.getELSE_ClauseRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleELSE_Clause"

	// $ANTLR start "ruleELSE_Clause"
	// InternalStructuredTextParser.g:388:1: ruleELSE_Clause : ( (
	// rule__ELSE_Clause__Group__0 ) ) ;
	public final void ruleELSE_Clause() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:392:2: ( ( ( rule__ELSE_Clause__Group__0 ) ) )
			// InternalStructuredTextParser.g:393:2: ( ( rule__ELSE_Clause__Group__0 ) )
			{
				// InternalStructuredTextParser.g:393:2: ( ( rule__ELSE_Clause__Group__0 ) )
				// InternalStructuredTextParser.g:394:3: ( rule__ELSE_Clause__Group__0 )
				{
					before(grammarAccess.getELSE_ClauseAccess().getGroup());
					// InternalStructuredTextParser.g:395:3: ( rule__ELSE_Clause__Group__0 )
					// InternalStructuredTextParser.g:395:4: rule__ELSE_Clause__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__ELSE_Clause__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getELSE_ClauseAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleELSE_Clause"

	// $ANTLR start "entryRuleCase_Stmt"
	// InternalStructuredTextParser.g:404:1: entryRuleCase_Stmt : ruleCase_Stmt EOF
	// ;
	public final void entryRuleCase_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:405:1: ( ruleCase_Stmt EOF )
			// InternalStructuredTextParser.g:406:1: ruleCase_Stmt EOF
			{
				before(grammarAccess.getCase_StmtRule());
				pushFollow(FOLLOW_1);
				ruleCase_Stmt();

				state._fsp--;

				after(grammarAccess.getCase_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleCase_Stmt"

	// $ANTLR start "ruleCase_Stmt"
	// InternalStructuredTextParser.g:413:1: ruleCase_Stmt : ( (
	// rule__Case_Stmt__Group__0 ) ) ;
	public final void ruleCase_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:417:2: ( ( ( rule__Case_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:418:2: ( ( rule__Case_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:418:2: ( ( rule__Case_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:419:3: ( rule__Case_Stmt__Group__0 )
				{
					before(grammarAccess.getCase_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:420:3: ( rule__Case_Stmt__Group__0 )
					// InternalStructuredTextParser.g:420:4: rule__Case_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Case_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getCase_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleCase_Stmt"

	// $ANTLR start "entryRuleCase_Selection"
	// InternalStructuredTextParser.g:429:1: entryRuleCase_Selection :
	// ruleCase_Selection EOF ;
	public final void entryRuleCase_Selection() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:430:1: ( ruleCase_Selection EOF )
			// InternalStructuredTextParser.g:431:1: ruleCase_Selection EOF
			{
				before(grammarAccess.getCase_SelectionRule());
				pushFollow(FOLLOW_1);
				ruleCase_Selection();

				state._fsp--;

				after(grammarAccess.getCase_SelectionRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleCase_Selection"

	// $ANTLR start "ruleCase_Selection"
	// InternalStructuredTextParser.g:438:1: ruleCase_Selection : ( (
	// rule__Case_Selection__Group__0 ) ) ;
	public final void ruleCase_Selection() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:442:2: ( ( ( rule__Case_Selection__Group__0 )
			// ) )
			// InternalStructuredTextParser.g:443:2: ( ( rule__Case_Selection__Group__0 ) )
			{
				// InternalStructuredTextParser.g:443:2: ( ( rule__Case_Selection__Group__0 ) )
				// InternalStructuredTextParser.g:444:3: ( rule__Case_Selection__Group__0 )
				{
					before(grammarAccess.getCase_SelectionAccess().getGroup());
					// InternalStructuredTextParser.g:445:3: ( rule__Case_Selection__Group__0 )
					// InternalStructuredTextParser.g:445:4: rule__Case_Selection__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Case_Selection__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getCase_SelectionAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleCase_Selection"

	// $ANTLR start "entryRuleIteration_Stmt"
	// InternalStructuredTextParser.g:454:1: entryRuleIteration_Stmt :
	// ruleIteration_Stmt EOF ;
	public final void entryRuleIteration_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:455:1: ( ruleIteration_Stmt EOF )
			// InternalStructuredTextParser.g:456:1: ruleIteration_Stmt EOF
			{
				before(grammarAccess.getIteration_StmtRule());
				pushFollow(FOLLOW_1);
				ruleIteration_Stmt();

				state._fsp--;

				after(grammarAccess.getIteration_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleIteration_Stmt"

	// $ANTLR start "ruleIteration_Stmt"
	// InternalStructuredTextParser.g:463:1: ruleIteration_Stmt : ( (
	// rule__Iteration_Stmt__Alternatives ) ) ;
	public final void ruleIteration_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:467:2: ( ( (
			// rule__Iteration_Stmt__Alternatives ) ) )
			// InternalStructuredTextParser.g:468:2: ( ( rule__Iteration_Stmt__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:468:2: ( ( rule__Iteration_Stmt__Alternatives
				// ) )
				// InternalStructuredTextParser.g:469:3: ( rule__Iteration_Stmt__Alternatives )
				{
					before(grammarAccess.getIteration_StmtAccess().getAlternatives());
					// InternalStructuredTextParser.g:470:3: ( rule__Iteration_Stmt__Alternatives )
					// InternalStructuredTextParser.g:470:4: rule__Iteration_Stmt__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Iteration_Stmt__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getIteration_StmtAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleIteration_Stmt"

	// $ANTLR start "entryRuleFor_Stmt"
	// InternalStructuredTextParser.g:479:1: entryRuleFor_Stmt : ruleFor_Stmt EOF ;
	public final void entryRuleFor_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:480:1: ( ruleFor_Stmt EOF )
			// InternalStructuredTextParser.g:481:1: ruleFor_Stmt EOF
			{
				before(grammarAccess.getFor_StmtRule());
				pushFollow(FOLLOW_1);
				ruleFor_Stmt();

				state._fsp--;

				after(grammarAccess.getFor_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleFor_Stmt"

	// $ANTLR start "ruleFor_Stmt"
	// InternalStructuredTextParser.g:488:1: ruleFor_Stmt : ( (
	// rule__For_Stmt__Group__0 ) ) ;
	public final void ruleFor_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:492:2: ( ( ( rule__For_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:493:2: ( ( rule__For_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:493:2: ( ( rule__For_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:494:3: ( rule__For_Stmt__Group__0 )
				{
					before(grammarAccess.getFor_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:495:3: ( rule__For_Stmt__Group__0 )
					// InternalStructuredTextParser.g:495:4: rule__For_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleFor_Stmt"

	// $ANTLR start "entryRuleWhile_Stmt"
	// InternalStructuredTextParser.g:504:1: entryRuleWhile_Stmt : ruleWhile_Stmt
	// EOF ;
	public final void entryRuleWhile_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:505:1: ( ruleWhile_Stmt EOF )
			// InternalStructuredTextParser.g:506:1: ruleWhile_Stmt EOF
			{
				before(grammarAccess.getWhile_StmtRule());
				pushFollow(FOLLOW_1);
				ruleWhile_Stmt();

				state._fsp--;

				after(grammarAccess.getWhile_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleWhile_Stmt"

	// $ANTLR start "ruleWhile_Stmt"
	// InternalStructuredTextParser.g:513:1: ruleWhile_Stmt : ( (
	// rule__While_Stmt__Group__0 ) ) ;
	public final void ruleWhile_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:517:2: ( ( ( rule__While_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:518:2: ( ( rule__While_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:518:2: ( ( rule__While_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:519:3: ( rule__While_Stmt__Group__0 )
				{
					before(grammarAccess.getWhile_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:520:3: ( rule__While_Stmt__Group__0 )
					// InternalStructuredTextParser.g:520:4: rule__While_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__While_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getWhile_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleWhile_Stmt"

	// $ANTLR start "entryRuleRepeat_Stmt"
	// InternalStructuredTextParser.g:529:1: entryRuleRepeat_Stmt : ruleRepeat_Stmt
	// EOF ;
	public final void entryRuleRepeat_Stmt() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:530:1: ( ruleRepeat_Stmt EOF )
			// InternalStructuredTextParser.g:531:1: ruleRepeat_Stmt EOF
			{
				before(grammarAccess.getRepeat_StmtRule());
				pushFollow(FOLLOW_1);
				ruleRepeat_Stmt();

				state._fsp--;

				after(grammarAccess.getRepeat_StmtRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleRepeat_Stmt"

	// $ANTLR start "ruleRepeat_Stmt"
	// InternalStructuredTextParser.g:538:1: ruleRepeat_Stmt : ( (
	// rule__Repeat_Stmt__Group__0 ) ) ;
	public final void ruleRepeat_Stmt() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:542:2: ( ( ( rule__Repeat_Stmt__Group__0 ) ) )
			// InternalStructuredTextParser.g:543:2: ( ( rule__Repeat_Stmt__Group__0 ) )
			{
				// InternalStructuredTextParser.g:543:2: ( ( rule__Repeat_Stmt__Group__0 ) )
				// InternalStructuredTextParser.g:544:3: ( rule__Repeat_Stmt__Group__0 )
				{
					before(grammarAccess.getRepeat_StmtAccess().getGroup());
					// InternalStructuredTextParser.g:545:3: ( rule__Repeat_Stmt__Group__0 )
					// InternalStructuredTextParser.g:545:4: rule__Repeat_Stmt__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Repeat_Stmt__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getRepeat_StmtAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleRepeat_Stmt"

	// $ANTLR start "entryRuleExpression"
	// InternalStructuredTextParser.g:554:1: entryRuleExpression : ruleExpression
	// EOF ;
	public final void entryRuleExpression() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:555:1: ( ruleExpression EOF )
			// InternalStructuredTextParser.g:556:1: ruleExpression EOF
			{
				before(grammarAccess.getExpressionRule());
				pushFollow(FOLLOW_1);
				ruleExpression();

				state._fsp--;

				after(grammarAccess.getExpressionRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleExpression"

	// $ANTLR start "ruleExpression"
	// InternalStructuredTextParser.g:563:1: ruleExpression : ( ruleOr_Expression )
	// ;
	public final void ruleExpression() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:567:2: ( ( ruleOr_Expression ) )
			// InternalStructuredTextParser.g:568:2: ( ruleOr_Expression )
			{
				// InternalStructuredTextParser.g:568:2: ( ruleOr_Expression )
				// InternalStructuredTextParser.g:569:3: ruleOr_Expression
				{
					before(grammarAccess.getExpressionAccess().getOr_ExpressionParserRuleCall());
					pushFollow(FOLLOW_2);
					ruleOr_Expression();

					state._fsp--;

					after(grammarAccess.getExpressionAccess().getOr_ExpressionParserRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleExpression"

	// $ANTLR start "entryRuleOr_Expression"
	// InternalStructuredTextParser.g:579:1: entryRuleOr_Expression :
	// ruleOr_Expression EOF ;
	public final void entryRuleOr_Expression() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:580:1: ( ruleOr_Expression EOF )
			// InternalStructuredTextParser.g:581:1: ruleOr_Expression EOF
			{
				before(grammarAccess.getOr_ExpressionRule());
				pushFollow(FOLLOW_1);
				ruleOr_Expression();

				state._fsp--;

				after(grammarAccess.getOr_ExpressionRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleOr_Expression"

	// $ANTLR start "ruleOr_Expression"
	// InternalStructuredTextParser.g:588:1: ruleOr_Expression : ( (
	// rule__Or_Expression__Group__0 ) ) ;
	public final void ruleOr_Expression() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:592:2: ( ( ( rule__Or_Expression__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:593:2: ( ( rule__Or_Expression__Group__0 ) )
			{
				// InternalStructuredTextParser.g:593:2: ( ( rule__Or_Expression__Group__0 ) )
				// InternalStructuredTextParser.g:594:3: ( rule__Or_Expression__Group__0 )
				{
					before(grammarAccess.getOr_ExpressionAccess().getGroup());
					// InternalStructuredTextParser.g:595:3: ( rule__Or_Expression__Group__0 )
					// InternalStructuredTextParser.g:595:4: rule__Or_Expression__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Or_Expression__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getOr_ExpressionAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleOr_Expression"

	// $ANTLR start "entryRuleXor_Expr"
	// InternalStructuredTextParser.g:604:1: entryRuleXor_Expr : ruleXor_Expr EOF ;
	public final void entryRuleXor_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:605:1: ( ruleXor_Expr EOF )
			// InternalStructuredTextParser.g:606:1: ruleXor_Expr EOF
			{
				before(grammarAccess.getXor_ExprRule());
				pushFollow(FOLLOW_1);
				ruleXor_Expr();

				state._fsp--;

				after(grammarAccess.getXor_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleXor_Expr"

	// $ANTLR start "ruleXor_Expr"
	// InternalStructuredTextParser.g:613:1: ruleXor_Expr : ( (
	// rule__Xor_Expr__Group__0 ) ) ;
	public final void ruleXor_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:617:2: ( ( ( rule__Xor_Expr__Group__0 ) ) )
			// InternalStructuredTextParser.g:618:2: ( ( rule__Xor_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:618:2: ( ( rule__Xor_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:619:3: ( rule__Xor_Expr__Group__0 )
				{
					before(grammarAccess.getXor_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:620:3: ( rule__Xor_Expr__Group__0 )
					// InternalStructuredTextParser.g:620:4: rule__Xor_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Xor_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getXor_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleXor_Expr"

	// $ANTLR start "entryRuleAnd_Expr"
	// InternalStructuredTextParser.g:629:1: entryRuleAnd_Expr : ruleAnd_Expr EOF ;
	public final void entryRuleAnd_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:630:1: ( ruleAnd_Expr EOF )
			// InternalStructuredTextParser.g:631:1: ruleAnd_Expr EOF
			{
				before(grammarAccess.getAnd_ExprRule());
				pushFollow(FOLLOW_1);
				ruleAnd_Expr();

				state._fsp--;

				after(grammarAccess.getAnd_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAnd_Expr"

	// $ANTLR start "ruleAnd_Expr"
	// InternalStructuredTextParser.g:638:1: ruleAnd_Expr : ( (
	// rule__And_Expr__Group__0 ) ) ;
	public final void ruleAnd_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:642:2: ( ( ( rule__And_Expr__Group__0 ) ) )
			// InternalStructuredTextParser.g:643:2: ( ( rule__And_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:643:2: ( ( rule__And_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:644:3: ( rule__And_Expr__Group__0 )
				{
					before(grammarAccess.getAnd_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:645:3: ( rule__And_Expr__Group__0 )
					// InternalStructuredTextParser.g:645:4: rule__And_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__And_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getAnd_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAnd_Expr"

	// $ANTLR start "entryRuleCompare_Expr"
	// InternalStructuredTextParser.g:654:1: entryRuleCompare_Expr :
	// ruleCompare_Expr EOF ;
	public final void entryRuleCompare_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:655:1: ( ruleCompare_Expr EOF )
			// InternalStructuredTextParser.g:656:1: ruleCompare_Expr EOF
			{
				before(grammarAccess.getCompare_ExprRule());
				pushFollow(FOLLOW_1);
				ruleCompare_Expr();

				state._fsp--;

				after(grammarAccess.getCompare_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleCompare_Expr"

	// $ANTLR start "ruleCompare_Expr"
	// InternalStructuredTextParser.g:663:1: ruleCompare_Expr : ( (
	// rule__Compare_Expr__Group__0 ) ) ;
	public final void ruleCompare_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:667:2: ( ( ( rule__Compare_Expr__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:668:2: ( ( rule__Compare_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:668:2: ( ( rule__Compare_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:669:3: ( rule__Compare_Expr__Group__0 )
				{
					before(grammarAccess.getCompare_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:670:3: ( rule__Compare_Expr__Group__0 )
					// InternalStructuredTextParser.g:670:4: rule__Compare_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Compare_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getCompare_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleCompare_Expr"

	// $ANTLR start "entryRuleEqu_Expr"
	// InternalStructuredTextParser.g:679:1: entryRuleEqu_Expr : ruleEqu_Expr EOF ;
	public final void entryRuleEqu_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:680:1: ( ruleEqu_Expr EOF )
			// InternalStructuredTextParser.g:681:1: ruleEqu_Expr EOF
			{
				before(grammarAccess.getEqu_ExprRule());
				pushFollow(FOLLOW_1);
				ruleEqu_Expr();

				state._fsp--;

				after(grammarAccess.getEqu_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleEqu_Expr"

	// $ANTLR start "ruleEqu_Expr"
	// InternalStructuredTextParser.g:688:1: ruleEqu_Expr : ( (
	// rule__Equ_Expr__Group__0 ) ) ;
	public final void ruleEqu_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:692:2: ( ( ( rule__Equ_Expr__Group__0 ) ) )
			// InternalStructuredTextParser.g:693:2: ( ( rule__Equ_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:693:2: ( ( rule__Equ_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:694:3: ( rule__Equ_Expr__Group__0 )
				{
					before(grammarAccess.getEqu_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:695:3: ( rule__Equ_Expr__Group__0 )
					// InternalStructuredTextParser.g:695:4: rule__Equ_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Equ_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getEqu_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleEqu_Expr"

	// $ANTLR start "entryRuleAdd_Expr"
	// InternalStructuredTextParser.g:704:1: entryRuleAdd_Expr : ruleAdd_Expr EOF ;
	public final void entryRuleAdd_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:705:1: ( ruleAdd_Expr EOF )
			// InternalStructuredTextParser.g:706:1: ruleAdd_Expr EOF
			{
				before(grammarAccess.getAdd_ExprRule());
				pushFollow(FOLLOW_1);
				ruleAdd_Expr();

				state._fsp--;

				after(grammarAccess.getAdd_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAdd_Expr"

	// $ANTLR start "ruleAdd_Expr"
	// InternalStructuredTextParser.g:713:1: ruleAdd_Expr : ( (
	// rule__Add_Expr__Group__0 ) ) ;
	public final void ruleAdd_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:717:2: ( ( ( rule__Add_Expr__Group__0 ) ) )
			// InternalStructuredTextParser.g:718:2: ( ( rule__Add_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:718:2: ( ( rule__Add_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:719:3: ( rule__Add_Expr__Group__0 )
				{
					before(grammarAccess.getAdd_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:720:3: ( rule__Add_Expr__Group__0 )
					// InternalStructuredTextParser.g:720:4: rule__Add_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Add_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getAdd_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAdd_Expr"

	// $ANTLR start "entryRuleTerm"
	// InternalStructuredTextParser.g:729:1: entryRuleTerm : ruleTerm EOF ;
	public final void entryRuleTerm() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:730:1: ( ruleTerm EOF )
			// InternalStructuredTextParser.g:731:1: ruleTerm EOF
			{
				before(grammarAccess.getTermRule());
				pushFollow(FOLLOW_1);
				ruleTerm();

				state._fsp--;

				after(grammarAccess.getTermRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTerm"

	// $ANTLR start "ruleTerm"
	// InternalStructuredTextParser.g:738:1: ruleTerm : ( ( rule__Term__Group__0 ) )
	// ;
	public final void ruleTerm() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:742:2: ( ( ( rule__Term__Group__0 ) ) )
			// InternalStructuredTextParser.g:743:2: ( ( rule__Term__Group__0 ) )
			{
				// InternalStructuredTextParser.g:743:2: ( ( rule__Term__Group__0 ) )
				// InternalStructuredTextParser.g:744:3: ( rule__Term__Group__0 )
				{
					before(grammarAccess.getTermAccess().getGroup());
					// InternalStructuredTextParser.g:745:3: ( rule__Term__Group__0 )
					// InternalStructuredTextParser.g:745:4: rule__Term__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Term__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getTermAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTerm"

	// $ANTLR start "entryRulePower_Expr"
	// InternalStructuredTextParser.g:754:1: entryRulePower_Expr : rulePower_Expr
	// EOF ;
	public final void entryRulePower_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:755:1: ( rulePower_Expr EOF )
			// InternalStructuredTextParser.g:756:1: rulePower_Expr EOF
			{
				before(grammarAccess.getPower_ExprRule());
				pushFollow(FOLLOW_1);
				rulePower_Expr();

				state._fsp--;

				after(grammarAccess.getPower_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRulePower_Expr"

	// $ANTLR start "rulePower_Expr"
	// InternalStructuredTextParser.g:763:1: rulePower_Expr : ( (
	// rule__Power_Expr__Group__0 ) ) ;
	public final void rulePower_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:767:2: ( ( ( rule__Power_Expr__Group__0 ) ) )
			// InternalStructuredTextParser.g:768:2: ( ( rule__Power_Expr__Group__0 ) )
			{
				// InternalStructuredTextParser.g:768:2: ( ( rule__Power_Expr__Group__0 ) )
				// InternalStructuredTextParser.g:769:3: ( rule__Power_Expr__Group__0 )
				{
					before(grammarAccess.getPower_ExprAccess().getGroup());
					// InternalStructuredTextParser.g:770:3: ( rule__Power_Expr__Group__0 )
					// InternalStructuredTextParser.g:770:4: rule__Power_Expr__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Power_Expr__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getPower_ExprAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rulePower_Expr"

	// $ANTLR start "entryRuleUnary_Expr"
	// InternalStructuredTextParser.g:779:1: entryRuleUnary_Expr : ruleUnary_Expr
	// EOF ;
	public final void entryRuleUnary_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:780:1: ( ruleUnary_Expr EOF )
			// InternalStructuredTextParser.g:781:1: ruleUnary_Expr EOF
			{
				before(grammarAccess.getUnary_ExprRule());
				pushFollow(FOLLOW_1);
				ruleUnary_Expr();

				state._fsp--;

				after(grammarAccess.getUnary_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleUnary_Expr"

	// $ANTLR start "ruleUnary_Expr"
	// InternalStructuredTextParser.g:788:1: ruleUnary_Expr : ( (
	// rule__Unary_Expr__Alternatives ) ) ;
	public final void ruleUnary_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:792:2: ( ( ( rule__Unary_Expr__Alternatives )
			// ) )
			// InternalStructuredTextParser.g:793:2: ( ( rule__Unary_Expr__Alternatives ) )
			{
				// InternalStructuredTextParser.g:793:2: ( ( rule__Unary_Expr__Alternatives ) )
				// InternalStructuredTextParser.g:794:3: ( rule__Unary_Expr__Alternatives )
				{
					before(grammarAccess.getUnary_ExprAccess().getAlternatives());
					// InternalStructuredTextParser.g:795:3: ( rule__Unary_Expr__Alternatives )
					// InternalStructuredTextParser.g:795:4: rule__Unary_Expr__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Unary_Expr__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getUnary_ExprAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleUnary_Expr"

	// $ANTLR start "entryRulePrimary_Expr"
	// InternalStructuredTextParser.g:804:1: entryRulePrimary_Expr :
	// rulePrimary_Expr EOF ;
	public final void entryRulePrimary_Expr() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:805:1: ( rulePrimary_Expr EOF )
			// InternalStructuredTextParser.g:806:1: rulePrimary_Expr EOF
			{
				before(grammarAccess.getPrimary_ExprRule());
				pushFollow(FOLLOW_1);
				rulePrimary_Expr();

				state._fsp--;

				after(grammarAccess.getPrimary_ExprRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRulePrimary_Expr"

	// $ANTLR start "rulePrimary_Expr"
	// InternalStructuredTextParser.g:813:1: rulePrimary_Expr : ( (
	// rule__Primary_Expr__Alternatives ) ) ;
	public final void rulePrimary_Expr() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:817:2: ( ( ( rule__Primary_Expr__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:818:2: ( ( rule__Primary_Expr__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:818:2: ( ( rule__Primary_Expr__Alternatives )
				// )
				// InternalStructuredTextParser.g:819:3: ( rule__Primary_Expr__Alternatives )
				{
					before(grammarAccess.getPrimary_ExprAccess().getAlternatives());
					// InternalStructuredTextParser.g:820:3: ( rule__Primary_Expr__Alternatives )
					// InternalStructuredTextParser.g:820:4: rule__Primary_Expr__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Primary_Expr__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getPrimary_ExprAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rulePrimary_Expr"

	// $ANTLR start "entryRuleFunc_Call"
	// InternalStructuredTextParser.g:829:1: entryRuleFunc_Call : ruleFunc_Call EOF
	// ;
	public final void entryRuleFunc_Call() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:830:1: ( ruleFunc_Call EOF )
			// InternalStructuredTextParser.g:831:1: ruleFunc_Call EOF
			{
				before(grammarAccess.getFunc_CallRule());
				pushFollow(FOLLOW_1);
				ruleFunc_Call();

				state._fsp--;

				after(grammarAccess.getFunc_CallRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleFunc_Call"

	// $ANTLR start "ruleFunc_Call"
	// InternalStructuredTextParser.g:838:1: ruleFunc_Call : ( (
	// rule__Func_Call__Group__0 ) ) ;
	public final void ruleFunc_Call() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:842:2: ( ( ( rule__Func_Call__Group__0 ) ) )
			// InternalStructuredTextParser.g:843:2: ( ( rule__Func_Call__Group__0 ) )
			{
				// InternalStructuredTextParser.g:843:2: ( ( rule__Func_Call__Group__0 ) )
				// InternalStructuredTextParser.g:844:3: ( rule__Func_Call__Group__0 )
				{
					before(grammarAccess.getFunc_CallAccess().getGroup());
					// InternalStructuredTextParser.g:845:3: ( rule__Func_Call__Group__0 )
					// InternalStructuredTextParser.g:845:4: rule__Func_Call__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getFunc_CallAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleFunc_Call"

	// $ANTLR start "entryRuleParam_Assign"
	// InternalStructuredTextParser.g:854:1: entryRuleParam_Assign :
	// ruleParam_Assign EOF ;
	public final void entryRuleParam_Assign() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:855:1: ( ruleParam_Assign EOF )
			// InternalStructuredTextParser.g:856:1: ruleParam_Assign EOF
			{
				before(grammarAccess.getParam_AssignRule());
				pushFollow(FOLLOW_1);
				ruleParam_Assign();

				state._fsp--;

				after(grammarAccess.getParam_AssignRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleParam_Assign"

	// $ANTLR start "ruleParam_Assign"
	// InternalStructuredTextParser.g:863:1: ruleParam_Assign : ( (
	// rule__Param_Assign__Alternatives ) ) ;
	public final void ruleParam_Assign() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:867:2: ( ( ( rule__Param_Assign__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:868:2: ( ( rule__Param_Assign__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:868:2: ( ( rule__Param_Assign__Alternatives )
				// )
				// InternalStructuredTextParser.g:869:3: ( rule__Param_Assign__Alternatives )
				{
					before(grammarAccess.getParam_AssignAccess().getAlternatives());
					// InternalStructuredTextParser.g:870:3: ( rule__Param_Assign__Alternatives )
					// InternalStructuredTextParser.g:870:4: rule__Param_Assign__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getParam_AssignAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleParam_Assign"

	// $ANTLR start "entryRuleParam_Assign_In"
	// InternalStructuredTextParser.g:879:1: entryRuleParam_Assign_In :
	// ruleParam_Assign_In EOF ;
	public final void entryRuleParam_Assign_In() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:880:1: ( ruleParam_Assign_In EOF )
			// InternalStructuredTextParser.g:881:1: ruleParam_Assign_In EOF
			{
				before(grammarAccess.getParam_Assign_InRule());
				pushFollow(FOLLOW_1);
				ruleParam_Assign_In();

				state._fsp--;

				after(grammarAccess.getParam_Assign_InRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleParam_Assign_In"

	// $ANTLR start "ruleParam_Assign_In"
	// InternalStructuredTextParser.g:888:1: ruleParam_Assign_In : ( (
	// rule__Param_Assign_In__Group__0 ) ) ;
	public final void ruleParam_Assign_In() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:892:2: ( ( ( rule__Param_Assign_In__Group__0 )
			// ) )
			// InternalStructuredTextParser.g:893:2: ( ( rule__Param_Assign_In__Group__0 ) )
			{
				// InternalStructuredTextParser.g:893:2: ( ( rule__Param_Assign_In__Group__0 ) )
				// InternalStructuredTextParser.g:894:3: ( rule__Param_Assign_In__Group__0 )
				{
					before(grammarAccess.getParam_Assign_InAccess().getGroup());
					// InternalStructuredTextParser.g:895:3: ( rule__Param_Assign_In__Group__0 )
					// InternalStructuredTextParser.g:895:4: rule__Param_Assign_In__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_In__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_InAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleParam_Assign_In"

	// $ANTLR start "entryRuleParam_Assign_Out"
	// InternalStructuredTextParser.g:904:1: entryRuleParam_Assign_Out :
	// ruleParam_Assign_Out EOF ;
	public final void entryRuleParam_Assign_Out() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:905:1: ( ruleParam_Assign_Out EOF )
			// InternalStructuredTextParser.g:906:1: ruleParam_Assign_Out EOF
			{
				before(grammarAccess.getParam_Assign_OutRule());
				pushFollow(FOLLOW_1);
				ruleParam_Assign_Out();

				state._fsp--;

				after(grammarAccess.getParam_Assign_OutRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleParam_Assign_Out"

	// $ANTLR start "ruleParam_Assign_Out"
	// InternalStructuredTextParser.g:913:1: ruleParam_Assign_Out : ( (
	// rule__Param_Assign_Out__Group__0 ) ) ;
	public final void ruleParam_Assign_Out() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:917:2: ( ( ( rule__Param_Assign_Out__Group__0
			// ) ) )
			// InternalStructuredTextParser.g:918:2: ( ( rule__Param_Assign_Out__Group__0 )
			// )
			{
				// InternalStructuredTextParser.g:918:2: ( ( rule__Param_Assign_Out__Group__0 )
				// )
				// InternalStructuredTextParser.g:919:3: ( rule__Param_Assign_Out__Group__0 )
				{
					before(grammarAccess.getParam_Assign_OutAccess().getGroup());
					// InternalStructuredTextParser.g:920:3: ( rule__Param_Assign_Out__Group__0 )
					// InternalStructuredTextParser.g:920:4: rule__Param_Assign_Out__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_Out__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_OutAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleParam_Assign_Out"

	// $ANTLR start "entryRuleVariable"
	// InternalStructuredTextParser.g:929:1: entryRuleVariable : ruleVariable EOF ;
	public final void entryRuleVariable() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:930:1: ( ruleVariable EOF )
			// InternalStructuredTextParser.g:931:1: ruleVariable EOF
			{
				before(grammarAccess.getVariableRule());
				pushFollow(FOLLOW_1);
				ruleVariable();

				state._fsp--;

				after(grammarAccess.getVariableRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVariable"

	// $ANTLR start "ruleVariable"
	// InternalStructuredTextParser.g:938:1: ruleVariable : ( ruleVariable_Subscript
	// ) ;
	public final void ruleVariable() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:942:2: ( ( ruleVariable_Subscript ) )
			// InternalStructuredTextParser.g:943:2: ( ruleVariable_Subscript )
			{
				// InternalStructuredTextParser.g:943:2: ( ruleVariable_Subscript )
				// InternalStructuredTextParser.g:944:3: ruleVariable_Subscript
				{
					before(grammarAccess.getVariableAccess().getVariable_SubscriptParserRuleCall());
					pushFollow(FOLLOW_2);
					ruleVariable_Subscript();

					state._fsp--;

					after(grammarAccess.getVariableAccess().getVariable_SubscriptParserRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVariable"

	// $ANTLR start "entryRuleVariable_Subscript"
	// InternalStructuredTextParser.g:954:1: entryRuleVariable_Subscript :
	// ruleVariable_Subscript EOF ;
	public final void entryRuleVariable_Subscript() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:955:1: ( ruleVariable_Subscript EOF )
			// InternalStructuredTextParser.g:956:1: ruleVariable_Subscript EOF
			{
				before(grammarAccess.getVariable_SubscriptRule());
				pushFollow(FOLLOW_1);
				ruleVariable_Subscript();

				state._fsp--;

				after(grammarAccess.getVariable_SubscriptRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVariable_Subscript"

	// $ANTLR start "ruleVariable_Subscript"
	// InternalStructuredTextParser.g:963:1: ruleVariable_Subscript : ( (
	// rule__Variable_Subscript__Group__0 ) ) ;
	public final void ruleVariable_Subscript() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:967:2: ( ( (
			// rule__Variable_Subscript__Group__0 ) ) )
			// InternalStructuredTextParser.g:968:2: ( ( rule__Variable_Subscript__Group__0
			// ) )
			{
				// InternalStructuredTextParser.g:968:2: ( ( rule__Variable_Subscript__Group__0
				// ) )
				// InternalStructuredTextParser.g:969:3: ( rule__Variable_Subscript__Group__0 )
				{
					before(grammarAccess.getVariable_SubscriptAccess().getGroup());
					// InternalStructuredTextParser.g:970:3: ( rule__Variable_Subscript__Group__0 )
					// InternalStructuredTextParser.g:970:4: rule__Variable_Subscript__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Subscript__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getVariable_SubscriptAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVariable_Subscript"

	// $ANTLR start "entryRuleVariable_Adapter"
	// InternalStructuredTextParser.g:979:1: entryRuleVariable_Adapter :
	// ruleVariable_Adapter EOF ;
	public final void entryRuleVariable_Adapter() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:980:1: ( ruleVariable_Adapter EOF )
			// InternalStructuredTextParser.g:981:1: ruleVariable_Adapter EOF
			{
				before(grammarAccess.getVariable_AdapterRule());
				pushFollow(FOLLOW_1);
				ruleVariable_Adapter();

				state._fsp--;

				after(grammarAccess.getVariable_AdapterRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVariable_Adapter"

	// $ANTLR start "ruleVariable_Adapter"
	// InternalStructuredTextParser.g:988:1: ruleVariable_Adapter : ( (
	// rule__Variable_Adapter__Group__0 ) ) ;
	public final void ruleVariable_Adapter() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:992:2: ( ( ( rule__Variable_Adapter__Group__0
			// ) ) )
			// InternalStructuredTextParser.g:993:2: ( ( rule__Variable_Adapter__Group__0 )
			// )
			{
				// InternalStructuredTextParser.g:993:2: ( ( rule__Variable_Adapter__Group__0 )
				// )
				// InternalStructuredTextParser.g:994:3: ( rule__Variable_Adapter__Group__0 )
				{
					before(grammarAccess.getVariable_AdapterAccess().getGroup());
					// InternalStructuredTextParser.g:995:3: ( rule__Variable_Adapter__Group__0 )
					// InternalStructuredTextParser.g:995:4: rule__Variable_Adapter__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Adapter__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getVariable_AdapterAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVariable_Adapter"

	// $ANTLR start "entryRuleAdapter_Name"
	// InternalStructuredTextParser.g:1004:1: entryRuleAdapter_Name :
	// ruleAdapter_Name EOF ;
	public final void entryRuleAdapter_Name() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1005:1: ( ruleAdapter_Name EOF )
			// InternalStructuredTextParser.g:1006:1: ruleAdapter_Name EOF
			{
				before(grammarAccess.getAdapter_NameRule());
				pushFollow(FOLLOW_1);
				ruleAdapter_Name();

				state._fsp--;

				after(grammarAccess.getAdapter_NameRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleAdapter_Name"

	// $ANTLR start "ruleAdapter_Name"
	// InternalStructuredTextParser.g:1013:1: ruleAdapter_Name : ( (
	// rule__Adapter_Name__Alternatives ) ) ;
	public final void ruleAdapter_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1017:2: ( ( ( rule__Adapter_Name__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:1018:2: ( ( rule__Adapter_Name__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:1018:2: ( ( rule__Adapter_Name__Alternatives )
				// )
				// InternalStructuredTextParser.g:1019:3: ( rule__Adapter_Name__Alternatives )
				{
					before(grammarAccess.getAdapter_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1020:3: ( rule__Adapter_Name__Alternatives )
					// InternalStructuredTextParser.g:1020:4: rule__Adapter_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Adapter_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getAdapter_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAdapter_Name"

	// $ANTLR start "entryRuleVariable_Primary"
	// InternalStructuredTextParser.g:1029:1: entryRuleVariable_Primary :
	// ruleVariable_Primary EOF ;
	public final void entryRuleVariable_Primary() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1030:1: ( ruleVariable_Primary EOF )
			// InternalStructuredTextParser.g:1031:1: ruleVariable_Primary EOF
			{
				before(grammarAccess.getVariable_PrimaryRule());
				pushFollow(FOLLOW_1);
				ruleVariable_Primary();

				state._fsp--;

				after(grammarAccess.getVariable_PrimaryRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVariable_Primary"

	// $ANTLR start "ruleVariable_Primary"
	// InternalStructuredTextParser.g:1038:1: ruleVariable_Primary : ( (
	// rule__Variable_Primary__VarAssignment ) ) ;
	public final void ruleVariable_Primary() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1042:2: ( ( (
			// rule__Variable_Primary__VarAssignment ) ) )
			// InternalStructuredTextParser.g:1043:2: ( (
			// rule__Variable_Primary__VarAssignment ) )
			{
				// InternalStructuredTextParser.g:1043:2: ( (
				// rule__Variable_Primary__VarAssignment ) )
				// InternalStructuredTextParser.g:1044:3: (
				// rule__Variable_Primary__VarAssignment )
				{
					before(grammarAccess.getVariable_PrimaryAccess().getVarAssignment());
					// InternalStructuredTextParser.g:1045:3: (
					// rule__Variable_Primary__VarAssignment )
					// InternalStructuredTextParser.g:1045:4: rule__Variable_Primary__VarAssignment
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Primary__VarAssignment();

						state._fsp--;

					}

					after(grammarAccess.getVariable_PrimaryAccess().getVarAssignment());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVariable_Primary"

	// $ANTLR start "entryRuleVariable_Name"
	// InternalStructuredTextParser.g:1054:1: entryRuleVariable_Name :
	// ruleVariable_Name EOF ;
	public final void entryRuleVariable_Name() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1055:1: ( ruleVariable_Name EOF )
			// InternalStructuredTextParser.g:1056:1: ruleVariable_Name EOF
			{
				before(grammarAccess.getVariable_NameRule());
				pushFollow(FOLLOW_1);
				ruleVariable_Name();

				state._fsp--;

				after(grammarAccess.getVariable_NameRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleVariable_Name"

	// $ANTLR start "ruleVariable_Name"
	// InternalStructuredTextParser.g:1063:1: ruleVariable_Name : ( (
	// rule__Variable_Name__Alternatives ) ) ;
	public final void ruleVariable_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1067:2: ( ( (
			// rule__Variable_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1068:2: ( ( rule__Variable_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1068:2: ( ( rule__Variable_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1069:3: ( rule__Variable_Name__Alternatives )
				{
					before(grammarAccess.getVariable_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1070:3: ( rule__Variable_Name__Alternatives )
					// InternalStructuredTextParser.g:1070:4: rule__Variable_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getVariable_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleVariable_Name"

	// $ANTLR start "entryRuleConstant"
	// InternalStructuredTextParser.g:1079:1: entryRuleConstant : ruleConstant EOF ;
	public final void entryRuleConstant() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1080:1: ( ruleConstant EOF )
			// InternalStructuredTextParser.g:1081:1: ruleConstant EOF
			{
				before(grammarAccess.getConstantRule());
				pushFollow(FOLLOW_1);
				ruleConstant();

				state._fsp--;

				after(grammarAccess.getConstantRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleConstant"

	// $ANTLR start "ruleConstant"
	// InternalStructuredTextParser.g:1088:1: ruleConstant : ( (
	// rule__Constant__Alternatives ) ) ;
	public final void ruleConstant() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1092:2: ( ( ( rule__Constant__Alternatives ) )
			// )
			// InternalStructuredTextParser.g:1093:2: ( ( rule__Constant__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1093:2: ( ( rule__Constant__Alternatives ) )
				// InternalStructuredTextParser.g:1094:3: ( rule__Constant__Alternatives )
				{
					before(grammarAccess.getConstantAccess().getAlternatives());
					// InternalStructuredTextParser.g:1095:3: ( rule__Constant__Alternatives )
					// InternalStructuredTextParser.g:1095:4: rule__Constant__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Constant__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getConstantAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleConstant"

	// $ANTLR start "entryRuleNumeric_Literal"
	// InternalStructuredTextParser.g:1104:1: entryRuleNumeric_Literal :
	// ruleNumeric_Literal EOF ;
	public final void entryRuleNumeric_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1105:1: ( ruleNumeric_Literal EOF )
			// InternalStructuredTextParser.g:1106:1: ruleNumeric_Literal EOF
			{
				before(grammarAccess.getNumeric_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleNumeric_Literal();

				state._fsp--;

				after(grammarAccess.getNumeric_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleNumeric_Literal"

	// $ANTLR start "ruleNumeric_Literal"
	// InternalStructuredTextParser.g:1113:1: ruleNumeric_Literal : ( (
	// rule__Numeric_Literal__Alternatives ) ) ;
	public final void ruleNumeric_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1117:2: ( ( (
			// rule__Numeric_Literal__Alternatives ) ) )
			// InternalStructuredTextParser.g:1118:2: ( (
			// rule__Numeric_Literal__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1118:2: ( (
				// rule__Numeric_Literal__Alternatives ) )
				// InternalStructuredTextParser.g:1119:3: ( rule__Numeric_Literal__Alternatives
				// )
				{
					before(grammarAccess.getNumeric_LiteralAccess().getAlternatives());
					// InternalStructuredTextParser.g:1120:3: ( rule__Numeric_Literal__Alternatives
					// )
					// InternalStructuredTextParser.g:1120:4: rule__Numeric_Literal__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Numeric_Literal__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getNumeric_LiteralAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleNumeric_Literal"

	// $ANTLR start "entryRuleInt_Literal"
	// InternalStructuredTextParser.g:1129:1: entryRuleInt_Literal : ruleInt_Literal
	// EOF ;
	public final void entryRuleInt_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1130:1: ( ruleInt_Literal EOF )
			// InternalStructuredTextParser.g:1131:1: ruleInt_Literal EOF
			{
				before(grammarAccess.getInt_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleInt_Literal();

				state._fsp--;

				after(grammarAccess.getInt_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleInt_Literal"

	// $ANTLR start "ruleInt_Literal"
	// InternalStructuredTextParser.g:1138:1: ruleInt_Literal : ( (
	// rule__Int_Literal__Group__0 ) ) ;
	public final void ruleInt_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1142:2: ( ( ( rule__Int_Literal__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1143:2: ( ( rule__Int_Literal__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1143:2: ( ( rule__Int_Literal__Group__0 ) )
				// InternalStructuredTextParser.g:1144:3: ( rule__Int_Literal__Group__0 )
				{
					before(grammarAccess.getInt_LiteralAccess().getGroup());
					// InternalStructuredTextParser.g:1145:3: ( rule__Int_Literal__Group__0 )
					// InternalStructuredTextParser.g:1145:4: rule__Int_Literal__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Int_Literal__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getInt_LiteralAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleInt_Literal"

	// $ANTLR start "entryRuleSigned_Int"
	// InternalStructuredTextParser.g:1154:1: entryRuleSigned_Int : ruleSigned_Int
	// EOF ;
	public final void entryRuleSigned_Int() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1155:1: ( ruleSigned_Int EOF )
			// InternalStructuredTextParser.g:1156:1: ruleSigned_Int EOF
			{
				before(grammarAccess.getSigned_IntRule());
				pushFollow(FOLLOW_1);
				ruleSigned_Int();

				state._fsp--;

				after(grammarAccess.getSigned_IntRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleSigned_Int"

	// $ANTLR start "ruleSigned_Int"
	// InternalStructuredTextParser.g:1163:1: ruleSigned_Int : ( (
	// rule__Signed_Int__Group__0 ) ) ;
	public final void ruleSigned_Int() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1167:2: ( ( ( rule__Signed_Int__Group__0 ) ) )
			// InternalStructuredTextParser.g:1168:2: ( ( rule__Signed_Int__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1168:2: ( ( rule__Signed_Int__Group__0 ) )
				// InternalStructuredTextParser.g:1169:3: ( rule__Signed_Int__Group__0 )
				{
					before(grammarAccess.getSigned_IntAccess().getGroup());
					// InternalStructuredTextParser.g:1170:3: ( rule__Signed_Int__Group__0 )
					// InternalStructuredTextParser.g:1170:4: rule__Signed_Int__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Signed_Int__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getSigned_IntAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleSigned_Int"

	// $ANTLR start "entryRuleArray_Size"
	// InternalStructuredTextParser.g:1179:1: entryRuleArray_Size : ruleArray_Size
	// EOF ;
	public final void entryRuleArray_Size() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1180:1: ( ruleArray_Size EOF )
			// InternalStructuredTextParser.g:1181:1: ruleArray_Size EOF
			{
				before(grammarAccess.getArray_SizeRule());
				pushFollow(FOLLOW_1);
				ruleArray_Size();

				state._fsp--;

				after(grammarAccess.getArray_SizeRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleArray_Size"

	// $ANTLR start "ruleArray_Size"
	// InternalStructuredTextParser.g:1188:1: ruleArray_Size : ( RULE_UNSIGNED_INT )
	// ;
	public final void ruleArray_Size() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1192:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1193:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1193:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1194:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getArray_SizeAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getArray_SizeAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleArray_Size"

	// $ANTLR start "entryRuleReal_Literal"
	// InternalStructuredTextParser.g:1204:1: entryRuleReal_Literal :
	// ruleReal_Literal EOF ;
	public final void entryRuleReal_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1205:1: ( ruleReal_Literal EOF )
			// InternalStructuredTextParser.g:1206:1: ruleReal_Literal EOF
			{
				before(grammarAccess.getReal_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleReal_Literal();

				state._fsp--;

				after(grammarAccess.getReal_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleReal_Literal"

	// $ANTLR start "ruleReal_Literal"
	// InternalStructuredTextParser.g:1213:1: ruleReal_Literal : ( (
	// rule__Real_Literal__Group__0 ) ) ;
	public final void ruleReal_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1217:2: ( ( ( rule__Real_Literal__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1218:2: ( ( rule__Real_Literal__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1218:2: ( ( rule__Real_Literal__Group__0 ) )
				// InternalStructuredTextParser.g:1219:3: ( rule__Real_Literal__Group__0 )
				{
					before(grammarAccess.getReal_LiteralAccess().getGroup());
					// InternalStructuredTextParser.g:1220:3: ( rule__Real_Literal__Group__0 )
					// InternalStructuredTextParser.g:1220:4: rule__Real_Literal__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Real_Literal__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getReal_LiteralAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleReal_Literal"

	// $ANTLR start "entryRuleReal_Value"
	// InternalStructuredTextParser.g:1229:1: entryRuleReal_Value : ruleReal_Value
	// EOF ;
	public final void entryRuleReal_Value() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1230:1: ( ruleReal_Value EOF )
			// InternalStructuredTextParser.g:1231:1: ruleReal_Value EOF
			{
				before(grammarAccess.getReal_ValueRule());
				pushFollow(FOLLOW_1);
				ruleReal_Value();

				state._fsp--;

				after(grammarAccess.getReal_ValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleReal_Value"

	// $ANTLR start "ruleReal_Value"
	// InternalStructuredTextParser.g:1238:1: ruleReal_Value : ( (
	// rule__Real_Value__Group__0 ) ) ;
	public final void ruleReal_Value() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1242:2: ( ( ( rule__Real_Value__Group__0 ) ) )
			// InternalStructuredTextParser.g:1243:2: ( ( rule__Real_Value__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1243:2: ( ( rule__Real_Value__Group__0 ) )
				// InternalStructuredTextParser.g:1244:3: ( rule__Real_Value__Group__0 )
				{
					before(grammarAccess.getReal_ValueAccess().getGroup());
					// InternalStructuredTextParser.g:1245:3: ( rule__Real_Value__Group__0 )
					// InternalStructuredTextParser.g:1245:4: rule__Real_Value__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Real_Value__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getReal_ValueAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleReal_Value"

	// $ANTLR start "entryRuleBool_Literal"
	// InternalStructuredTextParser.g:1254:1: entryRuleBool_Literal :
	// ruleBool_Literal EOF ;
	public final void entryRuleBool_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1255:1: ( ruleBool_Literal EOF )
			// InternalStructuredTextParser.g:1256:1: ruleBool_Literal EOF
			{
				before(grammarAccess.getBool_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleBool_Literal();

				state._fsp--;

				after(grammarAccess.getBool_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleBool_Literal"

	// $ANTLR start "ruleBool_Literal"
	// InternalStructuredTextParser.g:1263:1: ruleBool_Literal : ( (
	// rule__Bool_Literal__Group__0 ) ) ;
	public final void ruleBool_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1267:2: ( ( ( rule__Bool_Literal__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1268:2: ( ( rule__Bool_Literal__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1268:2: ( ( rule__Bool_Literal__Group__0 ) )
				// InternalStructuredTextParser.g:1269:3: ( rule__Bool_Literal__Group__0 )
				{
					before(grammarAccess.getBool_LiteralAccess().getGroup());
					// InternalStructuredTextParser.g:1270:3: ( rule__Bool_Literal__Group__0 )
					// InternalStructuredTextParser.g:1270:4: rule__Bool_Literal__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Bool_Literal__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getBool_LiteralAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleBool_Literal"

	// $ANTLR start "entryRuleBool_Value"
	// InternalStructuredTextParser.g:1279:1: entryRuleBool_Value : ruleBool_Value
	// EOF ;
	public final void entryRuleBool_Value() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1280:1: ( ruleBool_Value EOF )
			// InternalStructuredTextParser.g:1281:1: ruleBool_Value EOF
			{
				before(grammarAccess.getBool_ValueRule());
				pushFollow(FOLLOW_1);
				ruleBool_Value();

				state._fsp--;

				after(grammarAccess.getBool_ValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleBool_Value"

	// $ANTLR start "ruleBool_Value"
	// InternalStructuredTextParser.g:1288:1: ruleBool_Value : ( (
	// rule__Bool_Value__Alternatives ) ) ;
	public final void ruleBool_Value() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1292:2: ( ( ( rule__Bool_Value__Alternatives )
			// ) )
			// InternalStructuredTextParser.g:1293:2: ( ( rule__Bool_Value__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1293:2: ( ( rule__Bool_Value__Alternatives ) )
				// InternalStructuredTextParser.g:1294:3: ( rule__Bool_Value__Alternatives )
				{
					before(grammarAccess.getBool_ValueAccess().getAlternatives());
					// InternalStructuredTextParser.g:1295:3: ( rule__Bool_Value__Alternatives )
					// InternalStructuredTextParser.g:1295:4: rule__Bool_Value__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Bool_Value__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getBool_ValueAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleBool_Value"

	// $ANTLR start "entryRuleChar_Literal"
	// InternalStructuredTextParser.g:1304:1: entryRuleChar_Literal :
	// ruleChar_Literal EOF ;
	public final void entryRuleChar_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1305:1: ( ruleChar_Literal EOF )
			// InternalStructuredTextParser.g:1306:1: ruleChar_Literal EOF
			{
				before(grammarAccess.getChar_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleChar_Literal();

				state._fsp--;

				after(grammarAccess.getChar_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleChar_Literal"

	// $ANTLR start "ruleChar_Literal"
	// InternalStructuredTextParser.g:1313:1: ruleChar_Literal : ( (
	// rule__Char_Literal__Group__0 ) ) ;
	public final void ruleChar_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1317:2: ( ( ( rule__Char_Literal__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1318:2: ( ( rule__Char_Literal__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1318:2: ( ( rule__Char_Literal__Group__0 ) )
				// InternalStructuredTextParser.g:1319:3: ( rule__Char_Literal__Group__0 )
				{
					before(grammarAccess.getChar_LiteralAccess().getGroup());
					// InternalStructuredTextParser.g:1320:3: ( rule__Char_Literal__Group__0 )
					// InternalStructuredTextParser.g:1320:4: rule__Char_Literal__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getChar_LiteralAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleChar_Literal"

	// $ANTLR start "entryRuleTime_Literal"
	// InternalStructuredTextParser.g:1329:1: entryRuleTime_Literal :
	// ruleTime_Literal EOF ;
	public final void entryRuleTime_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1330:1: ( ruleTime_Literal EOF )
			// InternalStructuredTextParser.g:1331:1: ruleTime_Literal EOF
			{
				before(grammarAccess.getTime_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleTime_Literal();

				state._fsp--;

				after(grammarAccess.getTime_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTime_Literal"

	// $ANTLR start "ruleTime_Literal"
	// InternalStructuredTextParser.g:1338:1: ruleTime_Literal : ( (
	// rule__Time_Literal__Alternatives ) ) ;
	public final void ruleTime_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1342:2: ( ( ( rule__Time_Literal__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:1343:2: ( ( rule__Time_Literal__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:1343:2: ( ( rule__Time_Literal__Alternatives )
				// )
				// InternalStructuredTextParser.g:1344:3: ( rule__Time_Literal__Alternatives )
				{
					before(grammarAccess.getTime_LiteralAccess().getAlternatives());
					// InternalStructuredTextParser.g:1345:3: ( rule__Time_Literal__Alternatives )
					// InternalStructuredTextParser.g:1345:4: rule__Time_Literal__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Time_Literal__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getTime_LiteralAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTime_Literal"

	// $ANTLR start "entryRuleDuration"
	// InternalStructuredTextParser.g:1354:1: entryRuleDuration : ruleDuration EOF ;
	public final void entryRuleDuration() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1355:1: ( ruleDuration EOF )
			// InternalStructuredTextParser.g:1356:1: ruleDuration EOF
			{
				before(grammarAccess.getDurationRule());
				pushFollow(FOLLOW_1);
				ruleDuration();

				state._fsp--;

				after(grammarAccess.getDurationRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDuration"

	// $ANTLR start "ruleDuration"
	// InternalStructuredTextParser.g:1363:1: ruleDuration : ( (
	// rule__Duration__Group__0 ) ) ;
	public final void ruleDuration() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1367:2: ( ( ( rule__Duration__Group__0 ) ) )
			// InternalStructuredTextParser.g:1368:2: ( ( rule__Duration__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1368:2: ( ( rule__Duration__Group__0 ) )
				// InternalStructuredTextParser.g:1369:3: ( rule__Duration__Group__0 )
				{
					before(grammarAccess.getDurationAccess().getGroup());
					// InternalStructuredTextParser.g:1370:3: ( rule__Duration__Group__0 )
					// InternalStructuredTextParser.g:1370:4: rule__Duration__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Duration__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDurationAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDuration"

	// $ANTLR start "entryRuleDuration_Value"
	// InternalStructuredTextParser.g:1379:1: entryRuleDuration_Value :
	// ruleDuration_Value EOF ;
	public final void entryRuleDuration_Value() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1380:1: ( ruleDuration_Value EOF )
			// InternalStructuredTextParser.g:1381:1: ruleDuration_Value EOF
			{
				before(grammarAccess.getDuration_ValueRule());
				pushFollow(FOLLOW_1);
				ruleDuration_Value();

				state._fsp--;

				after(grammarAccess.getDuration_ValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDuration_Value"

	// $ANTLR start "ruleDuration_Value"
	// InternalStructuredTextParser.g:1388:1: ruleDuration_Value : ( (
	// rule__Duration_Value__Group__0 ) ) ;
	public final void ruleDuration_Value() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1392:2: ( ( ( rule__Duration_Value__Group__0 )
			// ) )
			// InternalStructuredTextParser.g:1393:2: ( ( rule__Duration_Value__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1393:2: ( ( rule__Duration_Value__Group__0 ) )
				// InternalStructuredTextParser.g:1394:3: ( rule__Duration_Value__Group__0 )
				{
					before(grammarAccess.getDuration_ValueAccess().getGroup());
					// InternalStructuredTextParser.g:1395:3: ( rule__Duration_Value__Group__0 )
					// InternalStructuredTextParser.g:1395:4: rule__Duration_Value__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Duration_Value__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDuration_ValueAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDuration_Value"

	// $ANTLR start "entryRuleFix_Point"
	// InternalStructuredTextParser.g:1404:1: entryRuleFix_Point : ruleFix_Point EOF
	// ;
	public final void entryRuleFix_Point() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1405:1: ( ruleFix_Point EOF )
			// InternalStructuredTextParser.g:1406:1: ruleFix_Point EOF
			{
				before(grammarAccess.getFix_PointRule());
				pushFollow(FOLLOW_1);
				ruleFix_Point();

				state._fsp--;

				after(grammarAccess.getFix_PointRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleFix_Point"

	// $ANTLR start "ruleFix_Point"
	// InternalStructuredTextParser.g:1413:1: ruleFix_Point : ( (
	// rule__Fix_Point__Group__0 ) ) ;
	public final void ruleFix_Point() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1417:2: ( ( ( rule__Fix_Point__Group__0 ) ) )
			// InternalStructuredTextParser.g:1418:2: ( ( rule__Fix_Point__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1418:2: ( ( rule__Fix_Point__Group__0 ) )
				// InternalStructuredTextParser.g:1419:3: ( rule__Fix_Point__Group__0 )
				{
					before(grammarAccess.getFix_PointAccess().getGroup());
					// InternalStructuredTextParser.g:1420:3: ( rule__Fix_Point__Group__0 )
					// InternalStructuredTextParser.g:1420:4: rule__Fix_Point__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Fix_Point__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getFix_PointAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleFix_Point"

	// $ANTLR start "entryRuleTime_Of_Day"
	// InternalStructuredTextParser.g:1429:1: entryRuleTime_Of_Day : ruleTime_Of_Day
	// EOF ;
	public final void entryRuleTime_Of_Day() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1430:1: ( ruleTime_Of_Day EOF )
			// InternalStructuredTextParser.g:1431:1: ruleTime_Of_Day EOF
			{
				before(grammarAccess.getTime_Of_DayRule());
				pushFollow(FOLLOW_1);
				ruleTime_Of_Day();

				state._fsp--;

				after(grammarAccess.getTime_Of_DayRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleTime_Of_Day"

	// $ANTLR start "ruleTime_Of_Day"
	// InternalStructuredTextParser.g:1438:1: ruleTime_Of_Day : ( (
	// rule__Time_Of_Day__Group__0 ) ) ;
	public final void ruleTime_Of_Day() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1442:2: ( ( ( rule__Time_Of_Day__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1443:2: ( ( rule__Time_Of_Day__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1443:2: ( ( rule__Time_Of_Day__Group__0 ) )
				// InternalStructuredTextParser.g:1444:3: ( rule__Time_Of_Day__Group__0 )
				{
					before(grammarAccess.getTime_Of_DayAccess().getGroup());
					// InternalStructuredTextParser.g:1445:3: ( rule__Time_Of_Day__Group__0 )
					// InternalStructuredTextParser.g:1445:4: rule__Time_Of_Day__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Time_Of_Day__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getTime_Of_DayAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTime_Of_Day"

	// $ANTLR start "entryRuleDaytime"
	// InternalStructuredTextParser.g:1454:1: entryRuleDaytime : ruleDaytime EOF ;
	public final void entryRuleDaytime() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1455:1: ( ruleDaytime EOF )
			// InternalStructuredTextParser.g:1456:1: ruleDaytime EOF
			{
				before(grammarAccess.getDaytimeRule());
				pushFollow(FOLLOW_1);
				ruleDaytime();

				state._fsp--;

				after(grammarAccess.getDaytimeRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDaytime"

	// $ANTLR start "ruleDaytime"
	// InternalStructuredTextParser.g:1463:1: ruleDaytime : ( (
	// rule__Daytime__Group__0 ) ) ;
	public final void ruleDaytime() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1467:2: ( ( ( rule__Daytime__Group__0 ) ) )
			// InternalStructuredTextParser.g:1468:2: ( ( rule__Daytime__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1468:2: ( ( rule__Daytime__Group__0 ) )
				// InternalStructuredTextParser.g:1469:3: ( rule__Daytime__Group__0 )
				{
					before(grammarAccess.getDaytimeAccess().getGroup());
					// InternalStructuredTextParser.g:1470:3: ( rule__Daytime__Group__0 )
					// InternalStructuredTextParser.g:1470:4: rule__Daytime__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Daytime__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDaytimeAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDaytime"

	// $ANTLR start "entryRuleDay_Hour"
	// InternalStructuredTextParser.g:1479:1: entryRuleDay_Hour : ruleDay_Hour EOF ;
	public final void entryRuleDay_Hour() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1480:1: ( ruleDay_Hour EOF )
			// InternalStructuredTextParser.g:1481:1: ruleDay_Hour EOF
			{
				before(grammarAccess.getDay_HourRule());
				pushFollow(FOLLOW_1);
				ruleDay_Hour();

				state._fsp--;

				after(grammarAccess.getDay_HourRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDay_Hour"

	// $ANTLR start "ruleDay_Hour"
	// InternalStructuredTextParser.g:1488:1: ruleDay_Hour : ( RULE_UNSIGNED_INT ) ;
	public final void ruleDay_Hour() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1492:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1493:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1493:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1494:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getDay_HourAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getDay_HourAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDay_Hour"

	// $ANTLR start "entryRuleDay_Minute"
	// InternalStructuredTextParser.g:1504:1: entryRuleDay_Minute : ruleDay_Minute
	// EOF ;
	public final void entryRuleDay_Minute() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1505:1: ( ruleDay_Minute EOF )
			// InternalStructuredTextParser.g:1506:1: ruleDay_Minute EOF
			{
				before(grammarAccess.getDay_MinuteRule());
				pushFollow(FOLLOW_1);
				ruleDay_Minute();

				state._fsp--;

				after(grammarAccess.getDay_MinuteRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDay_Minute"

	// $ANTLR start "ruleDay_Minute"
	// InternalStructuredTextParser.g:1513:1: ruleDay_Minute : ( RULE_UNSIGNED_INT )
	// ;
	public final void ruleDay_Minute() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1517:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1518:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1518:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1519:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getDay_MinuteAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getDay_MinuteAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDay_Minute"

	// $ANTLR start "entryRuleDay_Second"
	// InternalStructuredTextParser.g:1529:1: entryRuleDay_Second : ruleDay_Second
	// EOF ;
	public final void entryRuleDay_Second() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1530:1: ( ruleDay_Second EOF )
			// InternalStructuredTextParser.g:1531:1: ruleDay_Second EOF
			{
				before(grammarAccess.getDay_SecondRule());
				pushFollow(FOLLOW_1);
				ruleDay_Second();

				state._fsp--;

				after(grammarAccess.getDay_SecondRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDay_Second"

	// $ANTLR start "ruleDay_Second"
	// InternalStructuredTextParser.g:1538:1: ruleDay_Second : ( ruleFix_Point ) ;
	public final void ruleDay_Second() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1542:2: ( ( ruleFix_Point ) )
			// InternalStructuredTextParser.g:1543:2: ( ruleFix_Point )
			{
				// InternalStructuredTextParser.g:1543:2: ( ruleFix_Point )
				// InternalStructuredTextParser.g:1544:3: ruleFix_Point
				{
					before(grammarAccess.getDay_SecondAccess().getFix_PointParserRuleCall());
					pushFollow(FOLLOW_2);
					ruleFix_Point();

					state._fsp--;

					after(grammarAccess.getDay_SecondAccess().getFix_PointParserRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDay_Second"

	// $ANTLR start "entryRuleDate"
	// InternalStructuredTextParser.g:1554:1: entryRuleDate : ruleDate EOF ;
	public final void entryRuleDate() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1555:1: ( ruleDate EOF )
			// InternalStructuredTextParser.g:1556:1: ruleDate EOF
			{
				before(grammarAccess.getDateRule());
				pushFollow(FOLLOW_1);
				ruleDate();

				state._fsp--;

				after(grammarAccess.getDateRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDate"

	// $ANTLR start "ruleDate"
	// InternalStructuredTextParser.g:1563:1: ruleDate : ( ( rule__Date__Group__0 )
	// ) ;
	public final void ruleDate() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1567:2: ( ( ( rule__Date__Group__0 ) ) )
			// InternalStructuredTextParser.g:1568:2: ( ( rule__Date__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1568:2: ( ( rule__Date__Group__0 ) )
				// InternalStructuredTextParser.g:1569:3: ( rule__Date__Group__0 )
				{
					before(grammarAccess.getDateAccess().getGroup());
					// InternalStructuredTextParser.g:1570:3: ( rule__Date__Group__0 )
					// InternalStructuredTextParser.g:1570:4: rule__Date__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Date__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDateAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDate"

	// $ANTLR start "entryRuleDate_Literal"
	// InternalStructuredTextParser.g:1579:1: entryRuleDate_Literal :
	// ruleDate_Literal EOF ;
	public final void entryRuleDate_Literal() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1580:1: ( ruleDate_Literal EOF )
			// InternalStructuredTextParser.g:1581:1: ruleDate_Literal EOF
			{
				before(grammarAccess.getDate_LiteralRule());
				pushFollow(FOLLOW_1);
				ruleDate_Literal();

				state._fsp--;

				after(grammarAccess.getDate_LiteralRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDate_Literal"

	// $ANTLR start "ruleDate_Literal"
	// InternalStructuredTextParser.g:1588:1: ruleDate_Literal : ( (
	// rule__Date_Literal__Group__0 ) ) ;
	public final void ruleDate_Literal() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1592:2: ( ( ( rule__Date_Literal__Group__0 ) )
			// )
			// InternalStructuredTextParser.g:1593:2: ( ( rule__Date_Literal__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1593:2: ( ( rule__Date_Literal__Group__0 ) )
				// InternalStructuredTextParser.g:1594:3: ( rule__Date_Literal__Group__0 )
				{
					before(grammarAccess.getDate_LiteralAccess().getGroup());
					// InternalStructuredTextParser.g:1595:3: ( rule__Date_Literal__Group__0 )
					// InternalStructuredTextParser.g:1595:4: rule__Date_Literal__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Date_Literal__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDate_LiteralAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDate_Literal"

	// $ANTLR start "entryRuleYear"
	// InternalStructuredTextParser.g:1604:1: entryRuleYear : ruleYear EOF ;
	public final void entryRuleYear() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1605:1: ( ruleYear EOF )
			// InternalStructuredTextParser.g:1606:1: ruleYear EOF
			{
				before(grammarAccess.getYearRule());
				pushFollow(FOLLOW_1);
				ruleYear();

				state._fsp--;

				after(grammarAccess.getYearRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleYear"

	// $ANTLR start "ruleYear"
	// InternalStructuredTextParser.g:1613:1: ruleYear : ( RULE_UNSIGNED_INT ) ;
	public final void ruleYear() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1617:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1618:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1618:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1619:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getYearAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getYearAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleYear"

	// $ANTLR start "entryRuleMonth"
	// InternalStructuredTextParser.g:1629:1: entryRuleMonth : ruleMonth EOF ;
	public final void entryRuleMonth() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1630:1: ( ruleMonth EOF )
			// InternalStructuredTextParser.g:1631:1: ruleMonth EOF
			{
				before(grammarAccess.getMonthRule());
				pushFollow(FOLLOW_1);
				ruleMonth();

				state._fsp--;

				after(grammarAccess.getMonthRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleMonth"

	// $ANTLR start "ruleMonth"
	// InternalStructuredTextParser.g:1638:1: ruleMonth : ( RULE_UNSIGNED_INT ) ;
	public final void ruleMonth() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1642:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1643:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1643:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1644:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getMonthAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getMonthAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleMonth"

	// $ANTLR start "entryRuleDay"
	// InternalStructuredTextParser.g:1654:1: entryRuleDay : ruleDay EOF ;
	public final void entryRuleDay() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1655:1: ( ruleDay EOF )
			// InternalStructuredTextParser.g:1656:1: ruleDay EOF
			{
				before(grammarAccess.getDayRule());
				pushFollow(FOLLOW_1);
				ruleDay();

				state._fsp--;

				after(grammarAccess.getDayRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDay"

	// $ANTLR start "ruleDay"
	// InternalStructuredTextParser.g:1663:1: ruleDay : ( RULE_UNSIGNED_INT ) ;
	public final void ruleDay() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1667:2: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:1668:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:1668:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:1669:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getDayAccess().getUNSIGNED_INTTerminalRuleCall());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getDayAccess().getUNSIGNED_INTTerminalRuleCall());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDay"

	// $ANTLR start "entryRuleDate_And_Time"
	// InternalStructuredTextParser.g:1679:1: entryRuleDate_And_Time :
	// ruleDate_And_Time EOF ;
	public final void entryRuleDate_And_Time() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1680:1: ( ruleDate_And_Time EOF )
			// InternalStructuredTextParser.g:1681:1: ruleDate_And_Time EOF
			{
				before(grammarAccess.getDate_And_TimeRule());
				pushFollow(FOLLOW_1);
				ruleDate_And_Time();

				state._fsp--;

				after(grammarAccess.getDate_And_TimeRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDate_And_Time"

	// $ANTLR start "ruleDate_And_Time"
	// InternalStructuredTextParser.g:1688:1: ruleDate_And_Time : ( (
	// rule__Date_And_Time__Group__0 ) ) ;
	public final void ruleDate_And_Time() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1692:2: ( ( ( rule__Date_And_Time__Group__0 )
			// ) )
			// InternalStructuredTextParser.g:1693:2: ( ( rule__Date_And_Time__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1693:2: ( ( rule__Date_And_Time__Group__0 ) )
				// InternalStructuredTextParser.g:1694:3: ( rule__Date_And_Time__Group__0 )
				{
					before(grammarAccess.getDate_And_TimeAccess().getGroup());
					// InternalStructuredTextParser.g:1695:3: ( rule__Date_And_Time__Group__0 )
					// InternalStructuredTextParser.g:1695:4: rule__Date_And_Time__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Date_And_Time__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDate_And_TimeAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDate_And_Time"

	// $ANTLR start "entryRuleDate_And_Time_Value"
	// InternalStructuredTextParser.g:1704:1: entryRuleDate_And_Time_Value :
	// ruleDate_And_Time_Value EOF ;
	public final void entryRuleDate_And_Time_Value() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1705:1: ( ruleDate_And_Time_Value EOF )
			// InternalStructuredTextParser.g:1706:1: ruleDate_And_Time_Value EOF
			{
				before(grammarAccess.getDate_And_Time_ValueRule());
				pushFollow(FOLLOW_1);
				ruleDate_And_Time_Value();

				state._fsp--;

				after(grammarAccess.getDate_And_Time_ValueRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleDate_And_Time_Value"

	// $ANTLR start "ruleDate_And_Time_Value"
	// InternalStructuredTextParser.g:1713:1: ruleDate_And_Time_Value : ( (
	// rule__Date_And_Time_Value__Group__0 ) ) ;
	public final void ruleDate_And_Time_Value() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1717:2: ( ( (
			// rule__Date_And_Time_Value__Group__0 ) ) )
			// InternalStructuredTextParser.g:1718:2: ( (
			// rule__Date_And_Time_Value__Group__0 ) )
			{
				// InternalStructuredTextParser.g:1718:2: ( (
				// rule__Date_And_Time_Value__Group__0 ) )
				// InternalStructuredTextParser.g:1719:3: ( rule__Date_And_Time_Value__Group__0
				// )
				{
					before(grammarAccess.getDate_And_Time_ValueAccess().getGroup());
					// InternalStructuredTextParser.g:1720:3: ( rule__Date_And_Time_Value__Group__0
					// )
					// InternalStructuredTextParser.g:1720:4: rule__Date_And_Time_Value__Group__0
					{
						pushFollow(FOLLOW_2);
						rule__Date_And_Time_Value__Group__0();

						state._fsp--;

					}

					after(grammarAccess.getDate_And_Time_ValueAccess().getGroup());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDate_And_Time_Value"

	// $ANTLR start "entryRuleType_Name"
	// InternalStructuredTextParser.g:1729:1: entryRuleType_Name : ruleType_Name EOF
	// ;
	public final void entryRuleType_Name() throws RecognitionException {
		try {
			// InternalStructuredTextParser.g:1730:1: ( ruleType_Name EOF )
			// InternalStructuredTextParser.g:1731:1: ruleType_Name EOF
			{
				before(grammarAccess.getType_NameRule());
				pushFollow(FOLLOW_1);
				ruleType_Name();

				state._fsp--;

				after(grammarAccess.getType_NameRule());
				match(input, EOF, FOLLOW_2);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}
	// $ANTLR end "entryRuleType_Name"

	// $ANTLR start "ruleType_Name"
	// InternalStructuredTextParser.g:1738:1: ruleType_Name : ( (
	// rule__Type_Name__Alternatives ) ) ;
	public final void ruleType_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1742:2: ( ( ( rule__Type_Name__Alternatives )
			// ) )
			// InternalStructuredTextParser.g:1743:2: ( ( rule__Type_Name__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1743:2: ( ( rule__Type_Name__Alternatives ) )
				// InternalStructuredTextParser.g:1744:3: ( rule__Type_Name__Alternatives )
				{
					before(grammarAccess.getType_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1745:3: ( rule__Type_Name__Alternatives )
					// InternalStructuredTextParser.g:1745:4: rule__Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getType_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleType_Name"

	// $ANTLR start "ruleOr_Operator"
	// InternalStructuredTextParser.g:1754:1: ruleOr_Operator : ( ( OR ) ) ;
	public final void ruleOr_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1758:1: ( ( ( OR ) ) )
			// InternalStructuredTextParser.g:1759:2: ( ( OR ) )
			{
				// InternalStructuredTextParser.g:1759:2: ( ( OR ) )
				// InternalStructuredTextParser.g:1760:3: ( OR )
				{
					before(grammarAccess.getOr_OperatorAccess().getOREnumLiteralDeclaration());
					// InternalStructuredTextParser.g:1761:3: ( OR )
					// InternalStructuredTextParser.g:1761:4: OR
					{
						match(input, OR, FOLLOW_2);

					}

					after(grammarAccess.getOr_OperatorAccess().getOREnumLiteralDeclaration());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleOr_Operator"

	// $ANTLR start "ruleXor_Operator"
	// InternalStructuredTextParser.g:1770:1: ruleXor_Operator : ( ( XOR ) ) ;
	public final void ruleXor_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1774:1: ( ( ( XOR ) ) )
			// InternalStructuredTextParser.g:1775:2: ( ( XOR ) )
			{
				// InternalStructuredTextParser.g:1775:2: ( ( XOR ) )
				// InternalStructuredTextParser.g:1776:3: ( XOR )
				{
					before(grammarAccess.getXor_OperatorAccess().getXOREnumLiteralDeclaration());
					// InternalStructuredTextParser.g:1777:3: ( XOR )
					// InternalStructuredTextParser.g:1777:4: XOR
					{
						match(input, XOR, FOLLOW_2);

					}

					after(grammarAccess.getXor_OperatorAccess().getXOREnumLiteralDeclaration());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleXor_Operator"

	// $ANTLR start "ruleAnd_Operator"
	// InternalStructuredTextParser.g:1786:1: ruleAnd_Operator : ( (
	// rule__And_Operator__Alternatives ) ) ;
	public final void ruleAnd_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1790:1: ( ( ( rule__And_Operator__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:1791:2: ( ( rule__And_Operator__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:1791:2: ( ( rule__And_Operator__Alternatives )
				// )
				// InternalStructuredTextParser.g:1792:3: ( rule__And_Operator__Alternatives )
				{
					before(grammarAccess.getAnd_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1793:3: ( rule__And_Operator__Alternatives )
					// InternalStructuredTextParser.g:1793:4: rule__And_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__And_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getAnd_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAnd_Operator"

	// $ANTLR start "ruleCompare_Operator"
	// InternalStructuredTextParser.g:1802:1: ruleCompare_Operator : ( (
	// rule__Compare_Operator__Alternatives ) ) ;
	public final void ruleCompare_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1806:1: ( ( (
			// rule__Compare_Operator__Alternatives ) ) )
			// InternalStructuredTextParser.g:1807:2: ( (
			// rule__Compare_Operator__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1807:2: ( (
				// rule__Compare_Operator__Alternatives ) )
				// InternalStructuredTextParser.g:1808:3: ( rule__Compare_Operator__Alternatives
				// )
				{
					before(grammarAccess.getCompare_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1809:3: ( rule__Compare_Operator__Alternatives
					// )
					// InternalStructuredTextParser.g:1809:4: rule__Compare_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Compare_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getCompare_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleCompare_Operator"

	// $ANTLR start "ruleEqu_Operator"
	// InternalStructuredTextParser.g:1818:1: ruleEqu_Operator : ( (
	// rule__Equ_Operator__Alternatives ) ) ;
	public final void ruleEqu_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1822:1: ( ( ( rule__Equ_Operator__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:1823:2: ( ( rule__Equ_Operator__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:1823:2: ( ( rule__Equ_Operator__Alternatives )
				// )
				// InternalStructuredTextParser.g:1824:3: ( rule__Equ_Operator__Alternatives )
				{
					before(grammarAccess.getEqu_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1825:3: ( rule__Equ_Operator__Alternatives )
					// InternalStructuredTextParser.g:1825:4: rule__Equ_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Equ_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getEqu_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleEqu_Operator"

	// $ANTLR start "ruleAdd_Operator"
	// InternalStructuredTextParser.g:1834:1: ruleAdd_Operator : ( (
	// rule__Add_Operator__Alternatives ) ) ;
	public final void ruleAdd_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1838:1: ( ( ( rule__Add_Operator__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:1839:2: ( ( rule__Add_Operator__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:1839:2: ( ( rule__Add_Operator__Alternatives )
				// )
				// InternalStructuredTextParser.g:1840:3: ( rule__Add_Operator__Alternatives )
				{
					before(grammarAccess.getAdd_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1841:3: ( rule__Add_Operator__Alternatives )
					// InternalStructuredTextParser.g:1841:4: rule__Add_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Add_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getAdd_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleAdd_Operator"

	// $ANTLR start "ruleTerm_Operator"
	// InternalStructuredTextParser.g:1850:1: ruleTerm_Operator : ( (
	// rule__Term_Operator__Alternatives ) ) ;
	public final void ruleTerm_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1854:1: ( ( (
			// rule__Term_Operator__Alternatives ) ) )
			// InternalStructuredTextParser.g:1855:2: ( ( rule__Term_Operator__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1855:2: ( ( rule__Term_Operator__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1856:3: ( rule__Term_Operator__Alternatives )
				{
					before(grammarAccess.getTerm_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1857:3: ( rule__Term_Operator__Alternatives )
					// InternalStructuredTextParser.g:1857:4: rule__Term_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Term_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getTerm_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTerm_Operator"

	// $ANTLR start "rulePower_Operator"
	// InternalStructuredTextParser.g:1866:1: rulePower_Operator : ( (
	// AsteriskAsterisk ) ) ;
	public final void rulePower_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1870:1: ( ( ( AsteriskAsterisk ) ) )
			// InternalStructuredTextParser.g:1871:2: ( ( AsteriskAsterisk ) )
			{
				// InternalStructuredTextParser.g:1871:2: ( ( AsteriskAsterisk ) )
				// InternalStructuredTextParser.g:1872:3: ( AsteriskAsterisk )
				{
					before(grammarAccess.getPower_OperatorAccess().getPOWEREnumLiteralDeclaration());
					// InternalStructuredTextParser.g:1873:3: ( AsteriskAsterisk )
					// InternalStructuredTextParser.g:1873:4: AsteriskAsterisk
					{
						match(input, AsteriskAsterisk, FOLLOW_2);

					}

					after(grammarAccess.getPower_OperatorAccess().getPOWEREnumLiteralDeclaration());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rulePower_Operator"

	// $ANTLR start "ruleUnary_Operator"
	// InternalStructuredTextParser.g:1882:1: ruleUnary_Operator : ( (
	// rule__Unary_Operator__Alternatives ) ) ;
	public final void ruleUnary_Operator() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1886:1: ( ( (
			// rule__Unary_Operator__Alternatives ) ) )
			// InternalStructuredTextParser.g:1887:2: ( ( rule__Unary_Operator__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1887:2: ( ( rule__Unary_Operator__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1888:3: ( rule__Unary_Operator__Alternatives )
				{
					before(grammarAccess.getUnary_OperatorAccess().getAlternatives());
					// InternalStructuredTextParser.g:1889:3: ( rule__Unary_Operator__Alternatives )
					// InternalStructuredTextParser.g:1889:4: rule__Unary_Operator__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Unary_Operator__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getUnary_OperatorAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleUnary_Operator"

	// $ANTLR start "ruleDuration_Unit"
	// InternalStructuredTextParser.g:1898:1: ruleDuration_Unit : ( (
	// rule__Duration_Unit__Alternatives ) ) ;
	public final void ruleDuration_Unit() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1902:1: ( ( (
			// rule__Duration_Unit__Alternatives ) ) )
			// InternalStructuredTextParser.g:1903:2: ( ( rule__Duration_Unit__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1903:2: ( ( rule__Duration_Unit__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1904:3: ( rule__Duration_Unit__Alternatives )
				{
					before(grammarAccess.getDuration_UnitAccess().getAlternatives());
					// InternalStructuredTextParser.g:1905:3: ( rule__Duration_Unit__Alternatives )
					// InternalStructuredTextParser.g:1905:4: rule__Duration_Unit__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Duration_Unit__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getDuration_UnitAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDuration_Unit"

	// $ANTLR start "ruleInt_Type_Name"
	// InternalStructuredTextParser.g:1914:1: ruleInt_Type_Name : ( (
	// rule__Int_Type_Name__Alternatives ) ) ;
	public final void ruleInt_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1918:1: ( ( (
			// rule__Int_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1919:2: ( ( rule__Int_Type_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1919:2: ( ( rule__Int_Type_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1920:3: ( rule__Int_Type_Name__Alternatives )
				{
					before(grammarAccess.getInt_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1921:3: ( rule__Int_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:1921:4: rule__Int_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Int_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getInt_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleInt_Type_Name"

	// $ANTLR start "ruleReal_Type_Name"
	// InternalStructuredTextParser.g:1930:1: ruleReal_Type_Name : ( (
	// rule__Real_Type_Name__Alternatives ) ) ;
	public final void ruleReal_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1934:1: ( ( (
			// rule__Real_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1935:2: ( ( rule__Real_Type_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1935:2: ( ( rule__Real_Type_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1936:3: ( rule__Real_Type_Name__Alternatives )
				{
					before(grammarAccess.getReal_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1937:3: ( rule__Real_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:1937:4: rule__Real_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Real_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getReal_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleReal_Type_Name"

	// $ANTLR start "ruleString_Type_Name"
	// InternalStructuredTextParser.g:1946:1: ruleString_Type_Name : ( (
	// rule__String_Type_Name__Alternatives ) ) ;
	public final void ruleString_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1950:1: ( ( (
			// rule__String_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1951:2: ( (
			// rule__String_Type_Name__Alternatives ) )
			{
				// InternalStructuredTextParser.g:1951:2: ( (
				// rule__String_Type_Name__Alternatives ) )
				// InternalStructuredTextParser.g:1952:3: ( rule__String_Type_Name__Alternatives
				// )
				{
					before(grammarAccess.getString_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1953:3: ( rule__String_Type_Name__Alternatives
					// )
					// InternalStructuredTextParser.g:1953:4: rule__String_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__String_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getString_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleString_Type_Name"

	// $ANTLR start "ruleTime_Type_Name"
	// InternalStructuredTextParser.g:1962:1: ruleTime_Type_Name : ( (
	// rule__Time_Type_Name__Alternatives ) ) ;
	public final void ruleTime_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1966:1: ( ( (
			// rule__Time_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1967:2: ( ( rule__Time_Type_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1967:2: ( ( rule__Time_Type_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1968:3: ( rule__Time_Type_Name__Alternatives )
				{
					before(grammarAccess.getTime_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1969:3: ( rule__Time_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:1969:4: rule__Time_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Time_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getTime_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTime_Type_Name"

	// $ANTLR start "ruleTod_Type_Name"
	// InternalStructuredTextParser.g:1978:1: ruleTod_Type_Name : ( (
	// rule__Tod_Type_Name__Alternatives ) ) ;
	public final void ruleTod_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1982:1: ( ( (
			// rule__Tod_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1983:2: ( ( rule__Tod_Type_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1983:2: ( ( rule__Tod_Type_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:1984:3: ( rule__Tod_Type_Name__Alternatives )
				{
					before(grammarAccess.getTod_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:1985:3: ( rule__Tod_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:1985:4: rule__Tod_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Tod_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getTod_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleTod_Type_Name"

	// $ANTLR start "ruleDate_Type_Name"
	// InternalStructuredTextParser.g:1994:1: ruleDate_Type_Name : ( (
	// rule__Date_Type_Name__Alternatives ) ) ;
	public final void ruleDate_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:1998:1: ( ( (
			// rule__Date_Type_Name__Alternatives ) ) )
			// InternalStructuredTextParser.g:1999:2: ( ( rule__Date_Type_Name__Alternatives
			// ) )
			{
				// InternalStructuredTextParser.g:1999:2: ( ( rule__Date_Type_Name__Alternatives
				// ) )
				// InternalStructuredTextParser.g:2000:3: ( rule__Date_Type_Name__Alternatives )
				{
					before(grammarAccess.getDate_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:2001:3: ( rule__Date_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:2001:4: rule__Date_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__Date_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getDate_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDate_Type_Name"

	// $ANTLR start "ruleDT_Type_Name"
	// InternalStructuredTextParser.g:2010:1: ruleDT_Type_Name : ( (
	// rule__DT_Type_Name__Alternatives ) ) ;
	public final void ruleDT_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2014:1: ( ( ( rule__DT_Type_Name__Alternatives
			// ) ) )
			// InternalStructuredTextParser.g:2015:2: ( ( rule__DT_Type_Name__Alternatives )
			// )
			{
				// InternalStructuredTextParser.g:2015:2: ( ( rule__DT_Type_Name__Alternatives )
				// )
				// InternalStructuredTextParser.g:2016:3: ( rule__DT_Type_Name__Alternatives )
				{
					before(grammarAccess.getDT_Type_NameAccess().getAlternatives());
					// InternalStructuredTextParser.g:2017:3: ( rule__DT_Type_Name__Alternatives )
					// InternalStructuredTextParser.g:2017:4: rule__DT_Type_Name__Alternatives
					{
						pushFollow(FOLLOW_2);
						rule__DT_Type_Name__Alternatives();

						state._fsp--;

					}

					after(grammarAccess.getDT_Type_NameAccess().getAlternatives());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleDT_Type_Name"

	// $ANTLR start "ruleBool_Type_Name"
	// InternalStructuredTextParser.g:2026:1: ruleBool_Type_Name : ( ( BOOL ) ) ;
	public final void ruleBool_Type_Name() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2030:1: ( ( ( BOOL ) ) )
			// InternalStructuredTextParser.g:2031:2: ( ( BOOL ) )
			{
				// InternalStructuredTextParser.g:2031:2: ( ( BOOL ) )
				// InternalStructuredTextParser.g:2032:3: ( BOOL )
				{
					before(grammarAccess.getBool_Type_NameAccess().getBOOLEnumLiteralDeclaration());
					// InternalStructuredTextParser.g:2033:3: ( BOOL )
					// InternalStructuredTextParser.g:2033:4: BOOL
					{
						match(input, BOOL, FOLLOW_2);

					}

					after(grammarAccess.getBool_Type_NameAccess().getBOOLEnumLiteralDeclaration());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "ruleBool_Type_Name"

	// $ANTLR start "rule__Stmt__Alternatives"
	// InternalStructuredTextParser.g:2041:1: rule__Stmt__Alternatives : ( (
	// ruleAssign_Stmt ) | ( ruleSubprog_Ctrl_Stmt ) | ( ruleSelection_Stmt ) | (
	// ruleIteration_Stmt ) );
	public final void rule__Stmt__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2045:1: ( ( ruleAssign_Stmt ) | (
			// ruleSubprog_Ctrl_Stmt ) | ( ruleSelection_Stmt ) | ( ruleIteration_Stmt ) )
			int alt1 = 4;
			switch (input.LA(1)) {
			case RULE_ID: {
				int LA1_1 = input.LA(2);

				if ((LA1_1 == LeftParenthesis)) {
					alt1 = 2;
				} else if ((LA1_1 == ColonEqualsSign || LA1_1 == FullStop || LA1_1 == LeftSquareBracket)) {
					alt1 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 1, 1, input);

					throw nvae;
				}
			}
				break;
			case DT:
			case LT:
			case T: {
				alt1 = 1;
			}
				break;
			case RETURN:
			case SUPER:
			case TIME: {
				alt1 = 2;
			}
				break;
			case CASE:
			case IF: {
				alt1 = 3;
			}
				break;
			case CONTINUE:
			case REPEAT:
			case WHILE:
			case EXIT:
			case FOR: {
				alt1 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

				throw nvae;
			}

			switch (alt1) {
			case 1:
			// InternalStructuredTextParser.g:2046:2: ( ruleAssign_Stmt )
			{
				// InternalStructuredTextParser.g:2046:2: ( ruleAssign_Stmt )
				// InternalStructuredTextParser.g:2047:3: ruleAssign_Stmt
				{
					before(grammarAccess.getStmtAccess().getAssign_StmtParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleAssign_Stmt();

					state._fsp--;

					after(grammarAccess.getStmtAccess().getAssign_StmtParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2052:2: ( ruleSubprog_Ctrl_Stmt )
			{
				// InternalStructuredTextParser.g:2052:2: ( ruleSubprog_Ctrl_Stmt )
				// InternalStructuredTextParser.g:2053:3: ruleSubprog_Ctrl_Stmt
				{
					before(grammarAccess.getStmtAccess().getSubprog_Ctrl_StmtParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleSubprog_Ctrl_Stmt();

					state._fsp--;

					after(grammarAccess.getStmtAccess().getSubprog_Ctrl_StmtParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2058:2: ( ruleSelection_Stmt )
			{
				// InternalStructuredTextParser.g:2058:2: ( ruleSelection_Stmt )
				// InternalStructuredTextParser.g:2059:3: ruleSelection_Stmt
				{
					before(grammarAccess.getStmtAccess().getSelection_StmtParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleSelection_Stmt();

					state._fsp--;

					after(grammarAccess.getStmtAccess().getSelection_StmtParserRuleCall_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2064:2: ( ruleIteration_Stmt )
			{
				// InternalStructuredTextParser.g:2064:2: ( ruleIteration_Stmt )
				// InternalStructuredTextParser.g:2065:3: ruleIteration_Stmt
				{
					before(grammarAccess.getStmtAccess().getIteration_StmtParserRuleCall_3());
					pushFollow(FOLLOW_2);
					ruleIteration_Stmt();

					state._fsp--;

					after(grammarAccess.getStmtAccess().getIteration_StmtParserRuleCall_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt__Alternatives"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Alternatives"
	// InternalStructuredTextParser.g:2074:1: rule__Subprog_Ctrl_Stmt__Alternatives
	// : ( ( ruleFunc_Call ) | ( ( rule__Subprog_Ctrl_Stmt__Group_1__0 ) ) | ( (
	// rule__Subprog_Ctrl_Stmt__Group_2__0 ) ) );
	public final void rule__Subprog_Ctrl_Stmt__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2078:1: ( ( ruleFunc_Call ) | ( (
			// rule__Subprog_Ctrl_Stmt__Group_1__0 ) ) | ( (
			// rule__Subprog_Ctrl_Stmt__Group_2__0 ) ) )
			int alt2 = 3;
			switch (input.LA(1)) {
			case TIME:
			case RULE_ID: {
				alt2 = 1;
			}
				break;
			case SUPER: {
				alt2 = 2;
			}
				break;
			case RETURN: {
				alt2 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

				throw nvae;
			}

			switch (alt2) {
			case 1:
			// InternalStructuredTextParser.g:2079:2: ( ruleFunc_Call )
			{
				// InternalStructuredTextParser.g:2079:2: ( ruleFunc_Call )
				// InternalStructuredTextParser.g:2080:3: ruleFunc_Call
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getFunc_CallParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleFunc_Call();

					state._fsp--;

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getFunc_CallParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2085:2: ( (
			// rule__Subprog_Ctrl_Stmt__Group_1__0 ) )
			{
				// InternalStructuredTextParser.g:2085:2: ( (
				// rule__Subprog_Ctrl_Stmt__Group_1__0 ) )
				// InternalStructuredTextParser.g:2086:3: ( rule__Subprog_Ctrl_Stmt__Group_1__0
				// )
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getGroup_1());
					// InternalStructuredTextParser.g:2087:3: ( rule__Subprog_Ctrl_Stmt__Group_1__0
					// )
					// InternalStructuredTextParser.g:2087:4: rule__Subprog_Ctrl_Stmt__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__Subprog_Ctrl_Stmt__Group_1__0();

						state._fsp--;

					}

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getGroup_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2091:2: ( (
			// rule__Subprog_Ctrl_Stmt__Group_2__0 ) )
			{
				// InternalStructuredTextParser.g:2091:2: ( (
				// rule__Subprog_Ctrl_Stmt__Group_2__0 ) )
				// InternalStructuredTextParser.g:2092:3: ( rule__Subprog_Ctrl_Stmt__Group_2__0
				// )
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getGroup_2());
					// InternalStructuredTextParser.g:2093:3: ( rule__Subprog_Ctrl_Stmt__Group_2__0
					// )
					// InternalStructuredTextParser.g:2093:4: rule__Subprog_Ctrl_Stmt__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__Subprog_Ctrl_Stmt__Group_2__0();

						state._fsp--;

					}

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getGroup_2());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Alternatives"

	// $ANTLR start "rule__Selection_Stmt__Alternatives"
	// InternalStructuredTextParser.g:2101:1: rule__Selection_Stmt__Alternatives : (
	// ( ruleIF_Stmt ) | ( ruleCase_Stmt ) );
	public final void rule__Selection_Stmt__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2105:1: ( ( ruleIF_Stmt ) | ( ruleCase_Stmt )
			// )
			int alt3 = 2;
			int LA3_0 = input.LA(1);

			if ((LA3_0 == IF)) {
				alt3 = 1;
			} else if ((LA3_0 == CASE)) {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

				throw nvae;
			}
			switch (alt3) {
			case 1:
			// InternalStructuredTextParser.g:2106:2: ( ruleIF_Stmt )
			{
				// InternalStructuredTextParser.g:2106:2: ( ruleIF_Stmt )
				// InternalStructuredTextParser.g:2107:3: ruleIF_Stmt
				{
					before(grammarAccess.getSelection_StmtAccess().getIF_StmtParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleIF_Stmt();

					state._fsp--;

					after(grammarAccess.getSelection_StmtAccess().getIF_StmtParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2112:2: ( ruleCase_Stmt )
			{
				// InternalStructuredTextParser.g:2112:2: ( ruleCase_Stmt )
				// InternalStructuredTextParser.g:2113:3: ruleCase_Stmt
				{
					before(grammarAccess.getSelection_StmtAccess().getCase_StmtParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleCase_Stmt();

					state._fsp--;

					after(grammarAccess.getSelection_StmtAccess().getCase_StmtParserRuleCall_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Selection_Stmt__Alternatives"

	// $ANTLR start "rule__Iteration_Stmt__Alternatives"
	// InternalStructuredTextParser.g:2122:1: rule__Iteration_Stmt__Alternatives : (
	// ( ruleFor_Stmt ) | ( ruleWhile_Stmt ) | ( ruleRepeat_Stmt ) | ( (
	// rule__Iteration_Stmt__Group_3__0 ) ) | ( ( rule__Iteration_Stmt__Group_4__0 )
	// ) );
	public final void rule__Iteration_Stmt__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2126:1: ( ( ruleFor_Stmt ) | ( ruleWhile_Stmt
			// ) | ( ruleRepeat_Stmt ) | ( ( rule__Iteration_Stmt__Group_3__0 ) ) | ( (
			// rule__Iteration_Stmt__Group_4__0 ) ) )
			int alt4 = 5;
			switch (input.LA(1)) {
			case FOR: {
				alt4 = 1;
			}
				break;
			case WHILE: {
				alt4 = 2;
			}
				break;
			case REPEAT: {
				alt4 = 3;
			}
				break;
			case EXIT: {
				alt4 = 4;
			}
				break;
			case CONTINUE: {
				alt4 = 5;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

				throw nvae;
			}

			switch (alt4) {
			case 1:
			// InternalStructuredTextParser.g:2127:2: ( ruleFor_Stmt )
			{
				// InternalStructuredTextParser.g:2127:2: ( ruleFor_Stmt )
				// InternalStructuredTextParser.g:2128:3: ruleFor_Stmt
				{
					before(grammarAccess.getIteration_StmtAccess().getFor_StmtParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleFor_Stmt();

					state._fsp--;

					after(grammarAccess.getIteration_StmtAccess().getFor_StmtParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2133:2: ( ruleWhile_Stmt )
			{
				// InternalStructuredTextParser.g:2133:2: ( ruleWhile_Stmt )
				// InternalStructuredTextParser.g:2134:3: ruleWhile_Stmt
				{
					before(grammarAccess.getIteration_StmtAccess().getWhile_StmtParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleWhile_Stmt();

					state._fsp--;

					after(grammarAccess.getIteration_StmtAccess().getWhile_StmtParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2139:2: ( ruleRepeat_Stmt )
			{
				// InternalStructuredTextParser.g:2139:2: ( ruleRepeat_Stmt )
				// InternalStructuredTextParser.g:2140:3: ruleRepeat_Stmt
				{
					before(grammarAccess.getIteration_StmtAccess().getRepeat_StmtParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleRepeat_Stmt();

					state._fsp--;

					after(grammarAccess.getIteration_StmtAccess().getRepeat_StmtParserRuleCall_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2145:2: ( ( rule__Iteration_Stmt__Group_3__0 )
			// )
			{
				// InternalStructuredTextParser.g:2145:2: ( ( rule__Iteration_Stmt__Group_3__0 )
				// )
				// InternalStructuredTextParser.g:2146:3: ( rule__Iteration_Stmt__Group_3__0 )
				{
					before(grammarAccess.getIteration_StmtAccess().getGroup_3());
					// InternalStructuredTextParser.g:2147:3: ( rule__Iteration_Stmt__Group_3__0 )
					// InternalStructuredTextParser.g:2147:4: rule__Iteration_Stmt__Group_3__0
					{
						pushFollow(FOLLOW_2);
						rule__Iteration_Stmt__Group_3__0();

						state._fsp--;

					}

					after(grammarAccess.getIteration_StmtAccess().getGroup_3());

				}

			}
				break;
			case 5:
			// InternalStructuredTextParser.g:2151:2: ( ( rule__Iteration_Stmt__Group_4__0 )
			// )
			{
				// InternalStructuredTextParser.g:2151:2: ( ( rule__Iteration_Stmt__Group_4__0 )
				// )
				// InternalStructuredTextParser.g:2152:3: ( rule__Iteration_Stmt__Group_4__0 )
				{
					before(grammarAccess.getIteration_StmtAccess().getGroup_4());
					// InternalStructuredTextParser.g:2153:3: ( rule__Iteration_Stmt__Group_4__0 )
					// InternalStructuredTextParser.g:2153:4: rule__Iteration_Stmt__Group_4__0
					{
						pushFollow(FOLLOW_2);
						rule__Iteration_Stmt__Group_4__0();

						state._fsp--;

					}

					after(grammarAccess.getIteration_StmtAccess().getGroup_4());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Alternatives"

	// $ANTLR start "rule__Unary_Expr__Alternatives"
	// InternalStructuredTextParser.g:2161:1: rule__Unary_Expr__Alternatives : ( ( (
	// rule__Unary_Expr__Group_0__0 ) ) | ( rulePrimary_Expr ) | ( ruleConstant ) );
	public final void rule__Unary_Expr__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2165:1: ( ( ( rule__Unary_Expr__Group_0__0 ) )
			// | ( rulePrimary_Expr ) | ( ruleConstant ) )
			int alt5 = 3;
			alt5 = dfa5.predict(input);
			switch (alt5) {
			case 1:
			// InternalStructuredTextParser.g:2166:2: ( ( rule__Unary_Expr__Group_0__0 ) )
			{
				// InternalStructuredTextParser.g:2166:2: ( ( rule__Unary_Expr__Group_0__0 ) )
				// InternalStructuredTextParser.g:2167:3: ( rule__Unary_Expr__Group_0__0 )
				{
					before(grammarAccess.getUnary_ExprAccess().getGroup_0());
					// InternalStructuredTextParser.g:2168:3: ( rule__Unary_Expr__Group_0__0 )
					// InternalStructuredTextParser.g:2168:4: rule__Unary_Expr__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Unary_Expr__Group_0__0();

						state._fsp--;

					}

					after(grammarAccess.getUnary_ExprAccess().getGroup_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2172:2: ( rulePrimary_Expr )
			{
				// InternalStructuredTextParser.g:2172:2: ( rulePrimary_Expr )
				// InternalStructuredTextParser.g:2173:3: rulePrimary_Expr
				{
					before(grammarAccess.getUnary_ExprAccess().getPrimary_ExprParserRuleCall_1());
					pushFollow(FOLLOW_2);
					rulePrimary_Expr();

					state._fsp--;

					after(grammarAccess.getUnary_ExprAccess().getPrimary_ExprParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2178:2: ( ruleConstant )
			{
				// InternalStructuredTextParser.g:2178:2: ( ruleConstant )
				// InternalStructuredTextParser.g:2179:3: ruleConstant
				{
					before(grammarAccess.getUnary_ExprAccess().getConstantParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleConstant();

					state._fsp--;

					after(grammarAccess.getUnary_ExprAccess().getConstantParserRuleCall_2());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Alternatives"

	// $ANTLR start "rule__Primary_Expr__Alternatives"
	// InternalStructuredTextParser.g:2188:1: rule__Primary_Expr__Alternatives : ( (
	// ruleVariable ) | ( ruleFunc_Call ) | ( ( rule__Primary_Expr__Group_2__0 ) )
	// );
	public final void rule__Primary_Expr__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2192:1: ( ( ruleVariable ) | ( ruleFunc_Call )
			// | ( ( rule__Primary_Expr__Group_2__0 ) ) )
			int alt6 = 3;
			switch (input.LA(1)) {
			case RULE_ID: {
				int LA6_1 = input.LA(2);

				if ((LA6_1 == EOF || LA6_1 == END_REPEAT || LA6_1 == THEN || LA6_1 == AND || LA6_1 == MOD
						|| (LA6_1 >= XOR && LA6_1 <= AsteriskAsterisk)
						|| (LA6_1 >= LessThanSignEqualsSign && LA6_1 <= LessThanSignGreaterThanSign)
						|| (LA6_1 >= GreaterThanSignEqualsSign && LA6_1 <= DO) || (LA6_1 >= OF && LA6_1 <= TO)
						|| LA6_1 == Ampersand || (LA6_1 >= RightParenthesis && LA6_1 <= Solidus)
						|| (LA6_1 >= Semicolon && LA6_1 <= GreaterThanSign)
						|| (LA6_1 >= LeftSquareBracket && LA6_1 <= RightSquareBracket))) {
					alt6 = 1;
				} else if ((LA6_1 == LeftParenthesis)) {
					alt6 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 6, 1, input);

					throw nvae;
				}
			}
				break;
			case DT:
			case LT:
			case T: {
				alt6 = 1;
			}
				break;
			case TIME: {
				alt6 = 2;
			}
				break;
			case LeftParenthesis: {
				alt6 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

				throw nvae;
			}

			switch (alt6) {
			case 1:
			// InternalStructuredTextParser.g:2193:2: ( ruleVariable )
			{
				// InternalStructuredTextParser.g:2193:2: ( ruleVariable )
				// InternalStructuredTextParser.g:2194:3: ruleVariable
				{
					before(grammarAccess.getPrimary_ExprAccess().getVariableParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleVariable();

					state._fsp--;

					after(grammarAccess.getPrimary_ExprAccess().getVariableParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2199:2: ( ruleFunc_Call )
			{
				// InternalStructuredTextParser.g:2199:2: ( ruleFunc_Call )
				// InternalStructuredTextParser.g:2200:3: ruleFunc_Call
				{
					before(grammarAccess.getPrimary_ExprAccess().getFunc_CallParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleFunc_Call();

					state._fsp--;

					after(grammarAccess.getPrimary_ExprAccess().getFunc_CallParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2205:2: ( ( rule__Primary_Expr__Group_2__0 ) )
			{
				// InternalStructuredTextParser.g:2205:2: ( ( rule__Primary_Expr__Group_2__0 ) )
				// InternalStructuredTextParser.g:2206:3: ( rule__Primary_Expr__Group_2__0 )
				{
					before(grammarAccess.getPrimary_ExprAccess().getGroup_2());
					// InternalStructuredTextParser.g:2207:3: ( rule__Primary_Expr__Group_2__0 )
					// InternalStructuredTextParser.g:2207:4: rule__Primary_Expr__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__Primary_Expr__Group_2__0();

						state._fsp--;

					}

					after(grammarAccess.getPrimary_ExprAccess().getGroup_2());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Alternatives"

	// $ANTLR start "rule__Func_Call__FuncAlternatives_0_0"
	// InternalStructuredTextParser.g:2215:1: rule__Func_Call__FuncAlternatives_0_0
	// : ( ( RULE_ID ) | ( TIME ) );
	public final void rule__Func_Call__FuncAlternatives_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2219:1: ( ( RULE_ID ) | ( TIME ) )
			int alt7 = 2;
			int LA7_0 = input.LA(1);

			if ((LA7_0 == RULE_ID)) {
				alt7 = 1;
			} else if ((LA7_0 == TIME)) {
				alt7 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

				throw nvae;
			}
			switch (alt7) {
			case 1:
			// InternalStructuredTextParser.g:2220:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:2220:2: ( RULE_ID )
				// InternalStructuredTextParser.g:2221:3: RULE_ID
				{
					before(grammarAccess.getFunc_CallAccess().getFuncIDTerminalRuleCall_0_0_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getFunc_CallAccess().getFuncIDTerminalRuleCall_0_0_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2226:2: ( TIME )
			{
				// InternalStructuredTextParser.g:2226:2: ( TIME )
				// InternalStructuredTextParser.g:2227:3: TIME
				{
					before(grammarAccess.getFunc_CallAccess().getFuncTIMEKeyword_0_0_1());
					match(input, TIME, FOLLOW_2);
					after(grammarAccess.getFunc_CallAccess().getFuncTIMEKeyword_0_0_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__FuncAlternatives_0_0"

	// $ANTLR start "rule__Param_Assign__Alternatives"
	// InternalStructuredTextParser.g:2236:1: rule__Param_Assign__Alternatives : ( (
	// ruleParam_Assign_In ) | ( ruleParam_Assign_Out ) );
	public final void rule__Param_Assign__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2240:1: ( ( ruleParam_Assign_In ) | (
			// ruleParam_Assign_Out ) )
			int alt8 = 2;
			switch (input.LA(1)) {
			case RULE_ID: {
				int LA8_1 = input.LA(2);

				if ((LA8_1 == EOF || LA8_1 == AND || LA8_1 == MOD
						|| (LA8_1 >= XOR && LA8_1 <= LessThanSignGreaterThanSign) || LA8_1 == GreaterThanSignEqualsSign
						|| LA8_1 == OR || (LA8_1 >= Ampersand && LA8_1 <= Solidus)
						|| (LA8_1 >= LessThanSign && LA8_1 <= GreaterThanSign) || LA8_1 == LeftSquareBracket)) {
					alt8 = 1;
				} else if ((LA8_1 == EqualsSignGreaterThanSign)) {
					alt8 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 8, 1, input);

					throw nvae;
				}
			}
				break;
			case LDATE_AND_TIME:
			case DATE_AND_TIME:
			case LTIME_OF_DAY:
			case TIME_OF_DAY:
			case WSTRING:
			case STRING:
			case FALSE:
			case LDATE:
			case LREAL:
			case LTIME:
			case UDINT:
			case ULINT:
			case USINT:
			case WCHAR:
			case BOOL:
			case CHAR:
			case DATE:
			case DINT:
			case LINT:
			case LTOD:
			case REAL:
			case SINT:
			case TIME:
			case TRUE:
			case UINT:
			case INT:
			case LDT:
			case TOD:
			case DT:
			case LD:
			case LT:
			case LeftParenthesis:
			case PlusSign:
			case HyphenMinus:
			case T:
			case D_1:
			case RULE_BINARY_INT:
			case RULE_OCTAL_INT:
			case RULE_HEX_INT:
			case RULE_UNSIGNED_INT:
			case RULE_S_BYTE_CHAR_STR:
			case RULE_D_BYTE_CHAR_STR: {
				alt8 = 1;
			}
				break;
			case NOT: {
				int LA8_3 = input.LA(2);

				if ((LA8_3 == RULE_ID)) {
					int LA8_5 = input.LA(3);

					if ((LA8_5 == EOF || LA8_5 == AND || LA8_5 == MOD || (LA8_5 >= XOR && LA8_5 <= AsteriskAsterisk)
							|| (LA8_5 >= LessThanSignEqualsSign && LA8_5 <= LessThanSignGreaterThanSign)
							|| LA8_5 == GreaterThanSignEqualsSign || LA8_5 == OR
							|| (LA8_5 >= Ampersand && LA8_5 <= Solidus)
							|| (LA8_5 >= LessThanSign && LA8_5 <= GreaterThanSign) || LA8_5 == LeftSquareBracket)) {
						alt8 = 1;
					} else if ((LA8_5 == EqualsSignGreaterThanSign)) {
						alt8 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 8, 5, input);

						throw nvae;
					}
				} else if ((LA8_3 == TIME || LA8_3 == DT || LA8_3 == LT || LA8_3 == LeftParenthesis || LA8_3 == T)) {
					alt8 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 8, 3, input);

					throw nvae;
				}
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

				throw nvae;
			}

			switch (alt8) {
			case 1:
			// InternalStructuredTextParser.g:2241:2: ( ruleParam_Assign_In )
			{
				// InternalStructuredTextParser.g:2241:2: ( ruleParam_Assign_In )
				// InternalStructuredTextParser.g:2242:3: ruleParam_Assign_In
				{
					before(grammarAccess.getParam_AssignAccess().getParam_Assign_InParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleParam_Assign_In();

					state._fsp--;

					after(grammarAccess.getParam_AssignAccess().getParam_Assign_InParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2247:2: ( ruleParam_Assign_Out )
			{
				// InternalStructuredTextParser.g:2247:2: ( ruleParam_Assign_Out )
				// InternalStructuredTextParser.g:2248:3: ruleParam_Assign_Out
				{
					before(grammarAccess.getParam_AssignAccess().getParam_Assign_OutParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleParam_Assign_Out();

					state._fsp--;

					after(grammarAccess.getParam_AssignAccess().getParam_Assign_OutParserRuleCall_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign__Alternatives"

	// $ANTLR start "rule__Variable_Subscript__Alternatives_0"
	// InternalStructuredTextParser.g:2257:1:
	// rule__Variable_Subscript__Alternatives_0 : ( ( ruleVariable_Primary ) | (
	// ruleVariable_Adapter ) );
	public final void rule__Variable_Subscript__Alternatives_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2261:1: ( ( ruleVariable_Primary ) | (
			// ruleVariable_Adapter ) )
			int alt9 = 2;
			switch (input.LA(1)) {
			case RULE_ID: {
				int LA9_1 = input.LA(2);

				if ((LA9_1 == EOF || LA9_1 == END_REPEAT || LA9_1 == THEN || LA9_1 == AND || LA9_1 == MOD
						|| (LA9_1 >= XOR && LA9_1 <= LessThanSignGreaterThanSign)
						|| (LA9_1 >= GreaterThanSignEqualsSign && LA9_1 <= DO) || (LA9_1 >= OF && LA9_1 <= TO)
						|| LA9_1 == Ampersand || (LA9_1 >= RightParenthesis && LA9_1 <= HyphenMinus) || LA9_1 == Solidus
						|| (LA9_1 >= Semicolon && LA9_1 <= GreaterThanSign)
						|| (LA9_1 >= LeftSquareBracket && LA9_1 <= RightSquareBracket))) {
					alt9 = 1;
				} else if ((LA9_1 == FullStop)) {
					alt9 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 1, input);

					throw nvae;
				}
			}
				break;
			case T: {
				int LA9_2 = input.LA(2);

				if ((LA9_2 == EOF || LA9_2 == END_REPEAT || LA9_2 == THEN || LA9_2 == AND || LA9_2 == MOD
						|| (LA9_2 >= XOR && LA9_2 <= LessThanSignGreaterThanSign)
						|| (LA9_2 >= GreaterThanSignEqualsSign && LA9_2 <= DO) || (LA9_2 >= OF && LA9_2 <= TO)
						|| LA9_2 == Ampersand || (LA9_2 >= RightParenthesis && LA9_2 <= HyphenMinus) || LA9_2 == Solidus
						|| (LA9_2 >= Semicolon && LA9_2 <= GreaterThanSign)
						|| (LA9_2 >= LeftSquareBracket && LA9_2 <= RightSquareBracket))) {
					alt9 = 1;
				} else if ((LA9_2 == FullStop)) {
					alt9 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 2, input);

					throw nvae;
				}
			}
				break;
			case LT: {
				int LA9_3 = input.LA(2);

				if ((LA9_3 == EOF || LA9_3 == END_REPEAT || LA9_3 == THEN || LA9_3 == AND || LA9_3 == MOD
						|| (LA9_3 >= XOR && LA9_3 <= LessThanSignGreaterThanSign)
						|| (LA9_3 >= GreaterThanSignEqualsSign && LA9_3 <= DO) || (LA9_3 >= OF && LA9_3 <= TO)
						|| LA9_3 == Ampersand || (LA9_3 >= RightParenthesis && LA9_3 <= HyphenMinus) || LA9_3 == Solidus
						|| (LA9_3 >= Semicolon && LA9_3 <= GreaterThanSign)
						|| (LA9_3 >= LeftSquareBracket && LA9_3 <= RightSquareBracket))) {
					alt9 = 1;
				} else if ((LA9_3 == FullStop)) {
					alt9 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 3, input);

					throw nvae;
				}
			}
				break;
			case DT: {
				int LA9_4 = input.LA(2);

				if ((LA9_4 == EOF || LA9_4 == END_REPEAT || LA9_4 == THEN || LA9_4 == AND || LA9_4 == MOD
						|| (LA9_4 >= XOR && LA9_4 <= LessThanSignGreaterThanSign)
						|| (LA9_4 >= GreaterThanSignEqualsSign && LA9_4 <= DO) || (LA9_4 >= OF && LA9_4 <= TO)
						|| LA9_4 == Ampersand || (LA9_4 >= RightParenthesis && LA9_4 <= HyphenMinus) || LA9_4 == Solidus
						|| (LA9_4 >= Semicolon && LA9_4 <= GreaterThanSign)
						|| (LA9_4 >= LeftSquareBracket && LA9_4 <= RightSquareBracket))) {
					alt9 = 1;
				} else if ((LA9_4 == FullStop)) {
					alt9 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 4, input);

					throw nvae;
				}
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 9, 0, input);

				throw nvae;
			}

			switch (alt9) {
			case 1:
			// InternalStructuredTextParser.g:2262:2: ( ruleVariable_Primary )
			{
				// InternalStructuredTextParser.g:2262:2: ( ruleVariable_Primary )
				// InternalStructuredTextParser.g:2263:3: ruleVariable_Primary
				{
					before(grammarAccess.getVariable_SubscriptAccess().getVariable_PrimaryParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleVariable_Primary();

					state._fsp--;

					after(grammarAccess.getVariable_SubscriptAccess().getVariable_PrimaryParserRuleCall_0_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2268:2: ( ruleVariable_Adapter )
			{
				// InternalStructuredTextParser.g:2268:2: ( ruleVariable_Adapter )
				// InternalStructuredTextParser.g:2269:3: ruleVariable_Adapter
				{
					before(grammarAccess.getVariable_SubscriptAccess().getVariable_AdapterParserRuleCall_0_1());
					pushFollow(FOLLOW_2);
					ruleVariable_Adapter();

					state._fsp--;

					after(grammarAccess.getVariable_SubscriptAccess().getVariable_AdapterParserRuleCall_0_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Alternatives_0"

	// $ANTLR start "rule__Adapter_Name__Alternatives"
	// InternalStructuredTextParser.g:2278:1: rule__Adapter_Name__Alternatives : ( (
	// RULE_ID ) | ( T ) | ( LT ) | ( DT ) );
	public final void rule__Adapter_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2282:1: ( ( RULE_ID ) | ( T ) | ( LT ) | ( DT
			// ) )
			int alt10 = 4;
			switch (input.LA(1)) {
			case RULE_ID: {
				alt10 = 1;
			}
				break;
			case T: {
				alt10 = 2;
			}
				break;
			case LT: {
				alt10 = 3;
			}
				break;
			case DT: {
				alt10 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 10, 0, input);

				throw nvae;
			}

			switch (alt10) {
			case 1:
			// InternalStructuredTextParser.g:2283:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:2283:2: ( RULE_ID )
				// InternalStructuredTextParser.g:2284:3: RULE_ID
				{
					before(grammarAccess.getAdapter_NameAccess().getIDTerminalRuleCall_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getAdapter_NameAccess().getIDTerminalRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2289:2: ( T )
			{
				// InternalStructuredTextParser.g:2289:2: ( T )
				// InternalStructuredTextParser.g:2290:3: T
				{
					before(grammarAccess.getAdapter_NameAccess().getTKeyword_1());
					match(input, T, FOLLOW_2);
					after(grammarAccess.getAdapter_NameAccess().getTKeyword_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2295:2: ( LT )
			{
				// InternalStructuredTextParser.g:2295:2: ( LT )
				// InternalStructuredTextParser.g:2296:3: LT
				{
					before(grammarAccess.getAdapter_NameAccess().getLTKeyword_2());
					match(input, LT, FOLLOW_2);
					after(grammarAccess.getAdapter_NameAccess().getLTKeyword_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2301:2: ( DT )
			{
				// InternalStructuredTextParser.g:2301:2: ( DT )
				// InternalStructuredTextParser.g:2302:3: DT
				{
					before(grammarAccess.getAdapter_NameAccess().getDTKeyword_3());
					match(input, DT, FOLLOW_2);
					after(grammarAccess.getAdapter_NameAccess().getDTKeyword_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Adapter_Name__Alternatives"

	// $ANTLR start "rule__Variable_Name__Alternatives"
	// InternalStructuredTextParser.g:2311:1: rule__Variable_Name__Alternatives : (
	// ( RULE_ID ) | ( T ) | ( LT ) | ( DT ) );
	public final void rule__Variable_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2315:1: ( ( RULE_ID ) | ( T ) | ( LT ) | ( DT
			// ) )
			int alt11 = 4;
			switch (input.LA(1)) {
			case RULE_ID: {
				alt11 = 1;
			}
				break;
			case T: {
				alt11 = 2;
			}
				break;
			case LT: {
				alt11 = 3;
			}
				break;
			case DT: {
				alt11 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 11, 0, input);

				throw nvae;
			}

			switch (alt11) {
			case 1:
			// InternalStructuredTextParser.g:2316:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:2316:2: ( RULE_ID )
				// InternalStructuredTextParser.g:2317:3: RULE_ID
				{
					before(grammarAccess.getVariable_NameAccess().getIDTerminalRuleCall_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getVariable_NameAccess().getIDTerminalRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2322:2: ( T )
			{
				// InternalStructuredTextParser.g:2322:2: ( T )
				// InternalStructuredTextParser.g:2323:3: T
				{
					before(grammarAccess.getVariable_NameAccess().getTKeyword_1());
					match(input, T, FOLLOW_2);
					after(grammarAccess.getVariable_NameAccess().getTKeyword_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2328:2: ( LT )
			{
				// InternalStructuredTextParser.g:2328:2: ( LT )
				// InternalStructuredTextParser.g:2329:3: LT
				{
					before(grammarAccess.getVariable_NameAccess().getLTKeyword_2());
					match(input, LT, FOLLOW_2);
					after(grammarAccess.getVariable_NameAccess().getLTKeyword_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2334:2: ( DT )
			{
				// InternalStructuredTextParser.g:2334:2: ( DT )
				// InternalStructuredTextParser.g:2335:3: DT
				{
					before(grammarAccess.getVariable_NameAccess().getDTKeyword_3());
					match(input, DT, FOLLOW_2);
					after(grammarAccess.getVariable_NameAccess().getDTKeyword_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Name__Alternatives"

	// $ANTLR start "rule__Constant__Alternatives"
	// InternalStructuredTextParser.g:2344:1: rule__Constant__Alternatives : ( (
	// ruleNumeric_Literal ) | ( ruleChar_Literal ) | ( ruleTime_Literal ) | (
	// ruleBool_Literal ) );
	public final void rule__Constant__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2348:1: ( ( ruleNumeric_Literal ) | (
			// ruleChar_Literal ) | ( ruleTime_Literal ) | ( ruleBool_Literal ) )
			int alt12 = 4;
			switch (input.LA(1)) {
			case LREAL:
			case UDINT:
			case ULINT:
			case USINT:
			case DINT:
			case LINT:
			case REAL:
			case SINT:
			case UINT:
			case INT:
			case PlusSign:
			case HyphenMinus:
			case RULE_BINARY_INT:
			case RULE_OCTAL_INT:
			case RULE_HEX_INT:
			case RULE_UNSIGNED_INT: {
				alt12 = 1;
			}
				break;
			case WSTRING:
			case STRING:
			case WCHAR:
			case CHAR:
			case RULE_S_BYTE_CHAR_STR:
			case RULE_D_BYTE_CHAR_STR: {
				alt12 = 2;
			}
				break;
			case LDATE_AND_TIME:
			case DATE_AND_TIME:
			case LTIME_OF_DAY:
			case TIME_OF_DAY:
			case LDATE:
			case LTIME:
			case DATE:
			case LTOD:
			case TIME:
			case LDT:
			case TOD:
			case DT:
			case LD:
			case LT:
			case T:
			case D_1: {
				alt12 = 3;
			}
				break;
			case FALSE:
			case BOOL:
			case TRUE: {
				alt12 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 12, 0, input);

				throw nvae;
			}

			switch (alt12) {
			case 1:
			// InternalStructuredTextParser.g:2349:2: ( ruleNumeric_Literal )
			{
				// InternalStructuredTextParser.g:2349:2: ( ruleNumeric_Literal )
				// InternalStructuredTextParser.g:2350:3: ruleNumeric_Literal
				{
					before(grammarAccess.getConstantAccess().getNumeric_LiteralParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleNumeric_Literal();

					state._fsp--;

					after(grammarAccess.getConstantAccess().getNumeric_LiteralParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2355:2: ( ruleChar_Literal )
			{
				// InternalStructuredTextParser.g:2355:2: ( ruleChar_Literal )
				// InternalStructuredTextParser.g:2356:3: ruleChar_Literal
				{
					before(grammarAccess.getConstantAccess().getChar_LiteralParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleChar_Literal();

					state._fsp--;

					after(grammarAccess.getConstantAccess().getChar_LiteralParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2361:2: ( ruleTime_Literal )
			{
				// InternalStructuredTextParser.g:2361:2: ( ruleTime_Literal )
				// InternalStructuredTextParser.g:2362:3: ruleTime_Literal
				{
					before(grammarAccess.getConstantAccess().getTime_LiteralParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleTime_Literal();

					state._fsp--;

					after(grammarAccess.getConstantAccess().getTime_LiteralParserRuleCall_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2367:2: ( ruleBool_Literal )
			{
				// InternalStructuredTextParser.g:2367:2: ( ruleBool_Literal )
				// InternalStructuredTextParser.g:2368:3: ruleBool_Literal
				{
					before(grammarAccess.getConstantAccess().getBool_LiteralParserRuleCall_3());
					pushFollow(FOLLOW_2);
					ruleBool_Literal();

					state._fsp--;

					after(grammarAccess.getConstantAccess().getBool_LiteralParserRuleCall_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Constant__Alternatives"

	// $ANTLR start "rule__Numeric_Literal__Alternatives"
	// InternalStructuredTextParser.g:2377:1: rule__Numeric_Literal__Alternatives :
	// ( ( ruleInt_Literal ) | ( ruleReal_Literal ) );
	public final void rule__Numeric_Literal__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2381:1: ( ( ruleInt_Literal ) | (
			// ruleReal_Literal ) )
			int alt13 = 2;
			switch (input.LA(1)) {
			case UDINT:
			case ULINT:
			case USINT:
			case DINT:
			case LINT:
			case SINT:
			case UINT:
			case INT:
			case RULE_BINARY_INT:
			case RULE_OCTAL_INT:
			case RULE_HEX_INT: {
				alt13 = 1;
			}
				break;
			case PlusSign: {
				int LA13_2 = input.LA(2);

				if ((LA13_2 == RULE_UNSIGNED_INT)) {
					int LA13_4 = input.LA(3);

					if ((LA13_4 == EOF || LA13_4 == END_REPEAT || LA13_4 == THEN || LA13_4 == AND || LA13_4 == MOD
							|| (LA13_4 >= XOR && LA13_4 <= AsteriskAsterisk)
							|| (LA13_4 >= LessThanSignEqualsSign && LA13_4 <= LessThanSignGreaterThanSign)
							|| (LA13_4 >= GreaterThanSignEqualsSign && LA13_4 <= DO) || (LA13_4 >= OF && LA13_4 <= TO)
							|| LA13_4 == Ampersand || (LA13_4 >= RightParenthesis && LA13_4 <= HyphenMinus)
							|| (LA13_4 >= Solidus && LA13_4 <= GreaterThanSign) || LA13_4 == RightSquareBracket)) {
						alt13 = 1;
					} else if ((LA13_4 == FullStop)) {
						alt13 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 13, 4, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("", 13, 2, input);

					throw nvae;
				}
			}
				break;
			case HyphenMinus: {
				int LA13_3 = input.LA(2);

				if ((LA13_3 == RULE_UNSIGNED_INT)) {
					int LA13_4 = input.LA(3);

					if ((LA13_4 == EOF || LA13_4 == END_REPEAT || LA13_4 == THEN || LA13_4 == AND || LA13_4 == MOD
							|| (LA13_4 >= XOR && LA13_4 <= AsteriskAsterisk)
							|| (LA13_4 >= LessThanSignEqualsSign && LA13_4 <= LessThanSignGreaterThanSign)
							|| (LA13_4 >= GreaterThanSignEqualsSign && LA13_4 <= DO) || (LA13_4 >= OF && LA13_4 <= TO)
							|| LA13_4 == Ampersand || (LA13_4 >= RightParenthesis && LA13_4 <= HyphenMinus)
							|| (LA13_4 >= Solidus && LA13_4 <= GreaterThanSign) || LA13_4 == RightSquareBracket)) {
						alt13 = 1;
					} else if ((LA13_4 == FullStop)) {
						alt13 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("", 13, 4, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("", 13, 3, input);

					throw nvae;
				}
			}
				break;
			case RULE_UNSIGNED_INT: {
				int LA13_4 = input.LA(2);

				if ((LA13_4 == EOF || LA13_4 == END_REPEAT || LA13_4 == THEN || LA13_4 == AND || LA13_4 == MOD
						|| (LA13_4 >= XOR && LA13_4 <= AsteriskAsterisk)
						|| (LA13_4 >= LessThanSignEqualsSign && LA13_4 <= LessThanSignGreaterThanSign)
						|| (LA13_4 >= GreaterThanSignEqualsSign && LA13_4 <= DO) || (LA13_4 >= OF && LA13_4 <= TO)
						|| LA13_4 == Ampersand || (LA13_4 >= RightParenthesis && LA13_4 <= HyphenMinus)
						|| (LA13_4 >= Solidus && LA13_4 <= GreaterThanSign) || LA13_4 == RightSquareBracket)) {
					alt13 = 1;
				} else if ((LA13_4 == FullStop)) {
					alt13 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 13, 4, input);

					throw nvae;
				}
			}
				break;
			case LREAL:
			case REAL: {
				alt13 = 2;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

				throw nvae;
			}

			switch (alt13) {
			case 1:
			// InternalStructuredTextParser.g:2382:2: ( ruleInt_Literal )
			{
				// InternalStructuredTextParser.g:2382:2: ( ruleInt_Literal )
				// InternalStructuredTextParser.g:2383:3: ruleInt_Literal
				{
					before(grammarAccess.getNumeric_LiteralAccess().getInt_LiteralParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleInt_Literal();

					state._fsp--;

					after(grammarAccess.getNumeric_LiteralAccess().getInt_LiteralParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2388:2: ( ruleReal_Literal )
			{
				// InternalStructuredTextParser.g:2388:2: ( ruleReal_Literal )
				// InternalStructuredTextParser.g:2389:3: ruleReal_Literal
				{
					before(grammarAccess.getNumeric_LiteralAccess().getReal_LiteralParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleReal_Literal();

					state._fsp--;

					after(grammarAccess.getNumeric_LiteralAccess().getReal_LiteralParserRuleCall_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Numeric_Literal__Alternatives"

	// $ANTLR start "rule__Int_Literal__ValueAlternatives_1_0"
	// InternalStructuredTextParser.g:2398:1:
	// rule__Int_Literal__ValueAlternatives_1_0 : ( ( ruleSigned_Int ) | (
	// RULE_BINARY_INT ) | ( RULE_OCTAL_INT ) | ( RULE_HEX_INT ) );
	public final void rule__Int_Literal__ValueAlternatives_1_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2402:1: ( ( ruleSigned_Int ) | (
			// RULE_BINARY_INT ) | ( RULE_OCTAL_INT ) | ( RULE_HEX_INT ) )
			int alt14 = 4;
			switch (input.LA(1)) {
			case PlusSign:
			case HyphenMinus:
			case RULE_UNSIGNED_INT: {
				alt14 = 1;
			}
				break;
			case RULE_BINARY_INT: {
				alt14 = 2;
			}
				break;
			case RULE_OCTAL_INT: {
				alt14 = 3;
			}
				break;
			case RULE_HEX_INT: {
				alt14 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 14, 0, input);

				throw nvae;
			}

			switch (alt14) {
			case 1:
			// InternalStructuredTextParser.g:2403:2: ( ruleSigned_Int )
			{
				// InternalStructuredTextParser.g:2403:2: ( ruleSigned_Int )
				// InternalStructuredTextParser.g:2404:3: ruleSigned_Int
				{
					before(grammarAccess.getInt_LiteralAccess().getValueSigned_IntParserRuleCall_1_0_0());
					pushFollow(FOLLOW_2);
					ruleSigned_Int();

					state._fsp--;

					after(grammarAccess.getInt_LiteralAccess().getValueSigned_IntParserRuleCall_1_0_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2409:2: ( RULE_BINARY_INT )
			{
				// InternalStructuredTextParser.g:2409:2: ( RULE_BINARY_INT )
				// InternalStructuredTextParser.g:2410:3: RULE_BINARY_INT
				{
					before(grammarAccess.getInt_LiteralAccess().getValueBINARY_INTTerminalRuleCall_1_0_1());
					match(input, RULE_BINARY_INT, FOLLOW_2);
					after(grammarAccess.getInt_LiteralAccess().getValueBINARY_INTTerminalRuleCall_1_0_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2415:2: ( RULE_OCTAL_INT )
			{
				// InternalStructuredTextParser.g:2415:2: ( RULE_OCTAL_INT )
				// InternalStructuredTextParser.g:2416:3: RULE_OCTAL_INT
				{
					before(grammarAccess.getInt_LiteralAccess().getValueOCTAL_INTTerminalRuleCall_1_0_2());
					match(input, RULE_OCTAL_INT, FOLLOW_2);
					after(grammarAccess.getInt_LiteralAccess().getValueOCTAL_INTTerminalRuleCall_1_0_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2421:2: ( RULE_HEX_INT )
			{
				// InternalStructuredTextParser.g:2421:2: ( RULE_HEX_INT )
				// InternalStructuredTextParser.g:2422:3: RULE_HEX_INT
				{
					before(grammarAccess.getInt_LiteralAccess().getValueHEX_INTTerminalRuleCall_1_0_3());
					match(input, RULE_HEX_INT, FOLLOW_2);
					after(grammarAccess.getInt_LiteralAccess().getValueHEX_INTTerminalRuleCall_1_0_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__ValueAlternatives_1_0"

	// $ANTLR start "rule__Signed_Int__Alternatives_0"
	// InternalStructuredTextParser.g:2431:1: rule__Signed_Int__Alternatives_0 : ( (
	// PlusSign ) | ( HyphenMinus ) );
	public final void rule__Signed_Int__Alternatives_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2435:1: ( ( PlusSign ) | ( HyphenMinus ) )
			int alt15 = 2;
			int LA15_0 = input.LA(1);

			if ((LA15_0 == PlusSign)) {
				alt15 = 1;
			} else if ((LA15_0 == HyphenMinus)) {
				alt15 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 15, 0, input);

				throw nvae;
			}
			switch (alt15) {
			case 1:
			// InternalStructuredTextParser.g:2436:2: ( PlusSign )
			{
				// InternalStructuredTextParser.g:2436:2: ( PlusSign )
				// InternalStructuredTextParser.g:2437:3: PlusSign
				{
					before(grammarAccess.getSigned_IntAccess().getPlusSignKeyword_0_0());
					match(input, PlusSign, FOLLOW_2);
					after(grammarAccess.getSigned_IntAccess().getPlusSignKeyword_0_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2442:2: ( HyphenMinus )
			{
				// InternalStructuredTextParser.g:2442:2: ( HyphenMinus )
				// InternalStructuredTextParser.g:2443:3: HyphenMinus
				{
					before(grammarAccess.getSigned_IntAccess().getHyphenMinusKeyword_0_1());
					match(input, HyphenMinus, FOLLOW_2);
					after(grammarAccess.getSigned_IntAccess().getHyphenMinusKeyword_0_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Signed_Int__Alternatives_0"

	// $ANTLR start "rule__Bool_Value__Alternatives"
	// InternalStructuredTextParser.g:2452:1: rule__Bool_Value__Alternatives : ( (
	// FALSE ) | ( TRUE ) );
	public final void rule__Bool_Value__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2456:1: ( ( FALSE ) | ( TRUE ) )
			int alt16 = 2;
			int LA16_0 = input.LA(1);

			if ((LA16_0 == FALSE)) {
				alt16 = 1;
			} else if ((LA16_0 == TRUE)) {
				alt16 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

				throw nvae;
			}
			switch (alt16) {
			case 1:
			// InternalStructuredTextParser.g:2457:2: ( FALSE )
			{
				// InternalStructuredTextParser.g:2457:2: ( FALSE )
				// InternalStructuredTextParser.g:2458:3: FALSE
				{
					before(grammarAccess.getBool_ValueAccess().getFALSEKeyword_0());
					match(input, FALSE, FOLLOW_2);
					after(grammarAccess.getBool_ValueAccess().getFALSEKeyword_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2463:2: ( TRUE )
			{
				// InternalStructuredTextParser.g:2463:2: ( TRUE )
				// InternalStructuredTextParser.g:2464:3: TRUE
				{
					before(grammarAccess.getBool_ValueAccess().getTRUEKeyword_1());
					match(input, TRUE, FOLLOW_2);
					after(grammarAccess.getBool_ValueAccess().getTRUEKeyword_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Value__Alternatives"

	// $ANTLR start "rule__Char_Literal__ValueAlternatives_1_0"
	// InternalStructuredTextParser.g:2473:1:
	// rule__Char_Literal__ValueAlternatives_1_0 : ( ( RULE_S_BYTE_CHAR_STR ) | (
	// RULE_D_BYTE_CHAR_STR ) );
	public final void rule__Char_Literal__ValueAlternatives_1_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2477:1: ( ( RULE_S_BYTE_CHAR_STR ) | (
			// RULE_D_BYTE_CHAR_STR ) )
			int alt17 = 2;
			int LA17_0 = input.LA(1);

			if ((LA17_0 == RULE_S_BYTE_CHAR_STR)) {
				alt17 = 1;
			} else if ((LA17_0 == RULE_D_BYTE_CHAR_STR)) {
				alt17 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 17, 0, input);

				throw nvae;
			}
			switch (alt17) {
			case 1:
			// InternalStructuredTextParser.g:2478:2: ( RULE_S_BYTE_CHAR_STR )
			{
				// InternalStructuredTextParser.g:2478:2: ( RULE_S_BYTE_CHAR_STR )
				// InternalStructuredTextParser.g:2479:3: RULE_S_BYTE_CHAR_STR
				{
					before(grammarAccess.getChar_LiteralAccess().getValueS_BYTE_CHAR_STRTerminalRuleCall_1_0_0());
					match(input, RULE_S_BYTE_CHAR_STR, FOLLOW_2);
					after(grammarAccess.getChar_LiteralAccess().getValueS_BYTE_CHAR_STRTerminalRuleCall_1_0_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2484:2: ( RULE_D_BYTE_CHAR_STR )
			{
				// InternalStructuredTextParser.g:2484:2: ( RULE_D_BYTE_CHAR_STR )
				// InternalStructuredTextParser.g:2485:3: RULE_D_BYTE_CHAR_STR
				{
					before(grammarAccess.getChar_LiteralAccess().getValueD_BYTE_CHAR_STRTerminalRuleCall_1_0_1());
					match(input, RULE_D_BYTE_CHAR_STR, FOLLOW_2);
					after(grammarAccess.getChar_LiteralAccess().getValueD_BYTE_CHAR_STRTerminalRuleCall_1_0_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__ValueAlternatives_1_0"

	// $ANTLR start "rule__Time_Literal__Alternatives"
	// InternalStructuredTextParser.g:2494:1: rule__Time_Literal__Alternatives : ( (
	// ruleDuration ) | ( ruleTime_Of_Day ) | ( ruleDate ) | ( ruleDate_And_Time )
	// );
	public final void rule__Time_Literal__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2498:1: ( ( ruleDuration ) | ( ruleTime_Of_Day
			// ) | ( ruleDate ) | ( ruleDate_And_Time ) )
			int alt18 = 4;
			switch (input.LA(1)) {
			case LTIME:
			case TIME:
			case LT:
			case T: {
				alt18 = 1;
			}
				break;
			case LTIME_OF_DAY:
			case TIME_OF_DAY:
			case LTOD:
			case TOD: {
				alt18 = 2;
			}
				break;
			case LDATE:
			case DATE:
			case LD:
			case D_1: {
				alt18 = 3;
			}
				break;
			case LDATE_AND_TIME:
			case DATE_AND_TIME:
			case LDT:
			case DT: {
				alt18 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 18, 0, input);

				throw nvae;
			}

			switch (alt18) {
			case 1:
			// InternalStructuredTextParser.g:2499:2: ( ruleDuration )
			{
				// InternalStructuredTextParser.g:2499:2: ( ruleDuration )
				// InternalStructuredTextParser.g:2500:3: ruleDuration
				{
					before(grammarAccess.getTime_LiteralAccess().getDurationParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleDuration();

					state._fsp--;

					after(grammarAccess.getTime_LiteralAccess().getDurationParserRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2505:2: ( ruleTime_Of_Day )
			{
				// InternalStructuredTextParser.g:2505:2: ( ruleTime_Of_Day )
				// InternalStructuredTextParser.g:2506:3: ruleTime_Of_Day
				{
					before(grammarAccess.getTime_LiteralAccess().getTime_Of_DayParserRuleCall_1());
					pushFollow(FOLLOW_2);
					ruleTime_Of_Day();

					state._fsp--;

					after(grammarAccess.getTime_LiteralAccess().getTime_Of_DayParserRuleCall_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2511:2: ( ruleDate )
			{
				// InternalStructuredTextParser.g:2511:2: ( ruleDate )
				// InternalStructuredTextParser.g:2512:3: ruleDate
				{
					before(grammarAccess.getTime_LiteralAccess().getDateParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleDate();

					state._fsp--;

					after(grammarAccess.getTime_LiteralAccess().getDateParserRuleCall_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2517:2: ( ruleDate_And_Time )
			{
				// InternalStructuredTextParser.g:2517:2: ( ruleDate_And_Time )
				// InternalStructuredTextParser.g:2518:3: ruleDate_And_Time
				{
					before(grammarAccess.getTime_LiteralAccess().getDate_And_TimeParserRuleCall_3());
					pushFollow(FOLLOW_2);
					ruleDate_And_Time();

					state._fsp--;

					after(grammarAccess.getTime_LiteralAccess().getDate_And_TimeParserRuleCall_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Literal__Alternatives"

	// $ANTLR start "rule__Duration__Alternatives_2"
	// InternalStructuredTextParser.g:2527:1: rule__Duration__Alternatives_2 : ( (
	// PlusSign ) | ( ( rule__Duration__NegativeAssignment_2_1 ) ) );
	public final void rule__Duration__Alternatives_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2531:1: ( ( PlusSign ) | ( (
			// rule__Duration__NegativeAssignment_2_1 ) ) )
			int alt19 = 2;
			int LA19_0 = input.LA(1);

			if ((LA19_0 == PlusSign)) {
				alt19 = 1;
			} else if ((LA19_0 == HyphenMinus)) {
				alt19 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 19, 0, input);

				throw nvae;
			}
			switch (alt19) {
			case 1:
			// InternalStructuredTextParser.g:2532:2: ( PlusSign )
			{
				// InternalStructuredTextParser.g:2532:2: ( PlusSign )
				// InternalStructuredTextParser.g:2533:3: PlusSign
				{
					before(grammarAccess.getDurationAccess().getPlusSignKeyword_2_0());
					match(input, PlusSign, FOLLOW_2);
					after(grammarAccess.getDurationAccess().getPlusSignKeyword_2_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2538:2: ( (
			// rule__Duration__NegativeAssignment_2_1 ) )
			{
				// InternalStructuredTextParser.g:2538:2: ( (
				// rule__Duration__NegativeAssignment_2_1 ) )
				// InternalStructuredTextParser.g:2539:3: (
				// rule__Duration__NegativeAssignment_2_1 )
				{
					before(grammarAccess.getDurationAccess().getNegativeAssignment_2_1());
					// InternalStructuredTextParser.g:2540:3: (
					// rule__Duration__NegativeAssignment_2_1 )
					// InternalStructuredTextParser.g:2540:4: rule__Duration__NegativeAssignment_2_1
					{
						pushFollow(FOLLOW_2);
						rule__Duration__NegativeAssignment_2_1();

						state._fsp--;

					}

					after(grammarAccess.getDurationAccess().getNegativeAssignment_2_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Alternatives_2"

	// $ANTLR start "rule__Type_Name__Alternatives"
	// InternalStructuredTextParser.g:2548:1: rule__Type_Name__Alternatives : ( (
	// RULE_ID ) | ( DINT ) | ( INT ) | ( SINT ) | ( LINT ) | ( UINT ) | ( USINT ) |
	// ( UDINT ) | ( ULINT ) | ( REAL ) | ( LREAL ) | ( STRING ) | ( WSTRING ) | (
	// CHAR ) | ( WCHAR ) | ( TIME ) | ( LTIME ) | ( TIME_OF_DAY ) | ( LTIME_OF_DAY
	// ) | ( TOD ) | ( LTOD ) | ( DATE ) | ( LDATE ) | ( DATE_AND_TIME ) | (
	// LDATE_AND_TIME ) | ( BOOL ) );
	public final void rule__Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2552:1: ( ( RULE_ID ) | ( DINT ) | ( INT ) | (
			// SINT ) | ( LINT ) | ( UINT ) | ( USINT ) | ( UDINT ) | ( ULINT ) | ( REAL ) |
			// ( LREAL ) | ( STRING ) | ( WSTRING ) | ( CHAR ) | ( WCHAR ) | ( TIME ) | (
			// LTIME ) | ( TIME_OF_DAY ) | ( LTIME_OF_DAY ) | ( TOD ) | ( LTOD ) | ( DATE )
			// | ( LDATE ) | ( DATE_AND_TIME ) | ( LDATE_AND_TIME ) | ( BOOL ) )
			int alt20 = 26;
			switch (input.LA(1)) {
			case RULE_ID: {
				alt20 = 1;
			}
				break;
			case DINT: {
				alt20 = 2;
			}
				break;
			case INT: {
				alt20 = 3;
			}
				break;
			case SINT: {
				alt20 = 4;
			}
				break;
			case LINT: {
				alt20 = 5;
			}
				break;
			case UINT: {
				alt20 = 6;
			}
				break;
			case USINT: {
				alt20 = 7;
			}
				break;
			case UDINT: {
				alt20 = 8;
			}
				break;
			case ULINT: {
				alt20 = 9;
			}
				break;
			case REAL: {
				alt20 = 10;
			}
				break;
			case LREAL: {
				alt20 = 11;
			}
				break;
			case STRING: {
				alt20 = 12;
			}
				break;
			case WSTRING: {
				alt20 = 13;
			}
				break;
			case CHAR: {
				alt20 = 14;
			}
				break;
			case WCHAR: {
				alt20 = 15;
			}
				break;
			case TIME: {
				alt20 = 16;
			}
				break;
			case LTIME: {
				alt20 = 17;
			}
				break;
			case TIME_OF_DAY: {
				alt20 = 18;
			}
				break;
			case LTIME_OF_DAY: {
				alt20 = 19;
			}
				break;
			case TOD: {
				alt20 = 20;
			}
				break;
			case LTOD: {
				alt20 = 21;
			}
				break;
			case DATE: {
				alt20 = 22;
			}
				break;
			case LDATE: {
				alt20 = 23;
			}
				break;
			case DATE_AND_TIME: {
				alt20 = 24;
			}
				break;
			case LDATE_AND_TIME: {
				alt20 = 25;
			}
				break;
			case BOOL: {
				alt20 = 26;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 20, 0, input);

				throw nvae;
			}

			switch (alt20) {
			case 1:
			// InternalStructuredTextParser.g:2553:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:2553:2: ( RULE_ID )
				// InternalStructuredTextParser.g:2554:3: RULE_ID
				{
					before(grammarAccess.getType_NameAccess().getIDTerminalRuleCall_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getIDTerminalRuleCall_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2559:2: ( DINT )
			{
				// InternalStructuredTextParser.g:2559:2: ( DINT )
				// InternalStructuredTextParser.g:2560:3: DINT
				{
					before(grammarAccess.getType_NameAccess().getDINTKeyword_1());
					match(input, DINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getDINTKeyword_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2565:2: ( INT )
			{
				// InternalStructuredTextParser.g:2565:2: ( INT )
				// InternalStructuredTextParser.g:2566:3: INT
				{
					before(grammarAccess.getType_NameAccess().getINTKeyword_2());
					match(input, INT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getINTKeyword_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2571:2: ( SINT )
			{
				// InternalStructuredTextParser.g:2571:2: ( SINT )
				// InternalStructuredTextParser.g:2572:3: SINT
				{
					before(grammarAccess.getType_NameAccess().getSINTKeyword_3());
					match(input, SINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getSINTKeyword_3());

				}

			}
				break;
			case 5:
			// InternalStructuredTextParser.g:2577:2: ( LINT )
			{
				// InternalStructuredTextParser.g:2577:2: ( LINT )
				// InternalStructuredTextParser.g:2578:3: LINT
				{
					before(grammarAccess.getType_NameAccess().getLINTKeyword_4());
					match(input, LINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLINTKeyword_4());

				}

			}
				break;
			case 6:
			// InternalStructuredTextParser.g:2583:2: ( UINT )
			{
				// InternalStructuredTextParser.g:2583:2: ( UINT )
				// InternalStructuredTextParser.g:2584:3: UINT
				{
					before(grammarAccess.getType_NameAccess().getUINTKeyword_5());
					match(input, UINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getUINTKeyword_5());

				}

			}
				break;
			case 7:
			// InternalStructuredTextParser.g:2589:2: ( USINT )
			{
				// InternalStructuredTextParser.g:2589:2: ( USINT )
				// InternalStructuredTextParser.g:2590:3: USINT
				{
					before(grammarAccess.getType_NameAccess().getUSINTKeyword_6());
					match(input, USINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getUSINTKeyword_6());

				}

			}
				break;
			case 8:
			// InternalStructuredTextParser.g:2595:2: ( UDINT )
			{
				// InternalStructuredTextParser.g:2595:2: ( UDINT )
				// InternalStructuredTextParser.g:2596:3: UDINT
				{
					before(grammarAccess.getType_NameAccess().getUDINTKeyword_7());
					match(input, UDINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getUDINTKeyword_7());

				}

			}
				break;
			case 9:
			// InternalStructuredTextParser.g:2601:2: ( ULINT )
			{
				// InternalStructuredTextParser.g:2601:2: ( ULINT )
				// InternalStructuredTextParser.g:2602:3: ULINT
				{
					before(grammarAccess.getType_NameAccess().getULINTKeyword_8());
					match(input, ULINT, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getULINTKeyword_8());

				}

			}
				break;
			case 10:
			// InternalStructuredTextParser.g:2607:2: ( REAL )
			{
				// InternalStructuredTextParser.g:2607:2: ( REAL )
				// InternalStructuredTextParser.g:2608:3: REAL
				{
					before(grammarAccess.getType_NameAccess().getREALKeyword_9());
					match(input, REAL, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getREALKeyword_9());

				}

			}
				break;
			case 11:
			// InternalStructuredTextParser.g:2613:2: ( LREAL )
			{
				// InternalStructuredTextParser.g:2613:2: ( LREAL )
				// InternalStructuredTextParser.g:2614:3: LREAL
				{
					before(grammarAccess.getType_NameAccess().getLREALKeyword_10());
					match(input, LREAL, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLREALKeyword_10());

				}

			}
				break;
			case 12:
			// InternalStructuredTextParser.g:2619:2: ( STRING )
			{
				// InternalStructuredTextParser.g:2619:2: ( STRING )
				// InternalStructuredTextParser.g:2620:3: STRING
				{
					before(grammarAccess.getType_NameAccess().getSTRINGKeyword_11());
					match(input, STRING, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getSTRINGKeyword_11());

				}

			}
				break;
			case 13:
			// InternalStructuredTextParser.g:2625:2: ( WSTRING )
			{
				// InternalStructuredTextParser.g:2625:2: ( WSTRING )
				// InternalStructuredTextParser.g:2626:3: WSTRING
				{
					before(grammarAccess.getType_NameAccess().getWSTRINGKeyword_12());
					match(input, WSTRING, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getWSTRINGKeyword_12());

				}

			}
				break;
			case 14:
			// InternalStructuredTextParser.g:2631:2: ( CHAR )
			{
				// InternalStructuredTextParser.g:2631:2: ( CHAR )
				// InternalStructuredTextParser.g:2632:3: CHAR
				{
					before(grammarAccess.getType_NameAccess().getCHARKeyword_13());
					match(input, CHAR, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getCHARKeyword_13());

				}

			}
				break;
			case 15:
			// InternalStructuredTextParser.g:2637:2: ( WCHAR )
			{
				// InternalStructuredTextParser.g:2637:2: ( WCHAR )
				// InternalStructuredTextParser.g:2638:3: WCHAR
				{
					before(grammarAccess.getType_NameAccess().getWCHARKeyword_14());
					match(input, WCHAR, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getWCHARKeyword_14());

				}

			}
				break;
			case 16:
			// InternalStructuredTextParser.g:2643:2: ( TIME )
			{
				// InternalStructuredTextParser.g:2643:2: ( TIME )
				// InternalStructuredTextParser.g:2644:3: TIME
				{
					before(grammarAccess.getType_NameAccess().getTIMEKeyword_15());
					match(input, TIME, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getTIMEKeyword_15());

				}

			}
				break;
			case 17:
			// InternalStructuredTextParser.g:2649:2: ( LTIME )
			{
				// InternalStructuredTextParser.g:2649:2: ( LTIME )
				// InternalStructuredTextParser.g:2650:3: LTIME
				{
					before(grammarAccess.getType_NameAccess().getLTIMEKeyword_16());
					match(input, LTIME, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLTIMEKeyword_16());

				}

			}
				break;
			case 18:
			// InternalStructuredTextParser.g:2655:2: ( TIME_OF_DAY )
			{
				// InternalStructuredTextParser.g:2655:2: ( TIME_OF_DAY )
				// InternalStructuredTextParser.g:2656:3: TIME_OF_DAY
				{
					before(grammarAccess.getType_NameAccess().getTIME_OF_DAYKeyword_17());
					match(input, TIME_OF_DAY, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getTIME_OF_DAYKeyword_17());

				}

			}
				break;
			case 19:
			// InternalStructuredTextParser.g:2661:2: ( LTIME_OF_DAY )
			{
				// InternalStructuredTextParser.g:2661:2: ( LTIME_OF_DAY )
				// InternalStructuredTextParser.g:2662:3: LTIME_OF_DAY
				{
					before(grammarAccess.getType_NameAccess().getLTIME_OF_DAYKeyword_18());
					match(input, LTIME_OF_DAY, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLTIME_OF_DAYKeyword_18());

				}

			}
				break;
			case 20:
			// InternalStructuredTextParser.g:2667:2: ( TOD )
			{
				// InternalStructuredTextParser.g:2667:2: ( TOD )
				// InternalStructuredTextParser.g:2668:3: TOD
				{
					before(grammarAccess.getType_NameAccess().getTODKeyword_19());
					match(input, TOD, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getTODKeyword_19());

				}

			}
				break;
			case 21:
			// InternalStructuredTextParser.g:2673:2: ( LTOD )
			{
				// InternalStructuredTextParser.g:2673:2: ( LTOD )
				// InternalStructuredTextParser.g:2674:3: LTOD
				{
					before(grammarAccess.getType_NameAccess().getLTODKeyword_20());
					match(input, LTOD, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLTODKeyword_20());

				}

			}
				break;
			case 22:
			// InternalStructuredTextParser.g:2679:2: ( DATE )
			{
				// InternalStructuredTextParser.g:2679:2: ( DATE )
				// InternalStructuredTextParser.g:2680:3: DATE
				{
					before(grammarAccess.getType_NameAccess().getDATEKeyword_21());
					match(input, DATE, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getDATEKeyword_21());

				}

			}
				break;
			case 23:
			// InternalStructuredTextParser.g:2685:2: ( LDATE )
			{
				// InternalStructuredTextParser.g:2685:2: ( LDATE )
				// InternalStructuredTextParser.g:2686:3: LDATE
				{
					before(grammarAccess.getType_NameAccess().getLDATEKeyword_22());
					match(input, LDATE, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLDATEKeyword_22());

				}

			}
				break;
			case 24:
			// InternalStructuredTextParser.g:2691:2: ( DATE_AND_TIME )
			{
				// InternalStructuredTextParser.g:2691:2: ( DATE_AND_TIME )
				// InternalStructuredTextParser.g:2692:3: DATE_AND_TIME
				{
					before(grammarAccess.getType_NameAccess().getDATE_AND_TIMEKeyword_23());
					match(input, DATE_AND_TIME, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getDATE_AND_TIMEKeyword_23());

				}

			}
				break;
			case 25:
			// InternalStructuredTextParser.g:2697:2: ( LDATE_AND_TIME )
			{
				// InternalStructuredTextParser.g:2697:2: ( LDATE_AND_TIME )
				// InternalStructuredTextParser.g:2698:3: LDATE_AND_TIME
				{
					before(grammarAccess.getType_NameAccess().getLDATE_AND_TIMEKeyword_24());
					match(input, LDATE_AND_TIME, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getLDATE_AND_TIMEKeyword_24());

				}

			}
				break;
			case 26:
			// InternalStructuredTextParser.g:2703:2: ( BOOL )
			{
				// InternalStructuredTextParser.g:2703:2: ( BOOL )
				// InternalStructuredTextParser.g:2704:3: BOOL
				{
					before(grammarAccess.getType_NameAccess().getBOOLKeyword_25());
					match(input, BOOL, FOLLOW_2);
					after(grammarAccess.getType_NameAccess().getBOOLKeyword_25());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Type_Name__Alternatives"

	// $ANTLR start "rule__And_Operator__Alternatives"
	// InternalStructuredTextParser.g:2713:1: rule__And_Operator__Alternatives : ( (
	// ( AND ) ) | ( ( Ampersand ) ) );
	public final void rule__And_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2717:1: ( ( ( AND ) ) | ( ( Ampersand ) ) )
			int alt21 = 2;
			int LA21_0 = input.LA(1);

			if ((LA21_0 == AND)) {
				alt21 = 1;
			} else if ((LA21_0 == Ampersand)) {
				alt21 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 21, 0, input);

				throw nvae;
			}
			switch (alt21) {
			case 1:
			// InternalStructuredTextParser.g:2718:2: ( ( AND ) )
			{
				// InternalStructuredTextParser.g:2718:2: ( ( AND ) )
				// InternalStructuredTextParser.g:2719:3: ( AND )
				{
					before(grammarAccess.getAnd_OperatorAccess().getANDEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2720:3: ( AND )
					// InternalStructuredTextParser.g:2720:4: AND
					{
						match(input, AND, FOLLOW_2);

					}

					after(grammarAccess.getAnd_OperatorAccess().getANDEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2724:2: ( ( Ampersand ) )
			{
				// InternalStructuredTextParser.g:2724:2: ( ( Ampersand ) )
				// InternalStructuredTextParser.g:2725:3: ( Ampersand )
				{
					before(grammarAccess.getAnd_OperatorAccess().getANDEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2726:3: ( Ampersand )
					// InternalStructuredTextParser.g:2726:4: Ampersand
					{
						match(input, Ampersand, FOLLOW_2);

					}

					after(grammarAccess.getAnd_OperatorAccess().getANDEnumLiteralDeclaration_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Operator__Alternatives"

	// $ANTLR start "rule__Compare_Operator__Alternatives"
	// InternalStructuredTextParser.g:2734:1: rule__Compare_Operator__Alternatives :
	// ( ( ( EqualsSign ) ) | ( ( LessThanSignGreaterThanSign ) ) );
	public final void rule__Compare_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2738:1: ( ( ( EqualsSign ) ) | ( (
			// LessThanSignGreaterThanSign ) ) )
			int alt22 = 2;
			int LA22_0 = input.LA(1);

			if ((LA22_0 == EqualsSign)) {
				alt22 = 1;
			} else if ((LA22_0 == LessThanSignGreaterThanSign)) {
				alt22 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 22, 0, input);

				throw nvae;
			}
			switch (alt22) {
			case 1:
			// InternalStructuredTextParser.g:2739:2: ( ( EqualsSign ) )
			{
				// InternalStructuredTextParser.g:2739:2: ( ( EqualsSign ) )
				// InternalStructuredTextParser.g:2740:3: ( EqualsSign )
				{
					before(grammarAccess.getCompare_OperatorAccess().getEQEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2741:3: ( EqualsSign )
					// InternalStructuredTextParser.g:2741:4: EqualsSign
					{
						match(input, EqualsSign, FOLLOW_2);

					}

					after(grammarAccess.getCompare_OperatorAccess().getEQEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2745:2: ( ( LessThanSignGreaterThanSign ) )
			{
				// InternalStructuredTextParser.g:2745:2: ( ( LessThanSignGreaterThanSign ) )
				// InternalStructuredTextParser.g:2746:3: ( LessThanSignGreaterThanSign )
				{
					before(grammarAccess.getCompare_OperatorAccess().getNEEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2747:3: ( LessThanSignGreaterThanSign )
					// InternalStructuredTextParser.g:2747:4: LessThanSignGreaterThanSign
					{
						match(input, LessThanSignGreaterThanSign, FOLLOW_2);

					}

					after(grammarAccess.getCompare_OperatorAccess().getNEEnumLiteralDeclaration_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Operator__Alternatives"

	// $ANTLR start "rule__Equ_Operator__Alternatives"
	// InternalStructuredTextParser.g:2755:1: rule__Equ_Operator__Alternatives : ( (
	// ( LessThanSign ) ) | ( ( LessThanSignEqualsSign ) ) | ( ( GreaterThanSign ) )
	// | ( ( GreaterThanSignEqualsSign ) ) );
	public final void rule__Equ_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2759:1: ( ( ( LessThanSign ) ) | ( (
			// LessThanSignEqualsSign ) ) | ( ( GreaterThanSign ) ) | ( (
			// GreaterThanSignEqualsSign ) ) )
			int alt23 = 4;
			switch (input.LA(1)) {
			case LessThanSign: {
				alt23 = 1;
			}
				break;
			case LessThanSignEqualsSign: {
				alt23 = 2;
			}
				break;
			case GreaterThanSign: {
				alt23 = 3;
			}
				break;
			case GreaterThanSignEqualsSign: {
				alt23 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 23, 0, input);

				throw nvae;
			}

			switch (alt23) {
			case 1:
			// InternalStructuredTextParser.g:2760:2: ( ( LessThanSign ) )
			{
				// InternalStructuredTextParser.g:2760:2: ( ( LessThanSign ) )
				// InternalStructuredTextParser.g:2761:3: ( LessThanSign )
				{
					before(grammarAccess.getEqu_OperatorAccess().getLTEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2762:3: ( LessThanSign )
					// InternalStructuredTextParser.g:2762:4: LessThanSign
					{
						match(input, LessThanSign, FOLLOW_2);

					}

					after(grammarAccess.getEqu_OperatorAccess().getLTEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2766:2: ( ( LessThanSignEqualsSign ) )
			{
				// InternalStructuredTextParser.g:2766:2: ( ( LessThanSignEqualsSign ) )
				// InternalStructuredTextParser.g:2767:3: ( LessThanSignEqualsSign )
				{
					before(grammarAccess.getEqu_OperatorAccess().getLEEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2768:3: ( LessThanSignEqualsSign )
					// InternalStructuredTextParser.g:2768:4: LessThanSignEqualsSign
					{
						match(input, LessThanSignEqualsSign, FOLLOW_2);

					}

					after(grammarAccess.getEqu_OperatorAccess().getLEEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2772:2: ( ( GreaterThanSign ) )
			{
				// InternalStructuredTextParser.g:2772:2: ( ( GreaterThanSign ) )
				// InternalStructuredTextParser.g:2773:3: ( GreaterThanSign )
				{
					before(grammarAccess.getEqu_OperatorAccess().getGTEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:2774:3: ( GreaterThanSign )
					// InternalStructuredTextParser.g:2774:4: GreaterThanSign
					{
						match(input, GreaterThanSign, FOLLOW_2);

					}

					after(grammarAccess.getEqu_OperatorAccess().getGTEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2778:2: ( ( GreaterThanSignEqualsSign ) )
			{
				// InternalStructuredTextParser.g:2778:2: ( ( GreaterThanSignEqualsSign ) )
				// InternalStructuredTextParser.g:2779:3: ( GreaterThanSignEqualsSign )
				{
					before(grammarAccess.getEqu_OperatorAccess().getGEEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:2780:3: ( GreaterThanSignEqualsSign )
					// InternalStructuredTextParser.g:2780:4: GreaterThanSignEqualsSign
					{
						match(input, GreaterThanSignEqualsSign, FOLLOW_2);

					}

					after(grammarAccess.getEqu_OperatorAccess().getGEEnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Operator__Alternatives"

	// $ANTLR start "rule__Add_Operator__Alternatives"
	// InternalStructuredTextParser.g:2788:1: rule__Add_Operator__Alternatives : ( (
	// ( PlusSign ) ) | ( ( HyphenMinus ) ) );
	public final void rule__Add_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2792:1: ( ( ( PlusSign ) ) | ( ( HyphenMinus )
			// ) )
			int alt24 = 2;
			int LA24_0 = input.LA(1);

			if ((LA24_0 == PlusSign)) {
				alt24 = 1;
			} else if ((LA24_0 == HyphenMinus)) {
				alt24 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 24, 0, input);

				throw nvae;
			}
			switch (alt24) {
			case 1:
			// InternalStructuredTextParser.g:2793:2: ( ( PlusSign ) )
			{
				// InternalStructuredTextParser.g:2793:2: ( ( PlusSign ) )
				// InternalStructuredTextParser.g:2794:3: ( PlusSign )
				{
					before(grammarAccess.getAdd_OperatorAccess().getADDEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2795:3: ( PlusSign )
					// InternalStructuredTextParser.g:2795:4: PlusSign
					{
						match(input, PlusSign, FOLLOW_2);

					}

					after(grammarAccess.getAdd_OperatorAccess().getADDEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2799:2: ( ( HyphenMinus ) )
			{
				// InternalStructuredTextParser.g:2799:2: ( ( HyphenMinus ) )
				// InternalStructuredTextParser.g:2800:3: ( HyphenMinus )
				{
					before(grammarAccess.getAdd_OperatorAccess().getSUBEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2801:3: ( HyphenMinus )
					// InternalStructuredTextParser.g:2801:4: HyphenMinus
					{
						match(input, HyphenMinus, FOLLOW_2);

					}

					after(grammarAccess.getAdd_OperatorAccess().getSUBEnumLiteralDeclaration_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Operator__Alternatives"

	// $ANTLR start "rule__Term_Operator__Alternatives"
	// InternalStructuredTextParser.g:2809:1: rule__Term_Operator__Alternatives : (
	// ( ( Asterisk ) ) | ( ( Solidus ) ) | ( ( MOD ) ) );
	public final void rule__Term_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2813:1: ( ( ( Asterisk ) ) | ( ( Solidus ) ) |
			// ( ( MOD ) ) )
			int alt25 = 3;
			switch (input.LA(1)) {
			case Asterisk: {
				alt25 = 1;
			}
				break;
			case Solidus: {
				alt25 = 2;
			}
				break;
			case MOD: {
				alt25 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 25, 0, input);

				throw nvae;
			}

			switch (alt25) {
			case 1:
			// InternalStructuredTextParser.g:2814:2: ( ( Asterisk ) )
			{
				// InternalStructuredTextParser.g:2814:2: ( ( Asterisk ) )
				// InternalStructuredTextParser.g:2815:3: ( Asterisk )
				{
					before(grammarAccess.getTerm_OperatorAccess().getMULEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2816:3: ( Asterisk )
					// InternalStructuredTextParser.g:2816:4: Asterisk
					{
						match(input, Asterisk, FOLLOW_2);

					}

					after(grammarAccess.getTerm_OperatorAccess().getMULEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2820:2: ( ( Solidus ) )
			{
				// InternalStructuredTextParser.g:2820:2: ( ( Solidus ) )
				// InternalStructuredTextParser.g:2821:3: ( Solidus )
				{
					before(grammarAccess.getTerm_OperatorAccess().getDIVEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2822:3: ( Solidus )
					// InternalStructuredTextParser.g:2822:4: Solidus
					{
						match(input, Solidus, FOLLOW_2);

					}

					after(grammarAccess.getTerm_OperatorAccess().getDIVEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2826:2: ( ( MOD ) )
			{
				// InternalStructuredTextParser.g:2826:2: ( ( MOD ) )
				// InternalStructuredTextParser.g:2827:3: ( MOD )
				{
					before(grammarAccess.getTerm_OperatorAccess().getMODEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:2828:3: ( MOD )
					// InternalStructuredTextParser.g:2828:4: MOD
					{
						match(input, MOD, FOLLOW_2);

					}

					after(grammarAccess.getTerm_OperatorAccess().getMODEnumLiteralDeclaration_2());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term_Operator__Alternatives"

	// $ANTLR start "rule__Unary_Operator__Alternatives"
	// InternalStructuredTextParser.g:2836:1: rule__Unary_Operator__Alternatives : (
	// ( ( HyphenMinus ) ) | ( ( PlusSign ) ) | ( ( NOT ) ) );
	public final void rule__Unary_Operator__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2840:1: ( ( ( HyphenMinus ) ) | ( ( PlusSign )
			// ) | ( ( NOT ) ) )
			int alt26 = 3;
			switch (input.LA(1)) {
			case HyphenMinus: {
				alt26 = 1;
			}
				break;
			case PlusSign: {
				alt26 = 2;
			}
				break;
			case NOT: {
				alt26 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 26, 0, input);

				throw nvae;
			}

			switch (alt26) {
			case 1:
			// InternalStructuredTextParser.g:2841:2: ( ( HyphenMinus ) )
			{
				// InternalStructuredTextParser.g:2841:2: ( ( HyphenMinus ) )
				// InternalStructuredTextParser.g:2842:3: ( HyphenMinus )
				{
					before(grammarAccess.getUnary_OperatorAccess().getMINUSEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2843:3: ( HyphenMinus )
					// InternalStructuredTextParser.g:2843:4: HyphenMinus
					{
						match(input, HyphenMinus, FOLLOW_2);

					}

					after(grammarAccess.getUnary_OperatorAccess().getMINUSEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2847:2: ( ( PlusSign ) )
			{
				// InternalStructuredTextParser.g:2847:2: ( ( PlusSign ) )
				// InternalStructuredTextParser.g:2848:3: ( PlusSign )
				{
					before(grammarAccess.getUnary_OperatorAccess().getPLUSEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2849:3: ( PlusSign )
					// InternalStructuredTextParser.g:2849:4: PlusSign
					{
						match(input, PlusSign, FOLLOW_2);

					}

					after(grammarAccess.getUnary_OperatorAccess().getPLUSEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2853:2: ( ( NOT ) )
			{
				// InternalStructuredTextParser.g:2853:2: ( ( NOT ) )
				// InternalStructuredTextParser.g:2854:3: ( NOT )
				{
					before(grammarAccess.getUnary_OperatorAccess().getNOTEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:2855:3: ( NOT )
					// InternalStructuredTextParser.g:2855:4: NOT
					{
						match(input, NOT, FOLLOW_2);

					}

					after(grammarAccess.getUnary_OperatorAccess().getNOTEnumLiteralDeclaration_2());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Operator__Alternatives"

	// $ANTLR start "rule__Duration_Unit__Alternatives"
	// InternalStructuredTextParser.g:2863:1: rule__Duration_Unit__Alternatives : (
	// ( ( D_1 ) ) | ( ( H ) ) | ( ( M ) ) | ( ( S ) ) | ( ( Ms ) ) | ( ( Us ) ) | (
	// ( Ns ) ) );
	public final void rule__Duration_Unit__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2867:1: ( ( ( D_1 ) ) | ( ( H ) ) | ( ( M ) )
			// | ( ( S ) ) | ( ( Ms ) ) | ( ( Us ) ) | ( ( Ns ) ) )
			int alt27 = 7;
			switch (input.LA(1)) {
			case D_1: {
				alt27 = 1;
			}
				break;
			case H: {
				alt27 = 2;
			}
				break;
			case M: {
				alt27 = 3;
			}
				break;
			case S: {
				alt27 = 4;
			}
				break;
			case Ms: {
				alt27 = 5;
			}
				break;
			case Us: {
				alt27 = 6;
			}
				break;
			case Ns: {
				alt27 = 7;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 27, 0, input);

				throw nvae;
			}

			switch (alt27) {
			case 1:
			// InternalStructuredTextParser.g:2868:2: ( ( D_1 ) )
			{
				// InternalStructuredTextParser.g:2868:2: ( ( D_1 ) )
				// InternalStructuredTextParser.g:2869:3: ( D_1 )
				{
					before(grammarAccess.getDuration_UnitAccess().getDAYSEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2870:3: ( D_1 )
					// InternalStructuredTextParser.g:2870:4: D_1
					{
						match(input, D_1, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getDAYSEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2874:2: ( ( H ) )
			{
				// InternalStructuredTextParser.g:2874:2: ( ( H ) )
				// InternalStructuredTextParser.g:2875:3: ( H )
				{
					before(grammarAccess.getDuration_UnitAccess().getHOURSEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2876:3: ( H )
					// InternalStructuredTextParser.g:2876:4: H
					{
						match(input, H, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getHOURSEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2880:2: ( ( M ) )
			{
				// InternalStructuredTextParser.g:2880:2: ( ( M ) )
				// InternalStructuredTextParser.g:2881:3: ( M )
				{
					before(grammarAccess.getDuration_UnitAccess().getMINUTESEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:2882:3: ( M )
					// InternalStructuredTextParser.g:2882:4: M
					{
						match(input, M, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getMINUTESEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2886:2: ( ( S ) )
			{
				// InternalStructuredTextParser.g:2886:2: ( ( S ) )
				// InternalStructuredTextParser.g:2887:3: ( S )
				{
					before(grammarAccess.getDuration_UnitAccess().getSECONDSEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:2888:3: ( S )
					// InternalStructuredTextParser.g:2888:4: S
					{
						match(input, S, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getSECONDSEnumLiteralDeclaration_3());

				}

			}
				break;
			case 5:
			// InternalStructuredTextParser.g:2892:2: ( ( Ms ) )
			{
				// InternalStructuredTextParser.g:2892:2: ( ( Ms ) )
				// InternalStructuredTextParser.g:2893:3: ( Ms )
				{
					before(grammarAccess.getDuration_UnitAccess().getMILLISEnumLiteralDeclaration_4());
					// InternalStructuredTextParser.g:2894:3: ( Ms )
					// InternalStructuredTextParser.g:2894:4: Ms
					{
						match(input, Ms, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getMILLISEnumLiteralDeclaration_4());

				}

			}
				break;
			case 6:
			// InternalStructuredTextParser.g:2898:2: ( ( Us ) )
			{
				// InternalStructuredTextParser.g:2898:2: ( ( Us ) )
				// InternalStructuredTextParser.g:2899:3: ( Us )
				{
					before(grammarAccess.getDuration_UnitAccess().getMICROSEnumLiteralDeclaration_5());
					// InternalStructuredTextParser.g:2900:3: ( Us )
					// InternalStructuredTextParser.g:2900:4: Us
					{
						match(input, Us, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getMICROSEnumLiteralDeclaration_5());

				}

			}
				break;
			case 7:
			// InternalStructuredTextParser.g:2904:2: ( ( Ns ) )
			{
				// InternalStructuredTextParser.g:2904:2: ( ( Ns ) )
				// InternalStructuredTextParser.g:2905:3: ( Ns )
				{
					before(grammarAccess.getDuration_UnitAccess().getNANOSEnumLiteralDeclaration_6());
					// InternalStructuredTextParser.g:2906:3: ( Ns )
					// InternalStructuredTextParser.g:2906:4: Ns
					{
						match(input, Ns, FOLLOW_2);

					}

					after(grammarAccess.getDuration_UnitAccess().getNANOSEnumLiteralDeclaration_6());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Unit__Alternatives"

	// $ANTLR start "rule__Int_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:2914:1: rule__Int_Type_Name__Alternatives : (
	// ( ( DINT ) ) | ( ( INT ) ) | ( ( SINT ) ) | ( ( LINT ) ) | ( ( UINT ) ) | ( (
	// USINT ) ) | ( ( UDINT ) ) | ( ( ULINT ) ) );
	public final void rule__Int_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2918:1: ( ( ( DINT ) ) | ( ( INT ) ) | ( (
			// SINT ) ) | ( ( LINT ) ) | ( ( UINT ) ) | ( ( USINT ) ) | ( ( UDINT ) ) | ( (
			// ULINT ) ) )
			int alt28 = 8;
			switch (input.LA(1)) {
			case DINT: {
				alt28 = 1;
			}
				break;
			case INT: {
				alt28 = 2;
			}
				break;
			case SINT: {
				alt28 = 3;
			}
				break;
			case LINT: {
				alt28 = 4;
			}
				break;
			case UINT: {
				alt28 = 5;
			}
				break;
			case USINT: {
				alt28 = 6;
			}
				break;
			case UDINT: {
				alt28 = 7;
			}
				break;
			case ULINT: {
				alt28 = 8;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 28, 0, input);

				throw nvae;
			}

			switch (alt28) {
			case 1:
			// InternalStructuredTextParser.g:2919:2: ( ( DINT ) )
			{
				// InternalStructuredTextParser.g:2919:2: ( ( DINT ) )
				// InternalStructuredTextParser.g:2920:3: ( DINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getDINTEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2921:3: ( DINT )
					// InternalStructuredTextParser.g:2921:4: DINT
					{
						match(input, DINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getDINTEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2925:2: ( ( INT ) )
			{
				// InternalStructuredTextParser.g:2925:2: ( ( INT ) )
				// InternalStructuredTextParser.g:2926:3: ( INT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getINTEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2927:3: ( INT )
					// InternalStructuredTextParser.g:2927:4: INT
					{
						match(input, INT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getINTEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:2931:2: ( ( SINT ) )
			{
				// InternalStructuredTextParser.g:2931:2: ( ( SINT ) )
				// InternalStructuredTextParser.g:2932:3: ( SINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getSINTEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:2933:3: ( SINT )
					// InternalStructuredTextParser.g:2933:4: SINT
					{
						match(input, SINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getSINTEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:2937:2: ( ( LINT ) )
			{
				// InternalStructuredTextParser.g:2937:2: ( ( LINT ) )
				// InternalStructuredTextParser.g:2938:3: ( LINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getLINTEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:2939:3: ( LINT )
					// InternalStructuredTextParser.g:2939:4: LINT
					{
						match(input, LINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getLINTEnumLiteralDeclaration_3());

				}

			}
				break;
			case 5:
			// InternalStructuredTextParser.g:2943:2: ( ( UINT ) )
			{
				// InternalStructuredTextParser.g:2943:2: ( ( UINT ) )
				// InternalStructuredTextParser.g:2944:3: ( UINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getUINTEnumLiteralDeclaration_4());
					// InternalStructuredTextParser.g:2945:3: ( UINT )
					// InternalStructuredTextParser.g:2945:4: UINT
					{
						match(input, UINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getUINTEnumLiteralDeclaration_4());

				}

			}
				break;
			case 6:
			// InternalStructuredTextParser.g:2949:2: ( ( USINT ) )
			{
				// InternalStructuredTextParser.g:2949:2: ( ( USINT ) )
				// InternalStructuredTextParser.g:2950:3: ( USINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getUSINTEnumLiteralDeclaration_5());
					// InternalStructuredTextParser.g:2951:3: ( USINT )
					// InternalStructuredTextParser.g:2951:4: USINT
					{
						match(input, USINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getUSINTEnumLiteralDeclaration_5());

				}

			}
				break;
			case 7:
			// InternalStructuredTextParser.g:2955:2: ( ( UDINT ) )
			{
				// InternalStructuredTextParser.g:2955:2: ( ( UDINT ) )
				// InternalStructuredTextParser.g:2956:3: ( UDINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getUDINTEnumLiteralDeclaration_6());
					// InternalStructuredTextParser.g:2957:3: ( UDINT )
					// InternalStructuredTextParser.g:2957:4: UDINT
					{
						match(input, UDINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getUDINTEnumLiteralDeclaration_6());

				}

			}
				break;
			case 8:
			// InternalStructuredTextParser.g:2961:2: ( ( ULINT ) )
			{
				// InternalStructuredTextParser.g:2961:2: ( ( ULINT ) )
				// InternalStructuredTextParser.g:2962:3: ( ULINT )
				{
					before(grammarAccess.getInt_Type_NameAccess().getULINTEnumLiteralDeclaration_7());
					// InternalStructuredTextParser.g:2963:3: ( ULINT )
					// InternalStructuredTextParser.g:2963:4: ULINT
					{
						match(input, ULINT, FOLLOW_2);

					}

					after(grammarAccess.getInt_Type_NameAccess().getULINTEnumLiteralDeclaration_7());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Type_Name__Alternatives"

	// $ANTLR start "rule__Real_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:2971:1: rule__Real_Type_Name__Alternatives : (
	// ( ( REAL ) ) | ( ( LREAL ) ) );
	public final void rule__Real_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2975:1: ( ( ( REAL ) ) | ( ( LREAL ) ) )
			int alt29 = 2;
			int LA29_0 = input.LA(1);

			if ((LA29_0 == REAL)) {
				alt29 = 1;
			} else if ((LA29_0 == LREAL)) {
				alt29 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 29, 0, input);

				throw nvae;
			}
			switch (alt29) {
			case 1:
			// InternalStructuredTextParser.g:2976:2: ( ( REAL ) )
			{
				// InternalStructuredTextParser.g:2976:2: ( ( REAL ) )
				// InternalStructuredTextParser.g:2977:3: ( REAL )
				{
					before(grammarAccess.getReal_Type_NameAccess().getREALEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2978:3: ( REAL )
					// InternalStructuredTextParser.g:2978:4: REAL
					{
						match(input, REAL, FOLLOW_2);

					}

					after(grammarAccess.getReal_Type_NameAccess().getREALEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:2982:2: ( ( LREAL ) )
			{
				// InternalStructuredTextParser.g:2982:2: ( ( LREAL ) )
				// InternalStructuredTextParser.g:2983:3: ( LREAL )
				{
					before(grammarAccess.getReal_Type_NameAccess().getLREALEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:2984:3: ( LREAL )
					// InternalStructuredTextParser.g:2984:4: LREAL
					{
						match(input, LREAL, FOLLOW_2);

					}

					after(grammarAccess.getReal_Type_NameAccess().getLREALEnumLiteralDeclaration_1());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Type_Name__Alternatives"

	// $ANTLR start "rule__String_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:2992:1: rule__String_Type_Name__Alternatives :
	// ( ( ( STRING ) ) | ( ( WSTRING ) ) | ( ( CHAR ) ) | ( ( WCHAR ) ) );
	public final void rule__String_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:2996:1: ( ( ( STRING ) ) | ( ( WSTRING ) ) | (
			// ( CHAR ) ) | ( ( WCHAR ) ) )
			int alt30 = 4;
			switch (input.LA(1)) {
			case STRING: {
				alt30 = 1;
			}
				break;
			case WSTRING: {
				alt30 = 2;
			}
				break;
			case CHAR: {
				alt30 = 3;
			}
				break;
			case WCHAR: {
				alt30 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 30, 0, input);

				throw nvae;
			}

			switch (alt30) {
			case 1:
			// InternalStructuredTextParser.g:2997:2: ( ( STRING ) )
			{
				// InternalStructuredTextParser.g:2997:2: ( ( STRING ) )
				// InternalStructuredTextParser.g:2998:3: ( STRING )
				{
					before(grammarAccess.getString_Type_NameAccess().getSTRINGEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:2999:3: ( STRING )
					// InternalStructuredTextParser.g:2999:4: STRING
					{
						match(input, STRING, FOLLOW_2);

					}

					after(grammarAccess.getString_Type_NameAccess().getSTRINGEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:3003:2: ( ( WSTRING ) )
			{
				// InternalStructuredTextParser.g:3003:2: ( ( WSTRING ) )
				// InternalStructuredTextParser.g:3004:3: ( WSTRING )
				{
					before(grammarAccess.getString_Type_NameAccess().getWSTRINGEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:3005:3: ( WSTRING )
					// InternalStructuredTextParser.g:3005:4: WSTRING
					{
						match(input, WSTRING, FOLLOW_2);

					}

					after(grammarAccess.getString_Type_NameAccess().getWSTRINGEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:3009:2: ( ( CHAR ) )
			{
				// InternalStructuredTextParser.g:3009:2: ( ( CHAR ) )
				// InternalStructuredTextParser.g:3010:3: ( CHAR )
				{
					before(grammarAccess.getString_Type_NameAccess().getCHAREnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:3011:3: ( CHAR )
					// InternalStructuredTextParser.g:3011:4: CHAR
					{
						match(input, CHAR, FOLLOW_2);

					}

					after(grammarAccess.getString_Type_NameAccess().getCHAREnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:3015:2: ( ( WCHAR ) )
			{
				// InternalStructuredTextParser.g:3015:2: ( ( WCHAR ) )
				// InternalStructuredTextParser.g:3016:3: ( WCHAR )
				{
					before(grammarAccess.getString_Type_NameAccess().getWCHAREnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:3017:3: ( WCHAR )
					// InternalStructuredTextParser.g:3017:4: WCHAR
					{
						match(input, WCHAR, FOLLOW_2);

					}

					after(grammarAccess.getString_Type_NameAccess().getWCHAREnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__String_Type_Name__Alternatives"

	// $ANTLR start "rule__Time_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:3025:1: rule__Time_Type_Name__Alternatives : (
	// ( ( TIME ) ) | ( ( LTIME ) ) | ( ( T ) ) | ( ( LT ) ) );
	public final void rule__Time_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3029:1: ( ( ( TIME ) ) | ( ( LTIME ) ) | ( ( T
			// ) ) | ( ( LT ) ) )
			int alt31 = 4;
			switch (input.LA(1)) {
			case TIME: {
				alt31 = 1;
			}
				break;
			case LTIME: {
				alt31 = 2;
			}
				break;
			case T: {
				alt31 = 3;
			}
				break;
			case LT: {
				alt31 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 31, 0, input);

				throw nvae;
			}

			switch (alt31) {
			case 1:
			// InternalStructuredTextParser.g:3030:2: ( ( TIME ) )
			{
				// InternalStructuredTextParser.g:3030:2: ( ( TIME ) )
				// InternalStructuredTextParser.g:3031:3: ( TIME )
				{
					before(grammarAccess.getTime_Type_NameAccess().getTIMEEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:3032:3: ( TIME )
					// InternalStructuredTextParser.g:3032:4: TIME
					{
						match(input, TIME, FOLLOW_2);

					}

					after(grammarAccess.getTime_Type_NameAccess().getTIMEEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:3036:2: ( ( LTIME ) )
			{
				// InternalStructuredTextParser.g:3036:2: ( ( LTIME ) )
				// InternalStructuredTextParser.g:3037:3: ( LTIME )
				{
					before(grammarAccess.getTime_Type_NameAccess().getLTIMEEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:3038:3: ( LTIME )
					// InternalStructuredTextParser.g:3038:4: LTIME
					{
						match(input, LTIME, FOLLOW_2);

					}

					after(grammarAccess.getTime_Type_NameAccess().getLTIMEEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:3042:2: ( ( T ) )
			{
				// InternalStructuredTextParser.g:3042:2: ( ( T ) )
				// InternalStructuredTextParser.g:3043:3: ( T )
				{
					before(grammarAccess.getTime_Type_NameAccess().getTEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:3044:3: ( T )
					// InternalStructuredTextParser.g:3044:4: T
					{
						match(input, T, FOLLOW_2);

					}

					after(grammarAccess.getTime_Type_NameAccess().getTEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:3048:2: ( ( LT ) )
			{
				// InternalStructuredTextParser.g:3048:2: ( ( LT ) )
				// InternalStructuredTextParser.g:3049:3: ( LT )
				{
					before(grammarAccess.getTime_Type_NameAccess().getLTEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:3050:3: ( LT )
					// InternalStructuredTextParser.g:3050:4: LT
					{
						match(input, LT, FOLLOW_2);

					}

					after(grammarAccess.getTime_Type_NameAccess().getLTEnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Type_Name__Alternatives"

	// $ANTLR start "rule__Tod_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:3058:1: rule__Tod_Type_Name__Alternatives : (
	// ( ( TIME_OF_DAY ) ) | ( ( LTIME_OF_DAY ) ) | ( ( TOD ) ) | ( ( LTOD ) ) );
	public final void rule__Tod_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3062:1: ( ( ( TIME_OF_DAY ) ) | ( (
			// LTIME_OF_DAY ) ) | ( ( TOD ) ) | ( ( LTOD ) ) )
			int alt32 = 4;
			switch (input.LA(1)) {
			case TIME_OF_DAY: {
				alt32 = 1;
			}
				break;
			case LTIME_OF_DAY: {
				alt32 = 2;
			}
				break;
			case TOD: {
				alt32 = 3;
			}
				break;
			case LTOD: {
				alt32 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 32, 0, input);

				throw nvae;
			}

			switch (alt32) {
			case 1:
			// InternalStructuredTextParser.g:3063:2: ( ( TIME_OF_DAY ) )
			{
				// InternalStructuredTextParser.g:3063:2: ( ( TIME_OF_DAY ) )
				// InternalStructuredTextParser.g:3064:3: ( TIME_OF_DAY )
				{
					before(grammarAccess.getTod_Type_NameAccess().getTIME_OF_DAYEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:3065:3: ( TIME_OF_DAY )
					// InternalStructuredTextParser.g:3065:4: TIME_OF_DAY
					{
						match(input, TIME_OF_DAY, FOLLOW_2);

					}

					after(grammarAccess.getTod_Type_NameAccess().getTIME_OF_DAYEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:3069:2: ( ( LTIME_OF_DAY ) )
			{
				// InternalStructuredTextParser.g:3069:2: ( ( LTIME_OF_DAY ) )
				// InternalStructuredTextParser.g:3070:3: ( LTIME_OF_DAY )
				{
					before(grammarAccess.getTod_Type_NameAccess().getLTIME_OF_DAYEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:3071:3: ( LTIME_OF_DAY )
					// InternalStructuredTextParser.g:3071:4: LTIME_OF_DAY
					{
						match(input, LTIME_OF_DAY, FOLLOW_2);

					}

					after(grammarAccess.getTod_Type_NameAccess().getLTIME_OF_DAYEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:3075:2: ( ( TOD ) )
			{
				// InternalStructuredTextParser.g:3075:2: ( ( TOD ) )
				// InternalStructuredTextParser.g:3076:3: ( TOD )
				{
					before(grammarAccess.getTod_Type_NameAccess().getTODEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:3077:3: ( TOD )
					// InternalStructuredTextParser.g:3077:4: TOD
					{
						match(input, TOD, FOLLOW_2);

					}

					after(grammarAccess.getTod_Type_NameAccess().getTODEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:3081:2: ( ( LTOD ) )
			{
				// InternalStructuredTextParser.g:3081:2: ( ( LTOD ) )
				// InternalStructuredTextParser.g:3082:3: ( LTOD )
				{
					before(grammarAccess.getTod_Type_NameAccess().getLTODEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:3083:3: ( LTOD )
					// InternalStructuredTextParser.g:3083:4: LTOD
					{
						match(input, LTOD, FOLLOW_2);

					}

					after(grammarAccess.getTod_Type_NameAccess().getLTODEnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Tod_Type_Name__Alternatives"

	// $ANTLR start "rule__Date_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:3091:1: rule__Date_Type_Name__Alternatives : (
	// ( ( DATE ) ) | ( ( LDATE ) ) | ( ( D_1 ) ) | ( ( LD ) ) );
	public final void rule__Date_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3095:1: ( ( ( DATE ) ) | ( ( LDATE ) ) | ( (
			// D_1 ) ) | ( ( LD ) ) )
			int alt33 = 4;
			switch (input.LA(1)) {
			case DATE: {
				alt33 = 1;
			}
				break;
			case LDATE: {
				alt33 = 2;
			}
				break;
			case D_1: {
				alt33 = 3;
			}
				break;
			case LD: {
				alt33 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 33, 0, input);

				throw nvae;
			}

			switch (alt33) {
			case 1:
			// InternalStructuredTextParser.g:3096:2: ( ( DATE ) )
			{
				// InternalStructuredTextParser.g:3096:2: ( ( DATE ) )
				// InternalStructuredTextParser.g:3097:3: ( DATE )
				{
					before(grammarAccess.getDate_Type_NameAccess().getDATEEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:3098:3: ( DATE )
					// InternalStructuredTextParser.g:3098:4: DATE
					{
						match(input, DATE, FOLLOW_2);

					}

					after(grammarAccess.getDate_Type_NameAccess().getDATEEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:3102:2: ( ( LDATE ) )
			{
				// InternalStructuredTextParser.g:3102:2: ( ( LDATE ) )
				// InternalStructuredTextParser.g:3103:3: ( LDATE )
				{
					before(grammarAccess.getDate_Type_NameAccess().getLDATEEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:3104:3: ( LDATE )
					// InternalStructuredTextParser.g:3104:4: LDATE
					{
						match(input, LDATE, FOLLOW_2);

					}

					after(grammarAccess.getDate_Type_NameAccess().getLDATEEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:3108:2: ( ( D_1 ) )
			{
				// InternalStructuredTextParser.g:3108:2: ( ( D_1 ) )
				// InternalStructuredTextParser.g:3109:3: ( D_1 )
				{
					before(grammarAccess.getDate_Type_NameAccess().getDEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:3110:3: ( D_1 )
					// InternalStructuredTextParser.g:3110:4: D_1
					{
						match(input, D_1, FOLLOW_2);

					}

					after(grammarAccess.getDate_Type_NameAccess().getDEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:3114:2: ( ( LD ) )
			{
				// InternalStructuredTextParser.g:3114:2: ( ( LD ) )
				// InternalStructuredTextParser.g:3115:3: ( LD )
				{
					before(grammarAccess.getDate_Type_NameAccess().getLDEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:3116:3: ( LD )
					// InternalStructuredTextParser.g:3116:4: LD
					{
						match(input, LD, FOLLOW_2);

					}

					after(grammarAccess.getDate_Type_NameAccess().getLDEnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Type_Name__Alternatives"

	// $ANTLR start "rule__DT_Type_Name__Alternatives"
	// InternalStructuredTextParser.g:3124:1: rule__DT_Type_Name__Alternatives : ( (
	// ( DATE_AND_TIME ) ) | ( ( LDATE_AND_TIME ) ) | ( ( DT ) ) | ( ( LDT ) ) );
	public final void rule__DT_Type_Name__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3128:1: ( ( ( DATE_AND_TIME ) ) | ( (
			// LDATE_AND_TIME ) ) | ( ( DT ) ) | ( ( LDT ) ) )
			int alt34 = 4;
			switch (input.LA(1)) {
			case DATE_AND_TIME: {
				alt34 = 1;
			}
				break;
			case LDATE_AND_TIME: {
				alt34 = 2;
			}
				break;
			case DT: {
				alt34 = 3;
			}
				break;
			case LDT: {
				alt34 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 34, 0, input);

				throw nvae;
			}

			switch (alt34) {
			case 1:
			// InternalStructuredTextParser.g:3129:2: ( ( DATE_AND_TIME ) )
			{
				// InternalStructuredTextParser.g:3129:2: ( ( DATE_AND_TIME ) )
				// InternalStructuredTextParser.g:3130:3: ( DATE_AND_TIME )
				{
					before(grammarAccess.getDT_Type_NameAccess().getDATE_AND_TIMEEnumLiteralDeclaration_0());
					// InternalStructuredTextParser.g:3131:3: ( DATE_AND_TIME )
					// InternalStructuredTextParser.g:3131:4: DATE_AND_TIME
					{
						match(input, DATE_AND_TIME, FOLLOW_2);

					}

					after(grammarAccess.getDT_Type_NameAccess().getDATE_AND_TIMEEnumLiteralDeclaration_0());

				}

			}
				break;
			case 2:
			// InternalStructuredTextParser.g:3135:2: ( ( LDATE_AND_TIME ) )
			{
				// InternalStructuredTextParser.g:3135:2: ( ( LDATE_AND_TIME ) )
				// InternalStructuredTextParser.g:3136:3: ( LDATE_AND_TIME )
				{
					before(grammarAccess.getDT_Type_NameAccess().getLDATE_AND_TIMEEnumLiteralDeclaration_1());
					// InternalStructuredTextParser.g:3137:3: ( LDATE_AND_TIME )
					// InternalStructuredTextParser.g:3137:4: LDATE_AND_TIME
					{
						match(input, LDATE_AND_TIME, FOLLOW_2);

					}

					after(grammarAccess.getDT_Type_NameAccess().getLDATE_AND_TIMEEnumLiteralDeclaration_1());

				}

			}
				break;
			case 3:
			// InternalStructuredTextParser.g:3141:2: ( ( DT ) )
			{
				// InternalStructuredTextParser.g:3141:2: ( ( DT ) )
				// InternalStructuredTextParser.g:3142:3: ( DT )
				{
					before(grammarAccess.getDT_Type_NameAccess().getDTEnumLiteralDeclaration_2());
					// InternalStructuredTextParser.g:3143:3: ( DT )
					// InternalStructuredTextParser.g:3143:4: DT
					{
						match(input, DT, FOLLOW_2);

					}

					after(grammarAccess.getDT_Type_NameAccess().getDTEnumLiteralDeclaration_2());

				}

			}
				break;
			case 4:
			// InternalStructuredTextParser.g:3147:2: ( ( LDT ) )
			{
				// InternalStructuredTextParser.g:3147:2: ( ( LDT ) )
				// InternalStructuredTextParser.g:3148:3: ( LDT )
				{
					before(grammarAccess.getDT_Type_NameAccess().getLDTEnumLiteralDeclaration_3());
					// InternalStructuredTextParser.g:3149:3: ( LDT )
					// InternalStructuredTextParser.g:3149:4: LDT
					{
						match(input, LDT, FOLLOW_2);

					}

					after(grammarAccess.getDT_Type_NameAccess().getLDTEnumLiteralDeclaration_3());

				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__DT_Type_Name__Alternatives"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__0"
	// InternalStructuredTextParser.g:3157:1:
	// rule__StructuredTextAlgorithm__Group__0 :
	// rule__StructuredTextAlgorithm__Group__0__Impl
	// rule__StructuredTextAlgorithm__Group__1 ;
	public final void rule__StructuredTextAlgorithm__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3161:1: (
			// rule__StructuredTextAlgorithm__Group__0__Impl
			// rule__StructuredTextAlgorithm__Group__1 )
			// InternalStructuredTextParser.g:3162:2:
			// rule__StructuredTextAlgorithm__Group__0__Impl
			// rule__StructuredTextAlgorithm__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__StructuredTextAlgorithm__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__0"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__0__Impl"
	// InternalStructuredTextParser.g:3169:1:
	// rule__StructuredTextAlgorithm__Group__0__Impl : ( () ) ;
	public final void rule__StructuredTextAlgorithm__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3173:1: ( ( () ) )
			// InternalStructuredTextParser.g:3174:1: ( () )
			{
				// InternalStructuredTextParser.g:3174:1: ( () )
				// InternalStructuredTextParser.g:3175:2: ()
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getStructuredTextAlgorithmAction_0());
					// InternalStructuredTextParser.g:3176:2: ()
					// InternalStructuredTextParser.g:3176:3:
					{
					}

					after(grammarAccess.getStructuredTextAlgorithmAccess().getStructuredTextAlgorithmAction_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__0__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__1"
	// InternalStructuredTextParser.g:3184:1:
	// rule__StructuredTextAlgorithm__Group__1 :
	// rule__StructuredTextAlgorithm__Group__1__Impl
	// rule__StructuredTextAlgorithm__Group__2 ;
	public final void rule__StructuredTextAlgorithm__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3188:1: (
			// rule__StructuredTextAlgorithm__Group__1__Impl
			// rule__StructuredTextAlgorithm__Group__2 )
			// InternalStructuredTextParser.g:3189:2:
			// rule__StructuredTextAlgorithm__Group__1__Impl
			// rule__StructuredTextAlgorithm__Group__2
			{
				pushFollow(FOLLOW_3);
				rule__StructuredTextAlgorithm__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__1"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__1__Impl"
	// InternalStructuredTextParser.g:3196:1:
	// rule__StructuredTextAlgorithm__Group__1__Impl : ( (
	// rule__StructuredTextAlgorithm__Group_1__0 )? ) ;
	public final void rule__StructuredTextAlgorithm__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3200:1: ( ( (
			// rule__StructuredTextAlgorithm__Group_1__0 )? ) )
			// InternalStructuredTextParser.g:3201:1: ( (
			// rule__StructuredTextAlgorithm__Group_1__0 )? )
			{
				// InternalStructuredTextParser.g:3201:1: ( (
				// rule__StructuredTextAlgorithm__Group_1__0 )? )
				// InternalStructuredTextParser.g:3202:2: (
				// rule__StructuredTextAlgorithm__Group_1__0 )?
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getGroup_1());
					// InternalStructuredTextParser.g:3203:2: (
					// rule__StructuredTextAlgorithm__Group_1__0 )?
					int alt35 = 2;
					int LA35_0 = input.LA(1);

					if ((LA35_0 == VAR)) {
						alt35 = 1;
					}
					switch (alt35) {
					case 1:
					// InternalStructuredTextParser.g:3203:3:
					// rule__StructuredTextAlgorithm__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__StructuredTextAlgorithm__Group_1__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getStructuredTextAlgorithmAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__1__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__2"
	// InternalStructuredTextParser.g:3211:1:
	// rule__StructuredTextAlgorithm__Group__2 :
	// rule__StructuredTextAlgorithm__Group__2__Impl ;
	public final void rule__StructuredTextAlgorithm__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3215:1: (
			// rule__StructuredTextAlgorithm__Group__2__Impl )
			// InternalStructuredTextParser.g:3216:2:
			// rule__StructuredTextAlgorithm__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__2"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group__2__Impl"
	// InternalStructuredTextParser.g:3222:1:
	// rule__StructuredTextAlgorithm__Group__2__Impl : ( (
	// rule__StructuredTextAlgorithm__StatementsAssignment_2 ) ) ;
	public final void rule__StructuredTextAlgorithm__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3226:1: ( ( (
			// rule__StructuredTextAlgorithm__StatementsAssignment_2 ) ) )
			// InternalStructuredTextParser.g:3227:1: ( (
			// rule__StructuredTextAlgorithm__StatementsAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:3227:1: ( (
				// rule__StructuredTextAlgorithm__StatementsAssignment_2 ) )
				// InternalStructuredTextParser.g:3228:2: (
				// rule__StructuredTextAlgorithm__StatementsAssignment_2 )
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getStatementsAssignment_2());
					// InternalStructuredTextParser.g:3229:2: (
					// rule__StructuredTextAlgorithm__StatementsAssignment_2 )
					// InternalStructuredTextParser.g:3229:3:
					// rule__StructuredTextAlgorithm__StatementsAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__StructuredTextAlgorithm__StatementsAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getStructuredTextAlgorithmAccess().getStatementsAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group__2__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__0"
	// InternalStructuredTextParser.g:3238:1:
	// rule__StructuredTextAlgorithm__Group_1__0 :
	// rule__StructuredTextAlgorithm__Group_1__0__Impl
	// rule__StructuredTextAlgorithm__Group_1__1 ;
	public final void rule__StructuredTextAlgorithm__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3242:1: (
			// rule__StructuredTextAlgorithm__Group_1__0__Impl
			// rule__StructuredTextAlgorithm__Group_1__1 )
			// InternalStructuredTextParser.g:3243:2:
			// rule__StructuredTextAlgorithm__Group_1__0__Impl
			// rule__StructuredTextAlgorithm__Group_1__1
			{
				pushFollow(FOLLOW_4);
				rule__StructuredTextAlgorithm__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__0"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__0__Impl"
	// InternalStructuredTextParser.g:3250:1:
	// rule__StructuredTextAlgorithm__Group_1__0__Impl : ( VAR ) ;
	public final void rule__StructuredTextAlgorithm__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3254:1: ( ( VAR ) )
			// InternalStructuredTextParser.g:3255:1: ( VAR )
			{
				// InternalStructuredTextParser.g:3255:1: ( VAR )
				// InternalStructuredTextParser.g:3256:2: VAR
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getVARKeyword_1_0());
					match(input, VAR, FOLLOW_2);
					after(grammarAccess.getStructuredTextAlgorithmAccess().getVARKeyword_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__0__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__1"
	// InternalStructuredTextParser.g:3265:1:
	// rule__StructuredTextAlgorithm__Group_1__1 :
	// rule__StructuredTextAlgorithm__Group_1__1__Impl
	// rule__StructuredTextAlgorithm__Group_1__2 ;
	public final void rule__StructuredTextAlgorithm__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3269:1: (
			// rule__StructuredTextAlgorithm__Group_1__1__Impl
			// rule__StructuredTextAlgorithm__Group_1__2 )
			// InternalStructuredTextParser.g:3270:2:
			// rule__StructuredTextAlgorithm__Group_1__1__Impl
			// rule__StructuredTextAlgorithm__Group_1__2
			{
				pushFollow(FOLLOW_4);
				rule__StructuredTextAlgorithm__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__1"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__1__Impl"
	// InternalStructuredTextParser.g:3277:1:
	// rule__StructuredTextAlgorithm__Group_1__1__Impl : ( (
	// rule__StructuredTextAlgorithm__Group_1_1__0 )* ) ;
	public final void rule__StructuredTextAlgorithm__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3281:1: ( ( (
			// rule__StructuredTextAlgorithm__Group_1_1__0 )* ) )
			// InternalStructuredTextParser.g:3282:1: ( (
			// rule__StructuredTextAlgorithm__Group_1_1__0 )* )
			{
				// InternalStructuredTextParser.g:3282:1: ( (
				// rule__StructuredTextAlgorithm__Group_1_1__0 )* )
				// InternalStructuredTextParser.g:3283:2: (
				// rule__StructuredTextAlgorithm__Group_1_1__0 )*
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getGroup_1_1());
					// InternalStructuredTextParser.g:3284:2: (
					// rule__StructuredTextAlgorithm__Group_1_1__0 )*
					loop36: do {
						int alt36 = 2;
						int LA36_0 = input.LA(1);

						if ((LA36_0 == CONSTANT || LA36_0 == RULE_ID)) {
							alt36 = 1;
						}

						switch (alt36) {
						case 1:
						// InternalStructuredTextParser.g:3284:3:
						// rule__StructuredTextAlgorithm__Group_1_1__0
						{
							pushFollow(FOLLOW_5);
							rule__StructuredTextAlgorithm__Group_1_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop36;
						}
					} while (true);

					after(grammarAccess.getStructuredTextAlgorithmAccess().getGroup_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__1__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__2"
	// InternalStructuredTextParser.g:3292:1:
	// rule__StructuredTextAlgorithm__Group_1__2 :
	// rule__StructuredTextAlgorithm__Group_1__2__Impl ;
	public final void rule__StructuredTextAlgorithm__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3296:1: (
			// rule__StructuredTextAlgorithm__Group_1__2__Impl )
			// InternalStructuredTextParser.g:3297:2:
			// rule__StructuredTextAlgorithm__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__2"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1__2__Impl"
	// InternalStructuredTextParser.g:3303:1:
	// rule__StructuredTextAlgorithm__Group_1__2__Impl : ( END_VAR ) ;
	public final void rule__StructuredTextAlgorithm__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3307:1: ( ( END_VAR ) )
			// InternalStructuredTextParser.g:3308:1: ( END_VAR )
			{
				// InternalStructuredTextParser.g:3308:1: ( END_VAR )
				// InternalStructuredTextParser.g:3309:2: END_VAR
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getEND_VARKeyword_1_2());
					match(input, END_VAR, FOLLOW_2);
					after(grammarAccess.getStructuredTextAlgorithmAccess().getEND_VARKeyword_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1__2__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1_1__0"
	// InternalStructuredTextParser.g:3319:1:
	// rule__StructuredTextAlgorithm__Group_1_1__0 :
	// rule__StructuredTextAlgorithm__Group_1_1__0__Impl
	// rule__StructuredTextAlgorithm__Group_1_1__1 ;
	public final void rule__StructuredTextAlgorithm__Group_1_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3323:1: (
			// rule__StructuredTextAlgorithm__Group_1_1__0__Impl
			// rule__StructuredTextAlgorithm__Group_1_1__1 )
			// InternalStructuredTextParser.g:3324:2:
			// rule__StructuredTextAlgorithm__Group_1_1__0__Impl
			// rule__StructuredTextAlgorithm__Group_1_1__1
			{
				pushFollow(FOLLOW_6);
				rule__StructuredTextAlgorithm__Group_1_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group_1_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1_1__0"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1_1__0__Impl"
	// InternalStructuredTextParser.g:3331:1:
	// rule__StructuredTextAlgorithm__Group_1_1__0__Impl : ( (
	// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 ) ) ;
	public final void rule__StructuredTextAlgorithm__Group_1_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3335:1: ( ( (
			// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 ) ) )
			// InternalStructuredTextParser.g:3336:1: ( (
			// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 ) )
			{
				// InternalStructuredTextParser.g:3336:1: ( (
				// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 ) )
				// InternalStructuredTextParser.g:3337:2: (
				// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 )
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getLocalVariablesAssignment_1_1_0());
					// InternalStructuredTextParser.g:3338:2: (
					// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 )
					// InternalStructuredTextParser.g:3338:3:
					// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0
					{
						pushFollow(FOLLOW_2);
						rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0();

						state._fsp--;

					}

					after(grammarAccess.getStructuredTextAlgorithmAccess().getLocalVariablesAssignment_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1_1__0__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1_1__1"
	// InternalStructuredTextParser.g:3346:1:
	// rule__StructuredTextAlgorithm__Group_1_1__1 :
	// rule__StructuredTextAlgorithm__Group_1_1__1__Impl ;
	public final void rule__StructuredTextAlgorithm__Group_1_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3350:1: (
			// rule__StructuredTextAlgorithm__Group_1_1__1__Impl )
			// InternalStructuredTextParser.g:3351:2:
			// rule__StructuredTextAlgorithm__Group_1_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__StructuredTextAlgorithm__Group_1_1__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1_1__1"

	// $ANTLR start "rule__StructuredTextAlgorithm__Group_1_1__1__Impl"
	// InternalStructuredTextParser.g:3357:1:
	// rule__StructuredTextAlgorithm__Group_1_1__1__Impl : ( Semicolon ) ;
	public final void rule__StructuredTextAlgorithm__Group_1_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3361:1: ( ( Semicolon ) )
			// InternalStructuredTextParser.g:3362:1: ( Semicolon )
			{
				// InternalStructuredTextParser.g:3362:1: ( Semicolon )
				// InternalStructuredTextParser.g:3363:2: Semicolon
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getSemicolonKeyword_1_1_1());
					match(input, Semicolon, FOLLOW_2);
					after(grammarAccess.getStructuredTextAlgorithmAccess().getSemicolonKeyword_1_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__Group_1_1__1__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__0"
	// InternalStructuredTextParser.g:3373:1: rule__Var_Decl_Init__Group__0 :
	// rule__Var_Decl_Init__Group__0__Impl rule__Var_Decl_Init__Group__1 ;
	public final void rule__Var_Decl_Init__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3377:1: ( rule__Var_Decl_Init__Group__0__Impl
			// rule__Var_Decl_Init__Group__1 )
			// InternalStructuredTextParser.g:3378:2: rule__Var_Decl_Init__Group__0__Impl
			// rule__Var_Decl_Init__Group__1
			{
				pushFollow(FOLLOW_7);
				rule__Var_Decl_Init__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__0"

	// $ANTLR start "rule__Var_Decl_Init__Group__0__Impl"
	// InternalStructuredTextParser.g:3385:1: rule__Var_Decl_Init__Group__0__Impl :
	// ( () ) ;
	public final void rule__Var_Decl_Init__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3389:1: ( ( () ) )
			// InternalStructuredTextParser.g:3390:1: ( () )
			{
				// InternalStructuredTextParser.g:3390:1: ( () )
				// InternalStructuredTextParser.g:3391:2: ()
				{
					before(grammarAccess.getVar_Decl_InitAccess().getLocalVariableAction_0());
					// InternalStructuredTextParser.g:3392:2: ()
					// InternalStructuredTextParser.g:3392:3:
					{
					}

					after(grammarAccess.getVar_Decl_InitAccess().getLocalVariableAction_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__0__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__1"
	// InternalStructuredTextParser.g:3400:1: rule__Var_Decl_Init__Group__1 :
	// rule__Var_Decl_Init__Group__1__Impl rule__Var_Decl_Init__Group__2 ;
	public final void rule__Var_Decl_Init__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3404:1: ( rule__Var_Decl_Init__Group__1__Impl
			// rule__Var_Decl_Init__Group__2 )
			// InternalStructuredTextParser.g:3405:2: rule__Var_Decl_Init__Group__1__Impl
			// rule__Var_Decl_Init__Group__2
			{
				pushFollow(FOLLOW_7);
				rule__Var_Decl_Init__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__1"

	// $ANTLR start "rule__Var_Decl_Init__Group__1__Impl"
	// InternalStructuredTextParser.g:3412:1: rule__Var_Decl_Init__Group__1__Impl :
	// ( ( rule__Var_Decl_Init__ConstantAssignment_1 )? ) ;
	public final void rule__Var_Decl_Init__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3416:1: ( ( (
			// rule__Var_Decl_Init__ConstantAssignment_1 )? ) )
			// InternalStructuredTextParser.g:3417:1: ( (
			// rule__Var_Decl_Init__ConstantAssignment_1 )? )
			{
				// InternalStructuredTextParser.g:3417:1: ( (
				// rule__Var_Decl_Init__ConstantAssignment_1 )? )
				// InternalStructuredTextParser.g:3418:2: (
				// rule__Var_Decl_Init__ConstantAssignment_1 )?
				{
					before(grammarAccess.getVar_Decl_InitAccess().getConstantAssignment_1());
					// InternalStructuredTextParser.g:3419:2: (
					// rule__Var_Decl_Init__ConstantAssignment_1 )?
					int alt37 = 2;
					int LA37_0 = input.LA(1);

					if ((LA37_0 == CONSTANT)) {
						alt37 = 1;
					}
					switch (alt37) {
					case 1:
					// InternalStructuredTextParser.g:3419:3:
					// rule__Var_Decl_Init__ConstantAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__ConstantAssignment_1();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getConstantAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__1__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__2"
	// InternalStructuredTextParser.g:3427:1: rule__Var_Decl_Init__Group__2 :
	// rule__Var_Decl_Init__Group__2__Impl rule__Var_Decl_Init__Group__3 ;
	public final void rule__Var_Decl_Init__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3431:1: ( rule__Var_Decl_Init__Group__2__Impl
			// rule__Var_Decl_Init__Group__3 )
			// InternalStructuredTextParser.g:3432:2: rule__Var_Decl_Init__Group__2__Impl
			// rule__Var_Decl_Init__Group__3
			{
				pushFollow(FOLLOW_8);
				rule__Var_Decl_Init__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__2"

	// $ANTLR start "rule__Var_Decl_Init__Group__2__Impl"
	// InternalStructuredTextParser.g:3439:1: rule__Var_Decl_Init__Group__2__Impl :
	// ( ( rule__Var_Decl_Init__NameAssignment_2 ) ) ;
	public final void rule__Var_Decl_Init__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3443:1: ( ( (
			// rule__Var_Decl_Init__NameAssignment_2 ) ) )
			// InternalStructuredTextParser.g:3444:1: ( (
			// rule__Var_Decl_Init__NameAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:3444:1: ( (
				// rule__Var_Decl_Init__NameAssignment_2 ) )
				// InternalStructuredTextParser.g:3445:2: (
				// rule__Var_Decl_Init__NameAssignment_2 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getNameAssignment_2());
					// InternalStructuredTextParser.g:3446:2: (
					// rule__Var_Decl_Init__NameAssignment_2 )
					// InternalStructuredTextParser.g:3446:3: rule__Var_Decl_Init__NameAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__NameAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getNameAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__2__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__3"
	// InternalStructuredTextParser.g:3454:1: rule__Var_Decl_Init__Group__3 :
	// rule__Var_Decl_Init__Group__3__Impl rule__Var_Decl_Init__Group__4 ;
	public final void rule__Var_Decl_Init__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3458:1: ( rule__Var_Decl_Init__Group__3__Impl
			// rule__Var_Decl_Init__Group__4 )
			// InternalStructuredTextParser.g:3459:2: rule__Var_Decl_Init__Group__3__Impl
			// rule__Var_Decl_Init__Group__4
			{
				pushFollow(FOLLOW_9);
				rule__Var_Decl_Init__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__3"

	// $ANTLR start "rule__Var_Decl_Init__Group__3__Impl"
	// InternalStructuredTextParser.g:3466:1: rule__Var_Decl_Init__Group__3__Impl :
	// ( Colon ) ;
	public final void rule__Var_Decl_Init__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3470:1: ( ( Colon ) )
			// InternalStructuredTextParser.g:3471:1: ( Colon )
			{
				// InternalStructuredTextParser.g:3471:1: ( Colon )
				// InternalStructuredTextParser.g:3472:2: Colon
				{
					before(grammarAccess.getVar_Decl_InitAccess().getColonKeyword_3());
					match(input, Colon, FOLLOW_2);
					after(grammarAccess.getVar_Decl_InitAccess().getColonKeyword_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__3__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__4"
	// InternalStructuredTextParser.g:3481:1: rule__Var_Decl_Init__Group__4 :
	// rule__Var_Decl_Init__Group__4__Impl rule__Var_Decl_Init__Group__5 ;
	public final void rule__Var_Decl_Init__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3485:1: ( rule__Var_Decl_Init__Group__4__Impl
			// rule__Var_Decl_Init__Group__5 )
			// InternalStructuredTextParser.g:3486:2: rule__Var_Decl_Init__Group__4__Impl
			// rule__Var_Decl_Init__Group__5
			{
				pushFollow(FOLLOW_10);
				rule__Var_Decl_Init__Group__4__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__5();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__4"

	// $ANTLR start "rule__Var_Decl_Init__Group__4__Impl"
	// InternalStructuredTextParser.g:3493:1: rule__Var_Decl_Init__Group__4__Impl :
	// ( ( rule__Var_Decl_Init__TypeAssignment_4 ) ) ;
	public final void rule__Var_Decl_Init__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3497:1: ( ( (
			// rule__Var_Decl_Init__TypeAssignment_4 ) ) )
			// InternalStructuredTextParser.g:3498:1: ( (
			// rule__Var_Decl_Init__TypeAssignment_4 ) )
			{
				// InternalStructuredTextParser.g:3498:1: ( (
				// rule__Var_Decl_Init__TypeAssignment_4 ) )
				// InternalStructuredTextParser.g:3499:2: (
				// rule__Var_Decl_Init__TypeAssignment_4 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getTypeAssignment_4());
					// InternalStructuredTextParser.g:3500:2: (
					// rule__Var_Decl_Init__TypeAssignment_4 )
					// InternalStructuredTextParser.g:3500:3: rule__Var_Decl_Init__TypeAssignment_4
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__TypeAssignment_4();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getTypeAssignment_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__4__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__5"
	// InternalStructuredTextParser.g:3508:1: rule__Var_Decl_Init__Group__5 :
	// rule__Var_Decl_Init__Group__5__Impl rule__Var_Decl_Init__Group__6 ;
	public final void rule__Var_Decl_Init__Group__5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3512:1: ( rule__Var_Decl_Init__Group__5__Impl
			// rule__Var_Decl_Init__Group__6 )
			// InternalStructuredTextParser.g:3513:2: rule__Var_Decl_Init__Group__5__Impl
			// rule__Var_Decl_Init__Group__6
			{
				pushFollow(FOLLOW_10);
				rule__Var_Decl_Init__Group__5__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__6();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__5"

	// $ANTLR start "rule__Var_Decl_Init__Group__5__Impl"
	// InternalStructuredTextParser.g:3520:1: rule__Var_Decl_Init__Group__5__Impl :
	// ( ( rule__Var_Decl_Init__Group_5__0 )? ) ;
	public final void rule__Var_Decl_Init__Group__5__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3524:1: ( ( ( rule__Var_Decl_Init__Group_5__0
			// )? ) )
			// InternalStructuredTextParser.g:3525:1: ( ( rule__Var_Decl_Init__Group_5__0 )?
			// )
			{
				// InternalStructuredTextParser.g:3525:1: ( ( rule__Var_Decl_Init__Group_5__0 )?
				// )
				// InternalStructuredTextParser.g:3526:2: ( rule__Var_Decl_Init__Group_5__0 )?
				{
					before(grammarAccess.getVar_Decl_InitAccess().getGroup_5());
					// InternalStructuredTextParser.g:3527:2: ( rule__Var_Decl_Init__Group_5__0 )?
					int alt38 = 2;
					int LA38_0 = input.LA(1);

					if ((LA38_0 == LeftSquareBracket)) {
						alt38 = 1;
					}
					switch (alt38) {
					case 1:
					// InternalStructuredTextParser.g:3527:3: rule__Var_Decl_Init__Group_5__0
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__Group_5__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getGroup_5());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__5__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group__6"
	// InternalStructuredTextParser.g:3535:1: rule__Var_Decl_Init__Group__6 :
	// rule__Var_Decl_Init__Group__6__Impl ;
	public final void rule__Var_Decl_Init__Group__6() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3539:1: ( rule__Var_Decl_Init__Group__6__Impl
			// )
			// InternalStructuredTextParser.g:3540:2: rule__Var_Decl_Init__Group__6__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group__6__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__6"

	// $ANTLR start "rule__Var_Decl_Init__Group__6__Impl"
	// InternalStructuredTextParser.g:3546:1: rule__Var_Decl_Init__Group__6__Impl :
	// ( ( rule__Var_Decl_Init__Group_6__0 )? ) ;
	public final void rule__Var_Decl_Init__Group__6__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3550:1: ( ( ( rule__Var_Decl_Init__Group_6__0
			// )? ) )
			// InternalStructuredTextParser.g:3551:1: ( ( rule__Var_Decl_Init__Group_6__0 )?
			// )
			{
				// InternalStructuredTextParser.g:3551:1: ( ( rule__Var_Decl_Init__Group_6__0 )?
				// )
				// InternalStructuredTextParser.g:3552:2: ( rule__Var_Decl_Init__Group_6__0 )?
				{
					before(grammarAccess.getVar_Decl_InitAccess().getGroup_6());
					// InternalStructuredTextParser.g:3553:2: ( rule__Var_Decl_Init__Group_6__0 )?
					int alt39 = 2;
					int LA39_0 = input.LA(1);

					if ((LA39_0 == ColonEqualsSign)) {
						alt39 = 1;
					}
					switch (alt39) {
					case 1:
					// InternalStructuredTextParser.g:3553:3: rule__Var_Decl_Init__Group_6__0
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__Group_6__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getGroup_6());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group__6__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__0"
	// InternalStructuredTextParser.g:3562:1: rule__Var_Decl_Init__Group_5__0 :
	// rule__Var_Decl_Init__Group_5__0__Impl rule__Var_Decl_Init__Group_5__1 ;
	public final void rule__Var_Decl_Init__Group_5__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3566:1: (
			// rule__Var_Decl_Init__Group_5__0__Impl rule__Var_Decl_Init__Group_5__1 )
			// InternalStructuredTextParser.g:3567:2: rule__Var_Decl_Init__Group_5__0__Impl
			// rule__Var_Decl_Init__Group_5__1
			{
				pushFollow(FOLLOW_11);
				rule__Var_Decl_Init__Group_5__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group_5__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__0"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__0__Impl"
	// InternalStructuredTextParser.g:3574:1: rule__Var_Decl_Init__Group_5__0__Impl
	// : ( ( rule__Var_Decl_Init__ArrayAssignment_5_0 ) ) ;
	public final void rule__Var_Decl_Init__Group_5__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3578:1: ( ( (
			// rule__Var_Decl_Init__ArrayAssignment_5_0 ) ) )
			// InternalStructuredTextParser.g:3579:1: ( (
			// rule__Var_Decl_Init__ArrayAssignment_5_0 ) )
			{
				// InternalStructuredTextParser.g:3579:1: ( (
				// rule__Var_Decl_Init__ArrayAssignment_5_0 ) )
				// InternalStructuredTextParser.g:3580:2: (
				// rule__Var_Decl_Init__ArrayAssignment_5_0 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getArrayAssignment_5_0());
					// InternalStructuredTextParser.g:3581:2: (
					// rule__Var_Decl_Init__ArrayAssignment_5_0 )
					// InternalStructuredTextParser.g:3581:3:
					// rule__Var_Decl_Init__ArrayAssignment_5_0
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__ArrayAssignment_5_0();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getArrayAssignment_5_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__0__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__1"
	// InternalStructuredTextParser.g:3589:1: rule__Var_Decl_Init__Group_5__1 :
	// rule__Var_Decl_Init__Group_5__1__Impl rule__Var_Decl_Init__Group_5__2 ;
	public final void rule__Var_Decl_Init__Group_5__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3593:1: (
			// rule__Var_Decl_Init__Group_5__1__Impl rule__Var_Decl_Init__Group_5__2 )
			// InternalStructuredTextParser.g:3594:2: rule__Var_Decl_Init__Group_5__1__Impl
			// rule__Var_Decl_Init__Group_5__2
			{
				pushFollow(FOLLOW_12);
				rule__Var_Decl_Init__Group_5__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group_5__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__1"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__1__Impl"
	// InternalStructuredTextParser.g:3601:1: rule__Var_Decl_Init__Group_5__1__Impl
	// : ( ( rule__Var_Decl_Init__ArraySizeAssignment_5_1 ) ) ;
	public final void rule__Var_Decl_Init__Group_5__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3605:1: ( ( (
			// rule__Var_Decl_Init__ArraySizeAssignment_5_1 ) ) )
			// InternalStructuredTextParser.g:3606:1: ( (
			// rule__Var_Decl_Init__ArraySizeAssignment_5_1 ) )
			{
				// InternalStructuredTextParser.g:3606:1: ( (
				// rule__Var_Decl_Init__ArraySizeAssignment_5_1 ) )
				// InternalStructuredTextParser.g:3607:2: (
				// rule__Var_Decl_Init__ArraySizeAssignment_5_1 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getArraySizeAssignment_5_1());
					// InternalStructuredTextParser.g:3608:2: (
					// rule__Var_Decl_Init__ArraySizeAssignment_5_1 )
					// InternalStructuredTextParser.g:3608:3:
					// rule__Var_Decl_Init__ArraySizeAssignment_5_1
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__ArraySizeAssignment_5_1();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getArraySizeAssignment_5_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__1__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__2"
	// InternalStructuredTextParser.g:3616:1: rule__Var_Decl_Init__Group_5__2 :
	// rule__Var_Decl_Init__Group_5__2__Impl ;
	public final void rule__Var_Decl_Init__Group_5__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3620:1: (
			// rule__Var_Decl_Init__Group_5__2__Impl )
			// InternalStructuredTextParser.g:3621:2: rule__Var_Decl_Init__Group_5__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group_5__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__2"

	// $ANTLR start "rule__Var_Decl_Init__Group_5__2__Impl"
	// InternalStructuredTextParser.g:3627:1: rule__Var_Decl_Init__Group_5__2__Impl
	// : ( RightSquareBracket ) ;
	public final void rule__Var_Decl_Init__Group_5__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3631:1: ( ( RightSquareBracket ) )
			// InternalStructuredTextParser.g:3632:1: ( RightSquareBracket )
			{
				// InternalStructuredTextParser.g:3632:1: ( RightSquareBracket )
				// InternalStructuredTextParser.g:3633:2: RightSquareBracket
				{
					before(grammarAccess.getVar_Decl_InitAccess().getRightSquareBracketKeyword_5_2());
					match(input, RightSquareBracket, FOLLOW_2);
					after(grammarAccess.getVar_Decl_InitAccess().getRightSquareBracketKeyword_5_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_5__2__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group_6__0"
	// InternalStructuredTextParser.g:3643:1: rule__Var_Decl_Init__Group_6__0 :
	// rule__Var_Decl_Init__Group_6__0__Impl rule__Var_Decl_Init__Group_6__1 ;
	public final void rule__Var_Decl_Init__Group_6__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3647:1: (
			// rule__Var_Decl_Init__Group_6__0__Impl rule__Var_Decl_Init__Group_6__1 )
			// InternalStructuredTextParser.g:3648:2: rule__Var_Decl_Init__Group_6__0__Impl
			// rule__Var_Decl_Init__Group_6__1
			{
				pushFollow(FOLLOW_13);
				rule__Var_Decl_Init__Group_6__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group_6__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_6__0"

	// $ANTLR start "rule__Var_Decl_Init__Group_6__0__Impl"
	// InternalStructuredTextParser.g:3655:1: rule__Var_Decl_Init__Group_6__0__Impl
	// : ( ColonEqualsSign ) ;
	public final void rule__Var_Decl_Init__Group_6__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3659:1: ( ( ColonEqualsSign ) )
			// InternalStructuredTextParser.g:3660:1: ( ColonEqualsSign )
			{
				// InternalStructuredTextParser.g:3660:1: ( ColonEqualsSign )
				// InternalStructuredTextParser.g:3661:2: ColonEqualsSign
				{
					before(grammarAccess.getVar_Decl_InitAccess().getColonEqualsSignKeyword_6_0());
					match(input, ColonEqualsSign, FOLLOW_2);
					after(grammarAccess.getVar_Decl_InitAccess().getColonEqualsSignKeyword_6_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_6__0__Impl"

	// $ANTLR start "rule__Var_Decl_Init__Group_6__1"
	// InternalStructuredTextParser.g:3670:1: rule__Var_Decl_Init__Group_6__1 :
	// rule__Var_Decl_Init__Group_6__1__Impl ;
	public final void rule__Var_Decl_Init__Group_6__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3674:1: (
			// rule__Var_Decl_Init__Group_6__1__Impl )
			// InternalStructuredTextParser.g:3675:2: rule__Var_Decl_Init__Group_6__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Var_Decl_Init__Group_6__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_6__1"

	// $ANTLR start "rule__Var_Decl_Init__Group_6__1__Impl"
	// InternalStructuredTextParser.g:3681:1: rule__Var_Decl_Init__Group_6__1__Impl
	// : ( ( rule__Var_Decl_Init__InitialValueAssignment_6_1 ) ) ;
	public final void rule__Var_Decl_Init__Group_6__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3685:1: ( ( (
			// rule__Var_Decl_Init__InitialValueAssignment_6_1 ) ) )
			// InternalStructuredTextParser.g:3686:1: ( (
			// rule__Var_Decl_Init__InitialValueAssignment_6_1 ) )
			{
				// InternalStructuredTextParser.g:3686:1: ( (
				// rule__Var_Decl_Init__InitialValueAssignment_6_1 ) )
				// InternalStructuredTextParser.g:3687:2: (
				// rule__Var_Decl_Init__InitialValueAssignment_6_1 )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getInitialValueAssignment_6_1());
					// InternalStructuredTextParser.g:3688:2: (
					// rule__Var_Decl_Init__InitialValueAssignment_6_1 )
					// InternalStructuredTextParser.g:3688:3:
					// rule__Var_Decl_Init__InitialValueAssignment_6_1
					{
						pushFollow(FOLLOW_2);
						rule__Var_Decl_Init__InitialValueAssignment_6_1();

						state._fsp--;

					}

					after(grammarAccess.getVar_Decl_InitAccess().getInitialValueAssignment_6_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__Group_6__1__Impl"

	// $ANTLR start "rule__Stmt_List__Group__0"
	// InternalStructuredTextParser.g:3697:1: rule__Stmt_List__Group__0 :
	// rule__Stmt_List__Group__0__Impl rule__Stmt_List__Group__1 ;
	public final void rule__Stmt_List__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3701:1: ( rule__Stmt_List__Group__0__Impl
			// rule__Stmt_List__Group__1 )
			// InternalStructuredTextParser.g:3702:2: rule__Stmt_List__Group__0__Impl
			// rule__Stmt_List__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__Stmt_List__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Stmt_List__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group__0"

	// $ANTLR start "rule__Stmt_List__Group__0__Impl"
	// InternalStructuredTextParser.g:3709:1: rule__Stmt_List__Group__0__Impl : ( ()
	// ) ;
	public final void rule__Stmt_List__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3713:1: ( ( () ) )
			// InternalStructuredTextParser.g:3714:1: ( () )
			{
				// InternalStructuredTextParser.g:3714:1: ( () )
				// InternalStructuredTextParser.g:3715:2: ()
				{
					before(grammarAccess.getStmt_ListAccess().getStatementListAction_0());
					// InternalStructuredTextParser.g:3716:2: ()
					// InternalStructuredTextParser.g:3716:3:
					{
					}

					after(grammarAccess.getStmt_ListAccess().getStatementListAction_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group__0__Impl"

	// $ANTLR start "rule__Stmt_List__Group__1"
	// InternalStructuredTextParser.g:3724:1: rule__Stmt_List__Group__1 :
	// rule__Stmt_List__Group__1__Impl ;
	public final void rule__Stmt_List__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3728:1: ( rule__Stmt_List__Group__1__Impl )
			// InternalStructuredTextParser.g:3729:2: rule__Stmt_List__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Stmt_List__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group__1"

	// $ANTLR start "rule__Stmt_List__Group__1__Impl"
	// InternalStructuredTextParser.g:3735:1: rule__Stmt_List__Group__1__Impl : ( (
	// rule__Stmt_List__Group_1__0 )* ) ;
	public final void rule__Stmt_List__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3739:1: ( ( ( rule__Stmt_List__Group_1__0 )* )
			// )
			// InternalStructuredTextParser.g:3740:1: ( ( rule__Stmt_List__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:3740:1: ( ( rule__Stmt_List__Group_1__0 )* )
				// InternalStructuredTextParser.g:3741:2: ( rule__Stmt_List__Group_1__0 )*
				{
					before(grammarAccess.getStmt_ListAccess().getGroup_1());
					// InternalStructuredTextParser.g:3742:2: ( rule__Stmt_List__Group_1__0 )*
					loop40: do {
						int alt40 = 2;
						switch (input.LA(1)) {
						case TIME: {
							int LA40_2 = input.LA(2);

							if ((LA40_2 == LeftParenthesis)) {
								alt40 = 1;
							}

						}
							break;
						case T: {
							int LA40_3 = input.LA(2);

							if ((LA40_3 == ColonEqualsSign || LA40_3 == FullStop || LA40_3 == LeftSquareBracket)) {
								alt40 = 1;
							}

						}
							break;
						case LT: {
							int LA40_4 = input.LA(2);

							if ((LA40_4 == ColonEqualsSign || LA40_4 == FullStop || LA40_4 == LeftSquareBracket)) {
								alt40 = 1;
							}

						}
							break;
						case DT: {
							int LA40_5 = input.LA(2);

							if ((LA40_5 == ColonEqualsSign || LA40_5 == FullStop || LA40_5 == LeftSquareBracket)) {
								alt40 = 1;
							}

						}
							break;
						case CONTINUE:
						case REPEAT:
						case RETURN:
						case SUPER:
						case WHILE:
						case CASE:
						case EXIT:
						case FOR:
						case IF:
						case Semicolon:
						case RULE_ID: {
							alt40 = 1;
						}
							break;

						}

						switch (alt40) {
						case 1:
						// InternalStructuredTextParser.g:3742:3: rule__Stmt_List__Group_1__0
						{
							pushFollow(FOLLOW_14);
							rule__Stmt_List__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop40;
						}
					} while (true);

					after(grammarAccess.getStmt_ListAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group__1__Impl"

	// $ANTLR start "rule__Stmt_List__Group_1__0"
	// InternalStructuredTextParser.g:3751:1: rule__Stmt_List__Group_1__0 :
	// rule__Stmt_List__Group_1__0__Impl rule__Stmt_List__Group_1__1 ;
	public final void rule__Stmt_List__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3755:1: ( rule__Stmt_List__Group_1__0__Impl
			// rule__Stmt_List__Group_1__1 )
			// InternalStructuredTextParser.g:3756:2: rule__Stmt_List__Group_1__0__Impl
			// rule__Stmt_List__Group_1__1
			{
				pushFollow(FOLLOW_15);
				rule__Stmt_List__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Stmt_List__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group_1__0"

	// $ANTLR start "rule__Stmt_List__Group_1__0__Impl"
	// InternalStructuredTextParser.g:3763:1: rule__Stmt_List__Group_1__0__Impl : (
	// ( rule__Stmt_List__StatementsAssignment_1_0 )? ) ;
	public final void rule__Stmt_List__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3767:1: ( ( (
			// rule__Stmt_List__StatementsAssignment_1_0 )? ) )
			// InternalStructuredTextParser.g:3768:1: ( (
			// rule__Stmt_List__StatementsAssignment_1_0 )? )
			{
				// InternalStructuredTextParser.g:3768:1: ( (
				// rule__Stmt_List__StatementsAssignment_1_0 )? )
				// InternalStructuredTextParser.g:3769:2: (
				// rule__Stmt_List__StatementsAssignment_1_0 )?
				{
					before(grammarAccess.getStmt_ListAccess().getStatementsAssignment_1_0());
					// InternalStructuredTextParser.g:3770:2: (
					// rule__Stmt_List__StatementsAssignment_1_0 )?
					int alt41 = 2;
					int LA41_0 = input.LA(1);

					if ((LA41_0 == CONTINUE || (LA41_0 >= REPEAT && LA41_0 <= RETURN) || LA41_0 == SUPER
							|| LA41_0 == WHILE || LA41_0 == CASE || LA41_0 == EXIT || LA41_0 == TIME || LA41_0 == FOR
							|| (LA41_0 >= DT && LA41_0 <= IF) || LA41_0 == LT || LA41_0 == T || LA41_0 == RULE_ID)) {
						alt41 = 1;
					}
					switch (alt41) {
					case 1:
					// InternalStructuredTextParser.g:3770:3:
					// rule__Stmt_List__StatementsAssignment_1_0
					{
						pushFollow(FOLLOW_2);
						rule__Stmt_List__StatementsAssignment_1_0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getStmt_ListAccess().getStatementsAssignment_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group_1__0__Impl"

	// $ANTLR start "rule__Stmt_List__Group_1__1"
	// InternalStructuredTextParser.g:3778:1: rule__Stmt_List__Group_1__1 :
	// rule__Stmt_List__Group_1__1__Impl ;
	public final void rule__Stmt_List__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3782:1: ( rule__Stmt_List__Group_1__1__Impl )
			// InternalStructuredTextParser.g:3783:2: rule__Stmt_List__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Stmt_List__Group_1__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group_1__1"

	// $ANTLR start "rule__Stmt_List__Group_1__1__Impl"
	// InternalStructuredTextParser.g:3789:1: rule__Stmt_List__Group_1__1__Impl : (
	// Semicolon ) ;
	public final void rule__Stmt_List__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3793:1: ( ( Semicolon ) )
			// InternalStructuredTextParser.g:3794:1: ( Semicolon )
			{
				// InternalStructuredTextParser.g:3794:1: ( Semicolon )
				// InternalStructuredTextParser.g:3795:2: Semicolon
				{
					before(grammarAccess.getStmt_ListAccess().getSemicolonKeyword_1_1());
					match(input, Semicolon, FOLLOW_2);
					after(grammarAccess.getStmt_ListAccess().getSemicolonKeyword_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__Group_1__1__Impl"

	// $ANTLR start "rule__Assign_Stmt__Group__0"
	// InternalStructuredTextParser.g:3805:1: rule__Assign_Stmt__Group__0 :
	// rule__Assign_Stmt__Group__0__Impl rule__Assign_Stmt__Group__1 ;
	public final void rule__Assign_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3809:1: ( rule__Assign_Stmt__Group__0__Impl
			// rule__Assign_Stmt__Group__1 )
			// InternalStructuredTextParser.g:3810:2: rule__Assign_Stmt__Group__0__Impl
			// rule__Assign_Stmt__Group__1
			{
				pushFollow(FOLLOW_16);
				rule__Assign_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Assign_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__0"

	// $ANTLR start "rule__Assign_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:3817:1: rule__Assign_Stmt__Group__0__Impl : (
	// ( rule__Assign_Stmt__VariableAssignment_0 ) ) ;
	public final void rule__Assign_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3821:1: ( ( (
			// rule__Assign_Stmt__VariableAssignment_0 ) ) )
			// InternalStructuredTextParser.g:3822:1: ( (
			// rule__Assign_Stmt__VariableAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:3822:1: ( (
				// rule__Assign_Stmt__VariableAssignment_0 ) )
				// InternalStructuredTextParser.g:3823:2: (
				// rule__Assign_Stmt__VariableAssignment_0 )
				{
					before(grammarAccess.getAssign_StmtAccess().getVariableAssignment_0());
					// InternalStructuredTextParser.g:3824:2: (
					// rule__Assign_Stmt__VariableAssignment_0 )
					// InternalStructuredTextParser.g:3824:3:
					// rule__Assign_Stmt__VariableAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Assign_Stmt__VariableAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getAssign_StmtAccess().getVariableAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__0__Impl"

	// $ANTLR start "rule__Assign_Stmt__Group__1"
	// InternalStructuredTextParser.g:3832:1: rule__Assign_Stmt__Group__1 :
	// rule__Assign_Stmt__Group__1__Impl rule__Assign_Stmt__Group__2 ;
	public final void rule__Assign_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3836:1: ( rule__Assign_Stmt__Group__1__Impl
			// rule__Assign_Stmt__Group__2 )
			// InternalStructuredTextParser.g:3837:2: rule__Assign_Stmt__Group__1__Impl
			// rule__Assign_Stmt__Group__2
			{
				pushFollow(FOLLOW_17);
				rule__Assign_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Assign_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__1"

	// $ANTLR start "rule__Assign_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:3844:1: rule__Assign_Stmt__Group__1__Impl : (
	// ColonEqualsSign ) ;
	public final void rule__Assign_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3848:1: ( ( ColonEqualsSign ) )
			// InternalStructuredTextParser.g:3849:1: ( ColonEqualsSign )
			{
				// InternalStructuredTextParser.g:3849:1: ( ColonEqualsSign )
				// InternalStructuredTextParser.g:3850:2: ColonEqualsSign
				{
					before(grammarAccess.getAssign_StmtAccess().getColonEqualsSignKeyword_1());
					match(input, ColonEqualsSign, FOLLOW_2);
					after(grammarAccess.getAssign_StmtAccess().getColonEqualsSignKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__1__Impl"

	// $ANTLR start "rule__Assign_Stmt__Group__2"
	// InternalStructuredTextParser.g:3859:1: rule__Assign_Stmt__Group__2 :
	// rule__Assign_Stmt__Group__2__Impl ;
	public final void rule__Assign_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3863:1: ( rule__Assign_Stmt__Group__2__Impl )
			// InternalStructuredTextParser.g:3864:2: rule__Assign_Stmt__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Assign_Stmt__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__2"

	// $ANTLR start "rule__Assign_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:3870:1: rule__Assign_Stmt__Group__2__Impl : (
	// ( rule__Assign_Stmt__ExpressionAssignment_2 ) ) ;
	public final void rule__Assign_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3874:1: ( ( (
			// rule__Assign_Stmt__ExpressionAssignment_2 ) ) )
			// InternalStructuredTextParser.g:3875:1: ( (
			// rule__Assign_Stmt__ExpressionAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:3875:1: ( (
				// rule__Assign_Stmt__ExpressionAssignment_2 ) )
				// InternalStructuredTextParser.g:3876:2: (
				// rule__Assign_Stmt__ExpressionAssignment_2 )
				{
					before(grammarAccess.getAssign_StmtAccess().getExpressionAssignment_2());
					// InternalStructuredTextParser.g:3877:2: (
					// rule__Assign_Stmt__ExpressionAssignment_2 )
					// InternalStructuredTextParser.g:3877:3:
					// rule__Assign_Stmt__ExpressionAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__Assign_Stmt__ExpressionAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getAssign_StmtAccess().getExpressionAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__Group__2__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__0"
	// InternalStructuredTextParser.g:3886:1: rule__Subprog_Ctrl_Stmt__Group_1__0 :
	// rule__Subprog_Ctrl_Stmt__Group_1__0__Impl rule__Subprog_Ctrl_Stmt__Group_1__1
	// ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3890:1: (
			// rule__Subprog_Ctrl_Stmt__Group_1__0__Impl rule__Subprog_Ctrl_Stmt__Group_1__1
			// )
			// InternalStructuredTextParser.g:3891:2:
			// rule__Subprog_Ctrl_Stmt__Group_1__0__Impl rule__Subprog_Ctrl_Stmt__Group_1__1
			{
				pushFollow(FOLLOW_18);
				rule__Subprog_Ctrl_Stmt__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__0"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__0__Impl"
	// InternalStructuredTextParser.g:3898:1:
	// rule__Subprog_Ctrl_Stmt__Group_1__0__Impl : ( () ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3902:1: ( ( () ) )
			// InternalStructuredTextParser.g:3903:1: ( () )
			{
				// InternalStructuredTextParser.g:3903:1: ( () )
				// InternalStructuredTextParser.g:3904:2: ()
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getSuperStatementAction_1_0());
					// InternalStructuredTextParser.g:3905:2: ()
					// InternalStructuredTextParser.g:3905:3:
					{
					}

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getSuperStatementAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__0__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__1"
	// InternalStructuredTextParser.g:3913:1: rule__Subprog_Ctrl_Stmt__Group_1__1 :
	// rule__Subprog_Ctrl_Stmt__Group_1__1__Impl rule__Subprog_Ctrl_Stmt__Group_1__2
	// ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3917:1: (
			// rule__Subprog_Ctrl_Stmt__Group_1__1__Impl rule__Subprog_Ctrl_Stmt__Group_1__2
			// )
			// InternalStructuredTextParser.g:3918:2:
			// rule__Subprog_Ctrl_Stmt__Group_1__1__Impl rule__Subprog_Ctrl_Stmt__Group_1__2
			{
				pushFollow(FOLLOW_19);
				rule__Subprog_Ctrl_Stmt__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__1"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__1__Impl"
	// InternalStructuredTextParser.g:3925:1:
	// rule__Subprog_Ctrl_Stmt__Group_1__1__Impl : ( SUPER ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3929:1: ( ( SUPER ) )
			// InternalStructuredTextParser.g:3930:1: ( SUPER )
			{
				// InternalStructuredTextParser.g:3930:1: ( SUPER )
				// InternalStructuredTextParser.g:3931:2: SUPER
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getSUPERKeyword_1_1());
					match(input, SUPER, FOLLOW_2);
					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getSUPERKeyword_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__1__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__2"
	// InternalStructuredTextParser.g:3940:1: rule__Subprog_Ctrl_Stmt__Group_1__2 :
	// rule__Subprog_Ctrl_Stmt__Group_1__2__Impl rule__Subprog_Ctrl_Stmt__Group_1__3
	// ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3944:1: (
			// rule__Subprog_Ctrl_Stmt__Group_1__2__Impl rule__Subprog_Ctrl_Stmt__Group_1__3
			// )
			// InternalStructuredTextParser.g:3945:2:
			// rule__Subprog_Ctrl_Stmt__Group_1__2__Impl rule__Subprog_Ctrl_Stmt__Group_1__3
			{
				pushFollow(FOLLOW_20);
				rule__Subprog_Ctrl_Stmt__Group_1__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_1__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__2"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__2__Impl"
	// InternalStructuredTextParser.g:3952:1:
	// rule__Subprog_Ctrl_Stmt__Group_1__2__Impl : ( LeftParenthesis ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3956:1: ( ( LeftParenthesis ) )
			// InternalStructuredTextParser.g:3957:1: ( LeftParenthesis )
			{
				// InternalStructuredTextParser.g:3957:1: ( LeftParenthesis )
				// InternalStructuredTextParser.g:3958:2: LeftParenthesis
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getLeftParenthesisKeyword_1_2());
					match(input, LeftParenthesis, FOLLOW_2);
					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getLeftParenthesisKeyword_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__2__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__3"
	// InternalStructuredTextParser.g:3967:1: rule__Subprog_Ctrl_Stmt__Group_1__3 :
	// rule__Subprog_Ctrl_Stmt__Group_1__3__Impl ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3971:1: (
			// rule__Subprog_Ctrl_Stmt__Group_1__3__Impl )
			// InternalStructuredTextParser.g:3972:2:
			// rule__Subprog_Ctrl_Stmt__Group_1__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_1__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__3"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_1__3__Impl"
	// InternalStructuredTextParser.g:3978:1:
	// rule__Subprog_Ctrl_Stmt__Group_1__3__Impl : ( RightParenthesis ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_1__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3982:1: ( ( RightParenthesis ) )
			// InternalStructuredTextParser.g:3983:1: ( RightParenthesis )
			{
				// InternalStructuredTextParser.g:3983:1: ( RightParenthesis )
				// InternalStructuredTextParser.g:3984:2: RightParenthesis
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getRightParenthesisKeyword_1_3());
					match(input, RightParenthesis, FOLLOW_2);
					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getRightParenthesisKeyword_1_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_1__3__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_2__0"
	// InternalStructuredTextParser.g:3994:1: rule__Subprog_Ctrl_Stmt__Group_2__0 :
	// rule__Subprog_Ctrl_Stmt__Group_2__0__Impl rule__Subprog_Ctrl_Stmt__Group_2__1
	// ;
	public final void rule__Subprog_Ctrl_Stmt__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:3998:1: (
			// rule__Subprog_Ctrl_Stmt__Group_2__0__Impl rule__Subprog_Ctrl_Stmt__Group_2__1
			// )
			// InternalStructuredTextParser.g:3999:2:
			// rule__Subprog_Ctrl_Stmt__Group_2__0__Impl rule__Subprog_Ctrl_Stmt__Group_2__1
			{
				pushFollow(FOLLOW_21);
				rule__Subprog_Ctrl_Stmt__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_2__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_2__0"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_2__0__Impl"
	// InternalStructuredTextParser.g:4006:1:
	// rule__Subprog_Ctrl_Stmt__Group_2__0__Impl : ( () ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4010:1: ( ( () ) )
			// InternalStructuredTextParser.g:4011:1: ( () )
			{
				// InternalStructuredTextParser.g:4011:1: ( () )
				// InternalStructuredTextParser.g:4012:2: ()
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getReturnStatementAction_2_0());
					// InternalStructuredTextParser.g:4013:2: ()
					// InternalStructuredTextParser.g:4013:3:
					{
					}

					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getReturnStatementAction_2_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_2__0__Impl"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_2__1"
	// InternalStructuredTextParser.g:4021:1: rule__Subprog_Ctrl_Stmt__Group_2__1 :
	// rule__Subprog_Ctrl_Stmt__Group_2__1__Impl ;
	public final void rule__Subprog_Ctrl_Stmt__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4025:1: (
			// rule__Subprog_Ctrl_Stmt__Group_2__1__Impl )
			// InternalStructuredTextParser.g:4026:2:
			// rule__Subprog_Ctrl_Stmt__Group_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Subprog_Ctrl_Stmt__Group_2__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_2__1"

	// $ANTLR start "rule__Subprog_Ctrl_Stmt__Group_2__1__Impl"
	// InternalStructuredTextParser.g:4032:1:
	// rule__Subprog_Ctrl_Stmt__Group_2__1__Impl : ( RETURN ) ;
	public final void rule__Subprog_Ctrl_Stmt__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4036:1: ( ( RETURN ) )
			// InternalStructuredTextParser.g:4037:1: ( RETURN )
			{
				// InternalStructuredTextParser.g:4037:1: ( RETURN )
				// InternalStructuredTextParser.g:4038:2: RETURN
				{
					before(grammarAccess.getSubprog_Ctrl_StmtAccess().getRETURNKeyword_2_1());
					match(input, RETURN, FOLLOW_2);
					after(grammarAccess.getSubprog_Ctrl_StmtAccess().getRETURNKeyword_2_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Subprog_Ctrl_Stmt__Group_2__1__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__0"
	// InternalStructuredTextParser.g:4048:1: rule__IF_Stmt__Group__0 :
	// rule__IF_Stmt__Group__0__Impl rule__IF_Stmt__Group__1 ;
	public final void rule__IF_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4052:1: ( rule__IF_Stmt__Group__0__Impl
			// rule__IF_Stmt__Group__1 )
			// InternalStructuredTextParser.g:4053:2: rule__IF_Stmt__Group__0__Impl
			// rule__IF_Stmt__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__IF_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__0"

	// $ANTLR start "rule__IF_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:4060:1: rule__IF_Stmt__Group__0__Impl : ( IF )
	// ;
	public final void rule__IF_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4064:1: ( ( IF ) )
			// InternalStructuredTextParser.g:4065:1: ( IF )
			{
				// InternalStructuredTextParser.g:4065:1: ( IF )
				// InternalStructuredTextParser.g:4066:2: IF
				{
					before(grammarAccess.getIF_StmtAccess().getIFKeyword_0());
					match(input, IF, FOLLOW_2);
					after(grammarAccess.getIF_StmtAccess().getIFKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__0__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__1"
	// InternalStructuredTextParser.g:4075:1: rule__IF_Stmt__Group__1 :
	// rule__IF_Stmt__Group__1__Impl rule__IF_Stmt__Group__2 ;
	public final void rule__IF_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4079:1: ( rule__IF_Stmt__Group__1__Impl
			// rule__IF_Stmt__Group__2 )
			// InternalStructuredTextParser.g:4080:2: rule__IF_Stmt__Group__1__Impl
			// rule__IF_Stmt__Group__2
			{
				pushFollow(FOLLOW_22);
				rule__IF_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__1"

	// $ANTLR start "rule__IF_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:4087:1: rule__IF_Stmt__Group__1__Impl : ( (
	// rule__IF_Stmt__ExpressionAssignment_1 ) ) ;
	public final void rule__IF_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4091:1: ( ( (
			// rule__IF_Stmt__ExpressionAssignment_1 ) ) )
			// InternalStructuredTextParser.g:4092:1: ( (
			// rule__IF_Stmt__ExpressionAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:4092:1: ( (
				// rule__IF_Stmt__ExpressionAssignment_1 ) )
				// InternalStructuredTextParser.g:4093:2: (
				// rule__IF_Stmt__ExpressionAssignment_1 )
				{
					before(grammarAccess.getIF_StmtAccess().getExpressionAssignment_1());
					// InternalStructuredTextParser.g:4094:2: (
					// rule__IF_Stmt__ExpressionAssignment_1 )
					// InternalStructuredTextParser.g:4094:3: rule__IF_Stmt__ExpressionAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__IF_Stmt__ExpressionAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getIF_StmtAccess().getExpressionAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__1__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__2"
	// InternalStructuredTextParser.g:4102:1: rule__IF_Stmt__Group__2 :
	// rule__IF_Stmt__Group__2__Impl rule__IF_Stmt__Group__3 ;
	public final void rule__IF_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4106:1: ( rule__IF_Stmt__Group__2__Impl
			// rule__IF_Stmt__Group__3 )
			// InternalStructuredTextParser.g:4107:2: rule__IF_Stmt__Group__2__Impl
			// rule__IF_Stmt__Group__3
			{
				pushFollow(FOLLOW_3);
				rule__IF_Stmt__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__2"

	// $ANTLR start "rule__IF_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:4114:1: rule__IF_Stmt__Group__2__Impl : ( THEN
	// ) ;
	public final void rule__IF_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4118:1: ( ( THEN ) )
			// InternalStructuredTextParser.g:4119:1: ( THEN )
			{
				// InternalStructuredTextParser.g:4119:1: ( THEN )
				// InternalStructuredTextParser.g:4120:2: THEN
				{
					before(grammarAccess.getIF_StmtAccess().getTHENKeyword_2());
					match(input, THEN, FOLLOW_2);
					after(grammarAccess.getIF_StmtAccess().getTHENKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__2__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__3"
	// InternalStructuredTextParser.g:4129:1: rule__IF_Stmt__Group__3 :
	// rule__IF_Stmt__Group__3__Impl rule__IF_Stmt__Group__4 ;
	public final void rule__IF_Stmt__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4133:1: ( rule__IF_Stmt__Group__3__Impl
			// rule__IF_Stmt__Group__4 )
			// InternalStructuredTextParser.g:4134:2: rule__IF_Stmt__Group__3__Impl
			// rule__IF_Stmt__Group__4
			{
				pushFollow(FOLLOW_23);
				rule__IF_Stmt__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__3"

	// $ANTLR start "rule__IF_Stmt__Group__3__Impl"
	// InternalStructuredTextParser.g:4141:1: rule__IF_Stmt__Group__3__Impl : ( (
	// rule__IF_Stmt__StatmentsAssignment_3 ) ) ;
	public final void rule__IF_Stmt__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4145:1: ( ( (
			// rule__IF_Stmt__StatmentsAssignment_3 ) ) )
			// InternalStructuredTextParser.g:4146:1: ( (
			// rule__IF_Stmt__StatmentsAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:4146:1: ( (
				// rule__IF_Stmt__StatmentsAssignment_3 ) )
				// InternalStructuredTextParser.g:4147:2: ( rule__IF_Stmt__StatmentsAssignment_3
				// )
				{
					before(grammarAccess.getIF_StmtAccess().getStatmentsAssignment_3());
					// InternalStructuredTextParser.g:4148:2: ( rule__IF_Stmt__StatmentsAssignment_3
					// )
					// InternalStructuredTextParser.g:4148:3: rule__IF_Stmt__StatmentsAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__IF_Stmt__StatmentsAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getIF_StmtAccess().getStatmentsAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__3__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__4"
	// InternalStructuredTextParser.g:4156:1: rule__IF_Stmt__Group__4 :
	// rule__IF_Stmt__Group__4__Impl rule__IF_Stmt__Group__5 ;
	public final void rule__IF_Stmt__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4160:1: ( rule__IF_Stmt__Group__4__Impl
			// rule__IF_Stmt__Group__5 )
			// InternalStructuredTextParser.g:4161:2: rule__IF_Stmt__Group__4__Impl
			// rule__IF_Stmt__Group__5
			{
				pushFollow(FOLLOW_23);
				rule__IF_Stmt__Group__4__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__5();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__4"

	// $ANTLR start "rule__IF_Stmt__Group__4__Impl"
	// InternalStructuredTextParser.g:4168:1: rule__IF_Stmt__Group__4__Impl : ( (
	// rule__IF_Stmt__ElseifAssignment_4 )* ) ;
	public final void rule__IF_Stmt__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4172:1: ( ( (
			// rule__IF_Stmt__ElseifAssignment_4 )* ) )
			// InternalStructuredTextParser.g:4173:1: ( ( rule__IF_Stmt__ElseifAssignment_4
			// )* )
			{
				// InternalStructuredTextParser.g:4173:1: ( ( rule__IF_Stmt__ElseifAssignment_4
				// )* )
				// InternalStructuredTextParser.g:4174:2: ( rule__IF_Stmt__ElseifAssignment_4 )*
				{
					before(grammarAccess.getIF_StmtAccess().getElseifAssignment_4());
					// InternalStructuredTextParser.g:4175:2: ( rule__IF_Stmt__ElseifAssignment_4 )*
					loop42: do {
						int alt42 = 2;
						int LA42_0 = input.LA(1);

						if ((LA42_0 == ELSIF)) {
							alt42 = 1;
						}

						switch (alt42) {
						case 1:
						// InternalStructuredTextParser.g:4175:3: rule__IF_Stmt__ElseifAssignment_4
						{
							pushFollow(FOLLOW_24);
							rule__IF_Stmt__ElseifAssignment_4();

							state._fsp--;

						}
							break;

						default:
							break loop42;
						}
					} while (true);

					after(grammarAccess.getIF_StmtAccess().getElseifAssignment_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__4__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__5"
	// InternalStructuredTextParser.g:4183:1: rule__IF_Stmt__Group__5 :
	// rule__IF_Stmt__Group__5__Impl rule__IF_Stmt__Group__6 ;
	public final void rule__IF_Stmt__Group__5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4187:1: ( rule__IF_Stmt__Group__5__Impl
			// rule__IF_Stmt__Group__6 )
			// InternalStructuredTextParser.g:4188:2: rule__IF_Stmt__Group__5__Impl
			// rule__IF_Stmt__Group__6
			{
				pushFollow(FOLLOW_23);
				rule__IF_Stmt__Group__5__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__6();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__5"

	// $ANTLR start "rule__IF_Stmt__Group__5__Impl"
	// InternalStructuredTextParser.g:4195:1: rule__IF_Stmt__Group__5__Impl : ( (
	// rule__IF_Stmt__ElseAssignment_5 )? ) ;
	public final void rule__IF_Stmt__Group__5__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4199:1: ( ( ( rule__IF_Stmt__ElseAssignment_5
			// )? ) )
			// InternalStructuredTextParser.g:4200:1: ( ( rule__IF_Stmt__ElseAssignment_5 )?
			// )
			{
				// InternalStructuredTextParser.g:4200:1: ( ( rule__IF_Stmt__ElseAssignment_5 )?
				// )
				// InternalStructuredTextParser.g:4201:2: ( rule__IF_Stmt__ElseAssignment_5 )?
				{
					before(grammarAccess.getIF_StmtAccess().getElseAssignment_5());
					// InternalStructuredTextParser.g:4202:2: ( rule__IF_Stmt__ElseAssignment_5 )?
					int alt43 = 2;
					int LA43_0 = input.LA(1);

					if ((LA43_0 == ELSE)) {
						alt43 = 1;
					}
					switch (alt43) {
					case 1:
					// InternalStructuredTextParser.g:4202:3: rule__IF_Stmt__ElseAssignment_5
					{
						pushFollow(FOLLOW_2);
						rule__IF_Stmt__ElseAssignment_5();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getIF_StmtAccess().getElseAssignment_5());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__5__Impl"

	// $ANTLR start "rule__IF_Stmt__Group__6"
	// InternalStructuredTextParser.g:4210:1: rule__IF_Stmt__Group__6 :
	// rule__IF_Stmt__Group__6__Impl ;
	public final void rule__IF_Stmt__Group__6() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4214:1: ( rule__IF_Stmt__Group__6__Impl )
			// InternalStructuredTextParser.g:4215:2: rule__IF_Stmt__Group__6__Impl
			{
				pushFollow(FOLLOW_2);
				rule__IF_Stmt__Group__6__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__6"

	// $ANTLR start "rule__IF_Stmt__Group__6__Impl"
	// InternalStructuredTextParser.g:4221:1: rule__IF_Stmt__Group__6__Impl : (
	// END_IF ) ;
	public final void rule__IF_Stmt__Group__6__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4225:1: ( ( END_IF ) )
			// InternalStructuredTextParser.g:4226:1: ( END_IF )
			{
				// InternalStructuredTextParser.g:4226:1: ( END_IF )
				// InternalStructuredTextParser.g:4227:2: END_IF
				{
					before(grammarAccess.getIF_StmtAccess().getEND_IFKeyword_6());
					match(input, END_IF, FOLLOW_2);
					after(grammarAccess.getIF_StmtAccess().getEND_IFKeyword_6());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__Group__6__Impl"

	// $ANTLR start "rule__ELSIF_Clause__Group__0"
	// InternalStructuredTextParser.g:4237:1: rule__ELSIF_Clause__Group__0 :
	// rule__ELSIF_Clause__Group__0__Impl rule__ELSIF_Clause__Group__1 ;
	public final void rule__ELSIF_Clause__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4241:1: ( rule__ELSIF_Clause__Group__0__Impl
			// rule__ELSIF_Clause__Group__1 )
			// InternalStructuredTextParser.g:4242:2: rule__ELSIF_Clause__Group__0__Impl
			// rule__ELSIF_Clause__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__ELSIF_Clause__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ELSIF_Clause__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__0"

	// $ANTLR start "rule__ELSIF_Clause__Group__0__Impl"
	// InternalStructuredTextParser.g:4249:1: rule__ELSIF_Clause__Group__0__Impl : (
	// ELSIF ) ;
	public final void rule__ELSIF_Clause__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4253:1: ( ( ELSIF ) )
			// InternalStructuredTextParser.g:4254:1: ( ELSIF )
			{
				// InternalStructuredTextParser.g:4254:1: ( ELSIF )
				// InternalStructuredTextParser.g:4255:2: ELSIF
				{
					before(grammarAccess.getELSIF_ClauseAccess().getELSIFKeyword_0());
					match(input, ELSIF, FOLLOW_2);
					after(grammarAccess.getELSIF_ClauseAccess().getELSIFKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__0__Impl"

	// $ANTLR start "rule__ELSIF_Clause__Group__1"
	// InternalStructuredTextParser.g:4264:1: rule__ELSIF_Clause__Group__1 :
	// rule__ELSIF_Clause__Group__1__Impl rule__ELSIF_Clause__Group__2 ;
	public final void rule__ELSIF_Clause__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4268:1: ( rule__ELSIF_Clause__Group__1__Impl
			// rule__ELSIF_Clause__Group__2 )
			// InternalStructuredTextParser.g:4269:2: rule__ELSIF_Clause__Group__1__Impl
			// rule__ELSIF_Clause__Group__2
			{
				pushFollow(FOLLOW_22);
				rule__ELSIF_Clause__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ELSIF_Clause__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__1"

	// $ANTLR start "rule__ELSIF_Clause__Group__1__Impl"
	// InternalStructuredTextParser.g:4276:1: rule__ELSIF_Clause__Group__1__Impl : (
	// ( rule__ELSIF_Clause__ExpressionAssignment_1 ) ) ;
	public final void rule__ELSIF_Clause__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4280:1: ( ( (
			// rule__ELSIF_Clause__ExpressionAssignment_1 ) ) )
			// InternalStructuredTextParser.g:4281:1: ( (
			// rule__ELSIF_Clause__ExpressionAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:4281:1: ( (
				// rule__ELSIF_Clause__ExpressionAssignment_1 ) )
				// InternalStructuredTextParser.g:4282:2: (
				// rule__ELSIF_Clause__ExpressionAssignment_1 )
				{
					before(grammarAccess.getELSIF_ClauseAccess().getExpressionAssignment_1());
					// InternalStructuredTextParser.g:4283:2: (
					// rule__ELSIF_Clause__ExpressionAssignment_1 )
					// InternalStructuredTextParser.g:4283:3:
					// rule__ELSIF_Clause__ExpressionAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__ELSIF_Clause__ExpressionAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getELSIF_ClauseAccess().getExpressionAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__1__Impl"

	// $ANTLR start "rule__ELSIF_Clause__Group__2"
	// InternalStructuredTextParser.g:4291:1: rule__ELSIF_Clause__Group__2 :
	// rule__ELSIF_Clause__Group__2__Impl rule__ELSIF_Clause__Group__3 ;
	public final void rule__ELSIF_Clause__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4295:1: ( rule__ELSIF_Clause__Group__2__Impl
			// rule__ELSIF_Clause__Group__3 )
			// InternalStructuredTextParser.g:4296:2: rule__ELSIF_Clause__Group__2__Impl
			// rule__ELSIF_Clause__Group__3
			{
				pushFollow(FOLLOW_3);
				rule__ELSIF_Clause__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ELSIF_Clause__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__2"

	// $ANTLR start "rule__ELSIF_Clause__Group__2__Impl"
	// InternalStructuredTextParser.g:4303:1: rule__ELSIF_Clause__Group__2__Impl : (
	// THEN ) ;
	public final void rule__ELSIF_Clause__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4307:1: ( ( THEN ) )
			// InternalStructuredTextParser.g:4308:1: ( THEN )
			{
				// InternalStructuredTextParser.g:4308:1: ( THEN )
				// InternalStructuredTextParser.g:4309:2: THEN
				{
					before(grammarAccess.getELSIF_ClauseAccess().getTHENKeyword_2());
					match(input, THEN, FOLLOW_2);
					after(grammarAccess.getELSIF_ClauseAccess().getTHENKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__2__Impl"

	// $ANTLR start "rule__ELSIF_Clause__Group__3"
	// InternalStructuredTextParser.g:4318:1: rule__ELSIF_Clause__Group__3 :
	// rule__ELSIF_Clause__Group__3__Impl ;
	public final void rule__ELSIF_Clause__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4322:1: ( rule__ELSIF_Clause__Group__3__Impl )
			// InternalStructuredTextParser.g:4323:2: rule__ELSIF_Clause__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ELSIF_Clause__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__3"

	// $ANTLR start "rule__ELSIF_Clause__Group__3__Impl"
	// InternalStructuredTextParser.g:4329:1: rule__ELSIF_Clause__Group__3__Impl : (
	// ( rule__ELSIF_Clause__StatementsAssignment_3 ) ) ;
	public final void rule__ELSIF_Clause__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4333:1: ( ( (
			// rule__ELSIF_Clause__StatementsAssignment_3 ) ) )
			// InternalStructuredTextParser.g:4334:1: ( (
			// rule__ELSIF_Clause__StatementsAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:4334:1: ( (
				// rule__ELSIF_Clause__StatementsAssignment_3 ) )
				// InternalStructuredTextParser.g:4335:2: (
				// rule__ELSIF_Clause__StatementsAssignment_3 )
				{
					before(grammarAccess.getELSIF_ClauseAccess().getStatementsAssignment_3());
					// InternalStructuredTextParser.g:4336:2: (
					// rule__ELSIF_Clause__StatementsAssignment_3 )
					// InternalStructuredTextParser.g:4336:3:
					// rule__ELSIF_Clause__StatementsAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__ELSIF_Clause__StatementsAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getELSIF_ClauseAccess().getStatementsAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__Group__3__Impl"

	// $ANTLR start "rule__ELSE_Clause__Group__0"
	// InternalStructuredTextParser.g:4345:1: rule__ELSE_Clause__Group__0 :
	// rule__ELSE_Clause__Group__0__Impl rule__ELSE_Clause__Group__1 ;
	public final void rule__ELSE_Clause__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4349:1: ( rule__ELSE_Clause__Group__0__Impl
			// rule__ELSE_Clause__Group__1 )
			// InternalStructuredTextParser.g:4350:2: rule__ELSE_Clause__Group__0__Impl
			// rule__ELSE_Clause__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__ELSE_Clause__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__ELSE_Clause__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSE_Clause__Group__0"

	// $ANTLR start "rule__ELSE_Clause__Group__0__Impl"
	// InternalStructuredTextParser.g:4357:1: rule__ELSE_Clause__Group__0__Impl : (
	// ELSE ) ;
	public final void rule__ELSE_Clause__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4361:1: ( ( ELSE ) )
			// InternalStructuredTextParser.g:4362:1: ( ELSE )
			{
				// InternalStructuredTextParser.g:4362:1: ( ELSE )
				// InternalStructuredTextParser.g:4363:2: ELSE
				{
					before(grammarAccess.getELSE_ClauseAccess().getELSEKeyword_0());
					match(input, ELSE, FOLLOW_2);
					after(grammarAccess.getELSE_ClauseAccess().getELSEKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSE_Clause__Group__0__Impl"

	// $ANTLR start "rule__ELSE_Clause__Group__1"
	// InternalStructuredTextParser.g:4372:1: rule__ELSE_Clause__Group__1 :
	// rule__ELSE_Clause__Group__1__Impl ;
	public final void rule__ELSE_Clause__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4376:1: ( rule__ELSE_Clause__Group__1__Impl )
			// InternalStructuredTextParser.g:4377:2: rule__ELSE_Clause__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__ELSE_Clause__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSE_Clause__Group__1"

	// $ANTLR start "rule__ELSE_Clause__Group__1__Impl"
	// InternalStructuredTextParser.g:4383:1: rule__ELSE_Clause__Group__1__Impl : (
	// ( rule__ELSE_Clause__StatementsAssignment_1 ) ) ;
	public final void rule__ELSE_Clause__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4387:1: ( ( (
			// rule__ELSE_Clause__StatementsAssignment_1 ) ) )
			// InternalStructuredTextParser.g:4388:1: ( (
			// rule__ELSE_Clause__StatementsAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:4388:1: ( (
				// rule__ELSE_Clause__StatementsAssignment_1 ) )
				// InternalStructuredTextParser.g:4389:2: (
				// rule__ELSE_Clause__StatementsAssignment_1 )
				{
					before(grammarAccess.getELSE_ClauseAccess().getStatementsAssignment_1());
					// InternalStructuredTextParser.g:4390:2: (
					// rule__ELSE_Clause__StatementsAssignment_1 )
					// InternalStructuredTextParser.g:4390:3:
					// rule__ELSE_Clause__StatementsAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__ELSE_Clause__StatementsAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getELSE_ClauseAccess().getStatementsAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSE_Clause__Group__1__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__0"
	// InternalStructuredTextParser.g:4399:1: rule__Case_Stmt__Group__0 :
	// rule__Case_Stmt__Group__0__Impl rule__Case_Stmt__Group__1 ;
	public final void rule__Case_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4403:1: ( rule__Case_Stmt__Group__0__Impl
			// rule__Case_Stmt__Group__1 )
			// InternalStructuredTextParser.g:4404:2: rule__Case_Stmt__Group__0__Impl
			// rule__Case_Stmt__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__Case_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__0"

	// $ANTLR start "rule__Case_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:4411:1: rule__Case_Stmt__Group__0__Impl : (
	// CASE ) ;
	public final void rule__Case_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4415:1: ( ( CASE ) )
			// InternalStructuredTextParser.g:4416:1: ( CASE )
			{
				// InternalStructuredTextParser.g:4416:1: ( CASE )
				// InternalStructuredTextParser.g:4417:2: CASE
				{
					before(grammarAccess.getCase_StmtAccess().getCASEKeyword_0());
					match(input, CASE, FOLLOW_2);
					after(grammarAccess.getCase_StmtAccess().getCASEKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__0__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__1"
	// InternalStructuredTextParser.g:4426:1: rule__Case_Stmt__Group__1 :
	// rule__Case_Stmt__Group__1__Impl rule__Case_Stmt__Group__2 ;
	public final void rule__Case_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4430:1: ( rule__Case_Stmt__Group__1__Impl
			// rule__Case_Stmt__Group__2 )
			// InternalStructuredTextParser.g:4431:2: rule__Case_Stmt__Group__1__Impl
			// rule__Case_Stmt__Group__2
			{
				pushFollow(FOLLOW_25);
				rule__Case_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__1"

	// $ANTLR start "rule__Case_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:4438:1: rule__Case_Stmt__Group__1__Impl : ( (
	// rule__Case_Stmt__ExpressionAssignment_1 ) ) ;
	public final void rule__Case_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4442:1: ( ( (
			// rule__Case_Stmt__ExpressionAssignment_1 ) ) )
			// InternalStructuredTextParser.g:4443:1: ( (
			// rule__Case_Stmt__ExpressionAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:4443:1: ( (
				// rule__Case_Stmt__ExpressionAssignment_1 ) )
				// InternalStructuredTextParser.g:4444:2: (
				// rule__Case_Stmt__ExpressionAssignment_1 )
				{
					before(grammarAccess.getCase_StmtAccess().getExpressionAssignment_1());
					// InternalStructuredTextParser.g:4445:2: (
					// rule__Case_Stmt__ExpressionAssignment_1 )
					// InternalStructuredTextParser.g:4445:3:
					// rule__Case_Stmt__ExpressionAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Case_Stmt__ExpressionAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getCase_StmtAccess().getExpressionAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__1__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__2"
	// InternalStructuredTextParser.g:4453:1: rule__Case_Stmt__Group__2 :
	// rule__Case_Stmt__Group__2__Impl rule__Case_Stmt__Group__3 ;
	public final void rule__Case_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4457:1: ( rule__Case_Stmt__Group__2__Impl
			// rule__Case_Stmt__Group__3 )
			// InternalStructuredTextParser.g:4458:2: rule__Case_Stmt__Group__2__Impl
			// rule__Case_Stmt__Group__3
			{
				pushFollow(FOLLOW_13);
				rule__Case_Stmt__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__2"

	// $ANTLR start "rule__Case_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:4465:1: rule__Case_Stmt__Group__2__Impl : ( OF
	// ) ;
	public final void rule__Case_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4469:1: ( ( OF ) )
			// InternalStructuredTextParser.g:4470:1: ( OF )
			{
				// InternalStructuredTextParser.g:4470:1: ( OF )
				// InternalStructuredTextParser.g:4471:2: OF
				{
					before(grammarAccess.getCase_StmtAccess().getOFKeyword_2());
					match(input, OF, FOLLOW_2);
					after(grammarAccess.getCase_StmtAccess().getOFKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__2__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__3"
	// InternalStructuredTextParser.g:4480:1: rule__Case_Stmt__Group__3 :
	// rule__Case_Stmt__Group__3__Impl rule__Case_Stmt__Group__4 ;
	public final void rule__Case_Stmt__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4484:1: ( rule__Case_Stmt__Group__3__Impl
			// rule__Case_Stmt__Group__4 )
			// InternalStructuredTextParser.g:4485:2: rule__Case_Stmt__Group__3__Impl
			// rule__Case_Stmt__Group__4
			{
				pushFollow(FOLLOW_26);
				rule__Case_Stmt__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__3"

	// $ANTLR start "rule__Case_Stmt__Group__3__Impl"
	// InternalStructuredTextParser.g:4492:1: rule__Case_Stmt__Group__3__Impl : ( (
	// ( rule__Case_Stmt__CaseAssignment_3 ) ) ( ( rule__Case_Stmt__CaseAssignment_3
	// )* ) ) ;
	public final void rule__Case_Stmt__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4496:1: ( ( ( (
			// rule__Case_Stmt__CaseAssignment_3 ) ) ( ( rule__Case_Stmt__CaseAssignment_3
			// )* ) ) )
			// InternalStructuredTextParser.g:4497:1: ( ( (
			// rule__Case_Stmt__CaseAssignment_3 ) ) ( ( rule__Case_Stmt__CaseAssignment_3
			// )* ) )
			{
				// InternalStructuredTextParser.g:4497:1: ( ( (
				// rule__Case_Stmt__CaseAssignment_3 ) ) ( ( rule__Case_Stmt__CaseAssignment_3
				// )* ) )
				// InternalStructuredTextParser.g:4498:2: ( ( rule__Case_Stmt__CaseAssignment_3
				// ) ) ( ( rule__Case_Stmt__CaseAssignment_3 )* )
				{
					// InternalStructuredTextParser.g:4498:2: ( ( rule__Case_Stmt__CaseAssignment_3
					// ) )
					// InternalStructuredTextParser.g:4499:3: ( rule__Case_Stmt__CaseAssignment_3 )
					{
						before(grammarAccess.getCase_StmtAccess().getCaseAssignment_3());
						// InternalStructuredTextParser.g:4500:3: ( rule__Case_Stmt__CaseAssignment_3 )
						// InternalStructuredTextParser.g:4500:4: rule__Case_Stmt__CaseAssignment_3
						{
							pushFollow(FOLLOW_27);
							rule__Case_Stmt__CaseAssignment_3();

							state._fsp--;

						}

						after(grammarAccess.getCase_StmtAccess().getCaseAssignment_3());

					}

					// InternalStructuredTextParser.g:4503:2: ( ( rule__Case_Stmt__CaseAssignment_3
					// )* )
					// InternalStructuredTextParser.g:4504:3: ( rule__Case_Stmt__CaseAssignment_3 )*
					{
						before(grammarAccess.getCase_StmtAccess().getCaseAssignment_3());
						// InternalStructuredTextParser.g:4505:3: ( rule__Case_Stmt__CaseAssignment_3 )*
						loop44: do {
							int alt44 = 2;
							int LA44_0 = input.LA(1);

							if (((LA44_0 >= LDATE_AND_TIME && LA44_0 <= TIME_OF_DAY) || LA44_0 == WSTRING
									|| LA44_0 == STRING || (LA44_0 >= FALSE && LA44_0 <= LTIME)
									|| (LA44_0 >= UDINT && LA44_0 <= ULINT) || (LA44_0 >= USINT && LA44_0 <= WCHAR)
									|| LA44_0 == BOOL || (LA44_0 >= CHAR && LA44_0 <= DINT)
									|| (LA44_0 >= LINT && LA44_0 <= SINT) || (LA44_0 >= TIME && LA44_0 <= UINT)
									|| (LA44_0 >= INT && LA44_0 <= LDT) || LA44_0 == TOD || LA44_0 == DT
									|| (LA44_0 >= LD && LA44_0 <= LT) || LA44_0 == PlusSign || LA44_0 == HyphenMinus
									|| LA44_0 == T || LA44_0 == D_1
									|| (LA44_0 >= RULE_BINARY_INT && LA44_0 <= RULE_UNSIGNED_INT)
									|| LA44_0 == RULE_S_BYTE_CHAR_STR || LA44_0 == RULE_D_BYTE_CHAR_STR)) {
								alt44 = 1;
							}

							switch (alt44) {
							case 1:
							// InternalStructuredTextParser.g:4505:4: rule__Case_Stmt__CaseAssignment_3
							{
								pushFollow(FOLLOW_27);
								rule__Case_Stmt__CaseAssignment_3();

								state._fsp--;

							}
								break;

							default:
								break loop44;
							}
						} while (true);

						after(grammarAccess.getCase_StmtAccess().getCaseAssignment_3());

					}

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__3__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__4"
	// InternalStructuredTextParser.g:4514:1: rule__Case_Stmt__Group__4 :
	// rule__Case_Stmt__Group__4__Impl rule__Case_Stmt__Group__5 ;
	public final void rule__Case_Stmt__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4518:1: ( rule__Case_Stmt__Group__4__Impl
			// rule__Case_Stmt__Group__5 )
			// InternalStructuredTextParser.g:4519:2: rule__Case_Stmt__Group__4__Impl
			// rule__Case_Stmt__Group__5
			{
				pushFollow(FOLLOW_26);
				rule__Case_Stmt__Group__4__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__5();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__4"

	// $ANTLR start "rule__Case_Stmt__Group__4__Impl"
	// InternalStructuredTextParser.g:4526:1: rule__Case_Stmt__Group__4__Impl : ( (
	// rule__Case_Stmt__ElseAssignment_4 )? ) ;
	public final void rule__Case_Stmt__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4530:1: ( ( (
			// rule__Case_Stmt__ElseAssignment_4 )? ) )
			// InternalStructuredTextParser.g:4531:1: ( ( rule__Case_Stmt__ElseAssignment_4
			// )? )
			{
				// InternalStructuredTextParser.g:4531:1: ( ( rule__Case_Stmt__ElseAssignment_4
				// )? )
				// InternalStructuredTextParser.g:4532:2: ( rule__Case_Stmt__ElseAssignment_4 )?
				{
					before(grammarAccess.getCase_StmtAccess().getElseAssignment_4());
					// InternalStructuredTextParser.g:4533:2: ( rule__Case_Stmt__ElseAssignment_4 )?
					int alt45 = 2;
					int LA45_0 = input.LA(1);

					if ((LA45_0 == ELSE)) {
						alt45 = 1;
					}
					switch (alt45) {
					case 1:
					// InternalStructuredTextParser.g:4533:3: rule__Case_Stmt__ElseAssignment_4
					{
						pushFollow(FOLLOW_2);
						rule__Case_Stmt__ElseAssignment_4();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getCase_StmtAccess().getElseAssignment_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__4__Impl"

	// $ANTLR start "rule__Case_Stmt__Group__5"
	// InternalStructuredTextParser.g:4541:1: rule__Case_Stmt__Group__5 :
	// rule__Case_Stmt__Group__5__Impl ;
	public final void rule__Case_Stmt__Group__5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4545:1: ( rule__Case_Stmt__Group__5__Impl )
			// InternalStructuredTextParser.g:4546:2: rule__Case_Stmt__Group__5__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Case_Stmt__Group__5__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__5"

	// $ANTLR start "rule__Case_Stmt__Group__5__Impl"
	// InternalStructuredTextParser.g:4552:1: rule__Case_Stmt__Group__5__Impl : (
	// END_CASE ) ;
	public final void rule__Case_Stmt__Group__5__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4556:1: ( ( END_CASE ) )
			// InternalStructuredTextParser.g:4557:1: ( END_CASE )
			{
				// InternalStructuredTextParser.g:4557:1: ( END_CASE )
				// InternalStructuredTextParser.g:4558:2: END_CASE
				{
					before(grammarAccess.getCase_StmtAccess().getEND_CASEKeyword_5());
					match(input, END_CASE, FOLLOW_2);
					after(grammarAccess.getCase_StmtAccess().getEND_CASEKeyword_5());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__Group__5__Impl"

	// $ANTLR start "rule__Case_Selection__Group__0"
	// InternalStructuredTextParser.g:4568:1: rule__Case_Selection__Group__0 :
	// rule__Case_Selection__Group__0__Impl rule__Case_Selection__Group__1 ;
	public final void rule__Case_Selection__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4572:1: ( rule__Case_Selection__Group__0__Impl
			// rule__Case_Selection__Group__1 )
			// InternalStructuredTextParser.g:4573:2: rule__Case_Selection__Group__0__Impl
			// rule__Case_Selection__Group__1
			{
				pushFollow(FOLLOW_28);
				rule__Case_Selection__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__0"

	// $ANTLR start "rule__Case_Selection__Group__0__Impl"
	// InternalStructuredTextParser.g:4580:1: rule__Case_Selection__Group__0__Impl :
	// ( ( rule__Case_Selection__CaseAssignment_0 ) ) ;
	public final void rule__Case_Selection__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4584:1: ( ( (
			// rule__Case_Selection__CaseAssignment_0 ) ) )
			// InternalStructuredTextParser.g:4585:1: ( (
			// rule__Case_Selection__CaseAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:4585:1: ( (
				// rule__Case_Selection__CaseAssignment_0 ) )
				// InternalStructuredTextParser.g:4586:2: (
				// rule__Case_Selection__CaseAssignment_0 )
				{
					before(grammarAccess.getCase_SelectionAccess().getCaseAssignment_0());
					// InternalStructuredTextParser.g:4587:2: (
					// rule__Case_Selection__CaseAssignment_0 )
					// InternalStructuredTextParser.g:4587:3: rule__Case_Selection__CaseAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Case_Selection__CaseAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getCase_SelectionAccess().getCaseAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__0__Impl"

	// $ANTLR start "rule__Case_Selection__Group__1"
	// InternalStructuredTextParser.g:4595:1: rule__Case_Selection__Group__1 :
	// rule__Case_Selection__Group__1__Impl rule__Case_Selection__Group__2 ;
	public final void rule__Case_Selection__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4599:1: ( rule__Case_Selection__Group__1__Impl
			// rule__Case_Selection__Group__2 )
			// InternalStructuredTextParser.g:4600:2: rule__Case_Selection__Group__1__Impl
			// rule__Case_Selection__Group__2
			{
				pushFollow(FOLLOW_28);
				rule__Case_Selection__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__1"

	// $ANTLR start "rule__Case_Selection__Group__1__Impl"
	// InternalStructuredTextParser.g:4607:1: rule__Case_Selection__Group__1__Impl :
	// ( ( rule__Case_Selection__Group_1__0 )* ) ;
	public final void rule__Case_Selection__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4611:1: ( ( ( rule__Case_Selection__Group_1__0
			// )* ) )
			// InternalStructuredTextParser.g:4612:1: ( ( rule__Case_Selection__Group_1__0
			// )* )
			{
				// InternalStructuredTextParser.g:4612:1: ( ( rule__Case_Selection__Group_1__0
				// )* )
				// InternalStructuredTextParser.g:4613:2: ( rule__Case_Selection__Group_1__0 )*
				{
					before(grammarAccess.getCase_SelectionAccess().getGroup_1());
					// InternalStructuredTextParser.g:4614:2: ( rule__Case_Selection__Group_1__0 )*
					loop46: do {
						int alt46 = 2;
						int LA46_0 = input.LA(1);

						if ((LA46_0 == Comma)) {
							alt46 = 1;
						}

						switch (alt46) {
						case 1:
						// InternalStructuredTextParser.g:4614:3: rule__Case_Selection__Group_1__0
						{
							pushFollow(FOLLOW_29);
							rule__Case_Selection__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop46;
						}
					} while (true);

					after(grammarAccess.getCase_SelectionAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__1__Impl"

	// $ANTLR start "rule__Case_Selection__Group__2"
	// InternalStructuredTextParser.g:4622:1: rule__Case_Selection__Group__2 :
	// rule__Case_Selection__Group__2__Impl rule__Case_Selection__Group__3 ;
	public final void rule__Case_Selection__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4626:1: ( rule__Case_Selection__Group__2__Impl
			// rule__Case_Selection__Group__3 )
			// InternalStructuredTextParser.g:4627:2: rule__Case_Selection__Group__2__Impl
			// rule__Case_Selection__Group__3
			{
				pushFollow(FOLLOW_3);
				rule__Case_Selection__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__2"

	// $ANTLR start "rule__Case_Selection__Group__2__Impl"
	// InternalStructuredTextParser.g:4634:1: rule__Case_Selection__Group__2__Impl :
	// ( Colon ) ;
	public final void rule__Case_Selection__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4638:1: ( ( Colon ) )
			// InternalStructuredTextParser.g:4639:1: ( Colon )
			{
				// InternalStructuredTextParser.g:4639:1: ( Colon )
				// InternalStructuredTextParser.g:4640:2: Colon
				{
					before(grammarAccess.getCase_SelectionAccess().getColonKeyword_2());
					match(input, Colon, FOLLOW_2);
					after(grammarAccess.getCase_SelectionAccess().getColonKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__2__Impl"

	// $ANTLR start "rule__Case_Selection__Group__3"
	// InternalStructuredTextParser.g:4649:1: rule__Case_Selection__Group__3 :
	// rule__Case_Selection__Group__3__Impl ;
	public final void rule__Case_Selection__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4653:1: ( rule__Case_Selection__Group__3__Impl
			// )
			// InternalStructuredTextParser.g:4654:2: rule__Case_Selection__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__3"

	// $ANTLR start "rule__Case_Selection__Group__3__Impl"
	// InternalStructuredTextParser.g:4660:1: rule__Case_Selection__Group__3__Impl :
	// ( ( rule__Case_Selection__StatementsAssignment_3 ) ) ;
	public final void rule__Case_Selection__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4664:1: ( ( (
			// rule__Case_Selection__StatementsAssignment_3 ) ) )
			// InternalStructuredTextParser.g:4665:1: ( (
			// rule__Case_Selection__StatementsAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:4665:1: ( (
				// rule__Case_Selection__StatementsAssignment_3 ) )
				// InternalStructuredTextParser.g:4666:2: (
				// rule__Case_Selection__StatementsAssignment_3 )
				{
					before(grammarAccess.getCase_SelectionAccess().getStatementsAssignment_3());
					// InternalStructuredTextParser.g:4667:2: (
					// rule__Case_Selection__StatementsAssignment_3 )
					// InternalStructuredTextParser.g:4667:3:
					// rule__Case_Selection__StatementsAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__Case_Selection__StatementsAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getCase_SelectionAccess().getStatementsAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group__3__Impl"

	// $ANTLR start "rule__Case_Selection__Group_1__0"
	// InternalStructuredTextParser.g:4676:1: rule__Case_Selection__Group_1__0 :
	// rule__Case_Selection__Group_1__0__Impl rule__Case_Selection__Group_1__1 ;
	public final void rule__Case_Selection__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4680:1: (
			// rule__Case_Selection__Group_1__0__Impl rule__Case_Selection__Group_1__1 )
			// InternalStructuredTextParser.g:4681:2: rule__Case_Selection__Group_1__0__Impl
			// rule__Case_Selection__Group_1__1
			{
				pushFollow(FOLLOW_13);
				rule__Case_Selection__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group_1__0"

	// $ANTLR start "rule__Case_Selection__Group_1__0__Impl"
	// InternalStructuredTextParser.g:4688:1: rule__Case_Selection__Group_1__0__Impl
	// : ( Comma ) ;
	public final void rule__Case_Selection__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4692:1: ( ( Comma ) )
			// InternalStructuredTextParser.g:4693:1: ( Comma )
			{
				// InternalStructuredTextParser.g:4693:1: ( Comma )
				// InternalStructuredTextParser.g:4694:2: Comma
				{
					before(grammarAccess.getCase_SelectionAccess().getCommaKeyword_1_0());
					match(input, Comma, FOLLOW_2);
					after(grammarAccess.getCase_SelectionAccess().getCommaKeyword_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group_1__0__Impl"

	// $ANTLR start "rule__Case_Selection__Group_1__1"
	// InternalStructuredTextParser.g:4703:1: rule__Case_Selection__Group_1__1 :
	// rule__Case_Selection__Group_1__1__Impl ;
	public final void rule__Case_Selection__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4707:1: (
			// rule__Case_Selection__Group_1__1__Impl )
			// InternalStructuredTextParser.g:4708:2: rule__Case_Selection__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Case_Selection__Group_1__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group_1__1"

	// $ANTLR start "rule__Case_Selection__Group_1__1__Impl"
	// InternalStructuredTextParser.g:4714:1: rule__Case_Selection__Group_1__1__Impl
	// : ( ( rule__Case_Selection__CaseAssignment_1_1 ) ) ;
	public final void rule__Case_Selection__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4718:1: ( ( (
			// rule__Case_Selection__CaseAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:4719:1: ( (
			// rule__Case_Selection__CaseAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:4719:1: ( (
				// rule__Case_Selection__CaseAssignment_1_1 ) )
				// InternalStructuredTextParser.g:4720:2: (
				// rule__Case_Selection__CaseAssignment_1_1 )
				{
					before(grammarAccess.getCase_SelectionAccess().getCaseAssignment_1_1());
					// InternalStructuredTextParser.g:4721:2: (
					// rule__Case_Selection__CaseAssignment_1_1 )
					// InternalStructuredTextParser.g:4721:3:
					// rule__Case_Selection__CaseAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Case_Selection__CaseAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getCase_SelectionAccess().getCaseAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__Group_1__1__Impl"

	// $ANTLR start "rule__Iteration_Stmt__Group_3__0"
	// InternalStructuredTextParser.g:4730:1: rule__Iteration_Stmt__Group_3__0 :
	// rule__Iteration_Stmt__Group_3__0__Impl rule__Iteration_Stmt__Group_3__1 ;
	public final void rule__Iteration_Stmt__Group_3__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4734:1: (
			// rule__Iteration_Stmt__Group_3__0__Impl rule__Iteration_Stmt__Group_3__1 )
			// InternalStructuredTextParser.g:4735:2: rule__Iteration_Stmt__Group_3__0__Impl
			// rule__Iteration_Stmt__Group_3__1
			{
				pushFollow(FOLLOW_30);
				rule__Iteration_Stmt__Group_3__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Iteration_Stmt__Group_3__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_3__0"

	// $ANTLR start "rule__Iteration_Stmt__Group_3__0__Impl"
	// InternalStructuredTextParser.g:4742:1: rule__Iteration_Stmt__Group_3__0__Impl
	// : ( () ) ;
	public final void rule__Iteration_Stmt__Group_3__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4746:1: ( ( () ) )
			// InternalStructuredTextParser.g:4747:1: ( () )
			{
				// InternalStructuredTextParser.g:4747:1: ( () )
				// InternalStructuredTextParser.g:4748:2: ()
				{
					before(grammarAccess.getIteration_StmtAccess().getExitStatementAction_3_0());
					// InternalStructuredTextParser.g:4749:2: ()
					// InternalStructuredTextParser.g:4749:3:
					{
					}

					after(grammarAccess.getIteration_StmtAccess().getExitStatementAction_3_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_3__0__Impl"

	// $ANTLR start "rule__Iteration_Stmt__Group_3__1"
	// InternalStructuredTextParser.g:4757:1: rule__Iteration_Stmt__Group_3__1 :
	// rule__Iteration_Stmt__Group_3__1__Impl ;
	public final void rule__Iteration_Stmt__Group_3__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4761:1: (
			// rule__Iteration_Stmt__Group_3__1__Impl )
			// InternalStructuredTextParser.g:4762:2: rule__Iteration_Stmt__Group_3__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Iteration_Stmt__Group_3__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_3__1"

	// $ANTLR start "rule__Iteration_Stmt__Group_3__1__Impl"
	// InternalStructuredTextParser.g:4768:1: rule__Iteration_Stmt__Group_3__1__Impl
	// : ( EXIT ) ;
	public final void rule__Iteration_Stmt__Group_3__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4772:1: ( ( EXIT ) )
			// InternalStructuredTextParser.g:4773:1: ( EXIT )
			{
				// InternalStructuredTextParser.g:4773:1: ( EXIT )
				// InternalStructuredTextParser.g:4774:2: EXIT
				{
					before(grammarAccess.getIteration_StmtAccess().getEXITKeyword_3_1());
					match(input, EXIT, FOLLOW_2);
					after(grammarAccess.getIteration_StmtAccess().getEXITKeyword_3_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_3__1__Impl"

	// $ANTLR start "rule__Iteration_Stmt__Group_4__0"
	// InternalStructuredTextParser.g:4784:1: rule__Iteration_Stmt__Group_4__0 :
	// rule__Iteration_Stmt__Group_4__0__Impl rule__Iteration_Stmt__Group_4__1 ;
	public final void rule__Iteration_Stmt__Group_4__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4788:1: (
			// rule__Iteration_Stmt__Group_4__0__Impl rule__Iteration_Stmt__Group_4__1 )
			// InternalStructuredTextParser.g:4789:2: rule__Iteration_Stmt__Group_4__0__Impl
			// rule__Iteration_Stmt__Group_4__1
			{
				pushFollow(FOLLOW_31);
				rule__Iteration_Stmt__Group_4__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Iteration_Stmt__Group_4__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_4__0"

	// $ANTLR start "rule__Iteration_Stmt__Group_4__0__Impl"
	// InternalStructuredTextParser.g:4796:1: rule__Iteration_Stmt__Group_4__0__Impl
	// : ( () ) ;
	public final void rule__Iteration_Stmt__Group_4__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4800:1: ( ( () ) )
			// InternalStructuredTextParser.g:4801:1: ( () )
			{
				// InternalStructuredTextParser.g:4801:1: ( () )
				// InternalStructuredTextParser.g:4802:2: ()
				{
					before(grammarAccess.getIteration_StmtAccess().getContinueStatementAction_4_0());
					// InternalStructuredTextParser.g:4803:2: ()
					// InternalStructuredTextParser.g:4803:3:
					{
					}

					after(grammarAccess.getIteration_StmtAccess().getContinueStatementAction_4_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_4__0__Impl"

	// $ANTLR start "rule__Iteration_Stmt__Group_4__1"
	// InternalStructuredTextParser.g:4811:1: rule__Iteration_Stmt__Group_4__1 :
	// rule__Iteration_Stmt__Group_4__1__Impl ;
	public final void rule__Iteration_Stmt__Group_4__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4815:1: (
			// rule__Iteration_Stmt__Group_4__1__Impl )
			// InternalStructuredTextParser.g:4816:2: rule__Iteration_Stmt__Group_4__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Iteration_Stmt__Group_4__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_4__1"

	// $ANTLR start "rule__Iteration_Stmt__Group_4__1__Impl"
	// InternalStructuredTextParser.g:4822:1: rule__Iteration_Stmt__Group_4__1__Impl
	// : ( CONTINUE ) ;
	public final void rule__Iteration_Stmt__Group_4__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4826:1: ( ( CONTINUE ) )
			// InternalStructuredTextParser.g:4827:1: ( CONTINUE )
			{
				// InternalStructuredTextParser.g:4827:1: ( CONTINUE )
				// InternalStructuredTextParser.g:4828:2: CONTINUE
				{
					before(grammarAccess.getIteration_StmtAccess().getCONTINUEKeyword_4_1());
					match(input, CONTINUE, FOLLOW_2);
					after(grammarAccess.getIteration_StmtAccess().getCONTINUEKeyword_4_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Iteration_Stmt__Group_4__1__Impl"

	// $ANTLR start "rule__For_Stmt__Group__0"
	// InternalStructuredTextParser.g:4838:1: rule__For_Stmt__Group__0 :
	// rule__For_Stmt__Group__0__Impl rule__For_Stmt__Group__1 ;
	public final void rule__For_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4842:1: ( rule__For_Stmt__Group__0__Impl
			// rule__For_Stmt__Group__1 )
			// InternalStructuredTextParser.g:4843:2: rule__For_Stmt__Group__0__Impl
			// rule__For_Stmt__Group__1
			{
				pushFollow(FOLLOW_32);
				rule__For_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__0"

	// $ANTLR start "rule__For_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:4850:1: rule__For_Stmt__Group__0__Impl : ( FOR
	// ) ;
	public final void rule__For_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4854:1: ( ( FOR ) )
			// InternalStructuredTextParser.g:4855:1: ( FOR )
			{
				// InternalStructuredTextParser.g:4855:1: ( FOR )
				// InternalStructuredTextParser.g:4856:2: FOR
				{
					before(grammarAccess.getFor_StmtAccess().getFORKeyword_0());
					match(input, FOR, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getFORKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__0__Impl"

	// $ANTLR start "rule__For_Stmt__Group__1"
	// InternalStructuredTextParser.g:4865:1: rule__For_Stmt__Group__1 :
	// rule__For_Stmt__Group__1__Impl rule__For_Stmt__Group__2 ;
	public final void rule__For_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4869:1: ( rule__For_Stmt__Group__1__Impl
			// rule__For_Stmt__Group__2 )
			// InternalStructuredTextParser.g:4870:2: rule__For_Stmt__Group__1__Impl
			// rule__For_Stmt__Group__2
			{
				pushFollow(FOLLOW_16);
				rule__For_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__1"

	// $ANTLR start "rule__For_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:4877:1: rule__For_Stmt__Group__1__Impl : ( (
	// rule__For_Stmt__VariableAssignment_1 ) ) ;
	public final void rule__For_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4881:1: ( ( (
			// rule__For_Stmt__VariableAssignment_1 ) ) )
			// InternalStructuredTextParser.g:4882:1: ( (
			// rule__For_Stmt__VariableAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:4882:1: ( (
				// rule__For_Stmt__VariableAssignment_1 ) )
				// InternalStructuredTextParser.g:4883:2: ( rule__For_Stmt__VariableAssignment_1
				// )
				{
					before(grammarAccess.getFor_StmtAccess().getVariableAssignment_1());
					// InternalStructuredTextParser.g:4884:2: ( rule__For_Stmt__VariableAssignment_1
					// )
					// InternalStructuredTextParser.g:4884:3: rule__For_Stmt__VariableAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__VariableAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getVariableAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__1__Impl"

	// $ANTLR start "rule__For_Stmt__Group__2"
	// InternalStructuredTextParser.g:4892:1: rule__For_Stmt__Group__2 :
	// rule__For_Stmt__Group__2__Impl rule__For_Stmt__Group__3 ;
	public final void rule__For_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4896:1: ( rule__For_Stmt__Group__2__Impl
			// rule__For_Stmt__Group__3 )
			// InternalStructuredTextParser.g:4897:2: rule__For_Stmt__Group__2__Impl
			// rule__For_Stmt__Group__3
			{
				pushFollow(FOLLOW_17);
				rule__For_Stmt__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__2"

	// $ANTLR start "rule__For_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:4904:1: rule__For_Stmt__Group__2__Impl : (
	// ColonEqualsSign ) ;
	public final void rule__For_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4908:1: ( ( ColonEqualsSign ) )
			// InternalStructuredTextParser.g:4909:1: ( ColonEqualsSign )
			{
				// InternalStructuredTextParser.g:4909:1: ( ColonEqualsSign )
				// InternalStructuredTextParser.g:4910:2: ColonEqualsSign
				{
					before(grammarAccess.getFor_StmtAccess().getColonEqualsSignKeyword_2());
					match(input, ColonEqualsSign, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getColonEqualsSignKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__2__Impl"

	// $ANTLR start "rule__For_Stmt__Group__3"
	// InternalStructuredTextParser.g:4919:1: rule__For_Stmt__Group__3 :
	// rule__For_Stmt__Group__3__Impl rule__For_Stmt__Group__4 ;
	public final void rule__For_Stmt__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4923:1: ( rule__For_Stmt__Group__3__Impl
			// rule__For_Stmt__Group__4 )
			// InternalStructuredTextParser.g:4924:2: rule__For_Stmt__Group__3__Impl
			// rule__For_Stmt__Group__4
			{
				pushFollow(FOLLOW_33);
				rule__For_Stmt__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__3"

	// $ANTLR start "rule__For_Stmt__Group__3__Impl"
	// InternalStructuredTextParser.g:4931:1: rule__For_Stmt__Group__3__Impl : ( (
	// rule__For_Stmt__FromAssignment_3 ) ) ;
	public final void rule__For_Stmt__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4935:1: ( ( ( rule__For_Stmt__FromAssignment_3
			// ) ) )
			// InternalStructuredTextParser.g:4936:1: ( ( rule__For_Stmt__FromAssignment_3 )
			// )
			{
				// InternalStructuredTextParser.g:4936:1: ( ( rule__For_Stmt__FromAssignment_3 )
				// )
				// InternalStructuredTextParser.g:4937:2: ( rule__For_Stmt__FromAssignment_3 )
				{
					before(grammarAccess.getFor_StmtAccess().getFromAssignment_3());
					// InternalStructuredTextParser.g:4938:2: ( rule__For_Stmt__FromAssignment_3 )
					// InternalStructuredTextParser.g:4938:3: rule__For_Stmt__FromAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__FromAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getFromAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__3__Impl"

	// $ANTLR start "rule__For_Stmt__Group__4"
	// InternalStructuredTextParser.g:4946:1: rule__For_Stmt__Group__4 :
	// rule__For_Stmt__Group__4__Impl rule__For_Stmt__Group__5 ;
	public final void rule__For_Stmt__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4950:1: ( rule__For_Stmt__Group__4__Impl
			// rule__For_Stmt__Group__5 )
			// InternalStructuredTextParser.g:4951:2: rule__For_Stmt__Group__4__Impl
			// rule__For_Stmt__Group__5
			{
				pushFollow(FOLLOW_17);
				rule__For_Stmt__Group__4__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__5();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__4"

	// $ANTLR start "rule__For_Stmt__Group__4__Impl"
	// InternalStructuredTextParser.g:4958:1: rule__For_Stmt__Group__4__Impl : ( TO
	// ) ;
	public final void rule__For_Stmt__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4962:1: ( ( TO ) )
			// InternalStructuredTextParser.g:4963:1: ( TO )
			{
				// InternalStructuredTextParser.g:4963:1: ( TO )
				// InternalStructuredTextParser.g:4964:2: TO
				{
					before(grammarAccess.getFor_StmtAccess().getTOKeyword_4());
					match(input, TO, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getTOKeyword_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__4__Impl"

	// $ANTLR start "rule__For_Stmt__Group__5"
	// InternalStructuredTextParser.g:4973:1: rule__For_Stmt__Group__5 :
	// rule__For_Stmt__Group__5__Impl rule__For_Stmt__Group__6 ;
	public final void rule__For_Stmt__Group__5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4977:1: ( rule__For_Stmt__Group__5__Impl
			// rule__For_Stmt__Group__6 )
			// InternalStructuredTextParser.g:4978:2: rule__For_Stmt__Group__5__Impl
			// rule__For_Stmt__Group__6
			{
				pushFollow(FOLLOW_34);
				rule__For_Stmt__Group__5__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__6();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__5"

	// $ANTLR start "rule__For_Stmt__Group__5__Impl"
	// InternalStructuredTextParser.g:4985:1: rule__For_Stmt__Group__5__Impl : ( (
	// rule__For_Stmt__ToAssignment_5 ) ) ;
	public final void rule__For_Stmt__Group__5__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:4989:1: ( ( ( rule__For_Stmt__ToAssignment_5 )
			// ) )
			// InternalStructuredTextParser.g:4990:1: ( ( rule__For_Stmt__ToAssignment_5 ) )
			{
				// InternalStructuredTextParser.g:4990:1: ( ( rule__For_Stmt__ToAssignment_5 ) )
				// InternalStructuredTextParser.g:4991:2: ( rule__For_Stmt__ToAssignment_5 )
				{
					before(grammarAccess.getFor_StmtAccess().getToAssignment_5());
					// InternalStructuredTextParser.g:4992:2: ( rule__For_Stmt__ToAssignment_5 )
					// InternalStructuredTextParser.g:4992:3: rule__For_Stmt__ToAssignment_5
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__ToAssignment_5();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getToAssignment_5());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__5__Impl"

	// $ANTLR start "rule__For_Stmt__Group__6"
	// InternalStructuredTextParser.g:5000:1: rule__For_Stmt__Group__6 :
	// rule__For_Stmt__Group__6__Impl rule__For_Stmt__Group__7 ;
	public final void rule__For_Stmt__Group__6() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5004:1: ( rule__For_Stmt__Group__6__Impl
			// rule__For_Stmt__Group__7 )
			// InternalStructuredTextParser.g:5005:2: rule__For_Stmt__Group__6__Impl
			// rule__For_Stmt__Group__7
			{
				pushFollow(FOLLOW_34);
				rule__For_Stmt__Group__6__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__7();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__6"

	// $ANTLR start "rule__For_Stmt__Group__6__Impl"
	// InternalStructuredTextParser.g:5012:1: rule__For_Stmt__Group__6__Impl : ( (
	// rule__For_Stmt__Group_6__0 )? ) ;
	public final void rule__For_Stmt__Group__6__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5016:1: ( ( ( rule__For_Stmt__Group_6__0 )? )
			// )
			// InternalStructuredTextParser.g:5017:1: ( ( rule__For_Stmt__Group_6__0 )? )
			{
				// InternalStructuredTextParser.g:5017:1: ( ( rule__For_Stmt__Group_6__0 )? )
				// InternalStructuredTextParser.g:5018:2: ( rule__For_Stmt__Group_6__0 )?
				{
					before(grammarAccess.getFor_StmtAccess().getGroup_6());
					// InternalStructuredTextParser.g:5019:2: ( rule__For_Stmt__Group_6__0 )?
					int alt47 = 2;
					int LA47_0 = input.LA(1);

					if ((LA47_0 == BY)) {
						alt47 = 1;
					}
					switch (alt47) {
					case 1:
					// InternalStructuredTextParser.g:5019:3: rule__For_Stmt__Group_6__0
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__Group_6__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getFor_StmtAccess().getGroup_6());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__6__Impl"

	// $ANTLR start "rule__For_Stmt__Group__7"
	// InternalStructuredTextParser.g:5027:1: rule__For_Stmt__Group__7 :
	// rule__For_Stmt__Group__7__Impl rule__For_Stmt__Group__8 ;
	public final void rule__For_Stmt__Group__7() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5031:1: ( rule__For_Stmt__Group__7__Impl
			// rule__For_Stmt__Group__8 )
			// InternalStructuredTextParser.g:5032:2: rule__For_Stmt__Group__7__Impl
			// rule__For_Stmt__Group__8
			{
				pushFollow(FOLLOW_3);
				rule__For_Stmt__Group__7__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__8();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__7"

	// $ANTLR start "rule__For_Stmt__Group__7__Impl"
	// InternalStructuredTextParser.g:5039:1: rule__For_Stmt__Group__7__Impl : ( DO
	// ) ;
	public final void rule__For_Stmt__Group__7__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5043:1: ( ( DO ) )
			// InternalStructuredTextParser.g:5044:1: ( DO )
			{
				// InternalStructuredTextParser.g:5044:1: ( DO )
				// InternalStructuredTextParser.g:5045:2: DO
				{
					before(grammarAccess.getFor_StmtAccess().getDOKeyword_7());
					match(input, DO, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getDOKeyword_7());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__7__Impl"

	// $ANTLR start "rule__For_Stmt__Group__8"
	// InternalStructuredTextParser.g:5054:1: rule__For_Stmt__Group__8 :
	// rule__For_Stmt__Group__8__Impl rule__For_Stmt__Group__9 ;
	public final void rule__For_Stmt__Group__8() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5058:1: ( rule__For_Stmt__Group__8__Impl
			// rule__For_Stmt__Group__9 )
			// InternalStructuredTextParser.g:5059:2: rule__For_Stmt__Group__8__Impl
			// rule__For_Stmt__Group__9
			{
				pushFollow(FOLLOW_35);
				rule__For_Stmt__Group__8__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__9();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__8"

	// $ANTLR start "rule__For_Stmt__Group__8__Impl"
	// InternalStructuredTextParser.g:5066:1: rule__For_Stmt__Group__8__Impl : ( (
	// rule__For_Stmt__StatementsAssignment_8 ) ) ;
	public final void rule__For_Stmt__Group__8__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5070:1: ( ( (
			// rule__For_Stmt__StatementsAssignment_8 ) ) )
			// InternalStructuredTextParser.g:5071:1: ( (
			// rule__For_Stmt__StatementsAssignment_8 ) )
			{
				// InternalStructuredTextParser.g:5071:1: ( (
				// rule__For_Stmt__StatementsAssignment_8 ) )
				// InternalStructuredTextParser.g:5072:2: (
				// rule__For_Stmt__StatementsAssignment_8 )
				{
					before(grammarAccess.getFor_StmtAccess().getStatementsAssignment_8());
					// InternalStructuredTextParser.g:5073:2: (
					// rule__For_Stmt__StatementsAssignment_8 )
					// InternalStructuredTextParser.g:5073:3: rule__For_Stmt__StatementsAssignment_8
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__StatementsAssignment_8();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getStatementsAssignment_8());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__8__Impl"

	// $ANTLR start "rule__For_Stmt__Group__9"
	// InternalStructuredTextParser.g:5081:1: rule__For_Stmt__Group__9 :
	// rule__For_Stmt__Group__9__Impl ;
	public final void rule__For_Stmt__Group__9() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5085:1: ( rule__For_Stmt__Group__9__Impl )
			// InternalStructuredTextParser.g:5086:2: rule__For_Stmt__Group__9__Impl
			{
				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group__9__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__9"

	// $ANTLR start "rule__For_Stmt__Group__9__Impl"
	// InternalStructuredTextParser.g:5092:1: rule__For_Stmt__Group__9__Impl : (
	// END_FOR ) ;
	public final void rule__For_Stmt__Group__9__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5096:1: ( ( END_FOR ) )
			// InternalStructuredTextParser.g:5097:1: ( END_FOR )
			{
				// InternalStructuredTextParser.g:5097:1: ( END_FOR )
				// InternalStructuredTextParser.g:5098:2: END_FOR
				{
					before(grammarAccess.getFor_StmtAccess().getEND_FORKeyword_9());
					match(input, END_FOR, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getEND_FORKeyword_9());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group__9__Impl"

	// $ANTLR start "rule__For_Stmt__Group_6__0"
	// InternalStructuredTextParser.g:5108:1: rule__For_Stmt__Group_6__0 :
	// rule__For_Stmt__Group_6__0__Impl rule__For_Stmt__Group_6__1 ;
	public final void rule__For_Stmt__Group_6__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5112:1: ( rule__For_Stmt__Group_6__0__Impl
			// rule__For_Stmt__Group_6__1 )
			// InternalStructuredTextParser.g:5113:2: rule__For_Stmt__Group_6__0__Impl
			// rule__For_Stmt__Group_6__1
			{
				pushFollow(FOLLOW_17);
				rule__For_Stmt__Group_6__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group_6__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group_6__0"

	// $ANTLR start "rule__For_Stmt__Group_6__0__Impl"
	// InternalStructuredTextParser.g:5120:1: rule__For_Stmt__Group_6__0__Impl : (
	// BY ) ;
	public final void rule__For_Stmt__Group_6__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5124:1: ( ( BY ) )
			// InternalStructuredTextParser.g:5125:1: ( BY )
			{
				// InternalStructuredTextParser.g:5125:1: ( BY )
				// InternalStructuredTextParser.g:5126:2: BY
				{
					before(grammarAccess.getFor_StmtAccess().getBYKeyword_6_0());
					match(input, BY, FOLLOW_2);
					after(grammarAccess.getFor_StmtAccess().getBYKeyword_6_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group_6__0__Impl"

	// $ANTLR start "rule__For_Stmt__Group_6__1"
	// InternalStructuredTextParser.g:5135:1: rule__For_Stmt__Group_6__1 :
	// rule__For_Stmt__Group_6__1__Impl ;
	public final void rule__For_Stmt__Group_6__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5139:1: ( rule__For_Stmt__Group_6__1__Impl )
			// InternalStructuredTextParser.g:5140:2: rule__For_Stmt__Group_6__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__For_Stmt__Group_6__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group_6__1"

	// $ANTLR start "rule__For_Stmt__Group_6__1__Impl"
	// InternalStructuredTextParser.g:5146:1: rule__For_Stmt__Group_6__1__Impl : ( (
	// rule__For_Stmt__ByAssignment_6_1 ) ) ;
	public final void rule__For_Stmt__Group_6__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5150:1: ( ( ( rule__For_Stmt__ByAssignment_6_1
			// ) ) )
			// InternalStructuredTextParser.g:5151:1: ( ( rule__For_Stmt__ByAssignment_6_1 )
			// )
			{
				// InternalStructuredTextParser.g:5151:1: ( ( rule__For_Stmt__ByAssignment_6_1 )
				// )
				// InternalStructuredTextParser.g:5152:2: ( rule__For_Stmt__ByAssignment_6_1 )
				{
					before(grammarAccess.getFor_StmtAccess().getByAssignment_6_1());
					// InternalStructuredTextParser.g:5153:2: ( rule__For_Stmt__ByAssignment_6_1 )
					// InternalStructuredTextParser.g:5153:3: rule__For_Stmt__ByAssignment_6_1
					{
						pushFollow(FOLLOW_2);
						rule__For_Stmt__ByAssignment_6_1();

						state._fsp--;

					}

					after(grammarAccess.getFor_StmtAccess().getByAssignment_6_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__Group_6__1__Impl"

	// $ANTLR start "rule__While_Stmt__Group__0"
	// InternalStructuredTextParser.g:5162:1: rule__While_Stmt__Group__0 :
	// rule__While_Stmt__Group__0__Impl rule__While_Stmt__Group__1 ;
	public final void rule__While_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5166:1: ( rule__While_Stmt__Group__0__Impl
			// rule__While_Stmt__Group__1 )
			// InternalStructuredTextParser.g:5167:2: rule__While_Stmt__Group__0__Impl
			// rule__While_Stmt__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__While_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__While_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__0"

	// $ANTLR start "rule__While_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:5174:1: rule__While_Stmt__Group__0__Impl : (
	// WHILE ) ;
	public final void rule__While_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5178:1: ( ( WHILE ) )
			// InternalStructuredTextParser.g:5179:1: ( WHILE )
			{
				// InternalStructuredTextParser.g:5179:1: ( WHILE )
				// InternalStructuredTextParser.g:5180:2: WHILE
				{
					before(grammarAccess.getWhile_StmtAccess().getWHILEKeyword_0());
					match(input, WHILE, FOLLOW_2);
					after(grammarAccess.getWhile_StmtAccess().getWHILEKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__0__Impl"

	// $ANTLR start "rule__While_Stmt__Group__1"
	// InternalStructuredTextParser.g:5189:1: rule__While_Stmt__Group__1 :
	// rule__While_Stmt__Group__1__Impl rule__While_Stmt__Group__2 ;
	public final void rule__While_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5193:1: ( rule__While_Stmt__Group__1__Impl
			// rule__While_Stmt__Group__2 )
			// InternalStructuredTextParser.g:5194:2: rule__While_Stmt__Group__1__Impl
			// rule__While_Stmt__Group__2
			{
				pushFollow(FOLLOW_36);
				rule__While_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__While_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__1"

	// $ANTLR start "rule__While_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:5201:1: rule__While_Stmt__Group__1__Impl : ( (
	// rule__While_Stmt__ExpressionAssignment_1 ) ) ;
	public final void rule__While_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5205:1: ( ( (
			// rule__While_Stmt__ExpressionAssignment_1 ) ) )
			// InternalStructuredTextParser.g:5206:1: ( (
			// rule__While_Stmt__ExpressionAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:5206:1: ( (
				// rule__While_Stmt__ExpressionAssignment_1 ) )
				// InternalStructuredTextParser.g:5207:2: (
				// rule__While_Stmt__ExpressionAssignment_1 )
				{
					before(grammarAccess.getWhile_StmtAccess().getExpressionAssignment_1());
					// InternalStructuredTextParser.g:5208:2: (
					// rule__While_Stmt__ExpressionAssignment_1 )
					// InternalStructuredTextParser.g:5208:3:
					// rule__While_Stmt__ExpressionAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__While_Stmt__ExpressionAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getWhile_StmtAccess().getExpressionAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__1__Impl"

	// $ANTLR start "rule__While_Stmt__Group__2"
	// InternalStructuredTextParser.g:5216:1: rule__While_Stmt__Group__2 :
	// rule__While_Stmt__Group__2__Impl rule__While_Stmt__Group__3 ;
	public final void rule__While_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5220:1: ( rule__While_Stmt__Group__2__Impl
			// rule__While_Stmt__Group__3 )
			// InternalStructuredTextParser.g:5221:2: rule__While_Stmt__Group__2__Impl
			// rule__While_Stmt__Group__3
			{
				pushFollow(FOLLOW_3);
				rule__While_Stmt__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__While_Stmt__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__2"

	// $ANTLR start "rule__While_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:5228:1: rule__While_Stmt__Group__2__Impl : (
	// DO ) ;
	public final void rule__While_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5232:1: ( ( DO ) )
			// InternalStructuredTextParser.g:5233:1: ( DO )
			{
				// InternalStructuredTextParser.g:5233:1: ( DO )
				// InternalStructuredTextParser.g:5234:2: DO
				{
					before(grammarAccess.getWhile_StmtAccess().getDOKeyword_2());
					match(input, DO, FOLLOW_2);
					after(grammarAccess.getWhile_StmtAccess().getDOKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__2__Impl"

	// $ANTLR start "rule__While_Stmt__Group__3"
	// InternalStructuredTextParser.g:5243:1: rule__While_Stmt__Group__3 :
	// rule__While_Stmt__Group__3__Impl rule__While_Stmt__Group__4 ;
	public final void rule__While_Stmt__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5247:1: ( rule__While_Stmt__Group__3__Impl
			// rule__While_Stmt__Group__4 )
			// InternalStructuredTextParser.g:5248:2: rule__While_Stmt__Group__3__Impl
			// rule__While_Stmt__Group__4
			{
				pushFollow(FOLLOW_37);
				rule__While_Stmt__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__While_Stmt__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__3"

	// $ANTLR start "rule__While_Stmt__Group__3__Impl"
	// InternalStructuredTextParser.g:5255:1: rule__While_Stmt__Group__3__Impl : ( (
	// rule__While_Stmt__StatementsAssignment_3 ) ) ;
	public final void rule__While_Stmt__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5259:1: ( ( (
			// rule__While_Stmt__StatementsAssignment_3 ) ) )
			// InternalStructuredTextParser.g:5260:1: ( (
			// rule__While_Stmt__StatementsAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:5260:1: ( (
				// rule__While_Stmt__StatementsAssignment_3 ) )
				// InternalStructuredTextParser.g:5261:2: (
				// rule__While_Stmt__StatementsAssignment_3 )
				{
					before(grammarAccess.getWhile_StmtAccess().getStatementsAssignment_3());
					// InternalStructuredTextParser.g:5262:2: (
					// rule__While_Stmt__StatementsAssignment_3 )
					// InternalStructuredTextParser.g:5262:3:
					// rule__While_Stmt__StatementsAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__While_Stmt__StatementsAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getWhile_StmtAccess().getStatementsAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__3__Impl"

	// $ANTLR start "rule__While_Stmt__Group__4"
	// InternalStructuredTextParser.g:5270:1: rule__While_Stmt__Group__4 :
	// rule__While_Stmt__Group__4__Impl ;
	public final void rule__While_Stmt__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5274:1: ( rule__While_Stmt__Group__4__Impl )
			// InternalStructuredTextParser.g:5275:2: rule__While_Stmt__Group__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__While_Stmt__Group__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__4"

	// $ANTLR start "rule__While_Stmt__Group__4__Impl"
	// InternalStructuredTextParser.g:5281:1: rule__While_Stmt__Group__4__Impl : (
	// END_WHILE ) ;
	public final void rule__While_Stmt__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5285:1: ( ( END_WHILE ) )
			// InternalStructuredTextParser.g:5286:1: ( END_WHILE )
			{
				// InternalStructuredTextParser.g:5286:1: ( END_WHILE )
				// InternalStructuredTextParser.g:5287:2: END_WHILE
				{
					before(grammarAccess.getWhile_StmtAccess().getEND_WHILEKeyword_4());
					match(input, END_WHILE, FOLLOW_2);
					after(grammarAccess.getWhile_StmtAccess().getEND_WHILEKeyword_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__Group__4__Impl"

	// $ANTLR start "rule__Repeat_Stmt__Group__0"
	// InternalStructuredTextParser.g:5297:1: rule__Repeat_Stmt__Group__0 :
	// rule__Repeat_Stmt__Group__0__Impl rule__Repeat_Stmt__Group__1 ;
	public final void rule__Repeat_Stmt__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5301:1: ( rule__Repeat_Stmt__Group__0__Impl
			// rule__Repeat_Stmt__Group__1 )
			// InternalStructuredTextParser.g:5302:2: rule__Repeat_Stmt__Group__0__Impl
			// rule__Repeat_Stmt__Group__1
			{
				pushFollow(FOLLOW_3);
				rule__Repeat_Stmt__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Repeat_Stmt__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__0"

	// $ANTLR start "rule__Repeat_Stmt__Group__0__Impl"
	// InternalStructuredTextParser.g:5309:1: rule__Repeat_Stmt__Group__0__Impl : (
	// REPEAT ) ;
	public final void rule__Repeat_Stmt__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5313:1: ( ( REPEAT ) )
			// InternalStructuredTextParser.g:5314:1: ( REPEAT )
			{
				// InternalStructuredTextParser.g:5314:1: ( REPEAT )
				// InternalStructuredTextParser.g:5315:2: REPEAT
				{
					before(grammarAccess.getRepeat_StmtAccess().getREPEATKeyword_0());
					match(input, REPEAT, FOLLOW_2);
					after(grammarAccess.getRepeat_StmtAccess().getREPEATKeyword_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__0__Impl"

	// $ANTLR start "rule__Repeat_Stmt__Group__1"
	// InternalStructuredTextParser.g:5324:1: rule__Repeat_Stmt__Group__1 :
	// rule__Repeat_Stmt__Group__1__Impl rule__Repeat_Stmt__Group__2 ;
	public final void rule__Repeat_Stmt__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5328:1: ( rule__Repeat_Stmt__Group__1__Impl
			// rule__Repeat_Stmt__Group__2 )
			// InternalStructuredTextParser.g:5329:2: rule__Repeat_Stmt__Group__1__Impl
			// rule__Repeat_Stmt__Group__2
			{
				pushFollow(FOLLOW_38);
				rule__Repeat_Stmt__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Repeat_Stmt__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__1"

	// $ANTLR start "rule__Repeat_Stmt__Group__1__Impl"
	// InternalStructuredTextParser.g:5336:1: rule__Repeat_Stmt__Group__1__Impl : (
	// ( rule__Repeat_Stmt__StatementsAssignment_1 ) ) ;
	public final void rule__Repeat_Stmt__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5340:1: ( ( (
			// rule__Repeat_Stmt__StatementsAssignment_1 ) ) )
			// InternalStructuredTextParser.g:5341:1: ( (
			// rule__Repeat_Stmt__StatementsAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:5341:1: ( (
				// rule__Repeat_Stmt__StatementsAssignment_1 ) )
				// InternalStructuredTextParser.g:5342:2: (
				// rule__Repeat_Stmt__StatementsAssignment_1 )
				{
					before(grammarAccess.getRepeat_StmtAccess().getStatementsAssignment_1());
					// InternalStructuredTextParser.g:5343:2: (
					// rule__Repeat_Stmt__StatementsAssignment_1 )
					// InternalStructuredTextParser.g:5343:3:
					// rule__Repeat_Stmt__StatementsAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Repeat_Stmt__StatementsAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getRepeat_StmtAccess().getStatementsAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__1__Impl"

	// $ANTLR start "rule__Repeat_Stmt__Group__2"
	// InternalStructuredTextParser.g:5351:1: rule__Repeat_Stmt__Group__2 :
	// rule__Repeat_Stmt__Group__2__Impl rule__Repeat_Stmt__Group__3 ;
	public final void rule__Repeat_Stmt__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5355:1: ( rule__Repeat_Stmt__Group__2__Impl
			// rule__Repeat_Stmt__Group__3 )
			// InternalStructuredTextParser.g:5356:2: rule__Repeat_Stmt__Group__2__Impl
			// rule__Repeat_Stmt__Group__3
			{
				pushFollow(FOLLOW_17);
				rule__Repeat_Stmt__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Repeat_Stmt__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__2"

	// $ANTLR start "rule__Repeat_Stmt__Group__2__Impl"
	// InternalStructuredTextParser.g:5363:1: rule__Repeat_Stmt__Group__2__Impl : (
	// UNTIL ) ;
	public final void rule__Repeat_Stmt__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5367:1: ( ( UNTIL ) )
			// InternalStructuredTextParser.g:5368:1: ( UNTIL )
			{
				// InternalStructuredTextParser.g:5368:1: ( UNTIL )
				// InternalStructuredTextParser.g:5369:2: UNTIL
				{
					before(grammarAccess.getRepeat_StmtAccess().getUNTILKeyword_2());
					match(input, UNTIL, FOLLOW_2);
					after(grammarAccess.getRepeat_StmtAccess().getUNTILKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__2__Impl"

	// $ANTLR start "rule__Repeat_Stmt__Group__3"
	// InternalStructuredTextParser.g:5378:1: rule__Repeat_Stmt__Group__3 :
	// rule__Repeat_Stmt__Group__3__Impl rule__Repeat_Stmt__Group__4 ;
	public final void rule__Repeat_Stmt__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5382:1: ( rule__Repeat_Stmt__Group__3__Impl
			// rule__Repeat_Stmt__Group__4 )
			// InternalStructuredTextParser.g:5383:2: rule__Repeat_Stmt__Group__3__Impl
			// rule__Repeat_Stmt__Group__4
			{
				pushFollow(FOLLOW_39);
				rule__Repeat_Stmt__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Repeat_Stmt__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__3"

	// $ANTLR start "rule__Repeat_Stmt__Group__3__Impl"
	// InternalStructuredTextParser.g:5390:1: rule__Repeat_Stmt__Group__3__Impl : (
	// ( rule__Repeat_Stmt__ExpressionAssignment_3 ) ) ;
	public final void rule__Repeat_Stmt__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5394:1: ( ( (
			// rule__Repeat_Stmt__ExpressionAssignment_3 ) ) )
			// InternalStructuredTextParser.g:5395:1: ( (
			// rule__Repeat_Stmt__ExpressionAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:5395:1: ( (
				// rule__Repeat_Stmt__ExpressionAssignment_3 ) )
				// InternalStructuredTextParser.g:5396:2: (
				// rule__Repeat_Stmt__ExpressionAssignment_3 )
				{
					before(grammarAccess.getRepeat_StmtAccess().getExpressionAssignment_3());
					// InternalStructuredTextParser.g:5397:2: (
					// rule__Repeat_Stmt__ExpressionAssignment_3 )
					// InternalStructuredTextParser.g:5397:3:
					// rule__Repeat_Stmt__ExpressionAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__Repeat_Stmt__ExpressionAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getRepeat_StmtAccess().getExpressionAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__3__Impl"

	// $ANTLR start "rule__Repeat_Stmt__Group__4"
	// InternalStructuredTextParser.g:5405:1: rule__Repeat_Stmt__Group__4 :
	// rule__Repeat_Stmt__Group__4__Impl ;
	public final void rule__Repeat_Stmt__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5409:1: ( rule__Repeat_Stmt__Group__4__Impl )
			// InternalStructuredTextParser.g:5410:2: rule__Repeat_Stmt__Group__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Repeat_Stmt__Group__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__4"

	// $ANTLR start "rule__Repeat_Stmt__Group__4__Impl"
	// InternalStructuredTextParser.g:5416:1: rule__Repeat_Stmt__Group__4__Impl : (
	// END_REPEAT ) ;
	public final void rule__Repeat_Stmt__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5420:1: ( ( END_REPEAT ) )
			// InternalStructuredTextParser.g:5421:1: ( END_REPEAT )
			{
				// InternalStructuredTextParser.g:5421:1: ( END_REPEAT )
				// InternalStructuredTextParser.g:5422:2: END_REPEAT
				{
					before(grammarAccess.getRepeat_StmtAccess().getEND_REPEATKeyword_4());
					match(input, END_REPEAT, FOLLOW_2);
					after(grammarAccess.getRepeat_StmtAccess().getEND_REPEATKeyword_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__Group__4__Impl"

	// $ANTLR start "rule__Or_Expression__Group__0"
	// InternalStructuredTextParser.g:5432:1: rule__Or_Expression__Group__0 :
	// rule__Or_Expression__Group__0__Impl rule__Or_Expression__Group__1 ;
	public final void rule__Or_Expression__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5436:1: ( rule__Or_Expression__Group__0__Impl
			// rule__Or_Expression__Group__1 )
			// InternalStructuredTextParser.g:5437:2: rule__Or_Expression__Group__0__Impl
			// rule__Or_Expression__Group__1
			{
				pushFollow(FOLLOW_40);
				rule__Or_Expression__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Or_Expression__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group__0"

	// $ANTLR start "rule__Or_Expression__Group__0__Impl"
	// InternalStructuredTextParser.g:5444:1: rule__Or_Expression__Group__0__Impl :
	// ( ruleXor_Expr ) ;
	public final void rule__Or_Expression__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5448:1: ( ( ruleXor_Expr ) )
			// InternalStructuredTextParser.g:5449:1: ( ruleXor_Expr )
			{
				// InternalStructuredTextParser.g:5449:1: ( ruleXor_Expr )
				// InternalStructuredTextParser.g:5450:2: ruleXor_Expr
				{
					before(grammarAccess.getOr_ExpressionAccess().getXor_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleXor_Expr();

					state._fsp--;

					after(grammarAccess.getOr_ExpressionAccess().getXor_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group__0__Impl"

	// $ANTLR start "rule__Or_Expression__Group__1"
	// InternalStructuredTextParser.g:5459:1: rule__Or_Expression__Group__1 :
	// rule__Or_Expression__Group__1__Impl ;
	public final void rule__Or_Expression__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5463:1: ( rule__Or_Expression__Group__1__Impl
			// )
			// InternalStructuredTextParser.g:5464:2: rule__Or_Expression__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Or_Expression__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group__1"

	// $ANTLR start "rule__Or_Expression__Group__1__Impl"
	// InternalStructuredTextParser.g:5470:1: rule__Or_Expression__Group__1__Impl :
	// ( ( rule__Or_Expression__Group_1__0 )* ) ;
	public final void rule__Or_Expression__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5474:1: ( ( ( rule__Or_Expression__Group_1__0
			// )* ) )
			// InternalStructuredTextParser.g:5475:1: ( ( rule__Or_Expression__Group_1__0 )*
			// )
			{
				// InternalStructuredTextParser.g:5475:1: ( ( rule__Or_Expression__Group_1__0 )*
				// )
				// InternalStructuredTextParser.g:5476:2: ( rule__Or_Expression__Group_1__0 )*
				{
					before(grammarAccess.getOr_ExpressionAccess().getGroup_1());
					// InternalStructuredTextParser.g:5477:2: ( rule__Or_Expression__Group_1__0 )*
					loop48: do {
						int alt48 = 2;
						int LA48_0 = input.LA(1);

						if ((LA48_0 == OR)) {
							alt48 = 1;
						}

						switch (alt48) {
						case 1:
						// InternalStructuredTextParser.g:5477:3: rule__Or_Expression__Group_1__0
						{
							pushFollow(FOLLOW_41);
							rule__Or_Expression__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop48;
						}
					} while (true);

					after(grammarAccess.getOr_ExpressionAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group__1__Impl"

	// $ANTLR start "rule__Or_Expression__Group_1__0"
	// InternalStructuredTextParser.g:5486:1: rule__Or_Expression__Group_1__0 :
	// rule__Or_Expression__Group_1__0__Impl rule__Or_Expression__Group_1__1 ;
	public final void rule__Or_Expression__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5490:1: (
			// rule__Or_Expression__Group_1__0__Impl rule__Or_Expression__Group_1__1 )
			// InternalStructuredTextParser.g:5491:2: rule__Or_Expression__Group_1__0__Impl
			// rule__Or_Expression__Group_1__1
			{
				pushFollow(FOLLOW_40);
				rule__Or_Expression__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Or_Expression__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__0"

	// $ANTLR start "rule__Or_Expression__Group_1__0__Impl"
	// InternalStructuredTextParser.g:5498:1: rule__Or_Expression__Group_1__0__Impl
	// : ( () ) ;
	public final void rule__Or_Expression__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5502:1: ( ( () ) )
			// InternalStructuredTextParser.g:5503:1: ( () )
			{
				// InternalStructuredTextParser.g:5503:1: ( () )
				// InternalStructuredTextParser.g:5504:2: ()
				{
					before(grammarAccess.getOr_ExpressionAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:5505:2: ()
					// InternalStructuredTextParser.g:5505:3:
					{
					}

					after(grammarAccess.getOr_ExpressionAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__0__Impl"

	// $ANTLR start "rule__Or_Expression__Group_1__1"
	// InternalStructuredTextParser.g:5513:1: rule__Or_Expression__Group_1__1 :
	// rule__Or_Expression__Group_1__1__Impl rule__Or_Expression__Group_1__2 ;
	public final void rule__Or_Expression__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5517:1: (
			// rule__Or_Expression__Group_1__1__Impl rule__Or_Expression__Group_1__2 )
			// InternalStructuredTextParser.g:5518:2: rule__Or_Expression__Group_1__1__Impl
			// rule__Or_Expression__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Or_Expression__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Or_Expression__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__1"

	// $ANTLR start "rule__Or_Expression__Group_1__1__Impl"
	// InternalStructuredTextParser.g:5525:1: rule__Or_Expression__Group_1__1__Impl
	// : ( ( rule__Or_Expression__OperatorAssignment_1_1 ) ) ;
	public final void rule__Or_Expression__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5529:1: ( ( (
			// rule__Or_Expression__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:5530:1: ( (
			// rule__Or_Expression__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:5530:1: ( (
				// rule__Or_Expression__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:5531:2: (
				// rule__Or_Expression__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getOr_ExpressionAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:5532:2: (
					// rule__Or_Expression__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:5532:3:
					// rule__Or_Expression__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Or_Expression__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getOr_ExpressionAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__1__Impl"

	// $ANTLR start "rule__Or_Expression__Group_1__2"
	// InternalStructuredTextParser.g:5540:1: rule__Or_Expression__Group_1__2 :
	// rule__Or_Expression__Group_1__2__Impl ;
	public final void rule__Or_Expression__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5544:1: (
			// rule__Or_Expression__Group_1__2__Impl )
			// InternalStructuredTextParser.g:5545:2: rule__Or_Expression__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Or_Expression__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__2"

	// $ANTLR start "rule__Or_Expression__Group_1__2__Impl"
	// InternalStructuredTextParser.g:5551:1: rule__Or_Expression__Group_1__2__Impl
	// : ( ( rule__Or_Expression__RightAssignment_1_2 ) ) ;
	public final void rule__Or_Expression__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5555:1: ( ( (
			// rule__Or_Expression__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:5556:1: ( (
			// rule__Or_Expression__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:5556:1: ( (
				// rule__Or_Expression__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:5557:2: (
				// rule__Or_Expression__RightAssignment_1_2 )
				{
					before(grammarAccess.getOr_ExpressionAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:5558:2: (
					// rule__Or_Expression__RightAssignment_1_2 )
					// InternalStructuredTextParser.g:5558:3:
					// rule__Or_Expression__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Or_Expression__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getOr_ExpressionAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__Group_1__2__Impl"

	// $ANTLR start "rule__Xor_Expr__Group__0"
	// InternalStructuredTextParser.g:5567:1: rule__Xor_Expr__Group__0 :
	// rule__Xor_Expr__Group__0__Impl rule__Xor_Expr__Group__1 ;
	public final void rule__Xor_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5571:1: ( rule__Xor_Expr__Group__0__Impl
			// rule__Xor_Expr__Group__1 )
			// InternalStructuredTextParser.g:5572:2: rule__Xor_Expr__Group__0__Impl
			// rule__Xor_Expr__Group__1
			{
				pushFollow(FOLLOW_42);
				rule__Xor_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Xor_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group__0"

	// $ANTLR start "rule__Xor_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:5579:1: rule__Xor_Expr__Group__0__Impl : (
	// ruleAnd_Expr ) ;
	public final void rule__Xor_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5583:1: ( ( ruleAnd_Expr ) )
			// InternalStructuredTextParser.g:5584:1: ( ruleAnd_Expr )
			{
				// InternalStructuredTextParser.g:5584:1: ( ruleAnd_Expr )
				// InternalStructuredTextParser.g:5585:2: ruleAnd_Expr
				{
					before(grammarAccess.getXor_ExprAccess().getAnd_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleAnd_Expr();

					state._fsp--;

					after(grammarAccess.getXor_ExprAccess().getAnd_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group__0__Impl"

	// $ANTLR start "rule__Xor_Expr__Group__1"
	// InternalStructuredTextParser.g:5594:1: rule__Xor_Expr__Group__1 :
	// rule__Xor_Expr__Group__1__Impl ;
	public final void rule__Xor_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5598:1: ( rule__Xor_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:5599:2: rule__Xor_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Xor_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group__1"

	// $ANTLR start "rule__Xor_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:5605:1: rule__Xor_Expr__Group__1__Impl : ( (
	// rule__Xor_Expr__Group_1__0 )* ) ;
	public final void rule__Xor_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5609:1: ( ( ( rule__Xor_Expr__Group_1__0 )* )
			// )
			// InternalStructuredTextParser.g:5610:1: ( ( rule__Xor_Expr__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:5610:1: ( ( rule__Xor_Expr__Group_1__0 )* )
				// InternalStructuredTextParser.g:5611:2: ( rule__Xor_Expr__Group_1__0 )*
				{
					before(grammarAccess.getXor_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:5612:2: ( rule__Xor_Expr__Group_1__0 )*
					loop49: do {
						int alt49 = 2;
						int LA49_0 = input.LA(1);

						if ((LA49_0 == XOR)) {
							alt49 = 1;
						}

						switch (alt49) {
						case 1:
						// InternalStructuredTextParser.g:5612:3: rule__Xor_Expr__Group_1__0
						{
							pushFollow(FOLLOW_43);
							rule__Xor_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop49;
						}
					} while (true);

					after(grammarAccess.getXor_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group__1__Impl"

	// $ANTLR start "rule__Xor_Expr__Group_1__0"
	// InternalStructuredTextParser.g:5621:1: rule__Xor_Expr__Group_1__0 :
	// rule__Xor_Expr__Group_1__0__Impl rule__Xor_Expr__Group_1__1 ;
	public final void rule__Xor_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5625:1: ( rule__Xor_Expr__Group_1__0__Impl
			// rule__Xor_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:5626:2: rule__Xor_Expr__Group_1__0__Impl
			// rule__Xor_Expr__Group_1__1
			{
				pushFollow(FOLLOW_42);
				rule__Xor_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Xor_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__0"

	// $ANTLR start "rule__Xor_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:5633:1: rule__Xor_Expr__Group_1__0__Impl : (
	// () ) ;
	public final void rule__Xor_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5637:1: ( ( () ) )
			// InternalStructuredTextParser.g:5638:1: ( () )
			{
				// InternalStructuredTextParser.g:5638:1: ( () )
				// InternalStructuredTextParser.g:5639:2: ()
				{
					before(grammarAccess.getXor_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:5640:2: ()
					// InternalStructuredTextParser.g:5640:3:
					{
					}

					after(grammarAccess.getXor_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__Xor_Expr__Group_1__1"
	// InternalStructuredTextParser.g:5648:1: rule__Xor_Expr__Group_1__1 :
	// rule__Xor_Expr__Group_1__1__Impl rule__Xor_Expr__Group_1__2 ;
	public final void rule__Xor_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5652:1: ( rule__Xor_Expr__Group_1__1__Impl
			// rule__Xor_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:5653:2: rule__Xor_Expr__Group_1__1__Impl
			// rule__Xor_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Xor_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Xor_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__1"

	// $ANTLR start "rule__Xor_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:5660:1: rule__Xor_Expr__Group_1__1__Impl : ( (
	// rule__Xor_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__Xor_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5664:1: ( ( (
			// rule__Xor_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:5665:1: ( (
			// rule__Xor_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:5665:1: ( (
				// rule__Xor_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:5666:2: (
				// rule__Xor_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getXor_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:5667:2: (
					// rule__Xor_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:5667:3: rule__Xor_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Xor_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getXor_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__Xor_Expr__Group_1__2"
	// InternalStructuredTextParser.g:5675:1: rule__Xor_Expr__Group_1__2 :
	// rule__Xor_Expr__Group_1__2__Impl ;
	public final void rule__Xor_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5679:1: ( rule__Xor_Expr__Group_1__2__Impl )
			// InternalStructuredTextParser.g:5680:2: rule__Xor_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Xor_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__2"

	// $ANTLR start "rule__Xor_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:5686:1: rule__Xor_Expr__Group_1__2__Impl : ( (
	// rule__Xor_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__Xor_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5690:1: ( ( (
			// rule__Xor_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:5691:1: ( (
			// rule__Xor_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:5691:1: ( (
				// rule__Xor_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:5692:2: ( rule__Xor_Expr__RightAssignment_1_2
				// )
				{
					before(grammarAccess.getXor_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:5693:2: ( rule__Xor_Expr__RightAssignment_1_2
					// )
					// InternalStructuredTextParser.g:5693:3: rule__Xor_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Xor_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getXor_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__And_Expr__Group__0"
	// InternalStructuredTextParser.g:5702:1: rule__And_Expr__Group__0 :
	// rule__And_Expr__Group__0__Impl rule__And_Expr__Group__1 ;
	public final void rule__And_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5706:1: ( rule__And_Expr__Group__0__Impl
			// rule__And_Expr__Group__1 )
			// InternalStructuredTextParser.g:5707:2: rule__And_Expr__Group__0__Impl
			// rule__And_Expr__Group__1
			{
				pushFollow(FOLLOW_44);
				rule__And_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__And_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group__0"

	// $ANTLR start "rule__And_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:5714:1: rule__And_Expr__Group__0__Impl : (
	// ruleCompare_Expr ) ;
	public final void rule__And_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5718:1: ( ( ruleCompare_Expr ) )
			// InternalStructuredTextParser.g:5719:1: ( ruleCompare_Expr )
			{
				// InternalStructuredTextParser.g:5719:1: ( ruleCompare_Expr )
				// InternalStructuredTextParser.g:5720:2: ruleCompare_Expr
				{
					before(grammarAccess.getAnd_ExprAccess().getCompare_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleCompare_Expr();

					state._fsp--;

					after(grammarAccess.getAnd_ExprAccess().getCompare_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group__0__Impl"

	// $ANTLR start "rule__And_Expr__Group__1"
	// InternalStructuredTextParser.g:5729:1: rule__And_Expr__Group__1 :
	// rule__And_Expr__Group__1__Impl ;
	public final void rule__And_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5733:1: ( rule__And_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:5734:2: rule__And_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__And_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group__1"

	// $ANTLR start "rule__And_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:5740:1: rule__And_Expr__Group__1__Impl : ( (
	// rule__And_Expr__Group_1__0 )* ) ;
	public final void rule__And_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5744:1: ( ( ( rule__And_Expr__Group_1__0 )* )
			// )
			// InternalStructuredTextParser.g:5745:1: ( ( rule__And_Expr__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:5745:1: ( ( rule__And_Expr__Group_1__0 )* )
				// InternalStructuredTextParser.g:5746:2: ( rule__And_Expr__Group_1__0 )*
				{
					before(grammarAccess.getAnd_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:5747:2: ( rule__And_Expr__Group_1__0 )*
					loop50: do {
						int alt50 = 2;
						int LA50_0 = input.LA(1);

						if ((LA50_0 == AND || LA50_0 == Ampersand)) {
							alt50 = 1;
						}

						switch (alt50) {
						case 1:
						// InternalStructuredTextParser.g:5747:3: rule__And_Expr__Group_1__0
						{
							pushFollow(FOLLOW_45);
							rule__And_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop50;
						}
					} while (true);

					after(grammarAccess.getAnd_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group__1__Impl"

	// $ANTLR start "rule__And_Expr__Group_1__0"
	// InternalStructuredTextParser.g:5756:1: rule__And_Expr__Group_1__0 :
	// rule__And_Expr__Group_1__0__Impl rule__And_Expr__Group_1__1 ;
	public final void rule__And_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5760:1: ( rule__And_Expr__Group_1__0__Impl
			// rule__And_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:5761:2: rule__And_Expr__Group_1__0__Impl
			// rule__And_Expr__Group_1__1
			{
				pushFollow(FOLLOW_44);
				rule__And_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__And_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__0"

	// $ANTLR start "rule__And_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:5768:1: rule__And_Expr__Group_1__0__Impl : (
	// () ) ;
	public final void rule__And_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5772:1: ( ( () ) )
			// InternalStructuredTextParser.g:5773:1: ( () )
			{
				// InternalStructuredTextParser.g:5773:1: ( () )
				// InternalStructuredTextParser.g:5774:2: ()
				{
					before(grammarAccess.getAnd_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:5775:2: ()
					// InternalStructuredTextParser.g:5775:3:
					{
					}

					after(grammarAccess.getAnd_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__And_Expr__Group_1__1"
	// InternalStructuredTextParser.g:5783:1: rule__And_Expr__Group_1__1 :
	// rule__And_Expr__Group_1__1__Impl rule__And_Expr__Group_1__2 ;
	public final void rule__And_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5787:1: ( rule__And_Expr__Group_1__1__Impl
			// rule__And_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:5788:2: rule__And_Expr__Group_1__1__Impl
			// rule__And_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__And_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__And_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__1"

	// $ANTLR start "rule__And_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:5795:1: rule__And_Expr__Group_1__1__Impl : ( (
	// rule__And_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__And_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5799:1: ( ( (
			// rule__And_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:5800:1: ( (
			// rule__And_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:5800:1: ( (
				// rule__And_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:5801:2: (
				// rule__And_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getAnd_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:5802:2: (
					// rule__And_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:5802:3: rule__And_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__And_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getAnd_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__And_Expr__Group_1__2"
	// InternalStructuredTextParser.g:5810:1: rule__And_Expr__Group_1__2 :
	// rule__And_Expr__Group_1__2__Impl ;
	public final void rule__And_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5814:1: ( rule__And_Expr__Group_1__2__Impl )
			// InternalStructuredTextParser.g:5815:2: rule__And_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__And_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__2"

	// $ANTLR start "rule__And_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:5821:1: rule__And_Expr__Group_1__2__Impl : ( (
	// rule__And_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__And_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5825:1: ( ( (
			// rule__And_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:5826:1: ( (
			// rule__And_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:5826:1: ( (
				// rule__And_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:5827:2: ( rule__And_Expr__RightAssignment_1_2
				// )
				{
					before(grammarAccess.getAnd_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:5828:2: ( rule__And_Expr__RightAssignment_1_2
					// )
					// InternalStructuredTextParser.g:5828:3: rule__And_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__And_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getAnd_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__Compare_Expr__Group__0"
	// InternalStructuredTextParser.g:5837:1: rule__Compare_Expr__Group__0 :
	// rule__Compare_Expr__Group__0__Impl rule__Compare_Expr__Group__1 ;
	public final void rule__Compare_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5841:1: ( rule__Compare_Expr__Group__0__Impl
			// rule__Compare_Expr__Group__1 )
			// InternalStructuredTextParser.g:5842:2: rule__Compare_Expr__Group__0__Impl
			// rule__Compare_Expr__Group__1
			{
				pushFollow(FOLLOW_46);
				rule__Compare_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Compare_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group__0"

	// $ANTLR start "rule__Compare_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:5849:1: rule__Compare_Expr__Group__0__Impl : (
	// ruleEqu_Expr ) ;
	public final void rule__Compare_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5853:1: ( ( ruleEqu_Expr ) )
			// InternalStructuredTextParser.g:5854:1: ( ruleEqu_Expr )
			{
				// InternalStructuredTextParser.g:5854:1: ( ruleEqu_Expr )
				// InternalStructuredTextParser.g:5855:2: ruleEqu_Expr
				{
					before(grammarAccess.getCompare_ExprAccess().getEqu_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleEqu_Expr();

					state._fsp--;

					after(grammarAccess.getCompare_ExprAccess().getEqu_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group__0__Impl"

	// $ANTLR start "rule__Compare_Expr__Group__1"
	// InternalStructuredTextParser.g:5864:1: rule__Compare_Expr__Group__1 :
	// rule__Compare_Expr__Group__1__Impl ;
	public final void rule__Compare_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5868:1: ( rule__Compare_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:5869:2: rule__Compare_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Compare_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group__1"

	// $ANTLR start "rule__Compare_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:5875:1: rule__Compare_Expr__Group__1__Impl : (
	// ( rule__Compare_Expr__Group_1__0 )* ) ;
	public final void rule__Compare_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5879:1: ( ( ( rule__Compare_Expr__Group_1__0
			// )* ) )
			// InternalStructuredTextParser.g:5880:1: ( ( rule__Compare_Expr__Group_1__0 )*
			// )
			{
				// InternalStructuredTextParser.g:5880:1: ( ( rule__Compare_Expr__Group_1__0 )*
				// )
				// InternalStructuredTextParser.g:5881:2: ( rule__Compare_Expr__Group_1__0 )*
				{
					before(grammarAccess.getCompare_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:5882:2: ( rule__Compare_Expr__Group_1__0 )*
					loop51: do {
						int alt51 = 2;
						int LA51_0 = input.LA(1);

						if ((LA51_0 == LessThanSignGreaterThanSign || LA51_0 == EqualsSign)) {
							alt51 = 1;
						}

						switch (alt51) {
						case 1:
						// InternalStructuredTextParser.g:5882:3: rule__Compare_Expr__Group_1__0
						{
							pushFollow(FOLLOW_47);
							rule__Compare_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop51;
						}
					} while (true);

					after(grammarAccess.getCompare_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group__1__Impl"

	// $ANTLR start "rule__Compare_Expr__Group_1__0"
	// InternalStructuredTextParser.g:5891:1: rule__Compare_Expr__Group_1__0 :
	// rule__Compare_Expr__Group_1__0__Impl rule__Compare_Expr__Group_1__1 ;
	public final void rule__Compare_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5895:1: ( rule__Compare_Expr__Group_1__0__Impl
			// rule__Compare_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:5896:2: rule__Compare_Expr__Group_1__0__Impl
			// rule__Compare_Expr__Group_1__1
			{
				pushFollow(FOLLOW_46);
				rule__Compare_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Compare_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__0"

	// $ANTLR start "rule__Compare_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:5903:1: rule__Compare_Expr__Group_1__0__Impl :
	// ( () ) ;
	public final void rule__Compare_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5907:1: ( ( () ) )
			// InternalStructuredTextParser.g:5908:1: ( () )
			{
				// InternalStructuredTextParser.g:5908:1: ( () )
				// InternalStructuredTextParser.g:5909:2: ()
				{
					before(grammarAccess.getCompare_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:5910:2: ()
					// InternalStructuredTextParser.g:5910:3:
					{
					}

					after(grammarAccess.getCompare_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__Compare_Expr__Group_1__1"
	// InternalStructuredTextParser.g:5918:1: rule__Compare_Expr__Group_1__1 :
	// rule__Compare_Expr__Group_1__1__Impl rule__Compare_Expr__Group_1__2 ;
	public final void rule__Compare_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5922:1: ( rule__Compare_Expr__Group_1__1__Impl
			// rule__Compare_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:5923:2: rule__Compare_Expr__Group_1__1__Impl
			// rule__Compare_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Compare_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Compare_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__1"

	// $ANTLR start "rule__Compare_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:5930:1: rule__Compare_Expr__Group_1__1__Impl :
	// ( ( rule__Compare_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__Compare_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5934:1: ( ( (
			// rule__Compare_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:5935:1: ( (
			// rule__Compare_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:5935:1: ( (
				// rule__Compare_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:5936:2: (
				// rule__Compare_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getCompare_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:5937:2: (
					// rule__Compare_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:5937:3:
					// rule__Compare_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Compare_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getCompare_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__Compare_Expr__Group_1__2"
	// InternalStructuredTextParser.g:5945:1: rule__Compare_Expr__Group_1__2 :
	// rule__Compare_Expr__Group_1__2__Impl ;
	public final void rule__Compare_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5949:1: ( rule__Compare_Expr__Group_1__2__Impl
			// )
			// InternalStructuredTextParser.g:5950:2: rule__Compare_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Compare_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__2"

	// $ANTLR start "rule__Compare_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:5956:1: rule__Compare_Expr__Group_1__2__Impl :
	// ( ( rule__Compare_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__Compare_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5960:1: ( ( (
			// rule__Compare_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:5961:1: ( (
			// rule__Compare_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:5961:1: ( (
				// rule__Compare_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:5962:2: (
				// rule__Compare_Expr__RightAssignment_1_2 )
				{
					before(grammarAccess.getCompare_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:5963:2: (
					// rule__Compare_Expr__RightAssignment_1_2 )
					// InternalStructuredTextParser.g:5963:3:
					// rule__Compare_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Compare_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getCompare_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__Equ_Expr__Group__0"
	// InternalStructuredTextParser.g:5972:1: rule__Equ_Expr__Group__0 :
	// rule__Equ_Expr__Group__0__Impl rule__Equ_Expr__Group__1 ;
	public final void rule__Equ_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5976:1: ( rule__Equ_Expr__Group__0__Impl
			// rule__Equ_Expr__Group__1 )
			// InternalStructuredTextParser.g:5977:2: rule__Equ_Expr__Group__0__Impl
			// rule__Equ_Expr__Group__1
			{
				pushFollow(FOLLOW_48);
				rule__Equ_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Equ_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group__0"

	// $ANTLR start "rule__Equ_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:5984:1: rule__Equ_Expr__Group__0__Impl : (
	// ruleAdd_Expr ) ;
	public final void rule__Equ_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:5988:1: ( ( ruleAdd_Expr ) )
			// InternalStructuredTextParser.g:5989:1: ( ruleAdd_Expr )
			{
				// InternalStructuredTextParser.g:5989:1: ( ruleAdd_Expr )
				// InternalStructuredTextParser.g:5990:2: ruleAdd_Expr
				{
					before(grammarAccess.getEqu_ExprAccess().getAdd_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleAdd_Expr();

					state._fsp--;

					after(grammarAccess.getEqu_ExprAccess().getAdd_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group__0__Impl"

	// $ANTLR start "rule__Equ_Expr__Group__1"
	// InternalStructuredTextParser.g:5999:1: rule__Equ_Expr__Group__1 :
	// rule__Equ_Expr__Group__1__Impl ;
	public final void rule__Equ_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6003:1: ( rule__Equ_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:6004:2: rule__Equ_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Equ_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group__1"

	// $ANTLR start "rule__Equ_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:6010:1: rule__Equ_Expr__Group__1__Impl : ( (
	// rule__Equ_Expr__Group_1__0 )* ) ;
	public final void rule__Equ_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6014:1: ( ( ( rule__Equ_Expr__Group_1__0 )* )
			// )
			// InternalStructuredTextParser.g:6015:1: ( ( rule__Equ_Expr__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:6015:1: ( ( rule__Equ_Expr__Group_1__0 )* )
				// InternalStructuredTextParser.g:6016:2: ( rule__Equ_Expr__Group_1__0 )*
				{
					before(grammarAccess.getEqu_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:6017:2: ( rule__Equ_Expr__Group_1__0 )*
					loop52: do {
						int alt52 = 2;
						int LA52_0 = input.LA(1);

						if ((LA52_0 == LessThanSignEqualsSign || LA52_0 == GreaterThanSignEqualsSign
								|| LA52_0 == LessThanSign || LA52_0 == GreaterThanSign)) {
							alt52 = 1;
						}

						switch (alt52) {
						case 1:
						// InternalStructuredTextParser.g:6017:3: rule__Equ_Expr__Group_1__0
						{
							pushFollow(FOLLOW_49);
							rule__Equ_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop52;
						}
					} while (true);

					after(grammarAccess.getEqu_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group__1__Impl"

	// $ANTLR start "rule__Equ_Expr__Group_1__0"
	// InternalStructuredTextParser.g:6026:1: rule__Equ_Expr__Group_1__0 :
	// rule__Equ_Expr__Group_1__0__Impl rule__Equ_Expr__Group_1__1 ;
	public final void rule__Equ_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6030:1: ( rule__Equ_Expr__Group_1__0__Impl
			// rule__Equ_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:6031:2: rule__Equ_Expr__Group_1__0__Impl
			// rule__Equ_Expr__Group_1__1
			{
				pushFollow(FOLLOW_48);
				rule__Equ_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Equ_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__0"

	// $ANTLR start "rule__Equ_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:6038:1: rule__Equ_Expr__Group_1__0__Impl : (
	// () ) ;
	public final void rule__Equ_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6042:1: ( ( () ) )
			// InternalStructuredTextParser.g:6043:1: ( () )
			{
				// InternalStructuredTextParser.g:6043:1: ( () )
				// InternalStructuredTextParser.g:6044:2: ()
				{
					before(grammarAccess.getEqu_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:6045:2: ()
					// InternalStructuredTextParser.g:6045:3:
					{
					}

					after(grammarAccess.getEqu_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__Equ_Expr__Group_1__1"
	// InternalStructuredTextParser.g:6053:1: rule__Equ_Expr__Group_1__1 :
	// rule__Equ_Expr__Group_1__1__Impl rule__Equ_Expr__Group_1__2 ;
	public final void rule__Equ_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6057:1: ( rule__Equ_Expr__Group_1__1__Impl
			// rule__Equ_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:6058:2: rule__Equ_Expr__Group_1__1__Impl
			// rule__Equ_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Equ_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Equ_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__1"

	// $ANTLR start "rule__Equ_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:6065:1: rule__Equ_Expr__Group_1__1__Impl : ( (
	// rule__Equ_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__Equ_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6069:1: ( ( (
			// rule__Equ_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:6070:1: ( (
			// rule__Equ_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:6070:1: ( (
				// rule__Equ_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:6071:2: (
				// rule__Equ_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getEqu_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:6072:2: (
					// rule__Equ_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:6072:3: rule__Equ_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Equ_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getEqu_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__Equ_Expr__Group_1__2"
	// InternalStructuredTextParser.g:6080:1: rule__Equ_Expr__Group_1__2 :
	// rule__Equ_Expr__Group_1__2__Impl ;
	public final void rule__Equ_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6084:1: ( rule__Equ_Expr__Group_1__2__Impl )
			// InternalStructuredTextParser.g:6085:2: rule__Equ_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Equ_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__2"

	// $ANTLR start "rule__Equ_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:6091:1: rule__Equ_Expr__Group_1__2__Impl : ( (
	// rule__Equ_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__Equ_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6095:1: ( ( (
			// rule__Equ_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:6096:1: ( (
			// rule__Equ_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:6096:1: ( (
				// rule__Equ_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:6097:2: ( rule__Equ_Expr__RightAssignment_1_2
				// )
				{
					before(grammarAccess.getEqu_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:6098:2: ( rule__Equ_Expr__RightAssignment_1_2
					// )
					// InternalStructuredTextParser.g:6098:3: rule__Equ_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Equ_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getEqu_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__Add_Expr__Group__0"
	// InternalStructuredTextParser.g:6107:1: rule__Add_Expr__Group__0 :
	// rule__Add_Expr__Group__0__Impl rule__Add_Expr__Group__1 ;
	public final void rule__Add_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6111:1: ( rule__Add_Expr__Group__0__Impl
			// rule__Add_Expr__Group__1 )
			// InternalStructuredTextParser.g:6112:2: rule__Add_Expr__Group__0__Impl
			// rule__Add_Expr__Group__1
			{
				pushFollow(FOLLOW_50);
				rule__Add_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Add_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group__0"

	// $ANTLR start "rule__Add_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:6119:1: rule__Add_Expr__Group__0__Impl : (
	// ruleTerm ) ;
	public final void rule__Add_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6123:1: ( ( ruleTerm ) )
			// InternalStructuredTextParser.g:6124:1: ( ruleTerm )
			{
				// InternalStructuredTextParser.g:6124:1: ( ruleTerm )
				// InternalStructuredTextParser.g:6125:2: ruleTerm
				{
					before(grammarAccess.getAdd_ExprAccess().getTermParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleTerm();

					state._fsp--;

					after(grammarAccess.getAdd_ExprAccess().getTermParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group__0__Impl"

	// $ANTLR start "rule__Add_Expr__Group__1"
	// InternalStructuredTextParser.g:6134:1: rule__Add_Expr__Group__1 :
	// rule__Add_Expr__Group__1__Impl ;
	public final void rule__Add_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6138:1: ( rule__Add_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:6139:2: rule__Add_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Add_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group__1"

	// $ANTLR start "rule__Add_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:6145:1: rule__Add_Expr__Group__1__Impl : ( (
	// rule__Add_Expr__Group_1__0 )* ) ;
	public final void rule__Add_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6149:1: ( ( ( rule__Add_Expr__Group_1__0 )* )
			// )
			// InternalStructuredTextParser.g:6150:1: ( ( rule__Add_Expr__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:6150:1: ( ( rule__Add_Expr__Group_1__0 )* )
				// InternalStructuredTextParser.g:6151:2: ( rule__Add_Expr__Group_1__0 )*
				{
					before(grammarAccess.getAdd_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:6152:2: ( rule__Add_Expr__Group_1__0 )*
					loop53: do {
						int alt53 = 2;
						int LA53_0 = input.LA(1);

						if ((LA53_0 == PlusSign || LA53_0 == HyphenMinus)) {
							alt53 = 1;
						}

						switch (alt53) {
						case 1:
						// InternalStructuredTextParser.g:6152:3: rule__Add_Expr__Group_1__0
						{
							pushFollow(FOLLOW_51);
							rule__Add_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop53;
						}
					} while (true);

					after(grammarAccess.getAdd_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group__1__Impl"

	// $ANTLR start "rule__Add_Expr__Group_1__0"
	// InternalStructuredTextParser.g:6161:1: rule__Add_Expr__Group_1__0 :
	// rule__Add_Expr__Group_1__0__Impl rule__Add_Expr__Group_1__1 ;
	public final void rule__Add_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6165:1: ( rule__Add_Expr__Group_1__0__Impl
			// rule__Add_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:6166:2: rule__Add_Expr__Group_1__0__Impl
			// rule__Add_Expr__Group_1__1
			{
				pushFollow(FOLLOW_50);
				rule__Add_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Add_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__0"

	// $ANTLR start "rule__Add_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:6173:1: rule__Add_Expr__Group_1__0__Impl : (
	// () ) ;
	public final void rule__Add_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6177:1: ( ( () ) )
			// InternalStructuredTextParser.g:6178:1: ( () )
			{
				// InternalStructuredTextParser.g:6178:1: ( () )
				// InternalStructuredTextParser.g:6179:2: ()
				{
					before(grammarAccess.getAdd_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:6180:2: ()
					// InternalStructuredTextParser.g:6180:3:
					{
					}

					after(grammarAccess.getAdd_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__Add_Expr__Group_1__1"
	// InternalStructuredTextParser.g:6188:1: rule__Add_Expr__Group_1__1 :
	// rule__Add_Expr__Group_1__1__Impl rule__Add_Expr__Group_1__2 ;
	public final void rule__Add_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6192:1: ( rule__Add_Expr__Group_1__1__Impl
			// rule__Add_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:6193:2: rule__Add_Expr__Group_1__1__Impl
			// rule__Add_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Add_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Add_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__1"

	// $ANTLR start "rule__Add_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:6200:1: rule__Add_Expr__Group_1__1__Impl : ( (
	// rule__Add_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__Add_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6204:1: ( ( (
			// rule__Add_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:6205:1: ( (
			// rule__Add_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:6205:1: ( (
				// rule__Add_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:6206:2: (
				// rule__Add_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getAdd_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:6207:2: (
					// rule__Add_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:6207:3: rule__Add_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Add_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getAdd_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__Add_Expr__Group_1__2"
	// InternalStructuredTextParser.g:6215:1: rule__Add_Expr__Group_1__2 :
	// rule__Add_Expr__Group_1__2__Impl ;
	public final void rule__Add_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6219:1: ( rule__Add_Expr__Group_1__2__Impl )
			// InternalStructuredTextParser.g:6220:2: rule__Add_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Add_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__2"

	// $ANTLR start "rule__Add_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:6226:1: rule__Add_Expr__Group_1__2__Impl : ( (
	// rule__Add_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__Add_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6230:1: ( ( (
			// rule__Add_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:6231:1: ( (
			// rule__Add_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:6231:1: ( (
				// rule__Add_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:6232:2: ( rule__Add_Expr__RightAssignment_1_2
				// )
				{
					before(grammarAccess.getAdd_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:6233:2: ( rule__Add_Expr__RightAssignment_1_2
					// )
					// InternalStructuredTextParser.g:6233:3: rule__Add_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Add_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getAdd_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__Term__Group__0"
	// InternalStructuredTextParser.g:6242:1: rule__Term__Group__0 :
	// rule__Term__Group__0__Impl rule__Term__Group__1 ;
	public final void rule__Term__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6246:1: ( rule__Term__Group__0__Impl
			// rule__Term__Group__1 )
			// InternalStructuredTextParser.g:6247:2: rule__Term__Group__0__Impl
			// rule__Term__Group__1
			{
				pushFollow(FOLLOW_52);
				rule__Term__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Term__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group__0"

	// $ANTLR start "rule__Term__Group__0__Impl"
	// InternalStructuredTextParser.g:6254:1: rule__Term__Group__0__Impl : (
	// rulePower_Expr ) ;
	public final void rule__Term__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6258:1: ( ( rulePower_Expr ) )
			// InternalStructuredTextParser.g:6259:1: ( rulePower_Expr )
			{
				// InternalStructuredTextParser.g:6259:1: ( rulePower_Expr )
				// InternalStructuredTextParser.g:6260:2: rulePower_Expr
				{
					before(grammarAccess.getTermAccess().getPower_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					rulePower_Expr();

					state._fsp--;

					after(grammarAccess.getTermAccess().getPower_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group__0__Impl"

	// $ANTLR start "rule__Term__Group__1"
	// InternalStructuredTextParser.g:6269:1: rule__Term__Group__1 :
	// rule__Term__Group__1__Impl ;
	public final void rule__Term__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6273:1: ( rule__Term__Group__1__Impl )
			// InternalStructuredTextParser.g:6274:2: rule__Term__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Term__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group__1"

	// $ANTLR start "rule__Term__Group__1__Impl"
	// InternalStructuredTextParser.g:6280:1: rule__Term__Group__1__Impl : ( (
	// rule__Term__Group_1__0 )* ) ;
	public final void rule__Term__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6284:1: ( ( ( rule__Term__Group_1__0 )* ) )
			// InternalStructuredTextParser.g:6285:1: ( ( rule__Term__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:6285:1: ( ( rule__Term__Group_1__0 )* )
				// InternalStructuredTextParser.g:6286:2: ( rule__Term__Group_1__0 )*
				{
					before(grammarAccess.getTermAccess().getGroup_1());
					// InternalStructuredTextParser.g:6287:2: ( rule__Term__Group_1__0 )*
					loop54: do {
						int alt54 = 2;
						int LA54_0 = input.LA(1);

						if ((LA54_0 == MOD || LA54_0 == Asterisk || LA54_0 == Solidus)) {
							alt54 = 1;
						}

						switch (alt54) {
						case 1:
						// InternalStructuredTextParser.g:6287:3: rule__Term__Group_1__0
						{
							pushFollow(FOLLOW_53);
							rule__Term__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop54;
						}
					} while (true);

					after(grammarAccess.getTermAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group__1__Impl"

	// $ANTLR start "rule__Term__Group_1__0"
	// InternalStructuredTextParser.g:6296:1: rule__Term__Group_1__0 :
	// rule__Term__Group_1__0__Impl rule__Term__Group_1__1 ;
	public final void rule__Term__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6300:1: ( rule__Term__Group_1__0__Impl
			// rule__Term__Group_1__1 )
			// InternalStructuredTextParser.g:6301:2: rule__Term__Group_1__0__Impl
			// rule__Term__Group_1__1
			{
				pushFollow(FOLLOW_52);
				rule__Term__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Term__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__0"

	// $ANTLR start "rule__Term__Group_1__0__Impl"
	// InternalStructuredTextParser.g:6308:1: rule__Term__Group_1__0__Impl : ( () )
	// ;
	public final void rule__Term__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6312:1: ( ( () ) )
			// InternalStructuredTextParser.g:6313:1: ( () )
			{
				// InternalStructuredTextParser.g:6313:1: ( () )
				// InternalStructuredTextParser.g:6314:2: ()
				{
					before(grammarAccess.getTermAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:6315:2: ()
					// InternalStructuredTextParser.g:6315:3:
					{
					}

					after(grammarAccess.getTermAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__0__Impl"

	// $ANTLR start "rule__Term__Group_1__1"
	// InternalStructuredTextParser.g:6323:1: rule__Term__Group_1__1 :
	// rule__Term__Group_1__1__Impl rule__Term__Group_1__2 ;
	public final void rule__Term__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6327:1: ( rule__Term__Group_1__1__Impl
			// rule__Term__Group_1__2 )
			// InternalStructuredTextParser.g:6328:2: rule__Term__Group_1__1__Impl
			// rule__Term__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Term__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Term__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__1"

	// $ANTLR start "rule__Term__Group_1__1__Impl"
	// InternalStructuredTextParser.g:6335:1: rule__Term__Group_1__1__Impl : ( (
	// rule__Term__OperatorAssignment_1_1 ) ) ;
	public final void rule__Term__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6339:1: ( ( (
			// rule__Term__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:6340:1: ( ( rule__Term__OperatorAssignment_1_1
			// ) )
			{
				// InternalStructuredTextParser.g:6340:1: ( ( rule__Term__OperatorAssignment_1_1
				// ) )
				// InternalStructuredTextParser.g:6341:2: ( rule__Term__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getTermAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:6342:2: ( rule__Term__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:6342:3: rule__Term__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Term__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getTermAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__1__Impl"

	// $ANTLR start "rule__Term__Group_1__2"
	// InternalStructuredTextParser.g:6350:1: rule__Term__Group_1__2 :
	// rule__Term__Group_1__2__Impl ;
	public final void rule__Term__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6354:1: ( rule__Term__Group_1__2__Impl )
			// InternalStructuredTextParser.g:6355:2: rule__Term__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Term__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__2"

	// $ANTLR start "rule__Term__Group_1__2__Impl"
	// InternalStructuredTextParser.g:6361:1: rule__Term__Group_1__2__Impl : ( (
	// rule__Term__RightAssignment_1_2 ) ) ;
	public final void rule__Term__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6365:1: ( ( ( rule__Term__RightAssignment_1_2
			// ) ) )
			// InternalStructuredTextParser.g:6366:1: ( ( rule__Term__RightAssignment_1_2 )
			// )
			{
				// InternalStructuredTextParser.g:6366:1: ( ( rule__Term__RightAssignment_1_2 )
				// )
				// InternalStructuredTextParser.g:6367:2: ( rule__Term__RightAssignment_1_2 )
				{
					before(grammarAccess.getTermAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:6368:2: ( rule__Term__RightAssignment_1_2 )
					// InternalStructuredTextParser.g:6368:3: rule__Term__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Term__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getTermAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__Group_1__2__Impl"

	// $ANTLR start "rule__Power_Expr__Group__0"
	// InternalStructuredTextParser.g:6377:1: rule__Power_Expr__Group__0 :
	// rule__Power_Expr__Group__0__Impl rule__Power_Expr__Group__1 ;
	public final void rule__Power_Expr__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6381:1: ( rule__Power_Expr__Group__0__Impl
			// rule__Power_Expr__Group__1 )
			// InternalStructuredTextParser.g:6382:2: rule__Power_Expr__Group__0__Impl
			// rule__Power_Expr__Group__1
			{
				pushFollow(FOLLOW_54);
				rule__Power_Expr__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Power_Expr__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group__0"

	// $ANTLR start "rule__Power_Expr__Group__0__Impl"
	// InternalStructuredTextParser.g:6389:1: rule__Power_Expr__Group__0__Impl : (
	// ruleUnary_Expr ) ;
	public final void rule__Power_Expr__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6393:1: ( ( ruleUnary_Expr ) )
			// InternalStructuredTextParser.g:6394:1: ( ruleUnary_Expr )
			{
				// InternalStructuredTextParser.g:6394:1: ( ruleUnary_Expr )
				// InternalStructuredTextParser.g:6395:2: ruleUnary_Expr
				{
					before(grammarAccess.getPower_ExprAccess().getUnary_ExprParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleUnary_Expr();

					state._fsp--;

					after(grammarAccess.getPower_ExprAccess().getUnary_ExprParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group__0__Impl"

	// $ANTLR start "rule__Power_Expr__Group__1"
	// InternalStructuredTextParser.g:6404:1: rule__Power_Expr__Group__1 :
	// rule__Power_Expr__Group__1__Impl ;
	public final void rule__Power_Expr__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6408:1: ( rule__Power_Expr__Group__1__Impl )
			// InternalStructuredTextParser.g:6409:2: rule__Power_Expr__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Power_Expr__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group__1"

	// $ANTLR start "rule__Power_Expr__Group__1__Impl"
	// InternalStructuredTextParser.g:6415:1: rule__Power_Expr__Group__1__Impl : ( (
	// rule__Power_Expr__Group_1__0 )* ) ;
	public final void rule__Power_Expr__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6419:1: ( ( ( rule__Power_Expr__Group_1__0 )*
			// ) )
			// InternalStructuredTextParser.g:6420:1: ( ( rule__Power_Expr__Group_1__0 )* )
			{
				// InternalStructuredTextParser.g:6420:1: ( ( rule__Power_Expr__Group_1__0 )* )
				// InternalStructuredTextParser.g:6421:2: ( rule__Power_Expr__Group_1__0 )*
				{
					before(grammarAccess.getPower_ExprAccess().getGroup_1());
					// InternalStructuredTextParser.g:6422:2: ( rule__Power_Expr__Group_1__0 )*
					loop55: do {
						int alt55 = 2;
						int LA55_0 = input.LA(1);

						if ((LA55_0 == AsteriskAsterisk)) {
							alt55 = 1;
						}

						switch (alt55) {
						case 1:
						// InternalStructuredTextParser.g:6422:3: rule__Power_Expr__Group_1__0
						{
							pushFollow(FOLLOW_55);
							rule__Power_Expr__Group_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop55;
						}
					} while (true);

					after(grammarAccess.getPower_ExprAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group__1__Impl"

	// $ANTLR start "rule__Power_Expr__Group_1__0"
	// InternalStructuredTextParser.g:6431:1: rule__Power_Expr__Group_1__0 :
	// rule__Power_Expr__Group_1__0__Impl rule__Power_Expr__Group_1__1 ;
	public final void rule__Power_Expr__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6435:1: ( rule__Power_Expr__Group_1__0__Impl
			// rule__Power_Expr__Group_1__1 )
			// InternalStructuredTextParser.g:6436:2: rule__Power_Expr__Group_1__0__Impl
			// rule__Power_Expr__Group_1__1
			{
				pushFollow(FOLLOW_54);
				rule__Power_Expr__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Power_Expr__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__0"

	// $ANTLR start "rule__Power_Expr__Group_1__0__Impl"
	// InternalStructuredTextParser.g:6443:1: rule__Power_Expr__Group_1__0__Impl : (
	// () ) ;
	public final void rule__Power_Expr__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6447:1: ( ( () ) )
			// InternalStructuredTextParser.g:6448:1: ( () )
			{
				// InternalStructuredTextParser.g:6448:1: ( () )
				// InternalStructuredTextParser.g:6449:2: ()
				{
					before(grammarAccess.getPower_ExprAccess().getBinaryExpressionLeftAction_1_0());
					// InternalStructuredTextParser.g:6450:2: ()
					// InternalStructuredTextParser.g:6450:3:
					{
					}

					after(grammarAccess.getPower_ExprAccess().getBinaryExpressionLeftAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__0__Impl"

	// $ANTLR start "rule__Power_Expr__Group_1__1"
	// InternalStructuredTextParser.g:6458:1: rule__Power_Expr__Group_1__1 :
	// rule__Power_Expr__Group_1__1__Impl rule__Power_Expr__Group_1__2 ;
	public final void rule__Power_Expr__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6462:1: ( rule__Power_Expr__Group_1__1__Impl
			// rule__Power_Expr__Group_1__2 )
			// InternalStructuredTextParser.g:6463:2: rule__Power_Expr__Group_1__1__Impl
			// rule__Power_Expr__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Power_Expr__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Power_Expr__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__1"

	// $ANTLR start "rule__Power_Expr__Group_1__1__Impl"
	// InternalStructuredTextParser.g:6470:1: rule__Power_Expr__Group_1__1__Impl : (
	// ( rule__Power_Expr__OperatorAssignment_1_1 ) ) ;
	public final void rule__Power_Expr__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6474:1: ( ( (
			// rule__Power_Expr__OperatorAssignment_1_1 ) ) )
			// InternalStructuredTextParser.g:6475:1: ( (
			// rule__Power_Expr__OperatorAssignment_1_1 ) )
			{
				// InternalStructuredTextParser.g:6475:1: ( (
				// rule__Power_Expr__OperatorAssignment_1_1 ) )
				// InternalStructuredTextParser.g:6476:2: (
				// rule__Power_Expr__OperatorAssignment_1_1 )
				{
					before(grammarAccess.getPower_ExprAccess().getOperatorAssignment_1_1());
					// InternalStructuredTextParser.g:6477:2: (
					// rule__Power_Expr__OperatorAssignment_1_1 )
					// InternalStructuredTextParser.g:6477:3:
					// rule__Power_Expr__OperatorAssignment_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Power_Expr__OperatorAssignment_1_1();

						state._fsp--;

					}

					after(grammarAccess.getPower_ExprAccess().getOperatorAssignment_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__1__Impl"

	// $ANTLR start "rule__Power_Expr__Group_1__2"
	// InternalStructuredTextParser.g:6485:1: rule__Power_Expr__Group_1__2 :
	// rule__Power_Expr__Group_1__2__Impl ;
	public final void rule__Power_Expr__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6489:1: ( rule__Power_Expr__Group_1__2__Impl )
			// InternalStructuredTextParser.g:6490:2: rule__Power_Expr__Group_1__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Power_Expr__Group_1__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__2"

	// $ANTLR start "rule__Power_Expr__Group_1__2__Impl"
	// InternalStructuredTextParser.g:6496:1: rule__Power_Expr__Group_1__2__Impl : (
	// ( rule__Power_Expr__RightAssignment_1_2 ) ) ;
	public final void rule__Power_Expr__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6500:1: ( ( (
			// rule__Power_Expr__RightAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:6501:1: ( (
			// rule__Power_Expr__RightAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:6501:1: ( (
				// rule__Power_Expr__RightAssignment_1_2 ) )
				// InternalStructuredTextParser.g:6502:2: (
				// rule__Power_Expr__RightAssignment_1_2 )
				{
					before(grammarAccess.getPower_ExprAccess().getRightAssignment_1_2());
					// InternalStructuredTextParser.g:6503:2: (
					// rule__Power_Expr__RightAssignment_1_2 )
					// InternalStructuredTextParser.g:6503:3: rule__Power_Expr__RightAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Power_Expr__RightAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getPower_ExprAccess().getRightAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__Group_1__2__Impl"

	// $ANTLR start "rule__Unary_Expr__Group_0__0"
	// InternalStructuredTextParser.g:6512:1: rule__Unary_Expr__Group_0__0 :
	// rule__Unary_Expr__Group_0__0__Impl rule__Unary_Expr__Group_0__1 ;
	public final void rule__Unary_Expr__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6516:1: ( rule__Unary_Expr__Group_0__0__Impl
			// rule__Unary_Expr__Group_0__1 )
			// InternalStructuredTextParser.g:6517:2: rule__Unary_Expr__Group_0__0__Impl
			// rule__Unary_Expr__Group_0__1
			{
				pushFollow(FOLLOW_56);
				rule__Unary_Expr__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Unary_Expr__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__0"

	// $ANTLR start "rule__Unary_Expr__Group_0__0__Impl"
	// InternalStructuredTextParser.g:6524:1: rule__Unary_Expr__Group_0__0__Impl : (
	// () ) ;
	public final void rule__Unary_Expr__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6528:1: ( ( () ) )
			// InternalStructuredTextParser.g:6529:1: ( () )
			{
				// InternalStructuredTextParser.g:6529:1: ( () )
				// InternalStructuredTextParser.g:6530:2: ()
				{
					before(grammarAccess.getUnary_ExprAccess().getUnaryExpressionAction_0_0());
					// InternalStructuredTextParser.g:6531:2: ()
					// InternalStructuredTextParser.g:6531:3:
					{
					}

					after(grammarAccess.getUnary_ExprAccess().getUnaryExpressionAction_0_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__0__Impl"

	// $ANTLR start "rule__Unary_Expr__Group_0__1"
	// InternalStructuredTextParser.g:6539:1: rule__Unary_Expr__Group_0__1 :
	// rule__Unary_Expr__Group_0__1__Impl rule__Unary_Expr__Group_0__2 ;
	public final void rule__Unary_Expr__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6543:1: ( rule__Unary_Expr__Group_0__1__Impl
			// rule__Unary_Expr__Group_0__2 )
			// InternalStructuredTextParser.g:6544:2: rule__Unary_Expr__Group_0__1__Impl
			// rule__Unary_Expr__Group_0__2
			{
				pushFollow(FOLLOW_57);
				rule__Unary_Expr__Group_0__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Unary_Expr__Group_0__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__1"

	// $ANTLR start "rule__Unary_Expr__Group_0__1__Impl"
	// InternalStructuredTextParser.g:6551:1: rule__Unary_Expr__Group_0__1__Impl : (
	// ( rule__Unary_Expr__OperatorAssignment_0_1 ) ) ;
	public final void rule__Unary_Expr__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6555:1: ( ( (
			// rule__Unary_Expr__OperatorAssignment_0_1 ) ) )
			// InternalStructuredTextParser.g:6556:1: ( (
			// rule__Unary_Expr__OperatorAssignment_0_1 ) )
			{
				// InternalStructuredTextParser.g:6556:1: ( (
				// rule__Unary_Expr__OperatorAssignment_0_1 ) )
				// InternalStructuredTextParser.g:6557:2: (
				// rule__Unary_Expr__OperatorAssignment_0_1 )
				{
					before(grammarAccess.getUnary_ExprAccess().getOperatorAssignment_0_1());
					// InternalStructuredTextParser.g:6558:2: (
					// rule__Unary_Expr__OperatorAssignment_0_1 )
					// InternalStructuredTextParser.g:6558:3:
					// rule__Unary_Expr__OperatorAssignment_0_1
					{
						pushFollow(FOLLOW_2);
						rule__Unary_Expr__OperatorAssignment_0_1();

						state._fsp--;

					}

					after(grammarAccess.getUnary_ExprAccess().getOperatorAssignment_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__1__Impl"

	// $ANTLR start "rule__Unary_Expr__Group_0__2"
	// InternalStructuredTextParser.g:6566:1: rule__Unary_Expr__Group_0__2 :
	// rule__Unary_Expr__Group_0__2__Impl ;
	public final void rule__Unary_Expr__Group_0__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6570:1: ( rule__Unary_Expr__Group_0__2__Impl )
			// InternalStructuredTextParser.g:6571:2: rule__Unary_Expr__Group_0__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Unary_Expr__Group_0__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__2"

	// $ANTLR start "rule__Unary_Expr__Group_0__2__Impl"
	// InternalStructuredTextParser.g:6577:1: rule__Unary_Expr__Group_0__2__Impl : (
	// ( rule__Unary_Expr__ExpressionAssignment_0_2 ) ) ;
	public final void rule__Unary_Expr__Group_0__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6581:1: ( ( (
			// rule__Unary_Expr__ExpressionAssignment_0_2 ) ) )
			// InternalStructuredTextParser.g:6582:1: ( (
			// rule__Unary_Expr__ExpressionAssignment_0_2 ) )
			{
				// InternalStructuredTextParser.g:6582:1: ( (
				// rule__Unary_Expr__ExpressionAssignment_0_2 ) )
				// InternalStructuredTextParser.g:6583:2: (
				// rule__Unary_Expr__ExpressionAssignment_0_2 )
				{
					before(grammarAccess.getUnary_ExprAccess().getExpressionAssignment_0_2());
					// InternalStructuredTextParser.g:6584:2: (
					// rule__Unary_Expr__ExpressionAssignment_0_2 )
					// InternalStructuredTextParser.g:6584:3:
					// rule__Unary_Expr__ExpressionAssignment_0_2
					{
						pushFollow(FOLLOW_2);
						rule__Unary_Expr__ExpressionAssignment_0_2();

						state._fsp--;

					}

					after(grammarAccess.getUnary_ExprAccess().getExpressionAssignment_0_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__Group_0__2__Impl"

	// $ANTLR start "rule__Primary_Expr__Group_2__0"
	// InternalStructuredTextParser.g:6593:1: rule__Primary_Expr__Group_2__0 :
	// rule__Primary_Expr__Group_2__0__Impl rule__Primary_Expr__Group_2__1 ;
	public final void rule__Primary_Expr__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6597:1: ( rule__Primary_Expr__Group_2__0__Impl
			// rule__Primary_Expr__Group_2__1 )
			// InternalStructuredTextParser.g:6598:2: rule__Primary_Expr__Group_2__0__Impl
			// rule__Primary_Expr__Group_2__1
			{
				pushFollow(FOLLOW_17);
				rule__Primary_Expr__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Primary_Expr__Group_2__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__0"

	// $ANTLR start "rule__Primary_Expr__Group_2__0__Impl"
	// InternalStructuredTextParser.g:6605:1: rule__Primary_Expr__Group_2__0__Impl :
	// ( LeftParenthesis ) ;
	public final void rule__Primary_Expr__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6609:1: ( ( LeftParenthesis ) )
			// InternalStructuredTextParser.g:6610:1: ( LeftParenthesis )
			{
				// InternalStructuredTextParser.g:6610:1: ( LeftParenthesis )
				// InternalStructuredTextParser.g:6611:2: LeftParenthesis
				{
					before(grammarAccess.getPrimary_ExprAccess().getLeftParenthesisKeyword_2_0());
					match(input, LeftParenthesis, FOLLOW_2);
					after(grammarAccess.getPrimary_ExprAccess().getLeftParenthesisKeyword_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__0__Impl"

	// $ANTLR start "rule__Primary_Expr__Group_2__1"
	// InternalStructuredTextParser.g:6620:1: rule__Primary_Expr__Group_2__1 :
	// rule__Primary_Expr__Group_2__1__Impl rule__Primary_Expr__Group_2__2 ;
	public final void rule__Primary_Expr__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6624:1: ( rule__Primary_Expr__Group_2__1__Impl
			// rule__Primary_Expr__Group_2__2 )
			// InternalStructuredTextParser.g:6625:2: rule__Primary_Expr__Group_2__1__Impl
			// rule__Primary_Expr__Group_2__2
			{
				pushFollow(FOLLOW_20);
				rule__Primary_Expr__Group_2__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Primary_Expr__Group_2__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__1"

	// $ANTLR start "rule__Primary_Expr__Group_2__1__Impl"
	// InternalStructuredTextParser.g:6632:1: rule__Primary_Expr__Group_2__1__Impl :
	// ( ruleExpression ) ;
	public final void rule__Primary_Expr__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6636:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:6637:1: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:6637:1: ( ruleExpression )
				// InternalStructuredTextParser.g:6638:2: ruleExpression
				{
					before(grammarAccess.getPrimary_ExprAccess().getExpressionParserRuleCall_2_1());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getPrimary_ExprAccess().getExpressionParserRuleCall_2_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__1__Impl"

	// $ANTLR start "rule__Primary_Expr__Group_2__2"
	// InternalStructuredTextParser.g:6647:1: rule__Primary_Expr__Group_2__2 :
	// rule__Primary_Expr__Group_2__2__Impl ;
	public final void rule__Primary_Expr__Group_2__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6651:1: ( rule__Primary_Expr__Group_2__2__Impl
			// )
			// InternalStructuredTextParser.g:6652:2: rule__Primary_Expr__Group_2__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Primary_Expr__Group_2__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__2"

	// $ANTLR start "rule__Primary_Expr__Group_2__2__Impl"
	// InternalStructuredTextParser.g:6658:1: rule__Primary_Expr__Group_2__2__Impl :
	// ( RightParenthesis ) ;
	public final void rule__Primary_Expr__Group_2__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6662:1: ( ( RightParenthesis ) )
			// InternalStructuredTextParser.g:6663:1: ( RightParenthesis )
			{
				// InternalStructuredTextParser.g:6663:1: ( RightParenthesis )
				// InternalStructuredTextParser.g:6664:2: RightParenthesis
				{
					before(grammarAccess.getPrimary_ExprAccess().getRightParenthesisKeyword_2_2());
					match(input, RightParenthesis, FOLLOW_2);
					after(grammarAccess.getPrimary_ExprAccess().getRightParenthesisKeyword_2_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Primary_Expr__Group_2__2__Impl"

	// $ANTLR start "rule__Func_Call__Group__0"
	// InternalStructuredTextParser.g:6674:1: rule__Func_Call__Group__0 :
	// rule__Func_Call__Group__0__Impl rule__Func_Call__Group__1 ;
	public final void rule__Func_Call__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6678:1: ( rule__Func_Call__Group__0__Impl
			// rule__Func_Call__Group__1 )
			// InternalStructuredTextParser.g:6679:2: rule__Func_Call__Group__0__Impl
			// rule__Func_Call__Group__1
			{
				pushFollow(FOLLOW_19);
				rule__Func_Call__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Func_Call__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__0"

	// $ANTLR start "rule__Func_Call__Group__0__Impl"
	// InternalStructuredTextParser.g:6686:1: rule__Func_Call__Group__0__Impl : ( (
	// rule__Func_Call__FuncAssignment_0 ) ) ;
	public final void rule__Func_Call__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6690:1: ( ( (
			// rule__Func_Call__FuncAssignment_0 ) ) )
			// InternalStructuredTextParser.g:6691:1: ( ( rule__Func_Call__FuncAssignment_0
			// ) )
			{
				// InternalStructuredTextParser.g:6691:1: ( ( rule__Func_Call__FuncAssignment_0
				// ) )
				// InternalStructuredTextParser.g:6692:2: ( rule__Func_Call__FuncAssignment_0 )
				{
					before(grammarAccess.getFunc_CallAccess().getFuncAssignment_0());
					// InternalStructuredTextParser.g:6693:2: ( rule__Func_Call__FuncAssignment_0 )
					// InternalStructuredTextParser.g:6693:3: rule__Func_Call__FuncAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__FuncAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getFunc_CallAccess().getFuncAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__0__Impl"

	// $ANTLR start "rule__Func_Call__Group__1"
	// InternalStructuredTextParser.g:6701:1: rule__Func_Call__Group__1 :
	// rule__Func_Call__Group__1__Impl rule__Func_Call__Group__2 ;
	public final void rule__Func_Call__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6705:1: ( rule__Func_Call__Group__1__Impl
			// rule__Func_Call__Group__2 )
			// InternalStructuredTextParser.g:6706:2: rule__Func_Call__Group__1__Impl
			// rule__Func_Call__Group__2
			{
				pushFollow(FOLLOW_58);
				rule__Func_Call__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Func_Call__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__1"

	// $ANTLR start "rule__Func_Call__Group__1__Impl"
	// InternalStructuredTextParser.g:6713:1: rule__Func_Call__Group__1__Impl : (
	// LeftParenthesis ) ;
	public final void rule__Func_Call__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6717:1: ( ( LeftParenthesis ) )
			// InternalStructuredTextParser.g:6718:1: ( LeftParenthesis )
			{
				// InternalStructuredTextParser.g:6718:1: ( LeftParenthesis )
				// InternalStructuredTextParser.g:6719:2: LeftParenthesis
				{
					before(grammarAccess.getFunc_CallAccess().getLeftParenthesisKeyword_1());
					match(input, LeftParenthesis, FOLLOW_2);
					after(grammarAccess.getFunc_CallAccess().getLeftParenthesisKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__1__Impl"

	// $ANTLR start "rule__Func_Call__Group__2"
	// InternalStructuredTextParser.g:6728:1: rule__Func_Call__Group__2 :
	// rule__Func_Call__Group__2__Impl rule__Func_Call__Group__3 ;
	public final void rule__Func_Call__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6732:1: ( rule__Func_Call__Group__2__Impl
			// rule__Func_Call__Group__3 )
			// InternalStructuredTextParser.g:6733:2: rule__Func_Call__Group__2__Impl
			// rule__Func_Call__Group__3
			{
				pushFollow(FOLLOW_58);
				rule__Func_Call__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Func_Call__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__2"

	// $ANTLR start "rule__Func_Call__Group__2__Impl"
	// InternalStructuredTextParser.g:6740:1: rule__Func_Call__Group__2__Impl : ( (
	// rule__Func_Call__Group_2__0 )? ) ;
	public final void rule__Func_Call__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6744:1: ( ( ( rule__Func_Call__Group_2__0 )? )
			// )
			// InternalStructuredTextParser.g:6745:1: ( ( rule__Func_Call__Group_2__0 )? )
			{
				// InternalStructuredTextParser.g:6745:1: ( ( rule__Func_Call__Group_2__0 )? )
				// InternalStructuredTextParser.g:6746:2: ( rule__Func_Call__Group_2__0 )?
				{
					before(grammarAccess.getFunc_CallAccess().getGroup_2());
					// InternalStructuredTextParser.g:6747:2: ( rule__Func_Call__Group_2__0 )?
					int alt56 = 2;
					int LA56_0 = input.LA(1);

					if (((LA56_0 >= LDATE_AND_TIME && LA56_0 <= TIME_OF_DAY) || LA56_0 == WSTRING || LA56_0 == STRING
							|| (LA56_0 >= FALSE && LA56_0 <= LTIME) || (LA56_0 >= UDINT && LA56_0 <= ULINT)
							|| (LA56_0 >= USINT && LA56_0 <= WCHAR) || LA56_0 == BOOL
							|| (LA56_0 >= CHAR && LA56_0 <= DINT) || (LA56_0 >= LINT && LA56_0 <= SINT)
							|| (LA56_0 >= TIME && LA56_0 <= UINT) || (LA56_0 >= INT && LA56_0 <= LDT)
							|| (LA56_0 >= NOT && LA56_0 <= TOD) || LA56_0 == DT || (LA56_0 >= LD && LA56_0 <= LT)
							|| LA56_0 == LeftParenthesis || LA56_0 == PlusSign || LA56_0 == HyphenMinus || LA56_0 == T
							|| LA56_0 == D_1 || (LA56_0 >= RULE_ID && LA56_0 <= RULE_UNSIGNED_INT)
							|| LA56_0 == RULE_S_BYTE_CHAR_STR || LA56_0 == RULE_D_BYTE_CHAR_STR)) {
						alt56 = 1;
					}
					switch (alt56) {
					case 1:
					// InternalStructuredTextParser.g:6747:3: rule__Func_Call__Group_2__0
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__Group_2__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getFunc_CallAccess().getGroup_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__2__Impl"

	// $ANTLR start "rule__Func_Call__Group__3"
	// InternalStructuredTextParser.g:6755:1: rule__Func_Call__Group__3 :
	// rule__Func_Call__Group__3__Impl ;
	public final void rule__Func_Call__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6759:1: ( rule__Func_Call__Group__3__Impl )
			// InternalStructuredTextParser.g:6760:2: rule__Func_Call__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Func_Call__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__3"

	// $ANTLR start "rule__Func_Call__Group__3__Impl"
	// InternalStructuredTextParser.g:6766:1: rule__Func_Call__Group__3__Impl : (
	// RightParenthesis ) ;
	public final void rule__Func_Call__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6770:1: ( ( RightParenthesis ) )
			// InternalStructuredTextParser.g:6771:1: ( RightParenthesis )
			{
				// InternalStructuredTextParser.g:6771:1: ( RightParenthesis )
				// InternalStructuredTextParser.g:6772:2: RightParenthesis
				{
					before(grammarAccess.getFunc_CallAccess().getRightParenthesisKeyword_3());
					match(input, RightParenthesis, FOLLOW_2);
					after(grammarAccess.getFunc_CallAccess().getRightParenthesisKeyword_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group__3__Impl"

	// $ANTLR start "rule__Func_Call__Group_2__0"
	// InternalStructuredTextParser.g:6782:1: rule__Func_Call__Group_2__0 :
	// rule__Func_Call__Group_2__0__Impl rule__Func_Call__Group_2__1 ;
	public final void rule__Func_Call__Group_2__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6786:1: ( rule__Func_Call__Group_2__0__Impl
			// rule__Func_Call__Group_2__1 )
			// InternalStructuredTextParser.g:6787:2: rule__Func_Call__Group_2__0__Impl
			// rule__Func_Call__Group_2__1
			{
				pushFollow(FOLLOW_59);
				rule__Func_Call__Group_2__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Func_Call__Group_2__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2__0"

	// $ANTLR start "rule__Func_Call__Group_2__0__Impl"
	// InternalStructuredTextParser.g:6794:1: rule__Func_Call__Group_2__0__Impl : (
	// ( rule__Func_Call__ArgsAssignment_2_0 ) ) ;
	public final void rule__Func_Call__Group_2__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6798:1: ( ( (
			// rule__Func_Call__ArgsAssignment_2_0 ) ) )
			// InternalStructuredTextParser.g:6799:1: ( (
			// rule__Func_Call__ArgsAssignment_2_0 ) )
			{
				// InternalStructuredTextParser.g:6799:1: ( (
				// rule__Func_Call__ArgsAssignment_2_0 ) )
				// InternalStructuredTextParser.g:6800:2: ( rule__Func_Call__ArgsAssignment_2_0
				// )
				{
					before(grammarAccess.getFunc_CallAccess().getArgsAssignment_2_0());
					// InternalStructuredTextParser.g:6801:2: ( rule__Func_Call__ArgsAssignment_2_0
					// )
					// InternalStructuredTextParser.g:6801:3: rule__Func_Call__ArgsAssignment_2_0
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__ArgsAssignment_2_0();

						state._fsp--;

					}

					after(grammarAccess.getFunc_CallAccess().getArgsAssignment_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2__0__Impl"

	// $ANTLR start "rule__Func_Call__Group_2__1"
	// InternalStructuredTextParser.g:6809:1: rule__Func_Call__Group_2__1 :
	// rule__Func_Call__Group_2__1__Impl ;
	public final void rule__Func_Call__Group_2__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6813:1: ( rule__Func_Call__Group_2__1__Impl )
			// InternalStructuredTextParser.g:6814:2: rule__Func_Call__Group_2__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Func_Call__Group_2__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2__1"

	// $ANTLR start "rule__Func_Call__Group_2__1__Impl"
	// InternalStructuredTextParser.g:6820:1: rule__Func_Call__Group_2__1__Impl : (
	// ( rule__Func_Call__Group_2_1__0 )* ) ;
	public final void rule__Func_Call__Group_2__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6824:1: ( ( ( rule__Func_Call__Group_2_1__0 )*
			// ) )
			// InternalStructuredTextParser.g:6825:1: ( ( rule__Func_Call__Group_2_1__0 )* )
			{
				// InternalStructuredTextParser.g:6825:1: ( ( rule__Func_Call__Group_2_1__0 )* )
				// InternalStructuredTextParser.g:6826:2: ( rule__Func_Call__Group_2_1__0 )*
				{
					before(grammarAccess.getFunc_CallAccess().getGroup_2_1());
					// InternalStructuredTextParser.g:6827:2: ( rule__Func_Call__Group_2_1__0 )*
					loop57: do {
						int alt57 = 2;
						int LA57_0 = input.LA(1);

						if ((LA57_0 == Comma)) {
							alt57 = 1;
						}

						switch (alt57) {
						case 1:
						// InternalStructuredTextParser.g:6827:3: rule__Func_Call__Group_2_1__0
						{
							pushFollow(FOLLOW_29);
							rule__Func_Call__Group_2_1__0();

							state._fsp--;

						}
							break;

						default:
							break loop57;
						}
					} while (true);

					after(grammarAccess.getFunc_CallAccess().getGroup_2_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2__1__Impl"

	// $ANTLR start "rule__Func_Call__Group_2_1__0"
	// InternalStructuredTextParser.g:6836:1: rule__Func_Call__Group_2_1__0 :
	// rule__Func_Call__Group_2_1__0__Impl rule__Func_Call__Group_2_1__1 ;
	public final void rule__Func_Call__Group_2_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6840:1: ( rule__Func_Call__Group_2_1__0__Impl
			// rule__Func_Call__Group_2_1__1 )
			// InternalStructuredTextParser.g:6841:2: rule__Func_Call__Group_2_1__0__Impl
			// rule__Func_Call__Group_2_1__1
			{
				pushFollow(FOLLOW_17);
				rule__Func_Call__Group_2_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Func_Call__Group_2_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2_1__0"

	// $ANTLR start "rule__Func_Call__Group_2_1__0__Impl"
	// InternalStructuredTextParser.g:6848:1: rule__Func_Call__Group_2_1__0__Impl :
	// ( Comma ) ;
	public final void rule__Func_Call__Group_2_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6852:1: ( ( Comma ) )
			// InternalStructuredTextParser.g:6853:1: ( Comma )
			{
				// InternalStructuredTextParser.g:6853:1: ( Comma )
				// InternalStructuredTextParser.g:6854:2: Comma
				{
					before(grammarAccess.getFunc_CallAccess().getCommaKeyword_2_1_0());
					match(input, Comma, FOLLOW_2);
					after(grammarAccess.getFunc_CallAccess().getCommaKeyword_2_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2_1__0__Impl"

	// $ANTLR start "rule__Func_Call__Group_2_1__1"
	// InternalStructuredTextParser.g:6863:1: rule__Func_Call__Group_2_1__1 :
	// rule__Func_Call__Group_2_1__1__Impl ;
	public final void rule__Func_Call__Group_2_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6867:1: ( rule__Func_Call__Group_2_1__1__Impl
			// )
			// InternalStructuredTextParser.g:6868:2: rule__Func_Call__Group_2_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Func_Call__Group_2_1__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2_1__1"

	// $ANTLR start "rule__Func_Call__Group_2_1__1__Impl"
	// InternalStructuredTextParser.g:6874:1: rule__Func_Call__Group_2_1__1__Impl :
	// ( ( rule__Func_Call__ArgsAssignment_2_1_1 ) ) ;
	public final void rule__Func_Call__Group_2_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6878:1: ( ( (
			// rule__Func_Call__ArgsAssignment_2_1_1 ) ) )
			// InternalStructuredTextParser.g:6879:1: ( (
			// rule__Func_Call__ArgsAssignment_2_1_1 ) )
			{
				// InternalStructuredTextParser.g:6879:1: ( (
				// rule__Func_Call__ArgsAssignment_2_1_1 ) )
				// InternalStructuredTextParser.g:6880:2: (
				// rule__Func_Call__ArgsAssignment_2_1_1 )
				{
					before(grammarAccess.getFunc_CallAccess().getArgsAssignment_2_1_1());
					// InternalStructuredTextParser.g:6881:2: (
					// rule__Func_Call__ArgsAssignment_2_1_1 )
					// InternalStructuredTextParser.g:6881:3: rule__Func_Call__ArgsAssignment_2_1_1
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__ArgsAssignment_2_1_1();

						state._fsp--;

					}

					after(grammarAccess.getFunc_CallAccess().getArgsAssignment_2_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__Group_2_1__1__Impl"

	// $ANTLR start "rule__Param_Assign_In__Group__0"
	// InternalStructuredTextParser.g:6890:1: rule__Param_Assign_In__Group__0 :
	// rule__Param_Assign_In__Group__0__Impl rule__Param_Assign_In__Group__1 ;
	public final void rule__Param_Assign_In__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6894:1: (
			// rule__Param_Assign_In__Group__0__Impl rule__Param_Assign_In__Group__1 )
			// InternalStructuredTextParser.g:6895:2: rule__Param_Assign_In__Group__0__Impl
			// rule__Param_Assign_In__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__Param_Assign_In__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Param_Assign_In__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group__0"

	// $ANTLR start "rule__Param_Assign_In__Group__0__Impl"
	// InternalStructuredTextParser.g:6902:1: rule__Param_Assign_In__Group__0__Impl
	// : ( ( rule__Param_Assign_In__Group_0__0 )? ) ;
	public final void rule__Param_Assign_In__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6906:1: ( ( (
			// rule__Param_Assign_In__Group_0__0 )? ) )
			// InternalStructuredTextParser.g:6907:1: ( ( rule__Param_Assign_In__Group_0__0
			// )? )
			{
				// InternalStructuredTextParser.g:6907:1: ( ( rule__Param_Assign_In__Group_0__0
				// )? )
				// InternalStructuredTextParser.g:6908:2: ( rule__Param_Assign_In__Group_0__0 )?
				{
					before(grammarAccess.getParam_Assign_InAccess().getGroup_0());
					// InternalStructuredTextParser.g:6909:2: ( rule__Param_Assign_In__Group_0__0 )?
					int alt58 = 2;
					int LA58_0 = input.LA(1);

					if ((LA58_0 == RULE_ID)) {
						int LA58_1 = input.LA(2);

						if ((LA58_1 == ColonEqualsSign)) {
							alt58 = 1;
						}
					}
					switch (alt58) {
					case 1:
					// InternalStructuredTextParser.g:6909:3: rule__Param_Assign_In__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_In__Group_0__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getParam_Assign_InAccess().getGroup_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group__0__Impl"

	// $ANTLR start "rule__Param_Assign_In__Group__1"
	// InternalStructuredTextParser.g:6917:1: rule__Param_Assign_In__Group__1 :
	// rule__Param_Assign_In__Group__1__Impl ;
	public final void rule__Param_Assign_In__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6921:1: (
			// rule__Param_Assign_In__Group__1__Impl )
			// InternalStructuredTextParser.g:6922:2: rule__Param_Assign_In__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Param_Assign_In__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group__1"

	// $ANTLR start "rule__Param_Assign_In__Group__1__Impl"
	// InternalStructuredTextParser.g:6928:1: rule__Param_Assign_In__Group__1__Impl
	// : ( ( rule__Param_Assign_In__ExprAssignment_1 ) ) ;
	public final void rule__Param_Assign_In__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6932:1: ( ( (
			// rule__Param_Assign_In__ExprAssignment_1 ) ) )
			// InternalStructuredTextParser.g:6933:1: ( (
			// rule__Param_Assign_In__ExprAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:6933:1: ( (
				// rule__Param_Assign_In__ExprAssignment_1 ) )
				// InternalStructuredTextParser.g:6934:2: (
				// rule__Param_Assign_In__ExprAssignment_1 )
				{
					before(grammarAccess.getParam_Assign_InAccess().getExprAssignment_1());
					// InternalStructuredTextParser.g:6935:2: (
					// rule__Param_Assign_In__ExprAssignment_1 )
					// InternalStructuredTextParser.g:6935:3:
					// rule__Param_Assign_In__ExprAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_In__ExprAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_InAccess().getExprAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group__1__Impl"

	// $ANTLR start "rule__Param_Assign_In__Group_0__0"
	// InternalStructuredTextParser.g:6944:1: rule__Param_Assign_In__Group_0__0 :
	// rule__Param_Assign_In__Group_0__0__Impl rule__Param_Assign_In__Group_0__1 ;
	public final void rule__Param_Assign_In__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6948:1: (
			// rule__Param_Assign_In__Group_0__0__Impl rule__Param_Assign_In__Group_0__1 )
			// InternalStructuredTextParser.g:6949:2:
			// rule__Param_Assign_In__Group_0__0__Impl rule__Param_Assign_In__Group_0__1
			{
				pushFollow(FOLLOW_16);
				rule__Param_Assign_In__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Param_Assign_In__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group_0__0"

	// $ANTLR start "rule__Param_Assign_In__Group_0__0__Impl"
	// InternalStructuredTextParser.g:6956:1:
	// rule__Param_Assign_In__Group_0__0__Impl : ( (
	// rule__Param_Assign_In__VarAssignment_0_0 ) ) ;
	public final void rule__Param_Assign_In__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6960:1: ( ( (
			// rule__Param_Assign_In__VarAssignment_0_0 ) ) )
			// InternalStructuredTextParser.g:6961:1: ( (
			// rule__Param_Assign_In__VarAssignment_0_0 ) )
			{
				// InternalStructuredTextParser.g:6961:1: ( (
				// rule__Param_Assign_In__VarAssignment_0_0 ) )
				// InternalStructuredTextParser.g:6962:2: (
				// rule__Param_Assign_In__VarAssignment_0_0 )
				{
					before(grammarAccess.getParam_Assign_InAccess().getVarAssignment_0_0());
					// InternalStructuredTextParser.g:6963:2: (
					// rule__Param_Assign_In__VarAssignment_0_0 )
					// InternalStructuredTextParser.g:6963:3:
					// rule__Param_Assign_In__VarAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_In__VarAssignment_0_0();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_InAccess().getVarAssignment_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group_0__0__Impl"

	// $ANTLR start "rule__Param_Assign_In__Group_0__1"
	// InternalStructuredTextParser.g:6971:1: rule__Param_Assign_In__Group_0__1 :
	// rule__Param_Assign_In__Group_0__1__Impl ;
	public final void rule__Param_Assign_In__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6975:1: (
			// rule__Param_Assign_In__Group_0__1__Impl )
			// InternalStructuredTextParser.g:6976:2:
			// rule__Param_Assign_In__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Param_Assign_In__Group_0__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group_0__1"

	// $ANTLR start "rule__Param_Assign_In__Group_0__1__Impl"
	// InternalStructuredTextParser.g:6982:1:
	// rule__Param_Assign_In__Group_0__1__Impl : ( ColonEqualsSign ) ;
	public final void rule__Param_Assign_In__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:6986:1: ( ( ColonEqualsSign ) )
			// InternalStructuredTextParser.g:6987:1: ( ColonEqualsSign )
			{
				// InternalStructuredTextParser.g:6987:1: ( ColonEqualsSign )
				// InternalStructuredTextParser.g:6988:2: ColonEqualsSign
				{
					before(grammarAccess.getParam_Assign_InAccess().getColonEqualsSignKeyword_0_1());
					match(input, ColonEqualsSign, FOLLOW_2);
					after(grammarAccess.getParam_Assign_InAccess().getColonEqualsSignKeyword_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__Group_0__1__Impl"

	// $ANTLR start "rule__Param_Assign_Out__Group__0"
	// InternalStructuredTextParser.g:6998:1: rule__Param_Assign_Out__Group__0 :
	// rule__Param_Assign_Out__Group__0__Impl rule__Param_Assign_Out__Group__1 ;
	public final void rule__Param_Assign_Out__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7002:1: (
			// rule__Param_Assign_Out__Group__0__Impl rule__Param_Assign_Out__Group__1 )
			// InternalStructuredTextParser.g:7003:2: rule__Param_Assign_Out__Group__0__Impl
			// rule__Param_Assign_Out__Group__1
			{
				pushFollow(FOLLOW_17);
				rule__Param_Assign_Out__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Param_Assign_Out__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__0"

	// $ANTLR start "rule__Param_Assign_Out__Group__0__Impl"
	// InternalStructuredTextParser.g:7010:1: rule__Param_Assign_Out__Group__0__Impl
	// : ( ( rule__Param_Assign_Out__NotAssignment_0 )? ) ;
	public final void rule__Param_Assign_Out__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7014:1: ( ( (
			// rule__Param_Assign_Out__NotAssignment_0 )? ) )
			// InternalStructuredTextParser.g:7015:1: ( (
			// rule__Param_Assign_Out__NotAssignment_0 )? )
			{
				// InternalStructuredTextParser.g:7015:1: ( (
				// rule__Param_Assign_Out__NotAssignment_0 )? )
				// InternalStructuredTextParser.g:7016:2: (
				// rule__Param_Assign_Out__NotAssignment_0 )?
				{
					before(grammarAccess.getParam_Assign_OutAccess().getNotAssignment_0());
					// InternalStructuredTextParser.g:7017:2: (
					// rule__Param_Assign_Out__NotAssignment_0 )?
					int alt59 = 2;
					int LA59_0 = input.LA(1);

					if ((LA59_0 == NOT)) {
						alt59 = 1;
					}
					switch (alt59) {
					case 1:
					// InternalStructuredTextParser.g:7017:3:
					// rule__Param_Assign_Out__NotAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_Out__NotAssignment_0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getParam_Assign_OutAccess().getNotAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__0__Impl"

	// $ANTLR start "rule__Param_Assign_Out__Group__1"
	// InternalStructuredTextParser.g:7025:1: rule__Param_Assign_Out__Group__1 :
	// rule__Param_Assign_Out__Group__1__Impl rule__Param_Assign_Out__Group__2 ;
	public final void rule__Param_Assign_Out__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7029:1: (
			// rule__Param_Assign_Out__Group__1__Impl rule__Param_Assign_Out__Group__2 )
			// InternalStructuredTextParser.g:7030:2: rule__Param_Assign_Out__Group__1__Impl
			// rule__Param_Assign_Out__Group__2
			{
				pushFollow(FOLLOW_60);
				rule__Param_Assign_Out__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Param_Assign_Out__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__1"

	// $ANTLR start "rule__Param_Assign_Out__Group__1__Impl"
	// InternalStructuredTextParser.g:7037:1: rule__Param_Assign_Out__Group__1__Impl
	// : ( ( rule__Param_Assign_Out__VarAssignment_1 ) ) ;
	public final void rule__Param_Assign_Out__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7041:1: ( ( (
			// rule__Param_Assign_Out__VarAssignment_1 ) ) )
			// InternalStructuredTextParser.g:7042:1: ( (
			// rule__Param_Assign_Out__VarAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:7042:1: ( (
				// rule__Param_Assign_Out__VarAssignment_1 ) )
				// InternalStructuredTextParser.g:7043:2: (
				// rule__Param_Assign_Out__VarAssignment_1 )
				{
					before(grammarAccess.getParam_Assign_OutAccess().getVarAssignment_1());
					// InternalStructuredTextParser.g:7044:2: (
					// rule__Param_Assign_Out__VarAssignment_1 )
					// InternalStructuredTextParser.g:7044:3:
					// rule__Param_Assign_Out__VarAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_Out__VarAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_OutAccess().getVarAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__1__Impl"

	// $ANTLR start "rule__Param_Assign_Out__Group__2"
	// InternalStructuredTextParser.g:7052:1: rule__Param_Assign_Out__Group__2 :
	// rule__Param_Assign_Out__Group__2__Impl rule__Param_Assign_Out__Group__3 ;
	public final void rule__Param_Assign_Out__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7056:1: (
			// rule__Param_Assign_Out__Group__2__Impl rule__Param_Assign_Out__Group__3 )
			// InternalStructuredTextParser.g:7057:2: rule__Param_Assign_Out__Group__2__Impl
			// rule__Param_Assign_Out__Group__3
			{
				pushFollow(FOLLOW_32);
				rule__Param_Assign_Out__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Param_Assign_Out__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__2"

	// $ANTLR start "rule__Param_Assign_Out__Group__2__Impl"
	// InternalStructuredTextParser.g:7064:1: rule__Param_Assign_Out__Group__2__Impl
	// : ( EqualsSignGreaterThanSign ) ;
	public final void rule__Param_Assign_Out__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7068:1: ( ( EqualsSignGreaterThanSign ) )
			// InternalStructuredTextParser.g:7069:1: ( EqualsSignGreaterThanSign )
			{
				// InternalStructuredTextParser.g:7069:1: ( EqualsSignGreaterThanSign )
				// InternalStructuredTextParser.g:7070:2: EqualsSignGreaterThanSign
				{
					before(grammarAccess.getParam_Assign_OutAccess().getEqualsSignGreaterThanSignKeyword_2());
					match(input, EqualsSignGreaterThanSign, FOLLOW_2);
					after(grammarAccess.getParam_Assign_OutAccess().getEqualsSignGreaterThanSignKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__2__Impl"

	// $ANTLR start "rule__Param_Assign_Out__Group__3"
	// InternalStructuredTextParser.g:7079:1: rule__Param_Assign_Out__Group__3 :
	// rule__Param_Assign_Out__Group__3__Impl ;
	public final void rule__Param_Assign_Out__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7083:1: (
			// rule__Param_Assign_Out__Group__3__Impl )
			// InternalStructuredTextParser.g:7084:2: rule__Param_Assign_Out__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Param_Assign_Out__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__3"

	// $ANTLR start "rule__Param_Assign_Out__Group__3__Impl"
	// InternalStructuredTextParser.g:7090:1: rule__Param_Assign_Out__Group__3__Impl
	// : ( ( rule__Param_Assign_Out__ExprAssignment_3 ) ) ;
	public final void rule__Param_Assign_Out__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7094:1: ( ( (
			// rule__Param_Assign_Out__ExprAssignment_3 ) ) )
			// InternalStructuredTextParser.g:7095:1: ( (
			// rule__Param_Assign_Out__ExprAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:7095:1: ( (
				// rule__Param_Assign_Out__ExprAssignment_3 ) )
				// InternalStructuredTextParser.g:7096:2: (
				// rule__Param_Assign_Out__ExprAssignment_3 )
				{
					before(grammarAccess.getParam_Assign_OutAccess().getExprAssignment_3());
					// InternalStructuredTextParser.g:7097:2: (
					// rule__Param_Assign_Out__ExprAssignment_3 )
					// InternalStructuredTextParser.g:7097:3:
					// rule__Param_Assign_Out__ExprAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__Param_Assign_Out__ExprAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getParam_Assign_OutAccess().getExprAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__Group__3__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group__0"
	// InternalStructuredTextParser.g:7106:1: rule__Variable_Subscript__Group__0 :
	// rule__Variable_Subscript__Group__0__Impl rule__Variable_Subscript__Group__1 ;
	public final void rule__Variable_Subscript__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7110:1: (
			// rule__Variable_Subscript__Group__0__Impl rule__Variable_Subscript__Group__1 )
			// InternalStructuredTextParser.g:7111:2:
			// rule__Variable_Subscript__Group__0__Impl rule__Variable_Subscript__Group__1
			{
				pushFollow(FOLLOW_61);
				rule__Variable_Subscript__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group__0"

	// $ANTLR start "rule__Variable_Subscript__Group__0__Impl"
	// InternalStructuredTextParser.g:7118:1:
	// rule__Variable_Subscript__Group__0__Impl : ( (
	// rule__Variable_Subscript__Alternatives_0 ) ) ;
	public final void rule__Variable_Subscript__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7122:1: ( ( (
			// rule__Variable_Subscript__Alternatives_0 ) ) )
			// InternalStructuredTextParser.g:7123:1: ( (
			// rule__Variable_Subscript__Alternatives_0 ) )
			{
				// InternalStructuredTextParser.g:7123:1: ( (
				// rule__Variable_Subscript__Alternatives_0 ) )
				// InternalStructuredTextParser.g:7124:2: (
				// rule__Variable_Subscript__Alternatives_0 )
				{
					before(grammarAccess.getVariable_SubscriptAccess().getAlternatives_0());
					// InternalStructuredTextParser.g:7125:2: (
					// rule__Variable_Subscript__Alternatives_0 )
					// InternalStructuredTextParser.g:7125:3:
					// rule__Variable_Subscript__Alternatives_0
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Subscript__Alternatives_0();

						state._fsp--;

					}

					after(grammarAccess.getVariable_SubscriptAccess().getAlternatives_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group__0__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group__1"
	// InternalStructuredTextParser.g:7133:1: rule__Variable_Subscript__Group__1 :
	// rule__Variable_Subscript__Group__1__Impl ;
	public final void rule__Variable_Subscript__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7137:1: (
			// rule__Variable_Subscript__Group__1__Impl )
			// InternalStructuredTextParser.g:7138:2:
			// rule__Variable_Subscript__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group__1"

	// $ANTLR start "rule__Variable_Subscript__Group__1__Impl"
	// InternalStructuredTextParser.g:7144:1:
	// rule__Variable_Subscript__Group__1__Impl : ( (
	// rule__Variable_Subscript__Group_1__0 )? ) ;
	public final void rule__Variable_Subscript__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7148:1: ( ( (
			// rule__Variable_Subscript__Group_1__0 )? ) )
			// InternalStructuredTextParser.g:7149:1: ( (
			// rule__Variable_Subscript__Group_1__0 )? )
			{
				// InternalStructuredTextParser.g:7149:1: ( (
				// rule__Variable_Subscript__Group_1__0 )? )
				// InternalStructuredTextParser.g:7150:2: ( rule__Variable_Subscript__Group_1__0
				// )?
				{
					before(grammarAccess.getVariable_SubscriptAccess().getGroup_1());
					// InternalStructuredTextParser.g:7151:2: ( rule__Variable_Subscript__Group_1__0
					// )?
					int alt60 = 2;
					int LA60_0 = input.LA(1);

					if ((LA60_0 == LeftSquareBracket)) {
						alt60 = 1;
					}
					switch (alt60) {
					case 1:
					// InternalStructuredTextParser.g:7151:3: rule__Variable_Subscript__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Subscript__Group_1__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getVariable_SubscriptAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group__1__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1__0"
	// InternalStructuredTextParser.g:7160:1: rule__Variable_Subscript__Group_1__0 :
	// rule__Variable_Subscript__Group_1__0__Impl
	// rule__Variable_Subscript__Group_1__1 ;
	public final void rule__Variable_Subscript__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7164:1: (
			// rule__Variable_Subscript__Group_1__0__Impl
			// rule__Variable_Subscript__Group_1__1 )
			// InternalStructuredTextParser.g:7165:2:
			// rule__Variable_Subscript__Group_1__0__Impl
			// rule__Variable_Subscript__Group_1__1
			{
				pushFollow(FOLLOW_61);
				rule__Variable_Subscript__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__0"

	// $ANTLR start "rule__Variable_Subscript__Group_1__0__Impl"
	// InternalStructuredTextParser.g:7172:1:
	// rule__Variable_Subscript__Group_1__0__Impl : ( () ) ;
	public final void rule__Variable_Subscript__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7176:1: ( ( () ) )
			// InternalStructuredTextParser.g:7177:1: ( () )
			{
				// InternalStructuredTextParser.g:7177:1: ( () )
				// InternalStructuredTextParser.g:7178:2: ()
				{
					before(grammarAccess.getVariable_SubscriptAccess().getArrayVariableArrayAction_1_0());
					// InternalStructuredTextParser.g:7179:2: ()
					// InternalStructuredTextParser.g:7179:3:
					{
					}

					after(grammarAccess.getVariable_SubscriptAccess().getArrayVariableArrayAction_1_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__0__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1__1"
	// InternalStructuredTextParser.g:7187:1: rule__Variable_Subscript__Group_1__1 :
	// rule__Variable_Subscript__Group_1__1__Impl
	// rule__Variable_Subscript__Group_1__2 ;
	public final void rule__Variable_Subscript__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7191:1: (
			// rule__Variable_Subscript__Group_1__1__Impl
			// rule__Variable_Subscript__Group_1__2 )
			// InternalStructuredTextParser.g:7192:2:
			// rule__Variable_Subscript__Group_1__1__Impl
			// rule__Variable_Subscript__Group_1__2
			{
				pushFollow(FOLLOW_17);
				rule__Variable_Subscript__Group_1__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__1"

	// $ANTLR start "rule__Variable_Subscript__Group_1__1__Impl"
	// InternalStructuredTextParser.g:7199:1:
	// rule__Variable_Subscript__Group_1__1__Impl : ( LeftSquareBracket ) ;
	public final void rule__Variable_Subscript__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7203:1: ( ( LeftSquareBracket ) )
			// InternalStructuredTextParser.g:7204:1: ( LeftSquareBracket )
			{
				// InternalStructuredTextParser.g:7204:1: ( LeftSquareBracket )
				// InternalStructuredTextParser.g:7205:2: LeftSquareBracket
				{
					before(grammarAccess.getVariable_SubscriptAccess().getLeftSquareBracketKeyword_1_1());
					match(input, LeftSquareBracket, FOLLOW_2);
					after(grammarAccess.getVariable_SubscriptAccess().getLeftSquareBracketKeyword_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__1__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1__2"
	// InternalStructuredTextParser.g:7214:1: rule__Variable_Subscript__Group_1__2 :
	// rule__Variable_Subscript__Group_1__2__Impl
	// rule__Variable_Subscript__Group_1__3 ;
	public final void rule__Variable_Subscript__Group_1__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7218:1: (
			// rule__Variable_Subscript__Group_1__2__Impl
			// rule__Variable_Subscript__Group_1__3 )
			// InternalStructuredTextParser.g:7219:2:
			// rule__Variable_Subscript__Group_1__2__Impl
			// rule__Variable_Subscript__Group_1__3
			{
				pushFollow(FOLLOW_62);
				rule__Variable_Subscript__Group_1__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__2"

	// $ANTLR start "rule__Variable_Subscript__Group_1__2__Impl"
	// InternalStructuredTextParser.g:7226:1:
	// rule__Variable_Subscript__Group_1__2__Impl : ( (
	// rule__Variable_Subscript__IndexAssignment_1_2 ) ) ;
	public final void rule__Variable_Subscript__Group_1__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7230:1: ( ( (
			// rule__Variable_Subscript__IndexAssignment_1_2 ) ) )
			// InternalStructuredTextParser.g:7231:1: ( (
			// rule__Variable_Subscript__IndexAssignment_1_2 ) )
			{
				// InternalStructuredTextParser.g:7231:1: ( (
				// rule__Variable_Subscript__IndexAssignment_1_2 ) )
				// InternalStructuredTextParser.g:7232:2: (
				// rule__Variable_Subscript__IndexAssignment_1_2 )
				{
					before(grammarAccess.getVariable_SubscriptAccess().getIndexAssignment_1_2());
					// InternalStructuredTextParser.g:7233:2: (
					// rule__Variable_Subscript__IndexAssignment_1_2 )
					// InternalStructuredTextParser.g:7233:3:
					// rule__Variable_Subscript__IndexAssignment_1_2
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Subscript__IndexAssignment_1_2();

						state._fsp--;

					}

					after(grammarAccess.getVariable_SubscriptAccess().getIndexAssignment_1_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__2__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1__3"
	// InternalStructuredTextParser.g:7241:1: rule__Variable_Subscript__Group_1__3 :
	// rule__Variable_Subscript__Group_1__3__Impl
	// rule__Variable_Subscript__Group_1__4 ;
	public final void rule__Variable_Subscript__Group_1__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7245:1: (
			// rule__Variable_Subscript__Group_1__3__Impl
			// rule__Variable_Subscript__Group_1__4 )
			// InternalStructuredTextParser.g:7246:2:
			// rule__Variable_Subscript__Group_1__3__Impl
			// rule__Variable_Subscript__Group_1__4
			{
				pushFollow(FOLLOW_62);
				rule__Variable_Subscript__Group_1__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__3"

	// $ANTLR start "rule__Variable_Subscript__Group_1__3__Impl"
	// InternalStructuredTextParser.g:7253:1:
	// rule__Variable_Subscript__Group_1__3__Impl : ( (
	// rule__Variable_Subscript__Group_1_3__0 )* ) ;
	public final void rule__Variable_Subscript__Group_1__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7257:1: ( ( (
			// rule__Variable_Subscript__Group_1_3__0 )* ) )
			// InternalStructuredTextParser.g:7258:1: ( (
			// rule__Variable_Subscript__Group_1_3__0 )* )
			{
				// InternalStructuredTextParser.g:7258:1: ( (
				// rule__Variable_Subscript__Group_1_3__0 )* )
				// InternalStructuredTextParser.g:7259:2: (
				// rule__Variable_Subscript__Group_1_3__0 )*
				{
					before(grammarAccess.getVariable_SubscriptAccess().getGroup_1_3());
					// InternalStructuredTextParser.g:7260:2: (
					// rule__Variable_Subscript__Group_1_3__0 )*
					loop61: do {
						int alt61 = 2;
						int LA61_0 = input.LA(1);

						if ((LA61_0 == Comma)) {
							alt61 = 1;
						}

						switch (alt61) {
						case 1:
						// InternalStructuredTextParser.g:7260:3: rule__Variable_Subscript__Group_1_3__0
						{
							pushFollow(FOLLOW_29);
							rule__Variable_Subscript__Group_1_3__0();

							state._fsp--;

						}
							break;

						default:
							break loop61;
						}
					} while (true);

					after(grammarAccess.getVariable_SubscriptAccess().getGroup_1_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__3__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1__4"
	// InternalStructuredTextParser.g:7268:1: rule__Variable_Subscript__Group_1__4 :
	// rule__Variable_Subscript__Group_1__4__Impl ;
	public final void rule__Variable_Subscript__Group_1__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7272:1: (
			// rule__Variable_Subscript__Group_1__4__Impl )
			// InternalStructuredTextParser.g:7273:2:
			// rule__Variable_Subscript__Group_1__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__4"

	// $ANTLR start "rule__Variable_Subscript__Group_1__4__Impl"
	// InternalStructuredTextParser.g:7279:1:
	// rule__Variable_Subscript__Group_1__4__Impl : ( RightSquareBracket ) ;
	public final void rule__Variable_Subscript__Group_1__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7283:1: ( ( RightSquareBracket ) )
			// InternalStructuredTextParser.g:7284:1: ( RightSquareBracket )
			{
				// InternalStructuredTextParser.g:7284:1: ( RightSquareBracket )
				// InternalStructuredTextParser.g:7285:2: RightSquareBracket
				{
					before(grammarAccess.getVariable_SubscriptAccess().getRightSquareBracketKeyword_1_4());
					match(input, RightSquareBracket, FOLLOW_2);
					after(grammarAccess.getVariable_SubscriptAccess().getRightSquareBracketKeyword_1_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1__4__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1_3__0"
	// InternalStructuredTextParser.g:7295:1: rule__Variable_Subscript__Group_1_3__0
	// : rule__Variable_Subscript__Group_1_3__0__Impl
	// rule__Variable_Subscript__Group_1_3__1 ;
	public final void rule__Variable_Subscript__Group_1_3__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7299:1: (
			// rule__Variable_Subscript__Group_1_3__0__Impl
			// rule__Variable_Subscript__Group_1_3__1 )
			// InternalStructuredTextParser.g:7300:2:
			// rule__Variable_Subscript__Group_1_3__0__Impl
			// rule__Variable_Subscript__Group_1_3__1
			{
				pushFollow(FOLLOW_17);
				rule__Variable_Subscript__Group_1_3__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1_3__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1_3__0"

	// $ANTLR start "rule__Variable_Subscript__Group_1_3__0__Impl"
	// InternalStructuredTextParser.g:7307:1:
	// rule__Variable_Subscript__Group_1_3__0__Impl : ( Comma ) ;
	public final void rule__Variable_Subscript__Group_1_3__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7311:1: ( ( Comma ) )
			// InternalStructuredTextParser.g:7312:1: ( Comma )
			{
				// InternalStructuredTextParser.g:7312:1: ( Comma )
				// InternalStructuredTextParser.g:7313:2: Comma
				{
					before(grammarAccess.getVariable_SubscriptAccess().getCommaKeyword_1_3_0());
					match(input, Comma, FOLLOW_2);
					after(grammarAccess.getVariable_SubscriptAccess().getCommaKeyword_1_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1_3__0__Impl"

	// $ANTLR start "rule__Variable_Subscript__Group_1_3__1"
	// InternalStructuredTextParser.g:7322:1: rule__Variable_Subscript__Group_1_3__1
	// : rule__Variable_Subscript__Group_1_3__1__Impl ;
	public final void rule__Variable_Subscript__Group_1_3__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7326:1: (
			// rule__Variable_Subscript__Group_1_3__1__Impl )
			// InternalStructuredTextParser.g:7327:2:
			// rule__Variable_Subscript__Group_1_3__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Variable_Subscript__Group_1_3__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1_3__1"

	// $ANTLR start "rule__Variable_Subscript__Group_1_3__1__Impl"
	// InternalStructuredTextParser.g:7333:1:
	// rule__Variable_Subscript__Group_1_3__1__Impl : ( (
	// rule__Variable_Subscript__IndexAssignment_1_3_1 ) ) ;
	public final void rule__Variable_Subscript__Group_1_3__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7337:1: ( ( (
			// rule__Variable_Subscript__IndexAssignment_1_3_1 ) ) )
			// InternalStructuredTextParser.g:7338:1: ( (
			// rule__Variable_Subscript__IndexAssignment_1_3_1 ) )
			{
				// InternalStructuredTextParser.g:7338:1: ( (
				// rule__Variable_Subscript__IndexAssignment_1_3_1 ) )
				// InternalStructuredTextParser.g:7339:2: (
				// rule__Variable_Subscript__IndexAssignment_1_3_1 )
				{
					before(grammarAccess.getVariable_SubscriptAccess().getIndexAssignment_1_3_1());
					// InternalStructuredTextParser.g:7340:2: (
					// rule__Variable_Subscript__IndexAssignment_1_3_1 )
					// InternalStructuredTextParser.g:7340:3:
					// rule__Variable_Subscript__IndexAssignment_1_3_1
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Subscript__IndexAssignment_1_3_1();

						state._fsp--;

					}

					after(grammarAccess.getVariable_SubscriptAccess().getIndexAssignment_1_3_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__Group_1_3__1__Impl"

	// $ANTLR start "rule__Variable_Adapter__Group__0"
	// InternalStructuredTextParser.g:7349:1: rule__Variable_Adapter__Group__0 :
	// rule__Variable_Adapter__Group__0__Impl rule__Variable_Adapter__Group__1 ;
	public final void rule__Variable_Adapter__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7353:1: (
			// rule__Variable_Adapter__Group__0__Impl rule__Variable_Adapter__Group__1 )
			// InternalStructuredTextParser.g:7354:2: rule__Variable_Adapter__Group__0__Impl
			// rule__Variable_Adapter__Group__1
			{
				pushFollow(FOLLOW_32);
				rule__Variable_Adapter__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Adapter__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__0"

	// $ANTLR start "rule__Variable_Adapter__Group__0__Impl"
	// InternalStructuredTextParser.g:7361:1: rule__Variable_Adapter__Group__0__Impl
	// : ( () ) ;
	public final void rule__Variable_Adapter__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7365:1: ( ( () ) )
			// InternalStructuredTextParser.g:7366:1: ( () )
			{
				// InternalStructuredTextParser.g:7366:1: ( () )
				// InternalStructuredTextParser.g:7367:2: ()
				{
					before(grammarAccess.getVariable_AdapterAccess().getAdapterVariableAction_0());
					// InternalStructuredTextParser.g:7368:2: ()
					// InternalStructuredTextParser.g:7368:3:
					{
					}

					after(grammarAccess.getVariable_AdapterAccess().getAdapterVariableAction_0());

				}

			}

		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__0__Impl"

	// $ANTLR start "rule__Variable_Adapter__Group__1"
	// InternalStructuredTextParser.g:7376:1: rule__Variable_Adapter__Group__1 :
	// rule__Variable_Adapter__Group__1__Impl rule__Variable_Adapter__Group__2 ;
	public final void rule__Variable_Adapter__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7380:1: (
			// rule__Variable_Adapter__Group__1__Impl rule__Variable_Adapter__Group__2 )
			// InternalStructuredTextParser.g:7381:2: rule__Variable_Adapter__Group__1__Impl
			// rule__Variable_Adapter__Group__2
			{
				pushFollow(FOLLOW_63);
				rule__Variable_Adapter__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Adapter__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__1"

	// $ANTLR start "rule__Variable_Adapter__Group__1__Impl"
	// InternalStructuredTextParser.g:7388:1: rule__Variable_Adapter__Group__1__Impl
	// : ( ( rule__Variable_Adapter__AdapterAssignment_1 ) ) ;
	public final void rule__Variable_Adapter__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7392:1: ( ( (
			// rule__Variable_Adapter__AdapterAssignment_1 ) ) )
			// InternalStructuredTextParser.g:7393:1: ( (
			// rule__Variable_Adapter__AdapterAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:7393:1: ( (
				// rule__Variable_Adapter__AdapterAssignment_1 ) )
				// InternalStructuredTextParser.g:7394:2: (
				// rule__Variable_Adapter__AdapterAssignment_1 )
				{
					before(grammarAccess.getVariable_AdapterAccess().getAdapterAssignment_1());
					// InternalStructuredTextParser.g:7395:2: (
					// rule__Variable_Adapter__AdapterAssignment_1 )
					// InternalStructuredTextParser.g:7395:3:
					// rule__Variable_Adapter__AdapterAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Adapter__AdapterAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getVariable_AdapterAccess().getAdapterAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__1__Impl"

	// $ANTLR start "rule__Variable_Adapter__Group__2"
	// InternalStructuredTextParser.g:7403:1: rule__Variable_Adapter__Group__2 :
	// rule__Variable_Adapter__Group__2__Impl rule__Variable_Adapter__Group__3 ;
	public final void rule__Variable_Adapter__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7407:1: (
			// rule__Variable_Adapter__Group__2__Impl rule__Variable_Adapter__Group__3 )
			// InternalStructuredTextParser.g:7408:2: rule__Variable_Adapter__Group__2__Impl
			// rule__Variable_Adapter__Group__3
			{
				pushFollow(FOLLOW_32);
				rule__Variable_Adapter__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Variable_Adapter__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__2"

	// $ANTLR start "rule__Variable_Adapter__Group__2__Impl"
	// InternalStructuredTextParser.g:7415:1: rule__Variable_Adapter__Group__2__Impl
	// : ( FullStop ) ;
	public final void rule__Variable_Adapter__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7419:1: ( ( FullStop ) )
			// InternalStructuredTextParser.g:7420:1: ( FullStop )
			{
				// InternalStructuredTextParser.g:7420:1: ( FullStop )
				// InternalStructuredTextParser.g:7421:2: FullStop
				{
					before(grammarAccess.getVariable_AdapterAccess().getFullStopKeyword_2());
					match(input, FullStop, FOLLOW_2);
					after(grammarAccess.getVariable_AdapterAccess().getFullStopKeyword_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__2__Impl"

	// $ANTLR start "rule__Variable_Adapter__Group__3"
	// InternalStructuredTextParser.g:7430:1: rule__Variable_Adapter__Group__3 :
	// rule__Variable_Adapter__Group__3__Impl ;
	public final void rule__Variable_Adapter__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7434:1: (
			// rule__Variable_Adapter__Group__3__Impl )
			// InternalStructuredTextParser.g:7435:2: rule__Variable_Adapter__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Variable_Adapter__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__3"

	// $ANTLR start "rule__Variable_Adapter__Group__3__Impl"
	// InternalStructuredTextParser.g:7441:1: rule__Variable_Adapter__Group__3__Impl
	// : ( ( rule__Variable_Adapter__VarAssignment_3 ) ) ;
	public final void rule__Variable_Adapter__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7445:1: ( ( (
			// rule__Variable_Adapter__VarAssignment_3 ) ) )
			// InternalStructuredTextParser.g:7446:1: ( (
			// rule__Variable_Adapter__VarAssignment_3 ) )
			{
				// InternalStructuredTextParser.g:7446:1: ( (
				// rule__Variable_Adapter__VarAssignment_3 ) )
				// InternalStructuredTextParser.g:7447:2: (
				// rule__Variable_Adapter__VarAssignment_3 )
				{
					before(grammarAccess.getVariable_AdapterAccess().getVarAssignment_3());
					// InternalStructuredTextParser.g:7448:2: (
					// rule__Variable_Adapter__VarAssignment_3 )
					// InternalStructuredTextParser.g:7448:3:
					// rule__Variable_Adapter__VarAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__Variable_Adapter__VarAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getVariable_AdapterAccess().getVarAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__Group__3__Impl"

	// $ANTLR start "rule__Int_Literal__Group__0"
	// InternalStructuredTextParser.g:7457:1: rule__Int_Literal__Group__0 :
	// rule__Int_Literal__Group__0__Impl rule__Int_Literal__Group__1 ;
	public final void rule__Int_Literal__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7461:1: ( rule__Int_Literal__Group__0__Impl
			// rule__Int_Literal__Group__1 )
			// InternalStructuredTextParser.g:7462:2: rule__Int_Literal__Group__0__Impl
			// rule__Int_Literal__Group__1
			{
				pushFollow(FOLLOW_64);
				rule__Int_Literal__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Int_Literal__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group__0"

	// $ANTLR start "rule__Int_Literal__Group__0__Impl"
	// InternalStructuredTextParser.g:7469:1: rule__Int_Literal__Group__0__Impl : (
	// ( rule__Int_Literal__Group_0__0 )? ) ;
	public final void rule__Int_Literal__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7473:1: ( ( ( rule__Int_Literal__Group_0__0 )?
			// ) )
			// InternalStructuredTextParser.g:7474:1: ( ( rule__Int_Literal__Group_0__0 )? )
			{
				// InternalStructuredTextParser.g:7474:1: ( ( rule__Int_Literal__Group_0__0 )? )
				// InternalStructuredTextParser.g:7475:2: ( rule__Int_Literal__Group_0__0 )?
				{
					before(grammarAccess.getInt_LiteralAccess().getGroup_0());
					// InternalStructuredTextParser.g:7476:2: ( rule__Int_Literal__Group_0__0 )?
					int alt62 = 2;
					int LA62_0 = input.LA(1);

					if (((LA62_0 >= UDINT && LA62_0 <= ULINT) || LA62_0 == USINT || LA62_0 == DINT || LA62_0 == LINT
							|| LA62_0 == SINT || LA62_0 == UINT || LA62_0 == INT)) {
						alt62 = 1;
					}
					switch (alt62) {
					case 1:
					// InternalStructuredTextParser.g:7476:3: rule__Int_Literal__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Int_Literal__Group_0__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getInt_LiteralAccess().getGroup_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group__0__Impl"

	// $ANTLR start "rule__Int_Literal__Group__1"
	// InternalStructuredTextParser.g:7484:1: rule__Int_Literal__Group__1 :
	// rule__Int_Literal__Group__1__Impl ;
	public final void rule__Int_Literal__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7488:1: ( rule__Int_Literal__Group__1__Impl )
			// InternalStructuredTextParser.g:7489:2: rule__Int_Literal__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Int_Literal__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group__1"

	// $ANTLR start "rule__Int_Literal__Group__1__Impl"
	// InternalStructuredTextParser.g:7495:1: rule__Int_Literal__Group__1__Impl : (
	// ( rule__Int_Literal__ValueAssignment_1 ) ) ;
	public final void rule__Int_Literal__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7499:1: ( ( (
			// rule__Int_Literal__ValueAssignment_1 ) ) )
			// InternalStructuredTextParser.g:7500:1: ( (
			// rule__Int_Literal__ValueAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:7500:1: ( (
				// rule__Int_Literal__ValueAssignment_1 ) )
				// InternalStructuredTextParser.g:7501:2: ( rule__Int_Literal__ValueAssignment_1
				// )
				{
					before(grammarAccess.getInt_LiteralAccess().getValueAssignment_1());
					// InternalStructuredTextParser.g:7502:2: ( rule__Int_Literal__ValueAssignment_1
					// )
					// InternalStructuredTextParser.g:7502:3: rule__Int_Literal__ValueAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Int_Literal__ValueAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getInt_LiteralAccess().getValueAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group__1__Impl"

	// $ANTLR start "rule__Int_Literal__Group_0__0"
	// InternalStructuredTextParser.g:7511:1: rule__Int_Literal__Group_0__0 :
	// rule__Int_Literal__Group_0__0__Impl rule__Int_Literal__Group_0__1 ;
	public final void rule__Int_Literal__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7515:1: ( rule__Int_Literal__Group_0__0__Impl
			// rule__Int_Literal__Group_0__1 )
			// InternalStructuredTextParser.g:7516:2: rule__Int_Literal__Group_0__0__Impl
			// rule__Int_Literal__Group_0__1
			{
				pushFollow(FOLLOW_65);
				rule__Int_Literal__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Int_Literal__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group_0__0"

	// $ANTLR start "rule__Int_Literal__Group_0__0__Impl"
	// InternalStructuredTextParser.g:7523:1: rule__Int_Literal__Group_0__0__Impl :
	// ( ( rule__Int_Literal__TypeAssignment_0_0 ) ) ;
	public final void rule__Int_Literal__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7527:1: ( ( (
			// rule__Int_Literal__TypeAssignment_0_0 ) ) )
			// InternalStructuredTextParser.g:7528:1: ( (
			// rule__Int_Literal__TypeAssignment_0_0 ) )
			{
				// InternalStructuredTextParser.g:7528:1: ( (
				// rule__Int_Literal__TypeAssignment_0_0 ) )
				// InternalStructuredTextParser.g:7529:2: (
				// rule__Int_Literal__TypeAssignment_0_0 )
				{
					before(grammarAccess.getInt_LiteralAccess().getTypeAssignment_0_0());
					// InternalStructuredTextParser.g:7530:2: (
					// rule__Int_Literal__TypeAssignment_0_0 )
					// InternalStructuredTextParser.g:7530:3: rule__Int_Literal__TypeAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Int_Literal__TypeAssignment_0_0();

						state._fsp--;

					}

					after(grammarAccess.getInt_LiteralAccess().getTypeAssignment_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group_0__0__Impl"

	// $ANTLR start "rule__Int_Literal__Group_0__1"
	// InternalStructuredTextParser.g:7538:1: rule__Int_Literal__Group_0__1 :
	// rule__Int_Literal__Group_0__1__Impl ;
	public final void rule__Int_Literal__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7542:1: ( rule__Int_Literal__Group_0__1__Impl
			// )
			// InternalStructuredTextParser.g:7543:2: rule__Int_Literal__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Int_Literal__Group_0__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group_0__1"

	// $ANTLR start "rule__Int_Literal__Group_0__1__Impl"
	// InternalStructuredTextParser.g:7549:1: rule__Int_Literal__Group_0__1__Impl :
	// ( NumberSign ) ;
	public final void rule__Int_Literal__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7553:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:7554:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:7554:1: ( NumberSign )
				// InternalStructuredTextParser.g:7555:2: NumberSign
				{
					before(grammarAccess.getInt_LiteralAccess().getNumberSignKeyword_0_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getInt_LiteralAccess().getNumberSignKeyword_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__Group_0__1__Impl"

	// $ANTLR start "rule__Signed_Int__Group__0"
	// InternalStructuredTextParser.g:7565:1: rule__Signed_Int__Group__0 :
	// rule__Signed_Int__Group__0__Impl rule__Signed_Int__Group__1 ;
	public final void rule__Signed_Int__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7569:1: ( rule__Signed_Int__Group__0__Impl
			// rule__Signed_Int__Group__1 )
			// InternalStructuredTextParser.g:7570:2: rule__Signed_Int__Group__0__Impl
			// rule__Signed_Int__Group__1
			{
				pushFollow(FOLLOW_66);
				rule__Signed_Int__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Signed_Int__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Signed_Int__Group__0"

	// $ANTLR start "rule__Signed_Int__Group__0__Impl"
	// InternalStructuredTextParser.g:7577:1: rule__Signed_Int__Group__0__Impl : ( (
	// rule__Signed_Int__Alternatives_0 )? ) ;
	public final void rule__Signed_Int__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7581:1: ( ( ( rule__Signed_Int__Alternatives_0
			// )? ) )
			// InternalStructuredTextParser.g:7582:1: ( ( rule__Signed_Int__Alternatives_0
			// )? )
			{
				// InternalStructuredTextParser.g:7582:1: ( ( rule__Signed_Int__Alternatives_0
				// )? )
				// InternalStructuredTextParser.g:7583:2: ( rule__Signed_Int__Alternatives_0 )?
				{
					before(grammarAccess.getSigned_IntAccess().getAlternatives_0());
					// InternalStructuredTextParser.g:7584:2: ( rule__Signed_Int__Alternatives_0 )?
					int alt63 = 2;
					int LA63_0 = input.LA(1);

					if ((LA63_0 == PlusSign || LA63_0 == HyphenMinus)) {
						alt63 = 1;
					}
					switch (alt63) {
					case 1:
					// InternalStructuredTextParser.g:7584:3: rule__Signed_Int__Alternatives_0
					{
						pushFollow(FOLLOW_2);
						rule__Signed_Int__Alternatives_0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getSigned_IntAccess().getAlternatives_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Signed_Int__Group__0__Impl"

	// $ANTLR start "rule__Signed_Int__Group__1"
	// InternalStructuredTextParser.g:7592:1: rule__Signed_Int__Group__1 :
	// rule__Signed_Int__Group__1__Impl ;
	public final void rule__Signed_Int__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7596:1: ( rule__Signed_Int__Group__1__Impl )
			// InternalStructuredTextParser.g:7597:2: rule__Signed_Int__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Signed_Int__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Signed_Int__Group__1"

	// $ANTLR start "rule__Signed_Int__Group__1__Impl"
	// InternalStructuredTextParser.g:7603:1: rule__Signed_Int__Group__1__Impl : (
	// RULE_UNSIGNED_INT ) ;
	public final void rule__Signed_Int__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7607:1: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:7608:1: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:7608:1: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:7609:2: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getSigned_IntAccess().getUNSIGNED_INTTerminalRuleCall_1());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getSigned_IntAccess().getUNSIGNED_INTTerminalRuleCall_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Signed_Int__Group__1__Impl"

	// $ANTLR start "rule__Real_Literal__Group__0"
	// InternalStructuredTextParser.g:7619:1: rule__Real_Literal__Group__0 :
	// rule__Real_Literal__Group__0__Impl rule__Real_Literal__Group__1 ;
	public final void rule__Real_Literal__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7623:1: ( rule__Real_Literal__Group__0__Impl
			// rule__Real_Literal__Group__1 )
			// InternalStructuredTextParser.g:7624:2: rule__Real_Literal__Group__0__Impl
			// rule__Real_Literal__Group__1
			{
				pushFollow(FOLLOW_67);
				rule__Real_Literal__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Literal__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group__0"

	// $ANTLR start "rule__Real_Literal__Group__0__Impl"
	// InternalStructuredTextParser.g:7631:1: rule__Real_Literal__Group__0__Impl : (
	// ( rule__Real_Literal__Group_0__0 )? ) ;
	public final void rule__Real_Literal__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7635:1: ( ( ( rule__Real_Literal__Group_0__0
			// )? ) )
			// InternalStructuredTextParser.g:7636:1: ( ( rule__Real_Literal__Group_0__0 )?
			// )
			{
				// InternalStructuredTextParser.g:7636:1: ( ( rule__Real_Literal__Group_0__0 )?
				// )
				// InternalStructuredTextParser.g:7637:2: ( rule__Real_Literal__Group_0__0 )?
				{
					before(grammarAccess.getReal_LiteralAccess().getGroup_0());
					// InternalStructuredTextParser.g:7638:2: ( rule__Real_Literal__Group_0__0 )?
					int alt64 = 2;
					int LA64_0 = input.LA(1);

					if ((LA64_0 == LREAL || LA64_0 == REAL)) {
						alt64 = 1;
					}
					switch (alt64) {
					case 1:
					// InternalStructuredTextParser.g:7638:3: rule__Real_Literal__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Real_Literal__Group_0__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getReal_LiteralAccess().getGroup_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group__0__Impl"

	// $ANTLR start "rule__Real_Literal__Group__1"
	// InternalStructuredTextParser.g:7646:1: rule__Real_Literal__Group__1 :
	// rule__Real_Literal__Group__1__Impl ;
	public final void rule__Real_Literal__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7650:1: ( rule__Real_Literal__Group__1__Impl )
			// InternalStructuredTextParser.g:7651:2: rule__Real_Literal__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Real_Literal__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group__1"

	// $ANTLR start "rule__Real_Literal__Group__1__Impl"
	// InternalStructuredTextParser.g:7657:1: rule__Real_Literal__Group__1__Impl : (
	// ( rule__Real_Literal__ValueAssignment_1 ) ) ;
	public final void rule__Real_Literal__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7661:1: ( ( (
			// rule__Real_Literal__ValueAssignment_1 ) ) )
			// InternalStructuredTextParser.g:7662:1: ( (
			// rule__Real_Literal__ValueAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:7662:1: ( (
				// rule__Real_Literal__ValueAssignment_1 ) )
				// InternalStructuredTextParser.g:7663:2: (
				// rule__Real_Literal__ValueAssignment_1 )
				{
					before(grammarAccess.getReal_LiteralAccess().getValueAssignment_1());
					// InternalStructuredTextParser.g:7664:2: (
					// rule__Real_Literal__ValueAssignment_1 )
					// InternalStructuredTextParser.g:7664:3: rule__Real_Literal__ValueAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Real_Literal__ValueAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getReal_LiteralAccess().getValueAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group__1__Impl"

	// $ANTLR start "rule__Real_Literal__Group_0__0"
	// InternalStructuredTextParser.g:7673:1: rule__Real_Literal__Group_0__0 :
	// rule__Real_Literal__Group_0__0__Impl rule__Real_Literal__Group_0__1 ;
	public final void rule__Real_Literal__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7677:1: ( rule__Real_Literal__Group_0__0__Impl
			// rule__Real_Literal__Group_0__1 )
			// InternalStructuredTextParser.g:7678:2: rule__Real_Literal__Group_0__0__Impl
			// rule__Real_Literal__Group_0__1
			{
				pushFollow(FOLLOW_65);
				rule__Real_Literal__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Literal__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group_0__0"

	// $ANTLR start "rule__Real_Literal__Group_0__0__Impl"
	// InternalStructuredTextParser.g:7685:1: rule__Real_Literal__Group_0__0__Impl :
	// ( ( rule__Real_Literal__TypeAssignment_0_0 ) ) ;
	public final void rule__Real_Literal__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7689:1: ( ( (
			// rule__Real_Literal__TypeAssignment_0_0 ) ) )
			// InternalStructuredTextParser.g:7690:1: ( (
			// rule__Real_Literal__TypeAssignment_0_0 ) )
			{
				// InternalStructuredTextParser.g:7690:1: ( (
				// rule__Real_Literal__TypeAssignment_0_0 ) )
				// InternalStructuredTextParser.g:7691:2: (
				// rule__Real_Literal__TypeAssignment_0_0 )
				{
					before(grammarAccess.getReal_LiteralAccess().getTypeAssignment_0_0());
					// InternalStructuredTextParser.g:7692:2: (
					// rule__Real_Literal__TypeAssignment_0_0 )
					// InternalStructuredTextParser.g:7692:3: rule__Real_Literal__TypeAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Real_Literal__TypeAssignment_0_0();

						state._fsp--;

					}

					after(grammarAccess.getReal_LiteralAccess().getTypeAssignment_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group_0__0__Impl"

	// $ANTLR start "rule__Real_Literal__Group_0__1"
	// InternalStructuredTextParser.g:7700:1: rule__Real_Literal__Group_0__1 :
	// rule__Real_Literal__Group_0__1__Impl ;
	public final void rule__Real_Literal__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7704:1: ( rule__Real_Literal__Group_0__1__Impl
			// )
			// InternalStructuredTextParser.g:7705:2: rule__Real_Literal__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Real_Literal__Group_0__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group_0__1"

	// $ANTLR start "rule__Real_Literal__Group_0__1__Impl"
	// InternalStructuredTextParser.g:7711:1: rule__Real_Literal__Group_0__1__Impl :
	// ( NumberSign ) ;
	public final void rule__Real_Literal__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7715:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:7716:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:7716:1: ( NumberSign )
				// InternalStructuredTextParser.g:7717:2: NumberSign
				{
					before(grammarAccess.getReal_LiteralAccess().getNumberSignKeyword_0_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getReal_LiteralAccess().getNumberSignKeyword_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__Group_0__1__Impl"

	// $ANTLR start "rule__Real_Value__Group__0"
	// InternalStructuredTextParser.g:7727:1: rule__Real_Value__Group__0 :
	// rule__Real_Value__Group__0__Impl rule__Real_Value__Group__1 ;
	public final void rule__Real_Value__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7731:1: ( rule__Real_Value__Group__0__Impl
			// rule__Real_Value__Group__1 )
			// InternalStructuredTextParser.g:7732:2: rule__Real_Value__Group__0__Impl
			// rule__Real_Value__Group__1
			{
				pushFollow(FOLLOW_63);
				rule__Real_Value__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Value__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__0"

	// $ANTLR start "rule__Real_Value__Group__0__Impl"
	// InternalStructuredTextParser.g:7739:1: rule__Real_Value__Group__0__Impl : (
	// ruleSigned_Int ) ;
	public final void rule__Real_Value__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7743:1: ( ( ruleSigned_Int ) )
			// InternalStructuredTextParser.g:7744:1: ( ruleSigned_Int )
			{
				// InternalStructuredTextParser.g:7744:1: ( ruleSigned_Int )
				// InternalStructuredTextParser.g:7745:2: ruleSigned_Int
				{
					before(grammarAccess.getReal_ValueAccess().getSigned_IntParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleSigned_Int();

					state._fsp--;

					after(grammarAccess.getReal_ValueAccess().getSigned_IntParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__0__Impl"

	// $ANTLR start "rule__Real_Value__Group__1"
	// InternalStructuredTextParser.g:7754:1: rule__Real_Value__Group__1 :
	// rule__Real_Value__Group__1__Impl rule__Real_Value__Group__2 ;
	public final void rule__Real_Value__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7758:1: ( rule__Real_Value__Group__1__Impl
			// rule__Real_Value__Group__2 )
			// InternalStructuredTextParser.g:7759:2: rule__Real_Value__Group__1__Impl
			// rule__Real_Value__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Real_Value__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Value__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__1"

	// $ANTLR start "rule__Real_Value__Group__1__Impl"
	// InternalStructuredTextParser.g:7766:1: rule__Real_Value__Group__1__Impl : (
	// FullStop ) ;
	public final void rule__Real_Value__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7770:1: ( ( FullStop ) )
			// InternalStructuredTextParser.g:7771:1: ( FullStop )
			{
				// InternalStructuredTextParser.g:7771:1: ( FullStop )
				// InternalStructuredTextParser.g:7772:2: FullStop
				{
					before(grammarAccess.getReal_ValueAccess().getFullStopKeyword_1());
					match(input, FullStop, FOLLOW_2);
					after(grammarAccess.getReal_ValueAccess().getFullStopKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__1__Impl"

	// $ANTLR start "rule__Real_Value__Group__2"
	// InternalStructuredTextParser.g:7781:1: rule__Real_Value__Group__2 :
	// rule__Real_Value__Group__2__Impl rule__Real_Value__Group__3 ;
	public final void rule__Real_Value__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7785:1: ( rule__Real_Value__Group__2__Impl
			// rule__Real_Value__Group__3 )
			// InternalStructuredTextParser.g:7786:2: rule__Real_Value__Group__2__Impl
			// rule__Real_Value__Group__3
			{
				pushFollow(FOLLOW_68);
				rule__Real_Value__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Value__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__2"

	// $ANTLR start "rule__Real_Value__Group__2__Impl"
	// InternalStructuredTextParser.g:7793:1: rule__Real_Value__Group__2__Impl : (
	// RULE_UNSIGNED_INT ) ;
	public final void rule__Real_Value__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7797:1: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:7798:1: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:7798:1: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:7799:2: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getReal_ValueAccess().getUNSIGNED_INTTerminalRuleCall_2());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getReal_ValueAccess().getUNSIGNED_INTTerminalRuleCall_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__2__Impl"

	// $ANTLR start "rule__Real_Value__Group__3"
	// InternalStructuredTextParser.g:7808:1: rule__Real_Value__Group__3 :
	// rule__Real_Value__Group__3__Impl ;
	public final void rule__Real_Value__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7812:1: ( rule__Real_Value__Group__3__Impl )
			// InternalStructuredTextParser.g:7813:2: rule__Real_Value__Group__3__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Real_Value__Group__3__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__3"

	// $ANTLR start "rule__Real_Value__Group__3__Impl"
	// InternalStructuredTextParser.g:7819:1: rule__Real_Value__Group__3__Impl : ( (
	// rule__Real_Value__Group_3__0 )? ) ;
	public final void rule__Real_Value__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7823:1: ( ( ( rule__Real_Value__Group_3__0 )?
			// ) )
			// InternalStructuredTextParser.g:7824:1: ( ( rule__Real_Value__Group_3__0 )? )
			{
				// InternalStructuredTextParser.g:7824:1: ( ( rule__Real_Value__Group_3__0 )? )
				// InternalStructuredTextParser.g:7825:2: ( rule__Real_Value__Group_3__0 )?
				{
					before(grammarAccess.getReal_ValueAccess().getGroup_3());
					// InternalStructuredTextParser.g:7826:2: ( rule__Real_Value__Group_3__0 )?
					int alt65 = 2;
					int LA65_0 = input.LA(1);

					if ((LA65_0 == E)) {
						alt65 = 1;
					}
					switch (alt65) {
					case 1:
					// InternalStructuredTextParser.g:7826:3: rule__Real_Value__Group_3__0
					{
						pushFollow(FOLLOW_2);
						rule__Real_Value__Group_3__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getReal_ValueAccess().getGroup_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group__3__Impl"

	// $ANTLR start "rule__Real_Value__Group_3__0"
	// InternalStructuredTextParser.g:7835:1: rule__Real_Value__Group_3__0 :
	// rule__Real_Value__Group_3__0__Impl rule__Real_Value__Group_3__1 ;
	public final void rule__Real_Value__Group_3__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7839:1: ( rule__Real_Value__Group_3__0__Impl
			// rule__Real_Value__Group_3__1 )
			// InternalStructuredTextParser.g:7840:2: rule__Real_Value__Group_3__0__Impl
			// rule__Real_Value__Group_3__1
			{
				pushFollow(FOLLOW_66);
				rule__Real_Value__Group_3__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Real_Value__Group_3__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group_3__0"

	// $ANTLR start "rule__Real_Value__Group_3__0__Impl"
	// InternalStructuredTextParser.g:7847:1: rule__Real_Value__Group_3__0__Impl : (
	// E ) ;
	public final void rule__Real_Value__Group_3__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7851:1: ( ( E ) )
			// InternalStructuredTextParser.g:7852:1: ( E )
			{
				// InternalStructuredTextParser.g:7852:1: ( E )
				// InternalStructuredTextParser.g:7853:2: E
				{
					before(grammarAccess.getReal_ValueAccess().getEKeyword_3_0());
					match(input, E, FOLLOW_2);
					after(grammarAccess.getReal_ValueAccess().getEKeyword_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group_3__0__Impl"

	// $ANTLR start "rule__Real_Value__Group_3__1"
	// InternalStructuredTextParser.g:7862:1: rule__Real_Value__Group_3__1 :
	// rule__Real_Value__Group_3__1__Impl ;
	public final void rule__Real_Value__Group_3__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7866:1: ( rule__Real_Value__Group_3__1__Impl )
			// InternalStructuredTextParser.g:7867:2: rule__Real_Value__Group_3__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Real_Value__Group_3__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group_3__1"

	// $ANTLR start "rule__Real_Value__Group_3__1__Impl"
	// InternalStructuredTextParser.g:7873:1: rule__Real_Value__Group_3__1__Impl : (
	// ruleSigned_Int ) ;
	public final void rule__Real_Value__Group_3__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7877:1: ( ( ruleSigned_Int ) )
			// InternalStructuredTextParser.g:7878:1: ( ruleSigned_Int )
			{
				// InternalStructuredTextParser.g:7878:1: ( ruleSigned_Int )
				// InternalStructuredTextParser.g:7879:2: ruleSigned_Int
				{
					before(grammarAccess.getReal_ValueAccess().getSigned_IntParserRuleCall_3_1());
					pushFollow(FOLLOW_2);
					ruleSigned_Int();

					state._fsp--;

					after(grammarAccess.getReal_ValueAccess().getSigned_IntParserRuleCall_3_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Value__Group_3__1__Impl"

	// $ANTLR start "rule__Bool_Literal__Group__0"
	// InternalStructuredTextParser.g:7889:1: rule__Bool_Literal__Group__0 :
	// rule__Bool_Literal__Group__0__Impl rule__Bool_Literal__Group__1 ;
	public final void rule__Bool_Literal__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7893:1: ( rule__Bool_Literal__Group__0__Impl
			// rule__Bool_Literal__Group__1 )
			// InternalStructuredTextParser.g:7894:2: rule__Bool_Literal__Group__0__Impl
			// rule__Bool_Literal__Group__1
			{
				pushFollow(FOLLOW_13);
				rule__Bool_Literal__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Bool_Literal__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group__0"

	// $ANTLR start "rule__Bool_Literal__Group__0__Impl"
	// InternalStructuredTextParser.g:7901:1: rule__Bool_Literal__Group__0__Impl : (
	// ( rule__Bool_Literal__Group_0__0 )? ) ;
	public final void rule__Bool_Literal__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7905:1: ( ( ( rule__Bool_Literal__Group_0__0
			// )? ) )
			// InternalStructuredTextParser.g:7906:1: ( ( rule__Bool_Literal__Group_0__0 )?
			// )
			{
				// InternalStructuredTextParser.g:7906:1: ( ( rule__Bool_Literal__Group_0__0 )?
				// )
				// InternalStructuredTextParser.g:7907:2: ( rule__Bool_Literal__Group_0__0 )?
				{
					before(grammarAccess.getBool_LiteralAccess().getGroup_0());
					// InternalStructuredTextParser.g:7908:2: ( rule__Bool_Literal__Group_0__0 )?
					int alt66 = 2;
					int LA66_0 = input.LA(1);

					if ((LA66_0 == BOOL)) {
						alt66 = 1;
					}
					switch (alt66) {
					case 1:
					// InternalStructuredTextParser.g:7908:3: rule__Bool_Literal__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Bool_Literal__Group_0__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getBool_LiteralAccess().getGroup_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group__0__Impl"

	// $ANTLR start "rule__Bool_Literal__Group__1"
	// InternalStructuredTextParser.g:7916:1: rule__Bool_Literal__Group__1 :
	// rule__Bool_Literal__Group__1__Impl ;
	public final void rule__Bool_Literal__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7920:1: ( rule__Bool_Literal__Group__1__Impl )
			// InternalStructuredTextParser.g:7921:2: rule__Bool_Literal__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Bool_Literal__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group__1"

	// $ANTLR start "rule__Bool_Literal__Group__1__Impl"
	// InternalStructuredTextParser.g:7927:1: rule__Bool_Literal__Group__1__Impl : (
	// ( rule__Bool_Literal__ValueAssignment_1 ) ) ;
	public final void rule__Bool_Literal__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7931:1: ( ( (
			// rule__Bool_Literal__ValueAssignment_1 ) ) )
			// InternalStructuredTextParser.g:7932:1: ( (
			// rule__Bool_Literal__ValueAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:7932:1: ( (
				// rule__Bool_Literal__ValueAssignment_1 ) )
				// InternalStructuredTextParser.g:7933:2: (
				// rule__Bool_Literal__ValueAssignment_1 )
				{
					before(grammarAccess.getBool_LiteralAccess().getValueAssignment_1());
					// InternalStructuredTextParser.g:7934:2: (
					// rule__Bool_Literal__ValueAssignment_1 )
					// InternalStructuredTextParser.g:7934:3: rule__Bool_Literal__ValueAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Bool_Literal__ValueAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getBool_LiteralAccess().getValueAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group__1__Impl"

	// $ANTLR start "rule__Bool_Literal__Group_0__0"
	// InternalStructuredTextParser.g:7943:1: rule__Bool_Literal__Group_0__0 :
	// rule__Bool_Literal__Group_0__0__Impl rule__Bool_Literal__Group_0__1 ;
	public final void rule__Bool_Literal__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7947:1: ( rule__Bool_Literal__Group_0__0__Impl
			// rule__Bool_Literal__Group_0__1 )
			// InternalStructuredTextParser.g:7948:2: rule__Bool_Literal__Group_0__0__Impl
			// rule__Bool_Literal__Group_0__1
			{
				pushFollow(FOLLOW_65);
				rule__Bool_Literal__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Bool_Literal__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group_0__0"

	// $ANTLR start "rule__Bool_Literal__Group_0__0__Impl"
	// InternalStructuredTextParser.g:7955:1: rule__Bool_Literal__Group_0__0__Impl :
	// ( ( rule__Bool_Literal__TypeAssignment_0_0 ) ) ;
	public final void rule__Bool_Literal__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7959:1: ( ( (
			// rule__Bool_Literal__TypeAssignment_0_0 ) ) )
			// InternalStructuredTextParser.g:7960:1: ( (
			// rule__Bool_Literal__TypeAssignment_0_0 ) )
			{
				// InternalStructuredTextParser.g:7960:1: ( (
				// rule__Bool_Literal__TypeAssignment_0_0 ) )
				// InternalStructuredTextParser.g:7961:2: (
				// rule__Bool_Literal__TypeAssignment_0_0 )
				{
					before(grammarAccess.getBool_LiteralAccess().getTypeAssignment_0_0());
					// InternalStructuredTextParser.g:7962:2: (
					// rule__Bool_Literal__TypeAssignment_0_0 )
					// InternalStructuredTextParser.g:7962:3: rule__Bool_Literal__TypeAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Bool_Literal__TypeAssignment_0_0();

						state._fsp--;

					}

					after(grammarAccess.getBool_LiteralAccess().getTypeAssignment_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group_0__0__Impl"

	// $ANTLR start "rule__Bool_Literal__Group_0__1"
	// InternalStructuredTextParser.g:7970:1: rule__Bool_Literal__Group_0__1 :
	// rule__Bool_Literal__Group_0__1__Impl ;
	public final void rule__Bool_Literal__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7974:1: ( rule__Bool_Literal__Group_0__1__Impl
			// )
			// InternalStructuredTextParser.g:7975:2: rule__Bool_Literal__Group_0__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Bool_Literal__Group_0__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group_0__1"

	// $ANTLR start "rule__Bool_Literal__Group_0__1__Impl"
	// InternalStructuredTextParser.g:7981:1: rule__Bool_Literal__Group_0__1__Impl :
	// ( NumberSign ) ;
	public final void rule__Bool_Literal__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:7985:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:7986:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:7986:1: ( NumberSign )
				// InternalStructuredTextParser.g:7987:2: NumberSign
				{
					before(grammarAccess.getBool_LiteralAccess().getNumberSignKeyword_0_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getBool_LiteralAccess().getNumberSignKeyword_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__Group_0__1__Impl"

	// $ANTLR start "rule__Char_Literal__Group__0"
	// InternalStructuredTextParser.g:7997:1: rule__Char_Literal__Group__0 :
	// rule__Char_Literal__Group__0__Impl rule__Char_Literal__Group__1 ;
	public final void rule__Char_Literal__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8001:1: ( rule__Char_Literal__Group__0__Impl
			// rule__Char_Literal__Group__1 )
			// InternalStructuredTextParser.g:8002:2: rule__Char_Literal__Group__0__Impl
			// rule__Char_Literal__Group__1
			{
				pushFollow(FOLLOW_69);
				rule__Char_Literal__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Char_Literal__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group__0"

	// $ANTLR start "rule__Char_Literal__Group__0__Impl"
	// InternalStructuredTextParser.g:8009:1: rule__Char_Literal__Group__0__Impl : (
	// ( rule__Char_Literal__Group_0__0 )? ) ;
	public final void rule__Char_Literal__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8013:1: ( ( ( rule__Char_Literal__Group_0__0
			// )? ) )
			// InternalStructuredTextParser.g:8014:1: ( ( rule__Char_Literal__Group_0__0 )?
			// )
			{
				// InternalStructuredTextParser.g:8014:1: ( ( rule__Char_Literal__Group_0__0 )?
				// )
				// InternalStructuredTextParser.g:8015:2: ( rule__Char_Literal__Group_0__0 )?
				{
					before(grammarAccess.getChar_LiteralAccess().getGroup_0());
					// InternalStructuredTextParser.g:8016:2: ( rule__Char_Literal__Group_0__0 )?
					int alt67 = 2;
					int LA67_0 = input.LA(1);

					if ((LA67_0 == WSTRING || LA67_0 == STRING || LA67_0 == WCHAR || LA67_0 == CHAR)) {
						alt67 = 1;
					}
					switch (alt67) {
					case 1:
					// InternalStructuredTextParser.g:8016:3: rule__Char_Literal__Group_0__0
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__Group_0__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getChar_LiteralAccess().getGroup_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group__0__Impl"

	// $ANTLR start "rule__Char_Literal__Group__1"
	// InternalStructuredTextParser.g:8024:1: rule__Char_Literal__Group__1 :
	// rule__Char_Literal__Group__1__Impl ;
	public final void rule__Char_Literal__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8028:1: ( rule__Char_Literal__Group__1__Impl )
			// InternalStructuredTextParser.g:8029:2: rule__Char_Literal__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Char_Literal__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group__1"

	// $ANTLR start "rule__Char_Literal__Group__1__Impl"
	// InternalStructuredTextParser.g:8035:1: rule__Char_Literal__Group__1__Impl : (
	// ( rule__Char_Literal__ValueAssignment_1 ) ) ;
	public final void rule__Char_Literal__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8039:1: ( ( (
			// rule__Char_Literal__ValueAssignment_1 ) ) )
			// InternalStructuredTextParser.g:8040:1: ( (
			// rule__Char_Literal__ValueAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:8040:1: ( (
				// rule__Char_Literal__ValueAssignment_1 ) )
				// InternalStructuredTextParser.g:8041:2: (
				// rule__Char_Literal__ValueAssignment_1 )
				{
					before(grammarAccess.getChar_LiteralAccess().getValueAssignment_1());
					// InternalStructuredTextParser.g:8042:2: (
					// rule__Char_Literal__ValueAssignment_1 )
					// InternalStructuredTextParser.g:8042:3: rule__Char_Literal__ValueAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__ValueAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getChar_LiteralAccess().getValueAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group__1__Impl"

	// $ANTLR start "rule__Char_Literal__Group_0__0"
	// InternalStructuredTextParser.g:8051:1: rule__Char_Literal__Group_0__0 :
	// rule__Char_Literal__Group_0__0__Impl rule__Char_Literal__Group_0__1 ;
	public final void rule__Char_Literal__Group_0__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8055:1: ( rule__Char_Literal__Group_0__0__Impl
			// rule__Char_Literal__Group_0__1 )
			// InternalStructuredTextParser.g:8056:2: rule__Char_Literal__Group_0__0__Impl
			// rule__Char_Literal__Group_0__1
			{
				pushFollow(FOLLOW_70);
				rule__Char_Literal__Group_0__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Char_Literal__Group_0__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__0"

	// $ANTLR start "rule__Char_Literal__Group_0__0__Impl"
	// InternalStructuredTextParser.g:8063:1: rule__Char_Literal__Group_0__0__Impl :
	// ( ( rule__Char_Literal__TypeAssignment_0_0 ) ) ;
	public final void rule__Char_Literal__Group_0__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8067:1: ( ( (
			// rule__Char_Literal__TypeAssignment_0_0 ) ) )
			// InternalStructuredTextParser.g:8068:1: ( (
			// rule__Char_Literal__TypeAssignment_0_0 ) )
			{
				// InternalStructuredTextParser.g:8068:1: ( (
				// rule__Char_Literal__TypeAssignment_0_0 ) )
				// InternalStructuredTextParser.g:8069:2: (
				// rule__Char_Literal__TypeAssignment_0_0 )
				{
					before(grammarAccess.getChar_LiteralAccess().getTypeAssignment_0_0());
					// InternalStructuredTextParser.g:8070:2: (
					// rule__Char_Literal__TypeAssignment_0_0 )
					// InternalStructuredTextParser.g:8070:3: rule__Char_Literal__TypeAssignment_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__TypeAssignment_0_0();

						state._fsp--;

					}

					after(grammarAccess.getChar_LiteralAccess().getTypeAssignment_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__0__Impl"

	// $ANTLR start "rule__Char_Literal__Group_0__1"
	// InternalStructuredTextParser.g:8078:1: rule__Char_Literal__Group_0__1 :
	// rule__Char_Literal__Group_0__1__Impl rule__Char_Literal__Group_0__2 ;
	public final void rule__Char_Literal__Group_0__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8082:1: ( rule__Char_Literal__Group_0__1__Impl
			// rule__Char_Literal__Group_0__2 )
			// InternalStructuredTextParser.g:8083:2: rule__Char_Literal__Group_0__1__Impl
			// rule__Char_Literal__Group_0__2
			{
				pushFollow(FOLLOW_70);
				rule__Char_Literal__Group_0__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Char_Literal__Group_0__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__1"

	// $ANTLR start "rule__Char_Literal__Group_0__1__Impl"
	// InternalStructuredTextParser.g:8090:1: rule__Char_Literal__Group_0__1__Impl :
	// ( ( rule__Char_Literal__LengthAssignment_0_1 )? ) ;
	public final void rule__Char_Literal__Group_0__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8094:1: ( ( (
			// rule__Char_Literal__LengthAssignment_0_1 )? ) )
			// InternalStructuredTextParser.g:8095:1: ( (
			// rule__Char_Literal__LengthAssignment_0_1 )? )
			{
				// InternalStructuredTextParser.g:8095:1: ( (
				// rule__Char_Literal__LengthAssignment_0_1 )? )
				// InternalStructuredTextParser.g:8096:2: (
				// rule__Char_Literal__LengthAssignment_0_1 )?
				{
					before(grammarAccess.getChar_LiteralAccess().getLengthAssignment_0_1());
					// InternalStructuredTextParser.g:8097:2: (
					// rule__Char_Literal__LengthAssignment_0_1 )?
					int alt68 = 2;
					int LA68_0 = input.LA(1);

					if ((LA68_0 == RULE_UNSIGNED_INT)) {
						alt68 = 1;
					}
					switch (alt68) {
					case 1:
					// InternalStructuredTextParser.g:8097:3:
					// rule__Char_Literal__LengthAssignment_0_1
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__LengthAssignment_0_1();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getChar_LiteralAccess().getLengthAssignment_0_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__1__Impl"

	// $ANTLR start "rule__Char_Literal__Group_0__2"
	// InternalStructuredTextParser.g:8105:1: rule__Char_Literal__Group_0__2 :
	// rule__Char_Literal__Group_0__2__Impl ;
	public final void rule__Char_Literal__Group_0__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8109:1: ( rule__Char_Literal__Group_0__2__Impl
			// )
			// InternalStructuredTextParser.g:8110:2: rule__Char_Literal__Group_0__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Char_Literal__Group_0__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__2"

	// $ANTLR start "rule__Char_Literal__Group_0__2__Impl"
	// InternalStructuredTextParser.g:8116:1: rule__Char_Literal__Group_0__2__Impl :
	// ( NumberSign ) ;
	public final void rule__Char_Literal__Group_0__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8120:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:8121:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:8121:1: ( NumberSign )
				// InternalStructuredTextParser.g:8122:2: NumberSign
				{
					before(grammarAccess.getChar_LiteralAccess().getNumberSignKeyword_0_2());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getChar_LiteralAccess().getNumberSignKeyword_0_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__Group_0__2__Impl"

	// $ANTLR start "rule__Duration__Group__0"
	// InternalStructuredTextParser.g:8132:1: rule__Duration__Group__0 :
	// rule__Duration__Group__0__Impl rule__Duration__Group__1 ;
	public final void rule__Duration__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8136:1: ( rule__Duration__Group__0__Impl
			// rule__Duration__Group__1 )
			// InternalStructuredTextParser.g:8137:2: rule__Duration__Group__0__Impl
			// rule__Duration__Group__1
			{
				pushFollow(FOLLOW_65);
				rule__Duration__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__0"

	// $ANTLR start "rule__Duration__Group__0__Impl"
	// InternalStructuredTextParser.g:8144:1: rule__Duration__Group__0__Impl : ( (
	// rule__Duration__TypeAssignment_0 ) ) ;
	public final void rule__Duration__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8148:1: ( ( ( rule__Duration__TypeAssignment_0
			// ) ) )
			// InternalStructuredTextParser.g:8149:1: ( ( rule__Duration__TypeAssignment_0 )
			// )
			{
				// InternalStructuredTextParser.g:8149:1: ( ( rule__Duration__TypeAssignment_0 )
				// )
				// InternalStructuredTextParser.g:8150:2: ( rule__Duration__TypeAssignment_0 )
				{
					before(grammarAccess.getDurationAccess().getTypeAssignment_0());
					// InternalStructuredTextParser.g:8151:2: ( rule__Duration__TypeAssignment_0 )
					// InternalStructuredTextParser.g:8151:3: rule__Duration__TypeAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Duration__TypeAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getDurationAccess().getTypeAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__0__Impl"

	// $ANTLR start "rule__Duration__Group__1"
	// InternalStructuredTextParser.g:8159:1: rule__Duration__Group__1 :
	// rule__Duration__Group__1__Impl rule__Duration__Group__2 ;
	public final void rule__Duration__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8163:1: ( rule__Duration__Group__1__Impl
			// rule__Duration__Group__2 )
			// InternalStructuredTextParser.g:8164:2: rule__Duration__Group__1__Impl
			// rule__Duration__Group__2
			{
				pushFollow(FOLLOW_66);
				rule__Duration__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__1"

	// $ANTLR start "rule__Duration__Group__1__Impl"
	// InternalStructuredTextParser.g:8171:1: rule__Duration__Group__1__Impl : (
	// NumberSign ) ;
	public final void rule__Duration__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8175:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:8176:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:8176:1: ( NumberSign )
				// InternalStructuredTextParser.g:8177:2: NumberSign
				{
					before(grammarAccess.getDurationAccess().getNumberSignKeyword_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getDurationAccess().getNumberSignKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__1__Impl"

	// $ANTLR start "rule__Duration__Group__2"
	// InternalStructuredTextParser.g:8186:1: rule__Duration__Group__2 :
	// rule__Duration__Group__2__Impl rule__Duration__Group__3 ;
	public final void rule__Duration__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8190:1: ( rule__Duration__Group__2__Impl
			// rule__Duration__Group__3 )
			// InternalStructuredTextParser.g:8191:2: rule__Duration__Group__2__Impl
			// rule__Duration__Group__3
			{
				pushFollow(FOLLOW_66);
				rule__Duration__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__2"

	// $ANTLR start "rule__Duration__Group__2__Impl"
	// InternalStructuredTextParser.g:8198:1: rule__Duration__Group__2__Impl : ( (
	// rule__Duration__Alternatives_2 )? ) ;
	public final void rule__Duration__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8202:1: ( ( ( rule__Duration__Alternatives_2
			// )? ) )
			// InternalStructuredTextParser.g:8203:1: ( ( rule__Duration__Alternatives_2 )?
			// )
			{
				// InternalStructuredTextParser.g:8203:1: ( ( rule__Duration__Alternatives_2 )?
				// )
				// InternalStructuredTextParser.g:8204:2: ( rule__Duration__Alternatives_2 )?
				{
					before(grammarAccess.getDurationAccess().getAlternatives_2());
					// InternalStructuredTextParser.g:8205:2: ( rule__Duration__Alternatives_2 )?
					int alt69 = 2;
					int LA69_0 = input.LA(1);

					if ((LA69_0 == PlusSign || LA69_0 == HyphenMinus)) {
						alt69 = 1;
					}
					switch (alt69) {
					case 1:
					// InternalStructuredTextParser.g:8205:3: rule__Duration__Alternatives_2
					{
						pushFollow(FOLLOW_2);
						rule__Duration__Alternatives_2();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getDurationAccess().getAlternatives_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__2__Impl"

	// $ANTLR start "rule__Duration__Group__3"
	// InternalStructuredTextParser.g:8213:1: rule__Duration__Group__3 :
	// rule__Duration__Group__3__Impl rule__Duration__Group__4 ;
	public final void rule__Duration__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8217:1: ( rule__Duration__Group__3__Impl
			// rule__Duration__Group__4 )
			// InternalStructuredTextParser.g:8218:2: rule__Duration__Group__3__Impl
			// rule__Duration__Group__4
			{
				pushFollow(FOLLOW_71);
				rule__Duration__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__3"

	// $ANTLR start "rule__Duration__Group__3__Impl"
	// InternalStructuredTextParser.g:8225:1: rule__Duration__Group__3__Impl : ( (
	// rule__Duration__ValueAssignment_3 ) ) ;
	public final void rule__Duration__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8229:1: ( ( (
			// rule__Duration__ValueAssignment_3 ) ) )
			// InternalStructuredTextParser.g:8230:1: ( ( rule__Duration__ValueAssignment_3
			// ) )
			{
				// InternalStructuredTextParser.g:8230:1: ( ( rule__Duration__ValueAssignment_3
				// ) )
				// InternalStructuredTextParser.g:8231:2: ( rule__Duration__ValueAssignment_3 )
				{
					before(grammarAccess.getDurationAccess().getValueAssignment_3());
					// InternalStructuredTextParser.g:8232:2: ( rule__Duration__ValueAssignment_3 )
					// InternalStructuredTextParser.g:8232:3: rule__Duration__ValueAssignment_3
					{
						pushFollow(FOLLOW_2);
						rule__Duration__ValueAssignment_3();

						state._fsp--;

					}

					after(grammarAccess.getDurationAccess().getValueAssignment_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__3__Impl"

	// $ANTLR start "rule__Duration__Group__4"
	// InternalStructuredTextParser.g:8240:1: rule__Duration__Group__4 :
	// rule__Duration__Group__4__Impl ;
	public final void rule__Duration__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8244:1: ( rule__Duration__Group__4__Impl )
			// InternalStructuredTextParser.g:8245:2: rule__Duration__Group__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Duration__Group__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__4"

	// $ANTLR start "rule__Duration__Group__4__Impl"
	// InternalStructuredTextParser.g:8251:1: rule__Duration__Group__4__Impl : ( (
	// rule__Duration__Group_4__0 )* ) ;
	public final void rule__Duration__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8255:1: ( ( ( rule__Duration__Group_4__0 )* )
			// )
			// InternalStructuredTextParser.g:8256:1: ( ( rule__Duration__Group_4__0 )* )
			{
				// InternalStructuredTextParser.g:8256:1: ( ( rule__Duration__Group_4__0 )* )
				// InternalStructuredTextParser.g:8257:2: ( rule__Duration__Group_4__0 )*
				{
					before(grammarAccess.getDurationAccess().getGroup_4());
					// InternalStructuredTextParser.g:8258:2: ( rule__Duration__Group_4__0 )*
					loop70: do {
						int alt70 = 2;
						int LA70_0 = input.LA(1);

						if ((LA70_0 == KW__)) {
							alt70 = 1;
						}

						switch (alt70) {
						case 1:
						// InternalStructuredTextParser.g:8258:3: rule__Duration__Group_4__0
						{
							pushFollow(FOLLOW_72);
							rule__Duration__Group_4__0();

							state._fsp--;

						}
							break;

						default:
							break loop70;
						}
					} while (true);

					after(grammarAccess.getDurationAccess().getGroup_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group__4__Impl"

	// $ANTLR start "rule__Duration__Group_4__0"
	// InternalStructuredTextParser.g:8267:1: rule__Duration__Group_4__0 :
	// rule__Duration__Group_4__0__Impl rule__Duration__Group_4__1 ;
	public final void rule__Duration__Group_4__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8271:1: ( rule__Duration__Group_4__0__Impl
			// rule__Duration__Group_4__1 )
			// InternalStructuredTextParser.g:8272:2: rule__Duration__Group_4__0__Impl
			// rule__Duration__Group_4__1
			{
				pushFollow(FOLLOW_66);
				rule__Duration__Group_4__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration__Group_4__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group_4__0"

	// $ANTLR start "rule__Duration__Group_4__0__Impl"
	// InternalStructuredTextParser.g:8279:1: rule__Duration__Group_4__0__Impl : (
	// KW__ ) ;
	public final void rule__Duration__Group_4__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8283:1: ( ( KW__ ) )
			// InternalStructuredTextParser.g:8284:1: ( KW__ )
			{
				// InternalStructuredTextParser.g:8284:1: ( KW__ )
				// InternalStructuredTextParser.g:8285:2: KW__
				{
					before(grammarAccess.getDurationAccess().get_Keyword_4_0());
					match(input, KW__, FOLLOW_2);
					after(grammarAccess.getDurationAccess().get_Keyword_4_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group_4__0__Impl"

	// $ANTLR start "rule__Duration__Group_4__1"
	// InternalStructuredTextParser.g:8294:1: rule__Duration__Group_4__1 :
	// rule__Duration__Group_4__1__Impl ;
	public final void rule__Duration__Group_4__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8298:1: ( rule__Duration__Group_4__1__Impl )
			// InternalStructuredTextParser.g:8299:2: rule__Duration__Group_4__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Duration__Group_4__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group_4__1"

	// $ANTLR start "rule__Duration__Group_4__1__Impl"
	// InternalStructuredTextParser.g:8305:1: rule__Duration__Group_4__1__Impl : ( (
	// rule__Duration__ValueAssignment_4_1 ) ) ;
	public final void rule__Duration__Group_4__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8309:1: ( ( (
			// rule__Duration__ValueAssignment_4_1 ) ) )
			// InternalStructuredTextParser.g:8310:1: ( (
			// rule__Duration__ValueAssignment_4_1 ) )
			{
				// InternalStructuredTextParser.g:8310:1: ( (
				// rule__Duration__ValueAssignment_4_1 ) )
				// InternalStructuredTextParser.g:8311:2: ( rule__Duration__ValueAssignment_4_1
				// )
				{
					before(grammarAccess.getDurationAccess().getValueAssignment_4_1());
					// InternalStructuredTextParser.g:8312:2: ( rule__Duration__ValueAssignment_4_1
					// )
					// InternalStructuredTextParser.g:8312:3: rule__Duration__ValueAssignment_4_1
					{
						pushFollow(FOLLOW_2);
						rule__Duration__ValueAssignment_4_1();

						state._fsp--;

					}

					after(grammarAccess.getDurationAccess().getValueAssignment_4_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__Group_4__1__Impl"

	// $ANTLR start "rule__Duration_Value__Group__0"
	// InternalStructuredTextParser.g:8321:1: rule__Duration_Value__Group__0 :
	// rule__Duration_Value__Group__0__Impl rule__Duration_Value__Group__1 ;
	public final void rule__Duration_Value__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8325:1: ( rule__Duration_Value__Group__0__Impl
			// rule__Duration_Value__Group__1 )
			// InternalStructuredTextParser.g:8326:2: rule__Duration_Value__Group__0__Impl
			// rule__Duration_Value__Group__1
			{
				pushFollow(FOLLOW_73);
				rule__Duration_Value__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Duration_Value__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__Group__0"

	// $ANTLR start "rule__Duration_Value__Group__0__Impl"
	// InternalStructuredTextParser.g:8333:1: rule__Duration_Value__Group__0__Impl :
	// ( ( rule__Duration_Value__ValueAssignment_0 ) ) ;
	public final void rule__Duration_Value__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8337:1: ( ( (
			// rule__Duration_Value__ValueAssignment_0 ) ) )
			// InternalStructuredTextParser.g:8338:1: ( (
			// rule__Duration_Value__ValueAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:8338:1: ( (
				// rule__Duration_Value__ValueAssignment_0 ) )
				// InternalStructuredTextParser.g:8339:2: (
				// rule__Duration_Value__ValueAssignment_0 )
				{
					before(grammarAccess.getDuration_ValueAccess().getValueAssignment_0());
					// InternalStructuredTextParser.g:8340:2: (
					// rule__Duration_Value__ValueAssignment_0 )
					// InternalStructuredTextParser.g:8340:3:
					// rule__Duration_Value__ValueAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Duration_Value__ValueAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getDuration_ValueAccess().getValueAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__Group__0__Impl"

	// $ANTLR start "rule__Duration_Value__Group__1"
	// InternalStructuredTextParser.g:8348:1: rule__Duration_Value__Group__1 :
	// rule__Duration_Value__Group__1__Impl ;
	public final void rule__Duration_Value__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8352:1: ( rule__Duration_Value__Group__1__Impl
			// )
			// InternalStructuredTextParser.g:8353:2: rule__Duration_Value__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Duration_Value__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__Group__1"

	// $ANTLR start "rule__Duration_Value__Group__1__Impl"
	// InternalStructuredTextParser.g:8359:1: rule__Duration_Value__Group__1__Impl :
	// ( ( rule__Duration_Value__UnitAssignment_1 ) ) ;
	public final void rule__Duration_Value__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8363:1: ( ( (
			// rule__Duration_Value__UnitAssignment_1 ) ) )
			// InternalStructuredTextParser.g:8364:1: ( (
			// rule__Duration_Value__UnitAssignment_1 ) )
			{
				// InternalStructuredTextParser.g:8364:1: ( (
				// rule__Duration_Value__UnitAssignment_1 ) )
				// InternalStructuredTextParser.g:8365:2: (
				// rule__Duration_Value__UnitAssignment_1 )
				{
					before(grammarAccess.getDuration_ValueAccess().getUnitAssignment_1());
					// InternalStructuredTextParser.g:8366:2: (
					// rule__Duration_Value__UnitAssignment_1 )
					// InternalStructuredTextParser.g:8366:3: rule__Duration_Value__UnitAssignment_1
					{
						pushFollow(FOLLOW_2);
						rule__Duration_Value__UnitAssignment_1();

						state._fsp--;

					}

					after(grammarAccess.getDuration_ValueAccess().getUnitAssignment_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__Group__1__Impl"

	// $ANTLR start "rule__Fix_Point__Group__0"
	// InternalStructuredTextParser.g:8375:1: rule__Fix_Point__Group__0 :
	// rule__Fix_Point__Group__0__Impl rule__Fix_Point__Group__1 ;
	public final void rule__Fix_Point__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8379:1: ( rule__Fix_Point__Group__0__Impl
			// rule__Fix_Point__Group__1 )
			// InternalStructuredTextParser.g:8380:2: rule__Fix_Point__Group__0__Impl
			// rule__Fix_Point__Group__1
			{
				pushFollow(FOLLOW_63);
				rule__Fix_Point__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Fix_Point__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group__0"

	// $ANTLR start "rule__Fix_Point__Group__0__Impl"
	// InternalStructuredTextParser.g:8387:1: rule__Fix_Point__Group__0__Impl : (
	// RULE_UNSIGNED_INT ) ;
	public final void rule__Fix_Point__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8391:1: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:8392:1: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:8392:1: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:8393:2: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getFix_PointAccess().getUNSIGNED_INTTerminalRuleCall_0());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getFix_PointAccess().getUNSIGNED_INTTerminalRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group__0__Impl"

	// $ANTLR start "rule__Fix_Point__Group__1"
	// InternalStructuredTextParser.g:8402:1: rule__Fix_Point__Group__1 :
	// rule__Fix_Point__Group__1__Impl ;
	public final void rule__Fix_Point__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8406:1: ( rule__Fix_Point__Group__1__Impl )
			// InternalStructuredTextParser.g:8407:2: rule__Fix_Point__Group__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Fix_Point__Group__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group__1"

	// $ANTLR start "rule__Fix_Point__Group__1__Impl"
	// InternalStructuredTextParser.g:8413:1: rule__Fix_Point__Group__1__Impl : ( (
	// rule__Fix_Point__Group_1__0 )? ) ;
	public final void rule__Fix_Point__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8417:1: ( ( ( rule__Fix_Point__Group_1__0 )? )
			// )
			// InternalStructuredTextParser.g:8418:1: ( ( rule__Fix_Point__Group_1__0 )? )
			{
				// InternalStructuredTextParser.g:8418:1: ( ( rule__Fix_Point__Group_1__0 )? )
				// InternalStructuredTextParser.g:8419:2: ( rule__Fix_Point__Group_1__0 )?
				{
					before(grammarAccess.getFix_PointAccess().getGroup_1());
					// InternalStructuredTextParser.g:8420:2: ( rule__Fix_Point__Group_1__0 )?
					int alt71 = 2;
					int LA71_0 = input.LA(1);

					if ((LA71_0 == FullStop)) {
						alt71 = 1;
					}
					switch (alt71) {
					case 1:
					// InternalStructuredTextParser.g:8420:3: rule__Fix_Point__Group_1__0
					{
						pushFollow(FOLLOW_2);
						rule__Fix_Point__Group_1__0();

						state._fsp--;

					}
						break;

					}

					after(grammarAccess.getFix_PointAccess().getGroup_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group__1__Impl"

	// $ANTLR start "rule__Fix_Point__Group_1__0"
	// InternalStructuredTextParser.g:8429:1: rule__Fix_Point__Group_1__0 :
	// rule__Fix_Point__Group_1__0__Impl rule__Fix_Point__Group_1__1 ;
	public final void rule__Fix_Point__Group_1__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8433:1: ( rule__Fix_Point__Group_1__0__Impl
			// rule__Fix_Point__Group_1__1 )
			// InternalStructuredTextParser.g:8434:2: rule__Fix_Point__Group_1__0__Impl
			// rule__Fix_Point__Group_1__1
			{
				pushFollow(FOLLOW_11);
				rule__Fix_Point__Group_1__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Fix_Point__Group_1__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group_1__0"

	// $ANTLR start "rule__Fix_Point__Group_1__0__Impl"
	// InternalStructuredTextParser.g:8441:1: rule__Fix_Point__Group_1__0__Impl : (
	// FullStop ) ;
	public final void rule__Fix_Point__Group_1__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8445:1: ( ( FullStop ) )
			// InternalStructuredTextParser.g:8446:1: ( FullStop )
			{
				// InternalStructuredTextParser.g:8446:1: ( FullStop )
				// InternalStructuredTextParser.g:8447:2: FullStop
				{
					before(grammarAccess.getFix_PointAccess().getFullStopKeyword_1_0());
					match(input, FullStop, FOLLOW_2);
					after(grammarAccess.getFix_PointAccess().getFullStopKeyword_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group_1__0__Impl"

	// $ANTLR start "rule__Fix_Point__Group_1__1"
	// InternalStructuredTextParser.g:8456:1: rule__Fix_Point__Group_1__1 :
	// rule__Fix_Point__Group_1__1__Impl ;
	public final void rule__Fix_Point__Group_1__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8460:1: ( rule__Fix_Point__Group_1__1__Impl )
			// InternalStructuredTextParser.g:8461:2: rule__Fix_Point__Group_1__1__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Fix_Point__Group_1__1__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group_1__1"

	// $ANTLR start "rule__Fix_Point__Group_1__1__Impl"
	// InternalStructuredTextParser.g:8467:1: rule__Fix_Point__Group_1__1__Impl : (
	// RULE_UNSIGNED_INT ) ;
	public final void rule__Fix_Point__Group_1__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8471:1: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:8472:1: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:8472:1: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:8473:2: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getFix_PointAccess().getUNSIGNED_INTTerminalRuleCall_1_1());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getFix_PointAccess().getUNSIGNED_INTTerminalRuleCall_1_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Fix_Point__Group_1__1__Impl"

	// $ANTLR start "rule__Time_Of_Day__Group__0"
	// InternalStructuredTextParser.g:8483:1: rule__Time_Of_Day__Group__0 :
	// rule__Time_Of_Day__Group__0__Impl rule__Time_Of_Day__Group__1 ;
	public final void rule__Time_Of_Day__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8487:1: ( rule__Time_Of_Day__Group__0__Impl
			// rule__Time_Of_Day__Group__1 )
			// InternalStructuredTextParser.g:8488:2: rule__Time_Of_Day__Group__0__Impl
			// rule__Time_Of_Day__Group__1
			{
				pushFollow(FOLLOW_65);
				rule__Time_Of_Day__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Time_Of_Day__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__0"

	// $ANTLR start "rule__Time_Of_Day__Group__0__Impl"
	// InternalStructuredTextParser.g:8495:1: rule__Time_Of_Day__Group__0__Impl : (
	// ( rule__Time_Of_Day__TypeAssignment_0 ) ) ;
	public final void rule__Time_Of_Day__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8499:1: ( ( (
			// rule__Time_Of_Day__TypeAssignment_0 ) ) )
			// InternalStructuredTextParser.g:8500:1: ( (
			// rule__Time_Of_Day__TypeAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:8500:1: ( (
				// rule__Time_Of_Day__TypeAssignment_0 ) )
				// InternalStructuredTextParser.g:8501:2: ( rule__Time_Of_Day__TypeAssignment_0
				// )
				{
					before(grammarAccess.getTime_Of_DayAccess().getTypeAssignment_0());
					// InternalStructuredTextParser.g:8502:2: ( rule__Time_Of_Day__TypeAssignment_0
					// )
					// InternalStructuredTextParser.g:8502:3: rule__Time_Of_Day__TypeAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Time_Of_Day__TypeAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getTime_Of_DayAccess().getTypeAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__0__Impl"

	// $ANTLR start "rule__Time_Of_Day__Group__1"
	// InternalStructuredTextParser.g:8510:1: rule__Time_Of_Day__Group__1 :
	// rule__Time_Of_Day__Group__1__Impl rule__Time_Of_Day__Group__2 ;
	public final void rule__Time_Of_Day__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8514:1: ( rule__Time_Of_Day__Group__1__Impl
			// rule__Time_Of_Day__Group__2 )
			// InternalStructuredTextParser.g:8515:2: rule__Time_Of_Day__Group__1__Impl
			// rule__Time_Of_Day__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Time_Of_Day__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Time_Of_Day__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__1"

	// $ANTLR start "rule__Time_Of_Day__Group__1__Impl"
	// InternalStructuredTextParser.g:8522:1: rule__Time_Of_Day__Group__1__Impl : (
	// NumberSign ) ;
	public final void rule__Time_Of_Day__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8526:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:8527:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:8527:1: ( NumberSign )
				// InternalStructuredTextParser.g:8528:2: NumberSign
				{
					before(grammarAccess.getTime_Of_DayAccess().getNumberSignKeyword_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getTime_Of_DayAccess().getNumberSignKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__1__Impl"

	// $ANTLR start "rule__Time_Of_Day__Group__2"
	// InternalStructuredTextParser.g:8537:1: rule__Time_Of_Day__Group__2 :
	// rule__Time_Of_Day__Group__2__Impl ;
	public final void rule__Time_Of_Day__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8541:1: ( rule__Time_Of_Day__Group__2__Impl )
			// InternalStructuredTextParser.g:8542:2: rule__Time_Of_Day__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Time_Of_Day__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__2"

	// $ANTLR start "rule__Time_Of_Day__Group__2__Impl"
	// InternalStructuredTextParser.g:8548:1: rule__Time_Of_Day__Group__2__Impl : (
	// ( rule__Time_Of_Day__ValueAssignment_2 ) ) ;
	public final void rule__Time_Of_Day__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8552:1: ( ( (
			// rule__Time_Of_Day__ValueAssignment_2 ) ) )
			// InternalStructuredTextParser.g:8553:1: ( (
			// rule__Time_Of_Day__ValueAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:8553:1: ( (
				// rule__Time_Of_Day__ValueAssignment_2 ) )
				// InternalStructuredTextParser.g:8554:2: ( rule__Time_Of_Day__ValueAssignment_2
				// )
				{
					before(grammarAccess.getTime_Of_DayAccess().getValueAssignment_2());
					// InternalStructuredTextParser.g:8555:2: ( rule__Time_Of_Day__ValueAssignment_2
					// )
					// InternalStructuredTextParser.g:8555:3: rule__Time_Of_Day__ValueAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__Time_Of_Day__ValueAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getTime_Of_DayAccess().getValueAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__Group__2__Impl"

	// $ANTLR start "rule__Daytime__Group__0"
	// InternalStructuredTextParser.g:8564:1: rule__Daytime__Group__0 :
	// rule__Daytime__Group__0__Impl rule__Daytime__Group__1 ;
	public final void rule__Daytime__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8568:1: ( rule__Daytime__Group__0__Impl
			// rule__Daytime__Group__1 )
			// InternalStructuredTextParser.g:8569:2: rule__Daytime__Group__0__Impl
			// rule__Daytime__Group__1
			{
				pushFollow(FOLLOW_8);
				rule__Daytime__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Daytime__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__0"

	// $ANTLR start "rule__Daytime__Group__0__Impl"
	// InternalStructuredTextParser.g:8576:1: rule__Daytime__Group__0__Impl : (
	// ruleDay_Hour ) ;
	public final void rule__Daytime__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8580:1: ( ( ruleDay_Hour ) )
			// InternalStructuredTextParser.g:8581:1: ( ruleDay_Hour )
			{
				// InternalStructuredTextParser.g:8581:1: ( ruleDay_Hour )
				// InternalStructuredTextParser.g:8582:2: ruleDay_Hour
				{
					before(grammarAccess.getDaytimeAccess().getDay_HourParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleDay_Hour();

					state._fsp--;

					after(grammarAccess.getDaytimeAccess().getDay_HourParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__0__Impl"

	// $ANTLR start "rule__Daytime__Group__1"
	// InternalStructuredTextParser.g:8591:1: rule__Daytime__Group__1 :
	// rule__Daytime__Group__1__Impl rule__Daytime__Group__2 ;
	public final void rule__Daytime__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8595:1: ( rule__Daytime__Group__1__Impl
			// rule__Daytime__Group__2 )
			// InternalStructuredTextParser.g:8596:2: rule__Daytime__Group__1__Impl
			// rule__Daytime__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Daytime__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Daytime__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__1"

	// $ANTLR start "rule__Daytime__Group__1__Impl"
	// InternalStructuredTextParser.g:8603:1: rule__Daytime__Group__1__Impl : (
	// Colon ) ;
	public final void rule__Daytime__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8607:1: ( ( Colon ) )
			// InternalStructuredTextParser.g:8608:1: ( Colon )
			{
				// InternalStructuredTextParser.g:8608:1: ( Colon )
				// InternalStructuredTextParser.g:8609:2: Colon
				{
					before(grammarAccess.getDaytimeAccess().getColonKeyword_1());
					match(input, Colon, FOLLOW_2);
					after(grammarAccess.getDaytimeAccess().getColonKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__1__Impl"

	// $ANTLR start "rule__Daytime__Group__2"
	// InternalStructuredTextParser.g:8618:1: rule__Daytime__Group__2 :
	// rule__Daytime__Group__2__Impl rule__Daytime__Group__3 ;
	public final void rule__Daytime__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8622:1: ( rule__Daytime__Group__2__Impl
			// rule__Daytime__Group__3 )
			// InternalStructuredTextParser.g:8623:2: rule__Daytime__Group__2__Impl
			// rule__Daytime__Group__3
			{
				pushFollow(FOLLOW_8);
				rule__Daytime__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Daytime__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__2"

	// $ANTLR start "rule__Daytime__Group__2__Impl"
	// InternalStructuredTextParser.g:8630:1: rule__Daytime__Group__2__Impl : (
	// ruleDay_Minute ) ;
	public final void rule__Daytime__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8634:1: ( ( ruleDay_Minute ) )
			// InternalStructuredTextParser.g:8635:1: ( ruleDay_Minute )
			{
				// InternalStructuredTextParser.g:8635:1: ( ruleDay_Minute )
				// InternalStructuredTextParser.g:8636:2: ruleDay_Minute
				{
					before(grammarAccess.getDaytimeAccess().getDay_MinuteParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleDay_Minute();

					state._fsp--;

					after(grammarAccess.getDaytimeAccess().getDay_MinuteParserRuleCall_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__2__Impl"

	// $ANTLR start "rule__Daytime__Group__3"
	// InternalStructuredTextParser.g:8645:1: rule__Daytime__Group__3 :
	// rule__Daytime__Group__3__Impl rule__Daytime__Group__4 ;
	public final void rule__Daytime__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8649:1: ( rule__Daytime__Group__3__Impl
			// rule__Daytime__Group__4 )
			// InternalStructuredTextParser.g:8650:2: rule__Daytime__Group__3__Impl
			// rule__Daytime__Group__4
			{
				pushFollow(FOLLOW_66);
				rule__Daytime__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Daytime__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__3"

	// $ANTLR start "rule__Daytime__Group__3__Impl"
	// InternalStructuredTextParser.g:8657:1: rule__Daytime__Group__3__Impl : (
	// Colon ) ;
	public final void rule__Daytime__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8661:1: ( ( Colon ) )
			// InternalStructuredTextParser.g:8662:1: ( Colon )
			{
				// InternalStructuredTextParser.g:8662:1: ( Colon )
				// InternalStructuredTextParser.g:8663:2: Colon
				{
					before(grammarAccess.getDaytimeAccess().getColonKeyword_3());
					match(input, Colon, FOLLOW_2);
					after(grammarAccess.getDaytimeAccess().getColonKeyword_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__3__Impl"

	// $ANTLR start "rule__Daytime__Group__4"
	// InternalStructuredTextParser.g:8672:1: rule__Daytime__Group__4 :
	// rule__Daytime__Group__4__Impl ;
	public final void rule__Daytime__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8676:1: ( rule__Daytime__Group__4__Impl )
			// InternalStructuredTextParser.g:8677:2: rule__Daytime__Group__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Daytime__Group__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__4"

	// $ANTLR start "rule__Daytime__Group__4__Impl"
	// InternalStructuredTextParser.g:8683:1: rule__Daytime__Group__4__Impl : (
	// ruleDay_Second ) ;
	public final void rule__Daytime__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8687:1: ( ( ruleDay_Second ) )
			// InternalStructuredTextParser.g:8688:1: ( ruleDay_Second )
			{
				// InternalStructuredTextParser.g:8688:1: ( ruleDay_Second )
				// InternalStructuredTextParser.g:8689:2: ruleDay_Second
				{
					before(grammarAccess.getDaytimeAccess().getDay_SecondParserRuleCall_4());
					pushFollow(FOLLOW_2);
					ruleDay_Second();

					state._fsp--;

					after(grammarAccess.getDaytimeAccess().getDay_SecondParserRuleCall_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Daytime__Group__4__Impl"

	// $ANTLR start "rule__Date__Group__0"
	// InternalStructuredTextParser.g:8699:1: rule__Date__Group__0 :
	// rule__Date__Group__0__Impl rule__Date__Group__1 ;
	public final void rule__Date__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8703:1: ( rule__Date__Group__0__Impl
			// rule__Date__Group__1 )
			// InternalStructuredTextParser.g:8704:2: rule__Date__Group__0__Impl
			// rule__Date__Group__1
			{
				pushFollow(FOLLOW_65);
				rule__Date__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__0"

	// $ANTLR start "rule__Date__Group__0__Impl"
	// InternalStructuredTextParser.g:8711:1: rule__Date__Group__0__Impl : ( (
	// rule__Date__TypeAssignment_0 ) ) ;
	public final void rule__Date__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8715:1: ( ( ( rule__Date__TypeAssignment_0 ) )
			// )
			// InternalStructuredTextParser.g:8716:1: ( ( rule__Date__TypeAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:8716:1: ( ( rule__Date__TypeAssignment_0 ) )
				// InternalStructuredTextParser.g:8717:2: ( rule__Date__TypeAssignment_0 )
				{
					before(grammarAccess.getDateAccess().getTypeAssignment_0());
					// InternalStructuredTextParser.g:8718:2: ( rule__Date__TypeAssignment_0 )
					// InternalStructuredTextParser.g:8718:3: rule__Date__TypeAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Date__TypeAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getDateAccess().getTypeAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__0__Impl"

	// $ANTLR start "rule__Date__Group__1"
	// InternalStructuredTextParser.g:8726:1: rule__Date__Group__1 :
	// rule__Date__Group__1__Impl rule__Date__Group__2 ;
	public final void rule__Date__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8730:1: ( rule__Date__Group__1__Impl
			// rule__Date__Group__2 )
			// InternalStructuredTextParser.g:8731:2: rule__Date__Group__1__Impl
			// rule__Date__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Date__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__1"

	// $ANTLR start "rule__Date__Group__1__Impl"
	// InternalStructuredTextParser.g:8738:1: rule__Date__Group__1__Impl : (
	// NumberSign ) ;
	public final void rule__Date__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8742:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:8743:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:8743:1: ( NumberSign )
				// InternalStructuredTextParser.g:8744:2: NumberSign
				{
					before(grammarAccess.getDateAccess().getNumberSignKeyword_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getDateAccess().getNumberSignKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__1__Impl"

	// $ANTLR start "rule__Date__Group__2"
	// InternalStructuredTextParser.g:8753:1: rule__Date__Group__2 :
	// rule__Date__Group__2__Impl ;
	public final void rule__Date__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8757:1: ( rule__Date__Group__2__Impl )
			// InternalStructuredTextParser.g:8758:2: rule__Date__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Date__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__2"

	// $ANTLR start "rule__Date__Group__2__Impl"
	// InternalStructuredTextParser.g:8764:1: rule__Date__Group__2__Impl : ( (
	// rule__Date__ValueAssignment_2 ) ) ;
	public final void rule__Date__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8768:1: ( ( ( rule__Date__ValueAssignment_2 )
			// ) )
			// InternalStructuredTextParser.g:8769:1: ( ( rule__Date__ValueAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:8769:1: ( ( rule__Date__ValueAssignment_2 ) )
				// InternalStructuredTextParser.g:8770:2: ( rule__Date__ValueAssignment_2 )
				{
					before(grammarAccess.getDateAccess().getValueAssignment_2());
					// InternalStructuredTextParser.g:8771:2: ( rule__Date__ValueAssignment_2 )
					// InternalStructuredTextParser.g:8771:3: rule__Date__ValueAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__Date__ValueAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getDateAccess().getValueAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__Group__2__Impl"

	// $ANTLR start "rule__Date_Literal__Group__0"
	// InternalStructuredTextParser.g:8780:1: rule__Date_Literal__Group__0 :
	// rule__Date_Literal__Group__0__Impl rule__Date_Literal__Group__1 ;
	public final void rule__Date_Literal__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8784:1: ( rule__Date_Literal__Group__0__Impl
			// rule__Date_Literal__Group__1 )
			// InternalStructuredTextParser.g:8785:2: rule__Date_Literal__Group__0__Impl
			// rule__Date_Literal__Group__1
			{
				pushFollow(FOLLOW_74);
				rule__Date_Literal__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_Literal__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__0"

	// $ANTLR start "rule__Date_Literal__Group__0__Impl"
	// InternalStructuredTextParser.g:8792:1: rule__Date_Literal__Group__0__Impl : (
	// ruleYear ) ;
	public final void rule__Date_Literal__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8796:1: ( ( ruleYear ) )
			// InternalStructuredTextParser.g:8797:1: ( ruleYear )
			{
				// InternalStructuredTextParser.g:8797:1: ( ruleYear )
				// InternalStructuredTextParser.g:8798:2: ruleYear
				{
					before(grammarAccess.getDate_LiteralAccess().getYearParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleYear();

					state._fsp--;

					after(grammarAccess.getDate_LiteralAccess().getYearParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__0__Impl"

	// $ANTLR start "rule__Date_Literal__Group__1"
	// InternalStructuredTextParser.g:8807:1: rule__Date_Literal__Group__1 :
	// rule__Date_Literal__Group__1__Impl rule__Date_Literal__Group__2 ;
	public final void rule__Date_Literal__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8811:1: ( rule__Date_Literal__Group__1__Impl
			// rule__Date_Literal__Group__2 )
			// InternalStructuredTextParser.g:8812:2: rule__Date_Literal__Group__1__Impl
			// rule__Date_Literal__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Date_Literal__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_Literal__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__1"

	// $ANTLR start "rule__Date_Literal__Group__1__Impl"
	// InternalStructuredTextParser.g:8819:1: rule__Date_Literal__Group__1__Impl : (
	// HyphenMinus ) ;
	public final void rule__Date_Literal__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8823:1: ( ( HyphenMinus ) )
			// InternalStructuredTextParser.g:8824:1: ( HyphenMinus )
			{
				// InternalStructuredTextParser.g:8824:1: ( HyphenMinus )
				// InternalStructuredTextParser.g:8825:2: HyphenMinus
				{
					before(grammarAccess.getDate_LiteralAccess().getHyphenMinusKeyword_1());
					match(input, HyphenMinus, FOLLOW_2);
					after(grammarAccess.getDate_LiteralAccess().getHyphenMinusKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__1__Impl"

	// $ANTLR start "rule__Date_Literal__Group__2"
	// InternalStructuredTextParser.g:8834:1: rule__Date_Literal__Group__2 :
	// rule__Date_Literal__Group__2__Impl rule__Date_Literal__Group__3 ;
	public final void rule__Date_Literal__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8838:1: ( rule__Date_Literal__Group__2__Impl
			// rule__Date_Literal__Group__3 )
			// InternalStructuredTextParser.g:8839:2: rule__Date_Literal__Group__2__Impl
			// rule__Date_Literal__Group__3
			{
				pushFollow(FOLLOW_74);
				rule__Date_Literal__Group__2__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_Literal__Group__3();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__2"

	// $ANTLR start "rule__Date_Literal__Group__2__Impl"
	// InternalStructuredTextParser.g:8846:1: rule__Date_Literal__Group__2__Impl : (
	// ruleMonth ) ;
	public final void rule__Date_Literal__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8850:1: ( ( ruleMonth ) )
			// InternalStructuredTextParser.g:8851:1: ( ruleMonth )
			{
				// InternalStructuredTextParser.g:8851:1: ( ruleMonth )
				// InternalStructuredTextParser.g:8852:2: ruleMonth
				{
					before(grammarAccess.getDate_LiteralAccess().getMonthParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleMonth();

					state._fsp--;

					after(grammarAccess.getDate_LiteralAccess().getMonthParserRuleCall_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__2__Impl"

	// $ANTLR start "rule__Date_Literal__Group__3"
	// InternalStructuredTextParser.g:8861:1: rule__Date_Literal__Group__3 :
	// rule__Date_Literal__Group__3__Impl rule__Date_Literal__Group__4 ;
	public final void rule__Date_Literal__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8865:1: ( rule__Date_Literal__Group__3__Impl
			// rule__Date_Literal__Group__4 )
			// InternalStructuredTextParser.g:8866:2: rule__Date_Literal__Group__3__Impl
			// rule__Date_Literal__Group__4
			{
				pushFollow(FOLLOW_11);
				rule__Date_Literal__Group__3__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_Literal__Group__4();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__3"

	// $ANTLR start "rule__Date_Literal__Group__3__Impl"
	// InternalStructuredTextParser.g:8873:1: rule__Date_Literal__Group__3__Impl : (
	// HyphenMinus ) ;
	public final void rule__Date_Literal__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8877:1: ( ( HyphenMinus ) )
			// InternalStructuredTextParser.g:8878:1: ( HyphenMinus )
			{
				// InternalStructuredTextParser.g:8878:1: ( HyphenMinus )
				// InternalStructuredTextParser.g:8879:2: HyphenMinus
				{
					before(grammarAccess.getDate_LiteralAccess().getHyphenMinusKeyword_3());
					match(input, HyphenMinus, FOLLOW_2);
					after(grammarAccess.getDate_LiteralAccess().getHyphenMinusKeyword_3());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__3__Impl"

	// $ANTLR start "rule__Date_Literal__Group__4"
	// InternalStructuredTextParser.g:8888:1: rule__Date_Literal__Group__4 :
	// rule__Date_Literal__Group__4__Impl ;
	public final void rule__Date_Literal__Group__4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8892:1: ( rule__Date_Literal__Group__4__Impl )
			// InternalStructuredTextParser.g:8893:2: rule__Date_Literal__Group__4__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Date_Literal__Group__4__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__4"

	// $ANTLR start "rule__Date_Literal__Group__4__Impl"
	// InternalStructuredTextParser.g:8899:1: rule__Date_Literal__Group__4__Impl : (
	// ruleDay ) ;
	public final void rule__Date_Literal__Group__4__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8903:1: ( ( ruleDay ) )
			// InternalStructuredTextParser.g:8904:1: ( ruleDay )
			{
				// InternalStructuredTextParser.g:8904:1: ( ruleDay )
				// InternalStructuredTextParser.g:8905:2: ruleDay
				{
					before(grammarAccess.getDate_LiteralAccess().getDayParserRuleCall_4());
					pushFollow(FOLLOW_2);
					ruleDay();

					state._fsp--;

					after(grammarAccess.getDate_LiteralAccess().getDayParserRuleCall_4());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_Literal__Group__4__Impl"

	// $ANTLR start "rule__Date_And_Time__Group__0"
	// InternalStructuredTextParser.g:8915:1: rule__Date_And_Time__Group__0 :
	// rule__Date_And_Time__Group__0__Impl rule__Date_And_Time__Group__1 ;
	public final void rule__Date_And_Time__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8919:1: ( rule__Date_And_Time__Group__0__Impl
			// rule__Date_And_Time__Group__1 )
			// InternalStructuredTextParser.g:8920:2: rule__Date_And_Time__Group__0__Impl
			// rule__Date_And_Time__Group__1
			{
				pushFollow(FOLLOW_65);
				rule__Date_And_Time__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_And_Time__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__0"

	// $ANTLR start "rule__Date_And_Time__Group__0__Impl"
	// InternalStructuredTextParser.g:8927:1: rule__Date_And_Time__Group__0__Impl :
	// ( ( rule__Date_And_Time__TypeAssignment_0 ) ) ;
	public final void rule__Date_And_Time__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8931:1: ( ( (
			// rule__Date_And_Time__TypeAssignment_0 ) ) )
			// InternalStructuredTextParser.g:8932:1: ( (
			// rule__Date_And_Time__TypeAssignment_0 ) )
			{
				// InternalStructuredTextParser.g:8932:1: ( (
				// rule__Date_And_Time__TypeAssignment_0 ) )
				// InternalStructuredTextParser.g:8933:2: (
				// rule__Date_And_Time__TypeAssignment_0 )
				{
					before(grammarAccess.getDate_And_TimeAccess().getTypeAssignment_0());
					// InternalStructuredTextParser.g:8934:2: (
					// rule__Date_And_Time__TypeAssignment_0 )
					// InternalStructuredTextParser.g:8934:3: rule__Date_And_Time__TypeAssignment_0
					{
						pushFollow(FOLLOW_2);
						rule__Date_And_Time__TypeAssignment_0();

						state._fsp--;

					}

					after(grammarAccess.getDate_And_TimeAccess().getTypeAssignment_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__0__Impl"

	// $ANTLR start "rule__Date_And_Time__Group__1"
	// InternalStructuredTextParser.g:8942:1: rule__Date_And_Time__Group__1 :
	// rule__Date_And_Time__Group__1__Impl rule__Date_And_Time__Group__2 ;
	public final void rule__Date_And_Time__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8946:1: ( rule__Date_And_Time__Group__1__Impl
			// rule__Date_And_Time__Group__2 )
			// InternalStructuredTextParser.g:8947:2: rule__Date_And_Time__Group__1__Impl
			// rule__Date_And_Time__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Date_And_Time__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_And_Time__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__1"

	// $ANTLR start "rule__Date_And_Time__Group__1__Impl"
	// InternalStructuredTextParser.g:8954:1: rule__Date_And_Time__Group__1__Impl :
	// ( NumberSign ) ;
	public final void rule__Date_And_Time__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8958:1: ( ( NumberSign ) )
			// InternalStructuredTextParser.g:8959:1: ( NumberSign )
			{
				// InternalStructuredTextParser.g:8959:1: ( NumberSign )
				// InternalStructuredTextParser.g:8960:2: NumberSign
				{
					before(grammarAccess.getDate_And_TimeAccess().getNumberSignKeyword_1());
					match(input, NumberSign, FOLLOW_2);
					after(grammarAccess.getDate_And_TimeAccess().getNumberSignKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__1__Impl"

	// $ANTLR start "rule__Date_And_Time__Group__2"
	// InternalStructuredTextParser.g:8969:1: rule__Date_And_Time__Group__2 :
	// rule__Date_And_Time__Group__2__Impl ;
	public final void rule__Date_And_Time__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8973:1: ( rule__Date_And_Time__Group__2__Impl
			// )
			// InternalStructuredTextParser.g:8974:2: rule__Date_And_Time__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Date_And_Time__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__2"

	// $ANTLR start "rule__Date_And_Time__Group__2__Impl"
	// InternalStructuredTextParser.g:8980:1: rule__Date_And_Time__Group__2__Impl :
	// ( ( rule__Date_And_Time__ValueAssignment_2 ) ) ;
	public final void rule__Date_And_Time__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:8984:1: ( ( (
			// rule__Date_And_Time__ValueAssignment_2 ) ) )
			// InternalStructuredTextParser.g:8985:1: ( (
			// rule__Date_And_Time__ValueAssignment_2 ) )
			{
				// InternalStructuredTextParser.g:8985:1: ( (
				// rule__Date_And_Time__ValueAssignment_2 ) )
				// InternalStructuredTextParser.g:8986:2: (
				// rule__Date_And_Time__ValueAssignment_2 )
				{
					before(grammarAccess.getDate_And_TimeAccess().getValueAssignment_2());
					// InternalStructuredTextParser.g:8987:2: (
					// rule__Date_And_Time__ValueAssignment_2 )
					// InternalStructuredTextParser.g:8987:3: rule__Date_And_Time__ValueAssignment_2
					{
						pushFollow(FOLLOW_2);
						rule__Date_And_Time__ValueAssignment_2();

						state._fsp--;

					}

					after(grammarAccess.getDate_And_TimeAccess().getValueAssignment_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__Group__2__Impl"

	// $ANTLR start "rule__Date_And_Time_Value__Group__0"
	// InternalStructuredTextParser.g:8996:1: rule__Date_And_Time_Value__Group__0 :
	// rule__Date_And_Time_Value__Group__0__Impl rule__Date_And_Time_Value__Group__1
	// ;
	public final void rule__Date_And_Time_Value__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9000:1: (
			// rule__Date_And_Time_Value__Group__0__Impl rule__Date_And_Time_Value__Group__1
			// )
			// InternalStructuredTextParser.g:9001:2:
			// rule__Date_And_Time_Value__Group__0__Impl rule__Date_And_Time_Value__Group__1
			{
				pushFollow(FOLLOW_74);
				rule__Date_And_Time_Value__Group__0__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_And_Time_Value__Group__1();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__0"

	// $ANTLR start "rule__Date_And_Time_Value__Group__0__Impl"
	// InternalStructuredTextParser.g:9008:1:
	// rule__Date_And_Time_Value__Group__0__Impl : ( ruleDate_Literal ) ;
	public final void rule__Date_And_Time_Value__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9012:1: ( ( ruleDate_Literal ) )
			// InternalStructuredTextParser.g:9013:1: ( ruleDate_Literal )
			{
				// InternalStructuredTextParser.g:9013:1: ( ruleDate_Literal )
				// InternalStructuredTextParser.g:9014:2: ruleDate_Literal
				{
					before(grammarAccess.getDate_And_Time_ValueAccess().getDate_LiteralParserRuleCall_0());
					pushFollow(FOLLOW_2);
					ruleDate_Literal();

					state._fsp--;

					after(grammarAccess.getDate_And_Time_ValueAccess().getDate_LiteralParserRuleCall_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__0__Impl"

	// $ANTLR start "rule__Date_And_Time_Value__Group__1"
	// InternalStructuredTextParser.g:9023:1: rule__Date_And_Time_Value__Group__1 :
	// rule__Date_And_Time_Value__Group__1__Impl rule__Date_And_Time_Value__Group__2
	// ;
	public final void rule__Date_And_Time_Value__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9027:1: (
			// rule__Date_And_Time_Value__Group__1__Impl rule__Date_And_Time_Value__Group__2
			// )
			// InternalStructuredTextParser.g:9028:2:
			// rule__Date_And_Time_Value__Group__1__Impl rule__Date_And_Time_Value__Group__2
			{
				pushFollow(FOLLOW_11);
				rule__Date_And_Time_Value__Group__1__Impl();

				state._fsp--;

				pushFollow(FOLLOW_2);
				rule__Date_And_Time_Value__Group__2();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__1"

	// $ANTLR start "rule__Date_And_Time_Value__Group__1__Impl"
	// InternalStructuredTextParser.g:9035:1:
	// rule__Date_And_Time_Value__Group__1__Impl : ( HyphenMinus ) ;
	public final void rule__Date_And_Time_Value__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9039:1: ( ( HyphenMinus ) )
			// InternalStructuredTextParser.g:9040:1: ( HyphenMinus )
			{
				// InternalStructuredTextParser.g:9040:1: ( HyphenMinus )
				// InternalStructuredTextParser.g:9041:2: HyphenMinus
				{
					before(grammarAccess.getDate_And_Time_ValueAccess().getHyphenMinusKeyword_1());
					match(input, HyphenMinus, FOLLOW_2);
					after(grammarAccess.getDate_And_Time_ValueAccess().getHyphenMinusKeyword_1());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__1__Impl"

	// $ANTLR start "rule__Date_And_Time_Value__Group__2"
	// InternalStructuredTextParser.g:9050:1: rule__Date_And_Time_Value__Group__2 :
	// rule__Date_And_Time_Value__Group__2__Impl ;
	public final void rule__Date_And_Time_Value__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9054:1: (
			// rule__Date_And_Time_Value__Group__2__Impl )
			// InternalStructuredTextParser.g:9055:2:
			// rule__Date_And_Time_Value__Group__2__Impl
			{
				pushFollow(FOLLOW_2);
				rule__Date_And_Time_Value__Group__2__Impl();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__2"

	// $ANTLR start "rule__Date_And_Time_Value__Group__2__Impl"
	// InternalStructuredTextParser.g:9061:1:
	// rule__Date_And_Time_Value__Group__2__Impl : ( ruleDaytime ) ;
	public final void rule__Date_And_Time_Value__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9065:1: ( ( ruleDaytime ) )
			// InternalStructuredTextParser.g:9066:1: ( ruleDaytime )
			{
				// InternalStructuredTextParser.g:9066:1: ( ruleDaytime )
				// InternalStructuredTextParser.g:9067:2: ruleDaytime
				{
					before(grammarAccess.getDate_And_Time_ValueAccess().getDaytimeParserRuleCall_2());
					pushFollow(FOLLOW_2);
					ruleDaytime();

					state._fsp--;

					after(grammarAccess.getDate_And_Time_ValueAccess().getDaytimeParserRuleCall_2());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time_Value__Group__2__Impl"

	// $ANTLR start "rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0"
	// InternalStructuredTextParser.g:9077:1:
	// rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0 : (
	// ruleVar_Decl_Init ) ;
	public final void rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9081:1: ( ( ruleVar_Decl_Init ) )
			// InternalStructuredTextParser.g:9082:2: ( ruleVar_Decl_Init )
			{
				// InternalStructuredTextParser.g:9082:2: ( ruleVar_Decl_Init )
				// InternalStructuredTextParser.g:9083:3: ruleVar_Decl_Init
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess()
							.getLocalVariablesVar_Decl_InitParserRuleCall_1_1_0_0());
					pushFollow(FOLLOW_2);
					ruleVar_Decl_Init();

					state._fsp--;

					after(grammarAccess.getStructuredTextAlgorithmAccess()
							.getLocalVariablesVar_Decl_InitParserRuleCall_1_1_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__LocalVariablesAssignment_1_1_0"

	// $ANTLR start "rule__StructuredTextAlgorithm__StatementsAssignment_2"
	// InternalStructuredTextParser.g:9092:1:
	// rule__StructuredTextAlgorithm__StatementsAssignment_2 : ( ruleStmt_List ) ;
	public final void rule__StructuredTextAlgorithm__StatementsAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9096:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9097:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9097:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9098:3: ruleStmt_List
				{
					before(grammarAccess.getStructuredTextAlgorithmAccess().getStatementsStmt_ListParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getStructuredTextAlgorithmAccess().getStatementsStmt_ListParserRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__StructuredTextAlgorithm__StatementsAssignment_2"

	// $ANTLR start "rule__Var_Decl_Init__ConstantAssignment_1"
	// InternalStructuredTextParser.g:9107:1:
	// rule__Var_Decl_Init__ConstantAssignment_1 : ( ( CONSTANT ) ) ;
	public final void rule__Var_Decl_Init__ConstantAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9111:1: ( ( ( CONSTANT ) ) )
			// InternalStructuredTextParser.g:9112:2: ( ( CONSTANT ) )
			{
				// InternalStructuredTextParser.g:9112:2: ( ( CONSTANT ) )
				// InternalStructuredTextParser.g:9113:3: ( CONSTANT )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getConstantCONSTANTKeyword_1_0());
					// InternalStructuredTextParser.g:9114:3: ( CONSTANT )
					// InternalStructuredTextParser.g:9115:4: CONSTANT
					{
						before(grammarAccess.getVar_Decl_InitAccess().getConstantCONSTANTKeyword_1_0());
						match(input, CONSTANT, FOLLOW_2);
						after(grammarAccess.getVar_Decl_InitAccess().getConstantCONSTANTKeyword_1_0());

					}

					after(grammarAccess.getVar_Decl_InitAccess().getConstantCONSTANTKeyword_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__ConstantAssignment_1"

	// $ANTLR start "rule__Var_Decl_Init__NameAssignment_2"
	// InternalStructuredTextParser.g:9126:1: rule__Var_Decl_Init__NameAssignment_2
	// : ( RULE_ID ) ;
	public final void rule__Var_Decl_Init__NameAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9130:1: ( ( RULE_ID ) )
			// InternalStructuredTextParser.g:9131:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:9131:2: ( RULE_ID )
				// InternalStructuredTextParser.g:9132:3: RULE_ID
				{
					before(grammarAccess.getVar_Decl_InitAccess().getNameIDTerminalRuleCall_2_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getVar_Decl_InitAccess().getNameIDTerminalRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__NameAssignment_2"

	// $ANTLR start "rule__Var_Decl_Init__TypeAssignment_4"
	// InternalStructuredTextParser.g:9141:1: rule__Var_Decl_Init__TypeAssignment_4
	// : ( ( ruleType_Name ) ) ;
	public final void rule__Var_Decl_Init__TypeAssignment_4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9145:1: ( ( ( ruleType_Name ) ) )
			// InternalStructuredTextParser.g:9146:2: ( ( ruleType_Name ) )
			{
				// InternalStructuredTextParser.g:9146:2: ( ( ruleType_Name ) )
				// InternalStructuredTextParser.g:9147:3: ( ruleType_Name )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getTypeDataTypeCrossReference_4_0());
					// InternalStructuredTextParser.g:9148:3: ( ruleType_Name )
					// InternalStructuredTextParser.g:9149:4: ruleType_Name
					{
						before(grammarAccess.getVar_Decl_InitAccess().getTypeDataTypeType_NameParserRuleCall_4_0_1());
						pushFollow(FOLLOW_2);
						ruleType_Name();

						state._fsp--;

						after(grammarAccess.getVar_Decl_InitAccess().getTypeDataTypeType_NameParserRuleCall_4_0_1());

					}

					after(grammarAccess.getVar_Decl_InitAccess().getTypeDataTypeCrossReference_4_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__TypeAssignment_4"

	// $ANTLR start "rule__Var_Decl_Init__ArrayAssignment_5_0"
	// InternalStructuredTextParser.g:9160:1:
	// rule__Var_Decl_Init__ArrayAssignment_5_0 : ( ( LeftSquareBracket ) ) ;
	public final void rule__Var_Decl_Init__ArrayAssignment_5_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9164:1: ( ( ( LeftSquareBracket ) ) )
			// InternalStructuredTextParser.g:9165:2: ( ( LeftSquareBracket ) )
			{
				// InternalStructuredTextParser.g:9165:2: ( ( LeftSquareBracket ) )
				// InternalStructuredTextParser.g:9166:3: ( LeftSquareBracket )
				{
					before(grammarAccess.getVar_Decl_InitAccess().getArrayLeftSquareBracketKeyword_5_0_0());
					// InternalStructuredTextParser.g:9167:3: ( LeftSquareBracket )
					// InternalStructuredTextParser.g:9168:4: LeftSquareBracket
					{
						before(grammarAccess.getVar_Decl_InitAccess().getArrayLeftSquareBracketKeyword_5_0_0());
						match(input, LeftSquareBracket, FOLLOW_2);
						after(grammarAccess.getVar_Decl_InitAccess().getArrayLeftSquareBracketKeyword_5_0_0());

					}

					after(grammarAccess.getVar_Decl_InitAccess().getArrayLeftSquareBracketKeyword_5_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__ArrayAssignment_5_0"

	// $ANTLR start "rule__Var_Decl_Init__ArraySizeAssignment_5_1"
	// InternalStructuredTextParser.g:9179:1:
	// rule__Var_Decl_Init__ArraySizeAssignment_5_1 : ( ruleArray_Size ) ;
	public final void rule__Var_Decl_Init__ArraySizeAssignment_5_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9183:1: ( ( ruleArray_Size ) )
			// InternalStructuredTextParser.g:9184:2: ( ruleArray_Size )
			{
				// InternalStructuredTextParser.g:9184:2: ( ruleArray_Size )
				// InternalStructuredTextParser.g:9185:3: ruleArray_Size
				{
					before(grammarAccess.getVar_Decl_InitAccess().getArraySizeArray_SizeParserRuleCall_5_1_0());
					pushFollow(FOLLOW_2);
					ruleArray_Size();

					state._fsp--;

					after(grammarAccess.getVar_Decl_InitAccess().getArraySizeArray_SizeParserRuleCall_5_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__ArraySizeAssignment_5_1"

	// $ANTLR start "rule__Var_Decl_Init__InitialValueAssignment_6_1"
	// InternalStructuredTextParser.g:9194:1:
	// rule__Var_Decl_Init__InitialValueAssignment_6_1 : ( ruleConstant ) ;
	public final void rule__Var_Decl_Init__InitialValueAssignment_6_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9198:1: ( ( ruleConstant ) )
			// InternalStructuredTextParser.g:9199:2: ( ruleConstant )
			{
				// InternalStructuredTextParser.g:9199:2: ( ruleConstant )
				// InternalStructuredTextParser.g:9200:3: ruleConstant
				{
					before(grammarAccess.getVar_Decl_InitAccess().getInitialValueConstantParserRuleCall_6_1_0());
					pushFollow(FOLLOW_2);
					ruleConstant();

					state._fsp--;

					after(grammarAccess.getVar_Decl_InitAccess().getInitialValueConstantParserRuleCall_6_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Var_Decl_Init__InitialValueAssignment_6_1"

	// $ANTLR start "rule__Stmt_List__StatementsAssignment_1_0"
	// InternalStructuredTextParser.g:9209:1:
	// rule__Stmt_List__StatementsAssignment_1_0 : ( ruleStmt ) ;
	public final void rule__Stmt_List__StatementsAssignment_1_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9213:1: ( ( ruleStmt ) )
			// InternalStructuredTextParser.g:9214:2: ( ruleStmt )
			{
				// InternalStructuredTextParser.g:9214:2: ( ruleStmt )
				// InternalStructuredTextParser.g:9215:3: ruleStmt
				{
					before(grammarAccess.getStmt_ListAccess().getStatementsStmtParserRuleCall_1_0_0());
					pushFollow(FOLLOW_2);
					ruleStmt();

					state._fsp--;

					after(grammarAccess.getStmt_ListAccess().getStatementsStmtParserRuleCall_1_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Stmt_List__StatementsAssignment_1_0"

	// $ANTLR start "rule__Assign_Stmt__VariableAssignment_0"
	// InternalStructuredTextParser.g:9224:1:
	// rule__Assign_Stmt__VariableAssignment_0 : ( ruleVariable ) ;
	public final void rule__Assign_Stmt__VariableAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9228:1: ( ( ruleVariable ) )
			// InternalStructuredTextParser.g:9229:2: ( ruleVariable )
			{
				// InternalStructuredTextParser.g:9229:2: ( ruleVariable )
				// InternalStructuredTextParser.g:9230:3: ruleVariable
				{
					before(grammarAccess.getAssign_StmtAccess().getVariableVariableParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleVariable();

					state._fsp--;

					after(grammarAccess.getAssign_StmtAccess().getVariableVariableParserRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__VariableAssignment_0"

	// $ANTLR start "rule__Assign_Stmt__ExpressionAssignment_2"
	// InternalStructuredTextParser.g:9239:1:
	// rule__Assign_Stmt__ExpressionAssignment_2 : ( ruleExpression ) ;
	public final void rule__Assign_Stmt__ExpressionAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9243:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9244:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9244:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9245:3: ruleExpression
				{
					before(grammarAccess.getAssign_StmtAccess().getExpressionExpressionParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getAssign_StmtAccess().getExpressionExpressionParserRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Assign_Stmt__ExpressionAssignment_2"

	// $ANTLR start "rule__IF_Stmt__ExpressionAssignment_1"
	// InternalStructuredTextParser.g:9254:1: rule__IF_Stmt__ExpressionAssignment_1
	// : ( ruleExpression ) ;
	public final void rule__IF_Stmt__ExpressionAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9258:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9259:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9259:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9260:3: ruleExpression
				{
					before(grammarAccess.getIF_StmtAccess().getExpressionExpressionParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getIF_StmtAccess().getExpressionExpressionParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__ExpressionAssignment_1"

	// $ANTLR start "rule__IF_Stmt__StatmentsAssignment_3"
	// InternalStructuredTextParser.g:9269:1: rule__IF_Stmt__StatmentsAssignment_3 :
	// ( ruleStmt_List ) ;
	public final void rule__IF_Stmt__StatmentsAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9273:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9274:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9274:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9275:3: ruleStmt_List
				{
					before(grammarAccess.getIF_StmtAccess().getStatmentsStmt_ListParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getIF_StmtAccess().getStatmentsStmt_ListParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__StatmentsAssignment_3"

	// $ANTLR start "rule__IF_Stmt__ElseifAssignment_4"
	// InternalStructuredTextParser.g:9284:1: rule__IF_Stmt__ElseifAssignment_4 : (
	// ruleELSIF_Clause ) ;
	public final void rule__IF_Stmt__ElseifAssignment_4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9288:1: ( ( ruleELSIF_Clause ) )
			// InternalStructuredTextParser.g:9289:2: ( ruleELSIF_Clause )
			{
				// InternalStructuredTextParser.g:9289:2: ( ruleELSIF_Clause )
				// InternalStructuredTextParser.g:9290:3: ruleELSIF_Clause
				{
					before(grammarAccess.getIF_StmtAccess().getElseifELSIF_ClauseParserRuleCall_4_0());
					pushFollow(FOLLOW_2);
					ruleELSIF_Clause();

					state._fsp--;

					after(grammarAccess.getIF_StmtAccess().getElseifELSIF_ClauseParserRuleCall_4_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__ElseifAssignment_4"

	// $ANTLR start "rule__IF_Stmt__ElseAssignment_5"
	// InternalStructuredTextParser.g:9299:1: rule__IF_Stmt__ElseAssignment_5 : (
	// ruleELSE_Clause ) ;
	public final void rule__IF_Stmt__ElseAssignment_5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9303:1: ( ( ruleELSE_Clause ) )
			// InternalStructuredTextParser.g:9304:2: ( ruleELSE_Clause )
			{
				// InternalStructuredTextParser.g:9304:2: ( ruleELSE_Clause )
				// InternalStructuredTextParser.g:9305:3: ruleELSE_Clause
				{
					before(grammarAccess.getIF_StmtAccess().getElseELSE_ClauseParserRuleCall_5_0());
					pushFollow(FOLLOW_2);
					ruleELSE_Clause();

					state._fsp--;

					after(grammarAccess.getIF_StmtAccess().getElseELSE_ClauseParserRuleCall_5_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__IF_Stmt__ElseAssignment_5"

	// $ANTLR start "rule__ELSIF_Clause__ExpressionAssignment_1"
	// InternalStructuredTextParser.g:9314:1:
	// rule__ELSIF_Clause__ExpressionAssignment_1 : ( ruleExpression ) ;
	public final void rule__ELSIF_Clause__ExpressionAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9318:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9319:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9319:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9320:3: ruleExpression
				{
					before(grammarAccess.getELSIF_ClauseAccess().getExpressionExpressionParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getELSIF_ClauseAccess().getExpressionExpressionParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__ExpressionAssignment_1"

	// $ANTLR start "rule__ELSIF_Clause__StatementsAssignment_3"
	// InternalStructuredTextParser.g:9329:1:
	// rule__ELSIF_Clause__StatementsAssignment_3 : ( ruleStmt_List ) ;
	public final void rule__ELSIF_Clause__StatementsAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9333:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9334:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9334:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9335:3: ruleStmt_List
				{
					before(grammarAccess.getELSIF_ClauseAccess().getStatementsStmt_ListParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getELSIF_ClauseAccess().getStatementsStmt_ListParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSIF_Clause__StatementsAssignment_3"

	// $ANTLR start "rule__ELSE_Clause__StatementsAssignment_1"
	// InternalStructuredTextParser.g:9344:1:
	// rule__ELSE_Clause__StatementsAssignment_1 : ( ruleStmt_List ) ;
	public final void rule__ELSE_Clause__StatementsAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9348:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9349:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9349:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9350:3: ruleStmt_List
				{
					before(grammarAccess.getELSE_ClauseAccess().getStatementsStmt_ListParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getELSE_ClauseAccess().getStatementsStmt_ListParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__ELSE_Clause__StatementsAssignment_1"

	// $ANTLR start "rule__Case_Stmt__ExpressionAssignment_1"
	// InternalStructuredTextParser.g:9359:1:
	// rule__Case_Stmt__ExpressionAssignment_1 : ( ruleExpression ) ;
	public final void rule__Case_Stmt__ExpressionAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9363:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9364:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9364:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9365:3: ruleExpression
				{
					before(grammarAccess.getCase_StmtAccess().getExpressionExpressionParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getCase_StmtAccess().getExpressionExpressionParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__ExpressionAssignment_1"

	// $ANTLR start "rule__Case_Stmt__CaseAssignment_3"
	// InternalStructuredTextParser.g:9374:1: rule__Case_Stmt__CaseAssignment_3 : (
	// ruleCase_Selection ) ;
	public final void rule__Case_Stmt__CaseAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9378:1: ( ( ruleCase_Selection ) )
			// InternalStructuredTextParser.g:9379:2: ( ruleCase_Selection )
			{
				// InternalStructuredTextParser.g:9379:2: ( ruleCase_Selection )
				// InternalStructuredTextParser.g:9380:3: ruleCase_Selection
				{
					before(grammarAccess.getCase_StmtAccess().getCaseCase_SelectionParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleCase_Selection();

					state._fsp--;

					after(grammarAccess.getCase_StmtAccess().getCaseCase_SelectionParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__CaseAssignment_3"

	// $ANTLR start "rule__Case_Stmt__ElseAssignment_4"
	// InternalStructuredTextParser.g:9389:1: rule__Case_Stmt__ElseAssignment_4 : (
	// ruleELSE_Clause ) ;
	public final void rule__Case_Stmt__ElseAssignment_4() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9393:1: ( ( ruleELSE_Clause ) )
			// InternalStructuredTextParser.g:9394:2: ( ruleELSE_Clause )
			{
				// InternalStructuredTextParser.g:9394:2: ( ruleELSE_Clause )
				// InternalStructuredTextParser.g:9395:3: ruleELSE_Clause
				{
					before(grammarAccess.getCase_StmtAccess().getElseELSE_ClauseParserRuleCall_4_0());
					pushFollow(FOLLOW_2);
					ruleELSE_Clause();

					state._fsp--;

					after(grammarAccess.getCase_StmtAccess().getElseELSE_ClauseParserRuleCall_4_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Stmt__ElseAssignment_4"

	// $ANTLR start "rule__Case_Selection__CaseAssignment_0"
	// InternalStructuredTextParser.g:9404:1: rule__Case_Selection__CaseAssignment_0
	// : ( ruleConstant ) ;
	public final void rule__Case_Selection__CaseAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9408:1: ( ( ruleConstant ) )
			// InternalStructuredTextParser.g:9409:2: ( ruleConstant )
			{
				// InternalStructuredTextParser.g:9409:2: ( ruleConstant )
				// InternalStructuredTextParser.g:9410:3: ruleConstant
				{
					before(grammarAccess.getCase_SelectionAccess().getCaseConstantParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleConstant();

					state._fsp--;

					after(grammarAccess.getCase_SelectionAccess().getCaseConstantParserRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__CaseAssignment_0"

	// $ANTLR start "rule__Case_Selection__CaseAssignment_1_1"
	// InternalStructuredTextParser.g:9419:1:
	// rule__Case_Selection__CaseAssignment_1_1 : ( ruleConstant ) ;
	public final void rule__Case_Selection__CaseAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9423:1: ( ( ruleConstant ) )
			// InternalStructuredTextParser.g:9424:2: ( ruleConstant )
			{
				// InternalStructuredTextParser.g:9424:2: ( ruleConstant )
				// InternalStructuredTextParser.g:9425:3: ruleConstant
				{
					before(grammarAccess.getCase_SelectionAccess().getCaseConstantParserRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleConstant();

					state._fsp--;

					after(grammarAccess.getCase_SelectionAccess().getCaseConstantParserRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__CaseAssignment_1_1"

	// $ANTLR start "rule__Case_Selection__StatementsAssignment_3"
	// InternalStructuredTextParser.g:9434:1:
	// rule__Case_Selection__StatementsAssignment_3 : ( ruleStmt_List ) ;
	public final void rule__Case_Selection__StatementsAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9438:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9439:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9439:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9440:3: ruleStmt_List
				{
					before(grammarAccess.getCase_SelectionAccess().getStatementsStmt_ListParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getCase_SelectionAccess().getStatementsStmt_ListParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Case_Selection__StatementsAssignment_3"

	// $ANTLR start "rule__For_Stmt__VariableAssignment_1"
	// InternalStructuredTextParser.g:9449:1: rule__For_Stmt__VariableAssignment_1 :
	// ( ruleVariable_Primary ) ;
	public final void rule__For_Stmt__VariableAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9453:1: ( ( ruleVariable_Primary ) )
			// InternalStructuredTextParser.g:9454:2: ( ruleVariable_Primary )
			{
				// InternalStructuredTextParser.g:9454:2: ( ruleVariable_Primary )
				// InternalStructuredTextParser.g:9455:3: ruleVariable_Primary
				{
					before(grammarAccess.getFor_StmtAccess().getVariableVariable_PrimaryParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleVariable_Primary();

					state._fsp--;

					after(grammarAccess.getFor_StmtAccess().getVariableVariable_PrimaryParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__VariableAssignment_1"

	// $ANTLR start "rule__For_Stmt__FromAssignment_3"
	// InternalStructuredTextParser.g:9464:1: rule__For_Stmt__FromAssignment_3 : (
	// ruleExpression ) ;
	public final void rule__For_Stmt__FromAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9468:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9469:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9469:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9470:3: ruleExpression
				{
					before(grammarAccess.getFor_StmtAccess().getFromExpressionParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getFor_StmtAccess().getFromExpressionParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__FromAssignment_3"

	// $ANTLR start "rule__For_Stmt__ToAssignment_5"
	// InternalStructuredTextParser.g:9479:1: rule__For_Stmt__ToAssignment_5 : (
	// ruleExpression ) ;
	public final void rule__For_Stmt__ToAssignment_5() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9483:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9484:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9484:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9485:3: ruleExpression
				{
					before(grammarAccess.getFor_StmtAccess().getToExpressionParserRuleCall_5_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getFor_StmtAccess().getToExpressionParserRuleCall_5_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__ToAssignment_5"

	// $ANTLR start "rule__For_Stmt__ByAssignment_6_1"
	// InternalStructuredTextParser.g:9494:1: rule__For_Stmt__ByAssignment_6_1 : (
	// ruleExpression ) ;
	public final void rule__For_Stmt__ByAssignment_6_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9498:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9499:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9499:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9500:3: ruleExpression
				{
					before(grammarAccess.getFor_StmtAccess().getByExpressionParserRuleCall_6_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getFor_StmtAccess().getByExpressionParserRuleCall_6_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__ByAssignment_6_1"

	// $ANTLR start "rule__For_Stmt__StatementsAssignment_8"
	// InternalStructuredTextParser.g:9509:1: rule__For_Stmt__StatementsAssignment_8
	// : ( ruleStmt_List ) ;
	public final void rule__For_Stmt__StatementsAssignment_8() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9513:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9514:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9514:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9515:3: ruleStmt_List
				{
					before(grammarAccess.getFor_StmtAccess().getStatementsStmt_ListParserRuleCall_8_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getFor_StmtAccess().getStatementsStmt_ListParserRuleCall_8_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__For_Stmt__StatementsAssignment_8"

	// $ANTLR start "rule__While_Stmt__ExpressionAssignment_1"
	// InternalStructuredTextParser.g:9524:1:
	// rule__While_Stmt__ExpressionAssignment_1 : ( ruleExpression ) ;
	public final void rule__While_Stmt__ExpressionAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9528:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9529:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9529:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9530:3: ruleExpression
				{
					before(grammarAccess.getWhile_StmtAccess().getExpressionExpressionParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getWhile_StmtAccess().getExpressionExpressionParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__ExpressionAssignment_1"

	// $ANTLR start "rule__While_Stmt__StatementsAssignment_3"
	// InternalStructuredTextParser.g:9539:1:
	// rule__While_Stmt__StatementsAssignment_3 : ( ruleStmt_List ) ;
	public final void rule__While_Stmt__StatementsAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9543:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9544:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9544:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9545:3: ruleStmt_List
				{
					before(grammarAccess.getWhile_StmtAccess().getStatementsStmt_ListParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getWhile_StmtAccess().getStatementsStmt_ListParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__While_Stmt__StatementsAssignment_3"

	// $ANTLR start "rule__Repeat_Stmt__StatementsAssignment_1"
	// InternalStructuredTextParser.g:9554:1:
	// rule__Repeat_Stmt__StatementsAssignment_1 : ( ruleStmt_List ) ;
	public final void rule__Repeat_Stmt__StatementsAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9558:1: ( ( ruleStmt_List ) )
			// InternalStructuredTextParser.g:9559:2: ( ruleStmt_List )
			{
				// InternalStructuredTextParser.g:9559:2: ( ruleStmt_List )
				// InternalStructuredTextParser.g:9560:3: ruleStmt_List
				{
					before(grammarAccess.getRepeat_StmtAccess().getStatementsStmt_ListParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleStmt_List();

					state._fsp--;

					after(grammarAccess.getRepeat_StmtAccess().getStatementsStmt_ListParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__StatementsAssignment_1"

	// $ANTLR start "rule__Repeat_Stmt__ExpressionAssignment_3"
	// InternalStructuredTextParser.g:9569:1:
	// rule__Repeat_Stmt__ExpressionAssignment_3 : ( ruleExpression ) ;
	public final void rule__Repeat_Stmt__ExpressionAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9573:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9574:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9574:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9575:3: ruleExpression
				{
					before(grammarAccess.getRepeat_StmtAccess().getExpressionExpressionParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getRepeat_StmtAccess().getExpressionExpressionParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Repeat_Stmt__ExpressionAssignment_3"

	// $ANTLR start "rule__Or_Expression__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9584:1:
	// rule__Or_Expression__OperatorAssignment_1_1 : ( ruleOr_Operator ) ;
	public final void rule__Or_Expression__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9588:1: ( ( ruleOr_Operator ) )
			// InternalStructuredTextParser.g:9589:2: ( ruleOr_Operator )
			{
				// InternalStructuredTextParser.g:9589:2: ( ruleOr_Operator )
				// InternalStructuredTextParser.g:9590:3: ruleOr_Operator
				{
					before(grammarAccess.getOr_ExpressionAccess().getOperatorOr_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleOr_Operator();

					state._fsp--;

					after(grammarAccess.getOr_ExpressionAccess().getOperatorOr_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__OperatorAssignment_1_1"

	// $ANTLR start "rule__Or_Expression__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9599:1:
	// rule__Or_Expression__RightAssignment_1_2 : ( ruleXor_Expr ) ;
	public final void rule__Or_Expression__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9603:1: ( ( ruleXor_Expr ) )
			// InternalStructuredTextParser.g:9604:2: ( ruleXor_Expr )
			{
				// InternalStructuredTextParser.g:9604:2: ( ruleXor_Expr )
				// InternalStructuredTextParser.g:9605:3: ruleXor_Expr
				{
					before(grammarAccess.getOr_ExpressionAccess().getRightXor_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleXor_Expr();

					state._fsp--;

					after(grammarAccess.getOr_ExpressionAccess().getRightXor_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Or_Expression__RightAssignment_1_2"

	// $ANTLR start "rule__Xor_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9614:1: rule__Xor_Expr__OperatorAssignment_1_1
	// : ( ruleXor_Operator ) ;
	public final void rule__Xor_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9618:1: ( ( ruleXor_Operator ) )
			// InternalStructuredTextParser.g:9619:2: ( ruleXor_Operator )
			{
				// InternalStructuredTextParser.g:9619:2: ( ruleXor_Operator )
				// InternalStructuredTextParser.g:9620:3: ruleXor_Operator
				{
					before(grammarAccess.getXor_ExprAccess().getOperatorXor_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleXor_Operator();

					state._fsp--;

					after(grammarAccess.getXor_ExprAccess().getOperatorXor_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__Xor_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9629:1: rule__Xor_Expr__RightAssignment_1_2 :
	// ( ruleAnd_Expr ) ;
	public final void rule__Xor_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9633:1: ( ( ruleAnd_Expr ) )
			// InternalStructuredTextParser.g:9634:2: ( ruleAnd_Expr )
			{
				// InternalStructuredTextParser.g:9634:2: ( ruleAnd_Expr )
				// InternalStructuredTextParser.g:9635:3: ruleAnd_Expr
				{
					before(grammarAccess.getXor_ExprAccess().getRightAnd_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleAnd_Expr();

					state._fsp--;

					after(grammarAccess.getXor_ExprAccess().getRightAnd_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Xor_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__And_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9644:1: rule__And_Expr__OperatorAssignment_1_1
	// : ( ruleAnd_Operator ) ;
	public final void rule__And_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9648:1: ( ( ruleAnd_Operator ) )
			// InternalStructuredTextParser.g:9649:2: ( ruleAnd_Operator )
			{
				// InternalStructuredTextParser.g:9649:2: ( ruleAnd_Operator )
				// InternalStructuredTextParser.g:9650:3: ruleAnd_Operator
				{
					before(grammarAccess.getAnd_ExprAccess().getOperatorAnd_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleAnd_Operator();

					state._fsp--;

					after(grammarAccess.getAnd_ExprAccess().getOperatorAnd_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__And_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9659:1: rule__And_Expr__RightAssignment_1_2 :
	// ( ruleCompare_Expr ) ;
	public final void rule__And_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9663:1: ( ( ruleCompare_Expr ) )
			// InternalStructuredTextParser.g:9664:2: ( ruleCompare_Expr )
			{
				// InternalStructuredTextParser.g:9664:2: ( ruleCompare_Expr )
				// InternalStructuredTextParser.g:9665:3: ruleCompare_Expr
				{
					before(grammarAccess.getAnd_ExprAccess().getRightCompare_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleCompare_Expr();

					state._fsp--;

					after(grammarAccess.getAnd_ExprAccess().getRightCompare_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__And_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__Compare_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9674:1:
	// rule__Compare_Expr__OperatorAssignment_1_1 : ( ruleCompare_Operator ) ;
	public final void rule__Compare_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9678:1: ( ( ruleCompare_Operator ) )
			// InternalStructuredTextParser.g:9679:2: ( ruleCompare_Operator )
			{
				// InternalStructuredTextParser.g:9679:2: ( ruleCompare_Operator )
				// InternalStructuredTextParser.g:9680:3: ruleCompare_Operator
				{
					before(grammarAccess.getCompare_ExprAccess().getOperatorCompare_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleCompare_Operator();

					state._fsp--;

					after(grammarAccess.getCompare_ExprAccess().getOperatorCompare_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__Compare_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9689:1:
	// rule__Compare_Expr__RightAssignment_1_2 : ( ruleEqu_Expr ) ;
	public final void rule__Compare_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9693:1: ( ( ruleEqu_Expr ) )
			// InternalStructuredTextParser.g:9694:2: ( ruleEqu_Expr )
			{
				// InternalStructuredTextParser.g:9694:2: ( ruleEqu_Expr )
				// InternalStructuredTextParser.g:9695:3: ruleEqu_Expr
				{
					before(grammarAccess.getCompare_ExprAccess().getRightEqu_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleEqu_Expr();

					state._fsp--;

					after(grammarAccess.getCompare_ExprAccess().getRightEqu_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Compare_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__Equ_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9704:1: rule__Equ_Expr__OperatorAssignment_1_1
	// : ( ruleEqu_Operator ) ;
	public final void rule__Equ_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9708:1: ( ( ruleEqu_Operator ) )
			// InternalStructuredTextParser.g:9709:2: ( ruleEqu_Operator )
			{
				// InternalStructuredTextParser.g:9709:2: ( ruleEqu_Operator )
				// InternalStructuredTextParser.g:9710:3: ruleEqu_Operator
				{
					before(grammarAccess.getEqu_ExprAccess().getOperatorEqu_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleEqu_Operator();

					state._fsp--;

					after(grammarAccess.getEqu_ExprAccess().getOperatorEqu_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__Equ_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9719:1: rule__Equ_Expr__RightAssignment_1_2 :
	// ( ruleAdd_Expr ) ;
	public final void rule__Equ_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9723:1: ( ( ruleAdd_Expr ) )
			// InternalStructuredTextParser.g:9724:2: ( ruleAdd_Expr )
			{
				// InternalStructuredTextParser.g:9724:2: ( ruleAdd_Expr )
				// InternalStructuredTextParser.g:9725:3: ruleAdd_Expr
				{
					before(grammarAccess.getEqu_ExprAccess().getRightAdd_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleAdd_Expr();

					state._fsp--;

					after(grammarAccess.getEqu_ExprAccess().getRightAdd_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Equ_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__Add_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9734:1: rule__Add_Expr__OperatorAssignment_1_1
	// : ( ruleAdd_Operator ) ;
	public final void rule__Add_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9738:1: ( ( ruleAdd_Operator ) )
			// InternalStructuredTextParser.g:9739:2: ( ruleAdd_Operator )
			{
				// InternalStructuredTextParser.g:9739:2: ( ruleAdd_Operator )
				// InternalStructuredTextParser.g:9740:3: ruleAdd_Operator
				{
					before(grammarAccess.getAdd_ExprAccess().getOperatorAdd_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleAdd_Operator();

					state._fsp--;

					after(grammarAccess.getAdd_ExprAccess().getOperatorAdd_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__Add_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9749:1: rule__Add_Expr__RightAssignment_1_2 :
	// ( ruleTerm ) ;
	public final void rule__Add_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9753:1: ( ( ruleTerm ) )
			// InternalStructuredTextParser.g:9754:2: ( ruleTerm )
			{
				// InternalStructuredTextParser.g:9754:2: ( ruleTerm )
				// InternalStructuredTextParser.g:9755:3: ruleTerm
				{
					before(grammarAccess.getAdd_ExprAccess().getRightTermParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleTerm();

					state._fsp--;

					after(grammarAccess.getAdd_ExprAccess().getRightTermParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Add_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__Term__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9764:1: rule__Term__OperatorAssignment_1_1 : (
	// ruleTerm_Operator ) ;
	public final void rule__Term__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9768:1: ( ( ruleTerm_Operator ) )
			// InternalStructuredTextParser.g:9769:2: ( ruleTerm_Operator )
			{
				// InternalStructuredTextParser.g:9769:2: ( ruleTerm_Operator )
				// InternalStructuredTextParser.g:9770:3: ruleTerm_Operator
				{
					before(grammarAccess.getTermAccess().getOperatorTerm_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					ruleTerm_Operator();

					state._fsp--;

					after(grammarAccess.getTermAccess().getOperatorTerm_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__OperatorAssignment_1_1"

	// $ANTLR start "rule__Term__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9779:1: rule__Term__RightAssignment_1_2 : (
	// rulePower_Expr ) ;
	public final void rule__Term__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9783:1: ( ( rulePower_Expr ) )
			// InternalStructuredTextParser.g:9784:2: ( rulePower_Expr )
			{
				// InternalStructuredTextParser.g:9784:2: ( rulePower_Expr )
				// InternalStructuredTextParser.g:9785:3: rulePower_Expr
				{
					before(grammarAccess.getTermAccess().getRightPower_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					rulePower_Expr();

					state._fsp--;

					after(grammarAccess.getTermAccess().getRightPower_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Term__RightAssignment_1_2"

	// $ANTLR start "rule__Power_Expr__OperatorAssignment_1_1"
	// InternalStructuredTextParser.g:9794:1:
	// rule__Power_Expr__OperatorAssignment_1_1 : ( rulePower_Operator ) ;
	public final void rule__Power_Expr__OperatorAssignment_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9798:1: ( ( rulePower_Operator ) )
			// InternalStructuredTextParser.g:9799:2: ( rulePower_Operator )
			{
				// InternalStructuredTextParser.g:9799:2: ( rulePower_Operator )
				// InternalStructuredTextParser.g:9800:3: rulePower_Operator
				{
					before(grammarAccess.getPower_ExprAccess().getOperatorPower_OperatorEnumRuleCall_1_1_0());
					pushFollow(FOLLOW_2);
					rulePower_Operator();

					state._fsp--;

					after(grammarAccess.getPower_ExprAccess().getOperatorPower_OperatorEnumRuleCall_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__OperatorAssignment_1_1"

	// $ANTLR start "rule__Power_Expr__RightAssignment_1_2"
	// InternalStructuredTextParser.g:9809:1: rule__Power_Expr__RightAssignment_1_2
	// : ( ruleUnary_Expr ) ;
	public final void rule__Power_Expr__RightAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9813:1: ( ( ruleUnary_Expr ) )
			// InternalStructuredTextParser.g:9814:2: ( ruleUnary_Expr )
			{
				// InternalStructuredTextParser.g:9814:2: ( ruleUnary_Expr )
				// InternalStructuredTextParser.g:9815:3: ruleUnary_Expr
				{
					before(grammarAccess.getPower_ExprAccess().getRightUnary_ExprParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleUnary_Expr();

					state._fsp--;

					after(grammarAccess.getPower_ExprAccess().getRightUnary_ExprParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Power_Expr__RightAssignment_1_2"

	// $ANTLR start "rule__Unary_Expr__OperatorAssignment_0_1"
	// InternalStructuredTextParser.g:9824:1:
	// rule__Unary_Expr__OperatorAssignment_0_1 : ( ruleUnary_Operator ) ;
	public final void rule__Unary_Expr__OperatorAssignment_0_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9828:1: ( ( ruleUnary_Operator ) )
			// InternalStructuredTextParser.g:9829:2: ( ruleUnary_Operator )
			{
				// InternalStructuredTextParser.g:9829:2: ( ruleUnary_Operator )
				// InternalStructuredTextParser.g:9830:3: ruleUnary_Operator
				{
					before(grammarAccess.getUnary_ExprAccess().getOperatorUnary_OperatorEnumRuleCall_0_1_0());
					pushFollow(FOLLOW_2);
					ruleUnary_Operator();

					state._fsp--;

					after(grammarAccess.getUnary_ExprAccess().getOperatorUnary_OperatorEnumRuleCall_0_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__OperatorAssignment_0_1"

	// $ANTLR start "rule__Unary_Expr__ExpressionAssignment_0_2"
	// InternalStructuredTextParser.g:9839:1:
	// rule__Unary_Expr__ExpressionAssignment_0_2 : ( rulePrimary_Expr ) ;
	public final void rule__Unary_Expr__ExpressionAssignment_0_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9843:1: ( ( rulePrimary_Expr ) )
			// InternalStructuredTextParser.g:9844:2: ( rulePrimary_Expr )
			{
				// InternalStructuredTextParser.g:9844:2: ( rulePrimary_Expr )
				// InternalStructuredTextParser.g:9845:3: rulePrimary_Expr
				{
					before(grammarAccess.getUnary_ExprAccess().getExpressionPrimary_ExprParserRuleCall_0_2_0());
					pushFollow(FOLLOW_2);
					rulePrimary_Expr();

					state._fsp--;

					after(grammarAccess.getUnary_ExprAccess().getExpressionPrimary_ExprParserRuleCall_0_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Unary_Expr__ExpressionAssignment_0_2"

	// $ANTLR start "rule__Func_Call__FuncAssignment_0"
	// InternalStructuredTextParser.g:9854:1: rule__Func_Call__FuncAssignment_0 : (
	// ( rule__Func_Call__FuncAlternatives_0_0 ) ) ;
	public final void rule__Func_Call__FuncAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9858:1: ( ( (
			// rule__Func_Call__FuncAlternatives_0_0 ) ) )
			// InternalStructuredTextParser.g:9859:2: ( (
			// rule__Func_Call__FuncAlternatives_0_0 ) )
			{
				// InternalStructuredTextParser.g:9859:2: ( (
				// rule__Func_Call__FuncAlternatives_0_0 ) )
				// InternalStructuredTextParser.g:9860:3: (
				// rule__Func_Call__FuncAlternatives_0_0 )
				{
					before(grammarAccess.getFunc_CallAccess().getFuncAlternatives_0_0());
					// InternalStructuredTextParser.g:9861:3: (
					// rule__Func_Call__FuncAlternatives_0_0 )
					// InternalStructuredTextParser.g:9861:4: rule__Func_Call__FuncAlternatives_0_0
					{
						pushFollow(FOLLOW_2);
						rule__Func_Call__FuncAlternatives_0_0();

						state._fsp--;

					}

					after(grammarAccess.getFunc_CallAccess().getFuncAlternatives_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__FuncAssignment_0"

	// $ANTLR start "rule__Func_Call__ArgsAssignment_2_0"
	// InternalStructuredTextParser.g:9869:1: rule__Func_Call__ArgsAssignment_2_0 :
	// ( ruleParam_Assign ) ;
	public final void rule__Func_Call__ArgsAssignment_2_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9873:1: ( ( ruleParam_Assign ) )
			// InternalStructuredTextParser.g:9874:2: ( ruleParam_Assign )
			{
				// InternalStructuredTextParser.g:9874:2: ( ruleParam_Assign )
				// InternalStructuredTextParser.g:9875:3: ruleParam_Assign
				{
					before(grammarAccess.getFunc_CallAccess().getArgsParam_AssignParserRuleCall_2_0_0());
					pushFollow(FOLLOW_2);
					ruleParam_Assign();

					state._fsp--;

					after(grammarAccess.getFunc_CallAccess().getArgsParam_AssignParserRuleCall_2_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__ArgsAssignment_2_0"

	// $ANTLR start "rule__Func_Call__ArgsAssignment_2_1_1"
	// InternalStructuredTextParser.g:9884:1: rule__Func_Call__ArgsAssignment_2_1_1
	// : ( ruleParam_Assign ) ;
	public final void rule__Func_Call__ArgsAssignment_2_1_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9888:1: ( ( ruleParam_Assign ) )
			// InternalStructuredTextParser.g:9889:2: ( ruleParam_Assign )
			{
				// InternalStructuredTextParser.g:9889:2: ( ruleParam_Assign )
				// InternalStructuredTextParser.g:9890:3: ruleParam_Assign
				{
					before(grammarAccess.getFunc_CallAccess().getArgsParam_AssignParserRuleCall_2_1_1_0());
					pushFollow(FOLLOW_2);
					ruleParam_Assign();

					state._fsp--;

					after(grammarAccess.getFunc_CallAccess().getArgsParam_AssignParserRuleCall_2_1_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Func_Call__ArgsAssignment_2_1_1"

	// $ANTLR start "rule__Param_Assign_In__VarAssignment_0_0"
	// InternalStructuredTextParser.g:9899:1:
	// rule__Param_Assign_In__VarAssignment_0_0 : ( RULE_ID ) ;
	public final void rule__Param_Assign_In__VarAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9903:1: ( ( RULE_ID ) )
			// InternalStructuredTextParser.g:9904:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:9904:2: ( RULE_ID )
				// InternalStructuredTextParser.g:9905:3: RULE_ID
				{
					before(grammarAccess.getParam_Assign_InAccess().getVarIDTerminalRuleCall_0_0_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getParam_Assign_InAccess().getVarIDTerminalRuleCall_0_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__VarAssignment_0_0"

	// $ANTLR start "rule__Param_Assign_In__ExprAssignment_1"
	// InternalStructuredTextParser.g:9914:1:
	// rule__Param_Assign_In__ExprAssignment_1 : ( ruleExpression ) ;
	public final void rule__Param_Assign_In__ExprAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9918:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9919:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9919:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9920:3: ruleExpression
				{
					before(grammarAccess.getParam_Assign_InAccess().getExprExpressionParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getParam_Assign_InAccess().getExprExpressionParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_In__ExprAssignment_1"

	// $ANTLR start "rule__Param_Assign_Out__NotAssignment_0"
	// InternalStructuredTextParser.g:9929:1:
	// rule__Param_Assign_Out__NotAssignment_0 : ( ( NOT ) ) ;
	public final void rule__Param_Assign_Out__NotAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9933:1: ( ( ( NOT ) ) )
			// InternalStructuredTextParser.g:9934:2: ( ( NOT ) )
			{
				// InternalStructuredTextParser.g:9934:2: ( ( NOT ) )
				// InternalStructuredTextParser.g:9935:3: ( NOT )
				{
					before(grammarAccess.getParam_Assign_OutAccess().getNotNOTKeyword_0_0());
					// InternalStructuredTextParser.g:9936:3: ( NOT )
					// InternalStructuredTextParser.g:9937:4: NOT
					{
						before(grammarAccess.getParam_Assign_OutAccess().getNotNOTKeyword_0_0());
						match(input, NOT, FOLLOW_2);
						after(grammarAccess.getParam_Assign_OutAccess().getNotNOTKeyword_0_0());

					}

					after(grammarAccess.getParam_Assign_OutAccess().getNotNOTKeyword_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__NotAssignment_0"

	// $ANTLR start "rule__Param_Assign_Out__VarAssignment_1"
	// InternalStructuredTextParser.g:9948:1:
	// rule__Param_Assign_Out__VarAssignment_1 : ( RULE_ID ) ;
	public final void rule__Param_Assign_Out__VarAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9952:1: ( ( RULE_ID ) )
			// InternalStructuredTextParser.g:9953:2: ( RULE_ID )
			{
				// InternalStructuredTextParser.g:9953:2: ( RULE_ID )
				// InternalStructuredTextParser.g:9954:3: RULE_ID
				{
					before(grammarAccess.getParam_Assign_OutAccess().getVarIDTerminalRuleCall_1_0());
					match(input, RULE_ID, FOLLOW_2);
					after(grammarAccess.getParam_Assign_OutAccess().getVarIDTerminalRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__VarAssignment_1"

	// $ANTLR start "rule__Param_Assign_Out__ExprAssignment_3"
	// InternalStructuredTextParser.g:9963:1:
	// rule__Param_Assign_Out__ExprAssignment_3 : ( ruleVariable ) ;
	public final void rule__Param_Assign_Out__ExprAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9967:1: ( ( ruleVariable ) )
			// InternalStructuredTextParser.g:9968:2: ( ruleVariable )
			{
				// InternalStructuredTextParser.g:9968:2: ( ruleVariable )
				// InternalStructuredTextParser.g:9969:3: ruleVariable
				{
					before(grammarAccess.getParam_Assign_OutAccess().getExprVariableParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleVariable();

					state._fsp--;

					after(grammarAccess.getParam_Assign_OutAccess().getExprVariableParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Param_Assign_Out__ExprAssignment_3"

	// $ANTLR start "rule__Variable_Subscript__IndexAssignment_1_2"
	// InternalStructuredTextParser.g:9978:1:
	// rule__Variable_Subscript__IndexAssignment_1_2 : ( ruleExpression ) ;
	public final void rule__Variable_Subscript__IndexAssignment_1_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9982:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9983:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9983:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9984:3: ruleExpression
				{
					before(grammarAccess.getVariable_SubscriptAccess().getIndexExpressionParserRuleCall_1_2_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getVariable_SubscriptAccess().getIndexExpressionParserRuleCall_1_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__IndexAssignment_1_2"

	// $ANTLR start "rule__Variable_Subscript__IndexAssignment_1_3_1"
	// InternalStructuredTextParser.g:9993:1:
	// rule__Variable_Subscript__IndexAssignment_1_3_1 : ( ruleExpression ) ;
	public final void rule__Variable_Subscript__IndexAssignment_1_3_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:9997:1: ( ( ruleExpression ) )
			// InternalStructuredTextParser.g:9998:2: ( ruleExpression )
			{
				// InternalStructuredTextParser.g:9998:2: ( ruleExpression )
				// InternalStructuredTextParser.g:9999:3: ruleExpression
				{
					before(grammarAccess.getVariable_SubscriptAccess().getIndexExpressionParserRuleCall_1_3_1_0());
					pushFollow(FOLLOW_2);
					ruleExpression();

					state._fsp--;

					after(grammarAccess.getVariable_SubscriptAccess().getIndexExpressionParserRuleCall_1_3_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Subscript__IndexAssignment_1_3_1"

	// $ANTLR start "rule__Variable_Adapter__AdapterAssignment_1"
	// InternalStructuredTextParser.g:10008:1:
	// rule__Variable_Adapter__AdapterAssignment_1 : ( ( ruleAdapter_Name ) ) ;
	public final void rule__Variable_Adapter__AdapterAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10012:1: ( ( ( ruleAdapter_Name ) ) )
			// InternalStructuredTextParser.g:10013:2: ( ( ruleAdapter_Name ) )
			{
				// InternalStructuredTextParser.g:10013:2: ( ( ruleAdapter_Name ) )
				// InternalStructuredTextParser.g:10014:3: ( ruleAdapter_Name )
				{
					before(grammarAccess.getVariable_AdapterAccess().getAdapterAdapterDeclarationCrossReference_1_0());
					// InternalStructuredTextParser.g:10015:3: ( ruleAdapter_Name )
					// InternalStructuredTextParser.g:10016:4: ruleAdapter_Name
					{
						before(grammarAccess.getVariable_AdapterAccess()
								.getAdapterAdapterDeclarationAdapter_NameParserRuleCall_1_0_1());
						pushFollow(FOLLOW_2);
						ruleAdapter_Name();

						state._fsp--;

						after(grammarAccess.getVariable_AdapterAccess()
								.getAdapterAdapterDeclarationAdapter_NameParserRuleCall_1_0_1());

					}

					after(grammarAccess.getVariable_AdapterAccess().getAdapterAdapterDeclarationCrossReference_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__AdapterAssignment_1"

	// $ANTLR start "rule__Variable_Adapter__VarAssignment_3"
	// InternalStructuredTextParser.g:10027:1:
	// rule__Variable_Adapter__VarAssignment_3 : ( ( ruleVariable_Name ) ) ;
	public final void rule__Variable_Adapter__VarAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10031:1: ( ( ( ruleVariable_Name ) ) )
			// InternalStructuredTextParser.g:10032:2: ( ( ruleVariable_Name ) )
			{
				// InternalStructuredTextParser.g:10032:2: ( ( ruleVariable_Name ) )
				// InternalStructuredTextParser.g:10033:3: ( ruleVariable_Name )
				{
					before(grammarAccess.getVariable_AdapterAccess().getVarVarDeclarationCrossReference_3_0());
					// InternalStructuredTextParser.g:10034:3: ( ruleVariable_Name )
					// InternalStructuredTextParser.g:10035:4: ruleVariable_Name
					{
						before(grammarAccess.getVariable_AdapterAccess()
								.getVarVarDeclarationVariable_NameParserRuleCall_3_0_1());
						pushFollow(FOLLOW_2);
						ruleVariable_Name();

						state._fsp--;

						after(grammarAccess.getVariable_AdapterAccess()
								.getVarVarDeclarationVariable_NameParserRuleCall_3_0_1());

					}

					after(grammarAccess.getVariable_AdapterAccess().getVarVarDeclarationCrossReference_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Adapter__VarAssignment_3"

	// $ANTLR start "rule__Variable_Primary__VarAssignment"
	// InternalStructuredTextParser.g:10046:1: rule__Variable_Primary__VarAssignment
	// : ( ( ruleVariable_Name ) ) ;
	public final void rule__Variable_Primary__VarAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10050:1: ( ( ( ruleVariable_Name ) ) )
			// InternalStructuredTextParser.g:10051:2: ( ( ruleVariable_Name ) )
			{
				// InternalStructuredTextParser.g:10051:2: ( ( ruleVariable_Name ) )
				// InternalStructuredTextParser.g:10052:3: ( ruleVariable_Name )
				{
					before(grammarAccess.getVariable_PrimaryAccess().getVarVarDeclarationCrossReference_0());
					// InternalStructuredTextParser.g:10053:3: ( ruleVariable_Name )
					// InternalStructuredTextParser.g:10054:4: ruleVariable_Name
					{
						before(grammarAccess.getVariable_PrimaryAccess()
								.getVarVarDeclarationVariable_NameParserRuleCall_0_1());
						pushFollow(FOLLOW_2);
						ruleVariable_Name();

						state._fsp--;

						after(grammarAccess.getVariable_PrimaryAccess()
								.getVarVarDeclarationVariable_NameParserRuleCall_0_1());

					}

					after(grammarAccess.getVariable_PrimaryAccess().getVarVarDeclarationCrossReference_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Variable_Primary__VarAssignment"

	// $ANTLR start "rule__Int_Literal__TypeAssignment_0_0"
	// InternalStructuredTextParser.g:10065:1: rule__Int_Literal__TypeAssignment_0_0
	// : ( ruleInt_Type_Name ) ;
	public final void rule__Int_Literal__TypeAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10069:1: ( ( ruleInt_Type_Name ) )
			// InternalStructuredTextParser.g:10070:2: ( ruleInt_Type_Name )
			{
				// InternalStructuredTextParser.g:10070:2: ( ruleInt_Type_Name )
				// InternalStructuredTextParser.g:10071:3: ruleInt_Type_Name
				{
					before(grammarAccess.getInt_LiteralAccess().getTypeInt_Type_NameEnumRuleCall_0_0_0());
					pushFollow(FOLLOW_2);
					ruleInt_Type_Name();

					state._fsp--;

					after(grammarAccess.getInt_LiteralAccess().getTypeInt_Type_NameEnumRuleCall_0_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__TypeAssignment_0_0"

	// $ANTLR start "rule__Int_Literal__ValueAssignment_1"
	// InternalStructuredTextParser.g:10080:1: rule__Int_Literal__ValueAssignment_1
	// : ( ( rule__Int_Literal__ValueAlternatives_1_0 ) ) ;
	public final void rule__Int_Literal__ValueAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10084:1: ( ( (
			// rule__Int_Literal__ValueAlternatives_1_0 ) ) )
			// InternalStructuredTextParser.g:10085:2: ( (
			// rule__Int_Literal__ValueAlternatives_1_0 ) )
			{
				// InternalStructuredTextParser.g:10085:2: ( (
				// rule__Int_Literal__ValueAlternatives_1_0 ) )
				// InternalStructuredTextParser.g:10086:3: (
				// rule__Int_Literal__ValueAlternatives_1_0 )
				{
					before(grammarAccess.getInt_LiteralAccess().getValueAlternatives_1_0());
					// InternalStructuredTextParser.g:10087:3: (
					// rule__Int_Literal__ValueAlternatives_1_0 )
					// InternalStructuredTextParser.g:10087:4:
					// rule__Int_Literal__ValueAlternatives_1_0
					{
						pushFollow(FOLLOW_2);
						rule__Int_Literal__ValueAlternatives_1_0();

						state._fsp--;

					}

					after(grammarAccess.getInt_LiteralAccess().getValueAlternatives_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Int_Literal__ValueAssignment_1"

	// $ANTLR start "rule__Real_Literal__TypeAssignment_0_0"
	// InternalStructuredTextParser.g:10095:1:
	// rule__Real_Literal__TypeAssignment_0_0 : ( ruleReal_Type_Name ) ;
	public final void rule__Real_Literal__TypeAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10099:1: ( ( ruleReal_Type_Name ) )
			// InternalStructuredTextParser.g:10100:2: ( ruleReal_Type_Name )
			{
				// InternalStructuredTextParser.g:10100:2: ( ruleReal_Type_Name )
				// InternalStructuredTextParser.g:10101:3: ruleReal_Type_Name
				{
					before(grammarAccess.getReal_LiteralAccess().getTypeReal_Type_NameEnumRuleCall_0_0_0());
					pushFollow(FOLLOW_2);
					ruleReal_Type_Name();

					state._fsp--;

					after(grammarAccess.getReal_LiteralAccess().getTypeReal_Type_NameEnumRuleCall_0_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__TypeAssignment_0_0"

	// $ANTLR start "rule__Real_Literal__ValueAssignment_1"
	// InternalStructuredTextParser.g:10110:1: rule__Real_Literal__ValueAssignment_1
	// : ( ruleReal_Value ) ;
	public final void rule__Real_Literal__ValueAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10114:1: ( ( ruleReal_Value ) )
			// InternalStructuredTextParser.g:10115:2: ( ruleReal_Value )
			{
				// InternalStructuredTextParser.g:10115:2: ( ruleReal_Value )
				// InternalStructuredTextParser.g:10116:3: ruleReal_Value
				{
					before(grammarAccess.getReal_LiteralAccess().getValueReal_ValueParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleReal_Value();

					state._fsp--;

					after(grammarAccess.getReal_LiteralAccess().getValueReal_ValueParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Real_Literal__ValueAssignment_1"

	// $ANTLR start "rule__Bool_Literal__TypeAssignment_0_0"
	// InternalStructuredTextParser.g:10125:1:
	// rule__Bool_Literal__TypeAssignment_0_0 : ( ruleBool_Type_Name ) ;
	public final void rule__Bool_Literal__TypeAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10129:1: ( ( ruleBool_Type_Name ) )
			// InternalStructuredTextParser.g:10130:2: ( ruleBool_Type_Name )
			{
				// InternalStructuredTextParser.g:10130:2: ( ruleBool_Type_Name )
				// InternalStructuredTextParser.g:10131:3: ruleBool_Type_Name
				{
					before(grammarAccess.getBool_LiteralAccess().getTypeBool_Type_NameEnumRuleCall_0_0_0());
					pushFollow(FOLLOW_2);
					ruleBool_Type_Name();

					state._fsp--;

					after(grammarAccess.getBool_LiteralAccess().getTypeBool_Type_NameEnumRuleCall_0_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__TypeAssignment_0_0"

	// $ANTLR start "rule__Bool_Literal__ValueAssignment_1"
	// InternalStructuredTextParser.g:10140:1: rule__Bool_Literal__ValueAssignment_1
	// : ( ruleBool_Value ) ;
	public final void rule__Bool_Literal__ValueAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10144:1: ( ( ruleBool_Value ) )
			// InternalStructuredTextParser.g:10145:2: ( ruleBool_Value )
			{
				// InternalStructuredTextParser.g:10145:2: ( ruleBool_Value )
				// InternalStructuredTextParser.g:10146:3: ruleBool_Value
				{
					before(grammarAccess.getBool_LiteralAccess().getValueBool_ValueParserRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleBool_Value();

					state._fsp--;

					after(grammarAccess.getBool_LiteralAccess().getValueBool_ValueParserRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Bool_Literal__ValueAssignment_1"

	// $ANTLR start "rule__Char_Literal__TypeAssignment_0_0"
	// InternalStructuredTextParser.g:10155:1:
	// rule__Char_Literal__TypeAssignment_0_0 : ( ruleString_Type_Name ) ;
	public final void rule__Char_Literal__TypeAssignment_0_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10159:1: ( ( ruleString_Type_Name ) )
			// InternalStructuredTextParser.g:10160:2: ( ruleString_Type_Name )
			{
				// InternalStructuredTextParser.g:10160:2: ( ruleString_Type_Name )
				// InternalStructuredTextParser.g:10161:3: ruleString_Type_Name
				{
					before(grammarAccess.getChar_LiteralAccess().getTypeString_Type_NameEnumRuleCall_0_0_0());
					pushFollow(FOLLOW_2);
					ruleString_Type_Name();

					state._fsp--;

					after(grammarAccess.getChar_LiteralAccess().getTypeString_Type_NameEnumRuleCall_0_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__TypeAssignment_0_0"

	// $ANTLR start "rule__Char_Literal__LengthAssignment_0_1"
	// InternalStructuredTextParser.g:10170:1:
	// rule__Char_Literal__LengthAssignment_0_1 : ( RULE_UNSIGNED_INT ) ;
	public final void rule__Char_Literal__LengthAssignment_0_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10174:1: ( ( RULE_UNSIGNED_INT ) )
			// InternalStructuredTextParser.g:10175:2: ( RULE_UNSIGNED_INT )
			{
				// InternalStructuredTextParser.g:10175:2: ( RULE_UNSIGNED_INT )
				// InternalStructuredTextParser.g:10176:3: RULE_UNSIGNED_INT
				{
					before(grammarAccess.getChar_LiteralAccess().getLengthUNSIGNED_INTTerminalRuleCall_0_1_0());
					match(input, RULE_UNSIGNED_INT, FOLLOW_2);
					after(grammarAccess.getChar_LiteralAccess().getLengthUNSIGNED_INTTerminalRuleCall_0_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__LengthAssignment_0_1"

	// $ANTLR start "rule__Char_Literal__ValueAssignment_1"
	// InternalStructuredTextParser.g:10185:1: rule__Char_Literal__ValueAssignment_1
	// : ( ( rule__Char_Literal__ValueAlternatives_1_0 ) ) ;
	public final void rule__Char_Literal__ValueAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10189:1: ( ( (
			// rule__Char_Literal__ValueAlternatives_1_0 ) ) )
			// InternalStructuredTextParser.g:10190:2: ( (
			// rule__Char_Literal__ValueAlternatives_1_0 ) )
			{
				// InternalStructuredTextParser.g:10190:2: ( (
				// rule__Char_Literal__ValueAlternatives_1_0 ) )
				// InternalStructuredTextParser.g:10191:3: (
				// rule__Char_Literal__ValueAlternatives_1_0 )
				{
					before(grammarAccess.getChar_LiteralAccess().getValueAlternatives_1_0());
					// InternalStructuredTextParser.g:10192:3: (
					// rule__Char_Literal__ValueAlternatives_1_0 )
					// InternalStructuredTextParser.g:10192:4:
					// rule__Char_Literal__ValueAlternatives_1_0
					{
						pushFollow(FOLLOW_2);
						rule__Char_Literal__ValueAlternatives_1_0();

						state._fsp--;

					}

					after(grammarAccess.getChar_LiteralAccess().getValueAlternatives_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Char_Literal__ValueAssignment_1"

	// $ANTLR start "rule__Duration__TypeAssignment_0"
	// InternalStructuredTextParser.g:10200:1: rule__Duration__TypeAssignment_0 : (
	// ruleTime_Type_Name ) ;
	public final void rule__Duration__TypeAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10204:1: ( ( ruleTime_Type_Name ) )
			// InternalStructuredTextParser.g:10205:2: ( ruleTime_Type_Name )
			{
				// InternalStructuredTextParser.g:10205:2: ( ruleTime_Type_Name )
				// InternalStructuredTextParser.g:10206:3: ruleTime_Type_Name
				{
					before(grammarAccess.getDurationAccess().getTypeTime_Type_NameEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleTime_Type_Name();

					state._fsp--;

					after(grammarAccess.getDurationAccess().getTypeTime_Type_NameEnumRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__TypeAssignment_0"

	// $ANTLR start "rule__Duration__NegativeAssignment_2_1"
	// InternalStructuredTextParser.g:10215:1:
	// rule__Duration__NegativeAssignment_2_1 : ( ( HyphenMinus ) ) ;
	public final void rule__Duration__NegativeAssignment_2_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10219:1: ( ( ( HyphenMinus ) ) )
			// InternalStructuredTextParser.g:10220:2: ( ( HyphenMinus ) )
			{
				// InternalStructuredTextParser.g:10220:2: ( ( HyphenMinus ) )
				// InternalStructuredTextParser.g:10221:3: ( HyphenMinus )
				{
					before(grammarAccess.getDurationAccess().getNegativeHyphenMinusKeyword_2_1_0());
					// InternalStructuredTextParser.g:10222:3: ( HyphenMinus )
					// InternalStructuredTextParser.g:10223:4: HyphenMinus
					{
						before(grammarAccess.getDurationAccess().getNegativeHyphenMinusKeyword_2_1_0());
						match(input, HyphenMinus, FOLLOW_2);
						after(grammarAccess.getDurationAccess().getNegativeHyphenMinusKeyword_2_1_0());

					}

					after(grammarAccess.getDurationAccess().getNegativeHyphenMinusKeyword_2_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__NegativeAssignment_2_1"

	// $ANTLR start "rule__Duration__ValueAssignment_3"
	// InternalStructuredTextParser.g:10234:1: rule__Duration__ValueAssignment_3 : (
	// ruleDuration_Value ) ;
	public final void rule__Duration__ValueAssignment_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10238:1: ( ( ruleDuration_Value ) )
			// InternalStructuredTextParser.g:10239:2: ( ruleDuration_Value )
			{
				// InternalStructuredTextParser.g:10239:2: ( ruleDuration_Value )
				// InternalStructuredTextParser.g:10240:3: ruleDuration_Value
				{
					before(grammarAccess.getDurationAccess().getValueDuration_ValueParserRuleCall_3_0());
					pushFollow(FOLLOW_2);
					ruleDuration_Value();

					state._fsp--;

					after(grammarAccess.getDurationAccess().getValueDuration_ValueParserRuleCall_3_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__ValueAssignment_3"

	// $ANTLR start "rule__Duration__ValueAssignment_4_1"
	// InternalStructuredTextParser.g:10249:1: rule__Duration__ValueAssignment_4_1 :
	// ( ruleDuration_Value ) ;
	public final void rule__Duration__ValueAssignment_4_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10253:1: ( ( ruleDuration_Value ) )
			// InternalStructuredTextParser.g:10254:2: ( ruleDuration_Value )
			{
				// InternalStructuredTextParser.g:10254:2: ( ruleDuration_Value )
				// InternalStructuredTextParser.g:10255:3: ruleDuration_Value
				{
					before(grammarAccess.getDurationAccess().getValueDuration_ValueParserRuleCall_4_1_0());
					pushFollow(FOLLOW_2);
					ruleDuration_Value();

					state._fsp--;

					after(grammarAccess.getDurationAccess().getValueDuration_ValueParserRuleCall_4_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration__ValueAssignment_4_1"

	// $ANTLR start "rule__Duration_Value__ValueAssignment_0"
	// InternalStructuredTextParser.g:10264:1:
	// rule__Duration_Value__ValueAssignment_0 : ( ruleFix_Point ) ;
	public final void rule__Duration_Value__ValueAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10268:1: ( ( ruleFix_Point ) )
			// InternalStructuredTextParser.g:10269:2: ( ruleFix_Point )
			{
				// InternalStructuredTextParser.g:10269:2: ( ruleFix_Point )
				// InternalStructuredTextParser.g:10270:3: ruleFix_Point
				{
					before(grammarAccess.getDuration_ValueAccess().getValueFix_PointParserRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleFix_Point();

					state._fsp--;

					after(grammarAccess.getDuration_ValueAccess().getValueFix_PointParserRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__ValueAssignment_0"

	// $ANTLR start "rule__Duration_Value__UnitAssignment_1"
	// InternalStructuredTextParser.g:10279:1:
	// rule__Duration_Value__UnitAssignment_1 : ( ruleDuration_Unit ) ;
	public final void rule__Duration_Value__UnitAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10283:1: ( ( ruleDuration_Unit ) )
			// InternalStructuredTextParser.g:10284:2: ( ruleDuration_Unit )
			{
				// InternalStructuredTextParser.g:10284:2: ( ruleDuration_Unit )
				// InternalStructuredTextParser.g:10285:3: ruleDuration_Unit
				{
					before(grammarAccess.getDuration_ValueAccess().getUnitDuration_UnitEnumRuleCall_1_0());
					pushFollow(FOLLOW_2);
					ruleDuration_Unit();

					state._fsp--;

					after(grammarAccess.getDuration_ValueAccess().getUnitDuration_UnitEnumRuleCall_1_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Duration_Value__UnitAssignment_1"

	// $ANTLR start "rule__Time_Of_Day__TypeAssignment_0"
	// InternalStructuredTextParser.g:10294:1: rule__Time_Of_Day__TypeAssignment_0 :
	// ( ruleTod_Type_Name ) ;
	public final void rule__Time_Of_Day__TypeAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10298:1: ( ( ruleTod_Type_Name ) )
			// InternalStructuredTextParser.g:10299:2: ( ruleTod_Type_Name )
			{
				// InternalStructuredTextParser.g:10299:2: ( ruleTod_Type_Name )
				// InternalStructuredTextParser.g:10300:3: ruleTod_Type_Name
				{
					before(grammarAccess.getTime_Of_DayAccess().getTypeTod_Type_NameEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleTod_Type_Name();

					state._fsp--;

					after(grammarAccess.getTime_Of_DayAccess().getTypeTod_Type_NameEnumRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__TypeAssignment_0"

	// $ANTLR start "rule__Time_Of_Day__ValueAssignment_2"
	// InternalStructuredTextParser.g:10309:1: rule__Time_Of_Day__ValueAssignment_2
	// : ( ruleDaytime ) ;
	public final void rule__Time_Of_Day__ValueAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10313:1: ( ( ruleDaytime ) )
			// InternalStructuredTextParser.g:10314:2: ( ruleDaytime )
			{
				// InternalStructuredTextParser.g:10314:2: ( ruleDaytime )
				// InternalStructuredTextParser.g:10315:3: ruleDaytime
				{
					before(grammarAccess.getTime_Of_DayAccess().getValueDaytimeParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleDaytime();

					state._fsp--;

					after(grammarAccess.getTime_Of_DayAccess().getValueDaytimeParserRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Time_Of_Day__ValueAssignment_2"

	// $ANTLR start "rule__Date__TypeAssignment_0"
	// InternalStructuredTextParser.g:10324:1: rule__Date__TypeAssignment_0 : (
	// ruleDate_Type_Name ) ;
	public final void rule__Date__TypeAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10328:1: ( ( ruleDate_Type_Name ) )
			// InternalStructuredTextParser.g:10329:2: ( ruleDate_Type_Name )
			{
				// InternalStructuredTextParser.g:10329:2: ( ruleDate_Type_Name )
				// InternalStructuredTextParser.g:10330:3: ruleDate_Type_Name
				{
					before(grammarAccess.getDateAccess().getTypeDate_Type_NameEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleDate_Type_Name();

					state._fsp--;

					after(grammarAccess.getDateAccess().getTypeDate_Type_NameEnumRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__TypeAssignment_0"

	// $ANTLR start "rule__Date__ValueAssignment_2"
	// InternalStructuredTextParser.g:10339:1: rule__Date__ValueAssignment_2 : (
	// ruleDate_Literal ) ;
	public final void rule__Date__ValueAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10343:1: ( ( ruleDate_Literal ) )
			// InternalStructuredTextParser.g:10344:2: ( ruleDate_Literal )
			{
				// InternalStructuredTextParser.g:10344:2: ( ruleDate_Literal )
				// InternalStructuredTextParser.g:10345:3: ruleDate_Literal
				{
					before(grammarAccess.getDateAccess().getValueDate_LiteralParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleDate_Literal();

					state._fsp--;

					after(grammarAccess.getDateAccess().getValueDate_LiteralParserRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date__ValueAssignment_2"

	// $ANTLR start "rule__Date_And_Time__TypeAssignment_0"
	// InternalStructuredTextParser.g:10354:1: rule__Date_And_Time__TypeAssignment_0
	// : ( ruleDT_Type_Name ) ;
	public final void rule__Date_And_Time__TypeAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10358:1: ( ( ruleDT_Type_Name ) )
			// InternalStructuredTextParser.g:10359:2: ( ruleDT_Type_Name )
			{
				// InternalStructuredTextParser.g:10359:2: ( ruleDT_Type_Name )
				// InternalStructuredTextParser.g:10360:3: ruleDT_Type_Name
				{
					before(grammarAccess.getDate_And_TimeAccess().getTypeDT_Type_NameEnumRuleCall_0_0());
					pushFollow(FOLLOW_2);
					ruleDT_Type_Name();

					state._fsp--;

					after(grammarAccess.getDate_And_TimeAccess().getTypeDT_Type_NameEnumRuleCall_0_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__TypeAssignment_0"

	// $ANTLR start "rule__Date_And_Time__ValueAssignment_2"
	// InternalStructuredTextParser.g:10369:1:
	// rule__Date_And_Time__ValueAssignment_2 : ( ruleDate_And_Time_Value ) ;
	public final void rule__Date_And_Time__ValueAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// InternalStructuredTextParser.g:10373:1: ( ( ruleDate_And_Time_Value ) )
			// InternalStructuredTextParser.g:10374:2: ( ruleDate_And_Time_Value )
			{
				// InternalStructuredTextParser.g:10374:2: ( ruleDate_And_Time_Value )
				// InternalStructuredTextParser.g:10375:3: ruleDate_And_Time_Value
				{
					before(grammarAccess.getDate_And_TimeAccess().getValueDate_And_Time_ValueParserRuleCall_2_0());
					pushFollow(FOLLOW_2);
					ruleDate_And_Time_Value();

					state._fsp--;

					after(grammarAccess.getDate_And_TimeAccess().getValueDate_And_Time_ValueParserRuleCall_2_0());

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}
	// $ANTLR end "rule__Date_And_Time__ValueAssignment_2"

	// Delegated rules

	protected DFA5 dfa5 = new DFA5(this);
	static final String dfa_1s = "\12\uffff";
	static final String dfa_2s = "\5\uffff\3\4\2\uffff";
	static final String dfa_3s = "\1\4\2\57\2\uffff\3\10\1\116\1\uffff";
	static final String dfa_4s = "\1\163\2\157\2\uffff\3\140\1\120\1\uffff";
	static final String dfa_5s = "\3\uffff\1\1\1\2\4\uffff\1\3";
	static final String dfa_6s = "\12\uffff}>";
	static final String[] dfa_7s = {
			"\4\11\7\uffff\1\11\3\uffff\1\11\2\uffff\4\11\2\uffff\2\11\1\uffff\2\11\1\uffff\1\11\2\uffff\3\11\2\uffff\4\11\1\uffff\1\10\2\11\3\uffff\2\11\1\uffff\1\3\1\11\12\uffff\1\7\1\uffff\1\11\1\6\10\uffff\1\4\2\uffff\1\2\1\uffff\1\1\10\uffff\1\5\3\uffff\1\11\10\uffff\1\4\4\11\1\uffff\1\11\1\uffff\1\11",
			"\1\3\24\uffff\1\3\2\uffff\1\3\10\uffff\1\3\15\uffff\1\3\14\uffff\1\3\3\uffff\1\11",
			"\1\3\24\uffff\1\3\2\uffff\1\3\10\uffff\1\3\15\uffff\1\3\14\uffff\1\3\3\uffff\1\11", "", "",
			"\1\4\45\uffff\1\4\4\uffff\1\4\3\uffff\1\4\3\uffff\2\4\1\uffff\2\4\1\uffff\3\4\4\uffff\3\4\3\uffff\1\11\1\4\1\uffff\7\4\1\uffff\4\4\2\uffff\2\4",
			"\1\4\45\uffff\1\4\4\uffff\1\4\3\uffff\1\4\3\uffff\2\4\1\uffff\2\4\1\uffff\3\4\4\uffff\3\4\3\uffff\1\11\1\4\1\uffff\7\4\1\uffff\4\4\2\uffff\2\4",
			"\1\4\45\uffff\1\4\4\uffff\1\4\3\uffff\1\4\3\uffff\2\4\1\uffff\2\4\1\uffff\3\4\4\uffff\3\4\3\uffff\1\11\1\4\1\uffff\7\4\1\uffff\4\4\2\uffff\2\4",
			"\1\11\1\uffff\1\4", "" };

	static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
	static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
	static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
	static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
	static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
	static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
	static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

	class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_7;
		}

		@Override
		public String getDescription() {
			return "2161:1: rule__Unary_Expr__Alternatives : ( ( ( rule__Unary_Expr__Group_0__0 ) ) | ( rulePrimary_Expr ) | ( ruleConstant ) );";
		}
	}

	public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0410821208060800L, 0x00000800420000B0L });
	public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x0000000000004400L, 0x0000080000000000L });
	public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x0000000000000402L, 0x0000080000000000L });
	public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000002000000L });
	public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000000400L, 0x0000080000000000L });
	public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000001000000L });
	public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0222BCE5B38880F0L, 0x0000080000000000L });
	public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x2000000000000000L, 0x0000000080000000L });
	public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x0000000000000000L, 0x0000800000000000L });
	public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000100000000L });
	public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0263BCE5B3C880F0L, 0x000AF004402800D0L });
	public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x0010821208060802L, 0x00000800420000B0L });
	public static final BitSet FOLLOW_15 = new BitSet(new long[] { 0x0010821208060800L, 0x00000800420000B0L });
	public static final BitSet FOLLOW_16 = new BitSet(new long[] { 0x2000000000000000L });
	public static final BitSet FOLLOW_17 = new BitSet(new long[] { 0x0363BCE5B3C880F0L, 0x000AF804402900D0L });
	public static final BitSet FOLLOW_18 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_19 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000010000L });
	public static final BitSet FOLLOW_20 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000020000L });
	public static final BitSet FOLLOW_21 = new BitSet(new long[] { 0x0000800008040000L, 0x0000080000000000L });
	public static final BitSet FOLLOW_22 = new BitSet(new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_23 = new BitSet(new long[] { 0x0000010000210000L });
	public static final BitSet FOLLOW_24 = new BitSet(new long[] { 0x0000000000200002L });
	public static final BitSet FOLLOW_25 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000100L });
	public static final BitSet FOLLOW_26 = new BitSet(new long[] { 0x0000010000001000L });
	public static final BitSet FOLLOW_27 = new BitSet(new long[] { 0x0263BCE5B3C880F2L, 0x000AF004402800D0L });
	public static final BitSet FOLLOW_28 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000001100000L });
	public static final BitSet FOLLOW_29 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000100000L });
	public static final BitSet FOLLOW_30 = new BitSet(new long[] { 0x0000020000000000L });
	public static final BitSet FOLLOW_31 = new BitSet(new long[] { 0x0010821208060800L, 0x00000800400000B0L });
	public static final BitSet FOLLOW_32 = new BitSet(new long[] { 0x0000000000000000L, 0x0000080040000090L });
	public static final BitSet FOLLOW_33 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000400L });
	public static final BitSet FOLLOW_34 = new BitSet(new long[] { 0x0000000000000000L, 0x000000000000000CL });
	public static final BitSet FOLLOW_35 = new BitSet(new long[] { 0x0000000000002000L });
	public static final BitSet FOLLOW_36 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000008L });
	public static final BitSet FOLLOW_37 = new BitSet(new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_38 = new BitSet(new long[] { 0x0000000040000000L });
	public static final BitSet FOLLOW_39 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_40 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000200L });
	public static final BitSet FOLLOW_41 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000000200L });
	public static final BitSet FOLLOW_42 = new BitSet(new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_43 = new BitSet(new long[] { 0x0800000000000002L });
	public static final BitSet FOLLOW_44 = new BitSet(new long[] { 0x0008000000000000L, 0x0000000000008000L });
	public static final BitSet FOLLOW_45 = new BitSet(new long[] { 0x0008000000000002L, 0x0000000000008000L });
	public static final BitSet FOLLOW_46 = new BitSet(new long[] { 0x8000000000000000L, 0x0000000008000000L });
	public static final BitSet FOLLOW_47 = new BitSet(new long[] { 0x8000000000000002L, 0x0000000008000000L });
	public static final BitSet FOLLOW_48 = new BitSet(new long[] { 0x4000000000000000L, 0x0000000014000002L });
	public static final BitSet FOLLOW_49 = new BitSet(new long[] { 0x4000000000000002L, 0x0000000014000002L });
	public static final BitSet FOLLOW_50 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000280000L });
	public static final BitSet FOLLOW_51 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000280000L });
	public static final BitSet FOLLOW_52 = new BitSet(new long[] { 0x0080000000000000L, 0x0000000000840000L });
	public static final BitSet FOLLOW_53 = new BitSet(new long[] { 0x0080000000000002L, 0x0000000000840000L });
	public static final BitSet FOLLOW_54 = new BitSet(new long[] { 0x1000000000000000L });
	public static final BitSet FOLLOW_55 = new BitSet(new long[] { 0x1000000000000002L });
	public static final BitSet FOLLOW_56 = new BitSet(new long[] { 0x0100000000000000L, 0x0000000000280000L });
	public static final BitSet FOLLOW_57 = new BitSet(new long[] { 0x0000800000000000L, 0x0000080040010090L });
	public static final BitSet FOLLOW_58 = new BitSet(new long[] { 0x0363BCE5B3C880F0L, 0x000AF804402B00D0L });
	public static final BitSet FOLLOW_59 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000100000L });
	public static final BitSet FOLLOW_60 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_61 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000080000000L });
	public static final BitSet FOLLOW_62 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000100100000L });
	public static final BitSet FOLLOW_63 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000400000L });
	public static final BitSet FOLLOW_64 = new BitSet(new long[] { 0x00222480B0000000L, 0x0000F00000280000L });
	public static final BitSet FOLLOW_65 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000004000L });
	public static final BitSet FOLLOW_66 = new BitSet(new long[] { 0x0000000000000000L, 0x0000800000280000L });
	public static final BitSet FOLLOW_67 = new BitSet(new long[] { 0x00223480B1000000L, 0x0000F00000280000L });
	public static final BitSet FOLLOW_68 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000020000000L });
	public static final BitSet FOLLOW_69 = new BitSet(new long[] { 0x0000002100088000L, 0x000A000000000000L });
	public static final BitSet FOLLOW_70 = new BitSet(new long[] { 0x0000000000000000L, 0x0000800000004000L });
	public static final BitSet FOLLOW_71 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000200000000L });
	public static final BitSet FOLLOW_72 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000200000000L });
	public static final BitSet FOLLOW_73 = new BitSet(new long[] { 0x0000000000000000L, 0x0000003C00003800L });
	public static final BitSet FOLLOW_74 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000200000L });

}