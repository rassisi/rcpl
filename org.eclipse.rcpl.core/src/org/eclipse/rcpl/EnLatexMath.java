package org.eclipse.rcpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramin
 *
 */
public enum EnLatexMath implements IMath {

//	PLUS("+", "", "", 0),
//
//	MINUS("-", "", "", 0),
//
//	EQUAL("=", "", "", 0),
//
//	EXCLAMATION("!", "", "", 0),
//
//	SLASH("/", "", "", 0),
//
//	LEFT_ROUND_BRACKET("(", "", "", 0),
//
//	RIGHT_ROUND_BREAKET(")", "", "", 0),
//
//	LEFT_BRAKET("[", "", "", 0),
//
//	RIGHT_BRAKET("]", "", "", 0),
//
//	LESS_THEN("<", "", "", 0),
//
//	GREATER_THEN(">", "", "", 0),
//
//	VERTICAL_LINE("|", "", "", 0),
//
//	APOSTROPH("'", "", "", 0),
//
//	DOUBLE_DOT(":", "", "", 0),
//
//	ASTERIX("*", "", "", 0),
//

	beginArrayLeft(Structures, "al", "Array Left", 0, "\\begin{array}{l}\n\n\\end{array} ", 17),

	beginArrayCenter(Structures, "ac", "Array Left", 0, "\\begin{array}{c}\n\n\\end{array} ", 17),

	beginArrayRight(Structures, "ar", "Array Left", 0, "\\begin{array}{r}\n\n\\end{array} ", 17),

	// ---------- Mathematical Operators ---

	fraction(Structures, "/", "Fraction", 0, "\\frac{x}{y} ", 0),

	M_8704(Operators, "∀", "", 8704, "∀", 0),

	M_8705(Operators, "∁", "", 8705, "∁", 0),

	M_8706(Operators, "∂", "", 8706, "∂", 0),

	M_8707(Operators, "∃", "", 8707, "∃", 0),

	M_8708(Operators, "∄", "", 8708, "∄", 0),

	M_8709(Operators, "∅", "", 8709, "∅", 0),

	M_8710(Operators, "∆", "", 8710, "∆", 0),

	M_8711(Operators, "∇", "", 8711, "∇", 0),

	M_8712(Operators, "∈", "", 8712, "M_8712", 0),

	M_8713(Operators, "∉", "", 8713, "M_8713", 0),

	M_8714(Operators, "∊", "", 8714, "M_8714", 0),

	M_8715(Operators, "∋", "", 8715, "M_8715", 0),

	M_8716(Operators, "∌", "", 8716, "M_8716", 0),

	M_8717(Operators, "∍", "", 8717, "M_8717", 0),

	M_8718(Operators, "∎", "", 8718, "M_8718", 0),

	M_8719(Operators, "∏", "", 8719, "M_8719", 0),

	M_8720(Operators, "∐", "", 8720, "M_8720", 0),

	M_8721(Operators, "∑", "", 8721, "\\sum_{\\substack{\n   0<i<m\n  0<j<n\n }}\n P(i,j)", 0),

	M_8722(Operators, "−", "", 8722, "M_8722", 0),

	M_8723(Operators, "∓", "", 8723, "M_8723", 0),

	M_8724(Operators, "∔", "", 8724, "M_8724", 0),

	M_8725(Operators, "∕", "", 8725, "M_8725", 0),

	M_8726(Operators, "∖", "", 8726, "M_8726", 0),

	M_8727(Operators, "∗", "", 8727, "M_8727", 0),

	M_8728(Operators, "∘", "", 8728, "M_8728", 0),

	M_8729(Operators, "∙", "", 8729, "M_8729", 0),

	SQRT(Operators, "√", "Squareroot", 8730, "\\sqrt{x}", 0),

	M_8731(Operators, "∛", "", 8731, "M_8731", 0),

	M_8732(Operators, "∜", "", 8732, "M_8732", 0),

	M_8733(Operators, "∝", "", 8733, "M_8733", 0),

	M_8734(Operators, "∞", "", 8734, "\\infty", 0),

	M_8735(Operators, "∟", "", 8735, "M_8735", 0),

	M_8736(Operators, "∠", "", 8736, "M_8736", 0),

	M_8737(Operators, "∡", "", 8737, "M_8737", 0),

	M_8738(Operators, "∢", "", 8738, "M_8738", 0),

	M_8739(Operators, "∣", "", 8739, "M_8739", 0),

	M_8740(Operators, "∤", "", 8740, "M_8740", 0),

	M_8741(Operators, "∥", "", 8741, "M_8741", 0),

	M_8742(Operators, "∦", "", 8742, "M_8742", 0),

	M_8743(Operators, "∧", "", 8743, "M_8743", 0),

	M_8744(Operators, "∨", "", 8744, "M_8744", 0),

	M_8745(Operators, "∩", "", 8745, "M_8745", 0),

	M_8746(Operators, "∪", "", 8746, "M_8746", 0),

	M_8747(Operators, "∫", "", 8747, "\\int_a^\\b", 0),

	M_8748(Operators, "∬", "", 8748, "\\iint_a^\\b", 0),

	M_8749(Operators, "∭", "", 8749, "\\iiint_a^\\b", 0),

	M_8750(Operators, "∮", "", 8750, "M_8750", 0),

	M_8751(Operators, "∯", "", 8751, "M_8751", 0),

	M_8752(Operators, "∰", "", 8752, "M_8752", 0),

	M_8753(Operators, "∱", "", 8753, "M_8753", 0),

	M_8754(Operators, "∲", "", 8754, "M_8754", 0),

	M_8755(Operators, "∳", "", 8755, "M_8755", 0),

	M_8756(Operators, "∴", "", 8756, "M_8756", 0),

	M_8757(Operators, "∵", "", 8757, "M_8757", 0),

	M_8758(Operators, "∶", "", 8758, "M_8758", 0),

	M_8759(Operators, "∷", "", 8759, "M_8759", 0),

	M_8760(Operators, "∸", "", 8760, "M_8760", 0),

	M_8761(Operators, "∹", "", 8761, "M_8761", 0),

	M_8762(Operators, "∺", "", 8762, "M_8762", 0),

	M_8763(Operators, "∻", "", 8763, "M_8763", 0),

	M_8764(Operators, "∼", "", 8764, "M_8764", 0),

	M_8765(Operators, "∽", "", 8765, "M_8765", 0),

	M_8766(Operators, "∾", "", 8766, "M_8766", 0),

	M_8767(Operators, "∿", "", 8767, "M_8767", 0),

	M_8768(Operators, "≀", "", 8768, "M_8768", 0),

	M_8769(Operators, "≁", "", 8769, "M_8769", 0),

	M_8770(Operators, "≂", "", 8770, "M_8770", 0),

	M_8771(Operators, "≃", "", 8771, "M_8771", 0),

	M_8772(Operators, "≄", "", 8772, "M_8772", 0),

	M_8773(Operators, "≅", "", 8773, "M_8773", 0),

	M_8774(Operators, "≆", "", 8774, "M_8774", 0),

	M_8775(Operators, "≇", "", 8775, "M_8775", 0),

	M_8776(Operators, "≈", "", 8776, "M_8776", 0),

	M_8777(Operators, "≉", "", 8777, "M_8777", 0),

	M_8778(Operators, "≊", "", 8778, "M_8778", 0),

	M_8779(Operators, "≋", "", 8779, "M_8779", 0),

	M_8780(Operators, "≌", "", 8780, "M_8780", 0),

	M_8781(Operators, "≍", "", 8781, "M_8781", 0),

	M_8782(Operators, "≎", "", 8782, "M_8782", 0),

	M_8783(Operators, "≏", "", 8783, "M_8783", 0),

	M_8784(Operators, "≐", "", 8784, "M_8784", 0),

	M_8785(Operators, "≑", "", 8785, "M_8785", 0),

	M_8786(Operators, "≒", "", 8786, "M_8786", 0),

	M_8787(Operators, "≓", "", 8787, "M_8787", 0),

	M_8788(Operators, "≔", "", 8788, "M_8788", 0),

	M_8789(Operators, "≕", "", 8789, "M_8789", 0),

	M_8790(Operators, "≖", "", 8790, "M_8790", 0),

	M_8791(Operators, "≗", "", 8791, "M_8791", 0),

	M_8792(Operators, "≘", "", 8792, "M_8792", 0),

	M_8793(Operators, "≙", "", 8793, "M_8793", 0),

	M_8794(Operators, "≚", "", 8794, "M_8794", 0),

	M_8795(Operators, "≛", "", 8795, "M_8795", 0),

	M_8796(Operators, "≜", "", 8796, "M_8796", 0),

	M_8797(Operators, "≝", "", 8797, "M_8797", 0),

	M_8798(Operators, "≞", "", 8798, "M_8798", 0),

	M_8799(Operators, "≟", "", 8799, "M_8799", 0),

	M_8800(Operators, "≠", "", 8800, "M_8800", 0),

	M_8801(Operators, "≡", "", 8801, "M_8801", 0),

	M_8802(Operators, "≢", "", 8802, "M_8802", 0),

	M_8803(Operators, "≣", "", 8803, "M_8803", 0),

	M_8804(Operators, "≤", "", 8804, "M_8804", 0),

	M_8805(Operators, "≥", "", 8805, "M_8805", 0),

	M_8806(Operators, "≦", "", 8806, "M_8806", 0),

	M_8807(Operators, "≧", "", 8807, "M_8807", 0),

	M_8808(Operators, "≨", "", 8808, "M_8808", 0),

	M_8809(Operators, "≩", "", 8809, "M_8809", 0),

	M_8810(Operators, "≪", "", 8810, "M_8810", 0),

	M_8811(Operators, "≫", "", 8811, "M_8811", 0),

	M_8812(Operators, "≬", "", 8812, "M_8812", 0),

	M_8813(Operators, "≭", "", 8813, "M_8813", 0),

	M_8814(Operators, "≮", "", 8814, "M_8814", 0),

	M_8815(Operators, "≯", "", 8815, "M_8815", 0),

	M_8816(Operators, "≰", "", 8816, "M_8816", 0),

	M_8817(Operators, "≱", "", 8817, "M_8817", 0),

	M_8818(Operators, "≲", "", 8818, "M_8818", 0),

	M_8819(Operators, "≳", "", 8819, "M_8819", 0),

	M_8820(Operators, "≴", "", 8820, "M_8820", 0),

	M_8821(Operators, "≵", "", 8821, "M_8821", 0),

	M_8822(Operators, "≶", "", 8822, "M_8822", 0),

	M_8823(Operators, "≷", "", 8823, "M_8823", 0),

	M_8824(Operators, "≸", "", 8824, "M_8824", 0),

	M_8825(Operators, "≹", "", 8825, "M_8825", 0),

	M_8826(Operators, "≺", "", 8826, "M_8826", 0),

	M_8827(Operators, "≻", "", 8827, "M_8827", 0),

	M_8828(Operators, "≼", "", 8828, "M_8828", 0),

	M_8829(Operators, "≽", "", 8829, "M_8829", 0),

	M_8830(Operators, "≾", "", 8830, "M_8830", 0),

	M_8831(Operators, "≿", "", 8831, "M_8831", 0),

	M_8832(Operators, "⊀", "", 8832, "M_8832", 0),

	M_8833(Operators, "⊁", "", 8833, "M_8833", 0),

	M_8834(Operators, "⊂", "", 8834, "M_8834", 0),

	M_8835(Operators, "⊃", "", 8835, "M_8835", 0),

	M_8836(Operators, "⊄", "", 8836, "M_8836", 0),

	M_8837(Operators, "⊅", "", 8837, "M_8837", 0),

	M_8838(Operators, "⊆", "", 8838, "M_8838", 0),

	M_8839(Operators, "⊇", "", 8839, "M_8839", 0),

	M_8840(Operators, "⊈", "", 8840, "M_8840", 0),

	M_8841(Operators, "⊉", "", 8841, "M_8841", 0),

	M_8842(Operators, "⊊", "", 8842, "M_8842", 0),

	M_8843(Operators, "⊋", "", 8843, "M_8843", 0),

	M_8844(Operators, "⊌", "", 8844, "M_8844", 0),

	M_8845(Operators, "⊍", "", 8845, "M_8845", 0),

	M_8846(Operators, "⊎", "", 8846, "M_8846", 0),

	M_8847(Operators, "⊏", "", 8847, "M_8847", 0),

	M_8848(Operators, "⊐", "", 8848, "M_8848", 0),

	M_8849(Operators, "⊑", "", 8849, "M_8849", 0),

	M_8850(Operators, "⊒", "", 8850, "M_8850", 0),

	M_8851(Operators, "⊓", "", 8851, "M_8851", 0),

	M_8852(Operators, "⊔", "", 8852, "M_8852", 0),

	M_8853(Operators, "⊕", "", 8853, "M_8853", 0),

	M_8854(Operators, "⊖", "", 8854, "M_8854", 0),

	M_8855(Operators, "⊗", "", 8855, "M_8855", 0),

	M_8856(Operators, "⊘", "", 8856, "M_8856", 0),

	M_8857(Operators, "⊙", "", 8857, "M_8857", 0),

	M_8858(Operators, "⊚", "", 8858, "M_8858", 0),

	M_8859(Operators, "⊛", "", 8859, "M_8859", 0),

	M_8860(Operators, "⊜", "", 8860, "M_8860", 0),

	M_8861(Operators, "⊝", "", 8861, "M_8861", 0),

	M_8862(Operators, "⊞", "", 8862, "M_8862", 0),

	M_8863(Operators, "⊟", "", 8863, "M_8863", 0),

	M_8864(Operators, "⊠", "", 8864, "M_8864", 0),

	M_8865(Operators, "⊡", "", 8865, "M_8865", 0),

	M_8866(Operators, "⊢", "", 8866, "M_8866", 0),

	M_8867(Operators, "⊣", "", 8867, "M_8867", 0),

	M_8868(Operators, "⊤", "", 8868, "M_8868", 0),

	M_8869(Operators, "⊥", "", 8869, "M_8869", 0),

	M_8870(Operators, "⊦", "", 8870, "M_8870", 0),

	M_8871(Operators, "⊧", "", 8871, "M_8871", 0),

	M_8872(Operators, "⊨", "", 8872, "M_8872", 0),

	M_8873(Operators, "⊩", "", 8873, "M_8873", 0),

	M_8874(Operators, "⊪", "", 8874, "M_8874", 0),

	M_8875(Operators, "⊫", "", 8875, "M_8875", 0),

	M_8876(Operators, "⊬", "", 8876, "M_8876", 0),

	M_8877(Operators, "⊭", "", 8877, "M_8877", 0),

	M_8878(Operators, "⊮", "", 8878, "M_8878", 0),

	M_8879(Operators, "⊯", "", 8879, "M_8879", 0),

	M_8880(Operators, "⊰", "", 8880, "M_8880", 0),

	M_8881(Operators, "⊱", "", 8881, "M_8881", 0),

	M_8882(Operators, "⊲", "", 8882, "M_8882", 0),

	M_8883(Operators, "⊳", "", 8883, "M_8883", 0),

	M_8884(Operators, "⊴", "", 8884, "M_8884", 0),

	M_8885(Operators, "⊵", "", 8885, "M_8885", 0),

	M_8886(Operators, "⊶", "", 8886, "M_8886", 0),

	M_8887(Operators, "⊷", "", 8887, "M_8887", 0),

	M_8888(Operators, "⊸", "", 8888, "M_8888", 0),

	M_8889(Operators, "⊹", "", 8889, "M_8889", 0),

	M_8890(Operators, "⊺", "", 8890, "M_8890", 0),

	M_8891(Operators, "⊻", "", 8891, "M_8891", 0),

	M_8892(Operators, "⊼", "", 8892, "M_8892", 0),

	M_8893(Operators, "⊽", "", 8893, "M_8893", 0),

	M_8894(Operators, "⊾", "", 8894, "M_8894", 0),

	M_8895(Operators, "⊿", "", 8895, "M_8895", 0),

	M_8896(Operators, "⋀", "", 8896, "M_8896", 0),

	M_8897(Operators, "⋁", "", 8897, "M_8897", 0),

	M_8898(Operators, "⋂", "", 8898, "M_8898", 0),

	M_8899(Operators, "⋃", "", 8899, "M_8899", 0),

	M_8900(Operators, "⋄", "", 8900, "M_8900", 0),

	M_8901(Operators, "⋅", "", 8901, "M_8901", 0),

	M_8902(Operators, "⋆", "", 8902, "M_8902", 0),

	M_8903(Operators, "⋇", "", 8903, "M_8903", 0),

	M_8904(Operators, "⋈", "", 8904, "M_8904", 0),

	M_8905(Operators, "⋉", "", 8905, "M_8905", 0),

	M_8906(Operators, "⋊", "", 8906, "M_8906", 0),

	M_8907(Operators, "⋋", "", 8907, "M_8907", 0),

	M_8908(Operators, "⋌", "", 8908, "M_8908", 0),

	M_8909(Operators, "⋍", "", 8909, "M_8909", 0),

	M_8910(Operators, "⋎", "", 8910, "M_8910", 0),

	M_8911(Operators, "⋏", "", 8911, "M_8911", 0),

	M_8912(Operators, "⋐", "", 8912, "M_8912", 0),

	M_8913(Operators, "⋑", "", 8913, "M_8913", 0),

	M_8914(Operators, "⋒", "", 8914, "M_8914", 0),

	M_8915(Operators, "⋓", "", 8915, "M_8915", 0),

	M_8916(Operators, "⋔", "", 8916, "M_8916", 0),

	M_8917(Operators, "⋕", "", 8917, "M_8917", 0),

	M_8918(Operators, "⋖", "", 8918, "M_8918", 0),

	M_8919(Operators, "⋗", "", 8919, "M_8919", 0),

	M_8920(Operators, "⋘", "", 8920, "M_8920", 0),

	M_8921(Operators, "⋙", "", 8921, "M_8921", 0),

	M_8922(Operators, "⋚", "", 8922, "M_8922", 0),

	M_8923(Operators, "⋛", "", 8923, "M_8923", 0),

	M_8924(Operators, "⋜", "", 8924, "M_8924", 0),

	M_8925(Operators, "⋝", "", 8925, "M_8925", 0),

	M_8926(Operators, "⋞", "", 8926, "M_8926", 0),

	M_8927(Operators, "⋟", "", 8927, "M_8927", 0),

	M_8928(Operators, "⋠", "", 8928, "M_8928", 0),

	M_8929(Operators, "⋡", "", 8929, "M_8929", 0),

	M_8930(Operators, "⋢", "", 8930, "M_8930", 0),

	M_8931(Operators, "⋣", "", 8931, "M_8931", 0),

	M_8932(Operators, "⋤", "", 8932, "M_8932", 0),

	M_8933(Operators, "⋥", "", 8933, "M_8933", 0),

	M_8934(Operators, "⋦", "", 8934, "M_8934", 0),

	M_8935(Operators, "⋧", "", 8935, "M_8935", 0),

	M_8936(Operators, "⋨", "", 8936, "M_8936", 0),

	M_8937(Operators, "⋩", "", 8937, "M_8937", 0),

	M_8938(Operators, "⋪", "", 8938, "M_8938", 0),

	M_8939(Operators, "⋫", "", 8939, "M_8939", 0),

	M_8940(Operators, "⋬", "", 8940, "M_8940", 0),

	M_8941(Operators, "⋭", "", 8941, "M_8941", 0),

	M_8942(Operators, "⋮", "", 8942, "M_8942", 0),

	M_8943(Operators, "⋯", "", 8943, "M_8943", 0),

	M_8944(Operators, "⋰", "", 8944, "M_8944", 0),

	M_8945(Operators, "⋱", "", 8945, "M_8945", 0),

	M_8946(Operators, "⋲", "", 8946, "M_8946", 0),

	M_8947(Operators, "⋳", "", 8947, "M_8947", 0),

	M_8948(Operators, "⋴", "", 8948, "M_8948", 0),

	M_8949(Operators, "⋵", "", 8949, "M_8949", 0),

