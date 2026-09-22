package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List.
	 * @return raw listing of all symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms();
}
