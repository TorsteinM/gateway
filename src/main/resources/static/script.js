
PetiteVue.createApp({
    topic: '',
    payload: '',
    subscribed: '',
    published: false,
    error: '',
    async subscribe() {
        if (!this.topic) {
            this.error = 'Please enter a topic';
            return;
        }

        try {
            const response = await fetch(`/mqtt/subscribe?topic=${encodeURIComponent(this.topic)}`);
            if (response.ok) {
                this.subscribed = this.topic;
                this.error = '';
            } else {
                this.error = 'Error subscribing to topic: ' + (await response.text());
                this.subscribed = '';
            }
        } catch (err) {
            this.error = 'Error subscribing to topic: ' + err.message;
            this.subscribed = '';
        }
    },
    async publish() {
        if (!this.topic || !this.payload) {
            this.error = 'Please enter a topic and payload';
            return;
        }

        try {
            const response = await fetch(`/mqtt/publish?topic=${encodeURIComponent(this.topic)}&payload=${encodeURIComponent(this.payload)}`);
            if (response.ok) {
                this.published = true;
                this.error = '';
            } else {
                this.error = 'Error publishing message: ' + (await response.text());
                this.published = false;
            }
        } catch (err) {
            this.error = 'Error publishing message: ' + err.message;
            this.published = false;
        }
    }

}).mount();