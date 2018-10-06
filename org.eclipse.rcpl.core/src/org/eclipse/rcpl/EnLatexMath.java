package org.eclipse.rcpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramin
 *
 */
public enum EnLatexMath {

//	PLUS("+", "", ""),
//
//	MINUS("-", "", ""),
//
//	EQUAL("=", "", ""),
//
//	EXCLAMATION("!", "", ""),
//
//	SLASH("/", "", ""),
//
//	LEFT_ROUND_BRACKET("(", "", ""),
//
//	RIGHT_ROUND_BREAKET(")", "", ""),
//
//	LEFT_BRAKET("[", "", ""),
//
//	RIGHT_BRAKET("]", "", ""),
//
//	LESS_THEN("<", "", ""),
//
//	GREATER_THEN(">", "", ""),
//
//	VERTICAL_LINE("|", "", ""),
//
//	APOSTROPH("'", "", ""),
//
//	DOUBLE_DOT(":", "", ""),
//
//	ASTERIX("*", "", ""),
//
	FRACTION(0, null, 0, "equation_fraction", ""),

	// ---------- Mathematical Operators ---

	MATH_8704(1, "∀", 8704, "MATH_8704", "latex"),

	MATH_8705(1, "∁", 8705, "MATH_8705", "latex"),

	MATH_8706(1, "∂", 8706, "MATH_8706", "latex"),

	MATH_8707(1, "∃", 8707, "MATH_8707", "latex"),

	MATH_8708(1, "∄", 8708, "MATH_8708", "latex"),

	MATH_8709(1, "∅", 8709, "MATH_8709", "latex"),

	MATH_8710(1, "∆", 8710, "MATH_8710", "latex"),

	MATH_8711(1, "∇", 8711, "MATH_8711", "latex"),

	MATH_8712(1, "∈", 8712, "MATH_8712", "latex"),

	MATH_8713(1, "∉", 8713, "MATH_8713", "latex"),

	MATH_8714(1, "∊", 8714, "MATH_8714", "latex"),

	MATH_8715(1, "∋", 8715, "MATH_8715", "latex"),

	MATH_8716(1, "∌", 8716, "MATH_8716", "latex"),

	MATH_8717(1, "∍", 8717, "MATH_8717", "latex"),

	MATH_8718(1, "∎", 8718, "MATH_8718", "latex"),

	MATH_8719(1, "∏", 8719, "MATH_8719", "latex"),

	MATH_8720(1, "∐", 8720, "MATH_8720", "latex"),

	MATH_8721(1, "∑", 8721, "MATH_8721", "latex"),

	MATH_8722(1, "−", 8722, "MATH_8722", "latex"),

	MATH_8723(1, "∓", 8723, "MATH_8723", "latex"),

	MATH_8724(1, "∔", 8724, "MATH_8724", "latex"),

	MATH_8725(1, "∕", 8725, "MATH_8725", "latex"),

	MATH_8726(1, "∖", 8726, "MATH_8726", "latex"),

	MATH_8727(1, "∗", 8727, "MATH_8727", "latex"),

	MATH_8728(1, "∘", 8728, "MATH_8728", "latex"),

	MATH_8729(1, "∙", 8729, "MATH_8729", "latex"),

	MATH_8730(1, "√", 8730, "MATH_8730", "latex"),

	MATH_8731(1, "∛", 8731, "MATH_8731", "latex"),

	MATH_8732(1, "∜", 8732, "MATH_8732", "latex"),

	MATH_8733(1, "∝", 8733, "MATH_8733", "latex"),

	MATH_8734(1, "∞", 8734, "MATH_8734", "latex"),

	MATH_8735(1, "∟", 8735, "MATH_8735", "latex"),

	MATH_8736(1, "∠", 8736, "MATH_8736", "latex"),

	MATH_8737(1, "∡", 8737, "MATH_8737", "latex"),

	MATH_8738(1, "∢", 8738, "MATH_8738", "latex"),

	MATH_8739(1, "∣", 8739, "MATH_8739", "latex"),

	MATH_8740(1, "∤", 8740, "MATH_8740", "latex"),

	MATH_8741(1, "∥", 8741, "MATH_8741", "latex"),

	MATH_8742(1, "∦", 8742, "MATH_8742", "latex"),

	MATH_8743(1, "∧", 8743, "MATH_8743", "latex"),

	MATH_8744(1, "∨", 8744, "MATH_8744", "latex"),

	MATH_8745(1, "∩", 8745, "MATH_8745", "latex"),

	MATH_8746(1, "∪", 8746, "MATH_8746", "latex"),

	MATH_8747(1, "∫", 8747, "MATH_8747", "latex"),

	MATH_8748(1, "∬", 8748, "MATH_8748", "latex"),

	MATH_8749(1, "∭", 8749, "MATH_8749", "latex"),

	MATH_8750(1, "∮", 8750, "MATH_8750", "latex"),

	MATH_8751(1, "∯", 8751, "MATH_8751", "latex"),

	MATH_8752(1, "∰", 8752, "MATH_8752", "latex"),

	MATH_8753(1, "∱", 8753, "MATH_8753", "latex"),

	MATH_8754(1, "∲", 8754, "MATH_8754", "latex"),

	MATH_8755(1, "∳", 8755, "MATH_8755", "latex"),

	MATH_8756(1, "∴", 8756, "MATH_8756", "latex"),

	MATH_8757(1, "∵", 8757, "MATH_8757", "latex"),

	MATH_8758(1, "∶", 8758, "MATH_8758", "latex"),

	MATH_8759(1, "∷", 8759, "MATH_8759", "latex"),

	MATH_8760(1, "∸", 8760, "MATH_8760", "latex"),

	MATH_8761(1, "∹", 8761, "MATH_8761", "latex"),

	MATH_8762(1, "∺", 8762, "MATH_8762", "latex"),

	MATH_8763(1, "∻", 8763, "MATH_8763", "latex"),

	MATH_8764(1, "∼", 8764, "MATH_8764", "latex"),

	MATH_8765(1, "∽", 8765, "MATH_8765", "latex"),

	MATH_8766(1, "∾", 8766, "MATH_8766", "latex"),

	MATH_8767(1, "∿", 8767, "MATH_8767", "latex"),

	MATH_8768(1, "≀", 8768, "MATH_8768", "latex"),

	MATH_8769(1, "≁", 8769, "MATH_8769", "latex"),

	MATH_8770(1, "≂", 8770, "MATH_8770", "latex"),

	MATH_8771(1, "≃", 8771, "MATH_8771", "latex"),

	MATH_8772(1, "≄", 8772, "MATH_8772", "latex"),

	MATH_8773(1, "≅", 8773, "MATH_8773", "latex"),

	MATH_8774(1, "≆", 8774, "MATH_8774", "latex"),

	MATH_8775(1, "≇", 8775, "MATH_8775", "latex"),

	MATH_8776(1, "≈", 8776, "MATH_8776", "latex"),

	MATH_8777(1, "≉", 8777, "MATH_8777", "latex"),

	MATH_8778(1, "≊", 8778, "MATH_8778", "latex"),

	MATH_8779(1, "≋", 8779, "MATH_8779", "latex"),

	MATH_8780(1, "≌", 8780, "MATH_8780", "latex"),

	MATH_8781(1, "≍", 8781, "MATH_8781", "latex"),

	MATH_8782(1, "≎", 8782, "MATH_8782", "latex"),

	MATH_8783(1, "≏", 8783, "MATH_8783", "latex"),

	MATH_8784(1, "≐", 8784, "MATH_8784", "latex"),

	MATH_8785(1, "≑", 8785, "MATH_8785", "latex"),

	MATH_8786(1, "≒", 8786, "MATH_8786", "latex"),

	MATH_8787(1, "≓", 8787, "MATH_8787", "latex"),

	MATH_8788(1, "≔", 8788, "MATH_8788", "latex"),

	MATH_8789(1, "≕", 8789, "MATH_8789", "latex"),

	MATH_8790(1, "≖", 8790, "MATH_8790", "latex"),

	MATH_8791(1, "≗", 8791, "MATH_8791", "latex"),

	MATH_8792(1, "≘", 8792, "MATH_8792", "latex"),

	MATH_8793(1, "≙", 8793, "MATH_8793", "latex"),

	MATH_8794(1, "≚", 8794, "MATH_8794", "latex"),

	MATH_8795(1, "≛", 8795, "MATH_8795", "latex"),

	MATH_8796(1, "≜", 8796, "MATH_8796", "latex"),

	MATH_8797(1, "≝", 8797, "MATH_8797", "latex"),

	MATH_8798(1, "≞", 8798, "MATH_8798", "latex"),

	MATH_8799(1, "≟", 8799, "MATH_8799", "latex"),

	MATH_8800(1, "≠", 8800, "MATH_8800", "latex"),

	MATH_8801(1, "≡", 8801, "MATH_8801", "latex"),

	MATH_8802(1, "≢", 8802, "MATH_8802", "latex"),

	MATH_8803(1, "≣", 8803, "MATH_8803", "latex"),

	MATH_8804(1, "≤", 8804, "MATH_8804", "latex"),

	MATH_8805(1, "≥", 8805, "MATH_8805", "latex"),

	MATH_8806(1, "≦", 8806, "MATH_8806", "latex"),

	MATH_8807(1, "≧", 8807, "MATH_8807", "latex"),

	MATH_8808(1, "≨", 8808, "MATH_8808", "latex"),

	MATH_8809(1, "≩", 8809, "MATH_8809", "latex"),

	MATH_8810(1, "≪", 8810, "MATH_8810", "latex"),

	MATH_8811(1, "≫", 8811, "MATH_8811", "latex"),

	MATH_8812(1, "≬", 8812, "MATH_8812", "latex"),

	MATH_8813(1, "≭", 8813, "MATH_8813", "latex"),

	MATH_8814(1, "≮", 8814, "MATH_8814", "latex"),

	MATH_8815(1, "≯", 8815, "MATH_8815", "latex"),

	MATH_8816(1, "≰", 8816, "MATH_8816", "latex"),

	MATH_8817(1, "≱", 8817, "MATH_8817", "latex"),

	MATH_8818(1, "≲", 8818, "MATH_8818", "latex"),

	MATH_8819(1, "≳", 8819, "MATH_8819", "latex"),

	MATH_8820(1, "≴", 8820, "MATH_8820", "latex"),

	MATH_8821(1, "≵", 8821, "MATH_8821", "latex"),

	MATH_8822(1, "≶", 8822, "MATH_8822", "latex"),

	MATH_8823(1, "≷", 8823, "MATH_8823", "latex"),

	MATH_8824(1, "≸", 8824, "MATH_8824", "latex"),

	MATH_8825(1, "≹", 8825, "MATH_8825", "latex"),

	MATH_8826(1, "≺", 8826, "MATH_8826", "latex"),

	MATH_8827(1, "≻", 8827, "MATH_8827", "latex"),

	MATH_8828(1, "≼", 8828, "MATH_8828", "latex"),

	MATH_8829(1, "≽", 8829, "MATH_8829", "latex"),

	MATH_8830(1, "≾", 8830, "MATH_8830", "latex"),

	MATH_8831(1, "≿", 8831, "MATH_8831", "latex"),

	MATH_8832(1, "⊀", 8832, "MATH_8832", "latex"),

	MATH_8833(1, "⊁", 8833, "MATH_8833", "latex"),

	MATH_8834(1, "⊂", 8834, "MATH_8834", "latex"),

	MATH_8835(1, "⊃", 8835, "MATH_8835", "latex"),

	MATH_8836(1, "⊄", 8836, "MATH_8836", "latex"),

	MATH_8837(1, "⊅", 8837, "MATH_8837", "latex"),

	MATH_8838(1, "⊆", 8838, "MATH_8838", "latex"),

	MATH_8839(1, "⊇", 8839, "MATH_8839", "latex"),

	MATH_8840(1, "⊈", 8840, "MATH_8840", "latex"),

	MATH_8841(1, "⊉", 8841, "MATH_8841", "latex"),

	MATH_8842(1, "⊊", 8842, "MATH_8842", "latex"),

	MATH_8843(1, "⊋", 8843, "MATH_8843", "latex"),

	MATH_8844(1, "⊌", 8844, "MATH_8844", "latex"),

	MATH_8845(1, "⊍", 8845, "MATH_8845", "latex"),

	MATH_8846(1, "⊎", 8846, "MATH_8846", "latex"),

	MATH_8847(1, "⊏", 8847, "MATH_8847", "latex"),

	MATH_8848(1, "⊐", 8848, "MATH_8848", "latex"),

	MATH_8849(1, "⊑", 8849, "MATH_8849", "latex"),

	MATH_8850(1, "⊒", 8850, "MATH_8850", "latex"),

	MATH_8851(1, "⊓", 8851, "MATH_8851", "latex"),

	MATH_8852(1, "⊔", 8852, "MATH_8852", "latex"),

	MATH_8853(1, "⊕", 8853, "MATH_8853", "latex"),

	MATH_8854(1, "⊖", 8854, "MATH_8854", "latex"),

	MATH_8855(1, "⊗", 8855, "MATH_8855", "latex"),

	MATH_8856(1, "⊘", 8856, "MATH_8856", "latex"),

	MATH_8857(1, "⊙", 8857, "MATH_8857", "latex"),

	MATH_8858(1, "⊚", 8858, "MATH_8858", "latex"),

	MATH_8859(1, "⊛", 8859, "MATH_8859", "latex"),

	MATH_8860(1, "⊜", 8860, "MATH_8860", "latex"),

	MATH_8861(1, "⊝", 8861, "MATH_8861", "latex"),

	MATH_8862(1, "⊞", 8862, "MATH_8862", "latex"),

	MATH_8863(1, "⊟", 8863, "MATH_8863", "latex"),

	MATH_8864(1, "⊠", 8864, "MATH_8864", "latex"),

	MATH_8865(1, "⊡", 8865, "MATH_8865", "latex"),

	MATH_8866(1, "⊢", 8866, "MATH_8866", "latex"),

	MATH_8867(1, "⊣", 8867, "MATH_8867", "latex"),

	MATH_8868(1, "⊤", 8868, "MATH_8868", "latex"),

	MATH_8869(1, "⊥", 8869, "MATH_8869", "latex"),

	MATH_8870(1, "⊦", 8870, "MATH_8870", "latex"),

	MATH_8871(1, "⊧", 8871, "MATH_8871", "latex"),

	MATH_8872(1, "⊨", 8872, "MATH_8872", "latex"),

	MATH_8873(1, "⊩", 8873, "MATH_8873", "latex"),

	MATH_8874(1, "⊪", 8874, "MATH_8874", "latex"),

	MATH_8875(1, "⊫", 8875, "MATH_8875", "latex"),

	MATH_8876(1, "⊬", 8876, "MATH_8876", "latex"),

	MATH_8877(1, "⊭", 8877, "MATH_8877", "latex"),

	MATH_8878(1, "⊮", 8878, "MATH_8878", "latex"),

	MATH_8879(1, "⊯", 8879, "MATH_8879", "latex"),

	MATH_8880(1, "⊰", 8880, "MATH_8880", "latex"),

	MATH_8881(1, "⊱", 8881, "MATH_8881", "latex"),

	MATH_8882(1, "⊲", 8882, "MATH_8882", "latex"),

	MATH_8883(1, "⊳", 8883, "MATH_8883", "latex"),

	MATH_8884(1, "⊴", 8884, "MATH_8884", "latex"),

	MATH_8885(1, "⊵", 8885, "MATH_8885", "latex"),

	MATH_8886(1, "⊶", 8886, "MATH_8886", "latex"),

	MATH_8887(1, "⊷", 8887, "MATH_8887", "latex"),

	MATH_8888(1, "⊸", 8888, "MATH_8888", "latex"),

	MATH_8889(1, "⊹", 8889, "MATH_8889", "latex"),

	MATH_8890(1, "⊺", 8890, "MATH_8890", "latex"),

	MATH_8891(1, "⊻", 8891, "MATH_8891", "latex"),

	MATH_8892(1, "⊼", 8892, "MATH_8892", "latex"),

	MATH_8893(1, "⊽", 8893, "MATH_8893", "latex"),

	MATH_8894(1, "⊾", 8894, "MATH_8894", "latex"),

	MATH_8895(1, "⊿", 8895, "MATH_8895", "latex"),

	MATH_8896(1, "⋀", 8896, "MATH_8896", "latex"),

	MATH_8897(1, "⋁", 8897, "MATH_8897", "latex"),

	MATH_8898(1, "⋂", 8898, "MATH_8898", "latex"),

	MATH_8899(1, "⋃", 8899, "MATH_8899", "latex"),

	MATH_8900(1, "⋄", 8900, "MATH_8900", "latex"),

	MATH_8901(1, "⋅", 8901, "MATH_8901", "latex"),

	MATH_8902(1, "⋆", 8902, "MATH_8902", "latex"),

	MATH_8903(1, "⋇", 8903, "MATH_8903", "latex"),

	MATH_8904(1, "⋈", 8904, "MATH_8904", "latex"),

	MATH_8905(1, "⋉", 8905, "MATH_8905", "latex"),

	MATH_8906(1, "⋊", 8906, "MATH_8906", "latex"),

	MATH_8907(1, "⋋", 8907, "MATH_8907", "latex"),

	MATH_8908(1, "⋌", 8908, "MATH_8908", "latex"),

	MATH_8909(1, "⋍", 8909, "MATH_8909", "latex"),

