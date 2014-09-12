/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.madmatrix.zxing.android;

import android.app.Activity;
import android.os.Bundle;

/**
 * The main settings activity.
 * 
 * <br/>
 * 该类对应界面上的设置界面，基本上每一项在设置中都能找到对应的配置项
 * 
 * @author dswitkin@google.com (Daniel Switkin)
 * @author Sean Owen
 */
public final class PreferencesActivity extends Activity {

	public static final String KEY_DECODE_1D = "preferences_decode_1D";
	public static final String KEY_DECODE_QR = "preferences_decode_QR";
	public static final String KEY_DECODE_DATA_MATRIX = "preferences_decode_Data_Matrix";
	
	/**
	 * 自定义搜索网址
	 */
	public static final String KEY_CUSTOM_PRODUCT_SEARCH = "preferences_custom_product_search";

	/**
	 * 扫描成功时播放提示音
	 */
	public static final String KEY_PLAY_BEEP = "preferences_play_beep";
	
	/**
	 * 扫描成功时震动
	 */
	public static final String KEY_VIBRATE = "preferences_vibrate";
	
	/**
	 * 复制到剪贴板
	 */
	public static final String KEY_COPY_TO_CLIPBOARD = "preferences_copy_to_clipboard";
	
	/**
	 * 虽然这里是front_light，但实际是手机背面的闪光灯
	 */
	public static final String KEY_FRONT_LIGHT_MODE = "preferences_front_light_mode";
	
	/**
	 * 连续扫描并保存多个条形码
	 */
	public static final String KEY_BULK_MODE = "preferences_bulk_mode";
	
	/**
	 * 允许在历史记录中保存重复记录
	 */
	public static final String KEY_REMEMBER_DUPLICATES = "preferences_remember_duplicates";
	
	/**
	 * 尝试检索关于条码内容的更多信息
	 */
	public static final String KEY_SUPPLEMENTAL = "preferences_supplemental";

	/**
	 * 使用自动对焦
	 */
	public static final String KEY_AUTO_FOCUS = "preferences_auto_focus";
	
	/**
	 * 反向扫描：针对黑色背景上的白色条形码，但不一定有效，具体参考CameraConfigurationManager.setDesiredCameraParameters
	 */
	public static final String KEY_INVERT_SCAN = "preferences_invert_scan";
	
	/**
	 * 搜索国家
	 */
	public static final String KEY_SEARCH_COUNTRY = "preferences_search_country";

	/**
	 * 没有持续关注（只使用标准对焦模式）,具体参考CameraConfigurationManager.setDesiredCameraParameters()方法中对应逻辑
	 */
	public static final String KEY_DISABLE_CONTINUOUS_FOCUS = "preferences_disable_continuous_focus";

	// public static final String KEY_DISABLE_EXPOSURE =
	// "preferences_disable_exposure";

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferencesFragment()).commit();
	}

}
