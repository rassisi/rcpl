package org.eclipse.rcpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramin
 *
 */
public enum EnLatexMath implements IMath {

//	PLUS("+", null, null, 0,0),
//
//	MINUS("-", null, null, 0,0),
//
//	EQUAL("=", null, null, 0,0),
//
//	EXCLAMATION("!", null, null, 0,0),
//
//	SLASH("/", null, null, 0,0),
//
//	LEFT_ROUND_BRACKET("(", null, null, 0,0),
//
//	RIGHT_ROUND_BREAKET(")", null, null, 0,0),
//
//	LEFT_BRAKET("[", null, null, 0,0),
//
//	RIGHT_BRAKET("]", null, null, 0,0),
//
//	LESS_THEN("<", null, null, 0,0),
//
//	GREATER_THEN(">", null, null, 0,0),
//
//	VERTICAL_LINE("|", null, null, 0,0),
//
//	APOSTROPH("'", null, null, 0,0),
//
//	DOUBLE_DOT(":", null, null, 0,0),
//
//	ASTERIX("*", null, null, 0,0),
//

	beginArrayLeft(Structures, "al", "Array Left", 0, "\\begin{array}{l}\n\n\\end{array} ", 17, 0),

	beginArrayCenter(Structures, "ac", "Array Left", 0, "\\begin{array}{c}\n\n\\end{array} ", 17, 0),

	beginArrayRight(Structures, "ar", "Array Left", 0, "\\begin{array}{r}\n\n\\end{array} ", 17, 0),

	fraction(Structures, "/", "Fraction", 0, "\\frac{x}{y} ", 6, 1),

	sum(Structures, "∑", "Sum", 8721, "\\sum_{\\substack{0<i<m  0<j<n }} P(i,j)", 20, 1),

	sqrt(Structures, "√", "Squareroot", 8730, "\\sqrt{x}", 6, 1),

	integral(Structures, "∫", "", 8747, "\\int_a^b", 5, 1),

	doubleIntegral(Structures, "∬", "", 8748, "\\iint_a^b", 6, 1),

	tripleIntegral(Structures, "∭", "", 8749, "\\iiint_a^b", 7, 1),

	newLine(Structures, "¶", null, 186, "\\\\", 0, 0),

	// ---------- Mathematical Operators ---

	M_8704(Operators, "∀", null, 8704, "∀", 0, 0),

	M_8705(Operators, "∁", null, 8705, "∁", 0, 0),

	M_8706(Operators, "∂", null, 8706, "∂", 0, 0),

	M_8707(Operators, "∃", null, 8707, "∃", 0, 0),

	M_8708(Operators, "∄", null, 8708, "∄", 0, 0),

	M_8709(Operators, "∅", null, 8709, "∅", 0, 0),

	M_8710(Operators, "∆", null, 8710, "∆", 0, 0),

	M_8711(Operators, "∇", null, 8711, "∇", 0, 0),

	M_8712(Operators, "∈", null, 8712, null, 0, 0),

	M_8713(Operators, "∉", null, 8713, null, 0, 0),

	M_8714(Operators, "∊", null, 8714, null, 0, 0),

	M_8715(Operators, "∋", null, 8715, null, 0, 0),

	M_8716(Operators, "∌", null, 8716, null, 0, 0),

	M_8717(Operators, "∍", null, 8717, null, 0, 0),

	M_8718(Operators, "∎", null, 8718, null, 0, 0),

	M_8719(Operators, "∏", null, 8719, null, 0, 0),

	M_8720(Operators, "∐", null, 8720, null, 0, 0),

	M_8721(Operators, "∑", null, 8721, "\\sum_{\\substack{\n   0<i<m\n  0<j<n\n }}\n P(i,j)", 0, 0),

	M_8722(Operators, "−", null, 8722, null, 0, 0),

	M_8723(Operators, "∓", null, 8723, null, 0, 0),

	M_8724(Operators, "∔", null, 8724, null, 0, 0),

	M_8725(Operators, "∕", null, 8725, null, 0, 0),

	M_8726(Operators, "∖", null, 8726, null, 0, 0),

	M_8727(Operators, "∗", null, 8727, null, 0, 0),

	M_8728(Operators, "∘", null, 8728, null, 0, 0),

	M_8729(Operators, "∙", null, 8729, null, 0, 0),

	SQRT(Operators, "√", "Squareroot", 8730, "\\sqrt{x}", 6, 0),

	M_8731(Operators, "∛", null, 8731, null, 0, 0),

	M_8732(Operators, "∜", null, 8732, null, 0, 0),

	M_8733(Operators, "∝", null, 8733, null, 0, 0),

	M_8734(Operators, "∞", null, 8734, "\\infty", 0, 0),

	M_8735(Operators, "∟", null, 8735, null, 0, 0),

	M_8736(Operators, "∠", null, 8736, null, 0, 0),

	M_8737(Operators, "∡", null, 8737, null, 0, 0),

	M_8738(Operators, "∢", null, 8738, null, 0, 0),

	M_8739(Operators, "∣", null, 8739, null, 0, 0),

	M_8740(Operators, "∤", null, 8740, null, 0, 0),

	M_8741(Operators, "∥", null, 8741, null, 0, 0),

	M_8742(Operators, "∦", null, 8742, null, 0, 0),

	M_8743(Operators, "∧", null, 8743, "M_8743", 0, 0),

	M_8744(Operators, "∨", null, 8744, "M_8744", 0, 0),

	M_8745(Operators, "∩", null, 8745, "M_8745", 0, 0),

	M_8746(Operators, "∪", null, 8746, "M_8746", 0, 0),

	M_8747(Operators, "∫", null, 8747, "\\int_a^\\b", 0, 0),

	M_8748(Operators, "∬", null, 8748, "\\iint_a^\\b", 0, 0),

	M_8749(Operators, "∭", null, 8749, "\\iiint_a^\\b", 0, 0),

	M_8750(Operators, "∮", null, 8750, "M_8750", 0, 0),

	M_8751(Operators, "∯", null, 8751, "M_8751", 0, 0),

	M_8752(Operators, "∰", null, 8752, "M_8752", 0, 0),

	M_8753(Operators, "∱", null, 8753, "M_8753", 0, 0),

	M_8754(Operators, "∲", null, 8754, "M_8754", 0, 0),

	M_8755(Operators, "∳", null, 8755, "M_8755", 0, 0),

	M_8756(Operators, "∴", null, 8756, "M_8756", 0, 0),

	M_8757(Operators, "∵", null, 8757, "M_8757", 0, 0),

	M_8758(Operators, "∶", null, 8758, "M_8758", 0, 0),

	M_8759(Operators, "∷", null, 8759, "M_8759", 0, 0),

	M_8760(Operators, "∸", null, 8760, "M_8760", 0, 0),

	M_8761(Operators, "∹", null, 8761, "M_8761", 0, 0),

	M_8762(Operators, "∺", null, 8762, "M_8762", 0, 0),

	M_8763(Operators, "∻", null, 8763, "M_8763", 0, 0),

	M_8764(Operators, "∼", null, 8764, "M_8764", 0, 0),

	M_8765(Operators, "∽", null, 8765, "M_8765", 0, 0),

	M_8766(Operators, "∾", null, 8766, "M_8766", 0, 0),

	M_8767(Operators, "∿", null, 8767, "M_8767", 0, 0),

	M_8768(Operators, "≀", null, 8768, "M_8768", 0, 0),

	M_8769(Operators, "≁", null, 8769, "M_8769", 0, 0),

	M_8770(Operators, "≂", null, 8770, "M_8770", 0, 0),

	M_8771(Operators, "≃", null, 8771, "M_8771", 0, 0),

	M_8772(Operators, "≄", null, 8772, "M_8772", 0, 0),

	M_8773(Operators, "≅", null, 8773, "M_8773", 0, 0),

	M_8774(Operators, "≆", null, 8774, "M_8774", 0, 0),

	M_8775(Operators, "≇", null, 8775, "M_8775", 0, 0),

	M_8776(Operators, "≈", null, 8776, "M_8776", 0, 0),

	M_8777(Operators, "≉", null, 8777, "M_8777", 0, 0),

	M_8778(Operators, "≊", null, 8778, "M_8778", 0, 0),

	M_8779(Operators, "≋", null, 8779, "M_8779", 0, 0),

	M_8780(Operators, "≌", null, 8780, "M_8780", 0, 0),

	M_8781(Operators, "≍", null, 8781, "M_8781", 0, 0),

	M_8782(Operators, "≎", null, 8782, "M_8782", 0, 0),

	M_8783(Operators, "≏", null, 8783, "M_8783", 0, 0),

	M_8784(Operators, "≐", null, 8784, "M_8784", 0, 0),

	M_8785(Operators, "≑", null, 8785, "M_8785", 0, 0),

	M_8786(Operators, "≒", null, 8786, "M_8786", 0, 0),

	M_8787(Operators, "≓", null, 8787, "M_8787", 0, 0),

	M_8788(Operators, "≔", null, 8788, "M_8788", 0, 0),

	M_8789(Operators, "≕", null, 8789, "M_8789", 0, 0),

	M_8790(Operators, "≖", null, 8790, "M_8790", 0, 0),

	M_8791(Operators, "≗", null, 8791, "M_8791", 0, 0),

	M_8792(Operators, "≘", null, 8792, "M_8792", 0, 0),

	M_8793(Operators, "≙", null, 8793, "M_8793", 0, 0),

	M_8794(Operators, "≚", null, 8794, "M_8794", 0, 0),

	M_8795(Operators, "≛", null, 8795, "M_8795", 0, 0),

	M_8796(Operators, "≜", null, 8796, "M_8796", 0, 0),

	M_8797(Operators, "≝", null, 8797, "M_8797", 0, 0),

	M_8798(Operators, "≞", null, 8798, "M_8798", 0, 0),

	M_8799(Operators, "≟", null, 8799, "M_8799", 0, 0),

	M_8800(Operators, "≠", null, 8800, "M_8800", 0, 0),

	M_8801(Operators, "≡", null, 8801, "M_8801", 0, 0),

	M_8802(Operators, "≢", null, 8802, "M_8802", 0, 0),

	M_8803(Operators, "≣", null, 8803, "M_8803", 0, 0),

	M_8804(Operators, "≤", null, 8804, "M_8804", 0, 0),

	M_8805(Operators, "≥", null, 8805, "M_8805", 0, 0),

	M_8806(Operators, "≦", null, 8806, "M_8806", 0, 0),

	M_8807(Operators, "≧", null, 8807, "M_8807", 0, 0),

	M_8808(Operators, "≨", null, 8808, "M_8808", 0, 0),

	M_8809(Operators, "≩", null, 8809, "M_8809", 0, 0),

	M_8810(Operators, "≪", null, 8810, "M_8810", 0, 0),

	M_8811(Operators, "≫", null, 8811, "M_8811", 0, 0),

	M_8812(Operators, "≬", null, 8812, "M_8812", 0, 0),

	M_8813(Operators, "≭", null, 8813, "M_8813", 0, 0),

	M_8814(Operators, "≮", null, 8814, "M_8814", 0, 0),

	M_8815(Operators, "≯", null, 8815, "M_8815", 0, 0),

	M_8816(Operators, "≰", null, 8816, "M_8816", 0, 0),

	M_8817(Operators, "≱", null, 8817, "M_8817", 0, 0),

	M_8818(Operators, "≲", null, 8818, "M_8818", 0, 0),

	M_8819(Operators, "≳", null, 8819, "M_8819", 0, 0),

	M_8820(Operators, "≴", null, 8820, "M_8820", 0, 0),

	M_8821(Operators, "≵", null, 8821, "M_8821", 0, 0),

	M_8822(Operators, "≶", null, 8822, "M_8822", 0, 0),

	M_8823(Operators, "≷", null, 8823, "M_8823", 0, 0),

	M_8824(Operators, "≸", null, 8824, "M_8824", 0, 0),

	M_8825(Operators, "≹", null, 8825, "M_8825", 0, 0),

	M_8826(Operators, "≺", null, 8826, "M_8826", 0, 0),

	M_8827(Operators, "≻", null, 8827, "M_8827", 0, 0),

	M_8828(Operators, "≼", null, 8828, "M_8828", 0, 0),

	M_8829(Operators, "≽", null, 8829, "M_8829", 0, 0),

	M_8830(Operators, "≾", null, 8830, "M_8830", 0, 0),

	M_8831(Operators, "≿", null, 8831, "M_8831", 0, 0),

	M_8832(Operators, "⊀", null, 8832, "M_8832", 0, 0),

	M_8833(Operators, "⊁", null, 8833, "M_8833", 0, 0),

	M_8834(Operators, "⊂", null, 8834, "M_8834", 0, 0),

	M_8835(Operators, "⊃", null, 8835, "M_8835", 0, 0),

	M_8836(Operators, "⊄", null, 8836, "M_8836", 0, 0),

	M_8837(Operators, "⊅", null, 8837, "M_8837", 0, 0),

	M_8838(Operators, "⊆", null, 8838, "M_8838", 0, 0),

	M_8839(Operators, "⊇", null, 8839, "M_8839", 0, 0),

	M_8840(Operators, "⊈", null, 8840, "M_8840", 0, 0),

	M_8841(Operators, "⊉", null, 8841, "M_8841", 0, 0),

	M_8842(Operators, "⊊", null, 8842, "M_8842", 0, 0),

	M_8843(Operators, "⊋", null, 8843, "M_8843", 0, 0),

	M_8844(Operators, "⊌", null, 8844, "M_8844", 0, 0),

	M_8845(Operators, "⊍", null, 8845, "M_8845", 0, 0),

	M_8846(Operators, "⊎", null, 8846, "M_8846", 0, 0),

	M_8847(Operators, "⊏", null, 8847, "M_8847", 0, 0),

	M_8848(Operators, "⊐", null, 8848, "M_8848", 0, 0),

	M_8849(Operators, "⊑", null, 8849, "M_8849", 0, 0),

	M_8850(Operators, "⊒", null, 8850, "M_8850", 0, 0),

	M_8851(Operators, "⊓", null, 8851, "M_8851", 0, 0),

	M_8852(Operators, "⊔", null, 8852, "M_8852", 0, 0),

	M_8853(Operators, "⊕", null, 8853, "M_8853", 0, 0),

	M_8854(Operators, "⊖", null, 8854, "M_8854", 0, 0),

	M_8855(Operators, "⊗", null, 8855, "M_8855", 0, 0),

	M_8856(Operators, "⊘", null, 8856, "M_8856", 0, 0),

	M_8857(Operators, "⊙", null, 8857, "M_8857", 0, 0),

	M_8858(Operators, "⊚", null, 8858, "M_8858", 0, 0),

	M_8859(Operators, "⊛", null, 8859, "M_8859", 0, 0),

	M_8860(Operators, "⊜", null, 8860, "M_8860", 0, 0),

	M_8861(Operators, "⊝", null, 8861, "M_8861", 0, 0),

	M_8862(Operators, "⊞", null, 8862, "M_8862", 0, 0),

	M_8863(Operators, "⊟", null, 8863, "M_8863", 0, 0),

	M_8864(Operators, "⊠", null, 8864, "M_8864", 0, 0),

	M_8865(Operators, "⊡", null, 8865, "M_8865", 0, 0),

	M_8866(Operators, "⊢", null, 8866, "M_8866", 0, 0),

	M_8867(Operators, "⊣", null, 8867, "M_8867", 0, 0),

	M_8868(Operators, "⊤", null, 8868, "M_8868", 0, 0),

	M_8869(Operators, "⊥", null, 8869, "M_8869", 0, 0),

	M_8870(Operators, "⊦", null, 8870, "M_8870", 0, 0),

	M_8871(Operators, "⊧", null, 8871, "M_8871", 0, 0),

	M_8872(Operators, "⊨", null, 8872, "M_8872", 0, 0),

	M_8873(Operators, "⊩", null, 8873, "M_8873", 0, 0),

	M_8874(Operators, "⊪", null, 8874, "M_8874", 0, 0),

	M_8875(Operators, "⊫", null, 8875, "M_8875", 0, 0),

	M_8876(Operators, "⊬", null, 8876, "M_8876", 0, 0),

	M_8877(Operators, "⊭", null, 8877, "M_8877", 0, 0),

	M_8878(Operators, "⊮", null, 8878, "M_8878", 0, 0),

	M_8879(Operators, "⊯", null, 8879, "M_8879", 0, 0),

	M_8880(Operators, "⊰", null, 8880, "M_8880", 0, 0),

	M_8881(Operators, "⊱", null, 8881, "M_8881", 0, 0),

	M_8882(Operators, "⊲", null, 8882, "M_8882", 0, 0),

	M_8883(Operators, "⊳", null, 8883, "M_8883", 0, 0),

	M_8884(Operators, "⊴", null, 8884, "M_8884", 0, 0),

	M_8885(Operators, "⊵", null, 8885, "M_8885", 0, 0),

	M_8886(Operators, "⊶", null, 8886, "M_8886", 0, 0),

	M_8887(Operators, "⊷", null, 8887, "M_8887", 0, 0),

	M_8888(Operators, "⊸", null, 8888, "M_8888", 0, 0),

	M_8889(Operators, "⊹", null, 8889, "M_8889", 0, 0),

	M_8890(Operators, "⊺", null, 8890, "M_8890", 0, 0),

	M_8891(Operators, "⊻", null, 8891, "M_8891", 0, 0),

	M_8892(Operators, "⊼", null, 8892, "M_8892", 0, 0),

	M_8893(Operators, "⊽", null, 8893, "M_8893", 0, 0),

	M_8894(Operators, "⊾", null, 8894, "M_8894", 0, 0),

	M_8895(Operators, "⊿", null, 8895, "M_8895", 0, 0),

	M_8896(Operators, "⋀", null, 8896, "M_8896", 0, 0),

	M_8897(Operators, "⋁", null, 8897, "M_8897", 0, 0),

	M_8898(Operators, "⋂", null, 8898, "M_8898", 0, 0),

	M_8899(Operators, "⋃", null, 8899, "M_8899", 0, 0),

	M_8900(Operators, "⋄", null, 8900, "M_8900", 0, 0),

	M_8901(Operators, "⋅", null, 8901, "M_8901", 0, 0),

	M_8902(Operators, "⋆", null, 8902, "M_8902", 0, 0),

	M_8903(Operators, "⋇", null, 8903, "M_8903", 0, 0),

	M_8904(Operators, "⋈", null, 8904, "M_8904", 0, 0),

	M_8905(Operators, "⋉", null, 8905, "M_8905", 0, 0),

	M_8906(Operators, "⋊", null, 8906, "M_8906", 0, 0),

	M_8907(Operators, "⋋", null, 8907, "M_8907", 0, 0),

	M_8908(Operators, "⋌", null, 8908, "M_8908", 0, 0),

	M_8909(Operators, "⋍", null, 8909, "M_8909", 0, 0),

	M_8910(Operators, "⋎", null, 8910, "M_8910", 0, 0),

	M_8911(Operators, "⋏", null, 8911, "M_8911", 0, 0),

	M_8912(Operators, "⋐", null, 8912, "M_8912", 0, 0),

	M_8913(Operators, "⋑", null, 8913, "M_8913", 0, 0),

	M_8914(Operators, "⋒", null, 8914, "M_8914", 0, 0),

	M_8915(Operators, "⋓", null, 8915, "M_8915", 0, 0),

	M_8916(Operators, "⋔", null, 8916, "M_8916", 0, 0),

	M_8917(Operators, "⋕", null, 8917, "M_8917", 0, 0),

	M_8918(Operators, "⋖", null, 8918, "M_8918", 0, 0),

	M_8919(Operators, "⋗", null, 8919, "M_8919", 0, 0),

	M_8920(Operators, "⋘", null, 8920, "M_8920", 0, 0),

	M_8921(Operators, "⋙", null, 8921, "M_8921", 0, 0),

	M_8922(Operators, "⋚", null, 8922, "M_8922", 0, 0),

	M_8923(Operators, "⋛", null, 8923, "M_8923", 0, 0),

	M_8924(Operators, "⋜", null, 8924, "M_8924", 0, 0),

	M_8925(Operators, "⋝", null, 8925, "M_8925", 0, 0),

	M_8926(Operators, "⋞", null, 8926, "M_8926", 0, 0),

	M_8927(Operators, "⋟", null, 8927, "M_8927", 0, 0),

	M_8928(Operators, "⋠", null, 8928, "M_8928", 0, 0),

	M_8929(Operators, "⋡", null, 8929, "M_8929", 0, 0),

	M_8930(Operators, "⋢", null, 8930, "M_8930", 0, 0),

	M_8931(Operators, "⋣", null, 8931, "M_8931", 0, 0),

	M_8932(Operators, "⋤", null, 8932, "M_8932", 0, 0),

	M_8933(Operators, "⋥", null, 8933, "M_8933", 0, 0),

	M_8934(Operators, "⋦", null, 8934, "M_8934", 0, 0),

	M_8935(Operators, "⋧", null, 8935, "M_8935", 0, 0),

	M_8936(Operators, "⋨", null, 8936, "M_8936", 0, 0),

	M_8937(Operators, "⋩", null, 8937, "M_8937", 0, 0),

