import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Represents the mappings for a single category of items that should
 * be displayed
 * 
 * @author Catie Baker & Enrique Loza
 *
 */
public class AACCategory implements AACPage {

	 // Fields
    private String categoryName;
    private Map<String, String> items;
	/**
	 * Creates a new empty category with the given name
	 * @param name the name of the category
	 */
	public AACCategory(String name) {
		 this.categoryName = name;
        this.items = new HashMap<>();
	}
	
	/**
	 * Adds the image location, text pairing to the category
	 * @param imageLoc the location of the image
	 * @param text the text that image should speak
	 */
	public void addItem(String imageLoc, String text) {

		items.put(imageLoc,text);

	}

	/**
	 * Returns an array of all the images in the category
	 * @return the array of image locations; if there are no images,
	 * it should return an empty array
	 */
	public String[] getImageLocs() {
		return items.keySet().toArray(new String[0]);
	}

	/**
	 * Returns the name of the category
	 * @return the name of the category
	 */
	public String getCategory() {
		return categoryName;
	}

	/**
	 * Returns the text associated with the given image in this category
	 * @param imageLoc the location of the image
	 * @return the text associated with the image
	 * @throws NoSuchElementException if the image provided is not in the current
	 * 		   category
	 */
	public String select(String imageLoc) {
		if (!items.containsKey(imageLoc)) {
            throw new NoSuchElementException("Image not found in category: " + imageLoc);
        }
        return items.get(imageLoc);
	}

	/**
	 * Determines if the provided images is stored in the category
	 * @param imageLoc the location of the category
	 * @return true if it is in the category, false otherwise
	 */
	public boolean hasImage(String imageLoc) {
		return items.containsKey(imageLoc);
	}
}