	MATH_8910(1, "⋎", 8910, "MATH_8910", "latex"),

	MATH_8911(1, "⋏", 8911, "MATH_8911", "latex"),

	MATH_8912(1, "⋐", 8912, "MATH_8912", "latex"),

	MATH_8913(1, "⋑", 8913, "MATH_8913", "latex"),

	MATH_8914(1, "⋒", 8914, "MATH_8914", "latex"),

	MATH_8915(1, "⋓", 8915, "MATH_8915", "latex"),

	MATH_8916(1, "⋔", 8916, "MATH_8916", "latex"),

	MATH_8917(1, "⋕", 8917, "MATH_8917", "latex"),

	MATH_8918(1, "⋖", 8918, "MATH_8918", "latex"),

	MATH_8919(1, "⋗", 8919, "MATH_8919", "latex"),

	MATH_8920(1, "⋘", 8920, "MATH_8920", "latex"),

	MATH_8921(1, "⋙", 8921, "MATH_8921", "latex"),

	MATH_8922(1, "⋚", 8922, "MATH_8922", "latex"),

	MATH_8923(1, "⋛", 8923, "MATH_8923", "latex"),

	MATH_8924(1, "⋜", 8924, "MATH_8924", "latex"),

	MATH_8925(1, "⋝", 8925, "MATH_8925", "latex"),

	MATH_8926(1, "⋞", 8926, "MATH_8926", "latex"),

	MATH_8927(1, "⋟", 8927, "MATH_8927", "latex"),

	MATH_8928(1, "⋠", 8928, "MATH_8928", "latex"),

	MATH_8929(1, "⋡", 8929, "MATH_8929", "latex"),

	MATH_8930(1, "⋢", 8930, "MATH_8930", "latex"),

	MATH_8931(1, "⋣", 8931, "MATH_8931", "latex"),

	MATH_8932(1, "⋤", 8932, "MATH_8932", "latex"),

	MATH_8933(1, "⋥", 8933, "MATH_8933", "latex"),

	MATH_8934(1, "⋦", 8934, "MATH_8934", "latex"),

	MATH_8935(1, "⋧", 8935, "MATH_8935", "latex"),

	MATH_8936(1, "⋨", 8936, "MATH_8936", "latex"),

	MATH_8937(1, "⋩", 8937, "MATH_8937", "latex"),

	MATH_8938(1, "⋪", 8938, "MATH_8938", "latex"),

	MATH_8939(1, "⋫", 8939, "MATH_8939", "latex"),

	MATH_8940(1, "⋬", 8940, "MATH_8940", "latex"),

	MATH_8941(1, "⋭", 8941, "MATH_8941", "latex"),

	MATH_8942(1, "⋮", 8942, "MATH_8942", "latex"),

	MATH_8943(1, "⋯", 8943, "MATH_8943", "latex"),

	MATH_8944(1, "⋰", 8944, "MATH_8944", "latex"),

	MATH_8945(1, "⋱", 8945, "MATH_8945", "latex"),

	MATH_8946(1, "⋲", 8946, "MATH_8946", "latex"),

	MATH_8947(1, "⋳", 8947, "MATH_8947", "latex"),

	MATH_8948(1, "⋴", 8948, "MATH_8948", "latex"),

	MATH_8949(1, "⋵", 8949, "MATH_8949", "latex"),

	MATH_8950(1, "⋶", 8950, "MATH_8950", "latex"),

	MATH_8951(1, "⋷", 8951, "MATH_8951", "latex"),

	MATH_8952(1, "⋸", 8952, "MATH_8952", "latex"),

	MATH_8953(1, "⋹", 8953, "MATH_8953", "latex"),

	MATH_8954(1, "⋺", 8954, "MATH_8954", "latex"),

	MATH_8955(1, "⋻", 8955, "MATH_8955", "latex"),

	MATH_8956(1, "⋼", 8956, "MATH_8956", "latex"),

	MATH_8957(1, "⋽", 8957, "MATH_8957", "latex"),

	MATH_8958(1, "⋾", 8958, "MATH_8958", "latex"),

	MATH_8959(1, "⋿", 8959, "MATH_8959", "latex"),

	// ---------- mathematical Operators Supplement ---

	MATH_10752(2, "⨀", 10752, "MATH_10752", "latex"),

	MATH_10753(2, "⨁", 10753, "MATH_10753", "latex"),

	MATH_10754(2, "⨂", 10754, "MATH_10754", "latex"),

	MATH_10755(2, "⨃", 10755, "MATH_10755", "latex"),

	MATH_10756(2, "⨄", 10756, "MATH_10756", "latex"),

	MATH_10757(2, "⨅", 10757, "MATH_10757", "latex"),

	MATH_10758(2, "⨆", 10758, "MATH_10758", "latex"),

	MATH_10759(2, "⨇", 10759, "MATH_10759", "latex"),

	MATH_10760(2, "⨈", 10760, "MATH_10760", "latex"),

	MATH_10761(2, "⨉", 10761, "MATH_10761", "latex"),

	MATH_10762(2, "⨊", 10762, "MATH_10762", "latex"),

	MATH_10763(2, "⨋", 10763, "MATH_10763", "latex"),

	MATH_10764(2, "⨌", 10764, "MATH_10764", "latex"),

	MATH_10765(2, "⨍", 10765, "MATH_10765", "latex"),

	MATH_10766(2, "⨎", 10766, "MATH_10766", "latex"),

	MATH_10767(2, "⨏", 10767, "MATH_10767", "latex"),

	MATH_10768(2, "⨐", 10768, "MATH_10768", "latex"),

	MATH_10769(2, "⨑", 10769, "MATH_10769", "latex"),

	MATH_10770(2, "⨒", 10770, "MATH_10770", "latex"),

	MATH_10771(2, "⨓", 10771, "MATH_10771", "latex"),

	MATH_10772(2, "⨔", 10772, "MATH_10772", "latex"),

	MATH_10773(2, "⨕", 10773, "MATH_10773", "latex"),

	MATH_10774(2, "⨖", 10774, "MATH_10774", "latex"),

	MATH_10775(2, "⨗", 10775, "MATH_10775", "latex"),

	MATH_10776(2, "⨘", 10776, "MATH_10776", "latex"),

	MATH_10777(2, "⨙", 10777, "MATH_10777", "latex"),

	MATH_10778(2, "⨚", 10778, "MATH_10778", "latex"),

	MATH_10779(2, "⨛", 10779, "MATH_10779", "latex"),

	MATH_10780(2, "⨜", 10780, "MATH_10780", "latex"),

	MATH_10781(2, "⨝", 10781, "MATH_10781", "latex"),

	MATH_10782(2, "⨞", 10782, "MATH_10782", "latex"),

	MATH_10783(2, "⨟", 10783, "MATH_10783", "latex"),

	MATH_10784(2, "⨠", 10784, "MATH_10784", "latex"),

	MATH_10785(2, "⨡", 10785, "MATH_10785", "latex"),

	MATH_10786(2, "⨢", 10786, "MATH_10786", "latex"),

	MATH_10787(2, "⨣", 10787, "MATH_10787", "latex"),

	MATH_10788(2, "⨤", 10788, "MATH_10788", "latex"),

	MATH_10789(2, "⨥", 10789, "MATH_10789", "latex"),

	MATH_10790(2, "⨦", 10790, "MATH_10790", "latex"),

	MATH_10791(2, "⨧", 10791, "MATH_10791", "latex"),

	MATH_10792(2, "⨨", 10792, "MATH_10792", "latex"),

	MATH_10793(2, "⨩", 10793, "MATH_10793", "latex"),

	MATH_10794(2, "⨪", 10794, "MATH_10794", "latex"),

	MATH_10795(2, "⨫", 10795, "MATH_10795", "latex"),

	MATH_10796(2, "⨬", 10796, "MATH_10796", "latex"),

	MATH_10797(2, "⨭", 10797, "MATH_10797", "latex"),

	MATH_10798(2, "⨮", 10798, "MATH_10798", "latex"),

	MATH_10799(2, "⨯", 10799, "MATH_10799", "latex"),

	MATH_10800(2, "⨰", 10800, "MATH_10800", "latex"),

	MATH_10801(2, "⨱", 10801, "MATH_10801", "latex"),

	MATH_10802(2, "⨲", 10802, "MATH_10802", "latex"),

	MATH_10803(2, "⨳", 10803, "MATH_10803", "latex"),

	MATH_10804(2, "⨴", 10804, "MATH_10804", "latex"),

	MATH_10805(2, "⨵", 10805, "MATH_10805", "latex"),

	MATH_10806(2, "⨶", 10806, "MATH_10806", "latex"),

	MATH_10807(2, "⨷", 10807, "MATH_10807", "latex"),

	MATH_10808(2, "⨸", 10808, "MATH_10808", "latex"),

	MATH_10809(2, "⨹", 10809, "MATH_10809", "latex"),

	MATH_10810(2, "⨺", 10810, "MATH_10810", "latex"),

	MATH_10811(2, "⨻", 10811, "MATH_10811", "latex"),

	MATH_10812(2, "⨼", 10812, "MATH_10812", "latex"),

	MATH_10813(2, "⨽", 10813, "MATH_10813", "latex"),

	MATH_10814(2, "⨾", 10814, "MATH_10814", "latex"),

	MATH_10815(2, "⨿", 10815, "MATH_10815", "latex"),

	MATH_10816(2, "⩀", 10816, "MATH_10816", "latex"),

	MATH_10817(2, "⩁", 10817, "MATH_10817", "latex"),

	MATH_10818(2, "⩂", 10818, "MATH_10818", "latex"),

	MATH_10819(2, "⩃", 10819, "MATH_10819", "latex"),

	MATH_10820(2, "⩄", 10820, "MATH_10820", "latex"),

	MATH_10821(2, "⩅", 10821, "MATH_10821", "latex"),

	MATH_10822(2, "⩆", 10822, "MATH_10822", "latex"),

	MATH_10823(2, "⩇", 10823, "MATH_10823", "latex"),

	MATH_10824(2, "⩈", 10824, "MATH_10824", "latex"),

	MATH_10825(2, "⩉", 10825, "MATH_10825", "latex"),

	MATH_10826(2, "⩊", 10826, "MATH_10826", "latex"),

	MATH_10827(2, "⩋", 10827, "MATH_10827", "latex"),

	MATH_10828(2, "⩌", 10828, "MATH_10828", "latex"),

	MATH_10829(2, "⩍", 10829, "MATH_10829", "latex"),

	MATH_10830(2, "⩎", 10830, "MATH_10830", "latex"),

	MATH_10831(2, "⩏", 10831, "MATH_10831", "latex"),

	MATH_10832(2, "⩐", 10832, "MATH_10832", "latex"),

	MATH_10833(2, "⩑", 10833, "MATH_10833", "latex"),

	MATH_10834(2, "⩒", 10834, "MATH_10834", "latex"),

	MATH_10835(2, "⩓", 10835, "MATH_10835", "latex"),

	MATH_10836(2, "⩔", 10836, "MATH_10836", "latex"),

	MATH_10837(2, "⩕", 10837, "MATH_10837", "latex"),

	MATH_10838(2, "⩖", 10838, "MATH_10838", "latex"),

	MATH_10839(2, "⩗", 10839, "MATH_10839", "latex"),

	MATH_10840(2, "⩘", 10840, "MATH_10840", "latex"),

	MATH_10841(2, "⩙", 10841, "MATH_10841", "latex"),

	MATH_10842(2, "⩚", 10842, "MATH_10842", "latex"),

	MATH_10843(2, "⩛", 10843, "MATH_10843", "latex"),

	MATH_10844(2, "⩜", 10844, "MATH_10844", "latex"),

	MATH_10845(2, "⩝", 10845, "MATH_10845", "latex"),

	MATH_10846(2, "⩞", 10846, "MATH_10846", "latex"),

	MATH_10847(2, "⩟", 10847, "MATH_10847", "latex"),

	MATH_10848(2, "⩠", 10848, "MATH_10848", "latex"),

	MATH_10849(2, "⩡", 10849, "MATH_10849", "latex"),

	MATH_10850(2, "⩢", 10850, "MATH_10850", "latex"),

	MATH_10851(2, "⩣", 10851, "MATH_10851", "latex"),

	MATH_10852(2, "⩤", 10852, "MATH_10852", "latex"),

	MATH_10853(2, "⩥", 10853, "MATH_10853", "latex"),

	MATH_10854(2, "⩦", 10854, "MATH_10854", "latex"),

	MATH_10855(2, "⩧", 10855, "MATH_10855", "latex"),

	MATH_10856(2, "⩨", 10856, "MATH_10856", "latex"),

	MATH_10857(2, "⩩", 10857, "MATH_10857", "latex"),

	MATH_10858(2, "⩪", 10858, "MATH_10858", "latex"),

	MATH_10859(2, "⩫", 10859, "MATH_10859", "latex"),

	MATH_10860(2, "⩬", 10860, "MATH_10860", "latex"),

	MATH_10861(2, "⩭", 10861, "MATH_10861", "latex"),

	MATH_10862(2, "⩮", 10862, "MATH_10862", "latex"),

	MATH_10863(2, "⩯", 10863, "MATH_10863", "latex"),

	MATH_10864(2, "⩰", 10864, "MATH_10864", "latex"),

	MATH_10865(2, "⩱", 10865, "MATH_10865", "latex"),

	MATH_10866(2, "⩲", 10866, "MATH_10866", "latex"),

	MATH_10867(2, "⩳", 10867, "MATH_10867", "latex"),

	MATH_10868(2, "⩴", 10868, "MATH_10868", "latex"),

	MATH_10869(2, "⩵", 10869, "MATH_10869", "latex"),

	MATH_10870(2, "⩶", 10870, "MATH_10870", "latex"),

	MATH_10871(2, "⩷", 10871, "MATH_10871", "latex"),

	MATH_10872(2, "⩸", 10872, "MATH_10872", "latex"),

	MATH_10873(2, "⩹", 10873, "MATH_10873", "latex"),

	MATH_10874(2, "⩺", 10874, "MATH_10874", "latex"),

	MATH_10875(2, "⩻", 10875, "MATH_10875", "latex"),

	MATH_10876(2, "⩼", 10876, "MATH_10876", "latex"),

	MATH_10877(2, "⩽", 10877, "MATH_10877", "latex"),

	MATH_10878(2, "⩾", 10878, "MATH_10878", "latex"),

	MATH_10879(2, "⩿", 10879, "MATH_10879", "latex"),

	MATH_10880(2, "⪀", 10880, "MATH_10880", "latex"),

	MATH_10881(2, "⪁", 10881, "MATH_10881", "latex"),

	MATH_10882(2, "⪂", 10882, "MATH_10882", "latex"),

	MATH_10883(2, "⪃", 10883, "MATH_10883", "latex"),

	MATH_10884(2, "⪄", 10884, "MATH_10884", "latex"),

	MATH_10885(2, "⪅", 10885, "MATH_10885", "latex"),

	MATH_10886(2, "⪆", 10886, "MATH_10886", "latex"),

	MATH_10887(2, "⪇", 10887, "MATH_10887", "latex"),

	MATH_10888(2, "⪈", 10888, "MATH_10888", "latex"),

	MATH_10889(2, "⪉", 10889, "MATH_10889", "latex"),

	MATH_10890(2, "⪊", 10890, "MATH_10890", "latex"),

	MATH_10891(2, "⪋", 10891, "MATH_10891", "latex"),

	MATH_10892(2, "⪌", 10892, "MATH_10892", "latex"),

	MATH_10893(2, "⪍", 10893, "MATH_10893", "latex"),

	MATH_10894(2, "⪎", 10894, "MATH_10894", "latex"),

	MATH_10895(2, "⪏", 10895, "MATH_10895", "latex"),

	MATH_10896(2, "⪐", 10896, "MATH_10896", "latex"),

	MATH_10897(2, "⪑", 10897, "MATH_10897", "latex"),

	MATH_10898(2, "⪒", 10898, "MATH_10898", "latex"),

	MATH_10899(2, "⪓", 10899, "MATH_10899", "latex"),

	MATH_10900(2, "⪔", 10900, "MATH_10900", "latex"),

	MATH_10901(2, "⪕", 10901, "MATH_10901", "latex"),

	MATH_10902(2, "⪖", 10902, "MATH_10902", "latex"),

	MATH_10903(2, "⪗", 10903, "MATH_10903", "latex"),

	MATH_10904(2, "⪘", 10904, "MATH_10904", "latex"),

	MATH_10905(2, "⪙", 10905, "MATH_10905", "latex"),

	MATH_10906(2, "⪚", 10906, "MATH_10906", "latex"),

	MATH_10907(2, "⪛", 10907, "MATH_10907", "latex"),

	MATH_10908(2, "⪜", 10908, "MATH_10908", "latex"),

	MATH_10909(2, "⪝", 10909, "MATH_10909", "latex"),

	MATH_10910(2, "⪞", 10910, "MATH_10910", "latex"),

	MATH_10911(2, "⪟", 10911, "MATH_10911", "latex"),

	MATH_10912(2, "⪠", 10912, "MATH_10912", "latex"),

	MATH_10913(2, "⪡", 10913, "MATH_10913", "latex"),

	MATH_10914(2, "⪢", 10914, "MATH_10914", "latex"),

	MATH_10915(2, "⪣", 10915, "MATH_10915", "latex"),

	MATH_10916(2, "⪤", 10916, "MATH_10916", "latex"),

	MATH_10917(2, "⪥", 10917, "MATH_10917", "latex"),

