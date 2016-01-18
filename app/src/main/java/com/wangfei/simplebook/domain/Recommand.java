package com.wangfei.simplebook.domain;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/1/11.
 */
public class Recommand {

    /**
     * count : 30
     * err : 0
     * items : [{"format":"word","image":null,"published_at":1452470701,"tag":"","user":{"avatar_updated_at":1444845160,"last_visited_at":1424436790,"created_at":1424436790,"state":"active","last_device":"android_6.3.0","role":"n","login":"蒙面超人付小旭","id":25820212,"icon":"20151014175239.jpg"},"image_size":null,"id":114640334,"votes":{"down":-330,"up":14342},"created_at":1452468687,"content":"LZ有极品爸爸一枚~~~平时老爸最不喜欢看广告，每次电视一开始放广告的时候老爸就一顿糟蹋。。。格格驾到。。。今天老爸在剪指甲，听着电视里\u201c这是我的路，我是孟非，我穿39码奥康商务鞋。。。\u201d 爹地不淡定了抬头道： 一大男人穿39码的鞋你还真好意思当那么多人说出来，我闺女都比你脚大。。。脚大。。。大","state":"publish","comments_count":170,"allow_comment":true,"share_count":84,"type":"hot"},{"format":"word","image":null,"published_at":1452465303,"tag":"","user":{"avatar_updated_at":1449061667,"last_visited_at":1359037134,"created_at":1359037134,"state":"bonding","last_device":"web","role":"n","login":"心迷成魔。","id":6191038,"icon":"nopic.jpg"},"image_size":null,"id":114639512,"votes":{"down":-273,"up":10890},"created_at":1452452053,"content":"晚餐，五个人。\n买单时我问，请问可以支付宝或者微信支付？\n服务员说不可以。\n那行，你报警吧。","state":"publish","comments_count":85,"allow_comment":true,"share_count":150,"type":"promote"},{"format":"word","image":null,"published_at":1452466501,"tag":"","user":{"avatar_updated_at":1452436382,"last_visited_at":1452436382,"created_at":1452436382,"state":"active","last_device":"android_9.0.2","role":"n","login":"千面花","id":30939127,"icon":"20160110143302.jpg"},"image_size":null,"id":114639918,"votes":{"down":-182,"up":9598},"created_at":1452463773,"content":"坐公交遇一母子，男孩就6.7岁左右。天气冷，小孩要开窗户，打不开让他妈打开，他妈说打不开没劲。高潮来了，孩子说你打我就有劲，让你开个窗户就没劲。。","state":"publish","comments_count":60,"allow_comment":true,"share_count":89,"type":"hot"},{"format":"word","image":null,"published_at":1452481502,"tag":"","user":{"avatar_updated_at":0,"last_visited_at":1355466559,"created_at":1355466559,"state":"active","last_device":"android_2.1.1","role":"n","login":"xjcjycj","id":5083378,"icon":""},"image_size":null,"id":114641868,"votes":{"down":-99,"up":4473},"created_at":1452478219,"content":"昨天电大监考，看见一个小伙子很不自然，过去一看，大腿上放的书，我说：\u201c同学，这门课是开卷，你可以把书拿到桌子上，\u201d他说：\u201c放上面没有考试的感觉\u201d","state":"publish","comments_count":40,"allow_comment":true,"share_count":25,"type":"hot"},{"format":"image","image":"app114635709.jpg","published_at":1452434102,"tag":"","user":{"avatar_updated_at":1407592043,"last_visited_at":1407587686,"created_at":1407587686,"state":"active","last_device":"android_3.0.5","role":"n","login":"龙哥555","id":19116095,"icon":"20140809214722.jpg"},"image_size":{"s":[189,352,14265],"m":[429,800,66527]},"id":114635709,"votes":{"down":-257,"up":5631},"created_at":1452431688,"content":"在QQ里看到的，","state":"publish","comments_count":80,"allow_comment":true,"share_count":1109,"type":"hot"},{"format":"word","image":null,"published_at":1452506703,"tag":"","user":{"avatar_updated_at":1449859995,"last_visited_at":1449859995,"created_at":1449859995,"state":"active","last_device":"android_8.4.0","role":"n","login":"我有辣条跟我走啊","id":30767379,"icon":"20151211185315.jpg"},"image_size":null,"id":114646991,"votes":{"down":-8,"up":44},"created_at":1452503686,"content":"最近听了一首神曲，不知道大家听过没？！！！啊~~~五环你比四环多一环啊~~~五环你比六环少一环！","state":"publish","comments_count":1,"allow_comment":true,"share_count":0,"type":"fresh"},{"format":"word","image":null,"published_at":1452483903,"tag":"","user":{"avatar_updated_at":1452417681,"last_visited_at":1452417680,"created_at":1452417680,"state":"active","last_device":"android_9.0.2","role":"n","login":"那小九九","id":30937456,"icon":"20160110092120.jpg"},"image_size":null,"id":114642412,"votes":{"down":-129,"up":6165},"created_at":1452480701,"content":"班里有一对双胞胎，长的几乎完全一样就是哥哥比弟弟矮1cm，那二货弟弟经常跑到他哥哥面前，做花痴状特夸张的说：我的天，你太帅了，这五官，这脸型，就像艺术品要是再高个1厘米就太完美了。","state":"publish","comments_count":50,"allow_comment":true,"share_count":42,"type":"hot"},{"high_url":"http://qiubai-video.qiushibaike.com/UV401UNQ0513KNHM.mp4","format":"video","image":null,"published_at":1452506101,"tag":"","user":{"avatar_updated_at":1433960179,"last_visited_at":1372507396,"created_at":1372507396,"state":"bonded","last_device":"ios_2.3.5","role":"n","login":"cjclxyd","id":9746029,"icon":"20150611021619.jpg"},"image_size":null,"id":114644731,"votes":{"down":-9,"up":98},"created_at":1452491041,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/UV401UNQ0513KNHM.jpg","content":"勤劳致富。","state":"publish","comments_count":14,"low_url":"http://qiubai-video.qiushibaike.com/UV401UNQ0513KNHM_3g.mp4","allow_comment":true,"share_count":123,"type":"fresh","loop":13169},{"format":"word","image":null,"published_at":1452474901,"tag":"","user":{"avatar_updated_at":1356780170,"last_visited_at":1349862809,"created_at":1349862809,"state":"active","last_device":"android_2.0.5","role":"n","login":"独霸江南","id":4082008,"icon":"20121229192245.jpg"},"image_size":null,"id":114640787,"votes":{"down":-154,"up":6699},"created_at":1452471972,"content":"记得小时候有一次出去玩儿，忽然下起了冰雹，躲闪不急额头上被砸了好几个包，回到家我妈就问：是不是又和人打架了？\n我：没有，这是天打的。\n我妈：你怎么不说你是雷劈的？","state":"publish","comments_count":33,"allow_comment":true,"share_count":57,"type":"hot"},{"format":"image","image":"app114637526.jpg","published_at":1452442203,"tag":"","user":{"avatar_updated_at":1429711001,"last_visited_at":1425872977,"created_at":1425872977,"state":"active","last_device":"android_6.3.0","role":"n","login":"最有旺夫相","id":26415398,"icon":"20150422215643.jpg"},"image_size":{"s":[198,352,17215],"m":[450,800,74527]},"id":114637526,"votes":{"down":-183,"up":2988},"created_at":1452438466,"content":"快乐，你就不孤单。。。","state":"publish","comments_count":25,"allow_comment":true,"share_count":864,"type":"hot"},{"format":"word","image":null,"published_at":1452483902,"tag":"","user":{"avatar_updated_at":1452120437,"last_visited_at":1448891751,"created_at":1448891751,"state":"active","last_device":"ios_8.2.15","role":"n","login":"微雨的夏","id":30707186,"icon":"20160106224716.jpg"},"image_size":null,"id":114642464,"votes":{"down":-77,"up":3310},"created_at":1452480955,"content":"看过一部剧，女主过马路被车撞濒死，躺在男主怀里说遗言，背景音乐凄婉，正在遗言快说到重点的时候，一辆卡车呼啸而过\u2026世界清静了。这就是被车撞了还在马路中间瞎逼逼的后果。。","state":"publish","comments_count":30,"allow_comment":true,"share_count":20,"type":"hot"},{"format":"word","image":null,"published_at":1452480302,"tag":"","user":{"avatar_updated_at":1410619595,"last_visited_at":1365345569,"created_at":1365345569,"state":"active","last_device":"ios_2.3.3","role":"n","login":"金城武说我帅","id":8218241,"icon":"20140913224633.jpg"},"image_size":null,"id":114641840,"votes":{"down":-121,"up":4725},"created_at":1452478103,"content":"楼下经营着一家要死不活的拉面店，味道也不怎么好，最近却不知道为什么生意爆好，每天挤满了人。出于好奇，我今天去点了碗拉面，直到看见老板那20岁的35D的侄女在拉面，我才明白，老板是高人！","state":"publish","comments_count":105,"allow_comment":true,"share_count":21,"type":"hot"},{"format":"word","image":null,"published_at":1452483302,"tag":"","user":{"avatar_updated_at":1451296578,"last_visited_at":1451296577,"created_at":1451296577,"state":"active","last_device":"android_9.0.0","role":"n","login":"牛皮癣咨询一","id":30861547,"icon":"20151228095617.jpg"},"image_size":null,"id":114642461,"votes":{"down":-118,"up":4496},"created_at":1452480938,"content":"小时候的某个冬天，我一觉醒来，妈妈告诉我:\u201c昨天我和你爸打牌回家，看见你在睡觉，然后我们掀了你被子，看看你冻得醒不，结果你本来睡成大字的，慢慢缩啊缩，缩成了一个虾米你都没醒啊哈哈哈哈哈哈\u2026\u2026\u201d我瞬间凌乱了。我是亲生的？","state":"publish","comments_count":54,"allow_comment":true,"share_count":60,"type":"hot"},{"format":"word","image":null,"published_at":1452498302,"tag":"","user":null,"image_size":null,"id":114645464,"votes":{"down":-8,"up":133},"created_at":1452495254,"content":"悄悄告诉你们一个秘密，上班的时候每次想睡觉了，我都会偷偷跑到厕所，关上门，蹲下来，靠着门睡上10分钟。","state":"publish","comments_count":4,"allow_comment":true,"share_count":0,"type":"fresh"},{"format":"word","image":null,"published_at":1452475502,"tag":"","user":{"avatar_updated_at":1451994617,"last_visited_at":1451994617,"created_at":1451994617,"state":"active","last_device":"android_9.0.2","role":"n","login":"小雅福利","id":30908452,"icon":"20160105115017.jpg"},"image_size":null,"id":114640736,"votes":{"down":-47,"up":2039},"created_at":1452471610,"content":"我给侄子买了两个白椰子。第二天下班回来，侄子给我端来一个水杯，说道:\u201c请姑姑品尝我做的椰子汁儿。\u201d我有点小感动，喝完后感觉味道还真不错，透着天然的椰汁味，就问:\u201d怎么做的？\u201d侄子说:\u201c我先用吸管把椰子汁吸出来，再吐在杯子里，等吸了半杯之后，再兑上水\u2026\u2026\u201d","state":"publish","comments_count":15,"allow_comment":true,"share_count":11,"type":"hot"},{"format":"word","image":null,"published_at":1452464702,"tag":"","user":{"avatar_updated_at":1452436382,"last_visited_at":1452436382,"created_at":1452436382,"state":"active","last_device":"android_9.0.2","role":"n","login":"千面花","id":30939127,"icon":"20160110143302.jpg"},"image_size":null,"id":114639913,"votes":{"down":-209,"up":6708},"created_at":1452463680,"content":"今天吃鱼，爸爸说以前我们家穷很少吃鱼，但是每次吃鱼你爷爷奶奶都是把鱼头吃了剩下鱼肉给我们吃。所以这种传统在我这也不例外，爸爸一下子把整个鱼头夹走了。但是我想问一下爷爷奶奶那时吃的也是剁椒鱼头么？","state":"publish","comments_count":73,"allow_comment":true,"share_count":97,"type":"hot"},{"format":"word","image":null,"published_at":1452472202,"tag":"","user":{"avatar_updated_at":1452501523,"last_visited_at":1421811808,"created_at":1421811808,"state":"active","last_device":"android_6.0.1","role":"n","login":"愿为紳士","id":24955582,"icon":"20160111083842.jpg"},"image_size":null,"id":114640400,"votes":{"down":-145,"up":5713},"created_at":1452469159,"content":"说一真事，LZ高三中午去学校门口洗头，然后听老板在跟客人说话。他一个侄子的老爸去世了，然后就选坟地选了好久家里人都不中意，接着他侄子就来了一句，这都差不多了再好的地能给他种出来啊。种出来。。","state":"publish","comments_count":36,"allow_comment":true,"share_count":32,"type":"hot"},{"format":"image","image":"app114635068.jpg","published_at":1452431701,"tag":"","user":{"avatar_updated_at":1450008578,"last_visited_at":1450008578,"created_at":1450008578,"state":"active","last_device":"android_8.4.0","role":"n","login":"77太阳","id":30776427,"icon":"20151213120938.jpg"},"image_size":{"s":[220,219,11044],"m":[440,438,28081]},"id":114635068,"votes":{"down":-186,"up":3909},"created_at":1452428959,"content":"趁你年少，","state":"publish","comments_count":103,"allow_comment":true,"share_count":407,"type":"hot"},{"format":"word","image":null,"published_at":1452483902,"tag":"","user":{"avatar_updated_at":1451983710,"last_visited_at":1451983709,"created_at":1451983709,"state":"active","last_device":"ios_8.4.6","role":"n","login":"想撸的私我","id":30907743,"icon":"20160105084829.jpg"},"image_size":null,"id":114642591,"votes":{"down":-114,"up":4089},"created_at":1452481464,"content":"刚刚发生的，还热乎呢，割割割割割了闺蜜的二货老公，，，今有一闺蜜结婚，长得的不太漂亮，但是化完妆后很是漂亮，司仪问，新郎，新娘今天漂亮吗，新郎说，漂亮，司仪又问，漂亮的和什么似的，（一般都会说和天仙下凡）二货新郎:\u201d漂亮的和别人的老婆似的。。。。。。。\u201c众人风中凌乱了。。。。","state":"publish","comments_count":27,"allow_comment":true,"share_count":48,"type":"hot"},{"format":"word","image":null,"published_at":1452483602,"tag":"","user":{"avatar_updated_at":1446680395,"last_visited_at":1397976499,"created_at":1397976499,"state":"active","last_device":"ios_2.7.1","role":"n","login":"缺心眼么你","id":15714229,"icon":"20151104233954.jpg"},"image_size":null,"id":114642475,"votes":{"down":-101,"up":3986},"created_at":1452480998,"content":"听人家说冬天洗凉水澡暖和，我就尝试了一下，果然昨晚体温36.5，洗完澡现在到了38.5","state":"publish","comments_count":66,"allow_comment":true,"share_count":24,"type":"hot"},{"high_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8.mp4","format":"video","image":null,"published_at":1452493501,"tag":"","user":{"avatar_updated_at":1451434383,"last_visited_at":1446754034,"created_at":1446754034,"state":"active","last_device":"android_8.2.1","role":"n","login":"想养只可爱的狗狗","id":30571913,"icon":"20151230001302.jpg"},"image_size":null,"id":114641309,"votes":{"down":-48,"up":1057},"created_at":1452475137,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8.jpg","content":"大爷节奏感不错","state":"publish","comments_count":28,"low_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8_3g.mp4","allow_comment":true,"share_count":278,"type":"hot","loop":87365},{"format":"image","image":"app114646805.jpg","published_at":1452507303,"tag":"","user":{"avatar_updated_at":1428286316,"last_visited_at":1428286315,"created_at":1428286315,"state":"active","last_device":"android_6.5.0","role":"n","login":"笑侃人生～","id":27343184,"icon":"20150406101155.jpg"},"image_size":{"s":[198,352,9112],"m":[450,800,44509]},"id":114646805,"votes":{"down":-9,"up":37},"created_at":1452502774,"content":"买了一斤三文鱼孝敬丈母娘，结果清蒸了！我忍着，我看着","state":"publish","comments_count":0,"allow_comment":true,"share_count":0,"type":"fresh"},{"format":"image","image":"app114636738.jpg","published_at":1452438303,"tag":"","user":{"avatar_updated_at":1440091035,"last_visited_at":1416705219,"created_at":1416705219,"state":"active","last_device":"ios_3.3.2","role":"n","login":"Kk姐251215774","id":23007879,"icon":"20150820171717.jpg"},"image_size":{"s":[220,248,14799],"m":[440,496,59920]},"id":114636738,"votes":{"down":-197,"up":2112},"created_at":1452435545,"content":"狗狗的语言好多呀.","state":"publish","comments_count":82,"allow_comment":true,"share_count":387,"type":"hot"},{"format":"word","image":null,"published_at":1452474902,"tag":"","user":{"avatar_updated_at":1450966727,"last_visited_at":1450966726,"created_at":1450966726,"state":"active","last_device":"android_9.0.0","role":"n","login":"邢台王少","id":30839509,"icon":"20151224141846.jpg"},"image_size":null,"id":114640464,"votes":{"down":-132,"up":4253},"created_at":1452469641,"content":"有一异性朋友。。。关系特好。。不过她是个路痴。。。有一天给我打电话让我接她去。。。说她迷路了。。我就过去了。。。到了地方给她打电话问她具体位置在哪。。。然后她说：你往天上看有没有一朵三角形的云。。。我往天上看了一眼。。说看到了。。。结果她说她就在三角形的云正下方。。。当时我就震惊了！！！","state":"publish","comments_count":67,"allow_comment":true,"share_count":123,"type":"hot"},{"high_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W.mp4","format":"video","image":null,"published_at":1452492901,"tag":"","user":{"avatar_updated_at":1451900824,"last_visited_at":1451037244,"created_at":1451037244,"state":"active","last_device":"ios_8.4.6","role":"n","login":"咸盐哥","id":30844072,"icon":"20160104094703.jpg"},"image_size":null,"id":114641235,"votes":{"down":-59,"up":1612},"created_at":1452474709,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W.jpg","content":"歪果仁，从小就这么厉害，我电到了！","state":"publish","comments_count":22,"low_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W_3g.mp4","allow_comment":true,"share_count":256,"type":"hot","loop":72128},{"format":"word","image":null,"published_at":1452479702,"tag":"","user":{"avatar_updated_at":1440837678,"last_visited_at":1372729190,"created_at":1372729190,"state":"active","last_device":"android_2.3.1","role":"n","login":"左手撸残换右手，不撸出血死不休","id":9776137,"icon":"20150829084118.jpg"},"image_size":null,"id":114641787,"votes":{"down":-110,"up":4406},"created_at":1452477861,"content":"一哥们近视，整天戴着眼镜，昨天洗脸把眼镜摘了，我看到就说:你丫不戴眼镜看起来还挺帅的嘛！\n他抬头瞅我一眼说到:我特么不戴眼镜看你也挺帅的。。。","state":"publish","comments_count":23,"allow_comment":true,"share_count":17,"type":"hot"},{"format":"word","image":null,"published_at":1452474302,"tag":"","user":{"avatar_updated_at":1451473065,"last_visited_at":1424654113,"created_at":1424654113,"state":"active","last_device":"android_6.3.0","role":"n","login":"昭昭白玉堂","id":25886566,"icon":"20151230105744.jpg"},"image_size":null,"id":114640430,"votes":{"down":-215,"up":8671},"created_at":1452469376,"content":"哥们入库结婚，三朝回门。傍晚小俩口要回家了！临行前丈母娘拉着女儿，丈人拉着他，分别赠送礼物。嘱咐他们好好过日子。\n  回家拆开一看，一块搓衣板和一套护膝！\n  这算不算传承有序","state":"publish","comments_count":55,"allow_comment":true,"share_count":57,"type":"hot"},{"format":"word","image":null,"published_at":1452474902,"tag":"","user":{"avatar_updated_at":1398919790,"last_visited_at":1356786189,"created_at":1356786189,"state":"active","last_device":"android_2.1.2","role":"n","login":"医然为你","id":5461351,"icon":"20140501124950.jpg"},"image_size":null,"id":114640990,"votes":{"down":-141,"up":5231},"created_at":1452473415,"content":"今天患者跟我说：医生你让我出院吧好么？？\n\n我：不行！你现在你的病情还不能出院的。\n\n患者：我同病房的那个人脚丫子太他妈的臭了，在住下去我得死。\n\n我\u2026\u2026\u2026\u2026\u2026\u2026","state":"publish","comments_count":35,"allow_comment":true,"share_count":38,"type":"hot"},{"format":"word","image":null,"published_at":1452479702,"tag":"","user":{"avatar_updated_at":1444211359,"last_visited_at":1420819938,"created_at":1420819938,"state":"bonded","last_device":"android_3.0.4","role":"n","login":"名字懒的娶","id":24643598,"icon":"20151007094919.jpg"},"image_size":null,"id":114641553,"votes":{"down":-100,"up":4037},"created_at":1452476608,"content":"那天跟媳妇吵架，我大吼道：\u201c实话跟你说，比你漂亮的人多得是比你体贴的人多得是，但是我都没心动，为偏偏娶了你这泼妇？\u201d媳妇淡定地来了句：\u201c因为她们看不上你。我\u2026\u2026","state":"publish","comments_count":28,"allow_comment":true,"share_count":37,"type":"hot"},{"format":"word","image":null,"published_at":1452499501,"tag":"","user":{"avatar_updated_at":1416925567,"last_visited_at":1400375018,"created_at":1400375018,"state":"active","last_device":"android_2.8.6","role":"n","login":"背包丶","id":16320785,"icon":"20141125222606.jpg"},"image_size":null,"id":114645769,"votes":{"down":-7,"up":122},"created_at":1452497015,"content":"今天老师上课时问什么车上人最多，有得同学说公交车，有的说火车，哈哈，还有一个说的是印度的火车，笑死我了，最后我说老汉推得车，卧槽，这掌声。","state":"publish","comments_count":3,"allow_comment":true,"share_count":0,"type":"fresh"}]
     * total : 300
     * page : 1
     * refresh : 300
     */

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    /**
     * format : word
     * image : null
     * published_at : 1452470701
     * tag :
     * user : {"avatar_updated_at":1444845160,"last_visited_at":1424436790,"created_at":1424436790,"state":"active","last_device":"android_6.3.0","role":"n","login":"蒙面超人付小旭","id":25820212,"icon":"20151014175239.jpg"}
     * image_size : null
     * id : 114640334
     * votes : {"down":-330,"up":14342}
     * created_at : 1452468687
     * content : LZ有极品爸爸一枚~~~平时老爸最不喜欢看广告，每次电视一开始放广告的时候老爸就一顿糟蹋。。。格格驾到。。。今天老爸在剪指甲，听着电视里“这是我的路，我是孟非，我穿39码奥康商务鞋。。。” 爹地不淡定了抬头道： 一大男人穿39码的鞋你还真好意思当那么多人说出来，我闺女都比你脚大。。。脚大。。。大
     * state : publish
     * comments_count : 170
     * allow_comment : true
     * share_count : 84
     * type : hot
     */

    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getErr() {
        return err;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getRefresh() {
        return refresh;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity implements Serializable {
        private String high_url;
        private String format;
        private Object image;
        private int published_at;
        private String tag;


        public String getHigh_url() {
            return high_url;
        }

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getLow_url() {
            return low_url;
        }

        public void setLow_url(String low_url) {
            this.low_url = low_url;
        }

        /**
         * avatar_updated_at : 1444845160
         * last_visited_at : 1424436790
         * created_at : 1424436790
         * state : active
         * last_device : android_6.3.0
         * role : n
         * login : 蒙面超人付小旭
         * id : 25820212
         * icon : 20151014175239.jpg
         */

        private UserEntity user;
        private ImageSizeEntity image_size;
        private int id;
        /**
         * down : -330
         * up : 14342
         */

        private VotesEntity votes;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private String pic_url;
        private String low_url;
        private int share_count;

        public List<Integer> getPic_size() {
            return pic_size;
        }

        public void setPic_size(List<Integer> pic_size) {
            this.pic_size = pic_size;
        }

        private List<Integer> pic_size;

        private String type;


        public static class ImageSizeEntity implements Serializable{
            private List<Integer> s;
            private List<Integer> m;

            public static ImageSizeEntity objectFromData(String str) {

                return new Gson().fromJson(str, ImageSizeEntity.class);
            }

            public static ImageSizeEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ImageSizeEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public void setS(List<Integer> s) {
                this.s = s;
            }

            public void setM(List<Integer> m) {
                this.m = m;
            }

            public List<Integer> getS() {
                return s;
            }

            public List<Integer> getM() {
                return m;
            }
        }
            public void setFormat(String format) {
                this.format = format;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public void setPublished_at(int published_at) {
                this.published_at = published_at;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public void setUser(UserEntity user) {
                this.user = user;
            }

            public void setImage_size(ImageSizeEntity image_size) {
                this.image_size = image_size;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setVotes(VotesEntity votes) {
                this.votes = votes;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public void setAllow_comment(boolean allow_comment) {
                this.allow_comment = allow_comment;
            }

            public void setShare_count(int share_count) {
                this.share_count = share_count;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getFormat() {
                return format;
            }

            public Object getImage() {
                return image;
            }

            public int getPublished_at() {
                return published_at;
            }

            public String getTag() {
                return tag;
            }

            public UserEntity getUser() {
                return user;
            }

            public ImageSizeEntity getImage_size() {
                return image_size;
            }

            public int getId() {
                return id;
            }

            public VotesEntity getVotes() {
                return votes;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getContent() {
                return content;
            }

            public String getState() {
                return state;
            }

            public int getComments_count() {
                return comments_count;
            }

            public boolean isAllow_comment() {
                return allow_comment;
            }

            public int getShare_count() {
                return share_count;
            }

            public String getType() {
                return type;
            }

            public static class UserEntity implements Serializable{
                private int avatar_updated_at;
                private int last_visited_at;
                private int created_at;
                private String state;
                private String last_device;
                private String role;
                private String login;
                private int id;
                private String icon;

                public void setAvatar_updated_at(int avatar_updated_at) {
                    this.avatar_updated_at = avatar_updated_at;
                }

                public void setLast_visited_at(int last_visited_at) {
                    this.last_visited_at = last_visited_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public void setLast_device(String last_device) {
                    this.last_device = last_device;
                }

                public void setRole(String role) {
                    this.role = role;
                }

                public void setLogin(String login) {
                    this.login = login;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public int getAvatar_updated_at() {
                    return avatar_updated_at;
                }

                public int getLast_visited_at() {
                    return last_visited_at;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public String getState() {
                    return state;
                }

                public String getLast_device() {
                    return last_device;
                }

                public String getRole() {
                    return role;
                }

                public String getLogin() {
                    return login;
                }

                public int getId() {
                    return id;
                }

                public String getIcon() {
                    return icon;
                }
            }

            public static class VotesEntity implements Serializable{
                private int down;
                private int up;

                public void setDown(int down) {
                    this.down = down;
                }

                public void setUp(int up) {
                    this.up = up;
                }

                public int getDown() {
                    return down;
                }

                public int getUp() {
                    return up;
                }
            }
        }
    }
