#Android直播方案#

##直播流程##
- 采集 
	![](https://upload-images.jianshu.io/upload_images/13719045-5152bf5862e51c20.png?imageMogr2/auto-orient/strip|imageView2/2/w/300/format/webp)
> [采集方案1](https://www.jianshu.com/p/e40259351f54)
> 
> [camera2](https://www.sohu.com/a/312890487_120122487?spm=smpc.author.fd-d-347561.163.1589164728285NTj0l5R)

> surfaceView implements Camera.PreviewCallback 采集摄像头数据
> 
	     public Camerapreview(Context context) {
			             ...
		     	  		mCamera.setPreviewCallback(this);
	                 	mCamera.setPreviewDisplay(holder);
	                    mCamera.startPreview();//显示预览
						...
			       }
		>
		 @Override
		        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
						...
		 				 mCamera.setPreviewCallback(this);
		                mCamera.setPreviewDisplay(holder); // 再次预览
		                mCamera.stopPreview();
						...
		}

 > [声音采集](https://www.jianshu.com/p/2cb75a71009f/)
 >
	private void initAudioRecord(RecordCallback callback) {
	        int audioSource = MediaRecorder.AudioSource.MIC;
	//        if(audioConfiguration.aec) {
	//            audioSource = MediaRecorder.AudioSource.VOICE_COMMUNICATION;
	//        }
	        audioRecord = new AudioRecord(audioSource, sampleRateInHz,
	                channelConfig, audioFormat, getValidSampleRates());
	        recordThread = new Thread(() -> {
	            byte[] buffer = new byte[getValidSampleRates()];
	            audioRecord.startRecording();
	            recording = true;
	            while (recording) {
	                int read = audioRecord.read(buffer, 0, getValidSampleRates());
	                // 将数据回调到外部
	                if (read > 0 && callback != null) {
	                    callback.onRecord(buffer, read);
	                }
	            }
	            if (callback != null) {
	                // len 为-1时表示结束
	                callback.onRecord(buffer, -1);
	                recording = false;
	            }
	            //释放资源
	            release();
	        });
	        recordThread.start();
	    }


- 处理
>###音视频相关处理类###
>
> MediaMetadataRetriever:：用来获取视频的相关信息，例如视频宽高、时长、旋转角度、码率等等。
MediaExtractor:：视音频分离器，将一些格式的视频分离出视频轨道和音频轨道。
MediaCodec：视音频相应的编解码类。
MediaMuxer：视音频合成器，将视频和音频合成相应的格式。
MediaFormat：视音频相应的格式信息。
MediaCodec.BufferInfo：存放ByteBuffer相应信息的类。
MediaCrypto：视音频加密解密处理的类。
MediaCodecInfo：视音频编解码相关信息的类。

- 编码和封装

> [编码音频文件](https://www.jianshu.com/p/0d0497340d7d)

> [视频通过MediaCodec编码封装](https://www.jianshu.com/p/e607e63fb78f)
> 
- 推流到服务器
- 服务器流分发
- 播放器流播放

    ijkPlayer
##目前几种视频流的简单对比##

| ----| ------| :------: |
| 协议  | httpflv | rtmp | hls | dash
| 传输方式 | http流 | tcp流 | http | http
| 视频封装格式 | flv | flv tag | Ts文件 | Mp4 3gp webm
| 延时 | 低 | 低 | 高 | 高
| 数据分段 | 连续流 | 连续流 | 切片文件 | 切片文件
| Html5播放 | 可通过html5解封包播放(flv.js) | 不支持 | 可通过html5解封包播放(hls.js) | 如果dash文件列表是mp4webm文件，可直接播放



##FFmpeg for Android##
###FFmpeg一共包含8个库：###
1. avcodec：编解码（最重要的库）
2. avformat：封装格式处理
3. avfiler：滤镜特效处理
4. avdevice：各种设备的输入输出
5. avutil：工具库（大部分库都需要这个库的支持）
6. postpro：后加工
7. swresaple：音频采样数据格式转换
8. swscale：视频像素格式转换
###FFmpeg解码函数简介###
[FFmpeg for Android](https://www.jianshu.com/p/a0ee3009f5ad)