	M_8938(Operators, "⋪", null, 8938, "M_8938", 0, 0),

	M_8939(Operators, "⋫", null, 8939, "M_8939", 0, 0),

	M_8940(Operators, "⋬", null, 8940, "M_8940", 0, 0),

	M_8941(Operators, "⋭", null, 8941, "M_8941", 0, 0),

	M_8942(Operators, "⋮", null, 8942, "M_8942", 0, 0),

	M_8943(Operators, "⋯", null, 8943, "M_8943", 0, 0),

	M_8944(Operators, "⋰", null, 8944, "M_8944", 0, 0),

	M_8945(Operators, "⋱", null, 8945, "M_8945", 0, 0),

	M_8946(Operators, "⋲", null, 8946, "M_8946", 0, 0),

	M_8947(Operators, "⋳", null, 8947, "M_8947", 0, 0),

	M_8948(Operators, "⋴", null, 8948, "M_8948", 0, 0),

	M_8949(Operators, "⋵", null, 8949, "M_8949", 0, 0),

	M_8950(Operators, "⋶", null, 8950, "M_8950", 0, 0),

	M_8951(Operators, "⋷", null, 8951, "M_8951", 0, 0),

	M_8952(Operators, "⋸", null, 8952, "M_8952", 0, 0),

	M_8953(Operators, "⋹", null, 8953, "M_8953", 0, 0),

	M_8954(Operators, "⋺", null, 8954, "M_8954", 0, 0),

	M_8955(Operators, "⋻", null, 8955, "M_8955", 0, 0),

	M_8956(Operators, "⋼", null, 8956, "M_8956", 0, 0),

	M_8957(Operators, "⋽", null, 8957, "M_8957", 0, 0),

	M_8958(Operators, "⋾", null, 8958, "M_8958", 0, 0),

	M_8959(Operators, "⋿", null, 8959, "M_8959", 0, 0),

	// ---------- mathematical Operators Supplement ---

	M_10752(OperatorsSupplement, "⨀", null, 10752, "M_10752", 0, 0),

	M_10753(OperatorsSupplement, "⨁", null, 10753, "M_10753", 0, 0),

	M_10754(OperatorsSupplement, "⨂", null, 10754, "M_10754", 0, 0),

	M_10755(OperatorsSupplement, "⨃", null, 10755, "M_10755", 0, 0),

	M_10756(OperatorsSupplement, "⨄", null, 10756, "M_10756", 0, 0),

	M_10757(OperatorsSupplement, "⨅", null, 10757, "M_10757", 0, 0),

	M_10758(OperatorsSupplement, "⨆", null, 10758, "M_10758", 0, 0),

	M_10759(OperatorsSupplement, "⨇", null, 10759, "M_10759", 0, 0),

	M_10760(OperatorsSupplement, "⨈", null, 10760, "M_10760", 0, 0),

	M_10761(OperatorsSupplement, "⨉", null, 10761, "M_10761", 0, 0),

	M_10762(OperatorsSupplement, "⨊", null, 10762, "M_10762", 0, 0),

	M_10763(OperatorsSupplement, "⨋", null, 10763, "M_10763", 0, 0),

	M_10764(OperatorsSupplement, "⨌", null, 10764, "M_10764", 0, 0),

	M_10765(OperatorsSupplement, "⨍", null, 10765, "M_10765", 0, 0),

	M_10766(OperatorsSupplement, "⨎", null, 10766, "M_10766", 0, 0),

	M_10767(OperatorsSupplement, "⨏", null, 10767, "M_10767", 0, 0),

	M_10768(OperatorsSupplement, "⨐", null, 10768, "M_10768", 0, 0),

	M_10769(OperatorsSupplement, "⨑", null, 10769, "M_10769", 0, 0),

	M_10770(OperatorsSupplement, "⨒", null, 10770, "M_10770", 0, 0),

	M_10771(OperatorsSupplement, "⨓", null, 10771, "M_10771", 0, 0),

	M_10772(OperatorsSupplement, "⨔", null, 10772, "M_10772", 0, 0),

	M_10773(OperatorsSupplement, "⨕", null, 10773, "M_10773", 0, 0),

	M_10774(OperatorsSupplement, "⨖", null, 10774, "M_10774", 0, 0),

	M_10775(OperatorsSupplement, "⨗", null, 10775, "M_10775", 0, 0),

	M_10776(OperatorsSupplement, "⨘", null, 10776, "M_10776", 0, 0),

	M_10777(OperatorsSupplement, "⨙", null, 10777, "M_10777", 0, 0),

	M_10778(OperatorsSupplement, "⨚", null, 10778, "M_10778", 0, 0),

	M_10779(OperatorsSupplement, "⨛", null, 10779, "M_10779", 0, 0),

	M_10780(OperatorsSupplement, "⨜", null, 10780, "M_10780", 0, 0),

	M_10781(OperatorsSupplement, "⨝", null, 10781, "M_10781", 0, 0),

	M_10782(OperatorsSupplement, "⨞", null, 10782, "M_10782", 0, 0),

	M_10783(OperatorsSupplement, "⨟", null, 10783, "M_10783", 0, 0),

	M_10784(OperatorsSupplement, "⨠", null, 10784, "M_10784", 0, 0),

	M_10785(OperatorsSupplement, "⨡", null, 10785, "M_10785", 0, 0),

	M_10786(OperatorsSupplement, "⨢", null, 10786, "M_10786", 0, 0),

	M_10787(OperatorsSupplement, "⨣", null, 10787, "M_10787", 0, 0),

	M_10788(OperatorsSupplement, "⨤", null, 10788, "M_10788", 0, 0),

	M_10789(OperatorsSupplement, "⨥", null, 10789, "M_10789", 0, 0),

	M_10790(OperatorsSupplement, "⨦", null, 10790, "M_10790", 0, 0),

	M_10791(OperatorsSupplement, "⨧", null, 10791, "M_10791", 0, 0),

	M_10792(OperatorsSupplement, "⨨", null, 10792, "M_10792", 0, 0),

	M_10793(OperatorsSupplement, "⨩", null, 10793, "M_10793", 0, 0),

	M_10794(OperatorsSupplement, "⨪", null, 10794, "M_10794", 0, 0),

	M_10795(OperatorsSupplement, "⨫", null, 10795, "M_10795", 0, 0),

	M_10796(OperatorsSupplement, "⨬", null, 10796, "M_10796", 0, 0),

	M_10797(OperatorsSupplement, "⨭", null, 10797, "M_10797", 0, 0),

	M_10798(OperatorsSupplement, "⨮", null, 10798, "M_10798", 0, 0),

	M_10799(OperatorsSupplement, "⨯", null, 10799, "M_10799", 0, 0),

	M_10800(OperatorsSupplement, "⨰", null, 10800, "M_10800", 0, 0),

	M_10801(OperatorsSupplement, "⨱", null, 10801, "M_10801", 0, 0),

	M_10802(OperatorsSupplement, "⨲", null, 10802, "M_10802", 0, 0),

	M_10803(OperatorsSupplement, "⨳", null, 10803, "M_10803", 0, 0),

	M_10804(OperatorsSupplement, "⨴", null, 10804, "M_10804", 0, 0),

	M_10805(OperatorsSupplement, "⨵", null, 10805, "M_10805", 0, 0),

	M_10806(OperatorsSupplement, "⨶", null, 10806, "M_10806", 0, 0),

	M_10807(OperatorsSupplement, "⨷", null, 10807, "M_10807", 0, 0),

	M_10808(OperatorsSupplement, "⨸", null, 10808, "M_10808", 0, 0),

	M_10809(OperatorsSupplement, "⨹", null, 10809, "M_10809", 0, 0),

	M_10810(OperatorsSupplement, "⨺", null, 10810, "M_10810", 0, 0),

	M_10811(OperatorsSupplement, "⨻", null, 10811, "M_10811", 0, 0),

	M_10812(OperatorsSupplement, "⨼", null, 10812, "M_10812", 0, 0),

	M_10813(OperatorsSupplement, "⨽", null, 10813, "M_10813", 0, 0),

	M_10814(OperatorsSupplement, "⨾", null, 10814, "M_10814", 0, 0),

	M_10815(OperatorsSupplement, "⨿", null, 10815, "M_10815", 0, 0),

	M_10816(OperatorsSupplement, "⩀", null, 10816, "M_10816", 0, 0),

	M_10817(OperatorsSupplement, "⩁", null, 10817, "M_10817", 0, 0),

	M_10818(OperatorsSupplement, "⩂", null, 10818, "M_10818", 0, 0),

	M_10819(OperatorsSupplement, "⩃", null, 10819, "M_10819", 0, 0),

	M_10820(OperatorsSupplement, "⩄", null, 10820, "M_10820", 0, 0),

	M_10821(OperatorsSupplement, "⩅", null, 10821, "M_10821", 0, 0),

	M_10822(OperatorsSupplement, "⩆", null, 10822, "M_10822", 0, 0),

	M_10823(OperatorsSupplement, "⩇", null, 10823, "M_10823", 0, 0),

	M_10824(OperatorsSupplement, "⩈", null, 10824, "M_10824", 0, 0),

	M_10825(OperatorsSupplement, "⩉", null, 10825, "M_10825", 0, 0),

	M_10826(OperatorsSupplement, "⩊", null, 10826, "M_10826", 0, 0),

	M_10827(OperatorsSupplement, "⩋", null, 10827, "M_10827", 0, 0),

	M_10828(OperatorsSupplement, "⩌", null, 10828, "M_10828", 0, 0),

	M_10829(OperatorsSupplement, "⩍", null, 10829, "M_10829", 0, 0),

	M_10830(OperatorsSupplement, "⩎", null, 10830, "M_10830", 0, 0),

	M_10831(OperatorsSupplement, "⩏", null, 10831, "M_10831", 0, 0),

	M_10832(OperatorsSupplement, "⩐", null, 10832, "M_10832", 0, 0),

	M_10833(OperatorsSupplement, "⩑", null, 10833, "M_10833", 0, 0),

	M_10834(OperatorsSupplement, "⩒", null, 10834, "M_10834", 0, 0),

	M_10835(OperatorsSupplement, "⩓", null, 10835, "M_10835", 0, 0),

	M_10836(OperatorsSupplement, "⩔", null, 10836, "M_10836", 0, 0),

	M_10837(OperatorsSupplement, "⩕", null, 10837, "M_10837", 0, 0),

	M_10838(OperatorsSupplement, "⩖", null, 10838, "M_10838", 0, 0),

	M_10839(OperatorsSupplement, "⩗", null, 10839, "M_10839", 0, 0),

	M_10840(OperatorsSupplement, "⩘", null, 10840, "M_10840", 0, 0),

	M_10841(OperatorsSupplement, "⩙", null, 10841, "M_10841", 0, 0),

	M_10842(OperatorsSupplement, "⩚", null, 10842, "M_10842", 0, 0),

	M_10843(OperatorsSupplement, "⩛", null, 10843, "M_10843", 0, 0),

	M_10844(OperatorsSupplement, "⩜", null, 10844, "M_10844", 0, 0),

	M_10845(OperatorsSupplement, "⩝", null, 10845, "M_10845", 0, 0),

	M_10846(OperatorsSupplement, "⩞", null, 10846, "M_10846", 0, 0),

	M_10847(OperatorsSupplement, "⩟", null, 10847, "M_10847", 0, 0),

	M_10848(OperatorsSupplement, "⩠", null, 10848, "M_10848", 0, 0),

	M_10849(OperatorsSupplement, "⩡", null, 10849, "M_10849", 0, 0),

	M_10850(OperatorsSupplement, "⩢", null, 10850, "M_10850", 0, 0),

	M_10851(OperatorsSupplement, "⩣", null, 10851, "M_10851", 0, 0),

	M_10852(OperatorsSupplement, "⩤", null, 10852, "M_10852", 0, 0),

	M_10853(OperatorsSupplement, "⩥", null, 10853, "M_10853", 0, 0),

	M_10854(OperatorsSupplement, "⩦", null, 10854, "M_10854", 0, 0),

	M_10855(OperatorsSupplement, "⩧", null, 10855, "M_10855", 0, 0),

	M_10856(OperatorsSupplement, "⩨", null, 10856, "M_10856", 0, 0),

	M_10857(OperatorsSupplement, "⩩", null, 10857, "M_10857", 0, 0),

	M_10858(OperatorsSupplement, "⩪", null, 10858, "M_10858", 0, 0),

	M_10859(OperatorsSupplement, "⩫", null, 10859, "M_10859", 0, 0),

	M_10860(OperatorsSupplement, "⩬", null, 10860, "M_10860", 0, 0),

	M_10861(OperatorsSupplement, "⩭", null, 10861, "M_10861", 0, 0),

	M_10862(OperatorsSupplement, "⩮", null, 10862, "M_10862", 0, 0),

	M_10863(OperatorsSupplement, "⩯", null, 10863, "M_10863", 0, 0),

	M_10864(OperatorsSupplement, "⩰", null, 10864, "M_10864", 0, 0),

	M_10865(OperatorsSupplement, "⩱", null, 10865, "M_10865", 0, 0),

	M_10866(OperatorsSupplement, "⩲", null, 10866, "M_10866", 0, 0),

	M_10867(OperatorsSupplement, "⩳", null, 10867, "M_10867", 0, 0),

	M_10868(OperatorsSupplement, "⩴", null, 10868, "M_10868", 0, 0),

	M_10869(OperatorsSupplement, "⩵", null, 10869, "M_10869", 0, 0),

	M_10870(OperatorsSupplement, "⩶", null, 10870, "M_10870", 0, 0),

	M_10871(OperatorsSupplement, "⩷", null, 10871, "M_10871", 0, 0),

	M_10872(OperatorsSupplement, "⩸", null, 10872, "M_10872", 0, 0),

	M_10873(OperatorsSupplement, "⩹", null, 10873, "M_10873", 0, 0),

	M_10874(OperatorsSupplement, "⩺", null, 10874, "M_10874", 0, 0),

	M_10875(OperatorsSupplement, "⩻", null, 10875, "M_10875", 0, 0),

	M_10876(OperatorsSupplement, "⩼", null, 10876, "M_10876", 0, 0),

	M_10877(OperatorsSupplement, "⩽", null, 10877, "M_10877", 0, 0),

	M_10878(OperatorsSupplement, "⩾", null, 10878, "M_10878", 0, 0),

	M_10879(OperatorsSupplement, "⩿", null, 10879, "M_10879", 0, 0),

	M_10880(OperatorsSupplement, "⪀", null, 10880, "M_10880", 0, 0),

	M_10881(OperatorsSupplement, "⪁", null, 10881, "M_10881", 0, 0),

	M_10882(OperatorsSupplement, "⪂", null, 10882, "M_10882", 0, 0),

	M_10883(OperatorsSupplement, "⪃", null, 10883, "M_10883", 0, 0),

	M_10884(OperatorsSupplement, "⪄", null, 10884, "M_10884", 0, 0),

	M_10885(OperatorsSupplement, "⪅", null, 10885, "M_10885", 0, 0),

	M_10886(OperatorsSupplement, "⪆", null, 10886, "M_10886", 0, 0),

	M_10887(OperatorsSupplement, "⪇", null, 10887, "M_10887", 0, 0),

	M_10888(OperatorsSupplement, "⪈", null, 10888, "M_10888", 0, 0),

	M_10889(OperatorsSupplement, "⪉", null, 10889, "M_10889", 0, 0),

	M_10890(OperatorsSupplement, "⪊", null, 10890, "M_10890", 0, 0),

	M_10891(OperatorsSupplement, "⪋", null, 10891, "M_10891", 0, 0),

	M_10892(OperatorsSupplement, "⪌", null, 10892, "M_10892", 0, 0),

	M_10893(OperatorsSupplement, "⪍", null, 10893, "M_10893", 0, 0),

	M_10894(OperatorsSupplement, "⪎", null, 10894, "M_10894", 0, 0),

	M_10895(OperatorsSupplement, "⪏", null, 10895, "M_10895", 0, 0),

	M_10896(OperatorsSupplement, "⪐", null, 10896, "M_10896", 0, 0),

	M_10897(OperatorsSupplement, "⪑", null, 10897, "M_10897", 0, 0),

	M_10898(OperatorsSupplement, "⪒", null, 10898, "M_10898", 0, 0),

	M_10899(OperatorsSupplement, "⪓", null, 10899, "M_10899", 0, 0),

	M_10900(OperatorsSupplement, "⪔", null, 10900, "M_10900", 0, 0),

	M_10901(OperatorsSupplement, "⪕", null, 10901, "M_10901", 0, 0),

	M_10902(OperatorsSupplement, "⪖", null, 10902, "M_10902", 0, 0),

	M_10903(OperatorsSupplement, "⪗", null, 10903, "M_10903", 0, 0),

	M_10904(OperatorsSupplement, "⪘", null, 10904, "M_10904", 0, 0),

	M_10905(OperatorsSupplement, "⪙", null, 10905, "M_10905", 0, 0),

	M_10906(OperatorsSupplement, "⪚", null, 10906, "M_10906", 0, 0),

	M_10907(OperatorsSupplement, "⪛", null, 10907, "M_10907", 0, 0),

	M_10908(OperatorsSupplement, "⪜", null, 10908, "M_10908", 0, 0),

	M_10909(OperatorsSupplement, "⪝", null, 10909, "M_10909", 0, 0),

	M_10910(OperatorsSupplement, "⪞", null, 10910, "M_10910", 0, 0),

	M_10911(OperatorsSupplement, "⪟", null, 10911, "M_10911", 0, 0),

	M_10912(OperatorsSupplement, "⪠", null, 10912, "M_10912", 0, 0),

	M_10913(OperatorsSupplement, "⪡", null, 10913, "M_10913", 0, 0),

	M_10914(OperatorsSupplement, "⪢", null, 10914, "M_10914", 0, 0),

	M_10915(OperatorsSupplement, "⪣", null, 10915, "M_10915", 0, 0),

	M_10916(OperatorsSupplement, "⪤", null, 10916, "M_10916", 0, 0),

	M_10917(OperatorsSupplement, "⪥", null, 10917, "M_10917", 0, 0),

	M_10918(OperatorsSupplement, "⪦", null, 10918, "M_10918", 0, 0),

	M_10919(OperatorsSupplement, "⪧", null, 10919, "M_10919", 0, 0),

	M_10920(OperatorsSupplement, "⪨", null, 10920, "M_10920", 0, 0),

	M_10921(OperatorsSupplement, "⪩", null, 10921, "M_10921", 0, 0),

	M_10922(OperatorsSupplement, "⪪", null, 10922, "M_10922", 0, 0),

	M_10923(OperatorsSupplement, "⪫", null, 10923, "M_10923", 0, 0),

	M_10924(OperatorsSupplement, "⪬", null, 10924, "M_10924", 0, 0),

	M_10925(OperatorsSupplement, "⪭", null, 10925, "M_10925", 0, 0),

	M_10926(OperatorsSupplement, "⪮", null, 10926, "M_10926", 0, 0),

	M_10927(OperatorsSupplement, "⪯", null, 10927, "M_10927", 0, 0),

	M_10928(OperatorsSupplement, "⪰", null, 10928, "M_10928", 0, 0),

	M_10929(OperatorsSupplement, "⪱", null, 10929, "M_10929", 0, 0),

	M_10930(OperatorsSupplement, "⪲", null, 10930, "M_10930", 0, 0),

	M_10931(OperatorsSupplement, "⪳", null, 10931, "M_10931", 0, 0),

	M_10932(OperatorsSupplement, "⪴", null, 10932, "M_10932", 0, 0),

	M_10933(OperatorsSupplement, "⪵", null, 10933, "M_10933", 0, 0),

	M_10934(OperatorsSupplement, "⪶", null, 10934, "M_10934", 0, 0),

	M_10935(OperatorsSupplement, "⪷", null, 10935, "M_10935", 0, 0),

	M_10936(OperatorsSupplement, "⪸", null, 10936, "M_10936", 0, 0),

	M_10937(OperatorsSupplement, "⪹", null, 10937, "M_10937", 0, 0),

	M_10938(OperatorsSupplement, "⪺", null, 10938, "M_10938", 0, 0),

	M_10939(OperatorsSupplement, "⪻", null, 10939, "M_10939", 0, 0),

	M_10940(OperatorsSupplement, "⪼", null, 10940, "M_10940", 0, 0),

	M_10941(OperatorsSupplement, "⪽", null, 10941, "M_10941", 0, 0),

	M_10942(OperatorsSupplement, "⪾", null, 10942, "M_10942", 0, 0),

	M_10943(OperatorsSupplement, "⪿", null, 10943, "M_10943", 0, 0),

	M_10944(OperatorsSupplement, "⫀", null, 10944, "M_10944", 0, 0),

	M_10945(OperatorsSupplement, "⫁", null, 10945, "M_10945", 0, 0),

	M_10946(OperatorsSupplement, "⫂", null, 10946, "M_10946", 0, 0),

	M_10947(OperatorsSupplement, "⫃", null, 10947, "M_10947", 0, 0),

	M_10948(OperatorsSupplement, "⫄", null, 10948, "M_10948", 0, 0),

	M_10949(OperatorsSupplement, "⫅", null, 10949, "M_10949", 0, 0),

