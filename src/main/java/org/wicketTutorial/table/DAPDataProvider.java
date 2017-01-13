package org.wicketTutorial.table;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Data provider for displaying and sorting the data in a table.
 * 
 * @author cmanig
 * @param <T>
 */
public class DAPDataProvider<T extends Serializable> extends SortableDataProvider<T, String> {

	/** serialVersionUID */
	private static final long serialVersionUID = 3736097133544313678L;

	/** Logger which writes on the console. */
	private static final Logger log = LoggerFactory.getLogger(DAPDataProvider.class);

	/** The list of all data. */
	private List<T> dataList;
	/** The comparator for sorting. */
	private DAPDataComparator comparator = new DAPDataComparator();

	/**
	 * Constructor which create the data provider and sets the initial sort column and the sort 
	 * order ascending.
	 * 
	 * @param dataList list of all rows which should be displayed
	 * @param startSortField the field name of the initial sort column
	 */
	public DAPDataProvider(List<T> dataList, String startSortField) {
		this.dataList = dataList;
		
		setSort(startSortField, SortOrder.ASCENDING);
	}
	
	@Override
	public Iterator<? extends T> iterator(long first, long count) {
		if (dataList != null) {
			Collections.sort(dataList, comparator);
		} else {
			log.debug("List of data is emtpy!");
		}
		return dataList.subList((int) first, (int) (first + count)).iterator();
	}

	@Override
	public long size() {
		return dataList.size();
	}

	@Override
	public IModel<T> model(T object) {
		return new Model<T>(object);
	}
	

	/**
	 * Inner class comparator for comparing the different objects while sorting.
	 * 
	 * @author cmanig
	 */
	class DAPDataComparator implements Comparator<T>, Serializable {

		/** serialVersionUID */
		private static final long serialVersionUID = 8579887497327236909L;

		@Override
		public int compare(T o1, T o2) {
			PropertyModel<Comparable> model1 = new PropertyModel<Comparable>(o1, getSort().getProperty());
			PropertyModel<Comparable> model2 = new PropertyModel<Comparable>(o2, getSort().getProperty());

			int result = model1.getObject().compareTo(model2.getObject());

			if (!getSort().isAscending()) {
				result = -result;
			}
			return result;
		}
	}
}