	MATH_10918(2, "⪦", 10918, "MATH_10918", "latex"),

	MATH_10919(2, "⪧", 10919, "MATH_10919", "latex"),

	MATH_10920(2, "⪨", 10920, "MATH_10920", "latex"),

	MATH_10921(2, "⪩", 10921, "MATH_10921", "latex"),

	MATH_10922(2, "⪪", 10922, "MATH_10922", "latex"),

	MATH_10923(2, "⪫", 10923, "MATH_10923", "latex"),

	MATH_10924(2, "⪬", 10924, "MATH_10924", "latex"),

	MATH_10925(2, "⪭", 10925, "MATH_10925", "latex"),

	MATH_10926(2, "⪮", 10926, "MATH_10926", "latex"),

	MATH_10927(2, "⪯", 10927, "MATH_10927", "latex"),

	MATH_10928(2, "⪰", 10928, "MATH_10928", "latex"),

	MATH_10929(2, "⪱", 10929, "MATH_10929", "latex"),

	MATH_10930(2, "⪲", 10930, "MATH_10930", "latex"),

	MATH_10931(2, "⪳", 10931, "MATH_10931", "latex"),

	MATH_10932(2, "⪴", 10932, "MATH_10932", "latex"),

	MATH_10933(2, "⪵", 10933, "MATH_10933", "latex"),

	MATH_10934(2, "⪶", 10934, "MATH_10934", "latex"),

	MATH_10935(2, "⪷", 10935, "MATH_10935", "latex"),

	MATH_10936(2, "⪸", 10936, "MATH_10936", "latex"),

	MATH_10937(2, "⪹", 10937, "MATH_10937", "latex"),

	MATH_10938(2, "⪺", 10938, "MATH_10938", "latex"),

	MATH_10939(2, "⪻", 10939, "MATH_10939", "latex"),

	MATH_10940(2, "⪼", 10940, "MATH_10940", "latex"),

	MATH_10941(2, "⪽", 10941, "MATH_10941", "latex"),

	MATH_10942(2, "⪾", 10942, "MATH_10942", "latex"),

	MATH_10943(2, "⪿", 10943, "MATH_10943", "latex"),

	MATH_10944(2, "⫀", 10944, "MATH_10944", "latex"),

	MATH_10945(2, "⫁", 10945, "MATH_10945", "latex"),

	MATH_10946(2, "⫂", 10946, "MATH_10946", "latex"),

	MATH_10947(2, "⫃", 10947, "MATH_10947", "latex"),

	MATH_10948(2, "⫄", 10948, "MATH_10948", "latex"),

	MATH_10949(2, "⫅", 10949, "MATH_10949", "latex"),

	MATH_10950(2, "⫆", 10950, "MATH_10950", "latex"),

	MATH_10951(2, "⫇", 10951, "MATH_10951", "latex"),

	MATH_10952(2, "⫈", 10952, "MATH_10952", "latex"),

	MATH_10953(2, "⫉", 10953, "MATH_10953", "latex"),

	MATH_10954(2, "⫊", 10954, "MATH_10954", "latex"),

	MATH_10955(2, "⫋", 10955, "MATH_10955", "latex"),

	MATH_10956(2, "⫌", 10956, "MATH_10956", "latex"),

	MATH_10957(2, "⫍", 10957, "MATH_10957", "latex"),

	MATH_10958(2, "⫎", 10958, "MATH_10958", "latex"),

	MATH_10959(2, "⫏", 10959, "MATH_10959", "latex"),

	MATH_10960(2, "⫐", 10960, "MATH_10960", "latex"),

	MATH_10961(2, "⫑", 10961, "MATH_10961", "latex"),

	MATH_10962(2, "⫒", 10962, "MATH_10962", "latex"),

	MATH_10963(2, "⫓", 10963, "MATH_10963", "latex"),

	MATH_10964(2, "⫔", 10964, "MATH_10964", "latex"),

	MATH_10965(2, "⫕", 10965, "MATH_10965", "latex"),

	MATH_10966(2, "⫖", 10966, "MATH_10966", "latex"),

	MATH_10967(2, "⫗", 10967, "MATH_10967", "latex"),

	MATH_10968(2, "⫘", 10968, "MATH_10968", "latex"),

	MATH_10969(2, "⫙", 10969, "MATH_10969", "latex"),

	MATH_10970(2, "⫚", 10970, "MATH_10970", "latex"),

	MATH_10971(2, "⫛", 10971, "MATH_10971", "latex"),

	MATH_10972(2, "⫝̸", 10972, "MATH_10972", "latex"),

	MATH_10973(2, "⫝", 10973, "MATH_10973", "latex"),

	MATH_10974(2, "⫞", 10974, "MATH_10974", "latex"),

	MATH_10975(2, "⫟", 10975, "MATH_10975", "latex"),

	MATH_10976(2, "⫠", 10976, "MATH_10976", "latex"),

	MATH_10977(2, "⫡", 10977, "MATH_10977", "latex"),

	MATH_10978(2, "⫢", 10978, "MATH_10978", "latex"),

	MATH_10979(2, "⫣", 10979, "MATH_10979", "latex"),

	MATH_10980(2, "⫤", 10980, "MATH_10980", "latex"),

	MATH_10981(2, "⫥", 10981, "MATH_10981", "latex"),

	MATH_10982(2, "⫦", 10982, "MATH_10982", "latex"),

	MATH_10983(2, "⫧", 10983, "MATH_10983", "latex"),

	MATH_10984(2, "⫨", 10984, "MATH_10984", "latex"),

	MATH_10985(2, "⫩", 10985, "MATH_10985", "latex"),

	MATH_10986(2, "⫪", 10986, "MATH_10986", "latex"),

	MATH_10987(2, "⫫", 10987, "MATH_10987", "latex"),

	MATH_10988(2, "⫬", 10988, "MATH_10988", "latex"),

	MATH_10989(2, "⫭", 10989, "MATH_10989", "latex"),

	MATH_10990(2, "⫮", 10990, "MATH_10990", "latex"),

	MATH_10991(2, "⫯", 10991, "MATH_10991", "latex"),

	MATH_10992(2, "⫰", 10992, "MATH_10992", "latex"),

	MATH_10993(2, "⫱", 10993, "MATH_10993", "latex"),

	MATH_10994(2, "⫲", 10994, "MATH_10994", "latex"),

	MATH_10995(2, "⫳", 10995, "MATH_10995", "latex"),

	MATH_10996(2, "⫴", 10996, "MATH_10996", "latex"),

	MATH_10997(2, "⫵", 10997, "MATH_10997", "latex"),

	MATH_10998(2, "⫶", 10998, "MATH_10998", "latex"),

	MATH_10999(2, "⫷", 10999, "MATH_10999", "latex"),

	MATH_11000(2, "⫸", 11000, "MATH_11000", "latex"),

	MATH_11001(2, "⫹", 11001, "MATH_11001", "latex"),

	MATH_11002(2, "⫺", 11002, "MATH_11002", "latex"),

	MATH_11003(2, "⫻", 11003, "MATH_11003", "latex"),

	MATH_11004(2, "⫼", 11004, "MATH_11004", "latex"),

	MATH_11005(2, "⫽", 11005, "MATH_11005", "latex"),

	MATH_11006(2, "⫾", 11006, "MATH_11006", "latex"),

	MATH_11007(2, "⫿", 11007, "MATH_11007", "latex"),

	// ---------- Letterlike Symbols ---

	MATH_8448(4, "℀", 8448, "MATH_8448", "latex"),

	MATH_8449(4, "℁", 8449, "MATH_8449", "latex"),

	MATH_8450(4, "ℂ", 8450, "MATH_8450", "latex"),

	MATH_8451(4, "℃", 8451, "MATH_8451", "latex"),

	MATH_8452(4, "℄", 8452, "MATH_8452", "latex"),

	MATH_8453(4, "℅", 8453, "MATH_8453", "latex"),

	MATH_8454(4, "℆", 8454, "MATH_8454", "latex"),

	MATH_8455(4, "ℇ", 8455, "MATH_8455", "latex"),

	MATH_8456(4, "℈", 8456, "MATH_8456", "latex"),

	MATH_8457(4, "℉", 8457, "MATH_8457", "latex"),

	MATH_8458(4, "ℊ", 8458, "MATH_8458", "latex"),

	MATH_8459(4, "ℋ", 8459, "MATH_8459", "latex"),

	MATH_8460(4, "ℌ", 8460, "MATH_8460", "latex"),

	MATH_8461(4, "ℍ", 8461, "MATH_8461", "latex"),

	MATH_8462(4, "ℎ", 8462, "MATH_8462", "latex"),

	MATH_8463(4, "ℏ", 8463, "MATH_8463", "latex"),

	MATH_8464(4, "ℐ", 8464, "MATH_8464", "latex"),

	MATH_8465(4, "ℑ", 8465, "MATH_8465", "latex"),

	MATH_8466(4, "ℒ", 8466, "MATH_8466", "latex"),

	MATH_8467(4, "ℓ", 8467, "MATH_8467", "latex"),

	MATH_8468(4, "℔", 8468, "MATH_8468", "latex"),

	MATH_8469(4, "ℕ", 8469, "MATH_8469", "latex"),

	MATH_8470(4, "№", 8470, "MATH_8470", "latex"),

	MATH_8471(4, "℗", 8471, "MATH_8471", "latex"),

	MATH_8472(4, "℘", 8472, "MATH_8472", "latex"),

	MATH_8473(4, "ℙ", 8473, "MATH_8473", "latex"),

	MATH_8474(4, "ℚ", 8474, "MATH_8474", "latex"),

	MATH_8475(4, "ℛ", 8475, "MATH_8475", "latex"),

	MATH_8476(4, "ℜ", 8476, "MATH_8476", "latex"),

	MATH_8477(4, "ℝ", 8477, "MATH_8477", "latex"),

	MATH_8478(4, "℞", 8478, "MATH_8478", "latex"),

	MATH_8479(4, "℟", 8479, "MATH_8479", "latex"),

	MATH_8480(4, "℠", 8480, "MATH_8480", "latex"),

	MATH_8481(4, "℡", 8481, "MATH_8481", "latex"),

	MATH_8482(4, "™", 8482, "MATH_8482", "latex"),

	MATH_8483(4, "℣", 8483, "MATH_8483", "latex"),

	MATH_8484(4, "ℤ", 8484, "MATH_8484", "latex"),

	MATH_8485(4, "℥", 8485, "MATH_8485", "latex"),

	MATH_8486(4, "Ω", 8486, "MATH_8486", "latex"),

	MATH_8487(4, "℧", 8487, "MATH_8487", "latex"),

	MATH_8488(4, "ℨ", 8488, "MATH_8488", "latex"),

	MATH_8489(4, "℩", 8489, "MATH_8489", "latex"),

	MATH_8490(4, "K", 8490, "MATH_8490", "latex"),

	MATH_8491(4, "Å", 8491, "MATH_8491", "latex"),

	MATH_8492(4, "ℬ", 8492, "MATH_8492", "latex"),

	MATH_8493(4, "ℭ", 8493, "MATH_8493", "latex"),

	MATH_8494(4, "℮", 8494, "MATH_8494", "latex"),

	MATH_8495(4, "ℯ", 8495, "MATH_8495", "latex"),

	MATH_8496(4, "ℰ", 8496, "MATH_8496", "latex"),

	MATH_8497(4, "ℱ", 8497, "MATH_8497", "latex"),

	MATH_8498(4, "Ⅎ", 8498, "MATH_8498", "latex"),

	MATH_8499(4, "ℳ", 8499, "MATH_8499", "latex"),

	MATH_8500(4, "ℴ", 8500, "MATH_8500", "latex"),

	MATH_8501(4, "ℵ", 8501, "MATH_8501", "latex"),

	MATH_8502(4, "ℶ", 8502, "MATH_8502", "latex"),

	MATH_8503(4, "ℷ", 8503, "MATH_8503", "latex"),

	MATH_8504(4, "ℸ", 8504, "MATH_8504", "latex"),

	MATH_8505(4, "ℹ", 8505, "MATH_8505", "latex"),

	MATH_8506(4, "℺", 8506, "MATH_8506", "latex"),

	MATH_8507(4, "℻", 8507, "MATH_8507", "latex"),

	MATH_8508(4, "ℼ", 8508, "MATH_8508", "latex"),

	MATH_8509(4, "ℽ", 8509, "MATH_8509", "latex"),

	MATH_8510(4, "ℾ", 8510, "MATH_8510", "latex"),

	MATH_8511(4, "ℿ", 8511, "MATH_8511", "latex"),

	MATH_8512(4, "⅀", 8512, "MATH_8512", "latex"),

	MATH_8513(4, "⅁", 8513, "MATH_8513", "latex"),

	MATH_8514(4, "⅂", 8514, "MATH_8514", "latex"),

	MATH_8515(4, "⅃", 8515, "MATH_8515", "latex"),

	MATH_8516(4, "⅄", 8516, "MATH_8516", "latex"),

	MATH_8517(4, "ⅅ", 8517, "MATH_8517", "latex"),

	MATH_8518(4, "ⅆ", 8518, "MATH_8518", "latex"),

	MATH_8519(4, "ⅇ", 8519, "MATH_8519", "latex"),

	MATH_8520(4, "ⅈ", 8520, "MATH_8520", "latex"),

	MATH_8521(4, "ⅉ", 8521, "MATH_8521", "latex"),

	MATH_8522(4, "⅊", 8522, "MATH_8522", "latex"),

	MATH_8523(4, "⅋", 8523, "MATH_8523", "latex"),

	MATH_8524(4, "⅌", 8524, "MATH_8524", "latex"),

	MATH_8525(4, "⅍", 8525, "MATH_8525", "latex"),

	MATH_8526(4, "ⅎ", 8526, "MATH_8526", "latex"),

	MATH_8527(4, "⅏", 8527, "MATH_8527", "latex"),

	// ---------- Miscellaneous Mathematical Symbols-A ---

	MATH_10176(5, "⟀", 10176, "MATH_10176", "latex"),

	MATH_10177(5, "⟁", 10177, "MATH_10177", "latex"),

	MATH_10178(5, "⟂", 10178, "MATH_10178", "latex"),

	MATH_10179(5, "⟃", 10179, "MATH_10179", "latex"),

	MATH_10180(5, "⟄", 10180, "MATH_10180", "latex"),

	MATH_10181(5, "⟅", 10181, "MATH_10181", "latex"),

	MATH_10182(5, "⟆", 10182, "MATH_10182", "latex"),

	MATH_10183(5, "⟇", 10183, "MATH_10183", "latex"),

	MATH_10184(5, "⟈", 10184, "MATH_10184", "latex"),

	MATH_10185(5, "⟉", 10185, "MATH_10185", "latex"),

	MATH_10186(5, "⟊", 10186, "MATH_10186", "latex"),

	MATH_10187(5, "⟋", 10187, "MATH_10187", "latex"),

	MATH_10188(5, "⟌", 10188, "MATH_10188", "latex"),

	MATH_10189(5, "⟍", 10189, "MATH_10189", "latex"),

	MATH_10190(5, "⟎", 10190, "MATH_10190", "latex"),

	MATH_10191(5, "⟏", 10191, "MATH_10191", "latex"),

	MATH_10192(5, "⟐", 10192, "MATH_10192", "latex"),

	MATH_10193(5, "⟑", 10193, "MATH_10193", "latex"),

	MATH_10194(5, "⟒", 10194, "MATH_10194", "latex"),

	MATH_10195(5, "⟓", 10195, "MATH_10195", "latex"),

	MATH_10196(5, "⟔", 10196, "MATH_10196", "latex"),

	MATH_10197(5, "⟕", 10197, "MATH_10197", "latex"),

	MATH_10198(5, "⟖", 10198, "MATH_10198", "latex"),

	MATH_10199(5, "⟗", 10199, "MATH_10199", "latex"),

	MATH_10200(5, "⟘", 10200, "MATH_10200", "latex"),

	MATH_10201(5, "⟙", 10201, "MATH_10201", "latex"),

	MATH_10202(5, "⟚", 10202, "MATH_10202", "latex"),

	MATH_10203(5, "⟛", 10203, "MATH_10203", "latex"),

	MATH_10204(5, "⟜", 10204, "MATH_10204", "latex"),

	MATH_10205(5, "⟝", 10205, "MATH_10205", "latex"),

	MATH_10206(5, "⟞", 10206, "MATH_10206", "latex"),

	MATH_10207(5, "⟟", 10207, "MATH_10207", "latex"),

	MATH_10208(5, "⟠", 10208, "MATH_10208", "latex"),

	MATH_10209(5, "⟡", 10209, "MATH_10209", "latex"),

	MATH_10210(5, "⟢", 10210, "MATH_10210", "latex"),

	MATH_10211(5, "⟣", 10211, "MATH_10211", "latex"),

	MATH_10212(5, "⟤", 10212, "MATH_10212", "latex"),

	MATH_10213(5, "⟥", 10213, "MATH_10213", "latex"),

	MATH_10214(5, "⟦", 10214, "MATH_10214", "latex"),

	MATH_10215(5, "⟧", 10215, "MATH_10215", "latex"),

	MATH_10216(5, "⟨", 10216, "MATH_10216", "latex"),

	MATH_10217(5, "⟩", 10217, "MATH_10217", "latex"),

	MATH_10218(5, "⟪", 10218, "MATH_10218", "latex"),

