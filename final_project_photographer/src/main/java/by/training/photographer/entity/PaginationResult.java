package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PaginationResult <E extends Entity> {

    private int totalRecords;
    private int currentPage;
    private List<E> list;
    private int stepAmount;
    private int totalPages;

    public PaginationResult() {
    }

    public PaginationResult(final int currentPage,
                            final int stepAmount) {
        this.currentPage = currentPage;
        this.stepAmount = stepAmount;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(final int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(final List<E> list) {
        this.list = list;
    }

    public int getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(final int stepAmount) {
        this.stepAmount = stepAmount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginationResult<?> that = (PaginationResult<?>) o;
        return totalRecords == that.totalRecords &&
               currentPage == that.currentPage &&
               stepAmount == that.stepAmount &&
               totalPages == that.totalPages &&
               Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRecords, currentPage, list, stepAmount, totalPages);
    }

    @Override
    public String toString() {
        return "PaginationResult{"
               + "totalRecords=" + totalRecords
               + ", currentPage=" + currentPage
               + ", list=" + list
               + ", stepAmount=" + stepAmount
               + ", totalPages=" + totalPages
               + '}';
    }
}
