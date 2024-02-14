# Observer Pattern 觀察者模式
## Role

- customer: 使用者(觀察者)
- TopicRegistry: 主題註冊中心, 控制每個topic和topic裡的customer(observer)
- publisher: 對某一topic做發布動作

## Use case

1. customer A訂閱topic A(透過topicRegistry)
2. publisher對topic A進行發布, 所有有訂閱topic A的customer會被觸發自己的update method做後續動作(customer A 會觸發update)
3. customer A取消訂閱topic A(透過topicRegistry)
4. publisher對topic A進行發布, 所有有訂閱topic A的customer會被觸發自己的update method做後續動作(customer A已經取消訂閱, 不會觸發update)