	MATH_10219(5, "⟫", 10219, "MATH_10219", "latex"),

	MATH_10220(5, "⟬", 10220, "MATH_10220", "latex"),

	MATH_10221(5, "⟭", 10221, "MATH_10221", "latex"),

	MATH_10222(5, "⟮", 10222, "MATH_10222", "latex"),

	MATH_10223(5, "⟯", 10223, "MATH_10223", "latex"),

	// ---------- Miscellaneous Mathematical Symbols-B ---

	MATH_10624(6, "⦀", 10624, "MATH_10624", "latex"),

	MATH_10625(6, "⦁", 10625, "MATH_10625", "latex"),

	MATH_10626(6, "⦂", 10626, "MATH_10626", "latex"),

	MATH_10627(6, "⦃", 10627, "MATH_10627", "latex"),

	MATH_10628(6, "⦄", 10628, "MATH_10628", "latex"),

	MATH_10629(6, "⦅", 10629, "MATH_10629", "latex"),

	MATH_10630(6, "⦆", 10630, "MATH_10630", "latex"),

	MATH_10631(6, "⦇", 10631, "MATH_10631", "latex"),

	MATH_10632(6, "⦈", 10632, "MATH_10632", "latex"),

	MATH_10633(6, "⦉", 10633, "MATH_10633", "latex"),

	MATH_10634(6, "⦊", 10634, "MATH_10634", "latex"),

	MATH_10635(6, "⦋", 10635, "MATH_10635", "latex"),

	MATH_10636(6, "⦌", 10636, "MATH_10636", "latex"),

	MATH_10637(6, "⦍", 10637, "MATH_10637", "latex"),

	MATH_10638(6, "⦎", 10638, "MATH_10638", "latex"),

	MATH_10639(6, "⦏", 10639, "MATH_10639", "latex"),

	MATH_10640(6, "⦐", 10640, "MATH_10640", "latex"),

	MATH_10641(6, "⦑", 10641, "MATH_10641", "latex"),

	MATH_10642(6, "⦒", 10642, "MATH_10642", "latex"),

	MATH_10643(6, "⦓", 10643, "MATH_10643", "latex"),

	MATH_10644(6, "⦔", 10644, "MATH_10644", "latex"),

	MATH_10645(6, "⦕", 10645, "MATH_10645", "latex"),

	MATH_10646(6, "⦖", 10646, "MATH_10646", "latex"),

	MATH_10647(6, "⦗", 10647, "MATH_10647", "latex"),

	MATH_10648(6, "⦘", 10648, "MATH_10648", "latex"),

	MATH_10649(6, "⦙", 10649, "MATH_10649", "latex"),

	MATH_10650(6, "⦚", 10650, "MATH_10650", "latex"),

	MATH_10651(6, "⦛", 10651, "MATH_10651", "latex"),

	MATH_10652(6, "⦜", 10652, "MATH_10652", "latex"),

	MATH_10653(6, "⦝", 10653, "MATH_10653", "latex"),

	MATH_10654(6, "⦞", 10654, "MATH_10654", "latex"),

	MATH_10655(6, "⦟", 10655, "MATH_10655", "latex"),

	MATH_10656(6, "⦠", 10656, "MATH_10656", "latex"),

	MATH_10657(6, "⦡", 10657, "MATH_10657", "latex"),

	MATH_10658(6, "⦢", 10658, "MATH_10658", "latex"),

	MATH_10659(6, "⦣", 10659, "MATH_10659", "latex"),

	MATH_10660(6, "⦤", 10660, "MATH_10660", "latex"),

	MATH_10661(6, "⦥", 10661, "MATH_10661", "latex"),

	MATH_10662(6, "⦦", 10662, "MATH_10662", "latex"),

	MATH_10663(6, "⦧", 10663, "MATH_10663", "latex"),

	MATH_10664(6, "⦨", 10664, "MATH_10664", "latex"),

	MATH_10665(6, "⦩", 10665, "MATH_10665", "latex"),

	MATH_10666(6, "⦪", 10666, "MATH_10666", "latex"),

	MATH_10667(6, "⦫", 10667, "MATH_10667", "latex"),

	MATH_10668(6, "⦬", 10668, "MATH_10668", "latex"),

	MATH_10669(6, "⦭", 10669, "MATH_10669", "latex"),

	MATH_10670(6, "⦮", 10670, "MATH_10670", "latex"),

	MATH_10671(6, "⦯", 10671, "MATH_10671", "latex"),

	MATH_10672(6, "⦰", 10672, "MATH_10672", "latex"),

	MATH_10673(6, "⦱", 10673, "MATH_10673", "latex"),

	MATH_10674(6, "⦲", 10674, "MATH_10674", "latex"),

	MATH_10675(6, "⦳", 10675, "MATH_10675", "latex"),

	MATH_10676(6, "⦴", 10676, "MATH_10676", "latex"),

	MATH_10677(6, "⦵", 10677, "MATH_10677", "latex"),

	MATH_10678(6, "⦶", 10678, "MATH_10678", "latex"),

	MATH_10679(6, "⦷", 10679, "MATH_10679", "latex"),

	MATH_10680(6, "⦸", 10680, "MATH_10680", "latex"),

	MATH_10681(6, "⦹", 10681, "MATH_10681", "latex"),

	MATH_10682(6, "⦺", 10682, "MATH_10682", "latex"),

	MATH_10683(6, "⦻", 10683, "MATH_10683", "latex"),

	MATH_10684(6, "⦼", 10684, "MATH_10684", "latex"),

	MATH_10685(6, "⦽", 10685, "MATH_10685", "latex"),

	MATH_10686(6, "⦾", 10686, "MATH_10686", "latex"),

	MATH_10687(6, "⦿", 10687, "MATH_10687", "latex"),

	MATH_10688(6, "⧀", 10688, "MATH_10688", "latex"),

	MATH_10689(6, "⧁", 10689, "MATH_10689", "latex"),

	MATH_10690(6, "⧂", 10690, "MATH_10690", "latex"),

	MATH_10691(6, "⧃", 10691, "MATH_10691", "latex"),

	MATH_10692(6, "⧄", 10692, "MATH_10692", "latex"),

	MATH_10693(6, "⧅", 10693, "MATH_10693", "latex"),

	MATH_10694(6, "⧆", 10694, "MATH_10694", "latex"),

	MATH_10695(6, "⧇", 10695, "MATH_10695", "latex"),

	MATH_10696(6, "⧈", 10696, "MATH_10696", "latex"),

	MATH_10697(6, "⧉", 10697, "MATH_10697", "latex"),

	MATH_10698(6, "⧊", 10698, "MATH_10698", "latex"),

	MATH_10699(6, "⧋", 10699, "MATH_10699", "latex"),

	MATH_10700(6, "⧌", 10700, "MATH_10700", "latex"),

	MATH_10701(6, "⧍", 10701, "MATH_10701", "latex"),

	MATH_10702(6, "⧎", 10702, "MATH_10702", "latex"),

	MATH_10703(6, "⧏", 10703, "MATH_10703", "latex"),

	MATH_10704(6, "⧐", 10704, "MATH_10704", "latex"),

	MATH_10705(6, "⧑", 10705, "MATH_10705", "latex"),

	MATH_10706(6, "⧒", 10706, "MATH_10706", "latex"),

	MATH_10707(6, "⧓", 10707, "MATH_10707", "latex"),

	MATH_10708(6, "⧔", 10708, "MATH_10708", "latex"),

	MATH_10709(6, "⧕", 10709, "MATH_10709", "latex"),

	MATH_10710(6, "⧖", 10710, "MATH_10710", "latex"),

	MATH_10711(6, "⧗", 10711, "MATH_10711", "latex"),

	MATH_10712(6, "⧘", 10712, "MATH_10712", "latex"),

	MATH_10713(6, "⧙", 10713, "MATH_10713", "latex"),

	MATH_10714(6, "⧚", 10714, "MATH_10714", "latex"),

	MATH_10715(6, "⧛", 10715, "MATH_10715", "latex"),

	MATH_10716(6, "⧜", 10716, "MATH_10716", "latex"),

	MATH_10717(6, "⧝", 10717, "MATH_10717", "latex"),

	MATH_10718(6, "⧞", 10718, "MATH_10718", "latex"),

	MATH_10719(6, "⧟", 10719, "MATH_10719", "latex"),

	MATH_10720(6, "⧠", 10720, "MATH_10720", "latex"),

	MATH_10721(6, "⧡", 10721, "MATH_10721", "latex"),

	MATH_10722(6, "⧢", 10722, "MATH_10722", "latex"),

	MATH_10723(6, "⧣", 10723, "MATH_10723", "latex"),

	MATH_10724(6, "⧤", 10724, "MATH_10724", "latex"),

	MATH_10725(6, "⧥", 10725, "MATH_10725", "latex"),

	MATH_10726(6, "⧦", 10726, "MATH_10726", "latex"),

	MATH_10727(6, "⧧", 10727, "MATH_10727", "latex"),

	MATH_10728(6, "⧨", 10728, "MATH_10728", "latex"),

	MATH_10729(6, "⧩", 10729, "MATH_10729", "latex"),

	MATH_10730(6, "⧪", 10730, "MATH_10730", "latex"),

	MATH_10731(6, "⧫", 10731, "MATH_10731", "latex"),

	MATH_10732(6, "⧬", 10732, "MATH_10732", "latex"),

	MATH_10733(6, "⧭", 10733, "MATH_10733", "latex"),

	MATH_10734(6, "⧮", 10734, "MATH_10734", "latex"),

	MATH_10735(6, "⧯", 10735, "MATH_10735", "latex"),

	MATH_10736(6, "⧰", 10736, "MATH_10736", "latex"),

	MATH_10737(6, "⧱", 10737, "MATH_10737", "latex"),

	MATH_10738(6, "⧲", 10738, "MATH_10738", "latex"),

	MATH_10739(6, "⧳", 10739, "MATH_10739", "latex"),

	MATH_10740(6, "⧴", 10740, "MATH_10740", "latex"),

	MATH_10741(6, "⧵", 10741, "MATH_10741", "latex"),

	MATH_10742(6, "⧶", 10742, "MATH_10742", "latex"),

	MATH_10743(6, "⧷", 10743, "MATH_10743", "latex"),

	MATH_10744(6, "⧸", 10744, "MATH_10744", "latex"),

	MATH_10745(6, "⧹", 10745, "MATH_10745", "latex"),

	MATH_10746(6, "⧺", 10746, "MATH_10746", "latex"),

	MATH_10747(6, "⧻", 10747, "MATH_10747", "latex"),

	MATH_10748(6, "⧼", 10748, "MATH_10748", "latex"),

	MATH_10749(6, "⧽", 10749, "MATH_10749", "latex"),

	MATH_10750(6, "⧾", 10750, "MATH_10750", "latex"),

	MATH_10751(6, "⧿", 10751, "MATH_10751", "latex"),

	// ---------- Miscellaneous Technical ---

	MATH_8960(7, "⌀", 8960, "MATH_8960", "latex"),

	MATH_8961(7, "⌁", 8961, "MATH_8961", "latex"),

	MATH_8962(7, "⌂", 8962, "MATH_8962", "latex"),

	MATH_8963(7, "⌃", 8963, "MATH_8963", "latex"),

	MATH_8964(7, "⌄", 8964, "MATH_8964", "latex"),

	MATH_8965(7, "⌅", 8965, "MATH_8965", "latex"),

	MATH_8966(7, "⌆", 8966, "MATH_8966", "latex"),

	MATH_8967(7, "⌇", 8967, "MATH_8967", "latex"),

	MATH_8968(7, "⌈", 8968, "MATH_8968", "latex"),

	MATH_8969(7, "⌉", 8969, "MATH_8969", "latex"),

	MATH_8970(7, "⌊", 8970, "MATH_8970", "latex"),

	MATH_8971(7, "⌋", 8971, "MATH_8971", "latex"),

	MATH_8972(7, "⌌", 8972, "MATH_8972", "latex"),

	MATH_8973(7, "⌍", 8973, "MATH_8973", "latex"),

	MATH_8974(7, "⌎", 8974, "MATH_8974", "latex"),

	MATH_8975(7, "⌏", 8975, "MATH_8975", "latex"),

	MATH_8976(7, "⌐", 8976, "MATH_8976", "latex"),

	MATH_8977(7, "⌑", 8977, "MATH_8977", "latex"),

	MATH_8978(7, "⌒", 8978, "MATH_8978", "latex"),

	MATH_8979(7, "⌓", 8979, "MATH_8979", "latex"),

	MATH_8980(7, "⌔", 8980, "MATH_8980", "latex"),

	MATH_8981(7, "⌕", 8981, "MATH_8981", "latex"),

	MATH_8982(7, "⌖", 8982, "MATH_8982", "latex"),

	MATH_8983(7, "⌗", 8983, "MATH_8983", "latex"),

	MATH_8984(7, "⌘", 8984, "MATH_8984", "latex"),

	MATH_8985(7, "⌙", 8985, "MATH_8985", "latex"),

	MATH_8986(7, "⌚", 8986, "MATH_8986", "latex"),

	MATH_8987(7, "⌛", 8987, "MATH_8987", "latex"),

	MATH_8988(7, "⌜", 8988, "MATH_8988", "latex"),

	MATH_8989(7, "⌝", 8989, "MATH_8989", "latex"),

	MATH_8990(7, "⌞", 8990, "MATH_8990", "latex"),

	MATH_8991(7, "⌟", 8991, "MATH_8991", "latex"),

	MATH_8992(7, "⌠", 8992, "MATH_8992", "latex"),

	MATH_8993(7, "⌡", 8993, "MATH_8993", "latex"),

	MATH_8994(7, "⌢", 8994, "MATH_8994", "latex"),

	MATH_8995(7, "⌣", 8995, "MATH_8995", "latex"),

	MATH_8996(7, "⌤", 8996, "MATH_8996", "latex"),

	MATH_8997(7, "⌥", 8997, "MATH_8997", "latex"),

	MATH_8998(7, "⌦", 8998, "MATH_8998", "latex"),

	MATH_8999(7, "⌧", 8999, "MATH_8999", "latex"),

	MATH_9000(7, "⌨", 9000, "MATH_9000", "latex"),

	MATH_9001(7, "〈", 9001, "MATH_9001", "latex"),

	MATH_9002(7, "〉", 9002, "MATH_9002", "latex"),

	MATH_9003(7, "⌫", 9003, "MATH_9003", "latex"),

	MATH_9004(7, "⌬", 9004, "MATH_9004", "latex"),

	MATH_9005(7, "⌭", 9005, "MATH_9005", "latex"),

	MATH_9006(7, "⌮", 9006, "MATH_9006", "latex"),

	MATH_9007(7, "⌯", 9007, "MATH_9007", "latex"),

	MATH_9008(7, "⌰", 9008, "MATH_9008", "latex"),

	MATH_9009(7, "⌱", 9009, "MATH_9009", "latex"),

	MATH_9010(7, "⌲", 9010, "MATH_9010", "latex"),

	MATH_9011(7, "⌳", 9011, "MATH_9011", "latex"),

	MATH_9012(7, "⌴", 9012, "MATH_9012", "latex"),

	MATH_9013(7, "⌵", 9013, "MATH_9013", "latex"),

	MATH_9014(7, "⌶", 9014, "MATH_9014", "latex"),

	MATH_9015(7, "⌷", 9015, "MATH_9015", "latex"),

	MATH_9016(7, "⌸", 9016, "MATH_9016", "latex"),

	MATH_9017(7, "⌹", 9017, "MATH_9017", "latex"),

	MATH_9018(7, "⌺", 9018, "MATH_9018", "latex"),

	MATH_9019(7, "⌻", 9019, "MATH_9019", "latex"),

	MATH_9020(7, "⌼", 9020, "MATH_9020", "latex"),

	MATH_9021(7, "⌽", 9021, "MATH_9021", "latex"),

	MATH_9022(7, "⌾", 9022, "MATH_9022", "latex"),

	MATH_9023(7, "⌿", 9023, "MATH_9023", "latex"),

	MATH_9024(7, "⍀", 9024, "MATH_9024", "latex"),

	MATH_9025(7, "⍁", 9025, "MATH_9025", "latex"),

	MATH_9026(7, "⍂", 9026, "MATH_9026", "latex"),

	MATH_9027(7, "⍃", 9027, "MATH_9027", "latex"),

	MATH_9028(7, "⍄", 9028, "MATH_9028", "latex"),

	MATH_9029(7, "⍅", 9029, "MATH_9029", "latex"),

	MATH_9030(7, "⍆", 9030, "MATH_9030", "latex"),

	MATH_9031(7, "⍇", 9031, "MATH_9031", "latex"),

	MATH_9032(7, "⍈", 9032, "MATH_9032", "latex"),

	MATH_9033(7, "⍉", 9033, "MATH_9033", "latex"),

	MATH_9034(7, "⍊", 9034, "MATH_9034", "latex"),

	MATH_9035(7, "⍋", 9035, "MATH_9035", "latex"),

	MATH_9036(7, "⍌", 9036, "MATH_9036", "latex"),

	MATH_9037(7, "⍍", 9037, "MATH_9037", "latex"),

	MATH_9038(7, "⍎", 9038, "MATH_9038", "latex"),

	MATH_9039(7, "⍏", 9039, "MATH_9039", "latex"),

	MATH_9040(7, "⍐", 9040, "MATH_9040", "latex"),

	MATH_9041(7, "⍑", 9041, "MATH_9041", "latex"),