	M_8950(Operators, "⋶", "", 8950, "M_8950", 0),

	M_8951(Operators, "⋷", "", 8951, "M_8951", 0),

	M_8952(Operators, "⋸", "", 8952, "M_8952", 0),

	M_8953(Operators, "⋹", "", 8953, "M_8953", 0),

	M_8954(Operators, "⋺", "", 8954, "M_8954", 0),

	M_8955(Operators, "⋻", "", 8955, "M_8955", 0),

	M_8956(Operators, "⋼", "", 8956, "M_8956", 0),

	M_8957(Operators, "⋽", "", 8957, "M_8957", 0),

	M_8958(Operators, "⋾", "", 8958, "M_8958", 0),

	M_8959(Operators, "⋿", "", 8959, "M_8959", 0),

	// ---------- mathematical Operators Supplement ---

	M_10752(OperatorsSupplement, "⨀", "", 10752, "M_10752", 0),

	M_10753(OperatorsSupplement, "⨁", "", 10753, "M_10753", 0),

	M_10754(OperatorsSupplement, "⨂", "", 10754, "M_10754", 0),

	M_10755(OperatorsSupplement, "⨃", "", 10755, "M_10755", 0),

	M_10756(OperatorsSupplement, "⨄", "", 10756, "M_10756", 0),

	M_10757(OperatorsSupplement, "⨅", "", 10757, "M_10757", 0),

	M_10758(OperatorsSupplement, "⨆", "", 10758, "M_10758", 0),

	M_10759(OperatorsSupplement, "⨇", "", 10759, "M_10759", 0),

	M_10760(OperatorsSupplement, "⨈", "", 10760, "M_10760", 0),

	M_10761(OperatorsSupplement, "⨉", "", 10761, "M_10761", 0),

	M_10762(OperatorsSupplement, "⨊", "", 10762, "M_10762", 0),

	M_10763(OperatorsSupplement, "⨋", "", 10763, "M_10763", 0),

	M_10764(OperatorsSupplement, "⨌", "", 10764, "M_10764", 0),

	M_10765(OperatorsSupplement, "⨍", "", 10765, "M_10765", 0),

	M_10766(OperatorsSupplement, "⨎", "", 10766, "M_10766", 0),

	M_10767(OperatorsSupplement, "⨏", "", 10767, "M_10767", 0),

	M_10768(OperatorsSupplement, "⨐", "", 10768, "M_10768", 0),

	M_10769(OperatorsSupplement, "⨑", "", 10769, "M_10769", 0),

	M_10770(OperatorsSupplement, "⨒", "", 10770, "M_10770", 0),

	M_10771(OperatorsSupplement, "⨓", "", 10771, "M_10771", 0),

	M_10772(OperatorsSupplement, "⨔", "", 10772, "M_10772", 0),

	M_10773(OperatorsSupplement, "⨕", "", 10773, "M_10773", 0),

	M_10774(OperatorsSupplement, "⨖", "", 10774, "M_10774", 0),

	M_10775(OperatorsSupplement, "⨗", "", 10775, "M_10775", 0),

	M_10776(OperatorsSupplement, "⨘", "", 10776, "M_10776", 0),

	M_10777(OperatorsSupplement, "⨙", "", 10777, "M_10777", 0),

	M_10778(OperatorsSupplement, "⨚", "", 10778, "M_10778", 0),

	M_10779(OperatorsSupplement, "⨛", "", 10779, "M_10779", 0),

	M_10780(OperatorsSupplement, "⨜", "", 10780, "M_10780", 0),

	M_10781(OperatorsSupplement, "⨝", "", 10781, "M_10781", 0),

	M_10782(OperatorsSupplement, "⨞", "", 10782, "M_10782", 0),

	M_10783(OperatorsSupplement, "⨟", "", 10783, "M_10783", 0),

	M_10784(OperatorsSupplement, "⨠", "", 10784, "M_10784", 0),

	M_10785(OperatorsSupplement, "⨡", "", 10785, "M_10785", 0),

	M_10786(OperatorsSupplement, "⨢", "", 10786, "M_10786", 0),

	M_10787(OperatorsSupplement, "⨣", "", 10787, "M_10787", 0),

	M_10788(OperatorsSupplement, "⨤", "", 10788, "M_10788", 0),

	M_10789(OperatorsSupplement, "⨥", "", 10789, "M_10789", 0),

	M_10790(OperatorsSupplement, "⨦", "", 10790, "M_10790", 0),

	M_10791(OperatorsSupplement, "⨧", "", 10791, "M_10791", 0),

	M_10792(OperatorsSupplement, "⨨", "", 10792, "M_10792", 0),

	M_10793(OperatorsSupplement, "⨩", "", 10793, "M_10793", 0),

	M_10794(OperatorsSupplement, "⨪", "", 10794, "M_10794", 0),

	M_10795(OperatorsSupplement, "⨫", "", 10795, "M_10795", 0),

	M_10796(OperatorsSupplement, "⨬", "", 10796, "M_10796", 0),

	M_10797(OperatorsSupplement, "⨭", "", 10797, "M_10797", 0),

	M_10798(OperatorsSupplement, "⨮", "", 10798, "M_10798", 0),

	M_10799(OperatorsSupplement, "⨯", "", 10799, "M_10799", 0),

	M_10800(OperatorsSupplement, "⨰", "", 10800, "M_10800", 0),

	M_10801(OperatorsSupplement, "⨱", "", 10801, "M_10801", 0),

	M_10802(OperatorsSupplement, "⨲", "", 10802, "M_10802", 0),

	M_10803(OperatorsSupplement, "⨳", "", 10803, "M_10803", 0),

	M_10804(OperatorsSupplement, "⨴", "", 10804, "M_10804", 0),

	M_10805(OperatorsSupplement, "⨵", "", 10805, "M_10805", 0),

	M_10806(OperatorsSupplement, "⨶", "", 10806, "M_10806", 0),

	M_10807(OperatorsSupplement, "⨷", "", 10807, "M_10807", 0),

	M_10808(OperatorsSupplement, "⨸", "", 10808, "M_10808", 0),

	M_10809(OperatorsSupplement, "⨹", "", 10809, "M_10809", 0),

	M_10810(OperatorsSupplement, "⨺", "", 10810, "M_10810", 0),

	M_10811(OperatorsSupplement, "⨻", "", 10811, "M_10811", 0),

	M_10812(OperatorsSupplement, "⨼", "", 10812, "M_10812", 0),

	M_10813(OperatorsSupplement, "⨽", "", 10813, "M_10813", 0),

	M_10814(OperatorsSupplement, "⨾", "", 10814, "M_10814", 0),

	M_10815(OperatorsSupplement, "⨿", "", 10815, "M_10815", 0),

	M_10816(OperatorsSupplement, "⩀", "", 10816, "M_10816", 0),

	M_10817(OperatorsSupplement, "⩁", "", 10817, "M_10817", 0),

	M_10818(OperatorsSupplement, "⩂", "", 10818, "M_10818", 0),

	M_10819(OperatorsSupplement, "⩃", "", 10819, "M_10819", 0),

	M_10820(OperatorsSupplement, "⩄", "", 10820, "M_10820", 0),

	M_10821(OperatorsSupplement, "⩅", "", 10821, "M_10821", 0),

	M_10822(OperatorsSupplement, "⩆", "", 10822, "M_10822", 0),

	M_10823(OperatorsSupplement, "⩇", "", 10823, "M_10823", 0),

	M_10824(OperatorsSupplement, "⩈", "", 10824, "M_10824", 0),

	M_10825(OperatorsSupplement, "⩉", "", 10825, "M_10825", 0),

	M_10826(OperatorsSupplement, "⩊", "", 10826, "M_10826", 0),

	M_10827(OperatorsSupplement, "⩋", "", 10827, "M_10827", 0),

	M_10828(OperatorsSupplement, "⩌", "", 10828, "M_10828", 0),

	M_10829(OperatorsSupplement, "⩍", "", 10829, "M_10829", 0),

	M_10830(OperatorsSupplement, "⩎", "", 10830, "M_10830", 0),

	M_10831(OperatorsSupplement, "⩏", "", 10831, "M_10831", 0),

	M_10832(OperatorsSupplement, "⩐", "", 10832, "M_10832", 0),

	M_10833(OperatorsSupplement, "⩑", "", 10833, "M_10833", 0),

	M_10834(OperatorsSupplement, "⩒", "", 10834, "M_10834", 0),

	M_10835(OperatorsSupplement, "⩓", "", 10835, "M_10835", 0),

	M_10836(OperatorsSupplement, "⩔", "", 10836, "M_10836", 0),

	M_10837(OperatorsSupplement, "⩕", "", 10837, "M_10837", 0),

	M_10838(OperatorsSupplement, "⩖", "", 10838, "M_10838", 0),

	M_10839(OperatorsSupplement, "⩗", "", 10839, "M_10839", 0),

	M_10840(OperatorsSupplement, "⩘", "", 10840, "M_10840", 0),

	M_10841(OperatorsSupplement, "⩙", "", 10841, "M_10841", 0),

	M_10842(OperatorsSupplement, "⩚", "", 10842, "M_10842", 0),

	M_10843(OperatorsSupplement, "⩛", "", 10843, "M_10843", 0),

	M_10844(OperatorsSupplement, "⩜", "", 10844, "M_10844", 0),

	M_10845(OperatorsSupplement, "⩝", "", 10845, "M_10845", 0),

	M_10846(OperatorsSupplement, "⩞", "", 10846, "M_10846", 0),

	M_10847(OperatorsSupplement, "⩟", "", 10847, "M_10847", 0),

	M_10848(OperatorsSupplement, "⩠", "", 10848, "M_10848", 0),

	M_10849(OperatorsSupplement, "⩡", "", 10849, "M_10849", 0),

	M_10850(OperatorsSupplement, "⩢", "", 10850, "M_10850", 0),

	M_10851(OperatorsSupplement, "⩣", "", 10851, "M_10851", 0),

	M_10852(OperatorsSupplement, "⩤", "", 10852, "M_10852", 0),

	M_10853(OperatorsSupplement, "⩥", "", 10853, "M_10853", 0),

	M_10854(OperatorsSupplement, "⩦", "", 10854, "M_10854", 0),

	M_10855(OperatorsSupplement, "⩧", "", 10855, "M_10855", 0),

	M_10856(OperatorsSupplement, "⩨", "", 10856, "M_10856", 0),

	M_10857(OperatorsSupplement, "⩩", "", 10857, "M_10857", 0),

	M_10858(OperatorsSupplement, "⩪", "", 10858, "M_10858", 0),

	M_10859(OperatorsSupplement, "⩫", "", 10859, "M_10859", 0),

	M_10860(OperatorsSupplement, "⩬", "", 10860, "M_10860", 0),

	M_10861(OperatorsSupplement, "⩭", "", 10861, "M_10861", 0),

	M_10862(OperatorsSupplement, "⩮", "", 10862, "M_10862", 0),

	M_10863(OperatorsSupplement, "⩯", "", 10863, "M_10863", 0),

	M_10864(OperatorsSupplement, "⩰", "", 10864, "M_10864", 0),

	M_10865(OperatorsSupplement, "⩱", "", 10865, "M_10865", 0),

	M_10866(OperatorsSupplement, "⩲", "", 10866, "M_10866", 0),

	M_10867(OperatorsSupplement, "⩳", "", 10867, "M_10867", 0),

	M_10868(OperatorsSupplement, "⩴", "", 10868, "M_10868", 0),

	M_10869(OperatorsSupplement, "⩵", "", 10869, "M_10869", 0),

	M_10870(OperatorsSupplement, "⩶", "", 10870, "M_10870", 0),

	M_10871(OperatorsSupplement, "⩷", "", 10871, "M_10871", 0),

	M_10872(OperatorsSupplement, "⩸", "", 10872, "M_10872", 0),

	M_10873(OperatorsSupplement, "⩹", "", 10873, "M_10873", 0),

	M_10874(OperatorsSupplement, "⩺", "", 10874, "M_10874", 0),

	M_10875(OperatorsSupplement, "⩻", "", 10875, "M_10875", 0),

	M_10876(OperatorsSupplement, "⩼", "", 10876, "M_10876", 0),

	M_10877(OperatorsSupplement, "⩽", "", 10877, "M_10877", 0),

	M_10878(OperatorsSupplement, "⩾", "", 10878, "M_10878", 0),

	M_10879(OperatorsSupplement, "⩿", "", 10879, "M_10879", 0),

	M_10880(OperatorsSupplement, "⪀", "", 10880, "M_10880", 0),

	M_10881(OperatorsSupplement, "⪁", "", 10881, "M_10881", 0),

	M_10882(OperatorsSupplement, "⪂", "", 10882, "M_10882", 0),

	M_10883(OperatorsSupplement, "⪃", "", 10883, "M_10883", 0),

	M_10884(OperatorsSupplement, "⪄", "", 10884, "M_10884", 0),

	M_10885(OperatorsSupplement, "⪅", "", 10885, "M_10885", 0),

	M_10886(OperatorsSupplement, "⪆", "", 10886, "M_10886", 0),

	M_10887(OperatorsSupplement, "⪇", "", 10887, "M_10887", 0),

	M_10888(OperatorsSupplement, "⪈", "", 10888, "M_10888", 0),

	M_10889(OperatorsSupplement, "⪉", "", 10889, "M_10889", 0),

	M_10890(OperatorsSupplement, "⪊", "", 10890, "M_10890", 0),

	M_10891(OperatorsSupplement, "⪋", "", 10891, "M_10891", 0),

	M_10892(OperatorsSupplement, "⪌", "", 10892, "M_10892", 0),

	M_10893(OperatorsSupplement, "⪍", "", 10893, "M_10893", 0),

	M_10894(OperatorsSupplement, "⪎", "", 10894, "M_10894", 0),

	M_10895(OperatorsSupplement, "⪏", "", 10895, "M_10895", 0),

	M_10896(OperatorsSupplement, "⪐", "", 10896, "M_10896", 0),

	M_10897(OperatorsSupplement, "⪑", "", 10897, "M_10897", 0),

	M_10898(OperatorsSupplement, "⪒", "", 10898, "M_10898", 0),

	M_10899(OperatorsSupplement, "⪓", "", 10899, "M_10899", 0),

	M_10900(OperatorsSupplement, "⪔", "", 10900, "M_10900", 0),

	M_10901(OperatorsSupplement, "⪕", "", 10901, "M_10901", 0),

	M_10902(OperatorsSupplement, "⪖", "", 10902, "M_10902", 0),

	M_10903(OperatorsSupplement, "⪗", "", 10903, "M_10903", 0),

	M_10904(OperatorsSupplement, "⪘", "", 10904, "M_10904", 0),

	M_10905(OperatorsSupplement, "⪙", "", 10905, "M_10905", 0),

	M_10906(OperatorsSupplement, "⪚", "", 10906, "M_10906", 0),

	M_10907(OperatorsSupplement, "⪛", "", 10907, "M_10907", 0),

	M_10908(OperatorsSupplement, "⪜", "", 10908, "M_10908", 0),

	M_10909(OperatorsSupplement, "⪝", "", 10909, "M_10909", 0),

	M_10910(OperatorsSupplement, "⪞", "", 10910, "M_10910", 0),

	M_10911(OperatorsSupplement, "⪟", "", 10911, "M_10911", 0),

	M_10912(OperatorsSupplement, "⪠", "", 10912, "M_10912", 0),

	M_10913(OperatorsSupplement, "⪡", "", 10913, "M_10913", 0),

	M_10914(OperatorsSupplement, "⪢", "", 10914, "M_10914", 0),

	M_10915(OperatorsSupplement, "⪣", "", 10915, "M_10915", 0),

	M_10916(OperatorsSupplement, "⪤", "", 10916, "M_10916", 0),

	M_10917(OperatorsSupplement, "⪥", "", 10917, "M_10917", 0),

	M_10918(OperatorsSupplement, "⪦", "", 10918, "M_10918", 0),

	M_10919(OperatorsSupplement, "⪧", "", 10919, "M_10919", 0),

	M_10920(OperatorsSupplement, "⪨", "", 10920, "M_10920", 0),

	M_10921(OperatorsSupplement, "⪩", "", 10921, "M_10921", 0),

	M_10922(OperatorsSupplement, "⪪", "", 10922, "M_10922", 0),

	M_10923(OperatorsSupplement, "⪫", "", 10923, "M_10923", 0),

	M_10924(OperatorsSupplement, "⪬", "", 10924, "M_10924", 0),

	M_10925(OperatorsSupplement, "⪭", "", 10925, "M_10925", 0),

	M_10926(OperatorsSupplement, "⪮", "", 10926, "M_10926", 0),

	M_10927(OperatorsSupplement, "⪯", "", 10927, "M_10927", 0),

	M_10928(OperatorsSupplement, "⪰", "", 10928, "M_10928", 0),

	M_10929(OperatorsSupplement, "⪱", "", 10929, "M_10929", 0),

	M_10930(OperatorsSupplement, "⪲", "", 10930, "M_10930", 0),

	M_10931(OperatorsSupplement, "⪳", "", 10931, "M_10931", 0),

	M_10932(OperatorsSupplement, "⪴", "", 10932, "M_10932", 0),

	M_10933(OperatorsSupplement, "⪵", "", 10933, "M_10933", 0),

	M_10934(OperatorsSupplement, "⪶", "", 10934, "M_10934", 0),

	M_10935(OperatorsSupplement, "⪷", "", 10935, "M_10935", 0),

	M_10936(OperatorsSupplement, "⪸", "", 10936, "M_10936", 0),

	M_10937(OperatorsSupplement, "⪹", "", 10937, "M_10937", 0),

	M_10938(OperatorsSupplement, "⪺", "", 10938, "M_10938", 0),

	M_10939(OperatorsSupplement, "⪻", "", 10939, "M_10939", 0),

	M_10940(OperatorsSupplement, "⪼", "", 10940, "M_10940", 0),

	M_10941(OperatorsSupplement, "⪽", "", 10941, "M_10941", 0),

	M_10942(OperatorsSupplement, "⪾", "", 10942, "M_10942", 0),

	M_10943(OperatorsSupplement, "⪿", "", 10943, "M_10943", 0),

	M_10944(OperatorsSupplement, "⫀", "", 10944, "M_10944", 0),

	M_10945(OperatorsSupplement, "⫁", "", 10945, "M_10945", 0),

	M_10946(OperatorsSupplement, "⫂", "", 10946, "M_10946", 0),

	M_10947(OperatorsSupplement, "⫃", "", 10947, "M_10947", 0),

	M_10948(OperatorsSupplement, "⫄", "", 10948, "M_10948", 0),

	M_10949(OperatorsSupplement, "⫅", "", 10949, "M_10949", 0),

	M_10950(OperatorsSupplement, "⫆", "", 10950, "M_10950", 0),

	M_10951(OperatorsSupplement, "⫇", "", 10951, "M_10951", 0),

	M_10952(OperatorsSupplement, "⫈", "", 10952, "M_10952", 0),

	M_10953(OperatorsSupplement, "⫉", "", 10953, "M_10953", 0),

	M_10954(OperatorsSupplement, "⫊", "", 10954, "M_10954", 0),

	M_10955(OperatorsSupplement, "⫋", "", 10955, "M_10955", 0),

	M_10956(OperatorsSupplement, "⫌", "", 10956, "M_10956", 0),

	M_10957(OperatorsSupplement, "⫍", "", 10957, "M_10957", 0),

	M_10958(OperatorsSupplement, "⫎", "", 10958, "M_10958", 0),

	M_10959(OperatorsSupplement, "⫏", "", 10959, "M_10959", 0),

	M_10960(OperatorsSupplement, "⫐", "", 10960, "M_10960", 0),

	M_10961(OperatorsSupplement, "⫑", "", 10961, "M_10961", 0),

	M_10962(OperatorsSupplement, "⫒", "", 10962, "M_10962", 0),

	M_10963(OperatorsSupplement, "⫓", "", 10963, "M_10963", 0),

	M_10964(OperatorsSupplement, "⫔", "", 10964, "M_10964", 0),

	M_10965(OperatorsSupplement, "⫕", "", 10965, "M_10965", 0),

