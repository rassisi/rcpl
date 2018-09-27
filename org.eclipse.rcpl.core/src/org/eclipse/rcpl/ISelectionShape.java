package org.eclipse.rcpl;

public interface ISelectionShape {

	void setParagraph(IParagraph paragraph);

	boolean isActive();

	IParagraph getParagraph();

	int getCharacterIndex();

	void setActive(boolean visible);

	void setLocation(IParagraph paragraph, int characterIndex, double x, double y);
}