	MATH_9042(7, "⍒", 9042, "MATH_9042", "latex"),

	MATH_9043(7, "⍓", 9043, "MATH_9043", "latex"),

	MATH_9044(7, "⍔", 9044, "MATH_9044", "latex"),

	MATH_9045(7, "⍕", 9045, "MATH_9045", "latex"),

	MATH_9046(7, "⍖", 9046, "MATH_9046", "latex"),

	MATH_9047(7, "⍗", 9047, "MATH_9047", "latex"),

	MATH_9048(7, "⍘", 9048, "MATH_9048", "latex"),

	MATH_9049(7, "⍙", 9049, "MATH_9049", "latex"),

	MATH_9050(7, "⍚", 9050, "MATH_9050", "latex"),

	MATH_9051(7, "⍛", 9051, "MATH_9051", "latex"),

	MATH_9052(7, "⍜", 9052, "MATH_9052", "latex"),

	MATH_9053(7, "⍝", 9053, "MATH_9053", "latex"),

	MATH_9054(7, "⍞", 9054, "MATH_9054", "latex"),

	MATH_9055(7, "⍟", 9055, "MATH_9055", "latex"),

	MATH_9056(7, "⍠", 9056, "MATH_9056", "latex"),

	MATH_9057(7, "⍡", 9057, "MATH_9057", "latex"),

	MATH_9058(7, "⍢", 9058, "MATH_9058", "latex"),

	MATH_9059(7, "⍣", 9059, "MATH_9059", "latex"),

	MATH_9060(7, "⍤", 9060, "MATH_9060", "latex"),

	MATH_9061(7, "⍥", 9061, "MATH_9061", "latex"),

	MATH_9062(7, "⍦", 9062, "MATH_9062", "latex"),

	MATH_9063(7, "⍧", 9063, "MATH_9063", "latex"),

	MATH_9064(7, "⍨", 9064, "MATH_9064", "latex"),

	MATH_9065(7, "⍩", 9065, "MATH_9065", "latex"),

	MATH_9066(7, "⍪", 9066, "MATH_9066", "latex"),

	MATH_9067(7, "⍫", 9067, "MATH_9067", "latex"),

	MATH_9068(7, "⍬", 9068, "MATH_9068", "latex"),

	MATH_9069(7, "⍭", 9069, "MATH_9069", "latex"),

	MATH_9070(7, "⍮", 9070, "MATH_9070", "latex"),

	MATH_9071(7, "⍯", 9071, "MATH_9071", "latex"),

	MATH_9072(7, "⍰", 9072, "MATH_9072", "latex"),

	MATH_9073(7, "⍱", 9073, "MATH_9073", "latex"),

	MATH_9074(7, "⍲", 9074, "MATH_9074", "latex"),

	MATH_9075(7, "⍳", 9075, "MATH_9075", "latex"),

	MATH_9076(7, "⍴", 9076, "MATH_9076", "latex"),

	MATH_9077(7, "⍵", 9077, "MATH_9077", "latex"),

	MATH_9078(7, "⍶", 9078, "MATH_9078", "latex"),

	MATH_9079(7, "⍷", 9079, "MATH_9079", "latex"),

	MATH_9080(7, "⍸", 9080, "MATH_9080", "latex"),

	MATH_9081(7, "⍹", 9081, "MATH_9081", "latex"),

	MATH_9082(7, "⍺", 9082, "MATH_9082", "latex"),

	MATH_9083(7, "⍻", 9083, "MATH_9083", "latex"),

	MATH_9084(7, "⍼", 9084, "MATH_9084", "latex"),

	MATH_9085(7, "⍽", 9085, "MATH_9085", "latex"),

	MATH_9086(7, "⍾", 9086, "MATH_9086", "latex"),

	MATH_9087(7, "⍿", 9087, "MATH_9087", "latex"),

	MATH_9088(7, "⎀", 9088, "MATH_9088", "latex"),

	MATH_9089(7, "⎁", 9089, "MATH_9089", "latex"),

	MATH_9090(7, "⎂", 9090, "MATH_9090", "latex"),

	MATH_9091(7, "⎃", 9091, "MATH_9091", "latex"),

	MATH_9092(7, "⎄", 9092, "MATH_9092", "latex"),

	MATH_9093(7, "⎅", 9093, "MATH_9093", "latex"),

	MATH_9094(7, "⎆", 9094, "MATH_9094", "latex"),

	MATH_9095(7, "⎇", 9095, "MATH_9095", "latex"),

	MATH_9096(7, "⎈", 9096, "MATH_9096", "latex"),

	MATH_9097(7, "⎉", 9097, "MATH_9097", "latex"),

	MATH_9098(7, "⎊", 9098, "MATH_9098", "latex"),

	MATH_9099(7, "⎋", 9099, "MATH_9099", "latex"),

	MATH_9100(7, "⎌", 9100, "MATH_9100", "latex"),

	MATH_9101(7, "⎍", 9101, "MATH_9101", "latex"),

	MATH_9102(7, "⎎", 9102, "MATH_9102", "latex"),

	MATH_9103(7, "⎏", 9103, "MATH_9103", "latex"),

	MATH_9104(7, "⎐", 9104, "MATH_9104", "latex"),

	MATH_9105(7, "⎑", 9105, "MATH_9105", "latex"),

	MATH_9106(7, "⎒", 9106, "MATH_9106", "latex"),

	MATH_9107(7, "⎓", 9107, "MATH_9107", "latex"),

	MATH_9108(7, "⎔", 9108, "MATH_9108", "latex"),

	MATH_9109(7, "⎕", 9109, "MATH_9109", "latex"),

	MATH_9110(7, "⎖", 9110, "MATH_9110", "latex"),

	MATH_9111(7, "⎗", 9111, "MATH_9111", "latex"),

	MATH_9112(7, "⎘", 9112, "MATH_9112", "latex"),

	MATH_9113(7, "⎙", 9113, "MATH_9113", "latex"),

	MATH_9114(7, "⎚", 9114, "MATH_9114", "latex"),

	MATH_9115(7, "⎛", 9115, "MATH_9115", "latex"),

	MATH_9116(7, "⎜", 9116, "MATH_9116", "latex"),

	MATH_9117(7, "⎝", 9117, "MATH_9117", "latex"),

	MATH_9118(7, "⎞", 9118, "MATH_9118", "latex"),

	MATH_9119(7, "⎟", 9119, "MATH_9119", "latex"),

	MATH_9120(7, "⎠", 9120, "MATH_9120", "latex"),

	MATH_9121(7, "⎡", 9121, "MATH_9121", "latex"),

	MATH_9122(7, "⎢", 9122, "MATH_9122", "latex"),

	MATH_9123(7, "⎣", 9123, "MATH_9123", "latex"),

	MATH_9124(7, "⎤", 9124, "MATH_9124", "latex"),

	MATH_9125(7, "⎥", 9125, "MATH_9125", "latex"),

	MATH_9126(7, "⎦", 9126, "MATH_9126", "latex"),

	MATH_9127(7, "⎧", 9127, "MATH_9127", "latex"),

	MATH_9128(7, "⎨", 9128, "MATH_9128", "latex"),

	MATH_9129(7, "⎩", 9129, "MATH_9129", "latex"),

	MATH_9130(7, "⎪", 9130, "MATH_9130", "latex"),

	MATH_9131(7, "⎫", 9131, "MATH_9131", "latex"),

	MATH_9132(7, "⎬", 9132, "MATH_9132", "latex"),

	MATH_9133(7, "⎭", 9133, "MATH_9133", "latex"),

	MATH_9134(7, "⎮", 9134, "MATH_9134", "latex"),

	MATH_9135(7, "⎯", 9135, "MATH_9135", "latex"),

	MATH_9136(7, "⎰", 9136, "MATH_9136", "latex"),

	MATH_9137(7, "⎱", 9137, "MATH_9137", "latex"),

	MATH_9138(7, "⎲", 9138, "MATH_9138", "latex"),

	MATH_9139(7, "⎳", 9139, "MATH_9139", "latex"),

	MATH_9140(7, "⎴", 9140, "MATH_9140", "latex"),

	MATH_9141(7, "⎵", 9141, "MATH_9141", "latex"),

	MATH_9142(7, "⎶", 9142, "MATH_9142", "latex"),

	MATH_9143(7, "⎷", 9143, "MATH_9143", "latex"),

	MATH_9144(7, "⎸", 9144, "MATH_9144", "latex"),

	MATH_9145(7, "⎹", 9145, "MATH_9145", "latex"),

	MATH_9146(7, "⎺", 9146, "MATH_9146", "latex"),

	MATH_9147(7, "⎻", 9147, "MATH_9147", "latex"),

	MATH_9148(7, "⎼", 9148, "MATH_9148", "latex"),

	MATH_9149(7, "⎽", 9149, "MATH_9149", "latex"),

	MATH_9150(7, "⎾", 9150, "MATH_9150", "latex"),

	MATH_9151(7, "⎿", 9151, "MATH_9151", "latex"),

	MATH_9152(7, "⏀", 9152, "MATH_9152", "latex"),

	MATH_9153(7, "⏁", 9153, "MATH_9153", "latex"),

	MATH_9154(7, "⏂", 9154, "MATH_9154", "latex"),

	MATH_9155(7, "⏃", 9155, "MATH_9155", "latex"),

	MATH_9156(7, "⏄", 9156, "MATH_9156", "latex"),

	MATH_9157(7, "⏅", 9157, "MATH_9157", "latex"),

	MATH_9158(7, "⏆", 9158, "MATH_9158", "latex"),

	MATH_9159(7, "⏇", 9159, "MATH_9159", "latex"),

	MATH_9160(7, "⏈", 9160, "MATH_9160", "latex"),

	MATH_9161(7, "⏉", 9161, "MATH_9161", "latex"),

	MATH_9162(7, "⏊", 9162, "MATH_9162", "latex"),

	MATH_9163(7, "⏋", 9163, "MATH_9163", "latex"),

	MATH_9164(7, "⏌", 9164, "MATH_9164", "latex"),

	MATH_9165(7, "⏍", 9165, "MATH_9165", "latex"),

	MATH_9166(7, "⏎", 9166, "MATH_9166", "latex"),

	MATH_9167(7, "⏏", 9167, "MATH_9167", "latex"),

	MATH_9168(7, "⏐", 9168, "MATH_9168", "latex"),

	MATH_9169(7, "⏑", 9169, "MATH_9169", "latex"),

	MATH_9170(7, "⏒", 9170, "MATH_9170", "latex"),

	MATH_9171(7, "⏓", 9171, "MATH_9171", "latex"),

	MATH_9172(7, "⏔", 9172, "MATH_9172", "latex"),

	MATH_9173(7, "⏕", 9173, "MATH_9173", "latex"),

	MATH_9174(7, "⏖", 9174, "MATH_9174", "latex"),

	MATH_9175(7, "⏗", 9175, "MATH_9175", "latex"),

	MATH_9176(7, "⏘", 9176, "MATH_9176", "latex"),

	MATH_9177(7, "⏙", 9177, "MATH_9177", "latex"),

	MATH_9178(7, "⏚", 9178, "MATH_9178", "latex"),

	MATH_9179(7, "⏛", 9179, "MATH_9179", "latex"),

	MATH_9180(7, "⏜", 9180, "MATH_9180", "latex"),

	MATH_9181(7, "⏝", 9181, "MATH_9181", "latex"),

	MATH_9182(7, "⏞", 9182, "MATH_9182", "latex"),

	MATH_9183(7, "⏟", 9183, "MATH_9183", "latex"),

	MATH_9184(7, "⏠", 9184, "MATH_9184", "latex"),

	MATH_9185(7, "⏡", 9185, "MATH_9185", "latex"),

	MATH_9186(7, "⏢", 9186, "MATH_9186", "latex"),

	MATH_9187(7, "⏣", 9187, "MATH_9187", "latex"),

	MATH_9188(7, "⏤", 9188, "MATH_9188", "latex"),

	MATH_9189(7, "⏥", 9189, "MATH_9189", "latex"),

	MATH_9190(7, "⏦", 9190, "MATH_9190", "latex"),

	MATH_9191(7, "⏧", 9191, "MATH_9191", "latex"),

	MATH_9192(7, "⏨", 9192, "MATH_9192", "latex"),

	MATH_9193(7, "⏩", 9193, "MATH_9193", "latex"),

	MATH_9194(7, "⏪", 9194, "MATH_9194", "latex"),

	MATH_9195(7, "⏫", 9195, "MATH_9195", "latex"),

	MATH_9196(7, "⏬", 9196, "MATH_9196", "latex"),

	MATH_9197(7, "⏭", 9197, "MATH_9197", "latex"),

	MATH_9198(7, "⏮", 9198, "MATH_9198", "latex"),

	MATH_9199(7, "⏯", 9199, "MATH_9199", "latex"),

	MATH_9200(7, "⏰", 9200, "MATH_9200", "latex"),

	MATH_9201(7, "⏱", 9201, "MATH_9201", "latex"),

	MATH_9202(7, "⏲", 9202, "MATH_9202", "latex"),

	MATH_9203(7, "⏳", 9203, "MATH_9203", "latex"),

	MATH_9204(7, "⏴", 9204, "MATH_9204", "latex"),

	MATH_9205(7, "⏵", 9205, "MATH_9205", "latex"),

	MATH_9206(7, "⏶", 9206, "MATH_9206", "latex"),

	MATH_9207(7, "⏷", 9207, "MATH_9207", "latex"),

	MATH_9208(7, "⏸", 9208, "MATH_9208", "latex"),

	MATH_9209(7, "⏹", 9209, "MATH_9209", "latex"),

	MATH_9210(7, "⏺", 9210, "MATH_9210", "latex"),

	MATH_9211(7, "⏻", 9211, "MATH_9211", "latex"),

	MATH_9212(7, "⏼", 9212, "MATH_9212", "latex"),

	MATH_9213(7, "⏽", 9213, "MATH_9213", "latex"),

	MATH_9214(7, "⏾", 9214, "MATH_9214", "latex"),

	MATH_9215(7, "⏿", 9215, "MATH_9215", "latex"),

	// ---------- Geometric Shapes ---

	MATH_9632(8, "■", 9632, "MATH_9632", "latex"),

	MATH_9633(8, "□", 9633, "MATH_9633", "latex"),

	MATH_9634(8, "▢", 9634, "MATH_9634", "latex"),

	MATH_9635(8, "▣", 9635, "MATH_9635", "latex"),

	MATH_9636(8, "▤", 9636, "MATH_9636", "latex"),

	MATH_9637(8, "▥", 9637, "MATH_9637", "latex"),

	MATH_9638(8, "▦", 9638, "MATH_9638", "latex"),

	MATH_9639(8, "▧", 9639, "MATH_9639", "latex"),

	MATH_9640(8, "▨", 9640, "MATH_9640", "latex"),

	MATH_9641(8, "▩", 9641, "MATH_9641", "latex"),

	MATH_9642(8, "▪", 9642, "MATH_9642", "latex"),

	MATH_9643(8, "▫", 9643, "MATH_9643", "latex"),

	MATH_9644(8, "▬", 9644, "MATH_9644", "latex"),

	MATH_9645(8, "▭", 9645, "MATH_9645", "latex"),

	MATH_9646(8, "▮", 9646, "MATH_9646", "latex"),

	MATH_9647(8, "▯", 9647, "MATH_9647", "latex"),

	MATH_9648(8, "▰", 9648, "MATH_9648", "latex"),

	MATH_9649(8, "▱", 9649, "MATH_9649", "latex"),

	MATH_9650(8, "▲", 9650, "MATH_9650", "latex"),

	MATH_9651(8, "△", 9651, "MATH_9651", "latex"),

	MATH_9652(8, "▴", 9652, "MATH_9652", "latex"),

	MATH_9653(8, "▵", 9653, "MATH_9653", "latex"),

	MATH_9654(8, "▶", 9654, "MATH_9654", "latex"),

	MATH_9655(8, "▷", 9655, "MATH_9655", "latex"),

	MATH_9656(8, "▸", 9656, "MATH_9656", "latex"),

	MATH_9657(8, "▹", 9657, "MATH_9657", "latex"),

	MATH_9658(8, "►", 9658, "MATH_9658", "latex"),

	MATH_9659(8, "▻", 9659, "MATH_9659", "latex"),

	MATH_9660(8, "▼", 9660, "MATH_9660", "latex"),

	MATH_9661(8, "▽", 9661, "MATH_9661", "latex"),

	MATH_9662(8, "▾", 9662, "MATH_9662", "latex"),

	MATH_9663(8, "▿", 9663, "MATH_9663", "latex"),

	MATH_9664(8, "◀", 9664, "MATH_9664", "latex"),

	MATH_9665(8, "◁", 9665, "MATH_9665", "latex"),

	MATH_9666(8, "◂", 9666, "MATH_9666", "latex"),

	MATH_9667(8, "◃", 9667, "MATH_9667", "latex"),

	MATH_9668(8, "◄", 9668, "MATH_9668", "latex"),

	MATH_9669(8, "◅", 9669, "MATH_9669", "latex"),

	MATH_9670(8, "◆", 9670, "MATH_9670", "latex"),

	MATH_9671(8, "◇", 9671, "MATH_9671", "latex"),

	MATH_9672(8, "◈", 9672, "MATH_9672", "latex"),

	MATH_9673(8, "◉", 9673, "MATH_9673", "latex"),

	MATH_9674(8, "◊", 9674, "MATH_9674", "latex"),