	M_10966(OperatorsSupplement, "⫖", "", 10966, "M_10966", 0),

	M_10967(OperatorsSupplement, "⫗", "", 10967, "M_10967", 0),

	M_10968(OperatorsSupplement, "⫘", "", 10968, "M_10968", 0),

	M_10969(OperatorsSupplement, "⫙", "", 10969, "M_10969", 0),

	M_10970(OperatorsSupplement, "⫚", "", 10970, "M_10970", 0),

	M_10971(OperatorsSupplement, "⫛", "", 10971, "M_10971", 0),

	M_10972(OperatorsSupplement, "⫝̸", "", 10972, "M_10972", 0),

	M_10973(OperatorsSupplement, "⫝", "", 10973, "M_10973", 0),

	M_10974(OperatorsSupplement, "⫞", "", 10974, "M_10974", 0),

	M_10975(OperatorsSupplement, "⫟", "", 10975, "M_10975", 0),

	M_10976(OperatorsSupplement, "⫠", "", 10976, "M_10976", 0),

	M_10977(OperatorsSupplement, "⫡", "", 10977, "M_10977", 0),

	M_10978(OperatorsSupplement, "⫢", "", 10978, "M_10978", 0),

	M_10979(OperatorsSupplement, "⫣", "", 10979, "M_10979", 0),

	M_10980(OperatorsSupplement, "⫤", "", 10980, "M_10980", 0),

	M_10981(OperatorsSupplement, "⫥", "", 10981, "M_10981", 0),

	M_10982(OperatorsSupplement, "⫦", "", 10982, "M_10982", 0),

	M_10983(OperatorsSupplement, "⫧", "", 10983, "M_10983", 0),

	M_10984(OperatorsSupplement, "⫨", "", 10984, "M_10984", 0),

	M_10985(OperatorsSupplement, "⫩", "", 10985, "M_10985", 0),

	M_10986(OperatorsSupplement, "⫪", "", 10986, "M_10986", 0),

	M_10987(OperatorsSupplement, "⫫", "", 10987, "M_10987", 0),

	M_10988(OperatorsSupplement, "⫬", "", 10988, "M_10988", 0),

	M_10989(OperatorsSupplement, "⫭", "", 10989, "M_10989", 0),

	M_10990(OperatorsSupplement, "⫮", "", 10990, "M_10990", 0),

	M_10991(OperatorsSupplement, "⫯", "", 10991, "M_10991", 0),

	M_10992(OperatorsSupplement, "⫰", "", 10992, "M_10992", 0),

	M_10993(OperatorsSupplement, "⫱", "", 10993, "M_10993", 0),

	M_10994(OperatorsSupplement, "⫲", "", 10994, "M_10994", 0),

	M_10995(OperatorsSupplement, "⫳", "", 10995, "M_10995", 0),

	M_10996(OperatorsSupplement, "⫴", "", 10996, "M_10996", 0),

	M_10997(OperatorsSupplement, "⫵", "", 10997, "M_10997", 0),

	M_10998(OperatorsSupplement, "⫶", "", 10998, "M_10998", 0),

	M_10999(OperatorsSupplement, "⫷", "", 10999, "M_10999", 0),

	M_11000(OperatorsSupplement, "⫸", "", 11000, "M_11000", 0),

	M_11001(OperatorsSupplement, "⫹", "", 11001, "M_11001", 0),

	M_11002(OperatorsSupplement, "⫺", "", 11002, "M_11002", 0),

	M_11003(OperatorsSupplement, "⫻", "", 11003, "M_11003", 0),

	M_11004(OperatorsSupplement, "⫼", "", 11004, "M_11004", 0),

	M_11005(OperatorsSupplement, "⫽", "", 11005, "M_11005", 0),

	M_11006(OperatorsSupplement, "⫾", "", 11006, "M_11006", 0),

	M_11007(OperatorsSupplement, "⫿", "", 11007, "M_11007", 0),

	// ---------- empty Block

	M_EMPTY_BLOCK_1(AlphanumericSymbols, "⫿", "", 11007, "M_11007", 0),

	// ---------- Letterlike Symbols ---

	M_8448(LetterlikeSymbols, "℀", "", 8448, "M_8448", 0),

	M_8449(LetterlikeSymbols, "℁", "", 8449, "M_8449", 0),

	M_8450(LetterlikeSymbols, "ℂ", "", 8450, "M_8450", 0),

	M_8451(LetterlikeSymbols, "℃", "", 8451, "M_8451", 0),

	M_8452(LetterlikeSymbols, "℄", "", 8452, "M_8452", 0),

	M_8453(LetterlikeSymbols, "℅", "", 8453, "M_8453", 0),

	M_8454(LetterlikeSymbols, "℆", "", 8454, "M_8454", 0),

	M_8455(LetterlikeSymbols, "ℇ", "", 8455, "M_8455", 0),

	M_8456(LetterlikeSymbols, "℈", "", 8456, "M_8456", 0),

	M_8457(LetterlikeSymbols, "℉", "", 8457, "M_8457", 0),

	M_8458(LetterlikeSymbols, "ℊ", "", 8458, "M_8458", 0),

	M_8459(LetterlikeSymbols, "ℋ", "", 8459, "M_8459", 0),

	M_8460(LetterlikeSymbols, "ℌ", "", 8460, "M_8460", 0),

	M_8461(LetterlikeSymbols, "ℍ", "", 8461, "M_8461", 0),

	M_8462(LetterlikeSymbols, "ℎ", "", 8462, "M_8462", 0),

	M_8463(LetterlikeSymbols, "ℏ", "", 8463, "M_8463", 0),

	M_8464(LetterlikeSymbols, "ℐ", "", 8464, "M_8464", 0),

	M_8465(LetterlikeSymbols, "ℑ", "", 8465, "M_8465", 0),

	M_8466(LetterlikeSymbols, "ℒ", "", 8466, "M_8466", 0),

	M_8467(LetterlikeSymbols, "ℓ", "", 8467, "M_8467", 0),

	M_8468(LetterlikeSymbols, "℔", "", 8468, "M_8468", 0),

	M_8469(LetterlikeSymbols, "ℕ", "", 8469, "M_8469", 0),

	M_8470(LetterlikeSymbols, "№", "", 8470, "M_8470", 0),

	M_8471(LetterlikeSymbols, "℗", "", 8471, "M_8471", 0),

	M_8472(LetterlikeSymbols, "℘", "", 8472, "M_8472", 0),

	M_8473(LetterlikeSymbols, "ℙ", "", 8473, "M_8473", 0),

	M_8474(LetterlikeSymbols, "ℚ", "", 8474, "M_8474", 0),

	M_8475(LetterlikeSymbols, "ℛ", "", 8475, "M_8475", 0),

	M_8476(LetterlikeSymbols, "ℜ", "", 8476, "M_8476", 0),

	M_8477(LetterlikeSymbols, "ℝ", "", 8477, "M_8477", 0),

	M_8478(LetterlikeSymbols, "℞", "", 8478, "M_8478", 0),

	M_8479(LetterlikeSymbols, "℟", "", 8479, "M_8479", 0),

	M_8480(LetterlikeSymbols, "℠", "", 8480, "M_8480", 0),

	M_8481(LetterlikeSymbols, "℡", "", 8481, "M_8481", 0),

	M_8482(LetterlikeSymbols, "™", "", 8482, "M_8482", 0),

	M_8483(LetterlikeSymbols, "℣", "", 8483, "M_8483", 0),

	M_8484(LetterlikeSymbols, "ℤ", "", 8484, "M_8484", 0),

	M_8485(LetterlikeSymbols, "℥", "", 8485, "M_8485", 0),

	M_8486(LetterlikeSymbols, "Ω", "", 8486, "M_8486", 0),

	M_8487(LetterlikeSymbols, "℧", "", 8487, "M_8487", 0),

	M_8488(LetterlikeSymbols, "ℨ", "", 8488, "M_8488", 0),

	M_8489(LetterlikeSymbols, "℩", "", 8489, "M_8489", 0),

	M_8490(LetterlikeSymbols, "K", "", 8490, "M_8490", 0),

	M_8491(LetterlikeSymbols, "Å", "", 8491, "M_8491", 0),

	M_8492(LetterlikeSymbols, "ℬ", "", 8492, "M_8492", 0),

	M_8493(LetterlikeSymbols, "ℭ", "", 8493, "M_8493", 0),

	M_8494(LetterlikeSymbols, "℮", "", 8494, "M_8494", 0),

	M_8495(LetterlikeSymbols, "ℯ", "", 8495, "M_8495", 0),

	M_8496(LetterlikeSymbols, "ℰ", "", 8496, "M_8496", 0),

	M_8497(LetterlikeSymbols, "ℱ", "", 8497, "M_8497", 0),

	M_8498(LetterlikeSymbols, "Ⅎ", "", 8498, "M_8498", 0),

	M_8499(LetterlikeSymbols, "ℳ", "", 8499, "M_8499", 0),

	M_8500(LetterlikeSymbols, "ℴ", "", 8500, "M_8500", 0),

	M_8501(LetterlikeSymbols, "ℵ", "", 8501, "M_8501", 0),

	M_8502(LetterlikeSymbols, "ℶ", "", 8502, "M_8502", 0),

	M_8503(LetterlikeSymbols, "ℷ", "", 8503, "M_8503", 0),

	M_8504(LetterlikeSymbols, "ℸ", "", 8504, "M_8504", 0),

	M_8505(LetterlikeSymbols, "ℹ", "", 8505, "M_8505", 0),

	M_8506(LetterlikeSymbols, "℺", "", 8506, "M_8506", 0),

	M_8507(LetterlikeSymbols, "℻", "", 8507, "M_8507", 0),

	M_8508(LetterlikeSymbols, "ℼ", "", 8508, "M_8508", 0),

	M_8509(LetterlikeSymbols, "ℽ", "", 8509, "M_8509", 0),

	M_8510(LetterlikeSymbols, "ℾ", "", 8510, "M_8510", 0),

	M_8511(LetterlikeSymbols, "ℿ", "", 8511, "M_8511", 0),

	M_8512(LetterlikeSymbols, "⅀", "", 8512, "M_8512", 0),

	M_8513(LetterlikeSymbols, "⅁", "", 8513, "M_8513", 0),

	M_8514(LetterlikeSymbols, "⅂", "", 8514, "M_8514", 0),

	M_8515(LetterlikeSymbols, "⅃", "", 8515, "M_8515", 0),

	M_8516(LetterlikeSymbols, "⅄", "", 8516, "M_8516", 0),

	M_8517(LetterlikeSymbols, "ⅅ", "", 8517, "M_8517", 0),

	M_8518(LetterlikeSymbols, "ⅆ", "", 8518, "M_8518", 0),

	M_8519(LetterlikeSymbols, "ⅇ", "", 8519, "M_8519", 0),

	M_8520(LetterlikeSymbols, "ⅈ", "", 8520, "M_8520", 0),

	M_8521(LetterlikeSymbols, "ⅉ", "", 8521, "M_8521", 0),

	M_8522(LetterlikeSymbols, "⅊", "", 8522, "M_8522", 0),

	M_8523(LetterlikeSymbols, "⅋", "", 8523, "M_8523", 0),

	M_8524(LetterlikeSymbols, "⅌", "", 8524, "M_8524", 0),

	M_8525(LetterlikeSymbols, "⅍", "", 8525, "M_8525", 0),

	M_8526(LetterlikeSymbols, "ⅎ", "", 8526, "M_8526", 0),

	M_8527(LetterlikeSymbols, "⅏", "", 8527, "M_8527", 0),

	// ---------- Miscellaneous Mathematical Symbols-A ---

	M_10176(MiscellaneousSymbolsA, "⟀", "", 10176, "M_10176", 0),

	M_10177(MiscellaneousSymbolsA, "⟁", "", 10177, "M_10177", 0),

	M_10178(MiscellaneousSymbolsA, "⟂", "", 10178, "M_10178", 0),

	M_10179(MiscellaneousSymbolsA, "⟃", "", 10179, "M_10179", 0),

	M_10180(MiscellaneousSymbolsA, "⟄", "", 10180, "M_10180", 0),

	M_10181(MiscellaneousSymbolsA, "⟅", "", 10181, "M_10181", 0),

	M_10182(MiscellaneousSymbolsA, "⟆", "", 10182, "M_10182", 0),

	M_10183(MiscellaneousSymbolsA, "⟇", "", 10183, "M_10183", 0),

	M_10184(MiscellaneousSymbolsA, "⟈", "", 10184, "M_10184", 0),

	M_10185(MiscellaneousSymbolsA, "⟉", "", 10185, "M_10185", 0),

	M_10186(MiscellaneousSymbolsA, "⟊", "", 10186, "M_10186", 0),

	M_10187(MiscellaneousSymbolsA, "⟋", "", 10187, "M_10187", 0),

	M_10188(MiscellaneousSymbolsA, "⟌", "", 10188, "M_10188", 0),

	M_10189(MiscellaneousSymbolsA, "⟍", "", 10189, "M_10189", 0),

	M_10190(MiscellaneousSymbolsA, "⟎", "", 10190, "M_10190", 0),

	M_10191(MiscellaneousSymbolsA, "⟏", "", 10191, "M_10191", 0),

	M_10192(MiscellaneousSymbolsA, "⟐", "", 10192, "M_10192", 0),

	M_10193(MiscellaneousSymbolsA, "⟑", "", 10193, "M_10193", 0),

	M_10194(MiscellaneousSymbolsA, "⟒", "", 10194, "M_10194", 0),

	M_10195(MiscellaneousSymbolsA, "⟓", "", 10195, "M_10195", 0),

	M_10196(MiscellaneousSymbolsA, "⟔", "", 10196, "M_10196", 0),

	M_10197(MiscellaneousSymbolsA, "⟕", "", 10197, "M_10197", 0),

	M_10198(MiscellaneousSymbolsA, "⟖", "", 10198, "M_10198", 0),

	M_10199(MiscellaneousSymbolsA, "⟗", "", 10199, "M_10199", 0),

	M_10200(MiscellaneousSymbolsA, "⟘", "", 10200, "M_10200", 0),

	M_10201(MiscellaneousSymbolsA, "⟙", "", 10201, "M_10201", 0),

	M_10202(MiscellaneousSymbolsA, "⟚", "", 10202, "M_10202", 0),

	M_10203(MiscellaneousSymbolsA, "⟛", "", 10203, "M_10203", 0),

	M_10204(MiscellaneousSymbolsA, "⟜", "", 10204, "M_10204", 0),

	M_10205(MiscellaneousSymbolsA, "⟝", "", 10205, "M_10205", 0),

	M_10206(MiscellaneousSymbolsA, "⟞", "", 10206, "M_10206", 0),

	M_10207(MiscellaneousSymbolsA, "⟟", "", 10207, "M_10207", 0),

	M_10208(MiscellaneousSymbolsA, "⟠", "", 10208, "M_10208", 0),

	M_10209(MiscellaneousSymbolsA, "⟡", "", 10209, "M_10209", 0),

	M_10210(MiscellaneousSymbolsA, "⟢", "", 10210, "M_10210", 0),

	M_10211(MiscellaneousSymbolsA, "⟣", "", 10211, "M_10211", 0),

	M_10212(MiscellaneousSymbolsA, "⟤", "", 10212, "M_10212", 0),

	M_10213(MiscellaneousSymbolsA, "⟥", "", 10213, "M_10213", 0),

	M_10214(MiscellaneousSymbolsA, "⟦", "", 10214, "M_10214", 0),

	M_10215(MiscellaneousSymbolsA, "⟧", "", 10215, "M_10215", 0),

	M_10216(MiscellaneousSymbolsA, "⟨", "", 10216, "M_10216", 0),

	M_10217(MiscellaneousSymbolsA, "⟩", "", 10217, "M_10217", 0),

	M_10218(MiscellaneousSymbolsA, "⟪", "", 10218, "M_10218", 0),

	M_10219(MiscellaneousSymbolsA, "⟫", "", 10219, "M_10219", 0),

	M_10220(MiscellaneousSymbolsA, "⟬", "", 10220, "M_10220", 0),

	M_10221(MiscellaneousSymbolsA, "⟭", "", 10221, "M_10221", 0),

	M_10222(MiscellaneousSymbolsA, "⟮", "", 10222, "M_10222", 0),

	M_10223(MiscellaneousSymbolsA, "⟯", "", 10223, "M_10223", 0),

	// ---------- Miscellaneous Mathematical Symbols-B ---

	M_10624(MiscellaneousSymbolsB, "⦀", "", 10624, "M_10624", 0),

	M_10625(MiscellaneousSymbolsB, "⦁", "", 10625, "M_10625", 0),

	M_10626(MiscellaneousSymbolsB, "⦂", "", 10626, "M_10626", 0),

	M_10627(MiscellaneousSymbolsB, "⦃", "", 10627, "M_10627", 0),

	M_10628(MiscellaneousSymbolsB, "⦄", "", 10628, "M_10628", 0),

	M_10629(MiscellaneousSymbolsB, "⦅", "", 10629, "M_10629", 0),

	M_10630(MiscellaneousSymbolsB, "⦆", "", 10630, "M_10630", 0),

	M_10631(MiscellaneousSymbolsB, "⦇", "", 10631, "M_10631", 0),

	M_10632(MiscellaneousSymbolsB, "⦈", "", 10632, "M_10632", 0),

	M_10633(MiscellaneousSymbolsB, "⦉", "", 10633, "M_10633", 0),

	M_10634(MiscellaneousSymbolsB, "⦊", "", 10634, "M_10634", 0),

	M_10635(MiscellaneousSymbolsB, "⦋", "", 10635, "M_10635", 0),

	M_10636(MiscellaneousSymbolsB, "⦌", "", 10636, "M_10636", 0),

	M_10637(MiscellaneousSymbolsB, "⦍", "", 10637, "M_10637", 0),

	M_10638(MiscellaneousSymbolsB, "⦎", "", 10638, "M_10638", 0),

	M_10639(MiscellaneousSymbolsB, "⦏", "", 10639, "M_10639", 0),

	M_10640(MiscellaneousSymbolsB, "⦐", "", 10640, "M_10640", 0),

	M_10641(MiscellaneousSymbolsB, "⦑", "", 10641, "M_10641", 0),

	M_10642(MiscellaneousSymbolsB, "⦒", "", 10642, "M_10642", 0),

	M_10643(MiscellaneousSymbolsB, "⦓", "", 10643, "M_10643", 0),

	M_10644(MiscellaneousSymbolsB, "⦔", "", 10644, "M_10644", 0),

	M_10645(MiscellaneousSymbolsB, "⦕", "", 10645, "M_10645", 0),

	M_10646(MiscellaneousSymbolsB, "⦖", "", 10646, "M_10646", 0),

	M_10647(MiscellaneousSymbolsB, "⦗", "", 10647, "M_10647", 0),

	M_10648(MiscellaneousSymbolsB, "⦘", "", 10648, "M_10648", 0),

	M_10649(MiscellaneousSymbolsB, "⦙", "", 10649, "M_10649", 0),

	M_10650(MiscellaneousSymbolsB, "⦚", "", 10650, "M_10650", 0),

	M_10651(MiscellaneousSymbolsB, "⦛", "", 10651, "M_10651", 0),

	M_10652(MiscellaneousSymbolsB, "⦜", "", 10652, "M_10652", 0),

	M_10653(MiscellaneousSymbolsB, "⦝", "", 10653, "M_10653", 0),

	M_10654(MiscellaneousSymbolsB, "⦞", "", 10654, "M_10654", 0),

	M_10655(MiscellaneousSymbolsB, "⦟", "", 10655, "M_10655", 0),

	M_10656(MiscellaneousSymbolsB, "⦠", "", 10656, "M_10656", 0),

	M_10657(MiscellaneousSymbolsB, "⦡", "", 10657, "M_10657", 0),

	M_10658(MiscellaneousSymbolsB, "⦢", "", 10658, "M_10658", 0),

	M_10659(MiscellaneousSymbolsB, "⦣", "", 10659, "M_10659", 0),

