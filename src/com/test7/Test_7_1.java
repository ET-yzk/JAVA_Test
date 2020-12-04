package com.test7;

enum PayEnum implements Message {
    Cash("现金") {
        @Override
        public void show() {
            this.mount = 1000;
            System.out.printf("%s支付%.1f元\n", this.type, this.mount);
        }
    },
    WeChatPay("微信") {
        @Override
        public void show() {
            this.mount = 19999.9;
            System.out.printf("%s支付%.1f元\n", this.type, this.mount);
        }
    },
    AliPay("阿里") {
        @Override
        public void show() {
            this.mount = 6666.6;
            System.out.printf("%s支付%.1f元\n", this.type, this.mount);
        }
    },
    BankCard("银行卡") {
        @Override
        public void show() {
            this.mount = 10000;
            System.out.printf("%s支付%.1f元\n", this.type, this.mount);
        }
    },
    CreditCard("信用卡") {
        @Override
        public void show() {
            this.mount = 8888.8;
            System.out.printf("%s支付%.1f元\n", this.type, this.mount);
        }
    };

    final String type;// 支付类型
    double mount;// 支付金额

    PayEnum(String type) {
        this.type = type;
    }
}

interface Message {
    void show();
}

public class Test_7_1 {
    public static void main(String[] args) {
        PayEnum Cash = PayEnum.Cash;
        PayEnum WeChatPay = PayEnum.WeChatPay;
        PayEnum AliPay = PayEnum.AliPay;
        PayEnum BankCard = PayEnum.BankCard;
        PayEnum CreditCard = PayEnum.CreditCard;

        Cash.show();
        WeChatPay.show();
        AliPay.show();
        BankCard.show();
        CreditCard.show();
    }
}
