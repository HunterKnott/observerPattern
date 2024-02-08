package op.controller;

public class SnapshotLine {
	private String companyName;
	private String tickerSymbol;
	private float currentPrice;
	private float priceChange;
	private float percentChange;
	private float ytdPercentChange;
	private float yearlyHigh;
	private float yearlyLow;
	private float peRatio;
	
	public SnapshotLine() {
		this.setCompanyName(companyName);
		this.setTickerSymbol(tickerSymbol);
		this.setCurrentPrice(currentPrice);
		this.setPriceChange(priceChange);
		this.setPercentChange(percentChange);
		this.setYtdPercentChange(ytdPercentChange);
		this.setYearlyHigh(yearlyHigh);
		this.setYearlyLow(yearlyLow);
		this.setPeRatio(peRatio);
	}
	
	public String toString() {
		String result = "Company Name: " + getCompanyName()
				+ "\nTicker Symbol: " + getTickerSymbol()
				+ "\nCurrent Price: " + getCurrentPrice()
				+ "\nPrice Change: " + getPriceChange()
				+ "\nPercent Change: " + getPercentChange()
				+ "\nYTD Percent Change: " + getYtdPercentChange()
				+ "\nYearly High: " + getYearlyHigh()
				+ "\nYearly Low: " + getYearlyLow()
				+ "\nPE Ratio: " + getPeRatio() + "\n";
		return result;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(float priceChange) {
		this.priceChange = priceChange;
	}
	
	public float getPercentChange() {
		return percentChange;
	}
	
	public void setPercentChange(float percentChange) {
		this.percentChange = percentChange;
	}

	public float getYtdPercentChange() {
		return ytdPercentChange;
	}

	public void setYtdPercentChange(float ytdPercentChange) {
		this.ytdPercentChange = ytdPercentChange;
	}

	public float getYearlyHigh() {
		return yearlyHigh;
	}

	public void setYearlyHigh(float yearlyHigh) {
		this.yearlyHigh = yearlyHigh;
	}

	public float getYearlyLow() {
		return yearlyLow;
	}

	public void setYearlyLow(float yearlyLow) {
		this.yearlyLow = yearlyLow;
	}

	public float getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(float peRatio) {
		this.peRatio = peRatio;
	}
}