	M_10660(MiscellaneousSymbolsB, "⦤", "", 10660, "M_10660", 0),

	M_10661(MiscellaneousSymbolsB, "⦥", "", 10661, "M_10661", 0),

	M_10662(MiscellaneousSymbolsB, "⦦", "", 10662, "M_10662", 0),

	M_10663(MiscellaneousSymbolsB, "⦧", "", 10663, "M_10663", 0),

	M_10664(MiscellaneousSymbolsB, "⦨", "", 10664, "M_10664", 0),

	M_10665(MiscellaneousSymbolsB, "⦩", "", 10665, "M_10665", 0),

	M_10666(MiscellaneousSymbolsB, "⦪", "", 10666, "M_10666", 0),

	M_10667(MiscellaneousSymbolsB, "⦫", "", 10667, "M_10667", 0),

	M_10668(MiscellaneousSymbolsB, "⦬", "", 10668, "M_10668", 0),

	M_10669(MiscellaneousSymbolsB, "⦭", "", 10669, "M_10669", 0),

	M_10670(MiscellaneousSymbolsB, "⦮", "", 10670, "M_10670", 0),

	M_10671(MiscellaneousSymbolsB, "⦯", "", 10671, "M_10671", 0),

	M_10672(MiscellaneousSymbolsB, "⦰", "", 10672, "M_10672", 0),

	M_10673(MiscellaneousSymbolsB, "⦱", "", 10673, "M_10673", 0),

	M_10674(MiscellaneousSymbolsB, "⦲", "", 10674, "M_10674", 0),

	M_10675(MiscellaneousSymbolsB, "⦳", "", 10675, "M_10675", 0),

	M_10676(MiscellaneousSymbolsB, "⦴", "", 10676, "M_10676", 0),

	M_10677(MiscellaneousSymbolsB, "⦵", "", 10677, "M_10677", 0),

	M_10678(MiscellaneousSymbolsB, "⦶", "", 10678, "M_10678", 0),

	M_10679(MiscellaneousSymbolsB, "⦷", "", 10679, "M_10679", 0),

	M_10680(MiscellaneousSymbolsB, "⦸", "", 10680, "M_10680", 0),

	M_10681(MiscellaneousSymbolsB, "⦹", "", 10681, "M_10681", 0),

	M_10682(MiscellaneousSymbolsB, "⦺", "", 10682, "M_10682", 0),

	M_10683(MiscellaneousSymbolsB, "⦻", "", 10683, "M_10683", 0),

	M_10684(MiscellaneousSymbolsB, "⦼", "", 10684, "M_10684", 0),

	M_10685(MiscellaneousSymbolsB, "⦽", "", 10685, "M_10685", 0),

	M_10686(MiscellaneousSymbolsB, "⦾", "", 10686, "M_10686", 0),

	M_10687(MiscellaneousSymbolsB, "⦿", "", 10687, "M_10687", 0),

	M_10688(MiscellaneousSymbolsB, "⧀", "", 10688, "M_10688", 0),

	M_10689(MiscellaneousSymbolsB, "⧁", "", 10689, "M_10689", 0),

	M_10690(MiscellaneousSymbolsB, "⧂", "", 10690, "M_10690", 0),

	M_10691(MiscellaneousSymbolsB, "⧃", "", 10691, "M_10691", 0),

	M_10692(MiscellaneousSymbolsB, "⧄", "", 10692, "M_10692", 0),

	M_10693(MiscellaneousSymbolsB, "⧅", "", 10693, "M_10693", 0),

	M_10694(MiscellaneousSymbolsB, "⧆", "", 10694, "M_10694", 0),

	M_10695(MiscellaneousSymbolsB, "⧇", "", 10695, "M_10695", 0),

	M_10696(MiscellaneousSymbolsB, "⧈", "", 10696, "M_10696", 0),

	M_10697(MiscellaneousSymbolsB, "⧉", "", 10697, "M_10697", 0),

	M_10698(MiscellaneousSymbolsB, "⧊", "", 10698, "M_10698", 0),

	M_10699(MiscellaneousSymbolsB, "⧋", "", 10699, "M_10699", 0),

	M_10700(MiscellaneousSymbolsB, "⧌", "", 10700, "M_10700", 0),

	M_10701(MiscellaneousSymbolsB, "⧍", "", 10701, "M_10701", 0),

	M_10702(MiscellaneousSymbolsB, "⧎", "", 10702, "M_10702", 0),

	M_10703(MiscellaneousSymbolsB, "⧏", "", 10703, "M_10703", 0),

	M_10704(MiscellaneousSymbolsB, "⧐", "", 10704, "M_10704", 0),

	M_10705(MiscellaneousSymbolsB, "⧑", "", 10705, "M_10705", 0),

	M_10706(MiscellaneousSymbolsB, "⧒", "", 10706, "M_10706", 0),

	M_10707(MiscellaneousSymbolsB, "⧓", "", 10707, "M_10707", 0),

	M_10708(MiscellaneousSymbolsB, "⧔", "", 10708, "M_10708", 0),

	M_10709(MiscellaneousSymbolsB, "⧕", "", 10709, "M_10709", 0),

	M_10710(MiscellaneousSymbolsB, "⧖", "", 10710, "M_10710", 0),

	M_10711(MiscellaneousSymbolsB, "⧗", "", 10711, "M_10711", 0),

	M_10712(MiscellaneousSymbolsB, "⧘", "", 10712, "M_10712", 0),

	M_10713(MiscellaneousSymbolsB, "⧙", "", 10713, "M_10713", 0),

	M_10714(MiscellaneousSymbolsB, "⧚", "", 10714, "M_10714", 0),

	M_10715(MiscellaneousSymbolsB, "⧛", "", 10715, "M_10715", 0),

	M_10716(MiscellaneousSymbolsB, "⧜", "", 10716, "M_10716", 0),

	M_10717(MiscellaneousSymbolsB, "⧝", "", 10717, "M_10717", 0),

	M_10718(MiscellaneousSymbolsB, "⧞", "", 10718, "M_10718", 0),

	M_10719(MiscellaneousSymbolsB, "⧟", "", 10719, "M_10719", 0),

	M_10720(MiscellaneousSymbolsB, "⧠", "", 10720, "M_10720", 0),

	M_10721(MiscellaneousSymbolsB, "⧡", "", 10721, "M_10721", 0),

	M_10722(MiscellaneousSymbolsB, "⧢", "", 10722, "M_10722", 0),

	M_10723(MiscellaneousSymbolsB, "⧣", "", 10723, "M_10723", 0),

	M_10724(MiscellaneousSymbolsB, "⧤", "", 10724, "M_10724", 0),

	M_10725(MiscellaneousSymbolsB, "⧥", "", 10725, "M_10725", 0),

	M_10726(MiscellaneousSymbolsB, "⧦", "", 10726, "M_10726", 0),

	M_10727(MiscellaneousSymbolsB, "⧧", "", 10727, "M_10727", 0),

	M_10728(MiscellaneousSymbolsB, "⧨", "", 10728, "M_10728", 0),

	M_10729(MiscellaneousSymbolsB, "⧩", "", 10729, "M_10729", 0),

	M_10730(MiscellaneousSymbolsB, "⧪", "", 10730, "M_10730", 0),

	M_10731(MiscellaneousSymbolsB, "⧫", "", 10731, "M_10731", 0),

	M_10732(MiscellaneousSymbolsB, "⧬", "", 10732, "M_10732", 0),

	M_10733(MiscellaneousSymbolsB, "⧭", "", 10733, "M_10733", 0),

	M_10734(MiscellaneousSymbolsB, "⧮", "", 10734, "M_10734", 0),

	M_10735(MiscellaneousSymbolsB, "⧯", "", 10735, "M_10735", 0),

	M_10736(MiscellaneousSymbolsB, "⧰", "", 10736, "M_10736", 0),

	M_10737(MiscellaneousSymbolsB, "⧱", "", 10737, "M_10737", 0),

	M_10738(MiscellaneousSymbolsB, "⧲", "", 10738, "M_10738", 0),

	M_10739(MiscellaneousSymbolsB, "⧳", "", 10739, "M_10739", 0),

	M_10740(MiscellaneousSymbolsB, "⧴", "", 10740, "M_10740", 0),

	M_10741(MiscellaneousSymbolsB, "⧵", "", 10741, "M_10741", 0),

	M_10742(MiscellaneousSymbolsB, "⧶", "", 10742, "M_10742", 0),

	M_10743(MiscellaneousSymbolsB, "⧷", "", 10743, "M_10743", 0),

	M_10744(MiscellaneousSymbolsB, "⧸", "", 10744, "M_10744", 0),

	M_10745(MiscellaneousSymbolsB, "⧹", "", 10745, "M_10745", 0),

	M_10746(MiscellaneousSymbolsB, "⧺", "", 10746, "M_10746", 0),

	M_10747(MiscellaneousSymbolsB, "⧻", "", 10747, "M_10747", 0),

	M_10748(MiscellaneousSymbolsB, "⧼", "", 10748, "M_10748", 0),

	M_10749(MiscellaneousSymbolsB, "⧽", "", 10749, "M_10749", 0),

	M_10750(MiscellaneousSymbolsB, "⧾", "", 10750, "M_10750", 0),

	M_10751(MiscellaneousSymbolsB, "⧿", "", 10751, "M_10751", 0),

	// ---------- Miscellaneous Technical ---

	M_8960(MiscellaneousTechnical, "⌀", "", 8960, "M_8960", 0),

	M_8961(MiscellaneousTechnical, "⌁", "", 8961, "M_8961", 0),

	M_8962(MiscellaneousTechnical, "⌂", "", 8962, "M_8962", 0),

	M_8963(MiscellaneousTechnical, "⌃", "", 8963, "M_8963", 0),

	M_8964(MiscellaneousTechnical, "⌄", "", 8964, "M_8964", 0),

	M_8965(MiscellaneousTechnical, "⌅", "", 8965, "M_8965", 0),

	M_8966(MiscellaneousTechnical, "⌆", "", 8966, "M_8966", 0),

	M_8967(MiscellaneousTechnical, "⌇", "", 8967, "M_8967", 0),

	M_8968(MiscellaneousTechnical, "⌈", "", 8968, "M_8968", 0),

	M_8969(MiscellaneousTechnical, "⌉", "", 8969, "M_8969", 0),

	M_8970(MiscellaneousTechnical, "⌊", "", 8970, "M_8970", 0),

	M_8971(MiscellaneousTechnical, "⌋", "", 8971, "M_8971", 0),

	M_8972(MiscellaneousTechnical, "⌌", "", 8972, "M_8972", 0),

	M_8973(MiscellaneousTechnical, "⌍", "", 8973, "M_8973", 0),

	M_8974(MiscellaneousTechnical, "⌎", "", 8974, "M_8974", 0),

	M_8975(MiscellaneousTechnical, "⌏", "", 8975, "M_8975", 0),

	M_8976(MiscellaneousTechnical, "⌐", "", 8976, "M_8976", 0),

	M_8977(MiscellaneousTechnical, "⌑", "", 8977, "M_8977", 0),

	M_8978(MiscellaneousTechnical, "⌒", "", 8978, "M_8978", 0),

	M_8979(MiscellaneousTechnical, "⌓", "", 8979, "M_8979", 0),

	M_8980(MiscellaneousTechnical, "⌔", "", 8980, "M_8980", 0),

	M_8981(MiscellaneousTechnical, "⌕", "", 8981, "M_8981", 0),

	M_8982(MiscellaneousTechnical, "⌖", "", 8982, "M_8982", 0),

	M_8983(MiscellaneousTechnical, "⌗", "", 8983, "M_8983", 0),

	M_8984(MiscellaneousTechnical, "⌘", "", 8984, "M_8984", 0),

	M_8985(MiscellaneousTechnical, "⌙", "", 8985, "M_8985", 0),

	M_8986(MiscellaneousTechnical, "⌚", "", 8986, "M_8986", 0),

	M_8987(MiscellaneousTechnical, "⌛", "", 8987, "M_8987", 0),

	M_8988(MiscellaneousTechnical, "⌜", "", 8988, "M_8988", 0),

	M_8989(MiscellaneousTechnical, "⌝", "", 8989, "M_8989", 0),

	M_8990(MiscellaneousTechnical, "⌞", "", 8990, "M_8990", 0),

	M_8991(MiscellaneousTechnical, "⌟", "", 8991, "M_8991", 0),

	M_8992(MiscellaneousTechnical, "⌠", "", 8992, "M_8992", 0),

	M_8993(MiscellaneousTechnical, "⌡", "", 8993, "M_8993", 0),

	M_8994(MiscellaneousTechnical, "⌢", "", 8994, "M_8994", 0),

	M_8995(MiscellaneousTechnical, "⌣", "", 8995, "M_8995", 0),

	M_8996(MiscellaneousTechnical, "⌤", "", 8996, "M_8996", 0),

	M_8997(MiscellaneousTechnical, "⌥", "", 8997, "M_8997", 0),

	M_8998(MiscellaneousTechnical, "⌦", "", 8998, "M_8998", 0),

	M_8999(MiscellaneousTechnical, "⌧", "", 8999, "M_8999", 0),

	M_9000(MiscellaneousTechnical, "⌨", "", 9000, "M_9000", 0),

	M_9001(MiscellaneousTechnical, "〈", "", 9001, "M_9001", 0),

	M_9002(MiscellaneousTechnical, "〉", "", 9002, "M_9002", 0),

	M_9003(MiscellaneousTechnical, "⌫", "", 9003, "M_9003", 0),

	M_9004(MiscellaneousTechnical, "⌬", "", 9004, "M_9004", 0),

	M_9005(MiscellaneousTechnical, "⌭", "", 9005, "M_9005", 0),

	M_9006(MiscellaneousTechnical, "⌮", "", 9006, "M_9006", 0),

	M_9007(MiscellaneousTechnical, "⌯", "", 9007, "M_9007", 0),

	M_9008(MiscellaneousTechnical, "⌰", "", 9008, "M_9008", 0),

	M_9009(MiscellaneousTechnical, "⌱", "", 9009, "M_9009", 0),

	M_9010(MiscellaneousTechnical, "⌲", "", 9010, "M_9010", 0),

	M_9011(MiscellaneousTechnical, "⌳", "", 9011, "M_9011", 0),

	M_9012(MiscellaneousTechnical, "⌴", "", 9012, "M_9012", 0),

	M_9013(MiscellaneousTechnical, "⌵", "", 9013, "M_9013", 0),

	M_9014(MiscellaneousTechnical, "⌶", "", 9014, "M_9014", 0),

	M_9015(MiscellaneousTechnical, "⌷", "", 9015, "M_9015", 0),

	M_9016(MiscellaneousTechnical, "⌸", "", 9016, "M_9016", 0),

	M_9017(MiscellaneousTechnical, "⌹", "", 9017, "M_9017", 0),

	M_9018(MiscellaneousTechnical, "⌺", "", 9018, "M_9018", 0),

	M_9019(MiscellaneousTechnical, "⌻", "", 9019, "M_9019", 0),

	M_9020(MiscellaneousTechnical, "⌼", "", 9020, "M_9020", 0),

	M_9021(MiscellaneousTechnical, "⌽", "", 9021, "M_9021", 0),

	M_9022(MiscellaneousTechnical, "⌾", "", 9022, "M_9022", 0),

	M_9023(MiscellaneousTechnical, "⌿", "", 9023, "M_9023", 0),

	M_9024(MiscellaneousTechnical, "⍀", "", 9024, "M_9024", 0),

	M_9025(MiscellaneousTechnical, "⍁", "", 9025, "M_9025", 0),

	M_9026(MiscellaneousTechnical, "⍂", "", 9026, "M_9026", 0),

	M_9027(MiscellaneousTechnical, "⍃", "", 9027, "M_9027", 0),

	M_9028(MiscellaneousTechnical, "⍄", "", 9028, "M_9028", 0),

	M_9029(MiscellaneousTechnical, "⍅", "", 9029, "M_9029", 0),

	M_9030(MiscellaneousTechnical, "⍆", "", 9030, "M_9030", 0),

	M_9031(MiscellaneousTechnical, "⍇", "", 9031, "M_9031", 0),

	M_9032(MiscellaneousTechnical, "⍈", "", 9032, "M_9032", 0),

	M_9033(MiscellaneousTechnical, "⍉", "", 9033, "M_9033", 0),

	M_9034(MiscellaneousTechnical, "⍊", "", 9034, "M_9034", 0),

	M_9035(MiscellaneousTechnical, "⍋", "", 9035, "M_9035", 0),

	M_9036(MiscellaneousTechnical, "⍌", "", 9036, "M_9036", 0),

	M_9037(MiscellaneousTechnical, "⍍", "", 9037, "M_9037", 0),

	M_9038(MiscellaneousTechnical, "⍎", "", 9038, "M_9038", 0),

	M_9039(MiscellaneousTechnical, "⍏", "", 9039, "M_9039", 0),

	M_9040(MiscellaneousTechnical, "⍐", "", 9040, "M_9040", 0),

	M_9041(MiscellaneousTechnical, "⍑", "", 9041, "M_9041", 0),

	M_9042(MiscellaneousTechnical, "⍒", "", 9042, "M_9042", 0),

	M_9043(MiscellaneousTechnical, "⍓", "", 9043, "M_9043", 0),

	M_9044(MiscellaneousTechnical, "⍔", "", 9044, "M_9044", 0),

	M_9045(MiscellaneousTechnical, "⍕", "", 9045, "M_9045", 0),

	M_9046(MiscellaneousTechnical, "⍖", "", 9046, "M_9046", 0),

	M_9047(MiscellaneousTechnical, "⍗", "", 9047, "M_9047", 0),

	M_9048(MiscellaneousTechnical, "⍘", "", 9048, "M_9048", 0),

	M_9049(MiscellaneousTechnical, "⍙", "", 9049, "M_9049", 0),

	M_9050(MiscellaneousTechnical, "⍚", "", 9050, "M_9050", 0),

	M_9051(MiscellaneousTechnical, "⍛", "", 9051, "M_9051", 0),

	M_9052(MiscellaneousTechnical, "⍜", "", 9052, "M_9052", 0),

	M_9053(MiscellaneousTechnical, "⍝", "", 9053, "M_9053", 0),

	M_9054(MiscellaneousTechnical, "⍞", "", 9054, "M_9054", 0),

	M_9055(MiscellaneousTechnical, "⍟", "", 9055, "M_9055", 0),

	M_9056(MiscellaneousTechnical, "⍠", "", 9056, "M_9056", 0),

	M_9057(MiscellaneousTechnical, "⍡", "", 9057, "M_9057", 0),

	M_9058(MiscellaneousTechnical, "⍢", "", 9058, "M_9058", 0),

	M_9059(MiscellaneousTechnical, "⍣", "", 9059, "M_9059", 0),

	M_9060(MiscellaneousTechnical, "⍤", "", 9060, "M_9060", 0),

	M_9061(MiscellaneousTechnical, "⍥", "", 9061, "M_9061", 0),

	M_9062(MiscellaneousTechnical, "⍦", "", 9062, "M_9062", 0),

	M_9063(MiscellaneousTechnical, "⍧", "", 9063, "M_9063", 0),

	M_9064(MiscellaneousTechnical, "⍨", "", 9064, "M_9064", 0),

	M_9065(MiscellaneousTechnical, "⍩", "", 9065, "M_9065", 0),

	M_9066(MiscellaneousTechnical, "⍪", "", 9066, "M_9066", 0),

	M_9067(MiscellaneousTechnical, "⍫", "", 9067, "M_9067", 0),

	M_9068(MiscellaneousTechnical, "⍬", "", 9068, "M_9068", 0),

	M_9069(MiscellaneousTechnical, "⍭", "", 9069, "M_9069", 0),

	M_9070(MiscellaneousTechnical, "⍮", "", 9070, "M_9070", 0),

	M_9071(MiscellaneousTechnical, "⍯", "", 9071, "M_9071", 0),

	M_9072(MiscellaneousTechnical, "⍰", "", 9072, "M_9072", 0),

	M_9073(MiscellaneousTechnical, "⍱", "", 9073, "M_9073", 0),