	M_10950(OperatorsSupplement, "⫆", null, 10950, "M_10950", 0, 0),

	M_10951(OperatorsSupplement, "⫇", null, 10951, "M_10951", 0, 0),

	M_10952(OperatorsSupplement, "⫈", null, 10952, "M_10952", 0, 0),

	M_10953(OperatorsSupplement, "⫉", null, 10953, "M_10953", 0, 0),

	M_10954(OperatorsSupplement, "⫊", null, 10954, "M_10954", 0, 0),

	M_10955(OperatorsSupplement, "⫋", null, 10955, "M_10955", 0, 0),

	M_10956(OperatorsSupplement, "⫌", null, 10956, "M_10956", 0, 0),

	M_10957(OperatorsSupplement, "⫍", null, 10957, "M_10957", 0, 0),

	M_10958(OperatorsSupplement, "⫎", null, 10958, "M_10958", 0, 0),

	M_10959(OperatorsSupplement, "⫏", null, 10959, "M_10959", 0, 0),

	M_10960(OperatorsSupplement, "⫐", null, 10960, "M_10960", 0, 0),

	M_10961(OperatorsSupplement, "⫑", null, 10961, "M_10961", 0, 0),

	M_10962(OperatorsSupplement, "⫒", null, 10962, "M_10962", 0, 0),

	M_10963(OperatorsSupplement, "⫓", null, 10963, "M_10963", 0, 0),

	M_10964(OperatorsSupplement, "⫔", null, 10964, "M_10964", 0, 0),

	M_10965(OperatorsSupplement, "⫕", null, 10965, "M_10965", 0, 0),

	M_10966(OperatorsSupplement, "⫖", null, 10966, "M_10966", 0, 0),

	M_10967(OperatorsSupplement, "⫗", null, 10967, "M_10967", 0, 0),

	M_10968(OperatorsSupplement, "⫘", null, 10968, "M_10968", 0, 0),

	M_10969(OperatorsSupplement, "⫙", null, 10969, "M_10969", 0, 0),

	M_10970(OperatorsSupplement, "⫚", null, 10970, "M_10970", 0, 0),

	M_10971(OperatorsSupplement, "⫛", null, 10971, "M_10971", 0, 0),

	M_10972(OperatorsSupplement, "⫝̸", null, 10972, "M_10972", 0, 0),

	M_10973(OperatorsSupplement, "⫝", null, 10973, "M_10973", 0, 0),

	M_10974(OperatorsSupplement, "⫞", null, 10974, "M_10974", 0, 0),

	M_10975(OperatorsSupplement, "⫟", null, 10975, "M_10975", 0, 0),

	M_10976(OperatorsSupplement, "⫠", null, 10976, "M_10976", 0, 0),

	M_10977(OperatorsSupplement, "⫡", null, 10977, "M_10977", 0, 0),

	M_10978(OperatorsSupplement, "⫢", null, 10978, "M_10978", 0, 0),

	M_10979(OperatorsSupplement, "⫣", null, 10979, "M_10979", 0, 0),

	M_10980(OperatorsSupplement, "⫤", null, 10980, "M_10980", 0, 0),

	M_10981(OperatorsSupplement, "⫥", null, 10981, "M_10981", 0, 0),

	M_10982(OperatorsSupplement, "⫦", null, 10982, "M_10982", 0, 0),

	M_10983(OperatorsSupplement, "⫧", null, 10983, "M_10983", 0, 0),

	M_10984(OperatorsSupplement, "⫨", null, 10984, "M_10984", 0, 0),

	M_10985(OperatorsSupplement, "⫩", null, 10985, "M_10985", 0, 0),

	M_10986(OperatorsSupplement, "⫪", null, 10986, "M_10986", 0, 0),

	M_10987(OperatorsSupplement, "⫫", null, 10987, "M_10987", 0, 0),

	M_10988(OperatorsSupplement, "⫬", null, 10988, "M_10988", 0, 0),

	M_10989(OperatorsSupplement, "⫭", null, 10989, "M_10989", 0, 0),

	M_10990(OperatorsSupplement, "⫮", null, 10990, "M_10990", 0, 0),

	M_10991(OperatorsSupplement, "⫯", null, 10991, "M_10991", 0, 0),

	M_10992(OperatorsSupplement, "⫰", null, 10992, "M_10992", 0, 0),

	M_10993(OperatorsSupplement, "⫱", null, 10993, "M_10993", 0, 0),

	M_10994(OperatorsSupplement, "⫲", null, 10994, "M_10994", 0, 0),

	M_10995(OperatorsSupplement, "⫳", null, 10995, "M_10995", 0, 0),

	M_10996(OperatorsSupplement, "⫴", null, 10996, "M_10996", 0, 0),

	M_10997(OperatorsSupplement, "⫵", null, 10997, "M_10997", 0, 0),

	M_10998(OperatorsSupplement, "⫶", null, 10998, "M_10998", 0, 0),

	M_10999(OperatorsSupplement, "⫷", null, 10999, "M_10999", 0, 0),

	M_11000(OperatorsSupplement, "⫸", null, 11000, "M_11000", 0, 0),

	M_11001(OperatorsSupplement, "⫹", null, 11001, "M_11001", 0, 0),

	M_11002(OperatorsSupplement, "⫺", null, 11002, "M_11002", 0, 0),

	M_11003(OperatorsSupplement, "⫻", null, 11003, "M_11003", 0, 0),

	M_11004(OperatorsSupplement, "⫼", null, 11004, "M_11004", 0, 0),

	M_11005(OperatorsSupplement, "⫽", null, 11005, "M_11005", 0, 0),

	M_11006(OperatorsSupplement, "⫾", null, 11006, "M_11006", 0, 0),

	M_11007(OperatorsSupplement, "⫿", null, 11007, "M_11007", 0, 0),

	// ---------- empty Block

	M_EMPTY_BLOCK_1(AlphanumericSymbols, "⫿", null, 11007, "M_11007", 0, 0),

	// ---------- Letterlike Symbols ---

	M_8448(LetterlikeSymbols, "℀", null, 8448, "M_8448", 0, 0),

	M_8449(LetterlikeSymbols, "℁", null, 8449, "M_8449", 0, 0),

	M_8450(LetterlikeSymbols, "ℂ", null, 8450, "M_8450", 0, 0),

	M_8451(LetterlikeSymbols, "℃", null, 8451, "M_8451", 0, 0),

	M_8452(LetterlikeSymbols, "℄", null, 8452, "M_8452", 0, 0),

	M_8453(LetterlikeSymbols, "℅", null, 8453, "M_8453", 0, 0),

	M_8454(LetterlikeSymbols, "℆", null, 8454, "M_8454", 0, 0),

	M_8455(LetterlikeSymbols, "ℇ", null, 8455, "M_8455", 0, 0),

	M_8456(LetterlikeSymbols, "℈", null, 8456, "M_8456", 0, 0),

	M_8457(LetterlikeSymbols, "℉", null, 8457, "M_8457", 0, 0),

	M_8458(LetterlikeSymbols, "ℊ", null, 8458, "M_8458", 0, 0),

	M_8459(LetterlikeSymbols, "ℋ", null, 8459, "M_8459", 0, 0),

	M_8460(LetterlikeSymbols, "ℌ", null, 8460, "M_8460", 0, 0),

	M_8461(LetterlikeSymbols, "ℍ", null, 8461, "M_8461", 0, 0),

	M_8462(LetterlikeSymbols, "ℎ", null, 8462, "M_8462", 0, 0),

	M_8463(LetterlikeSymbols, "ℏ", null, 8463, "M_8463", 0, 0),

	M_8464(LetterlikeSymbols, "ℐ", null, 8464, "M_8464", 0, 0),

	M_8465(LetterlikeSymbols, "ℑ", null, 8465, "M_8465", 0, 0),

	M_8466(LetterlikeSymbols, "ℒ", null, 8466, "M_8466", 0, 0),

	M_8467(LetterlikeSymbols, "ℓ", null, 8467, "M_8467", 0, 0),

	M_8468(LetterlikeSymbols, "℔", null, 8468, "M_8468", 0, 0),

	M_8469(LetterlikeSymbols, "ℕ", null, 8469, "M_8469", 0, 0),

	M_8470(LetterlikeSymbols, "№", null, 8470, "M_8470", 0, 0),

	M_8471(LetterlikeSymbols, "℗", null, 8471, "M_8471", 0, 0),

	M_8472(LetterlikeSymbols, "℘", null, 8472, "M_8472", 0, 0),

	M_8473(LetterlikeSymbols, "ℙ", null, 8473, "M_8473", 0, 0),

	M_8474(LetterlikeSymbols, "ℚ", null, 8474, "M_8474", 0, 0),

	M_8475(LetterlikeSymbols, "ℛ", null, 8475, "M_8475", 0, 0),

	M_8476(LetterlikeSymbols, "ℜ", null, 8476, "M_8476", 0, 0),

	M_8477(LetterlikeSymbols, "ℝ", null, 8477, "M_8477", 0, 0),

	M_8478(LetterlikeSymbols, "℞", null, 8478, "M_8478", 0, 0),

	M_8479(LetterlikeSymbols, "℟", null, 8479, "M_8479", 0, 0),

	M_8480(LetterlikeSymbols, "℠", null, 8480, "M_8480", 0, 0),

	M_8481(LetterlikeSymbols, "℡", null, 8481, "M_8481", 0, 0),

	M_8482(LetterlikeSymbols, "™", null, 8482, "M_8482", 0, 0),

	M_8483(LetterlikeSymbols, "℣", null, 8483, "M_8483", 0, 0),

	M_8484(LetterlikeSymbols, "ℤ", null, 8484, "M_8484", 0, 0),

	M_8485(LetterlikeSymbols, "℥", null, 8485, "M_8485", 0, 0),

	M_8486(LetterlikeSymbols, "Ω", null, 8486, "M_8486", 0, 0),

	M_8487(LetterlikeSymbols, "℧", null, 8487, "M_8487", 0, 0),

	M_8488(LetterlikeSymbols, "ℨ", null, 8488, "M_8488", 0, 0),

	M_8489(LetterlikeSymbols, "℩", null, 8489, "M_8489", 0, 0),

	M_8490(LetterlikeSymbols, "K", null, 8490, "M_8490", 0, 0),

	M_8491(LetterlikeSymbols, "Å", null, 8491, "M_8491", 0, 0),

	M_8492(LetterlikeSymbols, "ℬ", null, 8492, "M_8492", 0, 0),

	M_8493(LetterlikeSymbols, "ℭ", null, 8493, "M_8493", 0, 0),

	M_8494(LetterlikeSymbols, "℮", null, 8494, "M_8494", 0, 0),

	M_8495(LetterlikeSymbols, "ℯ", null, 8495, "M_8495", 0, 0),

	M_8496(LetterlikeSymbols, "ℰ", null, 8496, "M_8496", 0, 0),

	M_8497(LetterlikeSymbols, "ℱ", null, 8497, "M_8497", 0, 0),

	M_8498(LetterlikeSymbols, "Ⅎ", null, 8498, "M_8498", 0, 0),

	M_8499(LetterlikeSymbols, "ℳ", null, 8499, "M_8499", 0, 0),

	M_8500(LetterlikeSymbols, "ℴ", null, 8500, "M_8500", 0, 0),

	M_8501(LetterlikeSymbols, "ℵ", null, 8501, "M_8501", 0, 0),

	M_8502(LetterlikeSymbols, "ℶ", null, 8502, "M_8502", 0, 0),

	M_8503(LetterlikeSymbols, "ℷ", null, 8503, "M_8503", 0, 0),

	M_8504(LetterlikeSymbols, "ℸ", null, 8504, "M_8504", 0, 0),

	M_8505(LetterlikeSymbols, "ℹ", null, 8505, "M_8505", 0, 0),

	M_8506(LetterlikeSymbols, "℺", null, 8506, "M_8506", 0, 0),

	M_8507(LetterlikeSymbols, "℻", null, 8507, "M_8507", 0, 0),

	M_8508(LetterlikeSymbols, "ℼ", null, 8508, "M_8508", 0, 0),

	M_8509(LetterlikeSymbols, "ℽ", null, 8509, "M_8509", 0, 0),

	M_8510(LetterlikeSymbols, "ℾ", null, 8510, "M_8510", 0, 0),

	M_8511(LetterlikeSymbols, "ℿ", null, 8511, "M_8511", 0, 0),

	M_8512(LetterlikeSymbols, "⅀", null, 8512, "M_8512", 0, 0),

	M_8513(LetterlikeSymbols, "⅁", null, 8513, "M_8513", 0, 0),

	M_8514(LetterlikeSymbols, "⅂", null, 8514, "M_8514", 0, 0),

	M_8515(LetterlikeSymbols, "⅃", null, 8515, "M_8515", 0, 0),

	M_8516(LetterlikeSymbols, "⅄", null, 8516, "M_8516", 0, 0),

	M_8517(LetterlikeSymbols, "ⅅ", null, 8517, "M_8517", 0, 0),

	M_8518(LetterlikeSymbols, "ⅆ", null, 8518, "M_8518", 0, 0),

	M_8519(LetterlikeSymbols, "ⅇ", null, 8519, "M_8519", 0, 0),

	M_8520(LetterlikeSymbols, "ⅈ", null, 8520, "M_8520", 0, 0),

	M_8521(LetterlikeSymbols, "ⅉ", null, 8521, "M_8521", 0, 0),

	M_8522(LetterlikeSymbols, "⅊", null, 8522, "M_8522", 0, 0),

	M_8523(LetterlikeSymbols, "⅋", null, 8523, "M_8523", 0, 0),

	M_8524(LetterlikeSymbols, "⅌", null, 8524, "M_8524", 0, 0),

	M_8525(LetterlikeSymbols, "⅍", null, 8525, "M_8525", 0, 0),

	M_8526(LetterlikeSymbols, "ⅎ", null, 8526, "M_8526", 0, 0),

	M_8527(LetterlikeSymbols, "⅏", null, 8527, "M_8527", 0, 0),

	// ---------- Miscellaneous Mathematical Symbols-A ---

	M_10176(MiscellaneousSymbolsA, "⟀", null, 10176, "M_10176", 0, 0),

	M_10177(MiscellaneousSymbolsA, "⟁", null, 10177, "M_10177", 0, 0),

	M_10178(MiscellaneousSymbolsA, "⟂", null, 10178, "M_10178", 0, 0),

	M_10179(MiscellaneousSymbolsA, "⟃", null, 10179, "M_10179", 0, 0),

	M_10180(MiscellaneousSymbolsA, "⟄", null, 10180, "M_10180", 0, 0),

	M_10181(MiscellaneousSymbolsA, "⟅", null, 10181, "M_10181", 0, 0),

	M_10182(MiscellaneousSymbolsA, "⟆", null, 10182, "M_10182", 0, 0),

	M_10183(MiscellaneousSymbolsA, "⟇", null, 10183, "M_10183", 0, 0),

	M_10184(MiscellaneousSymbolsA, "⟈", null, 10184, "M_10184", 0, 0),

	M_10185(MiscellaneousSymbolsA, "⟉", null, 10185, "M_10185", 0, 0),

	M_10186(MiscellaneousSymbolsA, "⟊", null, 10186, "M_10186", 0, 0),

	M_10187(MiscellaneousSymbolsA, "⟋", null, 10187, "M_10187", 0, 0),

	M_10188(MiscellaneousSymbolsA, "⟌", null, 10188, "M_10188", 0, 0),

	M_10189(MiscellaneousSymbolsA, "⟍", null, 10189, "M_10189", 0, 0),

	M_10190(MiscellaneousSymbolsA, "⟎", null, 10190, "M_10190", 0, 0),

	M_10191(MiscellaneousSymbolsA, "⟏", null, 10191, "M_10191", 0, 0),

	M_10192(MiscellaneousSymbolsA, "⟐", null, 10192, "M_10192", 0, 0),

	M_10193(MiscellaneousSymbolsA, "⟑", null, 10193, "M_10193", 0, 0),

	M_10194(MiscellaneousSymbolsA, "⟒", null, 10194, "M_10194", 0, 0),

	M_10195(MiscellaneousSymbolsA, "⟓", null, 10195, "M_10195", 0, 0),

	M_10196(MiscellaneousSymbolsA, "⟔", null, 10196, "M_10196", 0, 0),

	M_10197(MiscellaneousSymbolsA, "⟕", null, 10197, "M_10197", 0, 0),

	M_10198(MiscellaneousSymbolsA, "⟖", null, 10198, "M_10198", 0, 0),

	M_10199(MiscellaneousSymbolsA, "⟗", null, 10199, "M_10199", 0, 0),

	M_10200(MiscellaneousSymbolsA, "⟘", null, 10200, "M_10200", 0, 0),

	M_10201(MiscellaneousSymbolsA, "⟙", null, 10201, "M_10201", 0, 0),

	M_10202(MiscellaneousSymbolsA, "⟚", null, 10202, "M_10202", 0, 0),

	M_10203(MiscellaneousSymbolsA, "⟛", null, 10203, "M_10203", 0, 0),

	M_10204(MiscellaneousSymbolsA, "⟜", null, 10204, "M_10204", 0, 0),

	M_10205(MiscellaneousSymbolsA, "⟝", null, 10205, "M_10205", 0, 0),

	M_10206(MiscellaneousSymbolsA, "⟞", null, 10206, "M_10206", 0, 0),

	M_10207(MiscellaneousSymbolsA, "⟟", null, 10207, "M_10207", 0, 0),

	M_10208(MiscellaneousSymbolsA, "⟠", null, 10208, "M_10208", 0, 0),

	M_10209(MiscellaneousSymbolsA, "⟡", null, 10209, "M_10209", 0, 0),

	M_10210(MiscellaneousSymbolsA, "⟢", null, 10210, "M_10210", 0, 0),

	M_10211(MiscellaneousSymbolsA, "⟣", null, 10211, "M_10211", 0, 0),

	M_10212(MiscellaneousSymbolsA, "⟤", null, 10212, "M_10212", 0, 0),

	M_10213(MiscellaneousSymbolsA, "⟥", null, 10213, "M_10213", 0, 0),

	M_10214(MiscellaneousSymbolsA, "⟦", null, 10214, "M_10214", 0, 0),

	M_10215(MiscellaneousSymbolsA, "⟧", null, 10215, "M_10215", 0, 0),

	M_10216(MiscellaneousSymbolsA, "⟨", null, 10216, "M_10216", 0, 0),

	M_10217(MiscellaneousSymbolsA, "⟩", null, 10217, "M_10217", 0, 0),

	M_10218(MiscellaneousSymbolsA, "⟪", null, 10218, "M_10218", 0, 0),

	M_10219(MiscellaneousSymbolsA, "⟫", null, 10219, "M_10219", 0, 0),

	M_10220(MiscellaneousSymbolsA, "⟬", null, 10220, "M_10220", 0, 0),

	M_10221(MiscellaneousSymbolsA, "⟭", null, 10221, "M_10221", 0, 0),

	M_10222(MiscellaneousSymbolsA, "⟮", null, 10222, "M_10222", 0, 0),

	M_10223(MiscellaneousSymbolsA, "⟯", null, 10223, "M_10223", 0, 0),

	// ---------- Miscellaneous Mathematical Symbols-B ---

	M_10624(MiscellaneousSymbolsB, "⦀", null, 10624, "M_10624", 0, 0),

	M_10625(MiscellaneousSymbolsB, "⦁", null, 10625, "M_10625", 0, 0),

	M_10626(MiscellaneousSymbolsB, "⦂", null, 10626, "M_10626", 0, 0),

	M_10627(MiscellaneousSymbolsB, "⦃", null, 10627, "M_10627", 0, 0),

	M_10628(MiscellaneousSymbolsB, "⦄", null, 10628, "M_10628", 0, 0),

	M_10629(MiscellaneousSymbolsB, "⦅", null, 10629, "M_10629", 0, 0),

	M_10630(MiscellaneousSymbolsB, "⦆", null, 10630, "M_10630", 0, 0),

	M_10631(MiscellaneousSymbolsB, "⦇", null, 10631, "M_10631", 0, 0),

	M_10632(MiscellaneousSymbolsB, "⦈", null, 10632, "M_10632", 0, 0),

	M_10633(MiscellaneousSymbolsB, "⦉", null, 10633, "M_10633", 0, 0),

	M_10634(MiscellaneousSymbolsB, "⦊", null, 10634, "M_10634", 0, 0),

	M_10635(MiscellaneousSymbolsB, "⦋", null, 10635, "M_10635", 0, 0),

	M_10636(MiscellaneousSymbolsB, "⦌", null, 10636, "M_10636", 0, 0),

	M_10637(MiscellaneousSymbolsB, "⦍", null, 10637, "M_10637", 0, 0),

	M_10638(MiscellaneousSymbolsB, "⦎", null, 10638, "M_10638", 0, 0),

	M_10639(MiscellaneousSymbolsB, "⦏", null, 10639, "M_10639", 0, 0),

	M_10640(MiscellaneousSymbolsB, "⦐", null, 10640, "M_10640", 0, 0),

	M_10641(MiscellaneousSymbolsB, "⦑", null, 10641, "M_10641", 0, 0),

