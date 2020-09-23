# 学习文档
	linux 去掉文档空格：
		cat list |sed '/^$/d'
	远程同步文件： 
	 rsync -avzP /root/data/*.json root@33.82.4.13:/root/lcc/info
	 
## Execl函数使用
	判断一列中的某一个知否在另一列存在 
		IF(ISNUMBER(MATCH(C1,I:I,0)),"Y","N")
		MATCH(C1,J:J,0) 查找c1在J列中的第几行，返回行数
		ISNUMBER（123）判断是否是数字返回true:false
		IF(true,"Y","N")
	隐藏中间字符
		SUMIF(A1:A4,"*s*",B:B)求A1-A4包含s的B列求和
		LEFT(B2,3)&"****"&RIGHT(B2,4) 加密中间字符
		=REPLACE(B2,4,4,"****") 加密中间字符
## shell
```
	linux 去掉文档空格：
		cat list |sed '/^$/d'
	远程同步文件： 
	 rsync -avzP /root/data/*.json root@33.82.4.13:/root/lcc/info
	查看root下面的文件
	 pssh -h host -i "ll /root/ "
	将本地lcc目录拷贝到远程机器admin下面
	 pscp -h host -r /root/lcc /root/admin		
```
	
## mysql使用问题
```
去除mysql存储空格 回车等问题 
		update vsl_dev_encoder_chn_ext SET GB_CODE=REPLACE(REPLACE(GB_CODE,CHAR(10),''),CHAR(13),'') WHERE GB_CODE like '33010900001323501020%' or 
获取几分钟以前的时间
		SUBDATE( now(), INTERVAL 10 MINUTE ) 	
		now()现在的时间
case when 使用
	SELECT
	CASE
		WHEN
			SUBSTRING_INDEX( aa.cameraId, "_", 1 ) = 'ipc' THEN '结构化' 
		WHEN 
			SUBSTRING_INDEX( aa.cameraId, "_", 1 ) = 'gqqj' THEN '事件检测'  
		END AS 'type',
		bb.outFlow / 1024 / 1024 AS '点位流量（M/s)' 

```
	
## java
```
匹配器用法：
	Matcher matcher=Pattern.compile("东|南|西|北").matcher(str);
	if (matcher.find()){
            System.out.println(matcher.start() + "《 === 》" +matcher.group());
            System.out.println(str.substring(0,matcher.start()));
        }
		
自定义注解
	使用spring aop 前置通知||后置通知
	
BigDecimal 用法：	
	 public BigDecimal add(BigDecimal augend)
     加法
     
     public BigDecimal subtract(BigDecimal subtrahend)
      减法
     
     public BigDecimal multiply(BigDecimal multiplicand)
      乘法
     
     public BigDecimal divide(BigDecimal divisor)
      除法
      
 MD5 转换器
 	public static String stringMD5(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input argument can't be null");
        }

        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            byte[] inputByteArray = input.getBytes();

            messageDigest.update(inputByteArray);

            // 字符数组转换成字符串返回
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static SimpleDateFormat dayFdf = new SimpleDateFormat("dd");
    public static SimpleDateFormat hourSDF = new SimpleDateFormat("HH");
    public static SimpleDateFormat hourTime = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
    public static SimpleDateFormat fdf = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat czdf = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
    
		
```
	

	
	
	
	
	
	
	
	
	