	M_9074(MiscellaneousTechnical, "⍲", "", 9074, "M_9074", 0),

	M_9075(MiscellaneousTechnical, "⍳", "", 9075, "M_9075", 0),

	M_9076(MiscellaneousTechnical, "⍴", "", 9076, "M_9076", 0),

	M_9077(MiscellaneousTechnical, "⍵", "", 9077, "M_9077", 0),

	M_9078(MiscellaneousTechnical, "⍶", "", 9078, "M_9078", 0),

	M_9079(MiscellaneousTechnical, "⍷", "", 9079, "M_9079", 0),

	M_9080(MiscellaneousTechnical, "⍸", "", 9080, "M_9080", 0),

	M_9081(MiscellaneousTechnical, "⍹", "", 9081, "M_9081", 0),

	M_9082(MiscellaneousTechnical, "⍺", "", 9082, "M_9082", 0),

	M_9083(MiscellaneousTechnical, "⍻", "", 9083, "M_9083", 0),

	M_9084(MiscellaneousTechnical, "⍼", "", 9084, "M_9084", 0),

	M_9085(MiscellaneousTechnical, "⍽", "", 9085, "M_9085", 0),

	M_9086(MiscellaneousTechnical, "⍾", "", 9086, "M_9086", 0),

	M_9087(MiscellaneousTechnical, "⍿", "", 9087, "M_9087", 0),

	M_9088(MiscellaneousTechnical, "⎀", "", 9088, "M_9088", 0),

	M_9089(MiscellaneousTechnical, "⎁", "", 9089, "M_9089", 0),

	M_9090(MiscellaneousTechnical, "⎂", "", 9090, "M_9090", 0),

	M_9091(MiscellaneousTechnical, "⎃", "", 9091, "M_9091", 0),

	M_9092(MiscellaneousTechnical, "⎄", "", 9092, "M_9092", 0),

	M_9093(MiscellaneousTechnical, "⎅", "", 9093, "M_9093", 0),

	M_9094(MiscellaneousTechnical, "⎆", "", 9094, "M_9094", 0),

	M_9095(MiscellaneousTechnical, "⎇", "", 9095, "M_9095", 0),

	M_9096(MiscellaneousTechnical, "⎈", "", 9096, "M_9096", 0),

	M_9097(MiscellaneousTechnical, "⎉", "", 9097, "M_9097", 0),

	M_9098(MiscellaneousTechnical, "⎊", "", 9098, "M_9098", 0),

	M_9099(MiscellaneousTechnical, "⎋", "", 9099, "M_9099", 0),

	M_9100(MiscellaneousTechnical, "⎌", "", 9100, "M_9100", 0),

	M_9101(MiscellaneousTechnical, "⎍", "", 9101, "M_9101", 0),

	M_9102(MiscellaneousTechnical, "⎎", "", 9102, "M_9102", 0),

	M_9103(MiscellaneousTechnical, "⎏", "", 9103, "M_9103", 0),

	M_9104(MiscellaneousTechnical, "⎐", "", 9104, "M_9104", 0),

	M_9105(MiscellaneousTechnical, "⎑", "", 9105, "M_9105", 0),

	M_9106(MiscellaneousTechnical, "⎒", "", 9106, "M_9106", 0),

	M_9107(MiscellaneousTechnical, "⎓", "", 9107, "M_9107", 0),

	M_9108(MiscellaneousTechnical, "⎔", "", 9108, "M_9108", 0),

	M_9109(MiscellaneousTechnical, "⎕", "", 9109, "M_9109", 0),

	M_9110(MiscellaneousTechnical, "⎖", "", 9110, "M_9110", 0),

	M_9111(MiscellaneousTechnical, "⎗", "", 9111, "M_9111", 0),

	M_9112(MiscellaneousTechnical, "⎘", "", 9112, "M_9112", 0),

	M_9113(MiscellaneousTechnical, "⎙", "", 9113, "M_9113", 0),

	M_9114(MiscellaneousTechnical, "⎚", "", 9114, "M_9114", 0),

	M_9115(MiscellaneousTechnical, "⎛", "", 9115, "M_9115", 0),

	M_9116(MiscellaneousTechnical, "⎜", "", 9116, "M_9116", 0),

	M_9117(MiscellaneousTechnical, "⎝", "", 9117, "M_9117", 0),

	M_9118(MiscellaneousTechnical, "⎞", "", 9118, "M_9118", 0),

	M_9119(MiscellaneousTechnical, "⎟", "", 9119, "M_9119", 0),

	M_9120(MiscellaneousTechnical, "⎠", "", 9120, "M_9120", 0),

	M_9121(MiscellaneousTechnical, "⎡", "", 9121, "M_9121", 0),

	M_9122(MiscellaneousTechnical, "⎢", "", 9122, "M_9122", 0),

	M_9123(MiscellaneousTechnical, "⎣", "", 9123, "M_9123", 0),

	M_9124(MiscellaneousTechnical, "⎤", "", 9124, "M_9124", 0),

	M_9125(MiscellaneousTechnical, "⎥", "", 9125, "M_9125", 0),

	M_9126(MiscellaneousTechnical, "⎦", "", 9126, "M_9126", 0),

	M_9127(MiscellaneousTechnical, "⎧", "", 9127, "M_9127", 0),

	M_9128(MiscellaneousTechnical, "⎨", "", 9128, "M_9128", 0),

	M_9129(MiscellaneousTechnical, "⎩", "", 9129, "M_9129", 0),

	M_9130(MiscellaneousTechnical, "⎪", "", 9130, "M_9130", 0),

	M_9131(MiscellaneousTechnical, "⎫", "", 9131, "M_9131", 0),

	M_9132(MiscellaneousTechnical, "⎬", "", 9132, "M_9132", 0),

	M_9133(MiscellaneousTechnical, "⎭", "", 9133, "M_9133", 0),

	M_9134(MiscellaneousTechnical, "⎮", "", 9134, "M_9134", 0),

	M_9135(MiscellaneousTechnical, "⎯", "", 9135, "M_9135", 0),

	M_9136(MiscellaneousTechnical, "⎰", "", 9136, "M_9136", 0),

	M_9137(MiscellaneousTechnical, "⎱", "", 9137, "M_9137", 0),

	M_9138(MiscellaneousTechnical, "⎲", "", 9138, "M_9138", 0),

	M_9139(MiscellaneousTechnical, "⎳", "", 9139, "M_9139", 0),

	M_9140(MiscellaneousTechnical, "⎴", "", 9140, "M_9140", 0),

	M_9141(MiscellaneousTechnical, "⎵", "", 9141, "M_9141", 0),

	M_9142(MiscellaneousTechnical, "⎶", "", 9142, "M_9142", 0),

	M_9143(MiscellaneousTechnical, "⎷", "", 9143, "M_9143", 0),

	M_9144(MiscellaneousTechnical, "⎸", "", 9144, "M_9144", 0),

	M_9145(MiscellaneousTechnical, "⎹", "", 9145, "M_9145", 0),

	M_9146(MiscellaneousTechnical, "⎺", "", 9146, "M_9146", 0),

	M_9147(MiscellaneousTechnical, "⎻", "", 9147, "M_9147", 0),

	M_9148(MiscellaneousTechnical, "⎼", "", 9148, "M_9148", 0),

	M_9149(MiscellaneousTechnical, "⎽", "", 9149, "M_9149", 0),

	M_9150(MiscellaneousTechnical, "⎾", "", 9150, "M_9150", 0),

	M_9151(MiscellaneousTechnical, "⎿", "", 9151, "M_9151", 0),

	M_9152(MiscellaneousTechnical, "⏀", "", 9152, "M_9152", 0),

	M_9153(MiscellaneousTechnical, "⏁", "", 9153, "M_9153", 0),

	M_9154(MiscellaneousTechnical, "⏂", "", 9154, "M_9154", 0),

	M_9155(MiscellaneousTechnical, "⏃", "", 9155, "M_9155", 0),

	M_9156(MiscellaneousTechnical, "⏄", "", 9156, "M_9156", 0),

	M_9157(MiscellaneousTechnical, "⏅", "", 9157, "M_9157", 0),

	M_9158(MiscellaneousTechnical, "⏆", "", 9158, "M_9158", 0),

	M_9159(MiscellaneousTechnical, "⏇", "", 9159, "M_9159", 0),

	M_9160(MiscellaneousTechnical, "⏈", "", 9160, "M_9160", 0),

	M_9161(MiscellaneousTechnical, "⏉", "", 9161, "M_9161", 0),

	M_9162(MiscellaneousTechnical, "⏊", "", 9162, "M_9162", 0),

	M_9163(MiscellaneousTechnical, "⏋", "", 9163, "M_9163", 0),

	M_9164(MiscellaneousTechnical, "⏌", "", 9164, "M_9164", 0),

	M_9165(MiscellaneousTechnical, "⏍", "", 9165, "M_9165", 0),

	M_9166(MiscellaneousTechnical, "⏎", "", 9166, "M_9166", 0),

	M_9167(MiscellaneousTechnical, "⏏", "", 9167, "M_9167", 0),

	M_9168(MiscellaneousTechnical, "⏐", "", 9168, "M_9168", 0),

	M_9169(MiscellaneousTechnical, "⏑", "", 9169, "M_9169", 0),

	M_9170(MiscellaneousTechnical, "⏒", "", 9170, "M_9170", 0),

	M_9171(MiscellaneousTechnical, "⏓", "", 9171, "M_9171", 0),

	M_9172(MiscellaneousTechnical, "⏔", "", 9172, "M_9172", 0),

	M_9173(MiscellaneousTechnical, "⏕", "", 9173, "M_9173", 0),

	M_9174(MiscellaneousTechnical, "⏖", "", 9174, "M_9174", 0),

	M_9175(MiscellaneousTechnical, "⏗", "", 9175, "M_9175", 0),

	M_9176(MiscellaneousTechnical, "⏘", "", 9176, "M_9176", 0),

	M_9177(MiscellaneousTechnical, "⏙", "", 9177, "M_9177", 0),

	M_9178(MiscellaneousTechnical, "⏚", "", 9178, "M_9178", 0),

	M_9179(MiscellaneousTechnical, "⏛", "", 9179, "M_9179", 0),

	M_9180(MiscellaneousTechnical, "⏜", "", 9180, "M_9180", 0),

	M_9181(MiscellaneousTechnical, "⏝", "", 9181, "M_9181", 0),

	M_9182(MiscellaneousTechnical, "⏞", "", 9182, "M_9182", 0),

	M_9183(MiscellaneousTechnical, "⏟", "", 9183, "M_9183", 0),

	M_9184(MiscellaneousTechnical, "⏠", "", 9184, "M_9184", 0),

	M_9185(MiscellaneousTechnical, "⏡", "", 9185, "M_9185", 0),

	M_9186(MiscellaneousTechnical, "⏢", "", 9186, "M_9186", 0),

	M_9187(MiscellaneousTechnical, "⏣", "", 9187, "M_9187", 0),

	M_9188(MiscellaneousTechnical, "⏤", "", 9188, "M_9188", 0),

	M_9189(MiscellaneousTechnical, "⏥", "", 9189, "M_9189", 0),

	M_9190(MiscellaneousTechnical, "⏦", "", 9190, "M_9190", 0),

	M_9191(MiscellaneousTechnical, "⏧", "", 9191, "M_9191", 0),

	M_9192(MiscellaneousTechnical, "⏨", "", 9192, "M_9192", 0),

	M_9193(MiscellaneousTechnical, "⏩", "", 9193, "M_9193", 0),

	M_9194(MiscellaneousTechnical, "⏪", "", 9194, "M_9194", 0),

	M_9195(MiscellaneousTechnical, "⏫", "", 9195, "M_9195", 0),

	M_9196(MiscellaneousTechnical, "⏬", "", 9196, "M_9196", 0),

	M_9197(MiscellaneousTechnical, "⏭", "", 9197, "M_9197", 0),

	M_9198(MiscellaneousTechnical, "⏮", "", 9198, "M_9198", 0),

	M_9199(MiscellaneousTechnical, "⏯", "", 9199, "M_9199", 0),

	M_9200(MiscellaneousTechnical, "⏰", "", 9200, "M_9200", 0),

	M_9201(MiscellaneousTechnical, "⏱", "", 9201, "M_9201", 0),

	M_9202(MiscellaneousTechnical, "⏲", "", 9202, "M_9202", 0),

	M_9203(MiscellaneousTechnical, "⏳", "", 9203, "M_9203", 0),

	M_9204(MiscellaneousTechnical, "⏴", "", 9204, "M_9204", 0),

	M_9205(MiscellaneousTechnical, "⏵", "", 9205, "M_9205", 0),

	M_9206(MiscellaneousTechnical, "⏶", "", 9206, "M_9206", 0),

	M_9207(MiscellaneousTechnical, "⏷", "", 9207, "M_9207", 0),

	M_9208(MiscellaneousTechnical, "⏸", "", 9208, "M_9208", 0),

	M_9209(MiscellaneousTechnical, "⏹", "", 9209, "M_9209", 0),

	M_9210(MiscellaneousTechnical, "⏺", "", 9210, "M_9210", 0),

	M_9211(MiscellaneousTechnical, "⏻", "", 9211, "M_9211", 0),

	M_9212(MiscellaneousTechnical, "⏼", "", 9212, "M_9212", 0),

	M_9213(MiscellaneousTechnical, "⏽", "", 9213, "M_9213", 0),

	M_9214(MiscellaneousTechnical, "⏾", "", 9214, "M_9214", 0),

	M_9215(MiscellaneousTechnical, "⏿", "", 9215, "M_9215", 0),

	// ---------- Geometric Shapes ---

	M_9632(GeometricShapes, "■", "", 9632, "M_9632", 0),

	M_9633(GeometricShapes, "□", "", 9633, "M_9633", 0),

	M_9634(GeometricShapes, "▢", "", 9634, "M_9634", 0),

	M_9635(GeometricShapes, "▣", "", 9635, "M_9635", 0),

	M_9636(GeometricShapes, "▤", "", 9636, "M_9636", 0),

	M_9637(GeometricShapes, "▥", "", 9637, "M_9637", 0),

	M_9638(GeometricShapes, "▦", "", 9638, "M_9638", 0),

	M_9639(GeometricShapes, "▧", "", 9639, "M_9639", 0),

	M_9640(GeometricShapes, "▨", "", 9640, "M_9640", 0),

	M_9641(GeometricShapes, "▩", "", 9641, "M_9641", 0),

	M_9642(GeometricShapes, "▪", "", 9642, "M_9642", 0),

	M_9643(GeometricShapes, "▫", "", 9643, "M_9643", 0),

	M_9644(GeometricShapes, "▬", "", 9644, "M_9644", 0),

	M_9645(GeometricShapes, "▭", "", 9645, "M_9645", 0),

	M_9646(GeometricShapes, "▮", "", 9646, "M_9646", 0),

	M_9647(GeometricShapes, "▯", "", 9647, "M_9647", 0),

	M_9648(GeometricShapes, "▰", "", 9648, "M_9648", 0),

	M_9649(GeometricShapes, "▱", "", 9649, "M_9649", 0),

	M_9650(GeometricShapes, "▲", "", 9650, "M_9650", 0),

	M_9651(GeometricShapes, "△", "", 9651, "M_9651", 0),

	M_9652(GeometricShapes, "▴", "", 9652, "M_9652", 0),

	M_9653(GeometricShapes, "▵", "", 9653, "M_9653", 0),

	M_9654(GeometricShapes, "▶", "", 9654, "M_9654", 0),

	M_9655(GeometricShapes, "▷", "", 9655, "M_9655", 0),

	M_9656(GeometricShapes, "▸", "", 9656, "M_9656", 0),

	M_9657(GeometricShapes, "▹", "", 9657, "M_9657", 0),

	M_9658(GeometricShapes, "►", "", 9658, "M_9658", 0),

	M_9659(GeometricShapes, "▻", "", 9659, "M_9659", 0),

	M_9660(GeometricShapes, "▼", "", 9660, "M_9660", 0),

	M_9661(GeometricShapes, "▽", "", 9661, "M_9661", 0),

	M_9662(GeometricShapes, "▾", "", 9662, "M_9662", 0),

	M_9663(GeometricShapes, "▿", "", 9663, "M_9663", 0),

	M_9664(GeometricShapes, "◀", "", 9664, "M_9664", 0),

	M_9665(GeometricShapes, "◁", "", 9665, "M_9665", 0),

	M_9666(GeometricShapes, "◂", "", 9666, "M_9666", 0),

	M_9667(GeometricShapes, "◃", "", 9667, "M_9667", 0),

	M_9668(GeometricShapes, "◄", "", 9668, "M_9668", 0),

	M_9669(GeometricShapes, "◅", "", 9669, "M_9669", 0),

	M_9670(GeometricShapes, "◆", "", 9670, "M_9670", 0),

	M_9671(GeometricShapes, "◇", "", 9671, "M_9671", 0),

	M_9672(GeometricShapes, "◈", "", 9672, "M_9672", 0),

	M_9673(GeometricShapes, "◉", "", 9673, "M_9673", 0),

	M_9674(GeometricShapes, "◊", "", 9674, "M_9674", 0),

	M_9675(GeometricShapes, "○", "", 9675, "M_9675", 0),

	M_9676(GeometricShapes, "◌", "", 9676, "M_9676", 0),

	M_9677(GeometricShapes, "◍", "", 9677, "M_9677", 0),

	M_9678(GeometricShapes, "◎", "", 9678, "M_9678", 0),

	M_9679(GeometricShapes, "●", "", 9679, "M_9679", 0),

	M_9680(GeometricShapes, "◐", "", 9680, "M_9680", 0),

	M_9681(GeometricShapes, "◑", "", 9681, "M_9681", 0),

	M_9682(GeometricShapes, "◒", "", 9682, "M_9682", 0),

	M_9683(GeometricShapes, "◓", "", 9683, "M_9683", 0),

	M_9684(GeometricShapes, "◔", "", 9684, "M_9684", 0),

	M_9685(GeometricShapes, "◕", "", 9685, "M_9685", 0),

	M_9686(GeometricShapes, "◖", "", 9686, "M_9686", 0),

	M_9687(GeometricShapes, "◗", "", 9687, "M_9687", 0),

	M_9688(GeometricShapes, "◘", "", 9688, "M_9688", 0),

	M_9689(GeometricShapes, "◙", "", 9689, "M_9689", 0),

	M_9690(GeometricShapes, "◚", "", 9690, "M_9690", 0),

	M_9691(GeometricShapes, "◛", "", 9691, "M_9691", 0),

	M_9692(GeometricShapes, "◜", "", 9692, "M_9692", 0),

	M_9693(GeometricShapes, "◝", "", 9693, "M_9693", 0),

	M_9694(GeometricShapes, "◞", "", 9694, "M_9694", 0),

	M_9695(GeometricShapes, "◟", "", 9695, "M_9695", 0),

	M_9696(GeometricShapes, "◠", "", 9696, "M_9696", 0),

	M_9697(GeometricShapes, "◡", "", 9697, "M_9697", 0),

	M_9698(GeometricShapes, "◢", "", 9698, "M_9698", 0),

	M_9699(GeometricShapes, "◣", "", 9699, "M_9699", 0),

	M_9700(GeometricShapes, "◤", "", 9700, "M_9700", 0),

	M_9701(GeometricShapes, "◥", "", 9701, "M_9701", 0),

	M_9702(GeometricShapes, "◦", "", 9702, "M_9702", 0),

	M_9703(GeometricShapes, "◧", "", 9703, "M_9703", 0),

	M_9704(GeometricShapes, "◨", "", 9704, "M_9704", 0),

	M_9705(GeometricShapes, "◩", "", 9705, "M_9705", 0),

	M_9706(GeometricShapes, "◪", "", 9706, "M_9706", 0),

	M_9707(GeometricShapes, "◫", "", 9707, "M_9707", 0),

	M_9708(GeometricShapes, "◬", "", 9708, "M_9708", 0),

	M_9709(GeometricShapes, "◭", "", 9709, "M_9709", 0),