	M_10642(MiscellaneousSymbolsB, "⦒", null, 10642, "M_10642", 0, 0),

	M_10643(MiscellaneousSymbolsB, "⦓", null, 10643, "M_10643", 0, 0),

	M_10644(MiscellaneousSymbolsB, "⦔", null, 10644, "M_10644", 0, 0),

	M_10645(MiscellaneousSymbolsB, "⦕", null, 10645, "M_10645", 0, 0),

	M_10646(MiscellaneousSymbolsB, "⦖", null, 10646, "M_10646", 0, 0),

	M_10647(MiscellaneousSymbolsB, "⦗", null, 10647, "M_10647", 0, 0),

	M_10648(MiscellaneousSymbolsB, "⦘", null, 10648, "M_10648", 0, 0),

	M_10649(MiscellaneousSymbolsB, "⦙", null, 10649, "M_10649", 0, 0),

	M_10650(MiscellaneousSymbolsB, "⦚", null, 10650, "M_10650", 0, 0),

	M_10651(MiscellaneousSymbolsB, "⦛", null, 10651, "M_10651", 0, 0),

	M_10652(MiscellaneousSymbolsB, "⦜", null, 10652, "M_10652", 0, 0),

	M_10653(MiscellaneousSymbolsB, "⦝", null, 10653, "M_10653", 0, 0),

	M_10654(MiscellaneousSymbolsB, "⦞", null, 10654, "M_10654", 0, 0),

	M_10655(MiscellaneousSymbolsB, "⦟", null, 10655, "M_10655", 0, 0),

	M_10656(MiscellaneousSymbolsB, "⦠", null, 10656, "M_10656", 0, 0),

	M_10657(MiscellaneousSymbolsB, "⦡", null, 10657, "M_10657", 0, 0),

	M_10658(MiscellaneousSymbolsB, "⦢", null, 10658, "M_10658", 0, 0),

	M_10659(MiscellaneousSymbolsB, "⦣", null, 10659, "M_10659", 0, 0),

	M_10660(MiscellaneousSymbolsB, "⦤", null, 10660, "M_10660", 0, 0),

	M_10661(MiscellaneousSymbolsB, "⦥", null, 10661, "M_10661", 0, 0),

	M_10662(MiscellaneousSymbolsB, "⦦", null, 10662, "M_10662", 0, 0),

	M_10663(MiscellaneousSymbolsB, "⦧", null, 10663, "M_10663", 0, 0),

	M_10664(MiscellaneousSymbolsB, "⦨", null, 10664, "M_10664", 0, 0),

	M_10665(MiscellaneousSymbolsB, "⦩", null, 10665, "M_10665", 0, 0),

	M_10666(MiscellaneousSymbolsB, "⦪", null, 10666, "M_10666", 0, 0),

	M_10667(MiscellaneousSymbolsB, "⦫", null, 10667, "M_10667", 0, 0),

	M_10668(MiscellaneousSymbolsB, "⦬", null, 10668, "M_10668", 0, 0),

	M_10669(MiscellaneousSymbolsB, "⦭", null, 10669, "M_10669", 0, 0),

	M_10670(MiscellaneousSymbolsB, "⦮", null, 10670, "M_10670", 0, 0),

	M_10671(MiscellaneousSymbolsB, "⦯", null, 10671, "M_10671", 0, 0),

	M_10672(MiscellaneousSymbolsB, "⦰", null, 10672, "M_10672", 0, 0),

	M_10673(MiscellaneousSymbolsB, "⦱", null, 10673, "M_10673", 0, 0),

	M_10674(MiscellaneousSymbolsB, "⦲", null, 10674, "M_10674", 0, 0),

	M_10675(MiscellaneousSymbolsB, "⦳", null, 10675, "M_10675", 0, 0),

	M_10676(MiscellaneousSymbolsB, "⦴", null, 10676, "M_10676", 0, 0),

	M_10677(MiscellaneousSymbolsB, "⦵", null, 10677, "M_10677", 0, 0),

	M_10678(MiscellaneousSymbolsB, "⦶", null, 10678, "M_10678", 0, 0),

	M_10679(MiscellaneousSymbolsB, "⦷", null, 10679, "M_10679", 0, 0),

	M_10680(MiscellaneousSymbolsB, "⦸", null, 10680, "M_10680", 0, 0),

	M_10681(MiscellaneousSymbolsB, "⦹", null, 10681, "M_10681", 0, 0),

	M_10682(MiscellaneousSymbolsB, "⦺", null, 10682, "M_10682", 0, 0),

	M_10683(MiscellaneousSymbolsB, "⦻", null, 10683, "M_10683", 0, 0),

	M_10684(MiscellaneousSymbolsB, "⦼", null, 10684, "M_10684", 0, 0),

	M_10685(MiscellaneousSymbolsB, "⦽", null, 10685, "M_10685", 0, 0),

	M_10686(MiscellaneousSymbolsB, "⦾", null, 10686, "M_10686", 0, 0),

	M_10687(MiscellaneousSymbolsB, "⦿", null, 10687, "M_10687", 0, 0),

	M_10688(MiscellaneousSymbolsB, "⧀", null, 10688, "M_10688", 0, 0),

	M_10689(MiscellaneousSymbolsB, "⧁", null, 10689, "M_10689", 0, 0),

	M_10690(MiscellaneousSymbolsB, "⧂", null, 10690, "M_10690", 0, 0),

	M_10691(MiscellaneousSymbolsB, "⧃", null, 10691, "M_10691", 0, 0),

	M_10692(MiscellaneousSymbolsB, "⧄", null, 10692, "M_10692", 0, 0),

	M_10693(MiscellaneousSymbolsB, "⧅", null, 10693, "M_10693", 0, 0),

	M_10694(MiscellaneousSymbolsB, "⧆", null, 10694, "M_10694", 0, 0),

	M_10695(MiscellaneousSymbolsB, "⧇", null, 10695, "M_10695", 0, 0),

	M_10696(MiscellaneousSymbolsB, "⧈", null, 10696, "M_10696", 0, 0),

	M_10697(MiscellaneousSymbolsB, "⧉", null, 10697, "M_10697", 0, 0),

	M_10698(MiscellaneousSymbolsB, "⧊", null, 10698, "M_10698", 0, 0),

	M_10699(MiscellaneousSymbolsB, "⧋", null, 10699, "M_10699", 0, 0),

	M_10700(MiscellaneousSymbolsB, "⧌", null, 10700, "M_10700", 0, 0),

	M_10701(MiscellaneousSymbolsB, "⧍", null, 10701, "M_10701", 0, 0),

	M_10702(MiscellaneousSymbolsB, "⧎", null, 10702, "M_10702", 0, 0),

	M_10703(MiscellaneousSymbolsB, "⧏", null, 10703, "M_10703", 0, 0),

	M_10704(MiscellaneousSymbolsB, "⧐", null, 10704, "M_10704", 0, 0),

	M_10705(MiscellaneousSymbolsB, "⧑", null, 10705, "M_10705", 0, 0),

	M_10706(MiscellaneousSymbolsB, "⧒", null, 10706, "M_10706", 0, 0),

	M_10707(MiscellaneousSymbolsB, "⧓", null, 10707, "M_10707", 0, 0),

	M_10708(MiscellaneousSymbolsB, "⧔", null, 10708, "M_10708", 0, 0),

	M_10709(MiscellaneousSymbolsB, "⧕", null, 10709, "M_10709", 0, 0),

	M_10710(MiscellaneousSymbolsB, "⧖", null, 10710, "M_10710", 0, 0),

	M_10711(MiscellaneousSymbolsB, "⧗", null, 10711, "M_10711", 0, 0),

	M_10712(MiscellaneousSymbolsB, "⧘", null, 10712, "M_10712", 0, 0),

	M_10713(MiscellaneousSymbolsB, "⧙", null, 10713, "M_10713", 0, 0),

	M_10714(MiscellaneousSymbolsB, "⧚", null, 10714, "M_10714", 0, 0),

	M_10715(MiscellaneousSymbolsB, "⧛", null, 10715, "M_10715", 0, 0),

	M_10716(MiscellaneousSymbolsB, "⧜", null, 10716, "M_10716", 0, 0),

	M_10717(MiscellaneousSymbolsB, "⧝", null, 10717, "M_10717", 0, 0),

	M_10718(MiscellaneousSymbolsB, "⧞", null, 10718, "M_10718", 0, 0),

	M_10719(MiscellaneousSymbolsB, "⧟", null, 10719, "M_10719", 0, 0),

	M_10720(MiscellaneousSymbolsB, "⧠", null, 10720, "M_10720", 0, 0),

	M_10721(MiscellaneousSymbolsB, "⧡", null, 10721, "M_10721", 0, 0),

	M_10722(MiscellaneousSymbolsB, "⧢", null, 10722, "M_10722", 0, 0),

	M_10723(MiscellaneousSymbolsB, "⧣", null, 10723, "M_10723", 0, 0),

	M_10724(MiscellaneousSymbolsB, "⧤", null, 10724, "M_10724", 0, 0),

	M_10725(MiscellaneousSymbolsB, "⧥", null, 10725, "M_10725", 0, 0),

	M_10726(MiscellaneousSymbolsB, "⧦", null, 10726, "M_10726", 0, 0),

	M_10727(MiscellaneousSymbolsB, "⧧", null, 10727, "M_10727", 0, 0),

	M_10728(MiscellaneousSymbolsB, "⧨", null, 10728, "M_10728", 0, 0),

	M_10729(MiscellaneousSymbolsB, "⧩", null, 10729, "M_10729", 0, 0),

	M_10730(MiscellaneousSymbolsB, "⧪", null, 10730, "M_10730", 0, 0),

	M_10731(MiscellaneousSymbolsB, "⧫", null, 10731, "M_10731", 0, 0),

	M_10732(MiscellaneousSymbolsB, "⧬", null, 10732, "M_10732", 0, 0),

	M_10733(MiscellaneousSymbolsB, "⧭", null, 10733, "M_10733", 0, 0),

	M_10734(MiscellaneousSymbolsB, "⧮", null, 10734, "M_10734", 0, 0),

	M_10735(MiscellaneousSymbolsB, "⧯", null, 10735, "M_10735", 0, 0),

	M_10736(MiscellaneousSymbolsB, "⧰", null, 10736, "M_10736", 0, 0),

	M_10737(MiscellaneousSymbolsB, "⧱", null, 10737, "M_10737", 0, 0),

	M_10738(MiscellaneousSymbolsB, "⧲", null, 10738, "M_10738", 0, 0),

	M_10739(MiscellaneousSymbolsB, "⧳", null, 10739, "M_10739", 0, 0),

	M_10740(MiscellaneousSymbolsB, "⧴", null, 10740, "M_10740", 0, 0),

	M_10741(MiscellaneousSymbolsB, "⧵", null, 10741, "M_10741", 0, 0),

	M_10742(MiscellaneousSymbolsB, "⧶", null, 10742, "M_10742", 0, 0),

	M_10743(MiscellaneousSymbolsB, "⧷", null, 10743, "M_10743", 0, 0),

	M_10744(MiscellaneousSymbolsB, "⧸", null, 10744, "M_10744", 0, 0),

	M_10745(MiscellaneousSymbolsB, "⧹", null, 10745, "M_10745", 0, 0),

	M_10746(MiscellaneousSymbolsB, "⧺", null, 10746, "M_10746", 0, 0),

	M_10747(MiscellaneousSymbolsB, "⧻", null, 10747, "M_10747", 0, 0),

	M_10748(MiscellaneousSymbolsB, "⧼", null, 10748, "M_10748", 0, 0),

	M_10749(MiscellaneousSymbolsB, "⧽", null, 10749, "M_10749", 0, 0),

	M_10750(MiscellaneousSymbolsB, "⧾", null, 10750, "M_10750", 0, 0),

	M_10751(MiscellaneousSymbolsB, "⧿", null, 10751, "M_10751", 0, 0),

	// ---------- Miscellaneous Technical ---

	M_8960(MiscellaneousTechnical, "⌀", null, 8960, "M_8960", 0, 0),

	M_8961(MiscellaneousTechnical, "⌁", null, 8961, "M_8961", 0, 0),

	M_8962(MiscellaneousTechnical, "⌂", null, 8962, "M_8962", 0, 0),

	M_8963(MiscellaneousTechnical, "⌃", null, 8963, "M_8963", 0, 0),

	M_8964(MiscellaneousTechnical, "⌄", null, 8964, "M_8964", 0, 0),

	M_8965(MiscellaneousTechnical, "⌅", null, 8965, "M_8965", 0, 0),

	M_8966(MiscellaneousTechnical, "⌆", null, 8966, "M_8966", 0, 0),

	M_8967(MiscellaneousTechnical, "⌇", null, 8967, "M_8967", 0, 0),

	M_8968(MiscellaneousTechnical, "⌈", null, 8968, "M_8968", 0, 0),

	M_8969(MiscellaneousTechnical, "⌉", null, 8969, "M_8969", 0, 0),

	M_8970(MiscellaneousTechnical, "⌊", null, 8970, "M_8970", 0, 0),

	M_8971(MiscellaneousTechnical, "⌋", null, 8971, "M_8971", 0, 0),

	M_8972(MiscellaneousTechnical, "⌌", null, 8972, "M_8972", 0, 0),

	M_8973(MiscellaneousTechnical, "⌍", null, 8973, "M_8973", 0, 0),

	M_8974(MiscellaneousTechnical, "⌎", null, 8974, "M_8974", 0, 0),

	M_8975(MiscellaneousTechnical, "⌏", null, 8975, "M_8975", 0, 0),

	M_8976(MiscellaneousTechnical, "⌐", null, 8976, "M_8976", 0, 0),

	M_8977(MiscellaneousTechnical, "⌑", null, 8977, "M_8977", 0, 0),

	M_8978(MiscellaneousTechnical, "⌒", null, 8978, "M_8978", 0, 0),

	M_8979(MiscellaneousTechnical, "⌓", null, 8979, "M_8979", 0, 0),

	M_8980(MiscellaneousTechnical, "⌔", null, 8980, "M_8980", 0, 0),

	M_8981(MiscellaneousTechnical, "⌕", null, 8981, "M_8981", 0, 0),

	M_8982(MiscellaneousTechnical, "⌖", null, 8982, "M_8982", 0, 0),

	M_8983(MiscellaneousTechnical, "⌗", null, 8983, "M_8983", 0, 0),

	M_8984(MiscellaneousTechnical, "⌘", null, 8984, "M_8984", 0, 0),

	M_8985(MiscellaneousTechnical, "⌙", null, 8985, "M_8985", 0, 0),

	M_8986(MiscellaneousTechnical, "⌚", null, 8986, "M_8986", 0, 0),

	M_8987(MiscellaneousTechnical, "⌛", null, 8987, "M_8987", 0, 0),

	M_8988(MiscellaneousTechnical, "⌜", null, 8988, "M_8988", 0, 0),

	M_8989(MiscellaneousTechnical, "⌝", null, 8989, "M_8989", 0, 0),

	M_8990(MiscellaneousTechnical, "⌞", null, 8990, "M_8990", 0, 0),

	M_8991(MiscellaneousTechnical, "⌟", null, 8991, "M_8991", 0, 0),

	M_8992(MiscellaneousTechnical, "⌠", null, 8992, "M_8992", 0, 0),

	M_8993(MiscellaneousTechnical, "⌡", null, 8993, "M_8993", 0, 0),

	M_8994(MiscellaneousTechnical, "⌢", null, 8994, "M_8994", 0, 0),

	M_8995(MiscellaneousTechnical, "⌣", null, 8995, "M_8995", 0, 0),

	M_8996(MiscellaneousTechnical, "⌤", null, 8996, "M_8996", 0, 0),

	M_8997(MiscellaneousTechnical, "⌥", null, 8997, "M_8997", 0, 0),

	M_8998(MiscellaneousTechnical, "⌦", null, 8998, "M_8998", 0, 0),

	M_8999(MiscellaneousTechnical, "⌧", null, 8999, "M_8999", 0, 0),

	M_9000(MiscellaneousTechnical, "⌨", null, 9000, "M_9000", 0, 0),

	M_9001(MiscellaneousTechnical, "〈", null, 9001, "M_9001", 0, 0),

	M_9002(MiscellaneousTechnical, "〉", null, 9002, "M_9002", 0, 0),

	M_9003(MiscellaneousTechnical, "⌫", null, 9003, "M_9003", 0, 0),

	M_9004(MiscellaneousTechnical, "⌬", null, 9004, "M_9004", 0, 0),

	M_9005(MiscellaneousTechnical, "⌭", null, 9005, "M_9005", 0, 0),

	M_9006(MiscellaneousTechnical, "⌮", null, 9006, "M_9006", 0, 0),

	M_9007(MiscellaneousTechnical, "⌯", null, 9007, "M_9007", 0, 0),

	M_9008(MiscellaneousTechnical, "⌰", null, 9008, "M_9008", 0, 0),

	M_9009(MiscellaneousTechnical, "⌱", null, 9009, "M_9009", 0, 0),

	M_9010(MiscellaneousTechnical, "⌲", null, 9010, "M_9010", 0, 0),

	M_9011(MiscellaneousTechnical, "⌳", null, 9011, "M_9011", 0, 0),

	M_9012(MiscellaneousTechnical, "⌴", null, 9012, "M_9012", 0, 0),

	M_9013(MiscellaneousTechnical, "⌵", null, 9013, "M_9013", 0, 0),

	M_9014(MiscellaneousTechnical, "⌶", null, 9014, "M_9014", 0, 0),

	M_9015(MiscellaneousTechnical, "⌷", null, 9015, "M_9015", 0, 0),

	M_9016(MiscellaneousTechnical, "⌸", null, 9016, "M_9016", 0, 0),

	M_9017(MiscellaneousTechnical, "⌹", null, 9017, "M_9017", 0, 0),

	M_9018(MiscellaneousTechnical, "⌺", null, 9018, "M_9018", 0, 0),

	M_9019(MiscellaneousTechnical, "⌻", null, 9019, "M_9019", 0, 0),

	M_9020(MiscellaneousTechnical, "⌼", null, 9020, "M_9020", 0, 0),

	M_9021(MiscellaneousTechnical, "⌽", null, 9021, "M_9021", 0, 0),

	M_9022(MiscellaneousTechnical, "⌾", null, 9022, "M_9022", 0, 0),

	M_9023(MiscellaneousTechnical, "⌿", null, 9023, "M_9023", 0, 0),

	M_9024(MiscellaneousTechnical, "⍀", null, 9024, "M_9024", 0, 0),

	M_9025(MiscellaneousTechnical, "⍁", null, 9025, "M_9025", 0, 0),

	M_9026(MiscellaneousTechnical, "⍂", null, 9026, "M_9026", 0, 0),

	M_9027(MiscellaneousTechnical, "⍃", null, 9027, "M_9027", 0, 0),

	M_9028(MiscellaneousTechnical, "⍄", null, 9028, "M_9028", 0, 0),

	M_9029(MiscellaneousTechnical, "⍅", null, 9029, "M_9029", 0, 0),

	M_9030(MiscellaneousTechnical, "⍆", null, 9030, "M_9030", 0, 0),

	M_9031(MiscellaneousTechnical, "⍇", null, 9031, "M_9031", 0, 0),

	M_9032(MiscellaneousTechnical, "⍈", null, 9032, "M_9032", 0, 0),

	M_9033(MiscellaneousTechnical, "⍉", null, 9033, "M_9033", 0, 0),

	M_9034(MiscellaneousTechnical, "⍊", null, 9034, "M_9034", 0, 0),

	M_9035(MiscellaneousTechnical, "⍋", null, 9035, "M_9035", 0, 0),

	M_9036(MiscellaneousTechnical, "⍌", null, 9036, "M_9036", 0, 0),

	M_9037(MiscellaneousTechnical, "⍍", null, 9037, "M_9037", 0, 0),

	M_9038(MiscellaneousTechnical, "⍎", null, 9038, "M_9038", 0, 0),

	M_9039(MiscellaneousTechnical, "⍏", null, 9039, "M_9039", 0, 0),

	M_9040(MiscellaneousTechnical, "⍐", null, 9040, "M_9040", 0, 0),

	M_9041(MiscellaneousTechnical, "⍑", null, 9041, "M_9041", 0, 0),

	M_9042(MiscellaneousTechnical, "⍒", null, 9042, "M_9042", 0, 0),

	M_9043(MiscellaneousTechnical, "⍓", null, 9043, "M_9043", 0, 0),

	M_9044(MiscellaneousTechnical, "⍔", null, 9044, "M_9044", 0, 0),

	M_9045(MiscellaneousTechnical, "⍕", null, 9045, "M_9045", 0, 0),

	M_9046(MiscellaneousTechnical, "⍖", null, 9046, "M_9046", 0, 0),

	M_9047(MiscellaneousTechnical, "⍗", null, 9047, "M_9047", 0, 0),

	M_9048(MiscellaneousTechnical, "⍘", null, 9048, "M_9048", 0, 0),

	M_9049(MiscellaneousTechnical, "⍙", null, 9049, "M_9049", 0, 0),

	M_9050(MiscellaneousTechnical, "⍚", null, 9050, "M_9050", 0, 0),

