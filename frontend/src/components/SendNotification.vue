<template>

    <v-card outlined>
        <v-card-title>
            SendNotification
        </v-card-title>

        <v-card-text>
            <ApplicationId offline label="ApplicationId" v-model="value.applicationId" :editMode="editMode" @change="change"/>
            <String label="ApplicationNumber" v-model="value.applicationNumber" :editMode="editMode"/>
            <String label="Recipient" v-model="value.recipient" :editMode="editMode"/>
            <String label="NotificationMethod" v-model="value.notificationMethod" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="sendNotification"
            >
                SendNotification
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'SendNotificationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.applicationId = {};
        this.value.applicationNumber = '';
        this.value.recipient = '';
        this.value.notificationMethod = '';
    },
    watch: {
    },
    methods: {
        sendNotification() {
            this.$emit('sendNotification', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