	M_9710(GeometricShapes, "◮", "", 9710, "M_9710", 0),

	M_9711(GeometricShapes, "◯", "", 9711, "M_9711", 0),

	M_9712(GeometricShapes, "◰", "", 9712, "M_9712", 0),

	M_9713(GeometricShapes, "◱", "", 9713, "M_9713", 0),

	M_9714(GeometricShapes, "◲", "", 9714, "M_9714", 0),

	M_9715(GeometricShapes, "◳", "", 9715, "M_9715", 0),

	M_9716(GeometricShapes, "◴", "", 9716, "M_9716", 0),

	M_9717(GeometricShapes, "◵", "", 9717, "M_9717", 0),

	M_9718(GeometricShapes, "◶", "", 9718, "M_9718", 0),

	M_9719(GeometricShapes, "◷", "", 9719, "M_9719", 0),

	M_9720(GeometricShapes, "◸", "", 9720, "M_9720", 0),

	M_9721(GeometricShapes, "◹", "", 9721, "M_9721", 0),

	M_9722(GeometricShapes, "◺", "", 9722, "M_9722", 0),

	M_9723(GeometricShapes, "◻", "", 9723, "M_9723", 0),

	M_9724(GeometricShapes, "◼", "", 9724, "M_9724", 0),

	M_9725(GeometricShapes, "◽", "", 9725, "M_9725", 0),

	M_9726(GeometricShapes, "◾", "", 9726, "M_9726", 0),

	M_9727(GeometricShapes, "◿", "", 9727, "M_9727", 0),

	// ---------- Miscellaneous Symbols and Arrows ---

	M_11008(MiscellaneousSymbolsandArrows, "⬀", "", 11008, "M_11008", 0),

	M_11009(MiscellaneousSymbolsandArrows, "⬁", "", 11009, "M_11009", 0),

	M_11010(MiscellaneousSymbolsandArrows, "⬂", "", 11010, "M_11010", 0),

	M_11011(MiscellaneousSymbolsandArrows, "⬃", "", 11011, "M_11011", 0),

	M_11012(MiscellaneousSymbolsandArrows, "⬄", "", 11012, "M_11012", 0),

	M_11013(MiscellaneousSymbolsandArrows, "⬅", "", 11013, "M_11013", 0),

	M_11014(MiscellaneousSymbolsandArrows, "⬆", "", 11014, "M_11014", 0),

	M_11015(MiscellaneousSymbolsandArrows, "⬇", "", 11015, "M_11015", 0),

	M_11016(MiscellaneousSymbolsandArrows, "⬈", "", 11016, "M_11016", 0),

	M_11017(MiscellaneousSymbolsandArrows, "⬉", "", 11017, "M_11017", 0),

	M_11018(MiscellaneousSymbolsandArrows, "⬊", "", 11018, "M_11018", 0),

	M_11019(MiscellaneousSymbolsandArrows, "⬋", "", 11019, "M_11019", 0),

	M_11020(MiscellaneousSymbolsandArrows, "⬌", "", 11020, "M_11020", 0),

	M_11021(MiscellaneousSymbolsandArrows, "⬍", "", 11021, "M_11021", 0),

	M_11022(MiscellaneousSymbolsandArrows, "⬎", "", 11022, "M_11022", 0),

	M_11023(MiscellaneousSymbolsandArrows, "⬏", "", 11023, "M_11023", 0),

	M_11024(MiscellaneousSymbolsandArrows, "⬐", "", 11024, "M_11024", 0),

	M_11025(MiscellaneousSymbolsandArrows, "⬑", "", 11025, "M_11025", 0),

	M_11026(MiscellaneousSymbolsandArrows, "⬒", "", 11026, "M_11026", 0),

	M_11027(MiscellaneousSymbolsandArrows, "⬓", "", 11027, "M_11027", 0),

	M_11028(MiscellaneousSymbolsandArrows, "⬔", "", 11028, "M_11028", 0),

	M_11029(MiscellaneousSymbolsandArrows, "⬕", "", 11029, "M_11029", 0),

	M_11030(MiscellaneousSymbolsandArrows, "⬖", "", 11030, "M_11030", 0),

	M_11031(MiscellaneousSymbolsandArrows, "⬗", "", 11031, "M_11031", 0),

	M_11032(MiscellaneousSymbolsandArrows, "⬘", "", 11032, "M_11032", 0),

	M_11033(MiscellaneousSymbolsandArrows, "⬙", "", 11033, "M_11033", 0),

	M_11034(MiscellaneousSymbolsandArrows, "⬚", "", 11034, "M_11034", 0),

	M_11035(MiscellaneousSymbolsandArrows, "⬛", "", 11035, "M_11035", 0),

	M_11036(MiscellaneousSymbolsandArrows, "⬜", "", 11036, "M_11036", 0),

	M_11037(MiscellaneousSymbolsandArrows, "⬝", "", 11037, "M_11037", 0),

	M_11038(MiscellaneousSymbolsandArrows, "⬞", "", 11038, "M_11038", 0),

	M_11039(MiscellaneousSymbolsandArrows, "⬟", "", 11039, "M_11039", 0),

	M_11040(MiscellaneousSymbolsandArrows, "⬠", "", 11040, "M_11040", 0),

	M_11041(MiscellaneousSymbolsandArrows, "⬡", "", 11041, "M_11041", 0),

	M_11042(MiscellaneousSymbolsandArrows, "⬢", "", 11042, "M_11042", 0),

	M_11043(MiscellaneousSymbolsandArrows, "⬣", "", 11043, "M_11043", 0),

	M_11044(MiscellaneousSymbolsandArrows, "⬤", "", 11044, "M_11044", 0),

	M_11045(MiscellaneousSymbolsandArrows, "⬥", "", 11045, "M_11045", 0),

	M_11046(MiscellaneousSymbolsandArrows, "⬦", "", 11046, "M_11046", 0),

	M_11047(MiscellaneousSymbolsandArrows, "⬧", "", 11047, "M_11047", 0),

	M_11048(MiscellaneousSymbolsandArrows, "⬨", "", 11048, "M_11048", 0),

	M_11049(MiscellaneousSymbolsandArrows, "⬩", "", 11049, "M_11049", 0),

	M_11050(MiscellaneousSymbolsandArrows, "⬪", "", 11050, "M_11050", 0),

	M_11051(MiscellaneousSymbolsandArrows, "⬫", "", 11051, "M_11051", 0),

	M_11052(MiscellaneousSymbolsandArrows, "⬬", "", 11052, "M_11052", 0),

	M_11053(MiscellaneousSymbolsandArrows, "⬭", "", 11053, "M_11053", 0),

	M_11054(MiscellaneousSymbolsandArrows, "⬮", "", 11054, "M_11054", 0),

	M_11055(MiscellaneousSymbolsandArrows, "⬯", "", 11055, "M_11055", 0),

	M_11056(MiscellaneousSymbolsandArrows, "⬰", "", 11056, "M_11056", 0),

	M_11057(MiscellaneousSymbolsandArrows, "⬱", "", 11057, "M_11057", 0),

	M_11058(MiscellaneousSymbolsandArrows, "⬲", "", 11058, "M_11058", 0),

	M_11059(MiscellaneousSymbolsandArrows, "⬳", "", 11059, "M_11059", 0),

	M_11060(MiscellaneousSymbolsandArrows, "⬴", "", 11060, "M_11060", 0),

	M_11061(MiscellaneousSymbolsandArrows, "⬵", "", 11061, "M_11061", 0),

	M_11062(MiscellaneousSymbolsandArrows, "⬶", "", 11062, "M_11062", 0),

	M_11063(MiscellaneousSymbolsandArrows, "⬷", "", 11063, "M_11063", 0),

	M_11064(MiscellaneousSymbolsandArrows, "⬸", "", 11064, "M_11064", 0),

	M_11065(MiscellaneousSymbolsandArrows, "⬹", "", 11065, "M_11065", 0),

	M_11066(MiscellaneousSymbolsandArrows, "⬺", "", 11066, "M_11066", 0),

	M_11067(MiscellaneousSymbolsandArrows, "⬻", "", 11067, "M_11067", 0),

	M_11068(MiscellaneousSymbolsandArrows, "⬼", "", 11068, "M_11068", 0),

	M_11069(MiscellaneousSymbolsandArrows, "⬽", "", 11069, "M_11069", 0),

	M_11070(MiscellaneousSymbolsandArrows, "⬾", "", 11070, "M_11070", 0),

	M_11071(MiscellaneousSymbolsandArrows, "⬿", "", 11071, "M_11071", 0),

	M_11072(MiscellaneousSymbolsandArrows, "⭀", "", 11072, "M_11072", 0),

	M_11073(MiscellaneousSymbolsandArrows, "⭁", "", 11073, "M_11073", 0),

	M_11074(MiscellaneousSymbolsandArrows, "⭂", "", 11074, "M_11074", 0),

	M_11075(MiscellaneousSymbolsandArrows, "⭃", "", 11075, "M_11075", 0),

	M_11076(MiscellaneousSymbolsandArrows, "⭄", "", 11076, "M_11076", 0),

	M_11077(MiscellaneousSymbolsandArrows, "⭅", "", 11077, "M_11077", 0),

	M_11078(MiscellaneousSymbolsandArrows, "⭆", "", 11078, "M_11078", 0),

	M_11079(MiscellaneousSymbolsandArrows, "⭇", "", 11079, "M_11079", 0),

	M_11080(MiscellaneousSymbolsandArrows, "⭈", "", 11080, "M_11080", 0),

	M_11081(MiscellaneousSymbolsandArrows, "⭉", "", 11081, "M_11081", 0),

	M_11082(MiscellaneousSymbolsandArrows, "⭊", "", 11082, "M_11082", 0),

	M_11083(MiscellaneousSymbolsandArrows, "⭋", "", 11083, "M_11083", 0),

	M_11084(MiscellaneousSymbolsandArrows, "⭌", "", 11084, "M_11084", 0),

	M_11085(MiscellaneousSymbolsandArrows, "⭍", "", 11085, "M_11085", 0),

	M_11086(MiscellaneousSymbolsandArrows, "⭎", "", 11086, "M_11086", 0),

	M_11087(MiscellaneousSymbolsandArrows, "⭏", "", 11087, "M_11087", 0),

	M_11088(MiscellaneousSymbolsandArrows, "⭐", "", 11088, "M_11088", 0),

	M_11089(MiscellaneousSymbolsandArrows, "⭑", "", 11089, "M_11089", 0),

	M_11090(MiscellaneousSymbolsandArrows, "⭒", "", 11090, "M_11090", 0),

	M_11091(MiscellaneousSymbolsandArrows, "⭓", "", 11091, "M_11091", 0),

	M_11092(MiscellaneousSymbolsandArrows, "⭔", "", 11092, "M_11092", 0),

	M_11093(MiscellaneousSymbolsandArrows, "⭕", "", 11093, "M_11093", 0),

	M_11094(MiscellaneousSymbolsandArrows, "⭖", "", 11094, "M_11094", 0),

	M_11095(MiscellaneousSymbolsandArrows, "⭗", "", 11095, "M_11095", 0),

	M_11096(MiscellaneousSymbolsandArrows, "⭘", "", 11096, "M_11096", 0),

	M_11097(MiscellaneousSymbolsandArrows, "⭙", "", 11097, "M_11097", 0),

	M_11098(MiscellaneousSymbolsandArrows, "⭚", "", 11098, "M_11098", 0),

	M_11099(MiscellaneousSymbolsandArrows, "⭛", "", 11099, "M_11099", 0),

	M_11100(MiscellaneousSymbolsandArrows, "⭜", "", 11100, "M_11100", 0),

	M_11101(MiscellaneousSymbolsandArrows, "⭝", "", 11101, "M_11101", 0),

	M_11102(MiscellaneousSymbolsandArrows, "⭞", "", 11102, "M_11102", 0),

	M_11103(MiscellaneousSymbolsandArrows, "⭟", "", 11103, "M_11103", 0),

	M_11104(MiscellaneousSymbolsandArrows, "⭠", "", 11104, "M_11104", 0),

	M_11105(MiscellaneousSymbolsandArrows, "⭡", "", 11105, "M_11105", 0),

	M_11106(MiscellaneousSymbolsandArrows, "⭢", "", 11106, "M_11106", 0),

	M_11107(MiscellaneousSymbolsandArrows, "⭣", "", 11107, "M_11107", 0),

	M_11108(MiscellaneousSymbolsandArrows, "⭤", "", 11108, "M_11108", 0),

	M_11109(MiscellaneousSymbolsandArrows, "⭥", "", 11109, "M_11109", 0),

	M_11110(MiscellaneousSymbolsandArrows, "⭦", "", 11110, "M_11110", 0),

	M_11111(MiscellaneousSymbolsandArrows, "⭧", "", 11111, "M_11111", 0),

	M_11112(MiscellaneousSymbolsandArrows, "⭨", "", 11112, "M_11112", 0),

	M_11113(MiscellaneousSymbolsandArrows, "⭩", "", 11113, "M_11113", 0),

	M_11114(MiscellaneousSymbolsandArrows, "⭪", "", 11114, "M_11114", 0),

	M_11115(MiscellaneousSymbolsandArrows, "⭫", "", 11115, "M_11115", 0),

	M_11116(MiscellaneousSymbolsandArrows, "⭬", "", 11116, "M_11116", 0),

	M_11117(MiscellaneousSymbolsandArrows, "⭭", "", 11117, "M_11117", 0),

	M_11118(MiscellaneousSymbolsandArrows, "⭮", "", 11118, "M_11118", 0),

	M_11119(MiscellaneousSymbolsandArrows, "⭯", "", 11119, "M_11119", 0),

	M_11120(MiscellaneousSymbolsandArrows, "⭰", "", 11120, "M_11120", 0),

	M_11121(MiscellaneousSymbolsandArrows, "⭱", "", 11121, "M_11121", 0),

	M_11122(MiscellaneousSymbolsandArrows, "⭲", "", 11122, "M_11122", 0),

	M_11123(MiscellaneousSymbolsandArrows, "⭳", "", 11123, "M_11123", 0),

	M_11124(MiscellaneousSymbolsandArrows, "⭴", "", 11124, "M_11124", 0),

	M_11125(MiscellaneousSymbolsandArrows, "⭵", "", 11125, "M_11125", 0),

	M_11126(MiscellaneousSymbolsandArrows, "⭶", "", 11126, "M_11126", 0),

	M_11127(MiscellaneousSymbolsandArrows, "⭷", "", 11127, "M_11127", 0),

	M_11128(MiscellaneousSymbolsandArrows, "⭸", "", 11128, "M_11128", 0),

	M_11129(MiscellaneousSymbolsandArrows, "⭹", "", 11129, "M_11129", 0),

	M_11130(MiscellaneousSymbolsandArrows, "⭺", "", 11130, "M_11130", 0),

	M_11131(MiscellaneousSymbolsandArrows, "⭻", "", 11131, "M_11131", 0),

	M_11132(MiscellaneousSymbolsandArrows, "⭼", "", 11132, "M_11132", 0),

	M_11133(MiscellaneousSymbolsandArrows, "⭽", "", 11133, "M_11133", 0),

	M_11134(MiscellaneousSymbolsandArrows, "⭾", "", 11134, "M_11134", 0),

	M_11135(MiscellaneousSymbolsandArrows, "⭿", "", 11135, "M_11135", 0),

	M_11136(MiscellaneousSymbolsandArrows, "⮀", "", 11136, "M_11136", 0),

	M_11137(MiscellaneousSymbolsandArrows, "⮁", "", 11137, "M_11137", 0),

	M_11138(MiscellaneousSymbolsandArrows, "⮂", "", 11138, "M_11138", 0),

	M_11139(MiscellaneousSymbolsandArrows, "⮃", "", 11139, "M_11139", 0),

	M_11140(MiscellaneousSymbolsandArrows, "⮄", "", 11140, "M_11140", 0),

	M_11141(MiscellaneousSymbolsandArrows, "⮅", "", 11141, "M_11141", 0),

	M_11142(MiscellaneousSymbolsandArrows, "⮆", "", 11142, "M_11142", 0),

	M_11143(MiscellaneousSymbolsandArrows, "⮇", "", 11143, "M_11143", 0),

	M_11144(MiscellaneousSymbolsandArrows, "⮈", "", 11144, "M_11144", 0),

	M_11145(MiscellaneousSymbolsandArrows, "⮉", "", 11145, "M_11145", 0),

	M_11146(MiscellaneousSymbolsandArrows, "⮊", "", 11146, "M_11146", 0),

	M_11147(MiscellaneousSymbolsandArrows, "⮋", "", 11147, "M_11147", 0),

	M_11148(MiscellaneousSymbolsandArrows, "⮌", "", 11148, "M_11148", 0),

	M_11149(MiscellaneousSymbolsandArrows, "⮍", "", 11149, "M_11149", 0),

	M_11150(MiscellaneousSymbolsandArrows, "⮎", "", 11150, "M_11150", 0),

	M_11151(MiscellaneousSymbolsandArrows, "⮏", "", 11151, "M_11151", 0),

	M_11152(MiscellaneousSymbolsandArrows, "⮐", "", 11152, "M_11152", 0),

	M_11153(MiscellaneousSymbolsandArrows, "⮑", "", 11153, "M_11153", 0),

	M_11154(MiscellaneousSymbolsandArrows, "⮒", "", 11154, "M_11154", 0),

	M_11155(MiscellaneousSymbolsandArrows, "⮓", "", 11155, "M_11155", 0),

	M_11156(MiscellaneousSymbolsandArrows, "⮔", "", 11156, "M_11156", 0),

	M_11157(MiscellaneousSymbolsandArrows, "⮕", "", 11157, "M_11157", 0),

	M_11158(MiscellaneousSymbolsandArrows, "⮖", "", 11158, "M_11158", 0),

	M_11159(MiscellaneousSymbolsandArrows, "⮗", "", 11159, "M_11159", 0),

	M_11160(MiscellaneousSymbolsandArrows, "⮘", "", 11160, "M_11160", 0),

	M_11161(MiscellaneousSymbolsandArrows, "⮙", "", 11161, "M_11161", 0),

	M_11162(MiscellaneousSymbolsandArrows, "⮚", "", 11162, "M_11162", 0),

	M_11163(MiscellaneousSymbolsandArrows, "⮛", "", 11163, "M_11163", 0),

	M_11164(MiscellaneousSymbolsandArrows, "⮜", "", 11164, "M_11164", 0),

	M_11165(MiscellaneousSymbolsandArrows, "⮝", "", 11165, "M_11165", 0),

	M_11166(MiscellaneousSymbolsandArrows, "⮞", "", 11166, "M_11166", 0),

	M_11167(MiscellaneousSymbolsandArrows, "⮟", "", 11167, "M_11167", 0),

	M_11168(MiscellaneousSymbolsandArrows, "⮠", "", 11168, "M_11168", 0),

	M_11169(MiscellaneousSymbolsandArrows, "⮡", "", 11169, "M_11169", 0),

	M_11170(MiscellaneousSymbolsandArrows, "⮢", "", 11170, "M_11170", 0),

	M_11171(MiscellaneousSymbolsandArrows, "⮣", "", 11171, "M_11171", 0),

	M_11172(MiscellaneousSymbolsandArrows, "⮤", "", 11172, "M_11172", 0),

	M_11173(MiscellaneousSymbolsandArrows, "⮥", "", 11173, "M_11173", 0),

	M_11174(MiscellaneousSymbolsandArrows, "⮦", "", 11174, "M_11174", 0),

	M_11175(MiscellaneousSymbolsandArrows, "⮧", "", 11175, "M_11175", 0),

	M_11176(MiscellaneousSymbolsandArrows, "⮨", "", 11176, "M_11176", 0),

	M_11177(MiscellaneousSymbolsandArrows, "⮩", "", 11177, "M_11177", 0),

	M_11178(MiscellaneousSymbolsandArrows, "⮪", "", 11178, "M_11178", 0),

	M_11179(MiscellaneousSymbolsandArrows, "⮫", "", 11179, "M_11179", 0),

