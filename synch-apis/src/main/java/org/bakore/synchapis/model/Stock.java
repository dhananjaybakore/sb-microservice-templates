package org.bakore.synchapis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("stock")
@Getter @Setter @NoArgsConstructor
public class Stock {
    @Id
    private String symbol;

    private double ytdHigh;
    private double ytdLow;
    private double startBuyAtValue;
    private double buyIncrements;
    private double sellIncrements;
    private double startSellAtValue;
}
