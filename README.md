# NexumLedger-Java-Blockchain-Framework
企业级高性能区块链底层框架，基于Java构建核心引擎，融合多语言生态，支持联盟链/公链双模式，集成PoW/PoS混合共识、加密算法、智能合约、NFT、跨链桥、分片、零知识证明等全栈区块链功能。

## 项目特性
- 完整区块链核心账本与区块生成机制
- 高性能P2P去中心化网络节点通信
- 企业级加密签名与钱包管理系统
- 智能合约虚拟机与NFT标准化合约
- 跨链资产桥与去中心化预言机
- 分布式存储+IPFS适配层
- 链上治理、质押、验证节点轮换
- 零知识隐私保护与链上审计
- 高可用分片架构与链上监控
- 开箱即用API网关与CLI工具

## 项目文件清单与功能说明
1. **BlockchainCore.java** - 区块链核心引擎，实现创世区块、区块生成、哈希计算、主链管理基础能力
2. **ConsensusPoW.java** - 工作量证明共识算法实现，支持动态难度调整与区块挖矿验证
3. **CryptoEd25519.java** - 高性能Ed25519非对称加密，提供密钥生成、数据签名与验签
4. **TransactionManager.java** - 交易管理模块，处理链上交易创建、缓存与批量打包
5. **WalletManager.java** - 去中心化钱包管理器，支持多钱包创建、地址管理与余额查询
6. **LedgerService.java** - 分布式账本服务，维护账户余额与链上资产转账逻辑
7. **P2PNetworkNode.java** - P2P网络节点模块，实现节点发现、地址管理与对等节点连接
8. **BlockValidator.java** - 区块校验器，全链/单块合法性校验，防止双花与数据篡改
9. **SmartContractEngine.java** - 智能合约执行引擎，支持合约部署、方法调用与状态管理
10. **NFTContract.java** - NFT标准化合约，实现NFT铸造、转让、所有权管理
11. **CrossChainBridge.java** - 跨链桥模块，支持多链资产转移、交易确认与状态同步
12. **ChainDataStorage.java** - 链上数据持久化存储，支持区块落盘与本地加载
13. **MerkleTreeUtil.java** - 默克尔树工具类，生成交易默克尔根，提供交易存在性证明
14. **ChainSyncService.java** - 链数据同步服务，实现节点间最长链匹配与数据对齐
15. **NodeMonitor.java** - 节点状态监控，实时监测在线状态、区块活跃度与对等节点数量
16. **TokenEconomy.java** - 通证经济模型，支持代币发行、销毁、总供应量管控
17. **ContractAuditor.java** - 智能合约安全审计，自动扫描重入、溢出等安全风险
18. **ShardingManager.java** - 区块链分片管理器，实现账户分片、分片路由与分片区块管理
19. **ZeroKnowledgeProof.java** - 零知识证明模块，提供隐私数据验证与匿名交易支持
20. **ChainAPIGateway.java** - 区块链API网关，提供HTTP接口服务，支持区块/交易/账户查询
21. **NodeCLI.java** - 节点命令行交互工具，支持节点状态查询、运维指令执行
22. **ChainMetrics.java** - 链上指标统计，计算TPS、平均出块时间、总交易数
23. **MultiSigWallet.java** - 多签钱包实现，支持多节点签名授权与资产共管
24. **ChainForkResolver.java** - 链分叉 resolver，自动识别分叉点并选择最长有效链
25. **IPFSCacheService.java** - IPFS适配缓存服务，实现数据上链前缓存与CID管理
26. **ChainUpgradeManager.java** - 链上协议升级管理器，支持无硬分叉平滑升级
27. **TransactionPool.java** - 交易优先级池，按手续费/权重排序待打包交易
28. **ValidatorStaking.java** - 验证节点质押系统，支持质押、查询与最低质押门槛
29. **ChainEventBus.java** - 链上事件总线，支持区块/交易/合约事件订阅与发布
30. **BlockJsonSerializer.java** - 区块JSON序列化工具，实现区块数据格式化与解析
31. **ChainPeerDiscovery.java** - 自动节点发现服务，主动扫描网络并添加可信节点
32. **GasCalculator.java** - 燃料费计算器，动态计算交易/合约执行燃料消耗
33. **ChainWhiteList.java** - 联盟链白名单系统，管控节点/账户访问权限
34. **DecentralizedOracle.java** - 去中心化预言机，提供链下数据上链与价格喂价
35. **ChainRecoveryTool.java** - 链数据恢复工具，支持快照恢复与高度回滚
36. **Web3Connector.java** - Web3兼容连接器，适配标准RPC接口与生态工具
37. **ChainPrivacyLayer.java** - 隐私保护层，加密交易数据实现匿名转账
38. **ValidatorRotation.java** - 验证节点轮换机制，随机选择出块节点提升去中心化
39. **ChainRewardDistributor.java** - 出块奖励分发器，按质押比例分配节点奖励
40. **ChainConfigLoader.java** - 配置加载器，读取节点参数、共识配置、网络端口
41. **ChainBenchmark.java** - 性能基准测试，测量出块速度、TPS、吞吐量
42. **ChainIdentityManager.java** - 去中心化身份DID系统，管理链上数字身份
43. **ChainMessageQueue.java** - 链上消息队列，异步处理网络消息与交易广播
44. **ChainLockManager.java** - 分布式锁管理器，保证并发场景下数据一致性
45. **ChainDaemonService.java** - 后台守护服务，执行定时同步、清理、监控任务

## 技术栈
- 核心语言：Java 11+
- 辅助语言：Go/Python/JavaScript/Solidity
- 网络：TCP P2P、HTTP API
- 加密：SHA-256、Ed25519、ZKP
- 存储：本地文件系统、IPFS适配
- 架构：微服务、分片、模块化

## 适用场景
- 联盟链底层平台
- 数字资产发行与管理
- NFT发行与交易市场
- 跨链资产流转
- 供应链金融上链
- 去中心化身份认证
- 链上数据存证