	M_9051(MiscellaneousTechnical, "⍛", null, 9051, "M_9051", 0, 0),

	M_9052(MiscellaneousTechnical, "⍜", null, 9052, "M_9052", 0, 0),

	M_9053(MiscellaneousTechnical, "⍝", null, 9053, "M_9053", 0, 0),

	M_9054(MiscellaneousTechnical, "⍞", null, 9054, "M_9054", 0, 0),

	M_9055(MiscellaneousTechnical, "⍟", null, 9055, "M_9055", 0, 0),

	M_9056(MiscellaneousTechnical, "⍠", null, 9056, "M_9056", 0, 0),

	M_9057(MiscellaneousTechnical, "⍡", null, 9057, "M_9057", 0, 0),

	M_9058(MiscellaneousTechnical, "⍢", null, 9058, "M_9058", 0, 0),

	M_9059(MiscellaneousTechnical, "⍣", null, 9059, "M_9059", 0, 0),

	M_9060(MiscellaneousTechnical, "⍤", null, 9060, "M_9060", 0, 0),

	M_9061(MiscellaneousTechnical, "⍥", null, 9061, "M_9061", 0, 0),

	M_9062(MiscellaneousTechnical, "⍦", null, 9062, "M_9062", 0, 0),

	M_9063(MiscellaneousTechnical, "⍧", null, 9063, "M_9063", 0, 0),

	M_9064(MiscellaneousTechnical, "⍨", null, 9064, "M_9064", 0, 0),

	M_9065(MiscellaneousTechnical, "⍩", null, 9065, "M_9065", 0, 0),

	M_9066(MiscellaneousTechnical, "⍪", null, 9066, "M_9066", 0, 0),

	M_9067(MiscellaneousTechnical, "⍫", null, 9067, "M_9067", 0, 0),

	M_9068(MiscellaneousTechnical, "⍬", null, 9068, "M_9068", 0, 0),

	M_9069(MiscellaneousTechnical, "⍭", null, 9069, "M_9069", 0, 0),

	M_9070(MiscellaneousTechnical, "⍮", null, 9070, "M_9070", 0, 0),

	M_9071(MiscellaneousTechnical, "⍯", null, 9071, "M_9071", 0, 0),

	M_9072(MiscellaneousTechnical, "⍰", null, 9072, "M_9072", 0, 0),

	M_9073(MiscellaneousTechnical, "⍱", null, 9073, "M_9073", 0, 0),

	M_9074(MiscellaneousTechnical, "⍲", null, 9074, "M_9074", 0, 0),

	M_9075(MiscellaneousTechnical, "⍳", null, 9075, "M_9075", 0, 0),

	M_9076(MiscellaneousTechnical, "⍴", null, 9076, "M_9076", 0, 0),

	M_9077(MiscellaneousTechnical, "⍵", null, 9077, "M_9077", 0, 0),

	M_9078(MiscellaneousTechnical, "⍶", null, 9078, "M_9078", 0, 0),

	M_9079(MiscellaneousTechnical, "⍷", null, 9079, "M_9079", 0, 0),

	M_9080(MiscellaneousTechnical, "⍸", null, 9080, "M_9080", 0, 0),

	M_9081(MiscellaneousTechnical, "⍹", null, 9081, "M_9081", 0, 0),

	M_9082(MiscellaneousTechnical, "⍺", null, 9082, "M_9082", 0, 0),

	M_9083(MiscellaneousTechnical, "⍻", null, 9083, "M_9083", 0, 0),

	M_9084(MiscellaneousTechnical, "⍼", null, 9084, "M_9084", 0, 0),

	M_9085(MiscellaneousTechnical, "⍽", null, 9085, "M_9085", 0, 0),

	M_9086(MiscellaneousTechnical, "⍾", null, 9086, "M_9086", 0, 0),

	M_9087(MiscellaneousTechnical, "⍿", null, 9087, "M_9087", 0, 0),

	M_9088(MiscellaneousTechnical, "⎀", null, 9088, "M_9088", 0, 0),

	M_9089(MiscellaneousTechnical, "⎁", null, 9089, "M_9089", 0, 0),

	M_9090(MiscellaneousTechnical, "⎂", null, 9090, "M_9090", 0, 0),

	M_9091(MiscellaneousTechnical, "⎃", null, 9091, "M_9091", 0, 0),

	M_9092(MiscellaneousTechnical, "⎄", null, 9092, "M_9092", 0, 0),

	M_9093(MiscellaneousTechnical, "⎅", null, 9093, "M_9093", 0, 0),

	M_9094(MiscellaneousTechnical, "⎆", null, 9094, "M_9094", 0, 0),

	M_9095(MiscellaneousTechnical, "⎇", null, 9095, "M_9095", 0, 0),

	M_9096(MiscellaneousTechnical, "⎈", null, 9096, "M_9096", 0, 0),

	M_9097(MiscellaneousTechnical, "⎉", null, 9097, "M_9097", 0, 0),

	M_9098(MiscellaneousTechnical, "⎊", null, 9098, "M_9098", 0, 0),

	M_9099(MiscellaneousTechnical, "⎋", null, 9099, "M_9099", 0, 0),

	M_9100(MiscellaneousTechnical, "⎌", null, 9100, "M_9100", 0, 0),

	M_9101(MiscellaneousTechnical, "⎍", null, 9101, "M_9101", 0, 0),

	M_9102(MiscellaneousTechnical, "⎎", null, 9102, "M_9102", 0, 0),

	M_9103(MiscellaneousTechnical, "⎏", null, 9103, "M_9103", 0, 0),

	M_9104(MiscellaneousTechnical, "⎐", null, 9104, "M_9104", 0, 0),

	M_9105(MiscellaneousTechnical, "⎑", null, 9105, "M_9105", 0, 0),

	M_9106(MiscellaneousTechnical, "⎒", null, 9106, "M_9106", 0, 0),

	M_9107(MiscellaneousTechnical, "⎓", null, 9107, "M_9107", 0, 0),

	M_9108(MiscellaneousTechnical, "⎔", null, 9108, "M_9108", 0, 0),

	M_9109(MiscellaneousTechnical, "⎕", null, 9109, "M_9109", 0, 0),

	M_9110(MiscellaneousTechnical, "⎖", null, 9110, "M_9110", 0, 0),

	M_9111(MiscellaneousTechnical, "⎗", null, 9111, "M_9111", 0, 0),

	M_9112(MiscellaneousTechnical, "⎘", null, 9112, "M_9112", 0, 0),

	M_9113(MiscellaneousTechnical, "⎙", null, 9113, "M_9113", 0, 0),

	M_9114(MiscellaneousTechnical, "⎚", null, 9114, "M_9114", 0, 0),

	M_9115(MiscellaneousTechnical, "⎛", null, 9115, "M_9115", 0, 0),

	M_9116(MiscellaneousTechnical, "⎜", null, 9116, "M_9116", 0, 0),

	M_9117(MiscellaneousTechnical, "⎝", null, 9117, "M_9117", 0, 0),

	M_9118(MiscellaneousTechnical, "⎞", null, 9118, "M_9118", 0, 0),

	M_9119(MiscellaneousTechnical, "⎟", null, 9119, "M_9119", 0, 0),

	M_9120(MiscellaneousTechnical, "⎠", null, 9120, "M_9120", 0, 0),

	M_9121(MiscellaneousTechnical, "⎡", null, 9121, "M_9121", 0, 0),

	M_9122(MiscellaneousTechnical, "⎢", null, 9122, "M_9122", 0, 0),

	M_9123(MiscellaneousTechnical, "⎣", null, 9123, "M_9123", 0, 0),

	M_9124(MiscellaneousTechnical, "⎤", null, 9124, "M_9124", 0, 0),

	M_9125(MiscellaneousTechnical, "⎥", null, 9125, "M_9125", 0, 0),

	M_9126(MiscellaneousTechnical, "⎦", null, 9126, "M_9126", 0, 0),

	M_9127(MiscellaneousTechnical, "⎧", null, 9127, "M_9127", 0, 0),

	M_9128(MiscellaneousTechnical, "⎨", null, 9128, "M_9128", 0, 0),

	M_9129(MiscellaneousTechnical, "⎩", null, 9129, "M_9129", 0, 0),

	M_9130(MiscellaneousTechnical, "⎪", null, 9130, "M_9130", 0, 0),

	M_9131(MiscellaneousTechnical, "⎫", null, 9131, "M_9131", 0, 0),

	M_9132(MiscellaneousTechnical, "⎬", null, 9132, "M_9132", 0, 0),

	M_9133(MiscellaneousTechnical, "⎭", null, 9133, "M_9133", 0, 0),

	M_9134(MiscellaneousTechnical, "⎮", null, 9134, "M_9134", 0, 0),

	M_9135(MiscellaneousTechnical, "⎯", null, 9135, "M_9135", 0, 0),

	M_9136(MiscellaneousTechnical, "⎰", null, 9136, "M_9136", 0, 0),

	M_9137(MiscellaneousTechnical, "⎱", null, 9137, "M_9137", 0, 0),

	M_9138(MiscellaneousTechnical, "⎲", null, 9138, "M_9138", 0, 0),

	M_9139(MiscellaneousTechnical, "⎳", null, 9139, "M_9139", 0, 0),

	M_9140(MiscellaneousTechnical, "⎴", null, 9140, "M_9140", 0, 0),

	M_9141(MiscellaneousTechnical, "⎵", null, 9141, "M_9141", 0, 0),

	M_9142(MiscellaneousTechnical, "⎶", null, 9142, "M_9142", 0, 0),

	M_9143(MiscellaneousTechnical, "⎷", null, 9143, "M_9143", 0, 0),

	M_9144(MiscellaneousTechnical, "⎸", null, 9144, "M_9144", 0, 0),

	M_9145(MiscellaneousTechnical, "⎹", null, 9145, "M_9145", 0, 0),

	M_9146(MiscellaneousTechnical, "⎺", null, 9146, "M_9146", 0, 0),

	M_9147(MiscellaneousTechnical, "⎻", null, 9147, "M_9147", 0, 0),

	M_9148(MiscellaneousTechnical, "⎼", null, 9148, "M_9148", 0, 0),

	M_9149(MiscellaneousTechnical, "⎽", null, 9149, "M_9149", 0, 0),

	M_9150(MiscellaneousTechnical, "⎾", null, 9150, "M_9150", 0, 0),

	M_9151(MiscellaneousTechnical, "⎿", null, 9151, "M_9151", 0, 0),

	M_9152(MiscellaneousTechnical, "⏀", null, 9152, "M_9152", 0, 0),

	M_9153(MiscellaneousTechnical, "⏁", null, 9153, "M_9153", 0, 0),

	M_9154(MiscellaneousTechnical, "⏂", null, 9154, "M_9154", 0, 0),

	M_9155(MiscellaneousTechnical, "⏃", null, 9155, "M_9155", 0, 0),

	M_9156(MiscellaneousTechnical, "⏄", null, 9156, "M_9156", 0, 0),

	M_9157(MiscellaneousTechnical, "⏅", null, 9157, "M_9157", 0, 0),

	M_9158(MiscellaneousTechnical, "⏆", null, 9158, "M_9158", 0, 0),

	M_9159(MiscellaneousTechnical, "⏇", null, 9159, "M_9159", 0, 0),

	M_9160(MiscellaneousTechnical, "⏈", null, 9160, "M_9160", 0, 0),

	M_9161(MiscellaneousTechnical, "⏉", null, 9161, "M_9161", 0, 0),

	M_9162(MiscellaneousTechnical, "⏊", null, 9162, "M_9162", 0, 0),

	M_9163(MiscellaneousTechnical, "⏋", null, 9163, "M_9163", 0, 0),

	M_9164(MiscellaneousTechnical, "⏌", null, 9164, "M_9164", 0, 0),

	M_9165(MiscellaneousTechnical, "⏍", null, 9165, "M_9165", 0, 0),

	M_9166(MiscellaneousTechnical, "⏎", null, 9166, "M_9166", 0, 0),

	M_9167(MiscellaneousTechnical, "⏏", null, 9167, "M_9167", 0, 0),

	M_9168(MiscellaneousTechnical, "⏐", null, 9168, "M_9168", 0, 0),

	M_9169(MiscellaneousTechnical, "⏑", null, 9169, "M_9169", 0, 0),

	M_9170(MiscellaneousTechnical, "⏒", null, 9170, "M_9170", 0, 0),

	M_9171(MiscellaneousTechnical, "⏓", null, 9171, "M_9171", 0, 0),

	M_9172(MiscellaneousTechnical, "⏔", null, 9172, "M_9172", 0, 0),

	M_9173(MiscellaneousTechnical, "⏕", null, 9173, "M_9173", 0, 0),

	M_9174(MiscellaneousTechnical, "⏖", null, 9174, "M_9174", 0, 0),

	M_9175(MiscellaneousTechnical, "⏗", null, 9175, "M_9175", 0, 0),

	M_9176(MiscellaneousTechnical, "⏘", null, 9176, "M_9176", 0, 0),

	M_9177(MiscellaneousTechnical, "⏙", null, 9177, "M_9177", 0, 0),

	M_9178(MiscellaneousTechnical, "⏚", null, 9178, "M_9178", 0, 0),

	M_9179(MiscellaneousTechnical, "⏛", null, 9179, "M_9179", 0, 0),

	M_9180(MiscellaneousTechnical, "⏜", null, 9180, "M_9180", 0, 0),

	M_9181(MiscellaneousTechnical, "⏝", null, 9181, "M_9181", 0, 0),

	M_9182(MiscellaneousTechnical, "⏞", null, 9182, "M_9182", 0, 0),

	M_9183(MiscellaneousTechnical, "⏟", null, 9183, "M_9183", 0, 0),

	M_9184(MiscellaneousTechnical, "⏠", null, 9184, "M_9184", 0, 0),

	M_9185(MiscellaneousTechnical, "⏡", null, 9185, "M_9185", 0, 0),

	M_9186(MiscellaneousTechnical, "⏢", null, 9186, "M_9186", 0, 0),

	M_9187(MiscellaneousTechnical, "⏣", null, 9187, "M_9187", 0, 0),

	M_9188(MiscellaneousTechnical, "⏤", null, 9188, "M_9188", 0, 0),

	M_9189(MiscellaneousTechnical, "⏥", null, 9189, "M_9189", 0, 0),

	M_9190(MiscellaneousTechnical, "⏦", null, 9190, "M_9190", 0, 0),

	M_9191(MiscellaneousTechnical, "⏧", null, 9191, "M_9191", 0, 0),

	M_9192(MiscellaneousTechnical, "⏨", null, 9192, "M_9192", 0, 0),

	M_9193(MiscellaneousTechnical, "⏩", null, 9193, "M_9193", 0, 0),

	M_9194(MiscellaneousTechnical, "⏪", null, 9194, "M_9194", 0, 0),

	M_9195(MiscellaneousTechnical, "⏫", null, 9195, "M_9195", 0, 0),

	M_9196(MiscellaneousTechnical, "⏬", null, 9196, "M_9196", 0, 0),

	M_9197(MiscellaneousTechnical, "⏭", null, 9197, "M_9197", 0, 0),

	M_9198(MiscellaneousTechnical, "⏮", null, 9198, "M_9198", 0, 0),

	M_9199(MiscellaneousTechnical, "⏯", null, 9199, "M_9199", 0, 0),

	M_9200(MiscellaneousTechnical, "⏰", null, 9200, "M_9200", 0, 0),

	M_9201(MiscellaneousTechnical, "⏱", null, 9201, "M_9201", 0, 0),

	M_9202(MiscellaneousTechnical, "⏲", null, 9202, "M_9202", 0, 0),

	M_9203(MiscellaneousTechnical, "⏳", null, 9203, "M_9203", 0, 0),

	M_9204(MiscellaneousTechnical, "⏴", null, 9204, "M_9204", 0, 0),

	M_9205(MiscellaneousTechnical, "⏵", null, 9205, "M_9205", 0, 0),

	M_9206(MiscellaneousTechnical, "⏶", null, 9206, "M_9206", 0, 0),

	M_9207(MiscellaneousTechnical, "⏷", null, 9207, "M_9207", 0, 0),

	M_9208(MiscellaneousTechnical, "⏸", null, 9208, "M_9208", 0, 0),

	M_9209(MiscellaneousTechnical, "⏹", null, 9209, "M_9209", 0, 0),

	M_9210(MiscellaneousTechnical, "⏺", null, 9210, "M_9210", 0, 0),

	M_9211(MiscellaneousTechnical, "⏻", null, 9211, "M_9211", 0, 0),

	M_9212(MiscellaneousTechnical, "⏼", null, 9212, "M_9212", 0, 0),

	M_9213(MiscellaneousTechnical, "⏽", null, 9213, "M_9213", 0, 0),

	M_9214(MiscellaneousTechnical, "⏾", null, 9214, "M_9214", 0, 0),

	M_9215(MiscellaneousTechnical, "⏿", null, 9215, "M_9215", 0, 0),

	// ---------- Geometric Shapes ---

	M_9632(GeometricShapes, "■", null, 9632, "M_9632", 0, 0),

	M_9633(GeometricShapes, "□", null, 9633, "M_9633", 0, 0),

	M_9634(GeometricShapes, "▢", null, 9634, "M_9634", 0, 0),

	M_9635(GeometricShapes, "▣", null, 9635, "M_9635", 0, 0),

	M_9636(GeometricShapes, "▤", null, 9636, "M_9636", 0, 0),

	M_9637(GeometricShapes, "▥", null, 9637, "M_9637", 0, 0),

	M_9638(GeometricShapes, "▦", null, 9638, "M_9638", 0, 0),

	M_9639(GeometricShapes, "▧", null, 9639, "M_9639", 0, 0),

	M_9640(GeometricShapes, "▨", null, 9640, "M_9640", 0, 0),

	M_9641(GeometricShapes, "▩", null, 9641, "M_9641", 0, 0),

	M_9642(GeometricShapes, "▪", null, 9642, "M_9642", 0, 0),

	M_9643(GeometricShapes, "▫", null, 9643, "M_9643", 0, 0),

	M_9644(GeometricShapes, "▬", null, 9644, "M_9644", 0, 0),

	M_9645(GeometricShapes, "▭", null, 9645, "M_9645", 0, 0),

	M_9646(GeometricShapes, "▮", null, 9646, "M_9646", 0, 0),

	M_9647(GeometricShapes, "▯", null, 9647, "M_9647", 0, 0),

	M_9648(GeometricShapes, "▰", null, 9648, "M_9648", 0, 0),

	M_9649(GeometricShapes, "▱", null, 9649, "M_9649", 0, 0),

	M_9650(GeometricShapes, "▲", null, 9650, "M_9650", 0, 0),

	M_9651(GeometricShapes, "△", null, 9651, "M_9651", 0, 0),

	M_9652(GeometricShapes, "▴", null, 9652, "M_9652", 0, 0),

	M_9653(GeometricShapes, "▵", null, 9653, "M_9653", 0, 0),

	M_9654(GeometricShapes, "▶", null, 9654, "M_9654", 0, 0),

	M_9655(GeometricShapes, "▷", null, 9655, "M_9655", 0, 0),

	M_9656(GeometricShapes, "▸", null, 9656, "M_9656", 0, 0),

	M_9657(GeometricShapes, "▹", null, 9657, "M_9657", 0, 0),

	M_9658(GeometricShapes, "►", null, 9658, "M_9658", 0, 0),

	M_9659(GeometricShapes, "▻", null, 9659, "M_9659", 0, 0),

	M_9660(GeometricShapes, "▼", null, 9660, "M_9660", 0, 0),

	M_9661(GeometricShapes, "▽", null, 9661, "M_9661", 0, 0),

	M_9662(GeometricShapes, "▾", null, 9662, "M_9662", 0, 0),

	M_9663(GeometricShapes, "▿", null, 9663, "M_9663", 0, 0),

	M_9664(GeometricShapes, "◀", null, 9664, "M_9664", 0, 0),

	M_9665(GeometricShapes, "◁", null, 9665, "M_9665", 0, 0),

	M_9666(GeometricShapes, "◂", null, 9666, "M_9666", 0, 0),

	M_9667(GeometricShapes, "◃", null, 9667, "M_9667", 0, 0),

	M_9668(GeometricShapes, "◄", null, 9668, "M_9668", 0, 0),

	M_9669(GeometricShapes, "◅", null, 9669, "M_9669", 0, 0),

	M_9670(GeometricShapes, "◆", null, 9670, "M_9670", 0, 0),

	M_9671(GeometricShapes, "◇", null, 9671, "M_9671", 0, 0),

	M_9672(GeometricShapes, "◈", null, 9672, "M_9672", 0, 0),

	M_9673(GeometricShapes, "◉", null, 9673, "M_9673", 0, 0),

	M_9674(GeometricShapes, "◊", null, 9674, "M_9674", 0, 0),

	M_9675(GeometricShapes, "○", null, 9675, "M_9675", 0, 0),

	M_9676(GeometricShapes, "◌", null, 9676, "M_9676", 0, 0),

	M_9677(GeometricShapes, "◍", null, 9677, "M_9677", 0, 0),

	M_9678(GeometricShapes, "◎", null, 9678, "M_9678", 0, 0),

