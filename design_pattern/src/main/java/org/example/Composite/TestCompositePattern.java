package main.java.org.example.Composite;

public class TestCompositePattern {

	public static void main(String[] args) {
		HtmlTag parentTag = new HtmlParentElement("<html>");
		parentTag.setStartTag("<html>");
		parentTag.setEndTag("</html>");
		
		HtmlTag p1 = new HtmlParentElement("<body>");
		p1.setStartTag("<body>");
		p1.setEndTag("</body>");
		
		parentTag.addChildTag(p1);
		
		HtmlTag child1 = new HtmlElement("<p>");
		child1.setStartTag("<p>");
		child1.setEndTag("</p>");
		child1.setTagBody("Testing html tag library");
		p1.addChildTag(child1);
		
		child1 = new HtmlElement("<p>");
		child1.setStartTag("<p>");
		child1.setEndTag("</p>");
		child1.setTagBody("Paragraph 2");
		p1.addChildTag(child1);


		HtmlTag p2 = new HtmlParentElement("<div>");
		p2.setStartTag("<div>");
		p2.setEndTag("</div>");
		p1.addChildTag(p2);

		HtmlTag child2 = new HtmlElement("column");
		child2.setStartTag("<col1>");
		child2.setEndTag("</col1>");
		child2.setTagBody("col1 content");
		p2.addChildTag(child2);
		
		parentTag.generateHtml();
		
	}

}