	M_11180(MiscellaneousSymbolsandArrows, "⮬", "", 11180, "M_11180", 0),

	M_11181(MiscellaneousSymbolsandArrows, "⮭", "", 11181, "M_11181", 0),

	M_11182(MiscellaneousSymbolsandArrows, "⮮", "", 11182, "M_11182", 0),

	M_11183(MiscellaneousSymbolsandArrows, "⮯", "", 11183, "M_11183", 0),

	M_11184(MiscellaneousSymbolsandArrows, "⮰", "", 11184, "M_11184", 0),

	M_11185(MiscellaneousSymbolsandArrows, "⮱", "", 11185, "M_11185", 0),

	M_11186(MiscellaneousSymbolsandArrows, "⮲", "", 11186, "M_11186", 0),

	M_11187(MiscellaneousSymbolsandArrows, "⮳", "", 11187, "M_11187", 0),

	M_11188(MiscellaneousSymbolsandArrows, "⮴", "", 11188, "M_11188", 0),

	M_11189(MiscellaneousSymbolsandArrows, "⮵", "", 11189, "M_11189", 0),

	M_11190(MiscellaneousSymbolsandArrows, "⮶", "", 11190, "M_11190", 0),

	M_11191(MiscellaneousSymbolsandArrows, "⮷", "", 11191, "M_11191", 0),

	M_11192(MiscellaneousSymbolsandArrows, "⮸", "", 11192, "M_11192", 0),

	M_11193(MiscellaneousSymbolsandArrows, "⮹", "", 11193, "M_11193", 0),

	M_11194(MiscellaneousSymbolsandArrows, "⮺", "", 11194, "M_11194", 0),

	M_11195(MiscellaneousSymbolsandArrows, "⮻", "", 11195, "M_11195", 0),

	M_11196(MiscellaneousSymbolsandArrows, "⮼", "", 11196, "M_11196", 0),

	M_11197(MiscellaneousSymbolsandArrows, "⮽", "", 11197, "M_11197", 0),

	M_11198(MiscellaneousSymbolsandArrows, "⮾", "", 11198, "M_11198", 0),

	M_11199(MiscellaneousSymbolsandArrows, "⮿", "", 11199, "M_11199", 0),

	M_11200(MiscellaneousSymbolsandArrows, "⯀", "", 11200, "M_11200", 0),

	M_11201(MiscellaneousSymbolsandArrows, "⯁", "", 11201, "M_11201", 0),

	M_11202(MiscellaneousSymbolsandArrows, "⯂", "", 11202, "M_11202", 0),

	M_11203(MiscellaneousSymbolsandArrows, "⯃", "", 11203, "M_11203", 0),

	M_11204(MiscellaneousSymbolsandArrows, "⯄", "", 11204, "M_11204", 0),

	M_11205(MiscellaneousSymbolsandArrows, "⯅", "", 11205, "M_11205", 0),

	M_11206(MiscellaneousSymbolsandArrows, "⯆", "", 11206, "M_11206", 0),

	M_11207(MiscellaneousSymbolsandArrows, "⯇", "", 11207, "M_11207", 0),

	M_11208(MiscellaneousSymbolsandArrows, "⯈", "", 11208, "M_11208", 0),

	M_11209(MiscellaneousSymbolsandArrows, "⯉", "", 11209, "M_11209", 0),

	M_11210(MiscellaneousSymbolsandArrows, "⯊", "", 11210, "M_11210", 0),

	M_11211(MiscellaneousSymbolsandArrows, "⯋", "", 11211, "M_11211", 0),

	M_11212(MiscellaneousSymbolsandArrows, "⯌", "", 11212, "M_11212", 0),

	M_11213(MiscellaneousSymbolsandArrows, "⯍", "", 11213, "M_11213", 0),

	M_11214(MiscellaneousSymbolsandArrows, "⯎", "", 11214, "M_11214", 0),

	M_11215(MiscellaneousSymbolsandArrows, "⯏", "", 11215, "M_11215", 0),

	M_11216(MiscellaneousSymbolsandArrows, "⯐", "", 11216, "M_11216", 0),

	M_11217(MiscellaneousSymbolsandArrows, "⯑", "", 11217, "M_11217", 0),

	M_11218(MiscellaneousSymbolsandArrows, "⯒", "", 11218, "M_11218", 0),

	M_11219(MiscellaneousSymbolsandArrows, "⯓", "", 11219, "M_11219", 0),

	M_11220(MiscellaneousSymbolsandArrows, "⯔", "", 11220, "M_11220", 0),

	M_11221(MiscellaneousSymbolsandArrows, "⯕", "", 11221, "M_11221", 0),

	M_11222(MiscellaneousSymbolsandArrows, "⯖", "", 11222, "M_11222", 0),

	M_11223(MiscellaneousSymbolsandArrows, "⯗", "", 11223, "M_11223", 0),

	M_11224(MiscellaneousSymbolsandArrows, "⯘", "", 11224, "M_11224", 0),

	M_11225(MiscellaneousSymbolsandArrows, "⯙", "", 11225, "M_11225", 0),

	M_11226(MiscellaneousSymbolsandArrows, "⯚", "", 11226, "M_11226", 0),

	M_11227(MiscellaneousSymbolsandArrows, "⯛", "", 11227, "M_11227", 0),

	M_11228(MiscellaneousSymbolsandArrows, "⯜", "", 11228, "M_11228", 0),

	M_11229(MiscellaneousSymbolsandArrows, "⯝", "", 11229, "M_11229", 0),

	M_11230(MiscellaneousSymbolsandArrows, "⯞", "", 11230, "M_11230", 0),

	M_11231(MiscellaneousSymbolsandArrows, "⯟", "", 11231, "M_11231", 0),

	M_11232(MiscellaneousSymbolsandArrows, "⯠", "", 11232, "M_11232", 0),

	M_11233(MiscellaneousSymbolsandArrows, "⯡", "", 11233, "M_11233", 0),

	M_11234(MiscellaneousSymbolsandArrows, "⯢", "", 11234, "M_11234", 0),

	M_11235(MiscellaneousSymbolsandArrows, "⯣", "", 11235, "M_11235", 0),

	M_11236(MiscellaneousSymbolsandArrows, "⯤", "", 11236, "M_11236", 0),

	M_11237(MiscellaneousSymbolsandArrows, "⯥", "", 11237, "M_11237", 0),

	M_11238(MiscellaneousSymbolsandArrows, "⯦", "", 11238, "M_11238", 0),

	M_11239(MiscellaneousSymbolsandArrows, "⯧", "", 11239, "M_11239", 0),

	M_11240(MiscellaneousSymbolsandArrows, "⯨", "", 11240, "M_11240", 0),

	M_11241(MiscellaneousSymbolsandArrows, "⯩", "", 11241, "M_11241", 0),

	M_11242(MiscellaneousSymbolsandArrows, "⯪", "", 11242, "M_11242", 0),

	M_11243(MiscellaneousSymbolsandArrows, "⯫", "", 11243, "M_11243", 0),

	M_11244(MiscellaneousSymbolsandArrows, "⯬", "", 11244, "M_11244", 0),

	M_11245(MiscellaneousSymbolsandArrows, "⯭", "", 11245, "M_11245", 0),

	M_11246(MiscellaneousSymbolsandArrows, "⯮", "", 11246, "M_11246", 0),

	M_11247(MiscellaneousSymbolsandArrows, "⯯", "", 11247, "M_11247", 0),

	M_11248(MiscellaneousSymbolsandArrows, "⯰", "", 11248, "M_11248", 0),

	M_11249(MiscellaneousSymbolsandArrows, "⯱", "", 11249, "M_11249", 0),

	M_11250(MiscellaneousSymbolsandArrows, "⯲", "", 11250, "M_11250", 0),

	M_11251(MiscellaneousSymbolsandArrows, "⯳", "", 11251, "M_11251", 0),

	M_11252(MiscellaneousSymbolsandArrows, "⯴", "", 11252, "M_11252", 0),

	M_11253(MiscellaneousSymbolsandArrows, "⯵", "", 11253, "M_11253", 0),

	M_11254(MiscellaneousSymbolsandArrows, "⯶", "", 11254, "M_11254", 0),

	M_11255(MiscellaneousSymbolsandArrows, "⯷", "", 11255, "M_11255", 0),

	M_11256(MiscellaneousSymbolsandArrows, "⯸", "", 11256, "M_11256", 0),

	M_11257(MiscellaneousSymbolsandArrows, "⯹", "", 11257, "M_11257", 0),

	M_11258(MiscellaneousSymbolsandArrows, "⯺", "", 11258, "M_11258", 0),

	M_11259(MiscellaneousSymbolsandArrows, "⯻", "", 11259, "M_11259", 0),

	M_11260(MiscellaneousSymbolsandArrows, "⯼", "", 11260, "M_11260", 0),

	M_11261(MiscellaneousSymbolsandArrows, "⯽", "", 11261, "M_11261", 0),

	M_11262(MiscellaneousSymbolsandArrows, "⯾", "", 11262, "M_11262", 0),

	M_11263(MiscellaneousSymbolsandArrows, "⯿", "", 11263, "M_11263", 0),

	// ---------- Arrows ---

	M_8592(Arrows, "←", "", 8592, "M_8592", 0),

	M_8593(Arrows, "↑", "", 8593, "M_8593", 0),

	M_8594(Arrows, "→", "", 8594, "M_8594", 0),

	M_8595(Arrows, "↓", "", 8595, "M_8595", 0),

	M_8596(Arrows, "↔", "", 8596, "M_8596", 0),

	M_8597(Arrows, "↕", "", 8597, "M_8597", 0),

	M_8598(Arrows, "↖", "", 8598, "M_8598", 0),

	M_8599(Arrows, "↗", "", 8599, "M_8599", 0),

	M_8600(Arrows, "↘", "", 8600, "M_8600", 0),

	M_8601(Arrows, "↙", "", 8601, "M_8601", 0),

	M_8602(Arrows, "↚", "", 8602, "M_8602", 0),

	M_8603(Arrows, "↛", "", 8603, "M_8603", 0),

	M_8604(Arrows, "↜", "", 8604, "M_8604", 0),

	M_8605(Arrows, "↝", "", 8605, "M_8605", 0),

	M_8606(Arrows, "↞", "", 8606, "M_8606", 0),

	M_8607(Arrows, "↟", "", 8607, "M_8607", 0),

	M_8608(Arrows, "↠", "", 8608, "M_8608", 0),

	M_8609(Arrows, "↡", "", 8609, "M_8609", 0),

	M_8610(Arrows, "↢", "", 8610, "M_8610", 0),

	M_8611(Arrows, "↣", "", 8611, "M_8611", 0),

	M_8612(Arrows, "↤", "", 8612, "M_8612", 0),

	M_8613(Arrows, "↥", "", 8613, "M_8613", 0),

	M_8614(Arrows, "↦", "", 8614, "M_8614", 0),

	M_8615(Arrows, "↧", "", 8615, "M_8615", 0),

	M_8616(Arrows, "↨", "", 8616, "M_8616", 0),

	M_8617(Arrows, "↩", "", 8617, "M_8617", 0),

	M_8618(Arrows, "↪", "", 8618, "M_8618", 0),

	M_8619(Arrows, "↫", "", 8619, "M_8619", 0),

	M_8620(Arrows, "↬", "", 8620, "M_8620", 0),

	M_8621(Arrows, "↭", "", 8621, "M_8621", 0),

	M_8622(Arrows, "↮", "", 8622, "M_8622", 0),

	M_8623(Arrows, "↯", "", 8623, "M_8623", 0),

	M_8624(Arrows, "↰", "", 8624, "M_8624", 0),

	M_8625(Arrows, "↱", "", 8625, "M_8625", 0),

	M_8626(Arrows, "↲", "", 8626, "M_8626", 0),

	M_8627(Arrows, "↳", "", 8627, "M_8627", 0),

	M_8628(Arrows, "↴", "", 8628, "M_8628", 0),

	M_8629(Arrows, "↵", "", 8629, "M_8629", 0),

	M_8630(Arrows, "↶", "", 8630, "M_8630", 0),

	M_8631(Arrows, "↷", "", 8631, "M_8631", 0),

	M_8632(Arrows, "↸", "", 8632, "M_8632", 0),

	M_8633(Arrows, "↹", "", 8633, "M_8633", 0),

	M_8634(Arrows, "↺", "", 8634, "M_8634", 0),

	M_8635(Arrows, "↻", "", 8635, "M_8635", 0),

	M_8636(Arrows, "↼", "", 8636, "M_8636", 0),

	M_8637(Arrows, "↽", "", 8637, "M_8637", 0),

	M_8638(Arrows, "↾", "", 8638, "M_8638", 0),

	M_8639(Arrows, "↿", "", 8639, "M_8639", 0),

	M_8640(Arrows, "⇀", "", 8640, "M_8640", 0),

	M_8641(Arrows, "⇁", "", 8641, "M_8641", 0),

	M_8642(Arrows, "⇂", "", 8642, "M_8642", 0),

	M_8643(Arrows, "⇃", "", 8643, "M_8643", 0),

	M_8644(Arrows, "⇄", "", 8644, "M_8644", 0),

	M_8645(Arrows, "⇅", "", 8645, "M_8645", 0),

	M_8646(Arrows, "⇆", "", 8646, "M_8646", 0),

	M_8647(Arrows, "⇇", "", 8647, "M_8647", 0),

	M_8648(Arrows, "⇈", "", 8648, "M_8648", 0),

	M_8649(Arrows, "⇉", "", 8649, "M_8649", 0),

	M_8650(Arrows, "⇊", "", 8650, "M_8650", 0),

	M_8651(Arrows, "⇋", "", 8651, "M_8651", 0),

	M_8652(Arrows, "⇌", "", 8652, "M_8652", 0),

	M_8653(Arrows, "⇍", "", 8653, "M_8653", 0),

	M_8654(Arrows, "⇎", "", 8654, "M_8654", 0),

	M_8655(Arrows, "⇏", "", 8655, "M_8655", 0),

	M_8656(Arrows, "⇐", "", 8656, "M_8656", 0),

	M_8657(Arrows, "⇑", "", 8657, "M_8657", 0),

	M_8658(Arrows, "⇒", "", 8658, "M_8658", 0),

	M_8659(Arrows, "⇓", "", 8659, "M_8659", 0),

	M_8660(Arrows, "⇔", "", 8660, "M_8660", 0),

	M_8661(Arrows, "⇕", "", 8661, "M_8661", 0),

	M_8662(Arrows, "⇖", "", 8662, "M_8662", 0),

	M_8663(Arrows, "⇗", "", 8663, "M_8663", 0),

	M_8664(Arrows, "⇘", "", 8664, "M_8664", 0),

	M_8665(Arrows, "⇙", "", 8665, "M_8665", 0),

	M_8666(Arrows, "⇚", "", 8666, "M_8666", 0),

	M_8667(Arrows, "⇛", "", 8667, "M_8667", 0),

	M_8668(Arrows, "⇜", "", 8668, "M_8668", 0),

	M_8669(Arrows, "⇝", "", 8669, "M_8669", 0),

	M_8670(Arrows, "⇞", "", 8670, "M_8670", 0),

	M_8671(Arrows, "⇟", "", 8671, "M_8671", 0),

	M_8672(Arrows, "⇠", "", 8672, "M_8672", 0),

	M_8673(Arrows, "⇡", "", 8673, "M_8673", 0),

	M_8674(Arrows, "⇢", "", 8674, "M_8674", 0),

	M_8675(Arrows, "⇣", "", 8675, "M_8675", 0),

	M_8676(Arrows, "⇤", "", 8676, "M_8676", 0),

	M_8677(Arrows, "⇥", "", 8677, "M_8677", 0),

	M_8678(Arrows, "⇦", "", 8678, "M_8678", 0),

	M_8679(Arrows, "⇧", "", 8679, "M_8679", 0),

	M_8680(Arrows, "⇨", "", 8680, "M_8680", 0),

	M_8681(Arrows, "⇩", "", 8681, "M_8681", 0),

	M_8682(Arrows, "⇪", "", 8682, "M_8682", 0),

	M_8683(Arrows, "⇫", "", 8683, "M_8683", 0),

	M_8684(Arrows, "⇬", "", 8684, "M_8684", 0),

	M_8685(Arrows, "⇭", "", 8685, "M_8685", 0),

	M_8686(Arrows, "⇮", "", 8686, "M_8686", 0),

	M_8687(Arrows, "⇯", "", 8687, "M_8687", 0),

	M_8688(Arrows, "⇰", "", 8688, "M_8688", 0),

	M_8689(Arrows, "⇱", "", 8689, "M_8689", 0),

	M_8690(Arrows, "⇲", "", 8690, "M_8690", 0),

	M_8691(Arrows, "⇳", "", 8691, "M_8691", 0),

	M_8692(Arrows, "⇴", "", 8692, "M_8692", 0),

	M_8693(Arrows, "⇵", "", 8693, "M_8693", 0),

	M_8694(Arrows, "⇶", "", 8694, "M_8694", 0),

	M_8695(Arrows, "⇷", "", 8695, "M_8695", 0),

	M_8696(Arrows, "⇸", "", 8696, "M_8696", 0),

	M_8697(Arrows, "⇹", "", 8697, "M_8697", 0),

	M_8698(Arrows, "⇺", "", 8698, "M_8698", 0),

	M_8699(Arrows, "⇻", "", 8699, "M_8699", 0),

	M_8700(Arrows, "⇼", "", 8700, "M_8700", 0),

	M_8701(Arrows, "⇽", "", 8701, "M_8701", 0),

	M_8702(Arrows, "⇾", "", 8702, "M_8702", 0),

	M_8703(Arrows, "⇿", "", 8703, "M_8703", 0),

	// ---------- Supplemental Arrows-A ---

	M_10224(SupplementalArrows_A, "⟰", "", 10224, "M_10224", 0),

	M_10225(SupplementalArrows_A, "⟱", "", 10225, "M_10225", 0),

	M_10226(SupplementalArrows_A, "⟲", "", 10226, "M_10226", 0),

	M_10227(SupplementalArrows_A, "⟳", "", 10227, "M_10227", 0),

	M_10228(SupplementalArrows_A, "⟴", "", 10228, "M_10228", 0),

	M_10229(SupplementalArrows_A, "⟵", "", 10229, "M_10229", 0),

	M_10230(SupplementalArrows_A, "⟶", "", 10230, "M_10230", 0),

	M_10231(SupplementalArrows_A, "⟷", "", 10231, "M_10231", 0),

	M_10232(SupplementalArrows_A, "⟸", "", 10232, "M_10232", 0),

	M_10233(SupplementalArrows_A, "⟹", "", 10233, "M_10233", 0),

	M_10234(SupplementalArrows_A, "⟺", "", 10234, "M_10234", 0),

	M_10235(SupplementalArrows_A, "⟻", "", 10235, "M_10235", 0),

	M_10236(SupplementalArrows_A, "⟼", "", 10236, "M_10236", 0),

	M_10237(SupplementalArrows_A, "⟽", "", 10237, "M_10237", 0),

	M_10238(SupplementalArrows_A, "⟾", "", 10238, "M_10238", 0),

	M_10239(SupplementalArrows_A, "⟿", "", 10239, "M_10239", 0),

	// ---------- Supplemental Arrows-B ---

	M_10496(SupplementalArrows_B, "⤀", "", 10496, "M_10496", 0),

	M_10497(SupplementalArrows_B, "⤁", "", 10497, "M_10497", 0),

	M_10498(SupplementalArrows_B, "⤂", "", 10498, "M_10498", 0),

	M_10499(SupplementalArrows_B, "⤃", "", 10499, "M_10499", 0),

	M_10500(SupplementalArrows_B, "⤄", "", 10500, "M_10500", 0),

	M_10501(SupplementalArrows_B, "⤅", "", 10501, "M_10501", 0),

	M_10502(SupplementalArrows_B, "⤆", "", 10502, "M_10502", 0),

	M_10503(SupplementalArrows_B, "⤇", "", 10503, "M_10503", 0),

	M_10504(SupplementalArrows_B, "⤈", "", 10504, "M_10504", 0),