	M_9679(GeometricShapes, "●", null, 9679, "M_9679", 0, 0),

	M_9680(GeometricShapes, "◐", null, 9680, "M_9680", 0, 0),

	M_9681(GeometricShapes, "◑", null, 9681, "M_9681", 0, 0),

	M_9682(GeometricShapes, "◒", null, 9682, "M_9682", 0, 0),

	M_9683(GeometricShapes, "◓", null, 9683, "M_9683", 0, 0),

	M_9684(GeometricShapes, "◔", null, 9684, "M_9684", 0, 0),

	M_9685(GeometricShapes, "◕", null, 9685, "M_9685", 0, 0),

	M_9686(GeometricShapes, "◖", null, 9686, "M_9686", 0, 0),

	M_9687(GeometricShapes, "◗", null, 9687, "M_9687", 0, 0),

	M_9688(GeometricShapes, "◘", null, 9688, "M_9688", 0, 0),

	M_9689(GeometricShapes, "◙", null, 9689, "M_9689", 0, 0),

	M_9690(GeometricShapes, "◚", null, 9690, "M_9690", 0, 0),

	M_9691(GeometricShapes, "◛", null, 9691, "M_9691", 0, 0),

	M_9692(GeometricShapes, "◜", null, 9692, "M_9692", 0, 0),

	M_9693(GeometricShapes, "◝", null, 9693, "M_9693", 0, 0),

	M_9694(GeometricShapes, "◞", null, 9694, "M_9694", 0, 0),

	M_9695(GeometricShapes, "◟", null, 9695, "M_9695", 0, 0),

	M_9696(GeometricShapes, "◠", null, 9696, "M_9696", 0, 0),

	M_9697(GeometricShapes, "◡", null, 9697, "M_9697", 0, 0),

	M_9698(GeometricShapes, "◢", null, 9698, "M_9698", 0, 0),

	M_9699(GeometricShapes, "◣", null, 9699, "M_9699", 0, 0),

	M_9700(GeometricShapes, "◤", null, 9700, "M_9700", 0, 0),

	M_9701(GeometricShapes, "◥", null, 9701, "M_9701", 0, 0),

	M_9702(GeometricShapes, "◦", null, 9702, "M_9702", 0, 0),

	M_9703(GeometricShapes, "◧", null, 9703, "M_9703", 0, 0),

	M_9704(GeometricShapes, "◨", null, 9704, "M_9704", 0, 0),

	M_9705(GeometricShapes, "◩", null, 9705, "M_9705", 0, 0),

	M_9706(GeometricShapes, "◪", null, 9706, "M_9706", 0, 0),

	M_9707(GeometricShapes, "◫", null, 9707, "M_9707", 0, 0),

	M_9708(GeometricShapes, "◬", null, 9708, "M_9708", 0, 0),

	M_9709(GeometricShapes, "◭", null, 9709, "M_9709", 0, 0),

	M_9710(GeometricShapes, "◮", null, 9710, "M_9710", 0, 0),

	M_9711(GeometricShapes, "◯", null, 9711, "M_9711", 0, 0),

	M_9712(GeometricShapes, "◰", null, 9712, "M_9712", 0, 0),

	M_9713(GeometricShapes, "◱", null, 9713, "M_9713", 0, 0),

	M_9714(GeometricShapes, "◲", null, 9714, "M_9714", 0, 0),

	M_9715(GeometricShapes, "◳", null, 9715, "M_9715", 0, 0),

	M_9716(GeometricShapes, "◴", null, 9716, "M_9716", 0, 0),

	M_9717(GeometricShapes, "◵", null, 9717, "M_9717", 0, 0),

	M_9718(GeometricShapes, "◶", null, 9718, "M_9718", 0, 0),

	M_9719(GeometricShapes, "◷", null, 9719, "M_9719", 0, 0),

	M_9720(GeometricShapes, "◸", null, 9720, "M_9720", 0, 0),

	M_9721(GeometricShapes, "◹", null, 9721, "M_9721", 0, 0),

	M_9722(GeometricShapes, "◺", null, 9722, "M_9722", 0, 0),

	M_9723(GeometricShapes, "◻", null, 9723, "M_9723", 0, 0),

	M_9724(GeometricShapes, "◼", null, 9724, "M_9724", 0, 0),

	M_9725(GeometricShapes, "◽", null, 9725, "M_9725", 0, 0),

	M_9726(GeometricShapes, "◾", null, 9726, "M_9726", 0, 0),

	M_9727(GeometricShapes, "◿", null, 9727, "M_9727", 0, 0),

	// ---------- Miscellaneous Symbols and Arrows ---

	M_11008(MiscellaneousSymbolsandArrows, "⬀", null, 11008, "M_11008", 0, 0),

	M_11009(MiscellaneousSymbolsandArrows, "⬁", null, 11009, "M_11009", 0, 0),

	M_11010(MiscellaneousSymbolsandArrows, "⬂", null, 11010, "M_11010", 0, 0),

	M_11011(MiscellaneousSymbolsandArrows, "⬃", null, 11011, "M_11011", 0, 0),

	M_11012(MiscellaneousSymbolsandArrows, "⬄", null, 11012, "M_11012", 0, 0),

	M_11013(MiscellaneousSymbolsandArrows, "⬅", null, 11013, "M_11013", 0, 0),

	M_11014(MiscellaneousSymbolsandArrows, "⬆", null, 11014, "M_11014", 0, 0),

	M_11015(MiscellaneousSymbolsandArrows, "⬇", null, 11015, "M_11015", 0, 0),

	M_11016(MiscellaneousSymbolsandArrows, "⬈", null, 11016, "M_11016", 0, 0),

	M_11017(MiscellaneousSymbolsandArrows, "⬉", null, 11017, "M_11017", 0, 0),

	M_11018(MiscellaneousSymbolsandArrows, "⬊", null, 11018, "M_11018", 0, 0),

	M_11019(MiscellaneousSymbolsandArrows, "⬋", null, 11019, "M_11019", 0, 0),

	M_11020(MiscellaneousSymbolsandArrows, "⬌", null, 11020, "M_11020", 0, 0),

	M_11021(MiscellaneousSymbolsandArrows, "⬍", null, 11021, "M_11021", 0, 0),

	M_11022(MiscellaneousSymbolsandArrows, "⬎", null, 11022, "M_11022", 0, 0),

	M_11023(MiscellaneousSymbolsandArrows, "⬏", null, 11023, "M_11023", 0, 0),

	M_11024(MiscellaneousSymbolsandArrows, "⬐", null, 11024, "M_11024", 0, 0),

	M_11025(MiscellaneousSymbolsandArrows, "⬑", null, 11025, "M_11025", 0, 0),

	M_11026(MiscellaneousSymbolsandArrows, "⬒", null, 11026, "M_11026", 0, 0),

	M_11027(MiscellaneousSymbolsandArrows, "⬓", null, 11027, "M_11027", 0, 0),

	M_11028(MiscellaneousSymbolsandArrows, "⬔", null, 11028, "M_11028", 0, 0),

	M_11029(MiscellaneousSymbolsandArrows, "⬕", null, 11029, "M_11029", 0, 0),

	M_11030(MiscellaneousSymbolsandArrows, "⬖", null, 11030, "M_11030", 0, 0),

	M_11031(MiscellaneousSymbolsandArrows, "⬗", null, 11031, "M_11031", 0, 0),

	M_11032(MiscellaneousSymbolsandArrows, "⬘", null, 11032, "M_11032", 0, 0),

	M_11033(MiscellaneousSymbolsandArrows, "⬙", null, 11033, "M_11033", 0, 0),

	M_11034(MiscellaneousSymbolsandArrows, "⬚", null, 11034, "M_11034", 0, 0),

	M_11035(MiscellaneousSymbolsandArrows, "⬛", null, 11035, "M_11035", 0, 0),

	M_11036(MiscellaneousSymbolsandArrows, "⬜", null, 11036, "M_11036", 0, 0),

	M_11037(MiscellaneousSymbolsandArrows, "⬝", null, 11037, "M_11037", 0, 0),

	M_11038(MiscellaneousSymbolsandArrows, "⬞", null, 11038, "M_11038", 0, 0),

	M_11039(MiscellaneousSymbolsandArrows, "⬟", null, 11039, "M_11039", 0, 0),

	M_11040(MiscellaneousSymbolsandArrows, "⬠", null, 11040, "M_11040", 0, 0),

	M_11041(MiscellaneousSymbolsandArrows, "⬡", null, 11041, "M_11041", 0, 0),

	M_11042(MiscellaneousSymbolsandArrows, "⬢", null, 11042, "M_11042", 0, 0),

	M_11043(MiscellaneousSymbolsandArrows, "⬣", null, 11043, "M_11043", 0, 0),

	M_11044(MiscellaneousSymbolsandArrows, "⬤", null, 11044, "M_11044", 0, 0),

	M_11045(MiscellaneousSymbolsandArrows, "⬥", null, 11045, "M_11045", 0, 0),

	M_11046(MiscellaneousSymbolsandArrows, "⬦", null, 11046, "M_11046", 0, 0),

	M_11047(MiscellaneousSymbolsandArrows, "⬧", null, 11047, "M_11047", 0, 0),

	M_11048(MiscellaneousSymbolsandArrows, "⬨", null, 11048, "M_11048", 0, 0),

	M_11049(MiscellaneousSymbolsandArrows, "⬩", null, 11049, "M_11049", 0, 0),

	M_11050(MiscellaneousSymbolsandArrows, "⬪", null, 11050, "M_11050", 0, 0),

	M_11051(MiscellaneousSymbolsandArrows, "⬫", null, 11051, "M_11051", 0, 0),

	M_11052(MiscellaneousSymbolsandArrows, "⬬", null, 11052, "M_11052", 0, 0),

	M_11053(MiscellaneousSymbolsandArrows, "⬭", null, 11053, "M_11053", 0, 0),

	M_11054(MiscellaneousSymbolsandArrows, "⬮", null, 11054, "M_11054", 0, 0),

	M_11055(MiscellaneousSymbolsandArrows, "⬯", null, 11055, "M_11055", 0, 0),

	M_11056(MiscellaneousSymbolsandArrows, "⬰", null, 11056, "M_11056", 0, 0),

	M_11057(MiscellaneousSymbolsandArrows, "⬱", null, 11057, "M_11057", 0, 0),

	M_11058(MiscellaneousSymbolsandArrows, "⬲", null, 11058, "M_11058", 0, 0),

	M_11059(MiscellaneousSymbolsandArrows, "⬳", null, 11059, "M_11059", 0, 0),

	M_11060(MiscellaneousSymbolsandArrows, "⬴", null, 11060, "M_11060", 0, 0),

	M_11061(MiscellaneousSymbolsandArrows, "⬵", null, 11061, "M_11061", 0, 0),

	M_11062(MiscellaneousSymbolsandArrows, "⬶", null, 11062, "M_11062", 0, 0),

	M_11063(MiscellaneousSymbolsandArrows, "⬷", null, 11063, "M_11063", 0, 0),

	M_11064(MiscellaneousSymbolsandArrows, "⬸", null, 11064, "M_11064", 0, 0),

	M_11065(MiscellaneousSymbolsandArrows, "⬹", null, 11065, "M_11065", 0, 0),

	M_11066(MiscellaneousSymbolsandArrows, "⬺", null, 11066, "M_11066", 0, 0),

	M_11067(MiscellaneousSymbolsandArrows, "⬻", null, 11067, "M_11067", 0, 0),

	M_11068(MiscellaneousSymbolsandArrows, "⬼", null, 11068, "M_11068", 0, 0),

	M_11069(MiscellaneousSymbolsandArrows, "⬽", null, 11069, "M_11069", 0, 0),

	M_11070(MiscellaneousSymbolsandArrows, "⬾", null, 11070, "M_11070", 0, 0),

	M_11071(MiscellaneousSymbolsandArrows, "⬿", null, 11071, "M_11071", 0, 0),

	M_11072(MiscellaneousSymbolsandArrows, "⭀", null, 11072, "M_11072", 0, 0),

	M_11073(MiscellaneousSymbolsandArrows, "⭁", null, 11073, "M_11073", 0, 0),

	M_11074(MiscellaneousSymbolsandArrows, "⭂", null, 11074, "M_11074", 0, 0),

	M_11075(MiscellaneousSymbolsandArrows, "⭃", null, 11075, "M_11075", 0, 0),

	M_11076(MiscellaneousSymbolsandArrows, "⭄", null, 11076, "M_11076", 0, 0),

	M_11077(MiscellaneousSymbolsandArrows, "⭅", null, 11077, "M_11077", 0, 0),

	M_11078(MiscellaneousSymbolsandArrows, "⭆", null, 11078, "M_11078", 0, 0),

	M_11079(MiscellaneousSymbolsandArrows, "⭇", null, 11079, "M_11079", 0, 0),

	M_11080(MiscellaneousSymbolsandArrows, "⭈", null, 11080, "M_11080", 0, 0),

	M_11081(MiscellaneousSymbolsandArrows, "⭉", null, 11081, "M_11081", 0, 0),

	M_11082(MiscellaneousSymbolsandArrows, "⭊", null, 11082, "M_11082", 0, 0),

	M_11083(MiscellaneousSymbolsandArrows, "⭋", null, 11083, "M_11083", 0, 0),

	M_11084(MiscellaneousSymbolsandArrows, "⭌", null, 11084, "M_11084", 0, 0),

	M_11085(MiscellaneousSymbolsandArrows, "⭍", null, 11085, "M_11085", 0, 0),

	M_11086(MiscellaneousSymbolsandArrows, "⭎", null, 11086, "M_11086", 0, 0),

	M_11087(MiscellaneousSymbolsandArrows, "⭏", null, 11087, "M_11087", 0, 0),

	M_11088(MiscellaneousSymbolsandArrows, "⭐", null, 11088, "M_11088", 0, 0),

	M_11089(MiscellaneousSymbolsandArrows, "⭑", null, 11089, "M_11089", 0, 0),

	M_11090(MiscellaneousSymbolsandArrows, "⭒", null, 11090, "M_11090", 0, 0),

	M_11091(MiscellaneousSymbolsandArrows, "⭓", null, 11091, "M_11091", 0, 0),

	M_11092(MiscellaneousSymbolsandArrows, "⭔", null, 11092, "M_11092", 0, 0),

	M_11093(MiscellaneousSymbolsandArrows, "⭕", null, 11093, "M_11093", 0, 0),

	M_11094(MiscellaneousSymbolsandArrows, "⭖", null, 11094, "M_11094", 0, 0),

	M_11095(MiscellaneousSymbolsandArrows, "⭗", null, 11095, "M_11095", 0, 0),

	M_11096(MiscellaneousSymbolsandArrows, "⭘", null, 11096, "M_11096", 0, 0),

	M_11097(MiscellaneousSymbolsandArrows, "⭙", null, 11097, "M_11097", 0, 0),

	M_11098(MiscellaneousSymbolsandArrows, "⭚", null, 11098, "M_11098", 0, 0),

	M_11099(MiscellaneousSymbolsandArrows, "⭛", null, 11099, "M_11099", 0, 0),

	M_11100(MiscellaneousSymbolsandArrows, "⭜", null, 11100, "M_11100", 0, 0),

	M_11101(MiscellaneousSymbolsandArrows, "⭝", null, 11101, "M_11101", 0, 0),

	M_11102(MiscellaneousSymbolsandArrows, "⭞", null, 11102, "M_11102", 0, 0),

	M_11103(MiscellaneousSymbolsandArrows, "⭟", null, 11103, "M_11103", 0, 0),

	M_11104(MiscellaneousSymbolsandArrows, "⭠", null, 11104, "M_11104", 0, 0),

	M_11105(MiscellaneousSymbolsandArrows, "⭡", null, 11105, "M_11105", 0, 0),

	M_11106(MiscellaneousSymbolsandArrows, "⭢", null, 11106, "M_11106", 0, 0),

	M_11107(MiscellaneousSymbolsandArrows, "⭣", null, 11107, "M_11107", 0, 0),

	M_11108(MiscellaneousSymbolsandArrows, "⭤", null, 11108, "M_11108", 0, 0),

	M_11109(MiscellaneousSymbolsandArrows, "⭥", null, 11109, "M_11109", 0, 0),

	M_11110(MiscellaneousSymbolsandArrows, "⭦", null, 11110, "M_11110", 0, 0),

	M_11111(MiscellaneousSymbolsandArrows, "⭧", null, 11111, "M_11111", 0, 0),

	M_11112(MiscellaneousSymbolsandArrows, "⭨", null, 11112, "M_11112", 0, 0),

	M_11113(MiscellaneousSymbolsandArrows, "⭩", null, 11113, "M_11113", 0, 0),

	M_11114(MiscellaneousSymbolsandArrows, "⭪", null, 11114, "M_11114", 0, 0),

	M_11115(MiscellaneousSymbolsandArrows, "⭫", null, 11115, "M_11115", 0, 0),

	M_11116(MiscellaneousSymbolsandArrows, "⭬", null, 11116, "M_11116", 0, 0),

	M_11117(MiscellaneousSymbolsandArrows, "⭭", null, 11117, "M_11117", 0, 0),

	M_11118(MiscellaneousSymbolsandArrows, "⭮", null, 11118, "M_11118", 0, 0),

	M_11119(MiscellaneousSymbolsandArrows, "⭯", null, 11119, "M_11119", 0, 0),

	M_11120(MiscellaneousSymbolsandArrows, "⭰", null, 11120, "M_11120", 0, 0),

	M_11121(MiscellaneousSymbolsandArrows, "⭱", null, 11121, "M_11121", 0, 0),

	M_11122(MiscellaneousSymbolsandArrows, "⭲", null, 11122, "M_11122", 0, 0),

	M_11123(MiscellaneousSymbolsandArrows, "⭳", null, 11123, "M_11123", 0, 0),

	M_11124(MiscellaneousSymbolsandArrows, "⭴", null, 11124, "M_11124", 0, 0),

	M_11125(MiscellaneousSymbolsandArrows, "⭵", null, 11125, "M_11125", 0, 0),

	M_11126(MiscellaneousSymbolsandArrows, "⭶", null, 11126, "M_11126", 0, 0),

	M_11127(MiscellaneousSymbolsandArrows, "⭷", null, 11127, "M_11127", 0, 0),

	M_11128(MiscellaneousSymbolsandArrows, "⭸", null, 11128, "M_11128", 0, 0),

	M_11129(MiscellaneousSymbolsandArrows, "⭹", null, 11129, "M_11129", 0, 0),

	M_11130(MiscellaneousSymbolsandArrows, "⭺", null, 11130, "M_11130", 0, 0),

	M_11131(MiscellaneousSymbolsandArrows, "⭻", null, 11131, "M_11131", 0, 0),

	M_11132(MiscellaneousSymbolsandArrows, "⭼", null, 11132, "M_11132", 0, 0),

	M_11133(MiscellaneousSymbolsandArrows, "⭽", null, 11133, "M_11133", 0, 0),

	M_11134(MiscellaneousSymbolsandArrows, "⭾", null, 11134, "M_11134", 0, 0),

	M_11135(MiscellaneousSymbolsandArrows, "⭿", null, 11135, "M_11135", 0, 0),

	M_11136(MiscellaneousSymbolsandArrows, "⮀", null, 11136, "M_11136", 0, 0),

	M_11137(MiscellaneousSymbolsandArrows, "⮁", null, 11137, "M_11137", 0, 0),

	M_11138(MiscellaneousSymbolsandArrows, "⮂", null, 11138, "M_11138", 0, 0),

	M_11139(MiscellaneousSymbolsandArrows, "⮃", null, 11139, "M_11139", 0, 0),

	M_11140(MiscellaneousSymbolsandArrows, "⮄", null, 11140, "M_11140", 0, 0),

	M_11141(MiscellaneousSymbolsandArrows, "⮅", null, 11141, "M_11141", 0, 0),

	M_11142(MiscellaneousSymbolsandArrows, "⮆", null, 11142, "M_11142", 0, 0),

	M_11143(MiscellaneousSymbolsandArrows, "⮇", null, 11143, "M_11143", 0, 0),

	M_11144(MiscellaneousSymbolsandArrows, "⮈", null, 11144, "M_11144", 0, 0),

	M_11145(MiscellaneousSymbolsandArrows, "⮉", null, 11145, "M_11145", 0, 0),

	M_11146(MiscellaneousSymbolsandArrows, "⮊", null, 11146, "M_11146", 0, 0),

	M_11147(MiscellaneousSymbolsandArrows, "⮋", null, 11147, "M_11147", 0, 0),

	M_11148(MiscellaneousSymbolsandArrows, "⮌", null, 11148, "M_11148", 0, 0),

	M_11149(MiscellaneousSymbolsandArrows, "⮍", null, 11149, "M_11149", 0, 0),

	M_11150(MiscellaneousSymbolsandArrows, "⮎", null, 11150, "M_11150", 0, 0),

	M_11151(MiscellaneousSymbolsandArrows, "⮏", null, 11151, "M_11151", 0, 0),

	M_11152(MiscellaneousSymbolsandArrows, "⮐", null, 11152, "M_11152", 0, 0),

	M_11153(MiscellaneousSymbolsandArrows, "⮑", null, 11153, "M_11153", 0, 0),