	MATH_9675(8, "○", 9675, "MATH_9675", "latex"),

	MATH_9676(8, "◌", 9676, "MATH_9676", "latex"),

	MATH_9677(8, "◍", 9677, "MATH_9677", "latex"),

	MATH_9678(8, "◎", 9678, "MATH_9678", "latex"),

	MATH_9679(8, "●", 9679, "MATH_9679", "latex"),

	MATH_9680(8, "◐", 9680, "MATH_9680", "latex"),

	MATH_9681(8, "◑", 9681, "MATH_9681", "latex"),

	MATH_9682(8, "◒", 9682, "MATH_9682", "latex"),

	MATH_9683(8, "◓", 9683, "MATH_9683", "latex"),

	MATH_9684(8, "◔", 9684, "MATH_9684", "latex"),

	MATH_9685(8, "◕", 9685, "MATH_9685", "latex"),

	MATH_9686(8, "◖", 9686, "MATH_9686", "latex"),

	MATH_9687(8, "◗", 9687, "MATH_9687", "latex"),

	MATH_9688(8, "◘", 9688, "MATH_9688", "latex"),

	MATH_9689(8, "◙", 9689, "MATH_9689", "latex"),

	MATH_9690(8, "◚", 9690, "MATH_9690", "latex"),

	MATH_9691(8, "◛", 9691, "MATH_9691", "latex"),

	MATH_9692(8, "◜", 9692, "MATH_9692", "latex"),

	MATH_9693(8, "◝", 9693, "MATH_9693", "latex"),

	MATH_9694(8, "◞", 9694, "MATH_9694", "latex"),

	MATH_9695(8, "◟", 9695, "MATH_9695", "latex"),

	MATH_9696(8, "◠", 9696, "MATH_9696", "latex"),

	MATH_9697(8, "◡", 9697, "MATH_9697", "latex"),

	MATH_9698(8, "◢", 9698, "MATH_9698", "latex"),

	MATH_9699(8, "◣", 9699, "MATH_9699", "latex"),

	MATH_9700(8, "◤", 9700, "MATH_9700", "latex"),

	MATH_9701(8, "◥", 9701, "MATH_9701", "latex"),

	MATH_9702(8, "◦", 9702, "MATH_9702", "latex"),

	MATH_9703(8, "◧", 9703, "MATH_9703", "latex"),

	MATH_9704(8, "◨", 9704, "MATH_9704", "latex"),

	MATH_9705(8, "◩", 9705, "MATH_9705", "latex"),

	MATH_9706(8, "◪", 9706, "MATH_9706", "latex"),

	MATH_9707(8, "◫", 9707, "MATH_9707", "latex"),

	MATH_9708(8, "◬", 9708, "MATH_9708", "latex"),

	MATH_9709(8, "◭", 9709, "MATH_9709", "latex"),

	MATH_9710(8, "◮", 9710, "MATH_9710", "latex"),

	MATH_9711(8, "◯", 9711, "MATH_9711", "latex"),

	MATH_9712(8, "◰", 9712, "MATH_9712", "latex"),

	MATH_9713(8, "◱", 9713, "MATH_9713", "latex"),

	MATH_9714(8, "◲", 9714, "MATH_9714", "latex"),

	MATH_9715(8, "◳", 9715, "MATH_9715", "latex"),

	MATH_9716(8, "◴", 9716, "MATH_9716", "latex"),

	MATH_9717(8, "◵", 9717, "MATH_9717", "latex"),

	MATH_9718(8, "◶", 9718, "MATH_9718", "latex"),

	MATH_9719(8, "◷", 9719, "MATH_9719", "latex"),

	MATH_9720(8, "◸", 9720, "MATH_9720", "latex"),

	MATH_9721(8, "◹", 9721, "MATH_9721", "latex"),

	MATH_9722(8, "◺", 9722, "MATH_9722", "latex"),

	MATH_9723(8, "◻", 9723, "MATH_9723", "latex"),

	MATH_9724(8, "◼", 9724, "MATH_9724", "latex"),

	MATH_9725(8, "◽", 9725, "MATH_9725", "latex"),

	MATH_9726(8, "◾", 9726, "MATH_9726", "latex"),

	MATH_9727(8, "◿", 9727, "MATH_9727", "latex"),

	// ---------- Miscellaneous Symbols and Arrows ---

	MATH_11008(9, "⬀", 11008, "MATH_11008", "latex"),

	MATH_11009(9, "⬁", 11009, "MATH_11009", "latex"),

	MATH_11010(9, "⬂", 11010, "MATH_11010", "latex"),

	MATH_11011(9, "⬃", 11011, "MATH_11011", "latex"),

	MATH_11012(9, "⬄", 11012, "MATH_11012", "latex"),

	MATH_11013(9, "⬅", 11013, "MATH_11013", "latex"),

	MATH_11014(9, "⬆", 11014, "MATH_11014", "latex"),

	MATH_11015(9, "⬇", 11015, "MATH_11015", "latex"),

	MATH_11016(9, "⬈", 11016, "MATH_11016", "latex"),

	MATH_11017(9, "⬉", 11017, "MATH_11017", "latex"),

	MATH_11018(9, "⬊", 11018, "MATH_11018", "latex"),

	MATH_11019(9, "⬋", 11019, "MATH_11019", "latex"),

	MATH_11020(9, "⬌", 11020, "MATH_11020", "latex"),

	MATH_11021(9, "⬍", 11021, "MATH_11021", "latex"),

	MATH_11022(9, "⬎", 11022, "MATH_11022", "latex"),

	MATH_11023(9, "⬏", 11023, "MATH_11023", "latex"),

	MATH_11024(9, "⬐", 11024, "MATH_11024", "latex"),

	MATH_11025(9, "⬑", 11025, "MATH_11025", "latex"),

	MATH_11026(9, "⬒", 11026, "MATH_11026", "latex"),

	MATH_11027(9, "⬓", 11027, "MATH_11027", "latex"),

	MATH_11028(9, "⬔", 11028, "MATH_11028", "latex"),

	MATH_11029(9, "⬕", 11029, "MATH_11029", "latex"),

	MATH_11030(9, "⬖", 11030, "MATH_11030", "latex"),

	MATH_11031(9, "⬗", 11031, "MATH_11031", "latex"),

	MATH_11032(9, "⬘", 11032, "MATH_11032", "latex"),

	MATH_11033(9, "⬙", 11033, "MATH_11033", "latex"),

	MATH_11034(9, "⬚", 11034, "MATH_11034", "latex"),

	MATH_11035(9, "⬛", 11035, "MATH_11035", "latex"),

	MATH_11036(9, "⬜", 11036, "MATH_11036", "latex"),

	MATH_11037(9, "⬝", 11037, "MATH_11037", "latex"),

	MATH_11038(9, "⬞", 11038, "MATH_11038", "latex"),

	MATH_11039(9, "⬟", 11039, "MATH_11039", "latex"),

	MATH_11040(9, "⬠", 11040, "MATH_11040", "latex"),

	MATH_11041(9, "⬡", 11041, "MATH_11041", "latex"),

	MATH_11042(9, "⬢", 11042, "MATH_11042", "latex"),

	MATH_11043(9, "⬣", 11043, "MATH_11043", "latex"),

	MATH_11044(9, "⬤", 11044, "MATH_11044", "latex"),

	MATH_11045(9, "⬥", 11045, "MATH_11045", "latex"),

	MATH_11046(9, "⬦", 11046, "MATH_11046", "latex"),

	MATH_11047(9, "⬧", 11047, "MATH_11047", "latex"),

	MATH_11048(9, "⬨", 11048, "MATH_11048", "latex"),

	MATH_11049(9, "⬩", 11049, "MATH_11049", "latex"),

	MATH_11050(9, "⬪", 11050, "MATH_11050", "latex"),

	MATH_11051(9, "⬫", 11051, "MATH_11051", "latex"),

	MATH_11052(9, "⬬", 11052, "MATH_11052", "latex"),

	MATH_11053(9, "⬭", 11053, "MATH_11053", "latex"),

	MATH_11054(9, "⬮", 11054, "MATH_11054", "latex"),

	MATH_11055(9, "⬯", 11055, "MATH_11055", "latex"),

	MATH_11056(9, "⬰", 11056, "MATH_11056", "latex"),

	MATH_11057(9, "⬱", 11057, "MATH_11057", "latex"),

	MATH_11058(9, "⬲", 11058, "MATH_11058", "latex"),

	MATH_11059(9, "⬳", 11059, "MATH_11059", "latex"),

	MATH_11060(9, "⬴", 11060, "MATH_11060", "latex"),

	MATH_11061(9, "⬵", 11061, "MATH_11061", "latex"),

	MATH_11062(9, "⬶", 11062, "MATH_11062", "latex"),

	MATH_11063(9, "⬷", 11063, "MATH_11063", "latex"),

	MATH_11064(9, "⬸", 11064, "MATH_11064", "latex"),

	MATH_11065(9, "⬹", 11065, "MATH_11065", "latex"),

	MATH_11066(9, "⬺", 11066, "MATH_11066", "latex"),

	MATH_11067(9, "⬻", 11067, "MATH_11067", "latex"),

	MATH_11068(9, "⬼", 11068, "MATH_11068", "latex"),

	MATH_11069(9, "⬽", 11069, "MATH_11069", "latex"),

	MATH_11070(9, "⬾", 11070, "MATH_11070", "latex"),

	MATH_11071(9, "⬿", 11071, "MATH_11071", "latex"),

	MATH_11072(9, "⭀", 11072, "MATH_11072", "latex"),

	MATH_11073(9, "⭁", 11073, "MATH_11073", "latex"),

	MATH_11074(9, "⭂", 11074, "MATH_11074", "latex"),

	MATH_11075(9, "⭃", 11075, "MATH_11075", "latex"),

	MATH_11076(9, "⭄", 11076, "MATH_11076", "latex"),

	MATH_11077(9, "⭅", 11077, "MATH_11077", "latex"),

	MATH_11078(9, "⭆", 11078, "MATH_11078", "latex"),

	MATH_11079(9, "⭇", 11079, "MATH_11079", "latex"),

	MATH_11080(9, "⭈", 11080, "MATH_11080", "latex"),

	MATH_11081(9, "⭉", 11081, "MATH_11081", "latex"),

	MATH_11082(9, "⭊", 11082, "MATH_11082", "latex"),

	MATH_11083(9, "⭋", 11083, "MATH_11083", "latex"),

	MATH_11084(9, "⭌", 11084, "MATH_11084", "latex"),

	MATH_11085(9, "⭍", 11085, "MATH_11085", "latex"),

	MATH_11086(9, "⭎", 11086, "MATH_11086", "latex"),

	MATH_11087(9, "⭏", 11087, "MATH_11087", "latex"),

	MATH_11088(9, "⭐", 11088, "MATH_11088", "latex"),

	MATH_11089(9, "⭑", 11089, "MATH_11089", "latex"),

	MATH_11090(9, "⭒", 11090, "MATH_11090", "latex"),

	MATH_11091(9, "⭓", 11091, "MATH_11091", "latex"),

	MATH_11092(9, "⭔", 11092, "MATH_11092", "latex"),

	MATH_11093(9, "⭕", 11093, "MATH_11093", "latex"),

	MATH_11094(9, "⭖", 11094, "MATH_11094", "latex"),

	MATH_11095(9, "⭗", 11095, "MATH_11095", "latex"),

	MATH_11096(9, "⭘", 11096, "MATH_11096", "latex"),

	MATH_11097(9, "⭙", 11097, "MATH_11097", "latex"),

	MATH_11098(9, "⭚", 11098, "MATH_11098", "latex"),

	MATH_11099(9, "⭛", 11099, "MATH_11099", "latex"),

	MATH_11100(9, "⭜", 11100, "MATH_11100", "latex"),

	MATH_11101(9, "⭝", 11101, "MATH_11101", "latex"),

	MATH_11102(9, "⭞", 11102, "MATH_11102", "latex"),

	MATH_11103(9, "⭟", 11103, "MATH_11103", "latex"),

	MATH_11104(9, "⭠", 11104, "MATH_11104", "latex"),

	MATH_11105(9, "⭡", 11105, "MATH_11105", "latex"),

	MATH_11106(9, "⭢", 11106, "MATH_11106", "latex"),

	MATH_11107(9, "⭣", 11107, "MATH_11107", "latex"),

	MATH_11108(9, "⭤", 11108, "MATH_11108", "latex"),

	MATH_11109(9, "⭥", 11109, "MATH_11109", "latex"),

	MATH_11110(9, "⭦", 11110, "MATH_11110", "latex"),

	MATH_11111(9, "⭧", 11111, "MATH_11111", "latex"),

	MATH_11112(9, "⭨", 11112, "MATH_11112", "latex"),

	MATH_11113(9, "⭩", 11113, "MATH_11113", "latex"),

	MATH_11114(9, "⭪", 11114, "MATH_11114", "latex"),

	MATH_11115(9, "⭫", 11115, "MATH_11115", "latex"),

	MATH_11116(9, "⭬", 11116, "MATH_11116", "latex"),

	MATH_11117(9, "⭭", 11117, "MATH_11117", "latex"),

	MATH_11118(9, "⭮", 11118, "MATH_11118", "latex"),

	MATH_11119(9, "⭯", 11119, "MATH_11119", "latex"),

	MATH_11120(9, "⭰", 11120, "MATH_11120", "latex"),

	MATH_11121(9, "⭱", 11121, "MATH_11121", "latex"),

	MATH_11122(9, "⭲", 11122, "MATH_11122", "latex"),

	MATH_11123(9, "⭳", 11123, "MATH_11123", "latex"),

	MATH_11124(9, "⭴", 11124, "MATH_11124", "latex"),

	MATH_11125(9, "⭵", 11125, "MATH_11125", "latex"),

	MATH_11126(9, "⭶", 11126, "MATH_11126", "latex"),

	MATH_11127(9, "⭷", 11127, "MATH_11127", "latex"),

	MATH_11128(9, "⭸", 11128, "MATH_11128", "latex"),

	MATH_11129(9, "⭹", 11129, "MATH_11129", "latex"),

	MATH_11130(9, "⭺", 11130, "MATH_11130", "latex"),

	MATH_11131(9, "⭻", 11131, "MATH_11131", "latex"),

	MATH_11132(9, "⭼", 11132, "MATH_11132", "latex"),

	MATH_11133(9, "⭽", 11133, "MATH_11133", "latex"),

	MATH_11134(9, "⭾", 11134, "MATH_11134", "latex"),

	MATH_11135(9, "⭿", 11135, "MATH_11135", "latex"),

	MATH_11136(9, "⮀", 11136, "MATH_11136", "latex"),

	MATH_11137(9, "⮁", 11137, "MATH_11137", "latex"),

	MATH_11138(9, "⮂", 11138, "MATH_11138", "latex"),

	MATH_11139(9, "⮃", 11139, "MATH_11139", "latex"),

	MATH_11140(9, "⮄", 11140, "MATH_11140", "latex"),

	MATH_11141(9, "⮅", 11141, "MATH_11141", "latex"),

	MATH_11142(9, "⮆", 11142, "MATH_11142", "latex"),

	MATH_11143(9, "⮇", 11143, "MATH_11143", "latex"),

	MATH_11144(9, "⮈", 11144, "MATH_11144", "latex"),

	MATH_11145(9, "⮉", 11145, "MATH_11145", "latex"),

	MATH_11146(9, "⮊", 11146, "MATH_11146", "latex"),

	MATH_11147(9, "⮋", 11147, "MATH_11147", "latex"),

	MATH_11148(9, "⮌", 11148, "MATH_11148", "latex"),

	MATH_11149(9, "⮍", 11149, "MATH_11149", "latex"),

	MATH_11150(9, "⮎", 11150, "MATH_11150", "latex"),

	MATH_11151(9, "⮏", 11151, "MATH_11151", "latex"),

	MATH_11152(9, "⮐", 11152, "MATH_11152", "latex"),

	MATH_11153(9, "⮑", 11153, "MATH_11153", "latex"),

	MATH_11154(9, "⮒", 11154, "MATH_11154", "latex"),

	MATH_11155(9, "⮓", 11155, "MATH_11155", "latex"),

	MATH_11156(9, "⮔", 11156, "MATH_11156", "latex"),

	MATH_11157(9, "⮕", 11157, "MATH_11157", "latex"),

	MATH_11158(9, "⮖", 11158, "MATH_11158", "latex"),

	MATH_11159(9, "⮗", 11159, "MATH_11159", "latex"),

	MATH_11160(9, "⮘", 11160, "MATH_11160", "latex"),

	MATH_11161(9, "⮙", 11161, "MATH_11161", "latex"),

	MATH_11162(9, "⮚", 11162, "MATH_11162", "latex"),

	MATH_11163(9, "⮛", 11163, "MATH_11163", "latex"),

	MATH_11164(9, "⮜", 11164, "MATH_11164", "latex"),

	MATH_11165(9, "⮝", 11165, "MATH_11165", "latex"),

	MATH_11166(9, "⮞", 11166, "MATH_11166", "latex"),

	MATH_11167(9, "⮟", 11167, "MATH_11167", "latex"),

	MATH_11168(9, "⮠", 11168, "MATH_11168", "latex"),

	MATH_11169(9, "⮡", 11169, "MATH_11169", "latex"),

	MATH_11170(9, "⮢", 11170, "MATH_11170", "latex"),

	MATH_11171(9, "⮣", 11171, "MATH_11171", "latex"),

