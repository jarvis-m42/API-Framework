package tests.base;

import static runner.MyRunListener.test;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import service.ServiceProvider;

@RunWith(DataProviderRunner.class)
public abstract class BaseTest {

	private ServiceProvider serviceprovider;

	protected ServiceProvider service() {
		serviceprovider = new ServiceProvider();
		return serviceprovider;
	}
	
	@SuppressWarnings("deprecation")
	protected <T> void checkThat(String validation, T actual, Matcher<T> expected){
		try {
			Assert.assertThat(validation, actual, expected);
			test.pass(validation + actual);

		} catch (Throwable t) {
			test.fail(String.format("%s %s but is %s", validation,expected, actual ));
		}
	}

	@SuppressWarnings("deprecation")
	protected <T> void checkStatusCode(T actual, Matcher<T> expected) {

		test.info(String.format("Verifying that response status code %s ", expected));
		try {
			Assert.assertThat("Check status code", actual, expected);
			test.pass("Status code is as expected");

		} catch (Throwable t) {
			test.fail(String.format("Status code expected %s but is %s", expected, actual ));
		}
		
	}
}