	M_11154(MiscellaneousSymbolsandArrows, "⮒", null, 11154, "M_11154", 0, 0),

	M_11155(MiscellaneousSymbolsandArrows, "⮓", null, 11155, "M_11155", 0, 0),

	M_11156(MiscellaneousSymbolsandArrows, "⮔", null, 11156, "M_11156", 0, 0),

	M_11157(MiscellaneousSymbolsandArrows, "⮕", null, 11157, "M_11157", 0, 0),

	M_11158(MiscellaneousSymbolsandArrows, "⮖", null, 11158, "M_11158", 0, 0),

	M_11159(MiscellaneousSymbolsandArrows, "⮗", null, 11159, "M_11159", 0, 0),

	M_11160(MiscellaneousSymbolsandArrows, "⮘", null, 11160, "M_11160", 0, 0),

	M_11161(MiscellaneousSymbolsandArrows, "⮙", null, 11161, "M_11161", 0, 0),

	M_11162(MiscellaneousSymbolsandArrows, "⮚", null, 11162, "M_11162", 0, 0),

	M_11163(MiscellaneousSymbolsandArrows, "⮛", null, 11163, "M_11163", 0, 0),

	M_11164(MiscellaneousSymbolsandArrows, "⮜", null, 11164, "M_11164", 0, 0),

	M_11165(MiscellaneousSymbolsandArrows, "⮝", null, 11165, "M_11165", 0, 0),

	M_11166(MiscellaneousSymbolsandArrows, "⮞", null, 11166, "M_11166", 0, 0),

	M_11167(MiscellaneousSymbolsandArrows, "⮟", null, 11167, "M_11167", 0, 0),

	M_11168(MiscellaneousSymbolsandArrows, "⮠", null, 11168, "M_11168", 0, 0),

	M_11169(MiscellaneousSymbolsandArrows, "⮡", null, 11169, "M_11169", 0, 0),

	M_11170(MiscellaneousSymbolsandArrows, "⮢", null, 11170, "M_11170", 0, 0),

	M_11171(MiscellaneousSymbolsandArrows, "⮣", null, 11171, "M_11171", 0, 0),

	M_11172(MiscellaneousSymbolsandArrows, "⮤", null, 11172, "M_11172", 0, 0),

	M_11173(MiscellaneousSymbolsandArrows, "⮥", null, 11173, "M_11173", 0, 0),

	M_11174(MiscellaneousSymbolsandArrows, "⮦", null, 11174, "M_11174", 0, 0),

	M_11175(MiscellaneousSymbolsandArrows, "⮧", null, 11175, "M_11175", 0, 0),

	M_11176(MiscellaneousSymbolsandArrows, "⮨", null, 11176, "M_11176", 0, 0),

	M_11177(MiscellaneousSymbolsandArrows, "⮩", null, 11177, "M_11177", 0, 0),

	M_11178(MiscellaneousSymbolsandArrows, "⮪", null, 11178, "M_11178", 0, 0),

	M_11179(MiscellaneousSymbolsandArrows, "⮫", null, 11179, "M_11179", 0, 0),

	M_11180(MiscellaneousSymbolsandArrows, "⮬", null, 11180, "M_11180", 0, 0),

	M_11181(MiscellaneousSymbolsandArrows, "⮭", null, 11181, "M_11181", 0, 0),

	M_11182(MiscellaneousSymbolsandArrows, "⮮", null, 11182, "M_11182", 0, 0),

	M_11183(MiscellaneousSymbolsandArrows, "⮯", null, 11183, "M_11183", 0, 0),

	M_11184(MiscellaneousSymbolsandArrows, "⮰", null, 11184, "M_11184", 0, 0),

	M_11185(MiscellaneousSymbolsandArrows, "⮱", null, 11185, "M_11185", 0, 0),

	M_11186(MiscellaneousSymbolsandArrows, "⮲", null, 11186, "M_11186", 0, 0),

	M_11187(MiscellaneousSymbolsandArrows, "⮳", null, 11187, "M_11187", 0, 0),

	M_11188(MiscellaneousSymbolsandArrows, "⮴", null, 11188, "M_11188", 0, 0),

	M_11189(MiscellaneousSymbolsandArrows, "⮵", null, 11189, "M_11189", 0, 0),

	M_11190(MiscellaneousSymbolsandArrows, "⮶", null, 11190, "M_11190", 0, 0),

	M_11191(MiscellaneousSymbolsandArrows, "⮷", null, 11191, "M_11191", 0, 0),

	M_11192(MiscellaneousSymbolsandArrows, "⮸", null, 11192, "M_11192", 0, 0),

	M_11193(MiscellaneousSymbolsandArrows, "⮹", null, 11193, "M_11193", 0, 0),

	M_11194(MiscellaneousSymbolsandArrows, "⮺", null, 11194, "M_11194", 0, 0),

	M_11195(MiscellaneousSymbolsandArrows, "⮻", null, 11195, "M_11195", 0, 0),

	M_11196(MiscellaneousSymbolsandArrows, "⮼", null, 11196, "M_11196", 0, 0),

	M_11197(MiscellaneousSymbolsandArrows, "⮽", null, 11197, "M_11197", 0, 0),

	M_11198(MiscellaneousSymbolsandArrows, "⮾", null, 11198, "M_11198", 0, 0),

	M_11199(MiscellaneousSymbolsandArrows, "⮿", null, 11199, "M_11199", 0, 0),

	M_11200(MiscellaneousSymbolsandArrows, "⯀", null, 11200, "M_11200", 0, 0),

	M_11201(MiscellaneousSymbolsandArrows, "⯁", null, 11201, "M_11201", 0, 0),

	M_11202(MiscellaneousSymbolsandArrows, "⯂", null, 11202, "M_11202", 0, 0),

	M_11203(MiscellaneousSymbolsandArrows, "⯃", null, 11203, "M_11203", 0, 0),

	M_11204(MiscellaneousSymbolsandArrows, "⯄", null, 11204, "M_11204", 0, 0),

	M_11205(MiscellaneousSymbolsandArrows, "⯅", null, 11205, "M_11205", 0, 0),

	M_11206(MiscellaneousSymbolsandArrows, "⯆", null, 11206, "M_11206", 0, 0),

	M_11207(MiscellaneousSymbolsandArrows, "⯇", null, 11207, "M_11207", 0, 0),

	M_11208(MiscellaneousSymbolsandArrows, "⯈", null, 11208, "M_11208", 0, 0),

	M_11209(MiscellaneousSymbolsandArrows, "⯉", null, 11209, "M_11209", 0, 0),

	M_11210(MiscellaneousSymbolsandArrows, "⯊", null, 11210, "M_11210", 0, 0),

	M_11211(MiscellaneousSymbolsandArrows, "⯋", null, 11211, "M_11211", 0, 0),

	M_11212(MiscellaneousSymbolsandArrows, "⯌", null, 11212, "M_11212", 0, 0),

	M_11213(MiscellaneousSymbolsandArrows, "⯍", null, 11213, "M_11213", 0, 0),

	M_11214(MiscellaneousSymbolsandArrows, "⯎", null, 11214, "M_11214", 0, 0),

	M_11215(MiscellaneousSymbolsandArrows, "⯏", null, 11215, "M_11215", 0, 0),

	M_11216(MiscellaneousSymbolsandArrows, "⯐", null, 11216, "M_11216", 0, 0),

	M_11217(MiscellaneousSymbolsandArrows, "⯑", null, 11217, "M_11217", 0, 0),

	M_11218(MiscellaneousSymbolsandArrows, "⯒", null, 11218, "M_11218", 0, 0),

	M_11219(MiscellaneousSymbolsandArrows, "⯓", null, 11219, "M_11219", 0, 0),

	M_11220(MiscellaneousSymbolsandArrows, "⯔", null, 11220, "M_11220", 0, 0),

	M_11221(MiscellaneousSymbolsandArrows, "⯕", null, 11221, "M_11221", 0, 0),

	M_11222(MiscellaneousSymbolsandArrows, "⯖", null, 11222, "M_11222", 0, 0),

	M_11223(MiscellaneousSymbolsandArrows, "⯗", null, 11223, "M_11223", 0, 0),

	M_11224(MiscellaneousSymbolsandArrows, "⯘", null, 11224, "M_11224", 0, 0),

	M_11225(MiscellaneousSymbolsandArrows, "⯙", null, 11225, "M_11225", 0, 0),

	M_11226(MiscellaneousSymbolsandArrows, "⯚", null, 11226, "M_11226", 0, 0),

	M_11227(MiscellaneousSymbolsandArrows, "⯛", null, 11227, "M_11227", 0, 0),

	M_11228(MiscellaneousSymbolsandArrows, "⯜", null, 11228, "M_11228", 0, 0),

	M_11229(MiscellaneousSymbolsandArrows, "⯝", null, 11229, "M_11229", 0, 0),

	M_11230(MiscellaneousSymbolsandArrows, "⯞", null, 11230, "M_11230", 0, 0),

	M_11231(MiscellaneousSymbolsandArrows, "⯟", null, 11231, "M_11231", 0, 0),

	M_11232(MiscellaneousSymbolsandArrows, "⯠", null, 11232, "M_11232", 0, 0),

	M_11233(MiscellaneousSymbolsandArrows, "⯡", null, 11233, "M_11233", 0, 0),

	M_11234(MiscellaneousSymbolsandArrows, "⯢", null, 11234, "M_11234", 0, 0),

	M_11235(MiscellaneousSymbolsandArrows, "⯣", null, 11235, "M_11235", 0, 0),

	M_11236(MiscellaneousSymbolsandArrows, "⯤", null, 11236, "M_11236", 0, 0),

	M_11237(MiscellaneousSymbolsandArrows, "⯥", null, 11237, "M_11237", 0, 0),

	M_11238(MiscellaneousSymbolsandArrows, "⯦", null, 11238, "M_11238", 0, 0),

	M_11239(MiscellaneousSymbolsandArrows, "⯧", null, 11239, "M_11239", 0, 0),

	M_11240(MiscellaneousSymbolsandArrows, "⯨", null, 11240, "M_11240", 0, 0),

	M_11241(MiscellaneousSymbolsandArrows, "⯩", null, 11241, "M_11241", 0, 0),

	M_11242(MiscellaneousSymbolsandArrows, "⯪", null, 11242, "M_11242", 0, 0),

	M_11243(MiscellaneousSymbolsandArrows, "⯫", null, 11243, "M_11243", 0, 0),

	M_11244(MiscellaneousSymbolsandArrows, "⯬", null, 11244, "M_11244", 0, 0),

	M_11245(MiscellaneousSymbolsandArrows, "⯭", null, 11245, "M_11245", 0, 0),

	M_11246(MiscellaneousSymbolsandArrows, "⯮", null, 11246, "M_11246", 0, 0),

	M_11247(MiscellaneousSymbolsandArrows, "⯯", null, 11247, "M_11247", 0, 0),

	M_11248(MiscellaneousSymbolsandArrows, "⯰", null, 11248, "M_11248", 0, 0),

	M_11249(MiscellaneousSymbolsandArrows, "⯱", null, 11249, "M_11249", 0, 0),

	M_11250(MiscellaneousSymbolsandArrows, "⯲", null, 11250, "M_11250", 0, 0),

	M_11251(MiscellaneousSymbolsandArrows, "⯳", null, 11251, "M_11251", 0, 0),

	M_11252(MiscellaneousSymbolsandArrows, "⯴", null, 11252, "M_11252", 0, 0),

	M_11253(MiscellaneousSymbolsandArrows, "⯵", null, 11253, "M_11253", 0, 0),

	M_11254(MiscellaneousSymbolsandArrows, "⯶", null, 11254, "M_11254", 0, 0),

	M_11255(MiscellaneousSymbolsandArrows, "⯷", null, 11255, "M_11255", 0, 0),

	M_11256(MiscellaneousSymbolsandArrows, "⯸", null, 11256, "M_11256", 0, 0),

	M_11257(MiscellaneousSymbolsandArrows, "⯹", null, 11257, "M_11257", 0, 0),

	M_11258(MiscellaneousSymbolsandArrows, "⯺", null, 11258, "M_11258", 0, 0),

	M_11259(MiscellaneousSymbolsandArrows, "⯻", null, 11259, "M_11259", 0, 0),

	M_11260(MiscellaneousSymbolsandArrows, "⯼", null, 11260, "M_11260", 0, 0),

	M_11261(MiscellaneousSymbolsandArrows, "⯽", null, 11261, "M_11261", 0, 0),

	M_11262(MiscellaneousSymbolsandArrows, "⯾", null, 11262, "M_11262", 0, 0),

	M_11263(MiscellaneousSymbolsandArrows, "⯿", null, 11263, "M_11263", 0, 0),

	// ---------- Arrows ---

	M_8592(Arrows, "←", null, 8592, "M_8592", 0, 0),

	M_8593(Arrows, "↑", null, 8593, "M_8593", 0, 0),

	M_8594(Arrows, "→", null, 8594, "M_8594", 0, 0),

	M_8595(Arrows, "↓", null, 8595, "M_8595", 0, 0),

	M_8596(Arrows, "↔", null, 8596, "M_8596", 0, 0),

	M_8597(Arrows, "↕", null, 8597, "M_8597", 0, 0),

	M_8598(Arrows, "↖", null, 8598, "M_8598", 0, 0),

	M_8599(Arrows, "↗", null, 8599, "M_8599", 0, 0),

	M_8600(Arrows, "↘", null, 8600, "M_8600", 0, 0),

	M_8601(Arrows, "↙", null, 8601, "M_8601", 0, 0),

	M_8602(Arrows, "↚", null, 8602, "M_8602", 0, 0),

	M_8603(Arrows, "↛", null, 8603, "M_8603", 0, 0),

	M_8604(Arrows, "↜", null, 8604, "M_8604", 0, 0),

	M_8605(Arrows, "↝", null, 8605, "M_8605", 0, 0),

	M_8606(Arrows, "↞", null, 8606, "M_8606", 0, 0),

	M_8607(Arrows, "↟", null, 8607, "M_8607", 0, 0),

	M_8608(Arrows, "↠", null, 8608, "M_8608", 0, 0),

	M_8609(Arrows, "↡", null, 8609, "M_8609", 0, 0),

	M_8610(Arrows, "↢", null, 8610, "M_8610", 0, 0),

	M_8611(Arrows, "↣", null, 8611, "M_8611", 0, 0),

	M_8612(Arrows, "↤", null, 8612, "M_8612", 0, 0),

	M_8613(Arrows, "↥", null, 8613, "M_8613", 0, 0),

	M_8614(Arrows, "↦", null, 8614, "M_8614", 0, 0),

	M_8615(Arrows, "↧", null, 8615, "M_8615", 0, 0),

	M_8616(Arrows, "↨", null, 8616, "M_8616", 0, 0),

	M_8617(Arrows, "↩", null, 8617, "M_8617", 0, 0),

	M_8618(Arrows, "↪", null, 8618, "M_8618", 0, 0),

	M_8619(Arrows, "↫", null, 8619, "M_8619", 0, 0),

	M_8620(Arrows, "↬", null, 8620, "M_8620", 0, 0),

	M_8621(Arrows, "↭", null, 8621, "M_8621", 0, 0),

	M_8622(Arrows, "↮", null, 8622, "M_8622", 0, 0),

	M_8623(Arrows, "↯", null, 8623, "M_8623", 0, 0),

	M_8624(Arrows, "↰", null, 8624, "M_8624", 0, 0),

	M_8625(Arrows, "↱", null, 8625, "M_8625", 0, 0),

	M_8626(Arrows, "↲", null, 8626, "M_8626", 0, 0),

	M_8627(Arrows, "↳", null, 8627, "M_8627", 0, 0),

	M_8628(Arrows, "↴", null, 8628, "M_8628", 0, 0),

	M_8629(Arrows, "↵", null, 8629, "M_8629", 0, 0),

	M_8630(Arrows, "↶", null, 8630, "M_8630", 0, 0),

	M_8631(Arrows, "↷", null, 8631, "M_8631", 0, 0),

	M_8632(Arrows, "↸", null, 8632, "M_8632", 0, 0),

	M_8633(Arrows, "↹", null, 8633, "M_8633", 0, 0),

	M_8634(Arrows, "↺", null, 8634, "M_8634", 0, 0),

	M_8635(Arrows, "↻", null, 8635, "M_8635", 0, 0),

	M_8636(Arrows, "↼", null, 8636, "M_8636", 0, 0),

	M_8637(Arrows, "↽", null, 8637, "M_8637", 0, 0),

	M_8638(Arrows, "↾", null, 8638, "M_8638", 0, 0),

	M_8639(Arrows, "↿", null, 8639, "M_8639", 0, 0),

	M_8640(Arrows, "⇀", null, 8640, "M_8640", 0, 0),

	M_8641(Arrows, "⇁", null, 8641, "M_8641", 0, 0),

	M_8642(Arrows, "⇂", null, 8642, "M_8642", 0, 0),

	M_8643(Arrows, "⇃", null, 8643, "M_8643", 0, 0),

	M_8644(Arrows, "⇄", null, 8644, "M_8644", 0, 0),

	M_8645(Arrows, "⇅", null, 8645, "M_8645", 0, 0),

	M_8646(Arrows, "⇆", null, 8646, "M_8646", 0, 0),

	M_8647(Arrows, "⇇", null, 8647, "M_8647", 0, 0),

	M_8648(Arrows, "⇈", null, 8648, "M_8648", 0, 0),

	M_8649(Arrows, "⇉", null, 8649, "M_8649", 0, 0),

	M_8650(Arrows, "⇊", null, 8650, "M_8650", 0, 0),

	M_8651(Arrows, "⇋", null, 8651, "M_8651", 0, 0),

	M_8652(Arrows, "⇌", null, 8652, "M_8652", 0, 0),

	M_8653(Arrows, "⇍", null, 8653, "M_8653", 0, 0),

	M_8654(Arrows, "⇎", null, 8654, "M_8654", 0, 0),

	M_8655(Arrows, "⇏", null, 8655, "M_8655", 0, 0),

	M_8656(Arrows, "⇐", null, 8656, "M_8656", 0, 0),

	M_8657(Arrows, "⇑", null, 8657, "M_8657", 0, 0),

	M_8658(Arrows, "⇒", null, 8658, "M_8658", 0, 0),

	M_8659(Arrows, "⇓", null, 8659, "M_8659", 0, 0),

	M_8660(Arrows, "⇔", null, 8660, "M_8660", 0, 0),

	M_8661(Arrows, "⇕", null, 8661, "M_8661", 0, 0),

	M_8662(Arrows, "⇖", null, 8662, "M_8662", 0, 0),

	M_8663(Arrows, "⇗", null, 8663, "M_8663", 0, 0),

	M_8664(Arrows, "⇘", null, 8664, "M_8664", 0, 0),

	M_8665(Arrows, "⇙", null, 8665, "M_8665", 0, 0),

	M_8666(Arrows, "⇚", null, 8666, "M_8666", 0, 0),

	M_8667(Arrows, "⇛", null, 8667, "M_8667", 0, 0),

	M_8668(Arrows, "⇜", null, 8668, "M_8668", 0, 0),

	M_8669(Arrows, "⇝", null, 8669, "M_8669", 0, 0),

	M_8670(Arrows, "⇞", null, 8670, "M_8670", 0, 0),

	M_8671(Arrows, "⇟", null, 8671, "M_8671", 0, 0),

	M_8672(Arrows, "⇠", null, 8672, "M_8672", 0, 0),

	M_8673(Arrows, "⇡", null, 8673, "M_8673", 0, 0),

	M_8674(Arrows, "⇢", null, 8674, "M_8674", 0, 0),

	M_8675(Arrows, "⇣", null, 8675, "M_8675", 0, 0),

	M_8676(Arrows, "⇤", null, 8676, "M_8676", 0, 0),

	M_8677(Arrows, "⇥", null, 8677, "M_8677", 0, 0),

	M_8678(Arrows, "⇦", null, 8678, "M_8678", 0, 0),

	M_8679(Arrows, "⇧", null, 8679, "M_8679", 0, 0),

	M_8680(Arrows, "⇨", null, 8680, "M_8680", 0, 0),

	M_8681(Arrows, "⇩", null, 8681, "M_8681", 0, 0),

	M_8682(Arrows, "⇪", null, 8682, "M_8682", 0, 0),

	M_8683(Arrows, "⇫", null, 8683, "M_8683", 0, 0),

	M_8684(Arrows, "⇬", null, 8684, "M_8684", 0, 0),

	M_8685(Arrows, "⇭", null, 8685, "M_8685", 0, 0),

	M_8686(Arrows, "⇮", null, 8686, "M_8686", 0, 0),

	M_8687(Arrows, "⇯", null, 8687, "M_8687", 0, 0),

	M_8688(Arrows, "⇰", null, 8688, "M_8688", 0, 0),

	M_8689(Arrows, "⇱", null, 8689, "M_8689", 0, 0),

	M_8690(Arrows, "⇲", null, 8690, "M_8690", 0, 0),

	M_8691(Arrows, "⇳", null, 8691, "M_8691", 0, 0),

	M_8692(Arrows, "⇴", null, 8692, "M_8692", 0, 0),