	MATH_11172(9, "⮤", 11172, "MATH_11172", "latex"),

	MATH_11173(9, "⮥", 11173, "MATH_11173", "latex"),

	MATH_11174(9, "⮦", 11174, "MATH_11174", "latex"),

	MATH_11175(9, "⮧", 11175, "MATH_11175", "latex"),

	MATH_11176(9, "⮨", 11176, "MATH_11176", "latex"),

	MATH_11177(9, "⮩", 11177, "MATH_11177", "latex"),

	MATH_11178(9, "⮪", 11178, "MATH_11178", "latex"),

	MATH_11179(9, "⮫", 11179, "MATH_11179", "latex"),

	MATH_11180(9, "⮬", 11180, "MATH_11180", "latex"),

	MATH_11181(9, "⮭", 11181, "MATH_11181", "latex"),

	MATH_11182(9, "⮮", 11182, "MATH_11182", "latex"),

	MATH_11183(9, "⮯", 11183, "MATH_11183", "latex"),

	MATH_11184(9, "⮰", 11184, "MATH_11184", "latex"),

	MATH_11185(9, "⮱", 11185, "MATH_11185", "latex"),

	MATH_11186(9, "⮲", 11186, "MATH_11186", "latex"),

	MATH_11187(9, "⮳", 11187, "MATH_11187", "latex"),

	MATH_11188(9, "⮴", 11188, "MATH_11188", "latex"),

	MATH_11189(9, "⮵", 11189, "MATH_11189", "latex"),

	MATH_11190(9, "⮶", 11190, "MATH_11190", "latex"),

	MATH_11191(9, "⮷", 11191, "MATH_11191", "latex"),

	MATH_11192(9, "⮸", 11192, "MATH_11192", "latex"),

	MATH_11193(9, "⮹", 11193, "MATH_11193", "latex"),

	MATH_11194(9, "⮺", 11194, "MATH_11194", "latex"),

	MATH_11195(9, "⮻", 11195, "MATH_11195", "latex"),

	MATH_11196(9, "⮼", 11196, "MATH_11196", "latex"),

	MATH_11197(9, "⮽", 11197, "MATH_11197", "latex"),

	MATH_11198(9, "⮾", 11198, "MATH_11198", "latex"),

	MATH_11199(9, "⮿", 11199, "MATH_11199", "latex"),

	MATH_11200(9, "⯀", 11200, "MATH_11200", "latex"),

	MATH_11201(9, "⯁", 11201, "MATH_11201", "latex"),

	MATH_11202(9, "⯂", 11202, "MATH_11202", "latex"),

	MATH_11203(9, "⯃", 11203, "MATH_11203", "latex"),

	MATH_11204(9, "⯄", 11204, "MATH_11204", "latex"),

	MATH_11205(9, "⯅", 11205, "MATH_11205", "latex"),

	MATH_11206(9, "⯆", 11206, "MATH_11206", "latex"),

	MATH_11207(9, "⯇", 11207, "MATH_11207", "latex"),

	MATH_11208(9, "⯈", 11208, "MATH_11208", "latex"),

	MATH_11209(9, "⯉", 11209, "MATH_11209", "latex"),

	MATH_11210(9, "⯊", 11210, "MATH_11210", "latex"),

	MATH_11211(9, "⯋", 11211, "MATH_11211", "latex"),

	MATH_11212(9, "⯌", 11212, "MATH_11212", "latex"),

	MATH_11213(9, "⯍", 11213, "MATH_11213", "latex"),

	MATH_11214(9, "⯎", 11214, "MATH_11214", "latex"),

	MATH_11215(9, "⯏", 11215, "MATH_11215", "latex"),

	MATH_11216(9, "⯐", 11216, "MATH_11216", "latex"),

	MATH_11217(9, "⯑", 11217, "MATH_11217", "latex"),

	MATH_11218(9, "⯒", 11218, "MATH_11218", "latex"),

	MATH_11219(9, "⯓", 11219, "MATH_11219", "latex"),

	MATH_11220(9, "⯔", 11220, "MATH_11220", "latex"),

	MATH_11221(9, "⯕", 11221, "MATH_11221", "latex"),

	MATH_11222(9, "⯖", 11222, "MATH_11222", "latex"),

	MATH_11223(9, "⯗", 11223, "MATH_11223", "latex"),

	MATH_11224(9, "⯘", 11224, "MATH_11224", "latex"),

	MATH_11225(9, "⯙", 11225, "MATH_11225", "latex"),

	MATH_11226(9, "⯚", 11226, "MATH_11226", "latex"),

	MATH_11227(9, "⯛", 11227, "MATH_11227", "latex"),

	MATH_11228(9, "⯜", 11228, "MATH_11228", "latex"),

	MATH_11229(9, "⯝", 11229, "MATH_11229", "latex"),

	MATH_11230(9, "⯞", 11230, "MATH_11230", "latex"),

	MATH_11231(9, "⯟", 11231, "MATH_11231", "latex"),

	MATH_11232(9, "⯠", 11232, "MATH_11232", "latex"),

	MATH_11233(9, "⯡", 11233, "MATH_11233", "latex"),

	MATH_11234(9, "⯢", 11234, "MATH_11234", "latex"),

	MATH_11235(9, "⯣", 11235, "MATH_11235", "latex"),

	MATH_11236(9, "⯤", 11236, "MATH_11236", "latex"),

	MATH_11237(9, "⯥", 11237, "MATH_11237", "latex"),

	MATH_11238(9, "⯦", 11238, "MATH_11238", "latex"),

	MATH_11239(9, "⯧", 11239, "MATH_11239", "latex"),

	MATH_11240(9, "⯨", 11240, "MATH_11240", "latex"),

	MATH_11241(9, "⯩", 11241, "MATH_11241", "latex"),

	MATH_11242(9, "⯪", 11242, "MATH_11242", "latex"),

	MATH_11243(9, "⯫", 11243, "MATH_11243", "latex"),

	MATH_11244(9, "⯬", 11244, "MATH_11244", "latex"),

	MATH_11245(9, "⯭", 11245, "MATH_11245", "latex"),

	MATH_11246(9, "⯮", 11246, "MATH_11246", "latex"),

	MATH_11247(9, "⯯", 11247, "MATH_11247", "latex"),

	MATH_11248(9, "⯰", 11248, "MATH_11248", "latex"),

	MATH_11249(9, "⯱", 11249, "MATH_11249", "latex"),

	MATH_11250(9, "⯲", 11250, "MATH_11250", "latex"),

	MATH_11251(9, "⯳", 11251, "MATH_11251", "latex"),

	MATH_11252(9, "⯴", 11252, "MATH_11252", "latex"),

	MATH_11253(9, "⯵", 11253, "MATH_11253", "latex"),

	MATH_11254(9, "⯶", 11254, "MATH_11254", "latex"),

	MATH_11255(9, "⯷", 11255, "MATH_11255", "latex"),

	MATH_11256(9, "⯸", 11256, "MATH_11256", "latex"),

	MATH_11257(9, "⯹", 11257, "MATH_11257", "latex"),

	MATH_11258(9, "⯺", 11258, "MATH_11258", "latex"),

	MATH_11259(9, "⯻", 11259, "MATH_11259", "latex"),

	MATH_11260(9, "⯼", 11260, "MATH_11260", "latex"),

	MATH_11261(9, "⯽", 11261, "MATH_11261", "latex"),

	MATH_11262(9, "⯾", 11262, "MATH_11262", "latex"),

	MATH_11263(9, "⯿", 11263, "MATH_11263", "latex"),

	// ---------- Arrows ---

	MATH_8592(10, "←", 8592, "MATH_8592", "latex"),

	MATH_8593(10, "↑", 8593, "MATH_8593", "latex"),

	MATH_8594(10, "→", 8594, "MATH_8594", "latex"),

	MATH_8595(10, "↓", 8595, "MATH_8595", "latex"),

	MATH_8596(10, "↔", 8596, "MATH_8596", "latex"),

	MATH_8597(10, "↕", 8597, "MATH_8597", "latex"),

	MATH_8598(10, "↖", 8598, "MATH_8598", "latex"),

	MATH_8599(10, "↗", 8599, "MATH_8599", "latex"),

	MATH_8600(10, "↘", 8600, "MATH_8600", "latex"),

	MATH_8601(10, "↙", 8601, "MATH_8601", "latex"),

	MATH_8602(10, "↚", 8602, "MATH_8602", "latex"),

	MATH_8603(10, "↛", 8603, "MATH_8603", "latex"),

	MATH_8604(10, "↜", 8604, "MATH_8604", "latex"),

	MATH_8605(10, "↝", 8605, "MATH_8605", "latex"),

	MATH_8606(10, "↞", 8606, "MATH_8606", "latex"),

	MATH_8607(10, "↟", 8607, "MATH_8607", "latex"),

	MATH_8608(10, "↠", 8608, "MATH_8608", "latex"),

	MATH_8609(10, "↡", 8609, "MATH_8609", "latex"),

	MATH_8610(10, "↢", 8610, "MATH_8610", "latex"),

	MATH_8611(10, "↣", 8611, "MATH_8611", "latex"),

	MATH_8612(10, "↤", 8612, "MATH_8612", "latex"),

	MATH_8613(10, "↥", 8613, "MATH_8613", "latex"),

	MATH_8614(10, "↦", 8614, "MATH_8614", "latex"),

	MATH_8615(10, "↧", 8615, "MATH_8615", "latex"),

	MATH_8616(10, "↨", 8616, "MATH_8616", "latex"),

	MATH_8617(10, "↩", 8617, "MATH_8617", "latex"),

	MATH_8618(10, "↪", 8618, "MATH_8618", "latex"),

	MATH_8619(10, "↫", 8619, "MATH_8619", "latex"),

	MATH_8620(10, "↬", 8620, "MATH_8620", "latex"),

	MATH_8621(10, "↭", 8621, "MATH_8621", "latex"),

	MATH_8622(10, "↮", 8622, "MATH_8622", "latex"),

	MATH_8623(10, "↯", 8623, "MATH_8623", "latex"),

	MATH_8624(10, "↰", 8624, "MATH_8624", "latex"),

	MATH_8625(10, "↱", 8625, "MATH_8625", "latex"),

	MATH_8626(10, "↲", 8626, "MATH_8626", "latex"),

	MATH_8627(10, "↳", 8627, "MATH_8627", "latex"),

	MATH_8628(10, "↴", 8628, "MATH_8628", "latex"),

	MATH_8629(10, "↵", 8629, "MATH_8629", "latex"),

	MATH_8630(10, "↶", 8630, "MATH_8630", "latex"),

	MATH_8631(10, "↷", 8631, "MATH_8631", "latex"),

	MATH_8632(10, "↸", 8632, "MATH_8632", "latex"),

	MATH_8633(10, "↹", 8633, "MATH_8633", "latex"),

	MATH_8634(10, "↺", 8634, "MATH_8634", "latex"),

	MATH_8635(10, "↻", 8635, "MATH_8635", "latex"),

	MATH_8636(10, "↼", 8636, "MATH_8636", "latex"),

	MATH_8637(10, "↽", 8637, "MATH_8637", "latex"),

	MATH_8638(10, "↾", 8638, "MATH_8638", "latex"),

	MATH_8639(10, "↿", 8639, "MATH_8639", "latex"),

	MATH_8640(10, "⇀", 8640, "MATH_8640", "latex"),

	MATH_8641(10, "⇁", 8641, "MATH_8641", "latex"),

	MATH_8642(10, "⇂", 8642, "MATH_8642", "latex"),

	MATH_8643(10, "⇃", 8643, "MATH_8643", "latex"),

	MATH_8644(10, "⇄", 8644, "MATH_8644", "latex"),

	MATH_8645(10, "⇅", 8645, "MATH_8645", "latex"),

	MATH_8646(10, "⇆", 8646, "MATH_8646", "latex"),

	MATH_8647(10, "⇇", 8647, "MATH_8647", "latex"),

	MATH_8648(10, "⇈", 8648, "MATH_8648", "latex"),

	MATH_8649(10, "⇉", 8649, "MATH_8649", "latex"),

	MATH_8650(10, "⇊", 8650, "MATH_8650", "latex"),

	MATH_8651(10, "⇋", 8651, "MATH_8651", "latex"),

	MATH_8652(10, "⇌", 8652, "MATH_8652", "latex"),

	MATH_8653(10, "⇍", 8653, "MATH_8653", "latex"),

	MATH_8654(10, "⇎", 8654, "MATH_8654", "latex"),

	MATH_8655(10, "⇏", 8655, "MATH_8655", "latex"),

	MATH_8656(10, "⇐", 8656, "MATH_8656", "latex"),

	MATH_8657(10, "⇑", 8657, "MATH_8657", "latex"),

	MATH_8658(10, "⇒", 8658, "MATH_8658", "latex"),

	MATH_8659(10, "⇓", 8659, "MATH_8659", "latex"),

	MATH_8660(10, "⇔", 8660, "MATH_8660", "latex"),

	MATH_8661(10, "⇕", 8661, "MATH_8661", "latex"),

	MATH_8662(10, "⇖", 8662, "MATH_8662", "latex"),

	MATH_8663(10, "⇗", 8663, "MATH_8663", "latex"),

	MATH_8664(10, "⇘", 8664, "MATH_8664", "latex"),

	MATH_8665(10, "⇙", 8665, "MATH_8665", "latex"),

	MATH_8666(10, "⇚", 8666, "MATH_8666", "latex"),

	MATH_8667(10, "⇛", 8667, "MATH_8667", "latex"),

	MATH_8668(10, "⇜", 8668, "MATH_8668", "latex"),

	MATH_8669(10, "⇝", 8669, "MATH_8669", "latex"),

	MATH_8670(10, "⇞", 8670, "MATH_8670", "latex"),

	MATH_8671(10, "⇟", 8671, "MATH_8671", "latex"),

	MATH_8672(10, "⇠", 8672, "MATH_8672", "latex"),

	MATH_8673(10, "⇡", 8673, "MATH_8673", "latex"),

	MATH_8674(10, "⇢", 8674, "MATH_8674", "latex"),

	MATH_8675(10, "⇣", 8675, "MATH_8675", "latex"),

	MATH_8676(10, "⇤", 8676, "MATH_8676", "latex"),

	MATH_8677(10, "⇥", 8677, "MATH_8677", "latex"),

	MATH_8678(10, "⇦", 8678, "MATH_8678", "latex"),

	MATH_8679(10, "⇧", 8679, "MATH_8679", "latex"),

	MATH_8680(10, "⇨", 8680, "MATH_8680", "latex"),

	MATH_8681(10, "⇩", 8681, "MATH_8681", "latex"),

	MATH_8682(10, "⇪", 8682, "MATH_8682", "latex"),

	MATH_8683(10, "⇫", 8683, "MATH_8683", "latex"),

	MATH_8684(10, "⇬", 8684, "MATH_8684", "latex"),

	MATH_8685(10, "⇭", 8685, "MATH_8685", "latex"),

	MATH_8686(10, "⇮", 8686, "MATH_8686", "latex"),

	MATH_8687(10, "⇯", 8687, "MATH_8687", "latex"),

	MATH_8688(10, "⇰", 8688, "MATH_8688", "latex"),

	MATH_8689(10, "⇱", 8689, "MATH_8689", "latex"),

	MATH_8690(10, "⇲", 8690, "MATH_8690", "latex"),

	MATH_8691(10, "⇳", 8691, "MATH_8691", "latex"),

	MATH_8692(10, "⇴", 8692, "MATH_8692", "latex"),

	MATH_8693(10, "⇵", 8693, "MATH_8693", "latex"),

	MATH_8694(10, "⇶", 8694, "MATH_8694", "latex"),

	MATH_8695(10, "⇷", 8695, "MATH_8695", "latex"),

	MATH_8696(10, "⇸", 8696, "MATH_8696", "latex"),

	MATH_8697(10, "⇹", 8697, "MATH_8697", "latex"),

	MATH_8698(10, "⇺", 8698, "MATH_8698", "latex"),

	MATH_8699(10, "⇻", 8699, "MATH_8699", "latex"),

	MATH_8700(10, "⇼", 8700, "MATH_8700", "latex"),

	MATH_8701(10, "⇽", 8701, "MATH_8701", "latex"),

	MATH_8702(10, "⇾", 8702, "MATH_8702", "latex"),

	MATH_8703(10, "⇿", 8703, "MATH_8703", "latex"),

	// ---------- Supplemental Arrows-A ---

	MATH_10224(11, "⟰", 10224, "MATH_10224", "latex"),

	MATH_10225(11, "⟱", 10225, "MATH_10225", "latex"),

	MATH_10226(11, "⟲", 10226, "MATH_10226", "latex"),

	MATH_10227(11, "⟳", 10227, "MATH_10227", "latex"),

	MATH_10228(11, "⟴", 10228, "MATH_10228", "latex"),

	MATH_10229(11, "⟵", 10229, "MATH_10229", "latex"),

	MATH_10230(11, "⟶", 10230, "MATH_10230", "latex"),

	MATH_10231(11, "⟷", 10231, "MATH_10231", "latex"),

	MATH_10232(11, "⟸", 10232, "MATH_10232", "latex"),

	MATH_10233(11, "⟹", 10233, "MATH_10233", "latex"),

	MATH_10234(11, "⟺", 10234, "MATH_10234", "latex"),

	MATH_10235(11, "⟻", 10235, "MATH_10235", "latex"),

