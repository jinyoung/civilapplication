<template>

    <v-card outlined>
        <v-card-title>
            SubmitApplication
        </v-card-title>

        <v-card-text>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
            <String label="MinwonType" v-model="value.minwonType" :editMode="editMode"/>
            <String label="ApplicationReason" v-model="value.applicationReason" :editMode="editMode"/>
            <FileAttachmentList offline label="AttachFiles" v-model="value.attachFiles" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="submitApplication"
            >
                SubmitApplication
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
    name: 'SubmitApplicationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.applicantId = '';
        this.value.minwonType = '';
        this.value.applicationReason = '';
        this.value.attachFiles = [];
    },
    watch: {
    },
    methods: {
        submitApplication() {
            this.$emit('submitApplication', this.value);
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