	M_8693(Arrows, "⇵", null, 8693, "M_8693", 0, 0),

	M_8694(Arrows, "⇶", null, 8694, "M_8694", 0, 0),

	M_8695(Arrows, "⇷", null, 8695, "M_8695", 0, 0),

	M_8696(Arrows, "⇸", null, 8696, "M_8696", 0, 0),

	M_8697(Arrows, "⇹", null, 8697, "M_8697", 0, 0),

	M_8698(Arrows, "⇺", null, 8698, "M_8698", 0, 0),

	M_8699(Arrows, "⇻", null, 8699, "M_8699", 0, 0),

	M_8700(Arrows, "⇼", null, 8700, "M_8700", 0, 0),

	M_8701(Arrows, "⇽", null, 8701, "M_8701", 0, 0),

	M_8702(Arrows, "⇾", null, 8702, "M_8702", 0, 0),

	M_8703(Arrows, "⇿", null, 8703, "M_8703", 0, 0),

	// ---------- Supplemental Arrows-A ---

	M_10224(SupplementalArrows_A, "⟰", null, 10224, "M_10224", 0, 0),

	M_10225(SupplementalArrows_A, "⟱", null, 10225, "M_10225", 0, 0),

	M_10226(SupplementalArrows_A, "⟲", null, 10226, "M_10226", 0, 0),

	M_10227(SupplementalArrows_A, "⟳", null, 10227, "M_10227", 0, 0),

	M_10228(SupplementalArrows_A, "⟴", null, 10228, "M_10228", 0, 0),

	M_10229(SupplementalArrows_A, "⟵", null, 10229, "M_10229", 0, 0),

	M_10230(SupplementalArrows_A, "⟶", null, 10230, "M_10230", 0, 0),

	M_10231(SupplementalArrows_A, "⟷", null, 10231, "M_10231", 0, 0),

	M_10232(SupplementalArrows_A, "⟸", null, 10232, "M_10232", 0, 0),

	M_10233(SupplementalArrows_A, "⟹", null, 10233, "M_10233", 0, 0),

	M_10234(SupplementalArrows_A, "⟺", null, 10234, "M_10234", 0, 0),

	M_10235(SupplementalArrows_A, "⟻", null, 10235, "M_10235", 0, 0),

	M_10236(SupplementalArrows_A, "⟼", null, 10236, "M_10236", 0, 0),

	M_10237(SupplementalArrows_A, "⟽", null, 10237, "M_10237", 0, 0),

	M_10238(SupplementalArrows_A, "⟾", null, 10238, "M_10238", 0, 0),

	M_10239(SupplementalArrows_A, "⟿", null, 10239, "M_10239", 0, 0),

	// ---------- Supplemental Arrows-B ---

	M_10496(SupplementalArrows_B, "⤀", null, 10496, "M_10496", 0, 0),

	M_10497(SupplementalArrows_B, "⤁", null, 10497, "M_10497", 0, 0),

	M_10498(SupplementalArrows_B, "⤂", null, 10498, "M_10498", 0, 0),

	M_10499(SupplementalArrows_B, "⤃", null, 10499, "M_10499", 0, 0),

	M_10500(SupplementalArrows_B, "⤄", null, 10500, "M_10500", 0, 0),

	M_10501(SupplementalArrows_B, "⤅", null, 10501, "M_10501", 0, 0),

	M_10502(SupplementalArrows_B, "⤆", null, 10502, "M_10502", 0, 0),

	M_10503(SupplementalArrows_B, "⤇", null, 10503, "M_10503", 0, 0),

	M_10504(SupplementalArrows_B, "⤈", null, 10504, "M_10504", 0, 0),

	M_10505(SupplementalArrows_B, "⤉", null, 10505, "M_10505", 0, 0),

	M_10506(SupplementalArrows_B, "⤊", null, 10506, "M_10506", 0, 0),

	M_10507(SupplementalArrows_B, "⤋", null, 10507, "M_10507", 0, 0),

	M_10508(SupplementalArrows_B, "⤌", null, 10508, "M_10508", 0, 0),

	M_10509(SupplementalArrows_B, "⤍", null, 10509, "M_10509", 0, 0),

	M_10510(SupplementalArrows_B, "⤎", null, 10510, "M_10510", 0, 0),

	M_10511(SupplementalArrows_B, "⤏", null, 10511, "M_10511", 0, 0),

	M_10512(SupplementalArrows_B, "⤐", null, 10512, "M_10512", 0, 0),

	M_10513(SupplementalArrows_B, "⤑", null, 10513, "M_10513", 0, 0),

	M_10514(SupplementalArrows_B, "⤒", null, 10514, "M_10514", 0, 0),

	M_10515(SupplementalArrows_B, "⤓", null, 10515, "M_10515", 0, 0),

	M_10516(SupplementalArrows_B, "⤔", null, 10516, "M_10516", 0, 0),

	M_10517(SupplementalArrows_B, "⤕", null, 10517, "M_10517", 0, 0),

	M_10518(SupplementalArrows_B, "⤖", null, 10518, "M_10518", 0, 0),

	M_10519(SupplementalArrows_B, "⤗", null, 10519, "M_10519", 0, 0),

	M_10520(SupplementalArrows_B, "⤘", null, 10520, "M_10520", 0, 0),

	M_10521(SupplementalArrows_B, "⤙", null, 10521, "M_10521", 0, 0),

	M_10522(SupplementalArrows_B, "⤚", null, 10522, "M_10522", 0, 0),

	M_10523(SupplementalArrows_B, "⤛", null, 10523, "M_10523", 0, 0),

	M_10524(SupplementalArrows_B, "⤜", null, 10524, "M_10524", 0, 0),

	M_10525(SupplementalArrows_B, "⤝", null, 10525, "M_10525", 0, 0),

	M_10526(SupplementalArrows_B, "⤞", null, 10526, "M_10526", 0, 0),

	M_10527(SupplementalArrows_B, "⤟", null, 10527, "M_10527", 0, 0),

	M_10528(SupplementalArrows_B, "⤠", null, 10528, "M_10528", 0, 0),

	M_10529(SupplementalArrows_B, "⤡", null, 10529, "M_10529", 0, 0),

	M_10530(SupplementalArrows_B, "⤢", null, 10530, "M_10530", 0, 0),

	M_10531(SupplementalArrows_B, "⤣", null, 10531, "M_10531", 0, 0),

	M_10532(SupplementalArrows_B, "⤤", null, 10532, "M_10532", 0, 0),

	M_10533(SupplementalArrows_B, "⤥", null, 10533, "M_10533", 0, 0),

	M_10534(SupplementalArrows_B, "⤦", null, 10534, "M_10534", 0, 0),

	M_10535(SupplementalArrows_B, "⤧", null, 10535, "M_10535", 0, 0),

	M_10536(SupplementalArrows_B, "⤨", null, 10536, "M_10536", 0, 0),

	M_10537(SupplementalArrows_B, "⤩", null, 10537, "M_10537", 0, 0),

	M_10538(SupplementalArrows_B, "⤪", null, 10538, "M_10538", 0, 0),

	M_10539(SupplementalArrows_B, "⤫", null, 10539, "M_10539", 0, 0),

	M_10540(SupplementalArrows_B, "⤬", null, 10540, "M_10540", 0, 0),

	M_10541(SupplementalArrows_B, "⤭", null, 10541, "M_10541", 0, 0),

	M_10542(SupplementalArrows_B, "⤮", null, 10542, "M_10542", 0, 0),

	M_10543(SupplementalArrows_B, "⤯", null, 10543, "M_10543", 0, 0),

	M_10544(SupplementalArrows_B, "⤰", null, 10544, "M_10544", 0, 0),

	M_10545(SupplementalArrows_B, "⤱", null, 10545, "M_10545", 0, 0),

	M_10546(SupplementalArrows_B, "⤲", null, 10546, "M_10546", 0, 0),

	M_10547(SupplementalArrows_B, "⤳", null, 10547, "M_10547", 0, 0),

	M_10548(SupplementalArrows_B, "⤴", null, 10548, "M_10548", 0, 0),

	M_10549(SupplementalArrows_B, "⤵", null, 10549, "M_10549", 0, 0),

	M_10550(SupplementalArrows_B, "⤶", null, 10550, "M_10550", 0, 0),

	M_10551(SupplementalArrows_B, "⤷", null, 10551, "M_10551", 0, 0),

	M_10552(SupplementalArrows_B, "⤸", null, 10552, "M_10552", 0, 0),

	M_10553(SupplementalArrows_B, "⤹", null, 10553, "M_10553", 0, 0),

	M_10554(SupplementalArrows_B, "⤺", null, 10554, "M_10554", 0, 0),

	M_10555(SupplementalArrows_B, "⤻", null, 10555, "M_10555", 0, 0),

	M_10556(SupplementalArrows_B, "⤼", null, 10556, "M_10556", 0, 0),

	M_10557(SupplementalArrows_B, "⤽", null, 10557, "M_10557", 0, 0),

	M_10558(SupplementalArrows_B, "⤾", null, 10558, "M_10558", 0, 0),

	M_10559(SupplementalArrows_B, "⤿", null, 10559, "M_10559", 0, 0),

	M_10560(SupplementalArrows_B, "⥀", null, 10560, "M_10560", 0, 0),

	M_10561(SupplementalArrows_B, "⥁", null, 10561, "M_10561", 0, 0),

	M_10562(SupplementalArrows_B, "⥂", null, 10562, "M_10562", 0, 0),

	M_10563(SupplementalArrows_B, "⥃", null, 10563, "M_10563", 0, 0),

	M_10564(SupplementalArrows_B, "⥄", null, 10564, "M_10564", 0, 0),

	M_10565(SupplementalArrows_B, "⥅", null, 10565, "M_10565", 0, 0),

	M_10566(SupplementalArrows_B, "⥆", null, 10566, "M_10566", 0, 0),

	M_10567(SupplementalArrows_B, "⥇", null, 10567, "M_10567", 0, 0),

	M_10568(SupplementalArrows_B, "⥈", null, 10568, "M_10568", 0, 0),

	M_10569(SupplementalArrows_B, "⥉", null, 10569, "M_10569", 0, 0),

	M_10570(SupplementalArrows_B, "⥊", null, 10570, "M_10570", 0, 0),

	M_10571(SupplementalArrows_B, "⥋", null, 10571, "M_10571", 0, 0),

	M_10572(SupplementalArrows_B, "⥌", null, 10572, "M_10572", 0, 0),

	M_10573(SupplementalArrows_B, "⥍", null, 10573, "M_10573", 0, 0),

	M_10574(SupplementalArrows_B, "⥎", null, 10574, "M_10574", 0, 0),

	M_10575(SupplementalArrows_B, "⥏", null, 10575, "M_10575", 0, 0),

	M_10576(SupplementalArrows_B, "⥐", null, 10576, "M_10576", 0, 0),

	M_10577(SupplementalArrows_B, "⥑", null, 10577, "M_10577", 0, 0),

	M_10578(SupplementalArrows_B, "⥒", null, 10578, "M_10578", 0, 0),

	M_10579(SupplementalArrows_B, "⥓", null, 10579, "M_10579", 0, 0),

	M_10580(SupplementalArrows_B, "⥔", null, 10580, "M_10580", 0, 0),

	M_10581(SupplementalArrows_B, "⥕", null, 10581, "M_10581", 0, 0),

	M_10582(SupplementalArrows_B, "⥖", null, 10582, "M_10582", 0, 0),

	M_10583(SupplementalArrows_B, "⥗", null, 10583, "M_10583", 0, 0),

	M_10584(SupplementalArrows_B, "⥘", null, 10584, "M_10584", 0, 0),

	M_10585(SupplementalArrows_B, "⥙", null, 10585, "M_10585", 0, 0),

	M_10586(SupplementalArrows_B, "⥚", null, 10586, "M_10586", 0, 0),

	M_10587(SupplementalArrows_B, "⥛", null, 10587, "M_10587", 0, 0),

	M_10588(SupplementalArrows_B, "⥜", null, 10588, "M_10588", 0, 0),

	M_10589(SupplementalArrows_B, "⥝", null, 10589, "M_10589", 0, 0),

	M_10590(SupplementalArrows_B, "⥞", null, 10590, "M_10590", 0, 0),

	M_10591(SupplementalArrows_B, "⥟", null, 10591, "M_10591", 0, 0),

	M_10592(SupplementalArrows_B, "⥠", null, 10592, "M_10592", 0, 0),

	M_10593(SupplementalArrows_B, "⥡", null, 10593, "M_10593", 0, 0),

	M_10594(SupplementalArrows_B, "⥢", null, 10594, "M_10594", 0, 0),

	M_10595(SupplementalArrows_B, "⥣", null, 10595, "M_10595", 0, 0),

	M_10596(SupplementalArrows_B, "⥤", null, 10596, "M_10596", 0, 0),

	M_10597(SupplementalArrows_B, "⥥", null, 10597, "M_10597", 0, 0),

	M_10598(SupplementalArrows_B, "⥦", null, 10598, "M_10598", 0, 0),

	M_10599(SupplementalArrows_B, "⥧", null, 10599, "M_10599", 0, 0),

	M_10600(SupplementalArrows_B, "⥨", null, 10600, "M_10600", 0, 0),

	M_10601(SupplementalArrows_B, "⥩", null, 10601, "M_10601", 0, 0),

	M_10602(SupplementalArrows_B, "⥪", null, 10602, "M_10602", 0, 0),

	M_10603(SupplementalArrows_B, "⥫", null, 10603, "M_10603", 0, 0),

	M_10604(SupplementalArrows_B, "⥬", null, 10604, "M_10604", 0, 0),

	M_10605(SupplementalArrows_B, "⥭", null, 10605, "M_10605", 0, 0),

	M_10606(SupplementalArrows_B, "⥮", null, 10606, "M_10606", 0, 0),

	M_10607(SupplementalArrows_B, "⥯", null, 10607, "M_10607", 0, 0),

	M_10608(SupplementalArrows_B, "⥰", null, 10608, "M_10608", 0, 0),

	M_10609(SupplementalArrows_B, "⥱", null, 10609, "M_10609", 0, 0),

	M_10610(SupplementalArrows_B, "⥲", null, 10610, "M_10610", 0, 0),

	M_10611(SupplementalArrows_B, "⥳", null, 10611, "M_10611", 0, 0),

	M_10612(SupplementalArrows_B, "⥴", null, 10612, "M_10612", 0, 0),

	M_10613(SupplementalArrows_B, "⥵", null, 10613, "M_10613", 0, 0),

	M_10614(SupplementalArrows_B, "⥶", null, 10614, "M_10614", 0, 0),

	M_10615(SupplementalArrows_B, "⥷", null, 10615, "M_10615", 0, 0),

	M_10616(SupplementalArrows_B, "⥸", null, 10616, "M_10616", 0, 0),

	M_10617(SupplementalArrows_B, "⥹", null, 10617, "M_10617", 0, 0),

	M_10618(SupplementalArrows_B, "⥺", null, 10618, "M_10618", 0, 0),

	M_10619(SupplementalArrows_B, "⥻", null, 10619, "M_10619", 0, 0),

	M_10620(SupplementalArrows_B, "⥼", null, 10620, "M_10620", 0, 0),

	M_10621(SupplementalArrows_B, "⥽", null, 10621, "M_10621", 0, 0),

	M_10622(SupplementalArrows_B, "⥾", null, 10622, "M_10622", 0, 0),

	M_10623(SupplementalArrows_B, "⥿", null, 10623, "M_10623", 0, 0),

	// ---------- Combining Diacritical Marks for Symbols ---

	M_8400(DiacriticalMarksforSymbols, "⃐", null, 8400, "M_8400", 0, 0),

	M_8401(DiacriticalMarksforSymbols, "⃑", null, 8401, "M_8401", 0, 0),

	M_8402(DiacriticalMarksforSymbols, "⃒", null, 8402, "M_8402", 0, 0),

	M_8403(DiacriticalMarksforSymbols, "⃓", null, 8403, "M_8403", 0, 0),

	M_8404(DiacriticalMarksforSymbols, "⃔", null, 8404, "M_8404", 0, 0),

	M_8405(DiacriticalMarksforSymbols, "⃕", null, 8405, "M_8405", 0, 0),

	M_8406(DiacriticalMarksforSymbols, "⃖", null, 8406, "M_8406", 0, 0),

	M_8407(DiacriticalMarksforSymbols, "⃗", null, 8407, "M_8407", 0, 0),

	M_8408(DiacriticalMarksforSymbols, "⃘", null, 8408, "M_8408", 0, 0),

	M_8409(DiacriticalMarksforSymbols, "⃙", null, 8409, "M_8409", 0, 0),

	M_8410(DiacriticalMarksforSymbols, "⃚", null, 8410, "M_8410", 0, 0),

	M_8411(DiacriticalMarksforSymbols, "⃛", null, 8411, "M_8411", 0, 0),

	M_8412(DiacriticalMarksforSymbols, "⃜", null, 8412, "M_8412", 0, 0),

	M_8413(DiacriticalMarksforSymbols, "⃝", null, 8413, "M_8413", 0, 0),

	M_8414(DiacriticalMarksforSymbols, "⃞", null, 8414, "M_8414", 0, 0),

	M_8415(DiacriticalMarksforSymbols, "⃟", null, 8415, "M_8415", 0, 0),

	M_8416(DiacriticalMarksforSymbols, "⃠", null, 8416, "M_8416", 0, 0),

	M_8417(DiacriticalMarksforSymbols, "⃡", null, 8417, "M_8417", 0, 0),

	M_8418(DiacriticalMarksforSymbols, "⃢", null, 8418, "M_8418", 0, 0),

	M_8419(DiacriticalMarksforSymbols, "⃣", null, 8419, "M_8419", 0, 0),

	M_8420(DiacriticalMarksforSymbols, "⃤", null, 8420, "M_8420", 0, 0),

	M_8421(DiacriticalMarksforSymbols, "⃥", null, 8421, "M_8421", 0, 0),

	M_8422(DiacriticalMarksforSymbols, "⃦", null, 8422, "M_8422", 0, 0),

	M_8423(DiacriticalMarksforSymbols, "⃧", null, 8423, "M_8423", 0, 0),

	M_8424(DiacriticalMarksforSymbols, "⃨", null, 8424, "M_8424", 0, 0),

	M_8425(DiacriticalMarksforSymbols, "⃩", null, 8425, "M_8425", 0, 0),

	M_8426(DiacriticalMarksforSymbols, "⃪", null, 8426, "M_8426", 0, 0),

	M_8427(DiacriticalMarksforSymbols, "⃫", null, 8427, "M_8427", 0, 0),

	M_8428(DiacriticalMarksforSymbols, "⃬", null, 8428, "M_8428", 0, 0),

	M_8429(DiacriticalMarksforSymbols, "⃭", null, 8429, "M_8429", 0, 0),

	M_8430(DiacriticalMarksforSymbols, "⃮", null, 8430, "M_8430", 0, 0),

	M_8431(DiacriticalMarksforSymbols, "⃯", null, 8431, "M_8431", 0, 0),

	M_8432(DiacriticalMarksforSymbols, "⃰", null, 8432, "M_8432", 0, 0),

	M_8433(DiacriticalMarksforSymbols, "⃱", null, 8433, "M_8433", 0, 0),

	M_8434(DiacriticalMarksforSymbols, "⃲", null, 8434, "M_8434", 0, 0),

	M_8435(DiacriticalMarksforSymbols, "⃳", null, 8435, "M_8435", 0, 0),

	M_8436(DiacriticalMarksforSymbols, "⃴", null, 8436, "M_8436", 0, 0),

	M_8437(DiacriticalMarksforSymbols, "⃵", null, 8437, "M_8437", 0, 0),

	M_8438(DiacriticalMarksforSymbols, "⃶", null, 8438, "M_8438", 0, 0),

	M_8439(DiacriticalMarksforSymbols, "⃷", null, 8439, "M_8439", 0, 0),

	M_8440(DiacriticalMarksforSymbols, "⃸", null, 8440, "M_8440", 0, 0),

	M_8441(DiacriticalMarksforSymbols, "⃹", null, 8441, "M_8441", 0, 0),

	M_8442(DiacriticalMarksforSymbols, "⃺", null, 8442, "M_8442", 0, 0),

	M_8443(DiacriticalMarksforSymbols, "⃻", null, 8443, "M_8443", 0, 0),

	M_8444(DiacriticalMarksforSymbols, "⃼", null, 8444, "M_8444", 0, 0),

	M_8445(DiacriticalMarksforSymbols, "⃽", null, 8445, "M_8445", 0, 0),

	M_8446(DiacriticalMarksforSymbols, "⃾", null, 8446, "M_8446", 0, 0),

	M_8447(DiacriticalMarksforSymbols, "⃿", null, 8447, "M_8447", 0, 0),

	;

	final private String text;

	final private String latex;

	final private int block;

	final private String toolTip;

	final int caretPosition;

	final int length;

	EnLatexMath(int block, String text, String toolTip, int code, String latex, int caretPosition, int length) {
		this.block = block;
		this.text = text;
		this.toolTip = toolTip;
		this.latex = latex;
		this.caretPosition = caretPosition;
		this.length = length;
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
			return "Often Used";
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