	M_10505(SupplementalArrows_B, "⤉", "", 10505, "M_10505", 0),

	M_10506(SupplementalArrows_B, "⤊", "", 10506, "M_10506", 0),

	M_10507(SupplementalArrows_B, "⤋", "", 10507, "M_10507", 0),

	M_10508(SupplementalArrows_B, "⤌", "", 10508, "M_10508", 0),

	M_10509(SupplementalArrows_B, "⤍", "", 10509, "M_10509", 0),

	M_10510(SupplementalArrows_B, "⤎", "", 10510, "M_10510", 0),

	M_10511(SupplementalArrows_B, "⤏", "", 10511, "M_10511", 0),

	M_10512(SupplementalArrows_B, "⤐", "", 10512, "M_10512", 0),

	M_10513(SupplementalArrows_B, "⤑", "", 10513, "M_10513", 0),

	M_10514(SupplementalArrows_B, "⤒", "", 10514, "M_10514", 0),

	M_10515(SupplementalArrows_B, "⤓", "", 10515, "M_10515", 0),

	M_10516(SupplementalArrows_B, "⤔", "", 10516, "M_10516", 0),

	M_10517(SupplementalArrows_B, "⤕", "", 10517, "M_10517", 0),

	M_10518(SupplementalArrows_B, "⤖", "", 10518, "M_10518", 0),

	M_10519(SupplementalArrows_B, "⤗", "", 10519, "M_10519", 0),

	M_10520(SupplementalArrows_B, "⤘", "", 10520, "M_10520", 0),

	M_10521(SupplementalArrows_B, "⤙", "", 10521, "M_10521", 0),

	M_10522(SupplementalArrows_B, "⤚", "", 10522, "M_10522", 0),

	M_10523(SupplementalArrows_B, "⤛", "", 10523, "M_10523", 0),

	M_10524(SupplementalArrows_B, "⤜", "", 10524, "M_10524", 0),

	M_10525(SupplementalArrows_B, "⤝", "", 10525, "M_10525", 0),

	M_10526(SupplementalArrows_B, "⤞", "", 10526, "M_10526", 0),

	M_10527(SupplementalArrows_B, "⤟", "", 10527, "M_10527", 0),

	M_10528(SupplementalArrows_B, "⤠", "", 10528, "M_10528", 0),

	M_10529(SupplementalArrows_B, "⤡", "", 10529, "M_10529", 0),

	M_10530(SupplementalArrows_B, "⤢", "", 10530, "M_10530", 0),

	M_10531(SupplementalArrows_B, "⤣", "", 10531, "M_10531", 0),

	M_10532(SupplementalArrows_B, "⤤", "", 10532, "M_10532", 0),

	M_10533(SupplementalArrows_B, "⤥", "", 10533, "M_10533", 0),

	M_10534(SupplementalArrows_B, "⤦", "", 10534, "M_10534", 0),

	M_10535(SupplementalArrows_B, "⤧", "", 10535, "M_10535", 0),

	M_10536(SupplementalArrows_B, "⤨", "", 10536, "M_10536", 0),

	M_10537(SupplementalArrows_B, "⤩", "", 10537, "M_10537", 0),

	M_10538(SupplementalArrows_B, "⤪", "", 10538, "M_10538", 0),

	M_10539(SupplementalArrows_B, "⤫", "", 10539, "M_10539", 0),

	M_10540(SupplementalArrows_B, "⤬", "", 10540, "M_10540", 0),

	M_10541(SupplementalArrows_B, "⤭", "", 10541, "M_10541", 0),

	M_10542(SupplementalArrows_B, "⤮", "", 10542, "M_10542", 0),

	M_10543(SupplementalArrows_B, "⤯", "", 10543, "M_10543", 0),

	M_10544(SupplementalArrows_B, "⤰", "", 10544, "M_10544", 0),

	M_10545(SupplementalArrows_B, "⤱", "", 10545, "M_10545", 0),

	M_10546(SupplementalArrows_B, "⤲", "", 10546, "M_10546", 0),

	M_10547(SupplementalArrows_B, "⤳", "", 10547, "M_10547", 0),

	M_10548(SupplementalArrows_B, "⤴", "", 10548, "M_10548", 0),

	M_10549(SupplementalArrows_B, "⤵", "", 10549, "M_10549", 0),

	M_10550(SupplementalArrows_B, "⤶", "", 10550, "M_10550", 0),

	M_10551(SupplementalArrows_B, "⤷", "", 10551, "M_10551", 0),

	M_10552(SupplementalArrows_B, "⤸", "", 10552, "M_10552", 0),

	M_10553(SupplementalArrows_B, "⤹", "", 10553, "M_10553", 0),

	M_10554(SupplementalArrows_B, "⤺", "", 10554, "M_10554", 0),

	M_10555(SupplementalArrows_B, "⤻", "", 10555, "M_10555", 0),

	M_10556(SupplementalArrows_B, "⤼", "", 10556, "M_10556", 0),

	M_10557(SupplementalArrows_B, "⤽", "", 10557, "M_10557", 0),

	M_10558(SupplementalArrows_B, "⤾", "", 10558, "M_10558", 0),

	M_10559(SupplementalArrows_B, "⤿", "", 10559, "M_10559", 0),

	M_10560(SupplementalArrows_B, "⥀", "", 10560, "M_10560", 0),

	M_10561(SupplementalArrows_B, "⥁", "", 10561, "M_10561", 0),

	M_10562(SupplementalArrows_B, "⥂", "", 10562, "M_10562", 0),

	M_10563(SupplementalArrows_B, "⥃", "", 10563, "M_10563", 0),

	M_10564(SupplementalArrows_B, "⥄", "", 10564, "M_10564", 0),

	M_10565(SupplementalArrows_B, "⥅", "", 10565, "M_10565", 0),

	M_10566(SupplementalArrows_B, "⥆", "", 10566, "M_10566", 0),

	M_10567(SupplementalArrows_B, "⥇", "", 10567, "M_10567", 0),

	M_10568(SupplementalArrows_B, "⥈", "", 10568, "M_10568", 0),

	M_10569(SupplementalArrows_B, "⥉", "", 10569, "M_10569", 0),

	M_10570(SupplementalArrows_B, "⥊", "", 10570, "M_10570", 0),

	M_10571(SupplementalArrows_B, "⥋", "", 10571, "M_10571", 0),

	M_10572(SupplementalArrows_B, "⥌", "", 10572, "M_10572", 0),

	M_10573(SupplementalArrows_B, "⥍", "", 10573, "M_10573", 0),

	M_10574(SupplementalArrows_B, "⥎", "", 10574, "M_10574", 0),

	M_10575(SupplementalArrows_B, "⥏", "", 10575, "M_10575", 0),

	M_10576(SupplementalArrows_B, "⥐", "", 10576, "M_10576", 0),

	M_10577(SupplementalArrows_B, "⥑", "", 10577, "M_10577", 0),

	M_10578(SupplementalArrows_B, "⥒", "", 10578, "M_10578", 0),

	M_10579(SupplementalArrows_B, "⥓", "", 10579, "M_10579", 0),

	M_10580(SupplementalArrows_B, "⥔", "", 10580, "M_10580", 0),

	M_10581(SupplementalArrows_B, "⥕", "", 10581, "M_10581", 0),

	M_10582(SupplementalArrows_B, "⥖", "", 10582, "M_10582", 0),

	M_10583(SupplementalArrows_B, "⥗", "", 10583, "M_10583", 0),

	M_10584(SupplementalArrows_B, "⥘", "", 10584, "M_10584", 0),

	M_10585(SupplementalArrows_B, "⥙", "", 10585, "M_10585", 0),

	M_10586(SupplementalArrows_B, "⥚", "", 10586, "M_10586", 0),

	M_10587(SupplementalArrows_B, "⥛", "", 10587, "M_10587", 0),

	M_10588(SupplementalArrows_B, "⥜", "", 10588, "M_10588", 0),

	M_10589(SupplementalArrows_B, "⥝", "", 10589, "M_10589", 0),

	M_10590(SupplementalArrows_B, "⥞", "", 10590, "M_10590", 0),

	M_10591(SupplementalArrows_B, "⥟", "", 10591, "M_10591", 0),

	M_10592(SupplementalArrows_B, "⥠", "", 10592, "M_10592", 0),

	M_10593(SupplementalArrows_B, "⥡", "", 10593, "M_10593", 0),

	M_10594(SupplementalArrows_B, "⥢", "", 10594, "M_10594", 0),

	M_10595(SupplementalArrows_B, "⥣", "", 10595, "M_10595", 0),

	M_10596(SupplementalArrows_B, "⥤", "", 10596, "M_10596", 0),

	M_10597(SupplementalArrows_B, "⥥", "", 10597, "M_10597", 0),

	M_10598(SupplementalArrows_B, "⥦", "", 10598, "M_10598", 0),

	M_10599(SupplementalArrows_B, "⥧", "", 10599, "M_10599", 0),

	M_10600(SupplementalArrows_B, "⥨", "", 10600, "M_10600", 0),

	M_10601(SupplementalArrows_B, "⥩", "", 10601, "M_10601", 0),

	M_10602(SupplementalArrows_B, "⥪", "", 10602, "M_10602", 0),

	M_10603(SupplementalArrows_B, "⥫", "", 10603, "M_10603", 0),

	M_10604(SupplementalArrows_B, "⥬", "", 10604, "M_10604", 0),

	M_10605(SupplementalArrows_B, "⥭", "", 10605, "M_10605", 0),

	M_10606(SupplementalArrows_B, "⥮", "", 10606, "M_10606", 0),

	M_10607(SupplementalArrows_B, "⥯", "", 10607, "M_10607", 0),

	M_10608(SupplementalArrows_B, "⥰", "", 10608, "M_10608", 0),

	M_10609(SupplementalArrows_B, "⥱", "", 10609, "M_10609", 0),

	M_10610(SupplementalArrows_B, "⥲", "", 10610, "M_10610", 0),

	M_10611(SupplementalArrows_B, "⥳", "", 10611, "M_10611", 0),

	M_10612(SupplementalArrows_B, "⥴", "", 10612, "M_10612", 0),

	M_10613(SupplementalArrows_B, "⥵", "", 10613, "M_10613", 0),

	M_10614(SupplementalArrows_B, "⥶", "", 10614, "M_10614", 0),

	M_10615(SupplementalArrows_B, "⥷", "", 10615, "M_10615", 0),

	M_10616(SupplementalArrows_B, "⥸", "", 10616, "M_10616", 0),

	M_10617(SupplementalArrows_B, "⥹", "", 10617, "M_10617", 0),

	M_10618(SupplementalArrows_B, "⥺", "", 10618, "M_10618", 0),

	M_10619(SupplementalArrows_B, "⥻", "", 10619, "M_10619", 0),

	M_10620(SupplementalArrows_B, "⥼", "", 10620, "M_10620", 0),

	M_10621(SupplementalArrows_B, "⥽", "", 10621, "M_10621", 0),

	M_10622(SupplementalArrows_B, "⥾", "", 10622, "M_10622", 0),

	M_10623(SupplementalArrows_B, "⥿", "", 10623, "M_10623", 0),

	// ---------- Combining Diacritical Marks for Symbols ---

	M_8400(DiacriticalMarksforSymbols, "⃐", "", 8400, "M_8400", 0),

	M_8401(DiacriticalMarksforSymbols, "⃑", "", 8401, "M_8401", 0),

	M_8402(DiacriticalMarksforSymbols, "⃒", "", 8402, "M_8402", 0),

	M_8403(DiacriticalMarksforSymbols, "⃓", "", 8403, "M_8403", 0),

	M_8404(DiacriticalMarksforSymbols, "⃔", "", 8404, "M_8404", 0),

	M_8405(DiacriticalMarksforSymbols, "⃕", "", 8405, "M_8405", 0),

	M_8406(DiacriticalMarksforSymbols, "⃖", "", 8406, "M_8406", 0),

	M_8407(DiacriticalMarksforSymbols, "⃗", "", 8407, "M_8407", 0),

	M_8408(DiacriticalMarksforSymbols, "⃘", "", 8408, "M_8408", 0),

	M_8409(DiacriticalMarksforSymbols, "⃙", "", 8409, "M_8409", 0),

	M_8410(DiacriticalMarksforSymbols, "⃚", "", 8410, "M_8410", 0),

	M_8411(DiacriticalMarksforSymbols, "⃛", "", 8411, "M_8411", 0),

	M_8412(DiacriticalMarksforSymbols, "⃜", "", 8412, "M_8412", 0),

	M_8413(DiacriticalMarksforSymbols, "⃝", "", 8413, "M_8413", 0),

	M_8414(DiacriticalMarksforSymbols, "⃞", "", 8414, "M_8414", 0),

	M_8415(DiacriticalMarksforSymbols, "⃟", "", 8415, "M_8415", 0),

	M_8416(DiacriticalMarksforSymbols, "⃠", "", 8416, "M_8416", 0),

	M_8417(DiacriticalMarksforSymbols, "⃡", "", 8417, "M_8417", 0),

	M_8418(DiacriticalMarksforSymbols, "⃢", "", 8418, "M_8418", 0),

	M_8419(DiacriticalMarksforSymbols, "⃣", "", 8419, "M_8419", 0),

	M_8420(DiacriticalMarksforSymbols, "⃤", "", 8420, "M_8420", 0),

	M_8421(DiacriticalMarksforSymbols, "⃥", "", 8421, "M_8421", 0),

	M_8422(DiacriticalMarksforSymbols, "⃦", "", 8422, "M_8422", 0),

	M_8423(DiacriticalMarksforSymbols, "⃧", "", 8423, "M_8423", 0),

	M_8424(DiacriticalMarksforSymbols, "⃨", "", 8424, "M_8424", 0),

	M_8425(DiacriticalMarksforSymbols, "⃩", "", 8425, "M_8425", 0),

	M_8426(DiacriticalMarksforSymbols, "⃪", "", 8426, "M_8426", 0),

	M_8427(DiacriticalMarksforSymbols, "⃫", "", 8427, "M_8427", 0),

	M_8428(DiacriticalMarksforSymbols, "⃬", "", 8428, "M_8428", 0),

	M_8429(DiacriticalMarksforSymbols, "⃭", "", 8429, "M_8429", 0),

	M_8430(DiacriticalMarksforSymbols, "⃮", "", 8430, "M_8430", 0),

	M_8431(DiacriticalMarksforSymbols, "⃯", "", 8431, "M_8431", 0),

	M_8432(DiacriticalMarksforSymbols, "⃰", "", 8432, "M_8432", 0),

	M_8433(DiacriticalMarksforSymbols, "⃱", "", 8433, "M_8433", 0),

	M_8434(DiacriticalMarksforSymbols, "⃲", "", 8434, "M_8434", 0),

	M_8435(DiacriticalMarksforSymbols, "⃳", "", 8435, "M_8435", 0),

	M_8436(DiacriticalMarksforSymbols, "⃴", "", 8436, "M_8436", 0),

	M_8437(DiacriticalMarksforSymbols, "⃵", "", 8437, "M_8437", 0),

	M_8438(DiacriticalMarksforSymbols, "⃶", "", 8438, "M_8438", 0),

	M_8439(DiacriticalMarksforSymbols, "⃷", "", 8439, "M_8439", 0),

	M_8440(DiacriticalMarksforSymbols, "⃸", "", 8440, "M_8440", 0),

	M_8441(DiacriticalMarksforSymbols, "⃹", "", 8441, "M_8441", 0),

	M_8442(DiacriticalMarksforSymbols, "⃺", "", 8442, "M_8442", 0),

	M_8443(DiacriticalMarksforSymbols, "⃻", "", 8443, "M_8443", 0),

	M_8444(DiacriticalMarksforSymbols, "⃼", "", 8444, "M_8444", 0),

	M_8445(DiacriticalMarksforSymbols, "⃽", "", 8445, "M_8445", 0),

	M_8446(DiacriticalMarksforSymbols, "⃾", "", 8446, "M_8446", 0),

	M_8447(DiacriticalMarksforSymbols, "⃿", "", 8447, "M_8447", 0),

	;

	final private String text;

	final private String latex;

	final private int block;

	final private String toolTip;

	final int caretPosition;

	EnLatexMath(int block, String text, String toolTip, int code, String latex, int caretPosition) {
		this.block = block;
		this.text = text;
		this.toolTip = toolTip;
		this.latex = latex;
		this.caretPosition = caretPosition;
	}

	public String getText() {
		return text;
	}

	public String getLatex() {
		if (latex.startsWith("M_")) {
			return text;
		}
		return latex;
	}

	public int getBlock() {
		return block;
	}

	public static List<EnLatexMath> getBlock(int block) {
		List<EnLatexMath> result = new ArrayList<EnLatexMath>();
		for (EnLatexMath m : EnLatexMath.values()) {
			if (m.getBlock() == block) {
				result.add(m);
			}
		}
		return result;
	}

	public static String getTitle(int block) {
		switch (block) {
		case Structures:
			return "Structures";
		case Operators:
			return "Operators";
		case OperatorsSupplement:
			return "Operators Supplement";
		case AlphanumericSymbols:
			return "Alphanumeric Symbols";
		case LetterlikeSymbols:
			return "Letterlike Symbols";
		case MiscellaneousSymbolsA:
			return "Miscellaneous Symbols-A";
		case MiscellaneousSymbolsB:
			return "Miscellaneous Symbols-B";
		case MiscellaneousTechnical:
			return "Miscellaneous Technical";
		case GeometricShapes:
			return "Geometric Shapes";
		case MiscellaneousSymbolsandArrows:
			return "Miscellaneous Symbols and Arrows";
		case Arrows:
			return "Arrows";
		case SupplementalArrows_A:
			return "Supplemental Arrows-A";
		case SupplementalArrows_B:
			return "Supplemental Arrows-B";
		case DiacriticalMarksforSymbols:
			return "Diacritical Marks for Symbols";
		}
		return "Not defined Block";
	}

	public static String createAllEnums() {
		StringBuilder sb = new StringBuilder();
		sb.append(createMathUnicode(Operators, 0x2200, 0x22ff));
		sb.append(createMathUnicode(OperatorsSupplement, 0x2a00, 0x2aff));
		// sb.append(createMathUnicode(AlphanumericSymbols, 0x1d400, 0x1d7ff));
		sb.append(createMathUnicode(LetterlikeSymbols, 0x2100, 0x214f));
		sb.append(createMathUnicode(MiscellaneousSymbolsA, 0x27c0, 0x27ef));
		sb.append(createMathUnicode(MiscellaneousSymbolsB, 0x2980, 0x29ff));
		sb.append(createMathUnicode(MiscellaneousTechnical, 0x2300, 0x23ff));
		sb.append(createMathUnicode(GeometricShapes, 0x25a0, 0x25ff));
		sb.append(createMathUnicode(MiscellaneousSymbolsandArrows, 0x2b00, 0x2bff));
		sb.append(createMathUnicode(Arrows, 0x2190, 0x21ff));
		sb.append(createMathUnicode(SupplementalArrows_A, 0x27f0, 0x27ff));
		sb.append(createMathUnicode(SupplementalArrows_B, 0x2900, 0x297f));
		sb.append(createMathUnicode(DiacriticalMarksforSymbols, 0x20d0, 0x20ff));
		sb.append("\n;");
		return sb.toString();
	}

	private static String createMathUnicode(int block, int startCode, int endCode) {

		StringBuilder sb = new StringBuilder();
		int length = endCode - startCode + 1;

		sb.append("\n\n// ---------- " + EnLatexMath.getTitle(block) + " ---\n\n");

		for (int i = 0, code = startCode; i < length; i++, code++) {
			String c = new Character((char) code).toString();
			sb.append("M_" + code + "("

					+ block + ", "

					+ "\"" + c + "\", "

					+ code + ", "

					+ "\"" + "M_" + code + "\", "

					+ "\"" + "latex" + "\""

					+ "),\n\n");
		}
		return sb.toString();
	}

	public String getToolTip() {
		return toolTip;
	}

	public int getCaretPosition() {
		return caretPosition;
	}

}
