package io.yaoling.starter.weixin.mp.input;

public class QRTicketInput {

	public static final String ACTION_NAME_QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
	public static final String ACTION_NAME_QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
	public static final String ACTION_NAME_QR_SCENE = "QR_SCENE";
	static public class Scene {
		private Integer scene_id;
		private String scene_str;
		public Integer getScene_id() {
			return scene_id;
		}
		public void setScene_id(Integer scene_id) {
			this.scene_id = scene_id;
		}
		public String getScene_str() {
			return scene_str;
		}
		public void setScene_str(String scene_str) {
			this.scene_str = scene_str;
		}
	}
	static public class Info {
		private Scene scene = new Scene();

		public Scene getScene() {
			return scene;
		}

		public void setScene(Scene scene) {
			this.scene = scene;
		}
	}
	/**
	 * 有效期，仅在临时二维码使用。
	 * 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。 
	 */
	private Integer expire_seconds; 
	private String action_name = ACTION_NAME_QR_LIMIT_SCENE;
	private Info action_info = new Info();
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public Info getAction_info() {
		return action_info;
	}
	public void setAction_info(Info action_info) {
		this.action_info = action_info;
	}
	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
}
