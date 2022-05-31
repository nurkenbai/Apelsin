package com.company.entity;

import com.company.enums.StatusEnum;
import com.company.enums.TranStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionsEntity extends BestEntity {
    @Column(name = "from_card_id")
    private String fromCardId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_card_id", insertable = false, updatable = false)
    private CardEntity fromCard;

    @Column(name = "to_card_id")
    private String toCardId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_card_id", insertable = false, updatable = false)
    private CardEntity toCard;

    @Column
    private Long amount;
    @Column
    @Enumerated(EnumType.STRING)
    private TranStatus status;

}
