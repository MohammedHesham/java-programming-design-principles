package design.principles;

import java.util.ArrayList;
import java.util.List;

public class MatchAllFilter implements Filter {
    private List<Filter> filters;

    public MatchAllFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {

        for (Filter filter : filters) {
            if (!filter.satisfies(qe))
                return false;
        }

        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
