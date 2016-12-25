package cn.bdqn.oa.domain;

/*
 * 回复
 */
public class Reply extends Article {
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
