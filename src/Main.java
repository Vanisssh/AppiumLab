import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Main extends CoreTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testAddAndRemoveFromReadingList() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.enterSearchLine("The Hobbit");
        searchPageObject.waitForSearchResultToAppear();
        searchPageObject.saveArticleToReadingList();
        searchPageObject.deleteReadingList();
    }
}
