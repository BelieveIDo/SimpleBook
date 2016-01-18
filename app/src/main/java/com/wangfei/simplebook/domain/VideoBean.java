package com.wangfei.simplebook.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class VideoBean implements Serializable{


    /**
     * count : 30
     * err : 0
     * items : [{"high_url":"http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM.mp4","format":"video","image":null,"published_at":1452473101,"tag":"","user":{"avatar_updated_at":1394678596,"last_visited_at":1380072973,"created_at":1380072973,"state":"active","last_device":"android_2.6","role":"n","login":"永and恒","id":11413184,"icon":"20140313104316.jpg"},"image_size":null,"id":114635185,"votes":{"down":-143,"up":4888},"created_at":1452429465,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM.jpg","content":"可惜只有十秒","state":"publish","comments_count":125,"low_url":"http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM_3g.mp4","allow_comment":true,"share_count":2980,"type":"hot","loop":208946},{"high_url":"http://qiubai-video.qiushibaike.com/3Z4PGLP4U6LNTL6G.mp4","format":"video","image":null,"published_at":1452469502,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114637995,"votes":{"down":-84,"up":4324},"created_at":1452440357,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/3Z4PGLP4U6LNTL6G.jpg","content":"你是谁啊？","state":"publish","comments_count":56,"low_url":"http://qiubai-video.qiushibaike.com/3Z4PGLP4U6LNTL6G_3g.mp4","allow_comment":true,"share_count":881,"type":"hot","loop":251794},{"high_url":"http://qiubai-video.qiushibaike.com/8BXSMJGUBO75T2JG.mp4","format":"video","image":null,"published_at":1452471301,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114637838,"votes":{"down":-88,"up":3159},"created_at":1452439768,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/8BXSMJGUBO75T2JG.jpg","content":"人生如戏 ，全靠演技～","state":"publish","comments_count":104,"low_url":"http://qiubai-video.qiushibaike.com/8BXSMJGUBO75T2JG_3g.mp4","allow_comment":true,"share_count":200,"type":"hot","loop":196522},{"high_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8.mp4","format":"video","image":null,"published_at":1452493501,"tag":"","user":{"avatar_updated_at":1451434383,"last_visited_at":1446754034,"created_at":1446754034,"state":"active","last_device":"android_8.2.1","role":"n","login":"想养只可爱的狗狗","id":30571913,"icon":"20151230001302.jpg"},"image_size":null,"id":114641309,"votes":{"down":-23,"up":437},"created_at":1452475137,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8.jpg","content":"大爷节奏感不错","state":"publish","comments_count":17,"low_url":"http://qiubai-video.qiushibaike.com/SIX3FDQOSO31F5I8_3g.mp4","allow_comment":true,"share_count":124,"loop":44470},{"high_url":"http://qiubai-video.qiushibaike.com/GXGK63PQLBGZD1HI.mp4","format":"video","image":null,"published_at":1452492601,"tag":"","user":{"avatar_updated_at":1448708543,"last_visited_at":1448708486,"created_at":1448708486,"state":"active","last_device":"android_8.0.2","role":"n","login":"yun盘叁拾","id":30696190,"icon":"20151128110223.jpg"},"image_size":null,"id":114641919,"votes":{"down":-35,"up":636},"created_at":1452478472,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/GXGK63PQLBGZD1HI.jpg","content":"游戏好玩不？","state":"publish","comments_count":28,"low_url":"http://qiubai-video.qiushibaike.com/GXGK63PQLBGZD1HI_3g.mp4","allow_comment":true,"share_count":119,"loop":52024},{"high_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W.mp4","format":"video","image":null,"published_at":1452492901,"tag":"","user":{"avatar_updated_at":1451900824,"last_visited_at":1451037244,"created_at":1451037244,"state":"active","last_device":"ios_8.4.6","role":"n","login":"咸盐哥","id":30844072,"icon":"20160104094703.jpg"},"image_size":null,"id":114641235,"votes":{"down":-40,"up":890},"created_at":1452474709,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W.jpg","content":"歪果仁，从小就这么厉害，我电到了！","state":"publish","comments_count":16,"low_url":"http://qiubai-video.qiushibaike.com/IHG207WM8KO3AH6W_3g.mp4","allow_comment":true,"share_count":155,"loop":46158},{"high_url":"http://qiubai-video.qiushibaike.com/8PTT72A2Q3AWM8E6.mp4","format":"video","image":null,"published_at":1452489001,"tag":"","user":{"avatar_updated_at":1450813341,"last_visited_at":1433341040,"created_at":1433341040,"state":"active","last_device":"android_7.0.0","role":"n","login":"╰忆兮思黄昏","id":28778468,"icon":"20151222194220.jpg"},"image_size":null,"id":114642698,"votes":{"down":-38,"up":892},"created_at":1452481905,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/8PTT72A2Q3AWM8E6.jpg","content":"哈哈哈哈哈哈","state":"publish","comments_count":29,"low_url":"http://qiubai-video.qiushibaike.com/8PTT72A2Q3AWM8E6_3g.mp4","allow_comment":true,"share_count":86,"loop":35160},{"high_url":"http://qiubai-video.qiushibaike.com/GPCY3S33JTH4SDVI.mp4","format":"video","image":null,"published_at":1452492001,"tag":"","user":{"avatar_updated_at":1451900824,"last_visited_at":1451037244,"created_at":1451037244,"state":"active","last_device":"ios_8.4.6","role":"n","login":"咸盐哥","id":30844072,"icon":"20160104094703.jpg"},"image_size":null,"id":114641181,"votes":{"down":-24,"up":325},"created_at":1452474417,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/GPCY3S33JTH4SDVI.jpg","content":"困成这样了","state":"publish","comments_count":17,"low_url":"http://qiubai-video.qiushibaike.com/GPCY3S33JTH4SDVI_3g.mp4","allow_comment":true,"share_count":53,"loop":34054},{"high_url":"http://qiubai-video.qiushibaike.com/S1QG01VQ2S34KD2O.mp4","format":"video","image":null,"published_at":1452493202,"tag":"","user":{"avatar_updated_at":1418807589,"last_visited_at":1413080644,"created_at":1413080644,"state":"active","last_device":"android_3.3.1","role":"n","login":"五金交电","id":21622731,"icon":"20141217171308.jpg"},"image_size":null,"id":114641878,"votes":{"down":-33,"up":259},"created_at":1452478279,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/S1QG01VQ2S34KD2O.jpg","content":"再来五个字","state":"publish","comments_count":10,"low_url":"http://qiubai-video.qiushibaike.com/S1QG01VQ2S34KD2O_3g.mp4","allow_comment":true,"share_count":73,"loop":20755},{"high_url":"http://qiubai-video.qiushibaike.com/YJFQNO780OUY73BA.mp4","format":"video","image":null,"published_at":1452487802,"tag":"","user":{"avatar_updated_at":1451177474,"last_visited_at":1415072336,"created_at":1415072336,"state":"active","last_device":"android_3.4.0","role":"n","login":"琥珀蜜蜡加工销售","id":22357299,"icon":"20151227005113.jpg"},"image_size":null,"id":114643019,"votes":{"down":-133,"up":1521},"created_at":1452483246,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/YJFQNO780OUY73BA.jpg","content":"旁人得是啥眼神","state":"publish","comments_count":72,"low_url":"http://qiubai-video.qiushibaike.com/YJFQNO780OUY73BA_3g.mp4","allow_comment":true,"share_count":843,"type":"hot","loop":114427},{"high_url":"http://qiubai-video.qiushibaike.com/NLAUEVJWKB4WP13D.mp4","format":"video","image":null,"published_at":1452489601,"tag":"","user":{"avatar_updated_at":1452109443,"last_visited_at":1450831401,"created_at":1450831401,"state":"active","last_device":"android_9.0.0","role":"n","login":"妞、爺娶伱","id":30830130,"icon":"20160106194403.jpg"},"image_size":null,"id":114642709,"votes":{"down":-47,"up":343},"created_at":1452481946,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/NLAUEVJWKB4WP13D.jpg","content":"看短片说话","state":"publish","comments_count":10,"low_url":"http://qiubai-video.qiushibaike.com/NLAUEVJWKB4WP13D_3g.mp4","allow_comment":true,"share_count":117,"loop":58318},{"high_url":"http://qiubai-video.qiushibaike.com/W059MREBSS46CTQG.mp4","format":"video","image":null,"published_at":1452491401,"tag":"","user":{"avatar_updated_at":1451992657,"last_visited_at":1447887380,"created_at":1447887380,"state":"active","last_device":"android_8.3.3","role":"n","login":"能换就换","id":30642606,"icon":"20160105111736.jpg"},"image_size":null,"id":114643133,"votes":{"down":-42,"up":389},"created_at":1452483647,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/W059MREBSS46CTQG.jpg","content":"结局亮瞎了","state":"publish","comments_count":24,"low_url":"http://qiubai-video.qiushibaike.com/W059MREBSS46CTQG_3g.mp4","allow_comment":true,"share_count":67,"loop":72580},{"high_url":"http://qiubai-video.qiushibaike.com/AIAILME31UWFRE7A.mp4","format":"video","image":null,"published_at":1452486301,"tag":"","user":{"avatar_updated_at":1448911828,"last_visited_at":1446137096,"created_at":1446137096,"state":"active","last_device":"ios_8.0.15","role":"n","login":"玛咖，微xp3252","id":30535916,"icon":"20151130193027.jpg"},"image_size":null,"id":114638559,"votes":{"down":-108,"up":1623},"created_at":1452442875,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/AIAILME31UWFRE7A.jpg","content":"看你包你笑了，看男的表情","state":"publish","comments_count":56,"low_url":"http://qiubai-video.qiushibaike.com/AIAILME31UWFRE7A_3g.mp4","allow_comment":true,"share_count":367,"type":"hot","loop":143174},{"high_url":"http://qiubai-video.qiushibaike.com/B4UND4ZDCFN0WUW5.mp4","format":"video","image":null,"published_at":1452478801,"tag":"","user":{"avatar_updated_at":1421430650,"last_visited_at":1421430650,"created_at":1421430650,"state":"active","last_device":"ios_5.0.2","role":"n","login":"乌蒙山剿匪","id":24845114,"icon":"20150117015050.jpg"},"image_size":null,"id":114637390,"votes":{"down":-90,"up":1980},"created_at":1452437911,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/B4UND4ZDCFN0WUW5.jpg","content":"身残志坚马里奥4","state":"publish","comments_count":41,"low_url":"http://qiubai-video.qiushibaike.com/B4UND4ZDCFN0WUW5_3g.mp4","allow_comment":true,"share_count":367,"type":"hot","loop":115112},{"high_url":"http://qiubai-video.qiushibaike.com/NFNB2A8IZ8OLDSEF.mp4","format":"video","image":null,"published_at":1452487501,"tag":"","user":{"avatar_updated_at":1451900824,"last_visited_at":1451037244,"created_at":1451037244,"state":"active","last_device":"ios_8.4.6","role":"n","login":"咸盐哥","id":30844072,"icon":"20160104094703.jpg"},"image_size":null,"id":114641205,"votes":{"down":-65,"up":1992},"created_at":1452474543,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/NFNB2A8IZ8OLDSEF.jpg","content":"兄弟，你确定不是在扔炸弹吗？","state":"publish","comments_count":37,"low_url":"http://qiubai-video.qiushibaike.com/NFNB2A8IZ8OLDSEF_3g.mp4","allow_comment":true,"share_count":454,"type":"hot","loop":137669},{"high_url":"http://qiubai-video.qiushibaike.com/TISGYXDWS3EW6RHE.mp4","format":"video","image":null,"published_at":1452476402,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114637906,"votes":{"down":-36,"up":2150},"created_at":1452440010,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/TISGYXDWS3EW6RHE.jpg","content":"这平衡太强了～","state":"publish","comments_count":21,"low_url":"http://qiubai-video.qiushibaike.com/TISGYXDWS3EW6RHE_3g.mp4","allow_comment":true,"share_count":57,"type":"hot","loop":154170},{"high_url":"http://qiubai-video.qiushibaike.com/RFHILBMG46HCEBSV.mp4","format":"video","image":null,"published_at":1452487201,"tag":"","user":{"avatar_updated_at":1452461862,"last_visited_at":1452461862,"created_at":1452461862,"state":"active","last_device":"ios_9.0.1","role":"n","login":"西疯狂诗","id":30941679,"icon":"20160110213742.jpg"},"image_size":null,"id":114642876,"votes":{"down":-78,"up":2435},"created_at":1452482577,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/RFHILBMG46HCEBSV.jpg","content":"这是有多酸爽\\n吃了一粒\\n紧接着要一大口\\n","state":"publish","comments_count":72,"low_url":"http://qiubai-video.qiushibaike.com/RFHILBMG46HCEBSV_3g.mp4","allow_comment":true,"share_count":978,"type":"hot","loop":123435},{"high_url":"http://qiubai-video.qiushibaike.com/L7H6JAIM2GZZAKHA.mp4","format":"video","image":null,"published_at":1452477004,"tag":"","user":{"avatar_updated_at":1421430650,"last_visited_at":1421430650,"created_at":1421430650,"state":"active","last_device":"ios_5.0.2","role":"n","login":"乌蒙山剿匪","id":24845114,"icon":"20150117015050.jpg"},"image_size":null,"id":114637424,"votes":{"down":-68,"up":1430},"created_at":1452438017,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/L7H6JAIM2GZZAKHA.jpg","content":"身残志坚马里奥end","state":"publish","comments_count":24,"low_url":"http://qiubai-video.qiushibaike.com/L7H6JAIM2GZZAKHA_3g.mp4","allow_comment":true,"share_count":188,"type":"hot","loop":63947},{"high_url":"http://qiubai-video.qiushibaike.com/DP3JF7ZCEAZC2XQU.mp4","format":"video","image":null,"published_at":1452474002,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114638100,"votes":{"down":-45,"up":2489},"created_at":1452440739,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/DP3JF7ZCEAZC2XQU.jpg","content":"好奇心害死猫~","state":"publish","comments_count":44,"low_url":"http://qiubai-video.qiushibaike.com/DP3JF7ZCEAZC2XQU_3g.mp4","allow_comment":true,"share_count":192,"type":"hot","loop":133540},{"high_url":"http://qiubai-video.qiushibaike.com/MEQ911MQ9TG4VE7X.mp4","format":"video","image":null,"published_at":1452473401,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114637928,"votes":{"down":-45,"up":2074},"created_at":1452440097,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/MEQ911MQ9TG4VE7X.jpg","content":"这乌龟爪子太欠了～","state":"publish","comments_count":27,"low_url":"http://qiubai-video.qiushibaike.com/MEQ911MQ9TG4VE7X_3g.mp4","allow_comment":true,"share_count":146,"type":"hot","loop":173827},{"high_url":"http://qiubai-video.qiushibaike.com/28FC75R2Q6LDHD4G.mp4","format":"video","image":null,"published_at":1452475501,"tag":"","user":{"avatar_updated_at":1435349562,"last_visited_at":1431703034,"created_at":1431703034,"state":"active","last_device":"android_6.7.1","role":"n","login":"73kg纯胖","id":28438096,"icon":"20150626201241.jpg"},"image_size":null,"id":114635155,"votes":{"down":-95,"up":2719},"created_at":1452429372,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/28FC75R2Q6LDHD4G.jpg","content":"机智如你！","state":"publish","comments_count":27,"low_url":"http://qiubai-video.qiushibaike.com/28FC75R2Q6LDHD4G_3g.mp4","allow_comment":true,"share_count":310,"type":"hot","loop":187732},{"high_url":"http://qiubai-video.qiushibaike.com/G4JJRDGFV406RFIU.mp4","format":"video","image":null,"published_at":1452472801,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114637971,"votes":{"down":-69,"up":2058},"created_at":1452440264,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/G4JJRDGFV406RFIU.jpg","content":"您还收徒弟吗？","state":"publish","comments_count":33,"low_url":"http://qiubai-video.qiushibaike.com/G4JJRDGFV406RFIU_3g.mp4","allow_comment":true,"share_count":205,"type":"hot","loop":247459},{"high_url":"http://qiubai-video.qiushibaike.com/5ATYPUA22DNQ8MN7.mp4","format":"video","image":null,"published_at":1452493801,"tag":"","user":{"avatar_updated_at":1450787559,"last_visited_at":1420907347,"created_at":1420907347,"state":"bonded","last_device":"android_5.0.0","role":"n","login":".夜夜夜夜.","id":24674122,"icon":"20151222123238.jpg"},"image_size":null,"id":114638896,"votes":{"down":-9,"up":162},"created_at":1452444471,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/5ATYPUA22DNQ8MN7.jpg","content":"汪星人表示躺着也中枪","state":"publish","comments_count":3,"low_url":"http://qiubai-video.qiushibaike.com/5ATYPUA22DNQ8MN7_3g.mp4","allow_comment":true,"share_count":3,"type":"fresh","loop":17582},{"high_url":"http://qiubai-video.qiushibaike.com/3LDX89F2KKSQU3PI.mp4","format":"video","image":null,"published_at":1452470701,"tag":"","user":{"avatar_updated_at":1452461862,"last_visited_at":1452461862,"created_at":1452461862,"state":"active","last_device":"ios_9.0.1","role":"n","login":"西疯狂诗","id":30941679,"icon":"20160110213742.jpg"},"image_size":null,"id":114636186,"votes":{"down":-98,"up":2769},"created_at":1452433474,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/3LDX89F2KKSQU3PI.jpg","content":"笨头 船头跳水","state":"publish","comments_count":89,"low_url":"http://qiubai-video.qiushibaike.com/3LDX89F2KKSQU3PI_3g.mp4","allow_comment":true,"share_count":477,"type":"hot","loop":148455},{"high_url":"http://qiubai-video.qiushibaike.com/USQGQU2A0U06EZ6H.mp4","format":"video","image":null,"published_at":1452471002,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114638058,"votes":{"down":-40,"up":1747},"created_at":1452440584,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/USQGQU2A0U06EZ6H.jpg","content":"风大是一种什么体验，你们感受一下...","state":"publish","comments_count":28,"low_url":"http://qiubai-video.qiushibaike.com/USQGQU2A0U06EZ6H_3g.mp4","allow_comment":true,"share_count":98,"type":"hot","loop":230561},{"high_url":"http://qiubai-video.qiushibaike.com/N1A5EKR0G32TLU71.mp4","format":"video","image":null,"published_at":1452477602,"tag":"","user":{"avatar_updated_at":1452198192,"last_visited_at":1452198192,"created_at":1452198192,"state":"active","last_device":"android_9.0.2","role":"n","login":"抖胸行不行","id":30922934,"icon":"20160107202312.jpg"},"image_size":null,"id":114635419,"votes":{"down":-49,"up":982},"created_at":1452430349,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/N1A5EKR0G32TLU71.jpg","content":"顶一个吧！","state":"publish","comments_count":12,"low_url":"http://qiubai-video.qiushibaike.com/N1A5EKR0G32TLU71_3g.mp4","allow_comment":true,"share_count":61,"loop":84075},{"high_url":"http://qiubai-video.qiushibaike.com/51EF9J74WGY3Q3GL.mp4","format":"video","image":null,"published_at":1452471601,"tag":"","user":{"avatar_updated_at":1448913347,"last_visited_at":1440837331,"created_at":1440837331,"state":"active","last_device":"android_8.0.2","role":"n","login":"九七五","id":30189531,"icon":"20151130195547.jpg"},"image_size":null,"id":114634206,"votes":{"down":-66,"up":1812},"created_at":1452425194,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/51EF9J74WGY3Q3GL.jpg","content":"第一回知道萝卜是这样拔","state":"publish","comments_count":32,"low_url":"http://qiubai-video.qiushibaike.com/51EF9J74WGY3Q3GL_3g.mp4","allow_comment":true,"share_count":182,"type":"hot","loop":125684},{"high_url":"http://qiubai-video.qiushibaike.com/76SGTSMN84L8SVZD.mp4","format":"video","image":null,"published_at":1452486001,"tag":"","user":{"avatar_updated_at":1434990143,"last_visited_at":1435018943,"created_at":1435018943,"state":"active","last_device":"ios_6.8.4","role":"n","login":"走火的马赛克","id":29087238,"icon":"20150623002223.jpg"},"image_size":null,"id":114638679,"votes":{"down":-29,"up":472},"created_at":1452443403,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/76SGTSMN84L8SVZD.jpg","content":"晒个地瓜丝老妈真是下血本啊。","state":"publish","comments_count":19,"low_url":"http://qiubai-video.qiushibaike.com/76SGTSMN84L8SVZD_3g.mp4","allow_comment":true,"share_count":3,"loop":46122},{"high_url":"http://qiubai-video.qiushibaike.com/4MLDDCTSJ7E6PFTB.mp4","format":"video","image":null,"published_at":1452476701,"tag":"","user":{"avatar_updated_at":1450206437,"last_visited_at":1450206436,"created_at":1450206436,"state":"active","last_device":"android_8.4.0","role":"n","login":"批午夜A~V","id":30790108,"icon":"20151215190716.jpg"},"image_size":null,"id":114636303,"votes":{"down":-82,"up":951},"created_at":1452433877,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/4MLDDCTSJ7E6PFTB.jpg","content":"标准五个字","state":"publish","comments_count":16,"low_url":"http://qiubai-video.qiushibaike.com/4MLDDCTSJ7E6PFTB_3g.mp4","allow_comment":true,"share_count":167,"loop":118491},{"high_url":"http://qiubai-video.qiushibaike.com/X251QUL53AC4G72D.mp4","format":"video","image":null,"published_at":1452476102,"tag":"","user":{"avatar_updated_at":1450456539,"last_visited_at":1447948157,"created_at":1447948157,"state":"active","last_device":"android_8.2.1","role":"n","login":"内涵18姐","id":30646067,"icon":"20151218163539.jpg"},"image_size":null,"id":114638093,"votes":{"down":-24,"up":869},"created_at":1452440712,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/X251QUL53AC4G72D.jpg","content":"不击则已，一击必杀～","state":"publish","comments_count":9,"low_url":"http://qiubai-video.qiushibaike.com/X251QUL53AC4G72D_3g.mp4","allow_comment":true,"share_count":13,"loop":120157}]
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
     * high_url : http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM.mp4
     * format : video
     * image : null
     * published_at : 1452473101
     * tag :
     * user : {"avatar_updated_at":1394678596,"last_visited_at":1380072973,"created_at":1380072973,"state":"active","last_device":"android_2.6","role":"n","login":"永and恒","id":11413184,"icon":"20140313104316.jpg"}
     * image_size : null
     * id : 114635185
     * votes : {"down":-143,"up":4888}
     * created_at : 1452429465
     * pic_size : [480,480]
     * pic_url : http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM.jpg
     * content : 可惜只有十秒
     * state : publish
     * comments_count : 125
     * low_url : http://qiubai-video.qiushibaike.com/ES4G2LL53ZP7THEM_3g.mp4
     * allow_comment : true
     * share_count : 2980
     * type : hot
     * loop : 208946
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

    public static class ItemsEntity implements Serializable{
        private String high_url;
        private String format;
        private Object image;
        private int published_at;
        private String tag;
        /**
         * avatar_updated_at : 1394678596
         * last_visited_at : 1380072973
         * created_at : 1380072973
         * state : active
         * last_device : android_2.6
         * role : n
         * login : 永and恒
         * id : 11413184
         * icon : 20140313104316.jpg
         */

        private UserEntity user;
        private Object image_size;
        private int id;
        /**
         * down : -143
         * up : 4888
         */

        private VotesEntity votes;
        private int created_at;
        private String pic_url;
        private String content;
        private String state;
        private int comments_count;
        private String low_url;
        private boolean allow_comment;
        private int share_count;
        private String type;
        private int loop;
        private List<Integer> pic_size;

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
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

        public void setImage_size(Object image_size) {
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

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
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

        public void setLow_url(String low_url) {
            this.low_url = low_url;
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

        public void setLoop(int loop) {
            this.loop = loop;
        }

        public void setPic_size(List<Integer> pic_size) {
            this.pic_size = pic_size;
        }

        public String getHigh_url() {
            return high_url;
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

        public Object getImage_size() {
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

        public String getPic_url() {
            return pic_url;
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

        public String getLow_url() {
            return low_url;
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

        public int getLoop() {
            return loop;
        }

        public List<Integer> getPic_size() {
            return pic_size;
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