	MATH_10236(11, "⟼", 10236, "MATH_10236", "latex"),

	MATH_10237(11, "⟽", 10237, "MATH_10237", "latex"),

	MATH_10238(11, "⟾", 10238, "MATH_10238", "latex"),

	MATH_10239(11, "⟿", 10239, "MATH_10239", "latex"),

	// ---------- Supplemental Arrows-B ---

	MATH_10496(12, "⤀", 10496, "MATH_10496", "latex"),

	MATH_10497(12, "⤁", 10497, "MATH_10497", "latex"),

	MATH_10498(12, "⤂", 10498, "MATH_10498", "latex"),

	MATH_10499(12, "⤃", 10499, "MATH_10499", "latex"),

	MATH_10500(12, "⤄", 10500, "MATH_10500", "latex"),

	MATH_10501(12, "⤅", 10501, "MATH_10501", "latex"),

	MATH_10502(12, "⤆", 10502, "MATH_10502", "latex"),

	MATH_10503(12, "⤇", 10503, "MATH_10503", "latex"),

	MATH_10504(12, "⤈", 10504, "MATH_10504", "latex"),

	MATH_10505(12, "⤉", 10505, "MATH_10505", "latex"),

	MATH_10506(12, "⤊", 10506, "MATH_10506", "latex"),

	MATH_10507(12, "⤋", 10507, "MATH_10507", "latex"),

	MATH_10508(12, "⤌", 10508, "MATH_10508", "latex"),

	MATH_10509(12, "⤍", 10509, "MATH_10509", "latex"),

	MATH_10510(12, "⤎", 10510, "MATH_10510", "latex"),

	MATH_10511(12, "⤏", 10511, "MATH_10511", "latex"),

	MATH_10512(12, "⤐", 10512, "MATH_10512", "latex"),

	MATH_10513(12, "⤑", 10513, "MATH_10513", "latex"),

	MATH_10514(12, "⤒", 10514, "MATH_10514", "latex"),

	MATH_10515(12, "⤓", 10515, "MATH_10515", "latex"),

	MATH_10516(12, "⤔", 10516, "MATH_10516", "latex"),

	MATH_10517(12, "⤕", 10517, "MATH_10517", "latex"),

	MATH_10518(12, "⤖", 10518, "MATH_10518", "latex"),

	MATH_10519(12, "⤗", 10519, "MATH_10519", "latex"),

	MATH_10520(12, "⤘", 10520, "MATH_10520", "latex"),

	MATH_10521(12, "⤙", 10521, "MATH_10521", "latex"),

	MATH_10522(12, "⤚", 10522, "MATH_10522", "latex"),

	MATH_10523(12, "⤛", 10523, "MATH_10523", "latex"),

	MATH_10524(12, "⤜", 10524, "MATH_10524", "latex"),

	MATH_10525(12, "⤝", 10525, "MATH_10525", "latex"),

	MATH_10526(12, "⤞", 10526, "MATH_10526", "latex"),

	MATH_10527(12, "⤟", 10527, "MATH_10527", "latex"),

	MATH_10528(12, "⤠", 10528, "MATH_10528", "latex"),

	MATH_10529(12, "⤡", 10529, "MATH_10529", "latex"),

	MATH_10530(12, "⤢", 10530, "MATH_10530", "latex"),

	MATH_10531(12, "⤣", 10531, "MATH_10531", "latex"),

	MATH_10532(12, "⤤", 10532, "MATH_10532", "latex"),

	MATH_10533(12, "⤥", 10533, "MATH_10533", "latex"),

	MATH_10534(12, "⤦", 10534, "MATH_10534", "latex"),

	MATH_10535(12, "⤧", 10535, "MATH_10535", "latex"),

	MATH_10536(12, "⤨", 10536, "MATH_10536", "latex"),

	MATH_10537(12, "⤩", 10537, "MATH_10537", "latex"),

	MATH_10538(12, "⤪", 10538, "MATH_10538", "latex"),

	MATH_10539(12, "⤫", 10539, "MATH_10539", "latex"),

	MATH_10540(12, "⤬", 10540, "MATH_10540", "latex"),

	MATH_10541(12, "⤭", 10541, "MATH_10541", "latex"),

	MATH_10542(12, "⤮", 10542, "MATH_10542", "latex"),

	MATH_10543(12, "⤯", 10543, "MATH_10543", "latex"),

	MATH_10544(12, "⤰", 10544, "MATH_10544", "latex"),

	MATH_10545(12, "⤱", 10545, "MATH_10545", "latex"),

	MATH_10546(12, "⤲", 10546, "MATH_10546", "latex"),

	MATH_10547(12, "⤳", 10547, "MATH_10547", "latex"),

	MATH_10548(12, "⤴", 10548, "MATH_10548", "latex"),

	MATH_10549(12, "⤵", 10549, "MATH_10549", "latex"),

	MATH_10550(12, "⤶", 10550, "MATH_10550", "latex"),

	MATH_10551(12, "⤷", 10551, "MATH_10551", "latex"),

	MATH_10552(12, "⤸", 10552, "MATH_10552", "latex"),

	MATH_10553(12, "⤹", 10553, "MATH_10553", "latex"),

	MATH_10554(12, "⤺", 10554, "MATH_10554", "latex"),

	MATH_10555(12, "⤻", 10555, "MATH_10555", "latex"),

	MATH_10556(12, "⤼", 10556, "MATH_10556", "latex"),

	MATH_10557(12, "⤽", 10557, "MATH_10557", "latex"),

	MATH_10558(12, "⤾", 10558, "MATH_10558", "latex"),

	MATH_10559(12, "⤿", 10559, "MATH_10559", "latex"),

	MATH_10560(12, "⥀", 10560, "MATH_10560", "latex"),

	MATH_10561(12, "⥁", 10561, "MATH_10561", "latex"),

	MATH_10562(12, "⥂", 10562, "MATH_10562", "latex"),

	MATH_10563(12, "⥃", 10563, "MATH_10563", "latex"),

	MATH_10564(12, "⥄", 10564, "MATH_10564", "latex"),

	MATH_10565(12, "⥅", 10565, "MATH_10565", "latex"),

	MATH_10566(12, "⥆", 10566, "MATH_10566", "latex"),

	MATH_10567(12, "⥇", 10567, "MATH_10567", "latex"),

	MATH_10568(12, "⥈", 10568, "MATH_10568", "latex"),

	MATH_10569(12, "⥉", 10569, "MATH_10569", "latex"),

	MATH_10570(12, "⥊", 10570, "MATH_10570", "latex"),

	MATH_10571(12, "⥋", 10571, "MATH_10571", "latex"),

	MATH_10572(12, "⥌", 10572, "MATH_10572", "latex"),

	MATH_10573(12, "⥍", 10573, "MATH_10573", "latex"),

	MATH_10574(12, "⥎", 10574, "MATH_10574", "latex"),

	MATH_10575(12, "⥏", 10575, "MATH_10575", "latex"),

	MATH_10576(12, "⥐", 10576, "MATH_10576", "latex"),

	MATH_10577(12, "⥑", 10577, "MATH_10577", "latex"),

	MATH_10578(12, "⥒", 10578, "MATH_10578", "latex"),

	MATH_10579(12, "⥓", 10579, "MATH_10579", "latex"),

	MATH_10580(12, "⥔", 10580, "MATH_10580", "latex"),

	MATH_10581(12, "⥕", 10581, "MATH_10581", "latex"),

	MATH_10582(12, "⥖", 10582, "MATH_10582", "latex"),

	MATH_10583(12, "⥗", 10583, "MATH_10583", "latex"),

	MATH_10584(12, "⥘", 10584, "MATH_10584", "latex"),

	MATH_10585(12, "⥙", 10585, "MATH_10585", "latex"),

	MATH_10586(12, "⥚", 10586, "MATH_10586", "latex"),

	MATH_10587(12, "⥛", 10587, "MATH_10587", "latex"),

	MATH_10588(12, "⥜", 10588, "MATH_10588", "latex"),

	MATH_10589(12, "⥝", 10589, "MATH_10589", "latex"),

	MATH_10590(12, "⥞", 10590, "MATH_10590", "latex"),

	MATH_10591(12, "⥟", 10591, "MATH_10591", "latex"),

	MATH_10592(12, "⥠", 10592, "MATH_10592", "latex"),

	MATH_10593(12, "⥡", 10593, "MATH_10593", "latex"),

	MATH_10594(12, "⥢", 10594, "MATH_10594", "latex"),

	MATH_10595(12, "⥣", 10595, "MATH_10595", "latex"),

	MATH_10596(12, "⥤", 10596, "MATH_10596", "latex"),

	MATH_10597(12, "⥥", 10597, "MATH_10597", "latex"),

	MATH_10598(12, "⥦", 10598, "MATH_10598", "latex"),

	MATH_10599(12, "⥧", 10599, "MATH_10599", "latex"),

	MATH_10600(12, "⥨", 10600, "MATH_10600", "latex"),

	MATH_10601(12, "⥩", 10601, "MATH_10601", "latex"),

	MATH_10602(12, "⥪", 10602, "MATH_10602", "latex"),

	MATH_10603(12, "⥫", 10603, "MATH_10603", "latex"),

	MATH_10604(12, "⥬", 10604, "MATH_10604", "latex"),

	MATH_10605(12, "⥭", 10605, "MATH_10605", "latex"),

	MATH_10606(12, "⥮", 10606, "MATH_10606", "latex"),

	MATH_10607(12, "⥯", 10607, "MATH_10607", "latex"),

	MATH_10608(12, "⥰", 10608, "MATH_10608", "latex"),

	MATH_10609(12, "⥱", 10609, "MATH_10609", "latex"),

	MATH_10610(12, "⥲", 10610, "MATH_10610", "latex"),

	MATH_10611(12, "⥳", 10611, "MATH_10611", "latex"),

	MATH_10612(12, "⥴", 10612, "MATH_10612", "latex"),

	MATH_10613(12, "⥵", 10613, "MATH_10613", "latex"),

	MATH_10614(12, "⥶", 10614, "MATH_10614", "latex"),

	MATH_10615(12, "⥷", 10615, "MATH_10615", "latex"),

	MATH_10616(12, "⥸", 10616, "MATH_10616", "latex"),

	MATH_10617(12, "⥹", 10617, "MATH_10617", "latex"),

	MATH_10618(12, "⥺", 10618, "MATH_10618", "latex"),

	MATH_10619(12, "⥻", 10619, "MATH_10619", "latex"),

	MATH_10620(12, "⥼", 10620, "MATH_10620", "latex"),

	MATH_10621(12, "⥽", 10621, "MATH_10621", "latex"),

	MATH_10622(12, "⥾", 10622, "MATH_10622", "latex"),

	MATH_10623(12, "⥿", 10623, "MATH_10623", "latex"),

	// ---------- Combining Diacritical Marks for Symbols ---

	MATH_8400(13, "⃐", 8400, "MATH_8400", "latex"),

	MATH_8401(13, "⃑", 8401, "MATH_8401", "latex"),

	MATH_8402(13, "⃒", 8402, "MATH_8402", "latex"),

	MATH_8403(13, "⃓", 8403, "MATH_8403", "latex"),

	MATH_8404(13, "⃔", 8404, "MATH_8404", "latex"),

	MATH_8405(13, "⃕", 8405, "MATH_8405", "latex"),

	MATH_8406(13, "⃖", 8406, "MATH_8406", "latex"),

	MATH_8407(13, "⃗", 8407, "MATH_8407", "latex"),

	MATH_8408(13, "⃘", 8408, "MATH_8408", "latex"),

	MATH_8409(13, "⃙", 8409, "MATH_8409", "latex"),

	MATH_8410(13, "⃚", 8410, "MATH_8410", "latex"),

	MATH_8411(13, "⃛", 8411, "MATH_8411", "latex"),

	MATH_8412(13, "⃜", 8412, "MATH_8412", "latex"),

	MATH_8413(13, "⃝", 8413, "MATH_8413", "latex"),

	MATH_8414(13, "⃞", 8414, "MATH_8414", "latex"),

	MATH_8415(13, "⃟", 8415, "MATH_8415", "latex"),

	MATH_8416(13, "⃠", 8416, "MATH_8416", "latex"),

	MATH_8417(13, "⃡", 8417, "MATH_8417", "latex"),

	MATH_8418(13, "⃢", 8418, "MATH_8418", "latex"),

	MATH_8419(13, "⃣", 8419, "MATH_8419", "latex"),

	MATH_8420(13, "⃤", 8420, "MATH_8420", "latex"),

	MATH_8421(13, "⃥", 8421, "MATH_8421", "latex"),

	MATH_8422(13, "⃦", 8422, "MATH_8422", "latex"),

	MATH_8423(13, "⃧", 8423, "MATH_8423", "latex"),

	MATH_8424(13, "⃨", 8424, "MATH_8424", "latex"),

	MATH_8425(13, "⃩", 8425, "MATH_8425", "latex"),

	MATH_8426(13, "⃪", 8426, "MATH_8426", "latex"),

	MATH_8427(13, "⃫", 8427, "MATH_8427", "latex"),

	MATH_8428(13, "⃬", 8428, "MATH_8428", "latex"),

	MATH_8429(13, "⃭", 8429, "MATH_8429", "latex"),

	MATH_8430(13, "⃮", 8430, "MATH_8430", "latex"),

	MATH_8431(13, "⃯", 8431, "MATH_8431", "latex"),

	MATH_8432(13, "⃰", 8432, "MATH_8432", "latex"),

	MATH_8433(13, "⃱", 8433, "MATH_8433", "latex"),

	MATH_8434(13, "⃲", 8434, "MATH_8434", "latex"),

	MATH_8435(13, "⃳", 8435, "MATH_8435", "latex"),

	MATH_8436(13, "⃴", 8436, "MATH_8436", "latex"),

	MATH_8437(13, "⃵", 8437, "MATH_8437", "latex"),

	MATH_8438(13, "⃶", 8438, "MATH_8438", "latex"),

	MATH_8439(13, "⃷", 8439, "MATH_8439", "latex"),

	MATH_8440(13, "⃸", 8440, "MATH_8440", "latex"),

	MATH_8441(13, "⃹", 8441, "MATH_8441", "latex"),

	MATH_8442(13, "⃺", 8442, "MATH_8442", "latex"),

	MATH_8443(13, "⃻", 8443, "MATH_8443", "latex"),

	MATH_8444(13, "⃼", 8444, "MATH_8444", "latex"),

	MATH_8445(13, "⃽", 8445, "MATH_8445", "latex"),

	MATH_8446(13, "⃾", 8446, "MATH_8446", "latex"),

	MATH_8447(13, "⃿", 8447, "MATH_8447", "latex"),

	;

	final private String text;

	final private String image;

	final private String latex;

	final private int block;

	EnLatexMath(int block, String text, int code, String image, String latex) {
		this.block = block;
		this.text = text;
		this.image = image;
		this.latex = latex;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public String getLatex() {
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
		case 1:
			return "Mathematical Operators";
		case 2:
			return "mathematical Operators Supplement";
		case 3:
			return "Mathematical Alphanumeric Symbols";
		case 4:
			return "Letterlike Symbols";
		case 5:
			return "Miscellaneous Mathematical Symbols-A";
		case 6:
			return "Miscellaneous Mathematical Symbols-B";
		case 7:
			return "Miscellaneous Technical";
		case 8:
			return "Geometric Shapes";
		case 9:
			return "Miscellaneous Symbols and Arrows";
		case 10:
			return "Arrows";
		case 11:
			return "Supplemental Arrows-A";
		case 12:
			return "Supplemental Arrows-B";
		case 13:
			return "Combining Diacritical Marks for Symbols";
		}
		return "Not defined Block";
	}

	public static String createAllEnums() {
		StringBuilder sb = new StringBuilder();
		sb.append(createMathUnicode(1, 0x2200, 0x22ff));
		sb.append(createMathUnicode(2, 0x2a00, 0x2aff));
		// sb.append(createMathUnicode(3, 0x1d400, 0x1d7ff));
		sb.append(createMathUnicode(4, 0x2100, 0x214f));
		sb.append(createMathUnicode(5, 0x27c0, 0x27ef));
		sb.append(createMathUnicode(6, 0x2980, 0x29ff));
		sb.append(createMathUnicode(7, 0x2300, 0x23ff));
		sb.append(createMathUnicode(8, 0x25a0, 0x25ff));
		sb.append(createMathUnicode(9, 0x2b00, 0x2bff));
		sb.append(createMathUnicode(10, 0x2190, 0x21ff));
		sb.append(createMathUnicode(11, 0x27f0, 0x27ff));
		sb.append(createMathUnicode(12, 0x2900, 0x297f));
		sb.append(createMathUnicode(13, 0x20d0, 0x20ff));
		sb.append("\n;");
		return sb.toString();
	}

	private static String createMathUnicode(int block, int startCode, int endCode) {

		StringBuilder sb = new StringBuilder();
		int length = endCode - startCode + 1;

		sb.append("\n\n// ---------- " + EnLatexMath.getTitle(block) + " ---\n\n");

		for (int i = 0, code = startCode; i < length; i++, code++) {
			String c = new Character((char) code).toString();
			sb.append("MATH_" + code + "("

					+ block + ", "

					+ "\"" + c + "\", "

					+ code + ", "

					+ "\"" + "MATH_" + code + "\", "

					+ "\"" + "latex" + "\""

					+ "),\n\n");
		}
		return sb.toString();
	}

}
